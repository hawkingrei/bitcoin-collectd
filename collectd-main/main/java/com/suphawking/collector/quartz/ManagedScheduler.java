package com.suphawking.collector.quartz;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.suphawking.collector.quartz.job.CollectJob;

import io.dropwizard.lifecycle.Managed;

import lombok.extern.slf4j.Slf4j;

import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * Created by loveknut on 2016/11/1.
 */
@Slf4j
public class ManagedScheduler implements Managed {

  private final Scheduler scheduler;
  private final Injector injector;
  private final GuiceJobFactory guiceJobFactory;

  @Inject
  public ManagedScheduler(Scheduler scheduler, Injector injector, GuiceJobFactory guiceJobFactory) {
    this.scheduler = scheduler;
    this.injector = injector;
    this.guiceJobFactory = guiceJobFactory;
  }

  public void start() throws Exception {
    scheduler.setJobFactory(guiceJobFactory);
    scheduler.start();
    scheduleJob(injector.getInstance(CollectJob.class));
  }

  void scheduleJob(Job job) throws SchedulerException {
    Scheduled scheduleAnn = job.getClass().getAnnotation(Scheduled.class);
    if (scheduleAnn != null) {
      JobDetail jobDetail = JobBuilder.newJob(job.getClass()).build();
      Trigger trigger = buildTrigger(scheduleAnn);
      log.debug("Scheduled job {} with trigger {}", job, trigger);
      scheduler.scheduleJob(jobDetail, trigger);
    }
  }

  public Trigger buildTrigger(Scheduled ann) {
    TriggerBuilder<Trigger> trigger = TriggerBuilder.newTrigger();

    if (ann.cron() != null && ann.cron().trim().length() > 0) {
      trigger.withSchedule(CronScheduleBuilder.cronSchedule(ann.cron())
          .inTimeZone(TimeZone.getDefault()));
    } else if (ann.interval() != -1) {
      trigger.withSchedule(SimpleScheduleBuilder.simpleSchedule()
          .withIntervalInMilliseconds(
                TimeUnit.MILLISECONDS.convert(ann.interval(), ann.unit()))
          .withMisfireHandlingInstructionIgnoreMisfires()
          .repeatForever())
          .startAt(new Date(System.currentTimeMillis() + ann.delayInMillis()));
    } else {
      throw new IllegalArgumentException(
          "One of 'cron', 'interval' is required for the @Scheduled annotation");
    }

    return trigger.build();
  }

  public void stop() throws Exception {
    scheduler.shutdown();
  }

}

