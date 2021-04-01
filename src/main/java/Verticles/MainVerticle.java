package Verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

import java.util.UUID;

/**
 * @Author chandra sekhar Polavarapu
 */
public class MainVerticle extends AbstractVerticle {
  public static void main(String[] args) {
    Vertx vertex = Vertx.vertx();
    vertex.deployVerticle(new MainVerticle());
  }

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    System.out.println("start " +getClass().getName());
    vertx.deployVerticle(new VerticleA());
    vertx.deployVerticle(new VerticleB());
    vertx.deployVerticle(VerticleN.class.getName(),
      new DeploymentOptions().setInstances(4)
    .setConfig(new JsonObject().put("id", UUID.randomUUID().toString())
    .put("name",VerticleN.class.getName())));
    startPromise.complete();
  }
}
