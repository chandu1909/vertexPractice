package com.asynchProgramming.vertexPractice_starter.eventbus;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author chandra sekhar Polavarapu
 */
public class RequestResponseExaple {

  public static void main(String[] args) {
    var vertx = Vertx.vertx();
    vertx.deployVerticle(new RequestVerticle());
    vertx.deployVerticle(new ResponseVerticle());
  }
}

class RequestVerticle extends AbstractVerticle{

  public static final String MY_REQUEST_ADDRESS = "my.request.address";
  public static final String ADDRESS = MY_REQUEST_ADDRESS;
  private static Logger LOGGER = LoggerFactory.getLogger(RequestVerticle.class);
  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    startPromise.complete();
    var eventBus = vertx.eventBus();
    final String message = "Hello World..! ";
    LOGGER.debug("sending message {}",message);
    eventBus.request(ADDRESS,message, reply->{
      LOGGER.debug("message {}",reply.result().body());
    });
  }
}

class ResponseVerticle extends AbstractVerticle{
  private static Logger LOGGER  = LoggerFactory.getLogger(ResponseVerticle.class);
  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    startPromise.complete();
    vertx.eventBus().consumer(RequestVerticle.ADDRESS, message->{
      LOGGER.debug("Received message: {}",message.body());
      message.reply("Received your message. Thank You !");
    });

  }
}
