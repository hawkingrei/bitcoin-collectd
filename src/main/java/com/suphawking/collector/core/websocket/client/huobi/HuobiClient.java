package com.suphawking.collector.core.websocket.client.huobi;

/**
 * Created by loveknut on 2016/11/17.
 */

import com.suphawking.collector.core.domain.websocket.WebsocketSource;
import com.suphawking.collector.core.websocket.WebSocketService;

public class HuobiClient {
  private static final String ENDPOINT = "http://hq.huobi.com:80/socket.io/1/";

  public static void main(String[] args) throws Exception {



    WebsocketSource clientsource = new WebsocketSource();
    clientsource.setName("okcoin");
    clientsource.setUrl("wss://real.okcoin.cn:10440/websocket/okcoinapi");
    // 国际站WebSocket地址 注意如果访问国内站 请将 real.okcoin.com 改为 real.
    WebSocketService service = new BuissnesWebSocketServiceImpl();
    WebSoketClient client = new WebSoketClient(clientsource, service);
    client.run();

    //client.sendMessage(strMsg);
    client.addChannel("ok_sub_spotcny_btc_ticker");


  }
}
