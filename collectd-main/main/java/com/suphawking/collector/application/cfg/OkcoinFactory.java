package com.suphawking.collector.application.cfg;

import lombok.Data;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by loveknut on 2016/11/1.
 */
@Data
public class OkcoinFactory {
  @NotEmpty
  private String apiKey;
  @NotEmpty
  private String secretKey;
}
