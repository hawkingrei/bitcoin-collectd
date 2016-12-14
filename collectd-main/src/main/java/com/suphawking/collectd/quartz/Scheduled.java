package com.suphawking.collectd.quartz;

/**
 * Created by loveknut on 2016/11/1.
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Scheduled {
  String cron() default "";

  int interval() default -1;

  int delayInMillis() default 0;

  TimeUnit unit() default TimeUnit.SECONDS;
}
