package task8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Pier extends Thread {

  private final Cargo type;

  public Pier(Cargo type) {
    this.type = type;
  }

  public void unload(Ship ship) throws InterruptedException {
    System.out.println("Starting to unload " + ship.getName() + " type " + ship.getCargo());
    switch (ship.getLoadCapacity()) {
      case 10 -> TimeUnit.SECONDS.sleep(1);
      case 50 -> TimeUnit.SECONDS.sleep(5);
      case 100 -> TimeUnit.SECONDS.sleep(10);
      default -> {
        assert false;
      }
    }
    synchronized (Main.tunnel) {
      Main.tunnel.removeShip(ship);
      Main.tunnel.notifyAll();
    }
    System.out.println(ship.getName() + " unload");
  }

  @Override
  public void run() {
    List<Ship> unloadShipList = new ArrayList<>();
    while (Main.flagUnload) {
      synchronized (Main.tunnel) {
        if (!Main.tunnel.getTunnel().isEmpty()) {
          for (Ship ship : Main.tunnel.getTunnel()) {
            if (ship.getCargo() == type) {
              unloadShipList.add(ship);
            }
          }
        } else {
          System.out.println("tunnel empty");
        }
        if (unloadShipList.isEmpty()) {
          try {
            Main.tunnel.wait();
          } catch (InterruptedException e) {
            throw new RuntimeException(e);

          }
        }
      }
      for (Ship ship : unloadShipList) {
        try {
          unload(ship);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
      unloadShipList.clear();
    }
  }
}
