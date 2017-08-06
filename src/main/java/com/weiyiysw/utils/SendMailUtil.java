package com.weiyiysw.utils;

import io.vertx.core.Vertx;
import io.vertx.ext.mail.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * @author yishiwei, Date 2017/8/5.
 */
public enum SendMailUtil {

  INSTANCE;

  private static Logger logger = LoggerFactory.getLogger(SendMailUtil.class);

  private static MailClient mailClient;

//  private static String HOST = "smtp.exmail.qq.com"; // 腾讯企业邮
  private static String HOST = "smtp.163.com"; // 163邮箱
  private static String USERNAME = "weiyiysw@163.com";
  private static String PASSWORD = "azxknkysw1993";

  /**
   * 如果使用的HOST，没有开启SSL服务，则无需打开注释的两行
   * 默认 SMTP 端口是25，如果配置的端口有变化，请自行调用setPort设置
   * 邮箱都需要登录，请设置用户名和密码
   *
   * @param vertx vertx instance, use the same instance
   * @return MailClient instance
   */
  public MailClient getMailClient(Vertx vertx) {
    if (mailClient == null) {
      MailConfig mailConfig = new MailConfig();
      mailConfig.setHostname(HOST);
//      mailConfig.setPort(587);
//      mailConfig.setStarttls(StartTLSOptions.REQUIRED);
      mailConfig.setLogin(LoginOption.REQUIRED);
      mailConfig.setUsername(USERNAME);
      mailConfig.setPassword(PASSWORD);

      mailClient = MailClient.createNonShared(vertx, mailConfig);
    }

    return mailClient;
  }

  /**
   * send mail test
   */
  public static void sendMailTest(MailClient mailClient) {
    MailMessage message = new MailMessage();
    message.setFrom(USERNAME);
    message.setTo("1612268188@qq.com");
    message.setText("This is test Optional!");
    message.setSubject("Test");

    mailClient.sendMail(message, result -> {
      if (result.succeeded()) {
        logger.info("send mail success!");
      } else {
        logger.error("send mail failed! cause {}", result.cause());
      }
    });
  }
}
