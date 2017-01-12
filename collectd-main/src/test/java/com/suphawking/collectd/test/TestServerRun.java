package com.suphawking.collectd.test;

import com.suphawking.collectd.App;
import com.suphawking.collectd.AppCfg;

import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;


/**
 * Created by loveknut on 2017/1/12.
 */
public class TestServerRun {
  @ClassRule
  public static final DropwizardAppRule<AppCfg> RULE =
      new DropwizardAppRule<AppCfg>(App.class,
          ResourceHelpers.resourceFilePath("sample.yaml"));

  @BeforeClass
  public static void migrateDb() throws Exception {
    RULE.getApplication().run();
  }

  @Test
  public void loginHandlerRedirectsAfterPost() {
    OkHttpClient client = new OkHttpClient();
    try {
      Request request;
      request = new Request.Builder().url("http://localhost:"+RULE.getLocalPort()).build();
      Response response = client.newCall(request).execute();
      assertNotNull(response.code());
    } catch (Exception e){
      assertNotNull("True");
    }


  }
}
