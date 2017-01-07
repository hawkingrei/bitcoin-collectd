package com.suphawking.collectd.okcoin.mapper;

import com.suphawking.collectd.spi.jdbi.AutoMapper;
import com.suphawking.collectd.okcoin.vo.OkcoinBitcoinCurrentDataDO;

import org.skife.jdbi.v2.StatementContext;

import java.sql.ResultSet;

/**
 * Created by loveknut on 2017/1/6.
 */
public class OkcoinTrendDataMapper extends AutoMapper<OkcoinBitcoinCurrentDataDO> {
  @Override
  protected OkcoinBitcoinCurrentDataDO customMap(OkcoinBitcoinCurrentDataDO result, int idx,
      ResultSet rs, StatementContext ctx) {
    return result;
  }
}
