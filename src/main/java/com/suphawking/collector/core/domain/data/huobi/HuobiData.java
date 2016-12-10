package com.suphawking.collector.core.domain.data.huobi;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * Created by loveknut on 2016/12/10.
 */
@Data
@NoArgsConstructor
public class HuobiData implements Serializable {


  private static final long serialVersionUID = -3277249735837083741L;

  @NotNull
  private String channel;


  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }

}
