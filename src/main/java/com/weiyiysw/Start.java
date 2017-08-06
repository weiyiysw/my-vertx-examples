package com.weiyiysw;

import com.weiyiysw.utils.SendMailUtil;
import io.vertx.core.Vertx;
import io.vertx.ext.mail.MailClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yishiwei, Date 2017/8/2.
 */
public class Start {

  private static Logger logger = LoggerFactory.getLogger(Start.class);

  private static Vertx vertx = Vertx.vertx();

  private static Map<String, String> deploymentId = new HashMap<>();

  public static void main(String[] args) {

//    String backManagementUI = "com.weiyiysw.verticles.BackManagmentUIVerticle";
//
//    vertx.deployVerticle(backManagementUI, result -> {
//      if (result.succeeded()) {
//        logger.info("Back Management UI deploy success!");
//
//        if (logger.isDebugEnabled()) {
//          logger.debug("deployment id is {}!", result.result());
//        }
//        deploymentId.put(backManagementUI, result.result());
//      } else {
//        logger.error("Back Management UI deploy fail! {}", result.cause());
//      }
//    });

    MailClient mailClient = SendMailUtil.INSTANCE.getMailClient(vertx);
    SendMailUtil.sendMailTest(mailClient);

    // exit main
    vertx.setTimer(6000, handler -> {
      System.exit(0);
    });
  }
}
