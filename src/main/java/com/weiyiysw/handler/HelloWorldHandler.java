package com.weiyiysw.handler;

import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;


/**
 * @author yishiwei, Date 2017/8/2.
 */
public class HelloWorldHandler implements Handler<RoutingContext> {

  /**
   * Something has happened, so handle it.
   *
   * @param event the event to handle
   */
  @Override
  public void handle(RoutingContext event) {
    HttpServerResponse response = event.response();
    response.putHeader("content-type", "text/plain");

    // Write to the response and end it
    response.end("Hello World from Vert.x-Web!");
  }
}
