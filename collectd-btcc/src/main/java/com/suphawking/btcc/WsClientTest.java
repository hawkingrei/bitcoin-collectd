package com.suphawking.btcc;

import com.suphawking.collectd.spi.websocket.WebsocketSource;

import java.net.URISyntaxException;

/**
 * Created by loveknut on 2016/11/29.
 */

public class WsClientTest {


  public static void main(String[] args0) throws URISyntaxException {
    WebsocketSource btccClientsource = new WebsocketSource();
    btccClientsource.setName("btcc");
    btccClientsource.setUrl("https://websocket.btcchina.com");

    MessageHandlerFactory messageHandlerFactory = new MessageHandlerFactory();
    BtccClient cli = new BtccClient(messageHandlerFactory, btccClientsource);

    cli.start();
  }
}
