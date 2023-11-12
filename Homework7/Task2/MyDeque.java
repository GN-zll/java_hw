package Task2;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Stack;

public class MyDeque<E> implements Deque<E> {

  Stack<E> start = new Stack<>();
  Stack<E> end = new Stack<>();

  public MyDeque() {
  }

  public MyDeque(Stack<E> start, Stack<E> end) {
    this.start = start;
    this.end = end;
  }

  private void startToEnd() {
    while (!start.empty()) {
      end.push(start.peek());
      start.pop();
    }
  }

  private void endToStart() {
    while (!end.empty()) {
      start.push(end.peek());
      end.pop();
    }
  }

  @Override
  public void addFirst(E e) {
    start.push(e);
  }

  @Override
  public void addLast(E e) {
    end.push(e);
  }

  @Override
  public E removeFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    } else {
      if (!start.empty()) {
        E value = start.peek();
        start.pop();
        return value;
      } else {
        endToStart();
        E value = start.peek();
        start.pop();
        return value;
      }
    }
  }

  @Override
  public E removeLast() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    } else {
      if (!end.empty()) {
        E value = end.peek();
        end.pop();
        return value;
      } else {
        startToEnd();
        E value = end.peek();
        end.pop();
        return value;
      }
    }
  }

  @Override
  public E peekFirst() {
    if (isEmpty()) {
      return null;
    } else {
      if (start.empty()) {
        endToStart();
      }
      return start.peek();
    }
  }

  @Override
  public E peekLast() {
    if (isEmpty()) {
      return null;
    } else {
      if (end.empty()) {
        startToEnd();
      }
      return end.peek();
    }
  }

  @Override
  public boolean isEmpty() {
    return start.empty() && end.empty();
  }

  @Override
  public int size() {
    return start.size() + end.size();
  }

  @Override
  public void printDeque() {
    if (end.empty()) {
      System.out.println(Arrays.toString(start.toArray()));
    } else if (start.empty()) {
      System.out.print("[");
      for (int i = end.toArray().length - 1; i > 0; --i) {
        System.out.print(end.toArray()[i] + ", ");
      }
      System.out.println(end.toArray()[0] + "]");
    } else {
      System.out.print("[");
      for (Object i : start.toArray()) {
        System.out.print(i + ", ");
      }
      for (int i = end.toArray().length - 1; i > 0; --i) {
        System.out.print(end.toArray()[i] + ", ");
      }
      System.out.println(end.toArray()[0] + "]");
    }
  }

}
