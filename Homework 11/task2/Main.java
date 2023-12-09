package task2;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

  public static void main(String[] args) {
    Function<String, String> substring05 = bind(String::substring, );
    System.out.println(substring05.apply("123456789"));
  }

  static <A, B, C> Function<B, C> bind(BiFunction<A, B, C> fn, A a) {
    return b -> fn.apply(a, b);
  }
}
