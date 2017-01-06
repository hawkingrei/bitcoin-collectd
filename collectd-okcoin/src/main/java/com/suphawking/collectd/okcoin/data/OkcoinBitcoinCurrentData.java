package com.suphawking.collectd.okcoin.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by loveknut on 2016/12/17.
 */
@Data
@NoArgsConstructor
public class OkcoinBitcoinCurrentData implements Serializable {
  private static final long serialVersionUID = -3277249735837083741L;

  private BigDecimal high;
  private String vol;
  private String last;
  private BigDecimal low;
  private BigDecimal buy;
  private BigDecimal sell;
  private String timestamp;

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}
