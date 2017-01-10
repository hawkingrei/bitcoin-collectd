package com.suphawking.btcc;

import io.socket.emitter.Emitter;

import org.json.JSONObject;

/**
 * Created by loveknut on 2017/1/10.
 */

public class MessageHandler implements Emitter.Listener {
  private String prefix;

  public MessageHandler(String prefix) {
    this.prefix = prefix;
  }

  @Override
  public void call(Object... args) {
    JSONObject json = (JSONObject) args[0];
    System.out.println(prefix + "     " + json);
  }
}
