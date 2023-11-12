package Task3;

import java.util.AbstractList;
import java.util.List;

public class ListUtil {

  public static List<Integer> rangeList(int from, int to) {
    return new AbstractList<>() {

      @Override
      public Integer get(int index) {
        if (from + index >= to) {
          throw new IndexOutOfBoundsException();
        } else {
          return from + index;
        }
      }

      @Override
      public int size() {
        return to - from;
      }

      @Override
      public int indexOf(Object o) {
        return contains(o) ? ((int) o - from) : -1;
      }

      @Override
      public int lastIndexOf(Object o) {
        return contains(o) ? ((int) o - from) : -1;
      }

      @Override
      public boolean contains(Object o) {
        return from <= (int) o && (int) o < to;
      }
    };
  }

  public static List<Integer> medianSort(List<Integer> list) {
    return null;
  }

}