package chat;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;

import io.socket.SocketIO;

import java.net.MalformedURLException;

public class Chat extends Thread {
  private SocketIO socket;
  private ChatCallback callback;

  public Chat(ChatCallbackAdapter callback) {
    this.callback = new ChatCallback(callback);
  }

  @Override
  public void run() {
    try {
      socket = new SocketIO("http://localhost:3000", callback);
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
  }

  public void sendMessage(String message) {
    try {
      JsonObject json = new JsonObject();
      json.add("message", new JsonPrimitive(message));
      socket.emit("user message", json);
    } catch (JsonSyntaxException ex) {
      ex.printStackTrace();
    }
  }

  public void join(String nickname) {
    try {
      JsonObject json = new JsonObject();
      json.add("message", new JsonPrimitive(nickname));
      socket.emit("nickname", callback, json);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
