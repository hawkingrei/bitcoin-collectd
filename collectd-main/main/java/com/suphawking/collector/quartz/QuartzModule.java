package com.suphawking.collector.quartz;

import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.suphawking.collector.AppCfg;
import com.suphawking.collector.CollectdModule;

import io.dropwizard.setup.Environment;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by loveknut on 2016/11/1.
 */
public class QuartzModule extends CollectdModule {

  public QuartzModule(AppCfg cfg, Environment env) {
    super(cfg, env);
  }

  @Override
  protected void configure() {
    bind(ManagedScheduler.class);
    bind(GuiceJobFactory.class).in(Singleton.class);
  }

  @Provides
  @Singleton
  Scheduler provideScheduler() throws SchedulerException {
    return StdSchedulerFactory.getDefaultScheduler();
  }
}
