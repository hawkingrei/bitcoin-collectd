package com.suphawking.collectd.quartz.job;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.suphawking.collectd.quartz.Scheduled;

import lombok.extern.slf4j.Slf4j;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.concurrent.TimeUnit;

/**
 * Created by loveknut on 2016/11/1.
 */
@Scheduled(interval = 1, unit = TimeUnit.SECONDS)
@Slf4j
@SuppressWarnings("unchecked")
public class CollectJob implements Job {

  private final Injector injector;


  @Inject
  public CollectJob( Injector injector) {
    this.injector = injector;
  }


  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    log.info("done");
  }



}
