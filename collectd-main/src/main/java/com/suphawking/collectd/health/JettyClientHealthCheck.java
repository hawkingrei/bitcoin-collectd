package com.suphawking.collectd.health;

/**
 * Created by loveknut on 2016/11/1.
 */

import com.codahale.metrics.health.HealthCheck;
import com.google.inject.Inject;

import org.eclipse.jetty.client.HttpClient;

public class JettyClientHealthCheck extends HealthCheck {
  private final HttpClient httpClient;

  @Inject
  public JettyClientHealthCheck(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  @Override
  protected Result check() throws Exception {
    if (httpClient.isStarted()) {
      return Result.healthy();
    } else {
      return Result.unhealthy("stopped");
    }
  }
}
