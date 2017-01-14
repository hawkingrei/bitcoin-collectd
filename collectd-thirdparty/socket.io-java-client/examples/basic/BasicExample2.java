package basic;

import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;

import io.socket.IOAcknowledge;
import io.socket.IOCallback;
import io.socket.SocketIO;
import io.socket.SocketIOException;

public class BasicExample2 {
  public BasicExample2() throws Exception {
    SocketIO socket = new SocketIO("http://127.0.0.1:3001/");
    socket.connect(new IOCallback() {
      @Override
      public void onMessage(JsonElement json, IOAcknowledge ack) {
        try {
          System.out.println("Server said:" + json.toString());
        } catch (JsonSyntaxException e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onMessage(String data, IOAcknowledge ack) {
        System.out.println("Server said: " + data);
      }

      @Override
      public void onError(SocketIOException socketIOException) {
        System.out.println("an Error occured");
        socketIOException.printStackTrace();
      }

      @Override
      public void onDisconnect() {
        System.out.println("Connection terminated.");
      }

      @Override
      public void onConnect() {
        System.out.println("Connection established");
      }

      @Override
      public void on(String event, IOAcknowledge ack, JsonElement... args) {
        System.out.println("Server triggered event '" + event + "'");
      }
    });

    // This line is cached until the connection is establisched.
    socket.send("Hello Server!");
  }

  public static void main(String[] args) {
    try {
      new BasicExample2();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
