package com.suphawking.btcc;

/**
 * Created by loveknut on 2017/1/11.
 */
public class MessageHandlerFactory {


  public MessageHandler getMessageHandler(String prefix) {
    return new MessageHandler(prefix);
  }
}
