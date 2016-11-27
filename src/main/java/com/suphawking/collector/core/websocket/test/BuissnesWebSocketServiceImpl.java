package com.suphawking.collector.core.websocket.test;
import com.suphawking.collector.core.websocket.WebSocketService;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by loveknut on 2016/11/17.
 */
@Slf4j
public class BuissnesWebSocketServiceImpl implements WebSocketService{
  public void onReceive(String msg){
    log.info("WebSocket Client received message: " + msg);
  }
}
