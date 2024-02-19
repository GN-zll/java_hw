package task8;

import java.util.concurrent.TimeUnit;

public class Main {

  public static volatile boolean flagGenerate = true;
  public static volatile boolean flagUnload = true;

  public static final Tunnel tunnel = new Tunnel();

  public static void main(String[] args) throws InterruptedException {
    Generator generator = new Generator();
    Thread generatorThread = new Thread(generator);

    Pier breadPier = new Pier(Cargo.BREAD);
    Pier clothesPier = new Pier(Cargo.CLOTHES);
    Pier bananasPier = new Pier(Cargo.BANANAS);

    generatorThread.start();
    breadPier.start();
    clothesPier.start();
    bananasPier.start();
    TimeUnit.SECONDS.sleep(30);
    flagGenerate = false;
    System.out.println("--------TIME TO END---------");
    synchronized (tunnel) {
      tunnel.notifyAll();
      while (flagUnload) {
        tunnel.wait();
        if (tunnel.getTunnel().isEmpty()) {
          flagUnload = false;
        }
      }
      tunnel.notifyAll();
    }
  }


}
