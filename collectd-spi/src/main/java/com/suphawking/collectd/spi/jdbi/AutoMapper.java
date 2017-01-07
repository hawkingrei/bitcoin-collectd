package com.suphawking.collectd.spi.jdbi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.lang.reflect.ParameterizedType;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by loveknut on 2016/11/29.
 */

@SuppressWarnings("unchecked")
public abstract class AutoMapper<T> implements ResultSetMapper<T> {

  protected static final ObjectMapper mapper = new ObjectMapper();

  @Override
  public T map(int idx, ResultSet rs, StatementContext ctx) throws SQLException {
    ResultSetMetaData md = rs.getMetaData();
    int columnCount = md.getColumnCount();

    Map<String, Object> map = Maps.newHashMapWithExpectedSize(columnCount);
    for (int i = 1; i <= columnCount; ++i) {
      map.put(md.getColumnLabel(i), rs.getObject(i));
    }

    T result = mapper.convertValue(map, (Class<T>) ((ParameterizedType) getClass()
        .getGenericSuperclass()).getActualTypeArguments()[0]);
    return customMap(result, idx, rs, ctx);
  }

  protected abstract T customMap(T result, int idx, ResultSet rs, StatementContext ctx);

}
