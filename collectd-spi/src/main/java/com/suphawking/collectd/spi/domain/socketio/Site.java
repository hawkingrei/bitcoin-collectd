package com.suphawking.collectd.spi.domain.socketio;

import com.alibaba.fastjson.annotation.JSONCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by loveknut on 2016/11/27.
 */
public enum Site {
  HUOBI("HUOBI"),
  UNKNOWN("UNKOWN");

  public final String value;

  Site(String value) {
    this.value = value;
  }

  @JSONCreator
  public static Site of(String value) {
    for (Site a : Site.values()) {
      if (a.value == value) {
        return a;
      }
    }
    return UNKNOWN;
  }

  @JsonValue
  public String value() {
    return value;
  }
}
