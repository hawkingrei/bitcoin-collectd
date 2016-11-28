package com.suphawking.collector.core.socketio;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by loveknut on 2016/11/27.
 */
@Slf4j
public class huobitest {
  public static void main(String[] args0) throws Exception {
    IO.Options opts = new IO.Options();
    //opts.reconnection = true;

    //final Socket socket = IO.socket("hq.huobi.com:80",opts);
    //String strMsg = "{\"symbolList\":{\"lastTimeLine\":[{\"symbolId\":\"btccny\",\"pushType\":\"pushLong\"}],"
    //   +                  "},\"version\":1,\"msgType\":\"reqMsgSubscribe\",\"requestIndex\":1404103038520}";


    //socket.on(Socket.EVENT_CONNECT,new Emitter.Listener() {
    //  @Override
    //  public void call(Object... args) {
    //    log.info("Connected.");
    //    //JSONObject obj = (JSONObject)args[0];
    //  }});


    //socket.on("message", args -> log.info("message: {}", args[0]));
    //socket.connect();
  }
}
//@Slf4j
//class JsonLogger implements Emitter.Listener {
//
//  private String prefix;
//
// public JsonLogger(String prefix) {
//   this.prefix = prefix;
//  }

//  @Override
//  public void call(Object... args) {
//    JSONObject json = (JSONObject) args[0];
//    log.info("{}: {}",prefix, json);
//  }
//}
