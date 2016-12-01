package com.suphawking.collector.jdbi;

import com.google.common.base.Preconditions;
import com.suphawking.collector.AppCfg;
import com.suphawking.collector.CollectdModule;

import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;

import lombok.extern.slf4j.Slf4j;

import org.skife.jdbi.v2.DBI;

/**
 * Created by loveknut on 2016/11/1.
 */
@Slf4j
public class JdbiModule extends CollectdModule {
  public JdbiModule(AppCfg cfg, Environment env) {
    super(cfg, env);
    initJdbi();
  }

  private void initJdbi() {
    log.info("init jdbi");
    Preconditions.checkNotNull(cfg);
    Preconditions.checkNotNull(env);
    final DBIFactory factory = new DBIFactory();
    final DBI jdbiCollector = factory.build(env, cfg.getCollectorDbFactory(), "collector-db");
  }

  @Override
  protected void configure() {

  }


}
