package Task1;

import java.util.Iterator;

public class Test {

  public static void main(String[] args) {
    MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
    System.out.println(myLinkedList.getFirst());
    System.out.println(myLinkedList.size());
    System.out.println(myLinkedList.isEmpty());
    myLinkedList.add(1);
    myLinkedList.add(2);
    myLinkedList.add(4);
    myLinkedList.printList();
    System.out.println(myLinkedList.size());
    System.out.println(myLinkedList.isEmpty());
    myLinkedList.add(0, 0);
    myLinkedList.add(3, 3);
    myLinkedList.add(5, 5);
    myLinkedList.add(6);
    myLinkedList.add(7);
    myLinkedList.add(8);
    myLinkedList.add(9);
    myLinkedList.add(10);
    myLinkedList.printList();
    System.out.println(myLinkedList.get(10));
    myLinkedList.remove(10);
    myLinkedList.printList();
    System.out.println(myLinkedList.getFirst());
    System.out.println(myLinkedList.getLast());
    MyIterator<Integer> myListIterator = myLinkedList.iterator();
    while (myListIterator.hasNext()) {
      System.out.println(myListIterator.next());
    }
    while (myListIterator.hasPrevious()) {
      System.out.println(myListIterator.previous());
    }
  }

}
