package com.suphawking.collectd.quartz;

/**
 * Created by loveknut on 2016/11/1.
 */

import com.google.inject.Inject;
import com.google.inject.Injector;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.spi.JobFactory;
import org.quartz.spi.TriggerFiredBundle;

public class GuiceJobFactory implements JobFactory {

  private Injector injector;

  @Inject
  public GuiceJobFactory(Injector injector) {
    this.injector = injector;
  }

  public Job newJob(TriggerFiredBundle bundle, Scheduler scheduler)
      throws SchedulerException {

    JobDetail jobDetail = bundle.getJobDetail();
    Class<? extends Job> jobClass = jobDetail.getJobClass();
    return injector.getInstance(jobClass);
  }

}
