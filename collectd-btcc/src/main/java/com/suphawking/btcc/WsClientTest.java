package com.suphawking.btcc;

import java.net.URISyntaxException;

/**
 * Created by loveknut on 2016/11/29.
 */

public class WsClientTest {
  private static String URL = "https://websocket.btcchina.com";

  public static void main(String[] args0) throws URISyntaxException {


    MessageHandler tradeHandler = new MessageHandler("trade");
    MessageHandler tickerHandler = new MessageHandler("ticker");
    MessageHandler grouporderHandler = new MessageHandler("grouporder");
    MessageHandler orderHandler = new MessageHandler("order");
    Client cli = new Client(tradeHandler, tickerHandler, grouporderHandler, orderHandler, URL);

    cli.start();
  }
}
