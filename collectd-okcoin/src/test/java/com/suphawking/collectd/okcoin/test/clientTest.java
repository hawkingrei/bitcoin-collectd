package com.suphawking.collectd.okcoin.test;


import com.suphawking.collectd.okcoin.client.OkcoinClient;
import com.suphawking.collectd.spi.websocket.WebsocketSource;

import org.junit.Test;

/**
 * Created by loveknut on 2016/12/17.
 */
public class clientTest {

  @Test
  public void testClientGetData() throws Exception {
    WebsocketSource clientsource = new WebsocketSource();
    clientsource.setName("okcoin");
    clientsource.setUrl("wss://real.okcoin.cn:10440/websocket/okcoinapi");

    OkcoinClient client = new OkcoinClient(clientsource);
    client.start();
    client.stop();
  }
}
