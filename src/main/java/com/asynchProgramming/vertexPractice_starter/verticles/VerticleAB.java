package com.asynchProgramming.vertexPractice_starter.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** @Author chandra sekhar Polavarapu */
public class VerticleAB extends AbstractVerticle {
  private static final Logger LOGGER = LoggerFactory.getLogger(VerticleB.class);
  @Override
  public void start(Promise<Void> startPromise) throws Exception {
   LOGGER.debug("start {}", getClass().getName());
    startPromise.complete();
  }
}
