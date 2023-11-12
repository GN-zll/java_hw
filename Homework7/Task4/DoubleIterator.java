package Task4;

import java.util.Iterator;

public class DoubleIterator<T> implements Iterator<T> {

  Iterator<T> first;
  Iterator<T> second;
  Boolean iteratorState = false;

  public DoubleIterator(Iterator<T> first, Iterator<T> second) {
    this.first = first;
    this.second = second;
  }

  @Override
  public boolean hasNext() {
    if (first.hasNext()) {
      return true;
    }
    return second.hasNext();
  }

  @Override
  public T next() {
    if (first.hasNext()) {
      return first.next();
    }
    return second.next();
  }
}
