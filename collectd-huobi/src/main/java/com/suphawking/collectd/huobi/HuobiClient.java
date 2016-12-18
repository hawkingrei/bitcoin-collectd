package com.suphawking.collectd.huobi;


import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonElement;

import io.socket.IOAcknowledge;
import io.socket.IOCallback;
import io.socket.SocketIO;
import io.socket.SocketIOException;

import java.net.URI;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;
/**
 * Created by loveknut on 2016/12/1.
 */

class HuobiClient {


  private SocketIO socket;

  /**
   * @param args
   * TEST
   */
  public static void main(String[] args) throws Exception {

    URI url = new URI("http://hq.huobi.com:80");
    String strMsg =
        "{\"symbolList\":{\"lastTimeLine\":[{\"symbolId\":\"btccny\",\"pushType\":\"pushLong\"}],"
            + "},\"version\":1,\"msgType\":\"reqMsgSubscribe\",\"requestIndex\":1404103038520}";
    try {
      SocketIO.setDefaultSSLSocketFactory(SSLContext.getDefault());
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
    SocketIO socket = new SocketIO();
    socket.connect(url.toURL(),new IOCallback() {
      @Override
      public void onError(SocketIOException socketIOException) {
        System.out.print("error");
      }

      @Override
      public void onDisconnect() {
        System.out.print("disconnect");
      }

      @Override
      public void onConnect() {
        System.out.print("ok");
      }

      @Override
      public void onMessage(String message, IOAcknowledge ioAcknowledge) {
        System.out.println(message);
      }

      @Override
      public void onMessage(JsonElement jsonElement, IOAcknowledge ioAcknowledge) {
        //System.out.print(jsonElement.toString());

      }

      @Override
      public void on(String message, IOAcknowledge ioAcknowledge, JsonElement... jsonElements) {
        JsonElement jsonElement = jsonElements[0];
        System.out.print(jsonElement.toString());
        //List<HashMap> data =  JSONArray.parseArray(stringmassage, HashMap.class);
        //System.out.println(data.get(0).get("payload"));
        //System.out.println(s.toString());
        //System.out.println(jsonElements);
        //JSONObject result = new JSONObject.parseObject(message);
        //result.getJSONObject("payload");
      }

    });
    JSONObject sendJO = new JSONObject().parseObject(strMsg);

    socket.emit("request", sendJO.toJSONString());

    // This line is cached until the connection is establisched.

  }

}
