package com.suphawking.collectd.huobi.data;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by loveknut on 2017/2/2.
 */
@Data
@NoArgsConstructor
public class LastTimeLine implements Serializable {
  private static final long serialVersionUID = -3277249735837083741L;

  private String time;
  @SerializedName("priceLast")
  private BigDecimal priceLast;
  @SerializedName("amount")
  private BigDecimal amount;
  @SerializedName("symbolId")
  private String symbolId;
  @SerializedName("_id")
  private String id;
  private long date;

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }

}
