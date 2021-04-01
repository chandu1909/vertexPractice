package Verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

/** @Author chandra sekhar Polavarapu */
public class VerticleN extends AbstractVerticle {
  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    System.out.println("start " + getClass().getName() + "with Config " +config().toString());
    startPromise.complete();
  }
}
