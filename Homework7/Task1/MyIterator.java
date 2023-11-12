package Task1;

import Task1.MyLinkedList.Node;
import java.util.Iterator;

public class MyIterator<T> implements Iterator<T> {

  private MyLinkedList<T> myLinkedList;
  private int elem;

  public MyIterator(MyLinkedList<T> myLinkedList) {
    this.myLinkedList = myLinkedList;
    elem = 0;
  }

  @Override
  public boolean hasNext() {
    return elem < myLinkedList.size();
  }

  @Override
  public T next() {
    return myLinkedList.get(elem++);
  }

  public boolean hasPrevious() {
    return elem > 0;
  }

  public T previous() {
    return myLinkedList.get(--elem);
  }
}
