package com.suphawking.collector.core.socketio;

import io.socket.client.IO;
import io.socket.client.Socket;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by loveknut on 2016/11/27.
 */
@Slf4j
public class huobitest {
  public static void main(String[] args) throws Exception {
    IO.Options opts = new IO.Options();
    opts.reconnection = true;
    final Socket socket = IO.socket("http://hq.huobi.com:80/",opts);
    String strMsg = "{\"symbolList\":{\"lastTimeLine\":[{\"symbolId\":\"btccny\",\"pushType\":\"pushLong\"}],"
        +                  "},\"version\":1,\"msgType\":\"reqMsgSubscribe\",\"requestIndex\":1404103038520}";


    socket.on(Socket.EVENT_CONNECT, args -> {
      log.info("Connected.");

      socket.emit("requests", strMsg);
    }).on(Socket.EVENT_DISCONNECT, args -> log.info("Disconnected."));
    socket.connect();
  }
}
