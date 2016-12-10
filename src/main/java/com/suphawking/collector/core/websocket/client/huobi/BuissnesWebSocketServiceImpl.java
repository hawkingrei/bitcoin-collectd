package com.suphawking.collector.core.websocket.client.huobi;

import com.alibaba.fastjson.JSONArray;
import com.suphawking.collector.core.websocket.WebSocketService;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;

/**
 * Created by loveknut on 2016/11/17.
 */
@Slf4j
public class BuissnesWebSocketServiceImpl implements WebSocketService {

  public String pong = "{\"event\":\"pong\"}";

  public void onReceive(String msg) {

    log.info("WebSocket Client received message: " + msg);

    if (!msg.equals(pong)) {
      List<HashMap> data =  JSONArray.parseArray(msg, HashMap.class);
      System.out.println(data.get(0).get("channel"));
      System.out.println(data.get(0).get("data"));
    }
    /*
    try {

    } catch() {

    }
    if (msg != "{\"event\":\"pong\"}"){
      List<HashMap> data =  JSONArray.parseArray(msg, HashMap.class);
      System.out.println(data.toString());
    }




    /*

    if (data.getString()  == "ok_sub_spotcny_btc_ticker"){
      log.info("WebSocket Client received message: " + msg);
    }
    */

  }


}
