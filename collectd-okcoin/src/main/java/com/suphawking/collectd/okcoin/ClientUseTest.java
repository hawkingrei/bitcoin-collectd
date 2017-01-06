package com.suphawking.collectd.okcoin;

import com.suphawking.collectd.core.domain.websocket.WebsocketSource;
import com.suphawking.collectd.okcoin.client.HuobiClient;

/**
 * Created by loveknut on 2017/1/6.
 */
public class ClientUseTest {
  public static void main(String[] args) throws Exception {
    WebsocketSource clientsource = new WebsocketSource();
    clientsource.setName("okcoin");
    clientsource.setUrl("wss://real.okcoin.cn:10440/websocket/okcoinapi");

    HuobiClient client = new HuobiClient(clientsource);
    client.start();

  }

}
