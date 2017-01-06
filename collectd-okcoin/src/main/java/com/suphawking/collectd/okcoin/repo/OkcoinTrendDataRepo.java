package com.suphawking.collectd.okcoin.repo;

import com.suphawking.collectd.okcoin.data.OkcoinBitcoinCurrentData;

/**
 * Created by loveknut on 2016/12/17.
 */
public class OkcoinTrendDataRepo {

  public void okcoinCurrentDataRepo(OkcoinBitcoinCurrentData data) {
    data.getBuy();
    data.getHigh();
    data.getLast();
    data.getVol();
    data.getLow();
    data.getSell();
    data.getTimestamp();
  }


}
