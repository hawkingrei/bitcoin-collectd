package com.suphawking.collectd;


import com.google.inject.Guice;
import com.google.inject.Injector;
import com.suphawking.btcc.BtccClient;
import com.suphawking.btcc.MessageHandlerFactory;
import com.suphawking.collectd.application.managed.FManaged;
import com.suphawking.collectd.health.JettyClientHealthCheck;
import com.suphawking.collectd.okcoin.client.OkcoinClient;
import com.suphawking.collectd.quartz.QuartzModule;
import com.suphawking.collectd.spi.websocket.WebsocketSource;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.jersey.errors.EarlyEofExceptionMapper;
import io.dropwizard.jersey.errors.LoggingExceptionMapper;
import io.dropwizard.jersey.jackson.JsonProcessingExceptionMapper;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by loveknut on 2016/10/31.
 */

@Slf4j
@SuppressWarnings("unchecked")
public class App extends Application<AppCfg> {
  public static void main(String[] args) throws Exception {
    java.security.Security.setProperty("networkaddress.cache.ttl", "10");
    java.security.Security.setProperty("networkaddress.cache.negative.ttl", "10");
    new App().run(args);
  }

  @Override
  public String getName() {
    return "collector";
  }

  @Override
  public void initialize(Bootstrap<AppCfg> bootstrap) {
    bootstrap.addBundle(new ViewBundle());
    bootstrap.addBundle(new AssetsBundle("/assets", "/assets"));
  }

  @Override
  public void run(AppCfg cfg, Environment env) throws Exception {
    Injector injector = Guice.createInjector(
        new RootModule(cfg, env),
        new QuartzModule(cfg, env)
    );
    MongoManaged mongoManaged = new MongoManaged(cfg.mongo);
    env.lifecycle().manage(mongoManaged);
    env.jersey().register(new LoggingExceptionMapper<Throwable>() {
    });
    env.jersey().register(new JsonProcessingExceptionMapper());
    env.jersey().register(new EarlyEofExceptionMapper());
    env.healthChecks().register("jetty-client", injector.getInstance(JettyClientHealthCheck.class));
    WebsocketSource okcoinclientsource = new WebsocketSource();
    okcoinclientsource.setName("okcoin");
    okcoinclientsource.setUrl("wss://real.okcoin.cn:10440/websocket/okcoinapi");

    OkcoinClient okclient = new OkcoinClient(okcoinclientsource);
    env.lifecycle().manage(new FManaged(okclient::start, okclient::stop));


    WebsocketSource btccClientsource = new WebsocketSource();
    btccClientsource.setName("btcc");
    btccClientsource.setUrl("https://websocket.btcchina.com");

    MessageHandlerFactory messageHandlerFactory = new MessageHandlerFactory();
    BtccClient btcc = new BtccClient(messageHandlerFactory, btccClientsource);
    env.lifecycle().manage(new FManaged(btcc::start, btcc::stop));

  }

}

