package com.suphawking.collectd.okcoin.client;

/**
 * Created by loveknut on 2016/11/17.
 */


import com.suphawking.collectd.okcoin.WebSocketBase;
import com.suphawking.collectd.okcoin.WebSocketService;
import com.suphawking.collectd.spi.websocket.WebsocketSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebSocketClient extends WebSocketBase {
  public WebSocketClient(WebsocketSource source, WebSocketService service) {
    super(source, service);
  }
}
