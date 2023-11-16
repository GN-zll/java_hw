package homework4.task8;

public class Test {

    public static void main(String[] args) {
      try {
        String s = null;
        String m = s.toLowerCase();
      } catch (NullPointerException e) {
        System.err.println("error :(");
      }
    }

}
