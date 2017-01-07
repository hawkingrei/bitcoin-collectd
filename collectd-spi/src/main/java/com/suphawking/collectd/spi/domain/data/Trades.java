package com.suphawking.collectd.spi.domain.data;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

/**
 * Created by loveknut on 2017/1/7.
 */
@Data
@Getter
@Setter
@NoArgsConstructor
public class Trades {
  private static final long serialVersionUID = -3277249735837083741L;


  // 交易序号, 价格, 成交量, 时间, 买卖类型
  @NotNull
  private String seriesid;
  @NotNull
  private BigDecimal price;
  @NotNull
  private BigDecimal volume;
  @NotNull
  private Date time;
  @NotNull
  private String type;

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}
