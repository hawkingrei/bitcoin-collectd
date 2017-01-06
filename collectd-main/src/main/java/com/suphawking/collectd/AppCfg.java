package com.suphawking.collectd;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

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
  private DataSourceFactory collectorDbFactory = new DataSourceFactory();

}
