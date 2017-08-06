package com.weiyiysw.verticles;

import com.weiyiysw.handler.HelloWorldHandler;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

/**
 * @author yishiwei, Date 2017/8/2.
 */
public class BackManagmentUIVerticle extends AbstractVerticle {

  @Override
  public void start() {
    HttpServer server = vertx.createHttpServer();

    Router router = Router.router(vertx);

//    router.route().handler(routingContext -> {
//      HttpServerResponse response = routingContext.response();
//      response.putHeader("content-type", "text/plain");
//
//      // Write to the response and end it
//      response.end("Hello World from Vert.x-Web!");
//    });

    router.route().handler(new HelloWorldHandler());

    server.requestHandler(router::accept).listen(21437);
  }
}
