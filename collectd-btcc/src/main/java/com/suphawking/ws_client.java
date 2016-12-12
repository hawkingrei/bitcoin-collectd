package com.suphawking;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

import org.json.JSONObject;

import java.net.URISyntaxException;
/**
 * Created by loveknut on 2016/11/29.
 */

public class ws_client {
  private static String URL = "https://websocket.btcchina.com";

  public static void main(String[] args0) throws URISyntaxException {

    IO.Options opts = new IO.Options();
    opts.reconnection = true;

    Socket socket = IO.socket(URL, opts);
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
        .on("message", args -> System.out.println(args))
        //.on("trade", new JsonLogger("trade"))
        .on("ticker", new JsonLogger("ticker"))
        .on("grouporder", new JsonLogger("grouporder"))
        .on("order", new JsonLogger("order"))
        .on("account_info", new JsonLogger("account_info"))
        .on(Socket.EVENT_DISCONNECT, args -> System.out.println("Disconnected."));


    socket.connect();

  }
  private static class JsonLogger implements Emitter.Listener {

    private String prefix;

    public JsonLogger(String prefix) {
      this.prefix = prefix;
    }

    @Override
    public void call(Object... args) {
      JSONObject json = (JSONObject) args[0];
      System.out.println(prefix+ "     "+json);
    }
  }
}
