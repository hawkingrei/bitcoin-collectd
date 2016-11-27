package com.suphawking.collector.core.websocket.test;

/**
 * Created by loveknut on 2016/11/17.
 */

import com.suphawking.collector.core.domain.websocket.websocketSource;
import com.suphawking.collector.core.websocket.WebSocketService;

public class Example {
  private static final String ENDPOINT = "http://hq.huobi.com:80/socket.io/1/";

  public static void main(String[] args) throws Exception {

    // apiKey 为用户申请的apiKey
    String apiKey = "XXXXX";

    // secretKey为用户申请的secretKey
    String secretKey = "XXXXX";

    apiKey = "";
    secretKey = "";
    websocketSource s = new websocketSource();
    s.setName("okcoin");
    //s.setUrl(huobiUrl);
    s.setUrl("wss://real.okcoin.cn:10440/websocket/okcoinapi");
    // 国际站WebSocket地址 注意如果访问国内站 请将 real.okcoin.com 改为 real.
    WebSocketService service = new BuissnesWebSocketServiceImpl();
    WebSoketClient client = new WebSoketClient(s, service);
    client.run();

    //client.sendMessage(strMsg);
    client.addChannel("ok_sub_spotcny_btc_ticker");


  }
}
