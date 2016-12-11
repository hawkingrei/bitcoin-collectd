package com.suphawking.collector.core.websocket.huobi.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.suphawking.collector.core.domain.data.huobi.SubSpotcnyBtcTicker;
import com.suphawking.collector.core.websocket.huobi.WebSocketService;

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
      if (data.get(0).get("data") != null ) {
        SubSpotcnyBtcTicker tickerData = JSON.parseObject(data.get(0).get("data").toString(),
            SubSpotcnyBtcTicker.class);
        System.out.println(tickerData.getBuy());
      }
    }
  }


}