package Homework6.Task4;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    String[] arr = {"1", "2", "3", "4"};
    assert minMax(arr).getLeft().equals("1");
    assert minMax(arr).getRight().equals("4");
  }

  public static<T extends Comparable<T>> Pair<T> minMax(T[] arr) {
    Arrays.sort(arr);
    return new Pair<>(arr[0], arr[arr.length - 1]);
  }

}
