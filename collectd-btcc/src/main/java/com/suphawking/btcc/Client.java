package com.suphawking.btcc;

import io.socket.client.IO;
import io.socket.client.Socket;

import lombok.extern.slf4j.Slf4j;

import java.net.URISyntaxException;

/**
 * Created by loveknut on 2017/1/10.
 */
@Slf4j
public class Client {
  MessageHandler massageHandler;
  IO.Options opts;
  Socket socket;
  MessageHandler tradeHandler;
  MessageHandler tickerHandler;
  MessageHandler grouporderHandler;
  MessageHandler orderHandler;

  Client(MessageHandler tradeHandler,
      MessageHandler tickerHandler,
      MessageHandler grouporderHandler,
      MessageHandler orderHandler, String url) throws URISyntaxException {
    this.massageHandler = massageHandler;
    this.opts = new IO.Options();
    this.opts.reconnection = true;
    this.socket = IO.socket(url, this.opts);
    this.tradeHandler = tradeHandler;
    this.tickerHandler = tickerHandler;
    this.grouporderHandler = grouporderHandler;
    this.orderHandler = orderHandler;
  }

  public void start() {
    socket.on(Socket.EVENT_CONNECT, args -> {
      System.out.println("Connected.");

      socket.emit("subscribe", "marketdata_cnybtc");
      //socket.emit("subscribe", "marketdata_cnyltc");
      //socket.emit("subscribe", "marketdata_btcltc");

      //socket.emit("subscribe", "grouporder_cnybtc");
      //socket.emit("subscribe", "grouporder_cnyltc");
      //socket.emit("subscribe", "grouporder_btcltc");

      //socket.emit("private", Arrays.asList(payload(), sign()));
    })
        .on("message", args -> log.info(args.toString()))
        .on("trade", args -> tradeHandler.call(args))
        .on("ticker", args -> tickerHandler.call(args))
        .on("grouporder", args -> grouporderHandler.call(args))
        .on("order", args -> orderHandler.call(args))
        .on(Socket.EVENT_DISCONNECT, args -> System.out.println("Disconnected."));


    socket.connect();
  }

  public void stop() {
    socket.disconnect();
  }
}
