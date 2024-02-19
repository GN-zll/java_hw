package task9;

public class Cooking implements Runnable {

  @Override
  public void run() {
    String name = Thread.currentThread().getName();
    while (Main.flagCook) {
      Order order = Main.queue.poll();
      if (order != null) {
        try {
          System.out.println("      " + name + " START СOOK " + order + "\n");
          if (order.cook()) {
            System.out.println("      " + name + " СOOKED " + order + "\n");
            Main.deliverers.submit(new Delivering(order));
          }
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    }
  }

}
