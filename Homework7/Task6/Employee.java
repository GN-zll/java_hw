package Task6;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {

  private String name;
  private String surname;
  private String city;
  private int age;
  private int salary;

  public Employee(String name, String surname, String city, int age, int salary) {
    this.name = name;
    this.surname = surname;
    this.city = city;
    this.age = age;
    this.salary = salary;
  }

  public Employee(String name, int age) {
    this(name, "", "", age, 0);
  }


  public static final Comparator<Employee> AGE_SALARY_COMPARATOR = new Comparator<Employee>() {
    @Override
    public int compare(Employee o1, Employee o2) {
      return o1.age == o2.age ? Integer.compare(o1.salary, o2.salary)
          : Integer.compare(o1.age, o2.age);
    }
  };
  public static final Comparator<Employee> PASSPORT_COMPARATOR = new Comparator<Employee>() {
    @Override
    public int compare(Employee o1, Employee o2) {
      if(o1.name.equals(o2.name)){
        if(o1.surname.equals(o2.surname)){
          return o1.city.compareTo(o2.city);
        }
        return o1.surname.compareTo(o2.surname);
      }
      return o1.name.compareTo(o2.name);
    }
  };
  public static final Comparator<Employee> FULL_COMPARATOR = new Comparator<Employee>() {
    @Override
    public int compare(Employee o1, Employee o2) {
      if(o1.name.equals(o2.name)){
        if(o1.surname.equals(o2.surname)){
          if(o1.city.equals(o2.city)){
            if(o1.age == o2.age){
              return Integer.compare(o1.salary, o2.salary);
            }
            return Integer.compare(o1.age, o2.age);
          }
          return o1.city.compareTo(o2.city);
        }
        return o1.surname.compareTo(o2.surname);
      }
      return o1.name.compareTo(o2.name);
    }
  };;

  @Override
  public int compareTo(Employee o) {
    return name.equalsIgnoreCase(o.name) ? Integer.compare(age, o.age)
        : name.toLowerCase().compareTo(o.name.toLowerCase());
  }
}
