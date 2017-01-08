package com.suphawking.collectd.okcoin.client;


import com.google.inject.Inject;
import com.suphawking.collectd.okcoin.WebSocketService;
import com.suphawking.collectd.spi.websocket.WebsocketSource;

/**
 * Created by loveknut on 2016/11/17.
 */

public class HuobiClient {
  private static final String ENDPOINT = "http://hq.huobi.com:80/socket.io/1/";

  private WebsocketSource clientsource;
  private WebSocketClient client;

  @Inject
  public HuobiClient(WebsocketSource clientsource) {
    this.clientsource = clientsource;

  }

  public void start() throws Exception {

    // 国际站WebSocket地址 注意如果访问国内站 请将 real.okcoin.com 改为 real.

    WebSocketService service = new BusinessWebSocketServiceImpl();
    client = new WebSocketClient(clientsource, service);
    client.run();

    //client.sendMessage(strMsg);
    client.addChannel("ok_sub_spotcny_btc_ticker");
    client.addChannel("ok_sub_spotcny_btc_trades");
    client.addChannel("ok_sub_spotcny_btc_depth_60");


  }

  public  void stop() throws Exception {
    client.stop();

  }
}
