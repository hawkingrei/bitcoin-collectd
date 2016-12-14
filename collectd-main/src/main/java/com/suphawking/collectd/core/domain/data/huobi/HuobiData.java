package com.suphawking.collectd.core.domain.data.huobi;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * Created by loveknut on 2016/12/10.
 */
@Data
@Getter
@Setter
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
