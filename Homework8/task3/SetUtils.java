package task3;

import java.util.HashSet;
import java.util.Set;

public class SetUtils {

  public static void main(String[] args) {
    Set<Integer> firstSet = Set.of(1, 2);
    Set<Integer> secondSet = Set.of(2, 1);
    System.out.println(SetUtils.intersection(firstSet, secondSet));
  }

  public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
    Set<E> s = new HashSet<>(s1);
    if (s2.isEmpty()) {
      return s;
    }
    s.addAll(s2);
    return s;
  }

  public static <E> Set<E> intersection(Set<? extends E> s1, Set<? extends E> s2) {
    Set<E> s = new HashSet<>(s1);
    if (s2.isEmpty()) {
      return new HashSet<>();
    }
    s.retainAll(s2);
    return s;
  }

  public static <E> Set<E> difference(Set<? extends E> s1, Set<? extends E> s2) {
    Set<E> s = new HashSet<>(s1);
    if (s2.isEmpty()) {
      return s;
    }
    s.removeAll(s2);
    return s;
  }

  public static <E> Set<E> symmetricDifference(Set<? extends E> s1, Set<? extends E> s2) {
    return difference(union(s1, s2), intersection(s1, s2));
  }
}
