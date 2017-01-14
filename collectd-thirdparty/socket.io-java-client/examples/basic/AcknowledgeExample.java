package basic;
/*
 * socket.io-java-client Test.java
 *
 * Copyright (c) 2012, Enno Boland
 * socket.io-java-client is a implementation of the socket.io protocol in Java.
 * 
 * See LICENSE file for more information
 */

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

import io.socket.IOAcknowledge;
import io.socket.IOCallback;
import io.socket.SocketIO;
import io.socket.SocketIOException;

public class AcknowledgeExample implements IOCallback {
  private SocketIO socket;

  public AcknowledgeExample() throws Exception {
    socket = new SocketIO();
    socket.connect("http://127.0.0.1:3001/", this);

    // Sends a string to the server.
    socket.send(new IOAcknowledge() {
      @Override
      public void ack(JsonElement... args) {
        System.out.println("Server acknowledges this package.");
        for (Object o : args)
          System.out.println(o.toString());
      }
    }, "Hello Server");
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    try {
      new AcknowledgeExample();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void onMessage(JsonElement json, IOAcknowledge ack) {
  }

  @Override
  public void onMessage(String data, IOAcknowledge ack) {
    // acknowledges a package
    ack.ack(new JsonPrimitive("argument1"), new JsonPrimitive(23.42), new JsonPrimitive("argument3"));
  }

  @Override
  public void onError(SocketIOException socketIOException) {
  }

  @Override
  public void onDisconnect() {
  }

  @Override
  public void onConnect() {
  }

  @Override
  public void on(String event, IOAcknowledge ack, JsonElement... args) {
  }
}
