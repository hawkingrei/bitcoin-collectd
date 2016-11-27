package com.okcoin.websocket.test;

import org.apache.log4j.Logger;
import com.okcoin.websocket.WebSocketBase;
import com.okcoin.websocket.WebSocketService;
/**
 * Created by loveknut on 2016/11/3.
 */
public class BuissnesWebSocketServiceImpl implements WebSocketService{
  private Logger log = Logger.getLogger(WebSocketBase.class);
  @Override
  public void onReceive(String msg){

    log.info("WebSocket Client received message: " + msg);

  }
}
