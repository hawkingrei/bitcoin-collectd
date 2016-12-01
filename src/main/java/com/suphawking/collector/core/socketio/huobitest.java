package com.suphawking.collector.core.socketio;


import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonElement;

import io.socket.IOAcknowledge;
import io.socket.IOCallback;
import io.socket.SocketIO;
import io.socket.SocketIOException;

import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;

/**
 * Created by loveknut on 2016/11/27.
 */
@Slf4j
public class huobitest{


  private SocketIO socket;

  /**
   * @param args
   */
  public static void main(String[] args) throws Exception {

    URI url =new URI("http://hq.huobi.com:80");
    String strMsg = "{\"symbolList\":{\"lastTimeLine\":[{\"symbolId\":\"btccny\",\"pushType\":\"pushLong\"}],"
         +                  "},\"version\":1,\"msgType\":\"reqMsgSubscribe\",\"requestIndex\":1404103038520}";
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
      public void onMessage(String s, IOAcknowledge ioAcknowledge) {
        System.out.println(s);
      }

      @Override
      public void onMessage(JsonElement jsonElement, IOAcknowledge ioAcknowledge) {
        System.out.print(jsonElement.toString());
      }

      @Override
      public void on(String s, IOAcknowledge ioAcknowledge, JsonElement... jsonElements) {
        //System.out.println(s.toString());
        System.out.println(jsonElements.toString());
      }

    });
    JSONObject sendJO = new JSONObject().parseObject(strMsg);

    socket.emit("request", sendJO.toJSONString());

    // This line is cached until the connection is establisched.

  }





}
