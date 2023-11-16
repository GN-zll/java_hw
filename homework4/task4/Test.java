package homework4.task4;

public class Test {

  public static void main(String[] args) {
    Sign sign = (x) -> {
      if(x > 0){
        System.out.println("Положительное число");
      } else if (x == 0) {
        System.out.println("Ноль");
      } else {
        System.out.println("Отрицательное число");
      }
    };
    sign.determineSign(-1);
  }
}
