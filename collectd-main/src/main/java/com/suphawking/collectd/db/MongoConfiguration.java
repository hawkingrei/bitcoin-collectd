package com.suphawking.collectd.db;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by loveknut on 2017/2/19.
 */
public class MongoConfiguration {
  @NotNull
  public String host;

  @Min(1)
  @Max(65535)
  public int port;

  @NotNull
  public String db;

  @NotNull
  public String user;

  @NotNull
  public String password;
}
