package com.suphawking.collectd.okcoin.test;

import com.suphawking.collectd.core.domain.websocket.WebsocketSource;
import com.suphawking.collectd.okcoin.client.HuobiClient;

import org.junit.Test;

/**
 * Created by loveknut on 2016/12/17.
 */
public class clientTest {

  @Test
  public void testClientGetData()  throws Exception {
    WebsocketSource clientsource = new WebsocketSource();
    clientsource.setName("okcoin");
    clientsource.setUrl("wss://real.okcoin.cn:10440/websocket/okcoinapi");

    HuobiClient client = new HuobiClient(clientsource);
    client.start();
    client.stop();



  }
}
