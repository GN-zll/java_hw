package task8;

public class Ship {

  private final String name;
  private final int loadCapacity;
  private final Cargo cargo;

  public Ship(String name, int loadCapacity, Cargo cargo) {
    this.name = name;
    this.loadCapacity = loadCapacity;
    this.cargo = cargo;
  }

  public String getName() {
    return name;
  }

  public int getLoadCapacity() {
    return loadCapacity;
  }

  public Cargo getCargo() {
    return cargo;
  }

}
