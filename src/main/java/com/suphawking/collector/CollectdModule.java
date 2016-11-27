package com.suphawking.collector;

import com.google.inject.AbstractModule;

import io.dropwizard.setup.Environment;

/**
 * Created by loveknut on 2016/10/31.
 */
public abstract class CollectdModule extends AbstractModule {
  protected final AppCfg cfg;
  protected final Environment env;

  public CollectdModule(AppCfg cfg, Environment env) {
    this.cfg = cfg;
    this.env = env;
  }
}
