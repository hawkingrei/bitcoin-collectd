package com.suphawking.btcc.test;

import com.suphawking.btcc.BtccClient;
import com.suphawking.btcc.MessageHandlerFactory;
import com.suphawking.collectd.spi.websocket.WebsocketSource;

import org.junit.Test;

/**
 * Created by loveknut on 2017/1/12.
 */
public class TestBtccClient {

  @Test
  public void testClientGetData() throws Exception {
    WebsocketSource btccClientsource = new WebsocketSource();
    btccClientsource.setName("btcc");
    btccClientsource.setUrl("https://websocket.btcchina.com");

    MessageHandlerFactory messageHandlerFactory = new MessageHandlerFactory();
    BtccClient btcc = new BtccClient(messageHandlerFactory, btccClientsource);
    btcc.start();
    btcc.stop();
  }
}
