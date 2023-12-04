package Homework6.Task5;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main {

  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5);
    assert map(numbers, x -> 2 * x).equals(List.of(2, 4, 6, 8, 10)) : "Do not work! :(";
  }

  public static <T, R> List<R> map(List<T> listT, Function<T, R> function) {
    List<R> listR = new ArrayList<>();
    for (T i : listT) {
      listR.add(function.apply(i));
    }
    return listR;
  }
}
