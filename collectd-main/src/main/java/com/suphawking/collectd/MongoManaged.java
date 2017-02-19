package com.suphawking.collectd;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.suphawking.collectd.db.MongoConfiguration;

import io.dropwizard.lifecycle.Managed;

import java.util.Arrays;

/**
 * Created by loveknut on 2017/2/19.
 */
public class MongoManaged implements Managed {

  private Mongo mongo;
  private MongoClient mongocli;
  private MongoCredential credential;
  private DB db;

  public MongoManaged(MongoConfiguration mongoConfig) throws Exception {
    this.credential = MongoCredential.createCredential(mongoConfig.user, mongoConfig.db,
        mongoConfig.password.toCharArray());
    MongoClientOptions options = MongoClientOptions.builder().sslEnabled(false).build();
    this.mongocli = new MongoClient(new ServerAddress(mongoConfig.host, mongoConfig.port),
        Arrays.asList(credential),
        options);
  }


  @Override
  public void start() throws Exception {

  }

  @Override
  public void stop() throws Exception {
    this.mongo.close();
  }

  public Mongo getMongo() {
    return mongo;
  }

  public DB getDb() {
    return db;
  }
}
