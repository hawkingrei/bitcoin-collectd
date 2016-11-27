package com.suphawking.collector;


import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.suphawking.collector.health.JettyClientHealthCheck;
import com.suphawking.collector.jdbi.JdbiModule;
import com.suphawking.collector.quartz.QuartzModule;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.jersey.errors.EarlyEofExceptionMapper;
import io.dropwizard.jersey.errors.LoggingExceptionMapper;
import io.dropwizard.jersey.jackson.JsonProcessingExceptionMapper;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;

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
    bootstrap.getObjectMapper()
        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        .setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    bootstrap.addBundle(new ViewBundle());
    bootstrap.addBundle(new AssetsBundle("/assets", "/assets"));
  }

  @Override
  public void run(AppCfg cfg, Environment env) throws Exception {
    Injector injector = Guice.createInjector(
          new RootModule(cfg, env),
          new QuartzModule(cfg, env),
          new JdbiModule(cfg, env)
        );

    env.jersey().register(new LoggingExceptionMapper<Throwable>() {
    });
    env.jersey().register(new JsonProcessingExceptionMapper());
    env.jersey().register(new EarlyEofExceptionMapper());
    env.healthChecks().register("jetty-client", injector.getInstance(JettyClientHealthCheck.class));
  }

}

