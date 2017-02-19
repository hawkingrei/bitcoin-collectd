package com.suphawking.collectd.health;

import com.codahale.metrics.health.HealthCheck;
import com.suphawking.collectd.MongoManaged;

/**
 * Created by loveknut on 2017/2/19.
 */
public class MongoHealthCheck extends HealthCheck {
  private MongoManaged mongo;

  public MongoHealthCheck(MongoManaged mongoManaged) {
    this.mongo = mongoManaged;
  }

  @Override
  protected Result check() throws Exception {
    mongo.getDb();
    return Result.healthy();
  }

}
