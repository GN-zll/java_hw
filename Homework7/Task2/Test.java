package Task2;

public class Test {

  public static void main(String[] args) {
    MyDeque<Double> deque = new MyDeque<>();
    deque.addLast(1.0);
    deque.addLast(2.0);
    System.out.println(deque.peekLast());

  }
}
