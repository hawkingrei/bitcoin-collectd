package com.suphawking.collectd;

import io.dropwizard.setup.Environment;

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


}
