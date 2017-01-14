package chat;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import io.socket.IOAcknowledge;
import io.socket.IOCallback;
import io.socket.SocketIOException;

public class ChatCallback implements IOCallback, IOAcknowledge {
  private ChatCallbackAdapter callback;

  public ChatCallback(ChatCallbackAdapter callback) {
    this.callback = callback;
  }

  @Override
  public void ack(JsonElement... data) {
    try {
      JsonArray jarray = new JsonParser().parse(data.toString()).getAsJsonArray();
      callback.callback(jarray);
    } catch (Throwable e) {
      e.printStackTrace();
    }
  }

  @Override
  public void on(String event, IOAcknowledge ack, JsonElement... data) {
    callback.on(event, data[0]);
  }

  @Override
  public void onMessage(String message, IOAcknowledge ack) {
    callback.onMessage(message);
  }

  @Override
  public void onMessage(JsonElement json, IOAcknowledge ack) {
    callback.onMessage(json.getAsJsonObject());
  }

  @Override
  public void onConnect() {
    callback.onConnect();
  }

  @Override
  public void onDisconnect() {
    callback.onDisconnect();
  }

  @Override
  public void onError(SocketIOException socketIOException) {
    socketIOException.printStackTrace();
    callback.onConnectFailure();
  }


}
