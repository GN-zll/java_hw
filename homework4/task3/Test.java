package homework4.task3;

public class Test {

  public static void main(String[] args) {
    print(() -> {System.out.print("Hello world");});
  }
  static void print (Printable printable) {

    printable.print();
  }
}
