package com.asynchProgramming.vertexPractice_starter.workerVerticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author chandra sekhar Polavarapu
 */
public class WorkerVerticle extends AbstractVerticle {

  private static Logger LOGGER = LoggerFactory.getLogger(WorkerVerticle.class);

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    LOGGER.debug("Deployed as worker Vertical !");
    Thread.sleep(5000);
    LOGGER.debug("Blocking operation completed.");
  }
}
