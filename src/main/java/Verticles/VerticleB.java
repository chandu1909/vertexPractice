package Verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

/** @Author chandra sekhar Polavarapu */
public class VerticleB extends AbstractVerticle {
  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    System.out.println("start " + getClass().getName());
    vertx.deployVerticle(new VerticleAB());
    startPromise.complete();
  }
}
