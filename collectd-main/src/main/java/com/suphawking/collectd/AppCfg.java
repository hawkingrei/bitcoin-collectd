package com.suphawking.collectd;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.suphawking.collectd.db.MongoConfiguration;

import io.dropwizard.Configuration;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by loveknut on 2016/10/31.
 */
@Data
public class AppCfg extends Configuration {

  @Valid
  @NotNull
  @JsonProperty("collectorDb")
  public MongoConfiguration mongo = new MongoConfiguration();

}
