package com.suphawking.collectd.okcoin.data;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by loveknut on 2016/12/17.
 */
@Data
@Getter
@Setter
@NoArgsConstructor
public class OkcoinBitcoinCurrentData implements Serializable {
  private BigDecimal high;
  private String vol;
  private String last;
  private BigDecimal low;
  private BigDecimal buy;
  private BigDecimal sell;
  private String timestamp;
}
