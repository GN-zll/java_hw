package task6;

import java.util.concurrent.atomic.AtomicInteger;

public class Chest {

  private AtomicInteger gold = new AtomicInteger();

  public void addGold(int amount) {
    gold.addAndGet(amount);
  }

  public int getGold() {
    return gold.get();
  }
}
