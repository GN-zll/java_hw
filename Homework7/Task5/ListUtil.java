package Task5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListUtil {

  public static List<Integer> medianSort(List<Integer> list) {
    ArrayList<Integer> listSort = new ArrayList<>(list);
    if (!listSort.isEmpty()) {
      Collections.sort(listSort);
      int median;
      if (listSort.size() % 2 == 1) {
        median = listSort.get((listSort.size() - 1) / 2);
      } else {
        median =
            (listSort.get((listSort.size() - 1) / 2) + listSort.get(listSort.size() / 2)) / 2;
      }
      listSort.sort(Comparator.comparingInt(x -> Math.abs((int) x - median))
          .thenComparing(Comparator.comparingInt(x -> (int) x)));
    }
    return listSort;
  }

}