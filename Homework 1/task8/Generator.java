package task8;

import java.util.Random;

public class Generator implements Runnable {

  private int counter;

  private Ship generateShip() {
    int loadCapacity;
    Cargo cargo;
    Random random = new Random();
    switch (random.nextInt(3)) {
      case 0 -> loadCapacity = 10;
      case 1 -> loadCapacity = 50;
      case 2 -> loadCapacity = 100;
      default -> {
        loadCapacity = 10;
        assert false;
      }
    }

    switch (random.nextInt(3)) {
      case 0 -> cargo = Cargo.BREAD;
      case 1 -> cargo = Cargo.CLOTHES;
      case 2 -> cargo = Cargo.BANANAS;
      default -> {
        cargo = Cargo.BANANAS;
        assert false;
      }
    }
    counter++;
    return new Ship("Ship_" + counter, loadCapacity, cargo);
  }

  @Override
  public void run() {
    while (Main.flagGenerate) {
      synchronized (Main.tunnel) {
        if (Main.tunnel.getTunnel().size() < 5) {
          Ship ship = generateShip();
          Main.tunnel.addShip(ship);
          System.out.println(
              ship.getName() + " start with " + ship.getLoadCapacity() + " " + ship.getCargo());
          Main.tunnel.notifyAll();
        } else {
          try {
            Main.tunnel.wait();
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
      }
    }
  }
}
