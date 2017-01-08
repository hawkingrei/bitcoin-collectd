package com.suphawking.collectd.okcoin.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.suphawking.collectd.okcoin.WebSocketService;
import com.suphawking.collectd.spi.domain.data.huobi.SubSpotcnyBtcTicker;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;

/**
 * Created by loveknut on 2016/11/17.
 */
@Slf4j
public class BusinessWebSocketServiceImpl implements WebSocketService {


  public String pong = "{\"event\":\"pong\"}";


  public BusinessWebSocketServiceImpl() {

  }

  public void onReceive(String msg) {
    log.debug("WebSocket Client received message: " + msg);
    if (!msg.equals(pong)) {
      List<HashMap> data = JSONArray.parseArray(msg, HashMap.class);
      HashMap realDate = data.get(0);
      if (realDate.get("data") != null) {

        switch (realDate.get("channel").toString()) {
          case "ok_sub_spotcny_btc_ticker":
            SubSpotcnyBtcTicker tickerData = JSON.parseObject(data.get(0).get("data").toString(),
                SubSpotcnyBtcTicker.class);
            log.info(tickerData.toString());
            break;
          case "ok_sub_spotcny_btc_trades":

            log.info(data.get(0).get("data").toString());
            List<List<String>> tradaDate = JSON.parseObject(data.get(0).get("data").toString(),
                List.class);
            //log.debug(tradaDate.get(0).toString());
            //tradaDate.parallelStream().forEach( n -> System.out.println(n));
            break;
          case "ok_sub_spotcny_btc_depth_60":
            log.info(data.get(0).toString());
            break;
          default:
            log.info(data.get(0).toString());
            break;
        }


        //
      }
    }
  }


}
