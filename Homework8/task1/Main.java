package task1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class Main {
  public static List<Integer> findPrimes(int n) {
    HashSet<Integer> set = new HashSet<>(n);
    for (int i = 2; i <= n; ++i) {
      set.add(i);
    }
    int p = 2;
    while (p * p <= n) {
      int k = p;
      while (p * k <= n) {
        set.remove(k++ * p);
      }
      int finalP = p;
      Optional<Integer> optionalP = set.stream().filter((x) -> x > finalP).min(Comparator.naturalOrder());
      if(optionalP.isPresent()) {
        p = optionalP.get();
      } else {
        break;
      }
    }
    return set.stream().toList();
  }
}
