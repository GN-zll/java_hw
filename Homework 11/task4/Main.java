package task4;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

  public static void main(String[] args) {
    processElements(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9), (Integer x) -> x % 2 == 0, Object::toString,
        String::concat).ifPresent(System.out::println);
  }

  public static <T, R> Optional<R> processElements(List<T> elements, Predicate<T> predicate,
      Function<T, R> mapper, BinaryOperator<R> operator) {
    return elements.stream()
        .filter(predicate)
        .map(mapper)
        .reduce(operator);
  }

}
