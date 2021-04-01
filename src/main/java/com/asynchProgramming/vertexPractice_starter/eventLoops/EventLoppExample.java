package com.asynchProgramming.vertexPractice_starter.eventLoops;

import io.vertx.core.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/** @Author chandra sekhar Polavarapu */
public class EventLoppExample extends AbstractVerticle {
  public static void main(String[] args) {
    var vertx =
        Vertx.vertx(
            new VertxOptions()
                .setMaxEventLoopExecuteTime(500)
                .setMaxEventLoopExecuteTimeUnit(TimeUnit.MILLISECONDS)
                .setBlockedThreadCheckInterval(1)
                .setBlockedThreadCheckIntervalUnit(TimeUnit.SECONDS));
    vertx.deployVerticle(EventLoppExample.class.getName(), new DeploymentOptions().setInstances(4));
  }

  Logger LOGGER = LoggerFactory.getLogger(EventLoppExample.class);

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    LOGGER.debug("start {}", getClass().getName());
    startPromise.complete();
    // Do not do this inside a verticle. Its a blocking code.
    Thread.sleep(5000);
  }
}
