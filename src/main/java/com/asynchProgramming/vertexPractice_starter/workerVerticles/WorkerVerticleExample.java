package com.asynchProgramming.vertexPractice_starter.workerVerticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** @Author chandra sekhar Polavarapu */
public class WorkerVerticleExample extends AbstractVerticle {
  private static final Logger LOGGER = LoggerFactory.getLogger(WorkerVerticleExample.class);

  public static void main(String[] args) {
    var vertx = Vertx.vertx();
    vertx.deployVerticle(new WorkerVerticleExample());
  }

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    vertx.deployVerticle(
        new WorkerVerticle(),
        new DeploymentOptions()
            .setWorker(true)
            .setWorkerPoolSize(1)
            .setWorkerPoolName(
                "my-worker-verticle")); // this configuration allows the verticle to get deployed as
    // worker verticle
    startPromise.complete();
    executeBlockingCode();
  }

  private void executeBlockingCode() {
    vertx.executeBlocking(
        event -> {
          LOGGER.debug("Executing blocking code..!");
          try {
            Thread.sleep(5000);
            event.complete("NOT force failing");
          } catch (InterruptedException e) {
            LOGGER.error("Failed ", e);
            event.fail(e);
          }
        },
        result -> {
          if (result.succeeded()) {
            LOGGER.debug("Blocking call done");
          } else {
            LOGGER.debug("BLocking call failed due to: ", result.cause());
          }
        });
  }
}
