package task3;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

  public static void main(String[] args) {
    Function<String, String> sayHello = saySmth("Hello");
    System.out.println(sayHello.apply("Alice")); // Выведет "Hello, Alice!"
  }

  static Function<String, String> saySmth(String word) {
    return curry((String a, String b) -> a.concat(", " + b + "!")).apply(word);
  }

  static <A, B, C> Function<A, Function<B, C>> curry(BiFunction<A, B, C> fn) {
    return a -> b -> fn.apply(a, b);
  }
}
