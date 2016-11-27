package com.suphawking.collector.application.managed;

import io.dropwizard.lifecycle.Managed;

/**
 * Created by loveknut on 2016/11/3.
 */

public class FManaged implements Managed {
  public final Func startFunc;
  public final Func stopFunc;

  public FManaged(Func startFunc, Func stopFunc) {
    this.startFunc = startFunc;
    this.stopFunc = stopFunc;
  }

  @Override
  public void start() throws Exception {
    startFunc.apply();
  }

  @Override
  public void stop() throws Exception {
    stopFunc.apply();
  }
}
