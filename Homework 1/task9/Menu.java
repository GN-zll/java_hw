package task9;

import java.util.HashMap;

public enum Menu {
  BURGER,
  FRIES,
  PIZZA,
  SHAKE,
  NUGGETS;

  public final static HashMap<Menu, Integer> cookingTimes = new HashMap<>();

  static {
    cookingTimes.put(BURGER, 10);
    cookingTimes.put(FRIES, 5);
    cookingTimes.put(PIZZA, 15);
    cookingTimes.put(SHAKE, 3);
    cookingTimes.put(NUGGETS, 12);
  }
}
