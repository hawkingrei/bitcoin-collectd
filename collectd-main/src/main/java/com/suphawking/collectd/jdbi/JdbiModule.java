package com.suphawking.collectd.jdbi;

import com.google.common.base.Preconditions;
import com.google.inject.Singleton;
import com.suphawking.collectd.AppCfg;
import com.suphawking.collectd.CollectdModule;
import com.suphawking.collectd.okcoin.dao.SaveOkcoinTrendData;
import com.suphawking.collectd.okcoin.repo.OkcoinTrendDataRepo;

import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;

import lombok.Singular;
import lombok.extern.slf4j.Slf4j;

import org.skife.jdbi.v2.DBI;

/**
 * Created by loveknut on 2016/11/1.
 */
@Slf4j
public class JdbiModule extends CollectdModule {
  private SaveOkcoinTrendData saveOkcoinTrendData;
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
    this.saveOkcoinTrendData = jdbiCollector.onDemand(SaveOkcoinTrendData.class);

  }

  @Override
  protected void configure() {
    bind(SaveOkcoinTrendData.class).toInstance(this.saveOkcoinTrendData);
    bind(OkcoinTrendDataRepo.class).in(Singleton.class);
  }
}
