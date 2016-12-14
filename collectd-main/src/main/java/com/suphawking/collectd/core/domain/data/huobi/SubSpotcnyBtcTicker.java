package com.suphawking.collectd.core.domain.data.huobi;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by loveknut on 2016/12/10.
 */
@Data
@NoArgsConstructor
public class SubSpotcnyBtcTicker implements Serializable {
  private BigDecimal high;
  private String vol;
  private String last;
  private BigDecimal low;
  private BigDecimal buy;
  private BigDecimal sell;
  private String timestamp;



}
