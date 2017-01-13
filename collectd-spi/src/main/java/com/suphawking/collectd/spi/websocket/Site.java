package com.suphawking.collectd.spi.websocket;

import com.alibaba.fastjson.annotation.JSONCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by loveknut on 2016/11/18.
 */

public enum Site {
  OKCOIN("OKCOIN"),
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



