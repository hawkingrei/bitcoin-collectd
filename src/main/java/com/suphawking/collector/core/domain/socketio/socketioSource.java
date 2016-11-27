package com.suphawking.collector.core.domain.socketio;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by loveknut on 2016/11/27.
 */
@Data
public class socketioSource {
  @NotNull
  private String name;
  @NotNull
  private String url;
}
