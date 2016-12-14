package com.suphawking.collectd.jdbi.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by loveknut on 2016/12/1.
 */
@Data
@NoArgsConstructor
public class PriceDo implements Serializable {

  private BigDecimal price;
  private String sedId;
  private Date time;
  private String source;

  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}
