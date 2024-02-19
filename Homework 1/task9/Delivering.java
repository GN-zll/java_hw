package task9;

public class Delivering implements Runnable {

  private final Order order;

  public Delivering(Order order) {
    this.order = order;
  }

  @Override
  public void run() {
    String name = Thread.currentThread().getName();
    try {
      System.out.println("             " + name + " START DELIVERED " + order + "\n");
      order.delivery();
      System.out.println("             " + name + " DELIVERED  " + order + "\n");
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
