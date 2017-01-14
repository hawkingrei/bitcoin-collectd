package chat;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public interface ChatCallbackAdapter {
  public void callback(JsonArray data) throws Throwable;

  public void on(String event, JsonElement data);

  public void onMessage(String message);

  public void onMessage(JsonElement json);

  public void onConnect();

  public void onDisconnect();

  public void onConnectFailure();
}
