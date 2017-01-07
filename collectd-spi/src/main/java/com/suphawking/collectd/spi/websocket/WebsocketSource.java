package com.suphawking.collectd.spi.websocket;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by loveknut on 2017/1/7.
 */
@Data
public class WebsocketSource {
  @NotNull
  private String name;
  @NotNull
  private String url;
}
