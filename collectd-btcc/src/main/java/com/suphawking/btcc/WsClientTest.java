package com.suphawking.btcc;

import java.net.URISyntaxException;

/**
 * Created by loveknut on 2016/11/29.
 */

public class WsClientTest {
  private static String URL = "https://websocket.btcchina.com";

  public static void main(String[] args0) throws URISyntaxException {

    MessageHandlerFactory messageHandlerFactory = new MessageHandlerFactory();
    Client cli = new Client(messageHandlerFactory, URL);

    cli.start();
  }
}
