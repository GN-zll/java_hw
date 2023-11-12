package Task1;


public class MyLinkedList<E> implements List<E>, Iterable<E> {

  private Node<E> head;
  private Node<E> tail;

  public MyLinkedList(Node<E> head, Node<E> tail) {
    this.head = head;
    this.tail = tail;
  }

  public MyLinkedList() {
  }

  public void add(E el) {
    Node<E> newNode = new Node<>(el);

    if (head == null) {
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode;
      newNode.prev = tail;
      tail = newNode;
    }
  }

  public void insertHead(E el) {
    if (head == null) {
      add(el);
    } else {
      Node<E> newNode = new Node<>(el);
      head.prev = newNode;
      newNode.next = head;
      head = newNode;
    }
  }

  public void printList() {
    Node<E> current = head;
    System.out.print("[");
    while (current.next != null) {
      System.out.print(current.value + ", ");
      current = current.next;
    }
    System.out.println(current.value + "]");
  }

  @Override
  public void add(int index, E el) {
    Node<E> newNode = new Node<>(el);

    if (index < 0) {
      throw new ArrayIndexOutOfBoundsException();
    }
    if (head == null) {
      if (index != 0) {
        throw new ArrayIndexOutOfBoundsException();
      }
      head = newNode;
      tail = newNode;
    } else {
      int size = size();
      if (size < index) {
        throw new ArrayIndexOutOfBoundsException();
      } else if (index <= size / 2) {
        Node<E> current = head;
        if (index == 0) {
          insertHead(el);
        } else {
          for (int i = 0; i < index - 1; ++i) {
            current = current.next;
          }
          newNode.next = current.next;
          newNode.prev = current;
          current.next.prev = newNode;
          current.next = newNode;
        }
      } else {
        Node<E> current = tail;
        if (index == size) {
          add(el);
        } else {
          for (int i = size - 1; i > index; --i) {
            current = current.prev;
          }
          newNode.next = current;
          newNode.prev = current.prev;
          current.prev.next = newNode;
          current.prev = newNode;
        }
      }
    }
  }

  @Override
  public E get(int index) {
    if (index < 0) {
      throw new ArrayIndexOutOfBoundsException();
    }
    if (head == null) {
      throw new ArrayIndexOutOfBoundsException();
    } else {
      int size = size();
      if (size <= index) {
        throw new ArrayIndexOutOfBoundsException();
      } else if (index <= size / 2) {
        Node<E> current = head;
        for (int i = 0; i < index; ++i) {
          current = current.next;
        }
        return current.value;
      } else {
        Node<E> current = tail;
        for (int i = size - 1; i > index; --i) {
          current = current.prev;
        }
        return current.value;
      }
    }
  }

  @Override
  public void remove(int index) {
    int size = size();
    if (index < 0) {
      throw new ArrayIndexOutOfBoundsException();
    }
    if (head == null) {
      throw new ArrayIndexOutOfBoundsException();
    } else if (size == 1) {
      if (index != 0) {
        throw new ArrayIndexOutOfBoundsException();
      }
      head = null;
      tail = null;
    } else {
      if (size <= index) {
        throw new ArrayIndexOutOfBoundsException();
      } else if (index <= size / 2) {
        if (index == 0) {
          head = head.next;
          head.prev = null;
        } else if (index == size - 1) {
          tail = tail.prev;
          tail.next = null;
        } else {
          Node<E> current = head;
          for (int i = 0; i < index - 1; ++i) {
            current = current.next;
          }
          System.out.println(current.value);
          current.next = current.next.next;
          current.next.prev = current;
        }
      } else {
        if (index == size - 1) {
          tail = tail.prev;
          tail.next = null;
        } else {
          Node<E> current = tail;
          for (int i = size - 1; i > index + 1; --i) {
            current = current.prev;
          }
          System.out.println(current.value);
          current.prev = current.prev.prev;
          current.prev.next = current;
        }

      }
    }
  }

  @Override
  public int size() {
    if (isEmpty()) {
      return 0;
    } else {
      Node<E> current = head;
      int sizeList = 1;
      while (current.next != null) {
        sizeList++;
        current = current.next;
      }
      return sizeList;
    }
  }

  @Override
  public boolean isEmpty() {
    return head == null;
  }

  public E getFirst() {
    if (head == null) {
      return null;
    }
    return head.value;
  }

  public E getLast() {
    if (tail == null) {
      return null;
    }
    return tail.value;
  }

  public void clear() {
    head = null;
    tail = null;
  }

  @Override
  public MyIterator<E> iterator() {
    return new MyIterator<>(new MyLinkedList<>(head, tail));
  }

  public static class Node<T> {

    T value;
    Node<T> next;
    Node<T> prev;

    public Node(T value) {
      this.value = value;
    }
  }
}