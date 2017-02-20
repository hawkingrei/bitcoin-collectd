package com.suphawking.collectd;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import com.suphawking.collectd.db.MongoConfiguration;

import io.dropwizard.lifecycle.Managed;

import java.util.Arrays;

/**
 * Created by loveknut on 2017/2/19.
 */
public class MongoManaged implements Managed {


  private MongoClient mongocli;
  private MongoCredential credential;
  private MongoDatabase db;

  public MongoManaged(MongoConfiguration mongoConfig) throws Exception {
    credential = MongoCredential.createCredential(mongoConfig.user, mongoConfig.db,
        mongoConfig.password.toCharArray());
    MongoClientOptions options = MongoClientOptions.builder().sslEnabled(false).build();
    mongocli = new MongoClient(new ServerAddress(mongoConfig.host, mongoConfig.port),
        Arrays.asList(credential),
        options);
    db = mongocli.getDatabase("test");
  }


  @Override
  public void start() throws Exception {

  }

  @Override
  public void stop() throws Exception {
    mongocli.close();
  }

  public MongoClient getMongo() {
    return mongocli;
  }

  public MongoDatabase getDb() {
    return db;
  }
}
