package com.suphawking.collectd.okcoin.mapper;

import com.suphawking.collectd.jdbi.mapper.AutoMapper;
import com.suphawking.collectd.okcoin.dao.SaveOkcoinTrendData;

import org.skife.jdbi.v2.StatementContext;

import java.sql.ResultSet;

/**
 * Created by loveknut on 2017/1/6.
 */
public class OkcoinTrendDataMapper extends AutoMapper<SaveOkcoinTrendData> {
  @Override
  protected SaveOkcoinTrendData customMap(SaveOkcoinTrendData result, int idx,
      ResultSet rs, StatementContext ctx) {
    return result;
  }
}
