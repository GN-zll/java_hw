package Homework4.Task7;

public class Test {

  public static void main(String[] args) {
    try {
    int a = 42 / 0;
    } catch (ArithmeticException e) {
      System.err.println("error :(");
    }
  }

}
