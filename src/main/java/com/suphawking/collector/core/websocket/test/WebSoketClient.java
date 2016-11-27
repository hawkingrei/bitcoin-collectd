package com.suphawking.collector.core.websocket.test;

/**
 * Created by loveknut on 2016/11/17.
 */

import com.suphawking.collector.core.domain.websocket.websocketSource;
import com.suphawking.collector.core.websocket.WebSocketBase;
import com.suphawking.collector.core.websocket.WebSocketService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebSoketClient extends WebSocketBase {
  public WebSoketClient(websocketSource source,WebSocketService service){
    super(source,service);
  }
}
