package task1;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

  public static void main(String[] args) {
    Function<Integer, Integer> mult2 = bind((a, b) -> a * b, 2);
    System.out.println(mult2.apply(10));
  }

  static <A, B, C> Function<B, C> bind(BiFunction<A, B, C> fn, A a) {
    return b -> fn.apply(a, b);
  }
}
