package Homework6.Task3;

public class Main {

  public static void main(String[] args) {
    Pair<Integer> pair = new Pair<>(34, 100);
    assert pair.getLeft() == 34;
    assert pair.getRight() == 100;
    pair.setLeft(2);
    pair.setRight(10);
    assert pair.getLeft() == 2;
    assert pair.getRight() == 10;
    assert pair.max() == 10;
    assert pair.min() == 2;
  }
}
