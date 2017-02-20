package com.suphawking.collectd;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.inject.Provides;
import com.google.inject.Singleton;

import io.dropwizard.setup.Environment;

import java.text.SimpleDateFormat;

/**
 * Created by loveknut on 2016/11/18.
 */
public class RootModule extends CollectdModule {
  public RootModule(AppCfg cfg, Environment env) {
    super(cfg, env);
  }

  @Override
  protected void configure() {
    bind(AppCfg.class).toInstance(cfg);
    bind(Environment.class).toInstance(env);

    //bind(HttpClient.class).toInstance(cfg.getJettyClientFactory().build(env));
  }

  @Provides
  @Singleton
  ObjectMapper provideObjectMapper() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        .setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    return objectMapper;
  }
}
