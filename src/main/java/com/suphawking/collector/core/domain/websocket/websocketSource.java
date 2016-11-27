package com.suphawking.collector.core.domain.websocket;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by loveknut on 2016/11/15.
 */
@Data
public class websocketSource {
  @NotNull
  private String name;
  @NotNull
  private String url;
}
