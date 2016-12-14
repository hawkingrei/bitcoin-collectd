package com.suphawking.collectd.core.domain.bitcoin;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by loveknut on 2016/12/1.
 */
@Data
@NoArgsConstructor
public class Price implements Serializable {
  private BigDecimal price;
  private String sedId;
  private Date time;
  private String source;
}
