package com.suphawking.collectd.application.managed;

/**
 * Created by loveknut on 2016/11/3.
 */
@FunctionalInterface
public interface Func {
  void apply() throws Exception;
}
