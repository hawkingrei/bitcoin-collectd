package com.suphawking.collectd.okcoin.dao;

import com.suphawking.collectd.okcoin.data.OkcoinBitcoinCurrentData;
import com.suphawking.collectd.okcoin.mapper.OkcoinTrendDataMapper;

import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

/**
 * Created by loveknut on 2017/1/6.
 */
public interface SaveOkcoinTrendData {

  String INSERT_COLS = "buy,high,last,low,sell,timestamp,vol";
  String ALL_COLS = "id,buy,high,last,low,sell,timestamp,vol";

  @SqlQuery(" INSERT INTO OkcoinTrendData (" + INSERT_COLS + ") "
      + " VALUES (:buy,:high,:last,:low,:sell,:timestamp,:vol) ")
  @Mapper(OkcoinTrendDataMapper.class)
  @GetGeneratedKeys
  String save(@BindBean OkcoinBitcoinCurrentData ansibleyaml);

}
