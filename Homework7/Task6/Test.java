package Task6;

public class Test {

  public static void main(String[] args) {
    Employee e1 = new Employee("", "B", "City", 11, 0);
    Employee e2 = new Employee("", "B", "city", 9, 1);
    System.out.println(Employee.PASSPORT_COMPARATOR.compare(e1, e2));
  }
}
