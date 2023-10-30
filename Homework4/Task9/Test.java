package Homework4.Task9;

public class Test {
  public static void main(String[] args) {
    try {
      int[] m = new int[2];
      m[8] = 5;
    } catch (ArrayIndexOutOfBoundsException e) {
      System.err.println("error :(");
    }
  }
}
