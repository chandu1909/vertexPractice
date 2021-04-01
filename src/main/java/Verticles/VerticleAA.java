package Verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

/** @Author chandra sekhar Polavarapu */
public class VerticleAA extends AbstractVerticle {
  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    System.out.println("start " + getClass().getName());
    startPromise.complete();
  }
}
