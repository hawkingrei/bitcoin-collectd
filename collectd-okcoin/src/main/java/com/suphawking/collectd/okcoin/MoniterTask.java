package com.suphawking.collectd.okcoin;

import java.util.TimerTask;

/**
 * Created by loveknut on 2016/12/1.
 */
class MoniterTask extends TimerTask {

  private long startTime = System.currentTimeMillis();
  private int checkTime = 5000;
  private WebSocketBase client = null;

  public void updateTime() {
    // log.info("startTime is update");
    startTime = System.currentTimeMillis();
  }

  public MoniterTask(WebSocketBase client) {
    this.client = client;
    // log.info("TimerTask is starting.... ");
  }

  public void run() {
    if (System.currentTimeMillis() - startTime > checkTime) {
      client.setStatus(false);
      // log.info("Moniter reconnect....... ");
      client.reConnect();
    }
    client.sentPing();
    // log.info("Moniter ping data sent.... ");
  }

}
