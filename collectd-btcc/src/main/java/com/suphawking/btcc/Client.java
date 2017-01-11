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
  MessageHandlerFactory messageHandlerFactory;

  Client(MessageHandlerFactory messageHandlerFactory, String url) throws URISyntaxException {
    this.messageHandlerFactory = messageHandlerFactory;
    this.opts = new IO.Options();
    this.opts.reconnection = true;
    this.socket = IO.socket(url, this.opts);

  }

  public void start() {
    socket.on(Socket.EVENT_CONNECT, args -> {
      log.info("Connected.");

      socket.emit("subscribe", "marketdata_cnybtc");
      //socket.emit("subscribe", "marketdata_cnyltc");
      //socket.emit("subscribe", "marketdata_btcltc");
      //socket.emit("subscribe", "grouporder_cnybtc");
      //socket.emit("subscribe", "grouporder_cnyltc");
      //socket.emit("subscribe", "grouporder_btcltc");
      //socket.emit("private", Arrays.asList(payload(), sign()));
    })
        .on("message", args -> log.info(args.toString()))
        .on("trade", messageHandlerFactory.getMessageHandler("trade"))
        .on("ticker", messageHandlerFactory.getMessageHandler("ticker"))
        .on("grouporder", messageHandlerFactory.getMessageHandler("grouporder"))
        .on("order", messageHandlerFactory.getMessageHandler("order"))
        .on(Socket.EVENT_DISCONNECT, args -> log.info("Disconnected."));


    socket.connect();
  }

  public void stop() {
    socket.disconnect();
  }
}
