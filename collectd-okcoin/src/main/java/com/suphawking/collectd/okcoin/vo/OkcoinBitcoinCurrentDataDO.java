package com.suphawking.collectd.okcoin.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by loveknut on 2017/1/6.
 */
@Data
@NoArgsConstructor
public class OkcoinBitcoinCurrentDataDO implements Serializable {


  private BigDecimal high;
  private String vol;
  private String last;
  private BigDecimal low;
  private BigDecimal buy;
  private BigDecimal sell;
  private String timestamp;

  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }

}
