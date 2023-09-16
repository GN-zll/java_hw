package Homework2;

public class main {
    public static void main(String[] args) {
        Car myCar = new Car("green", 5, 200, "BMW", 10, 0);
        myCar.info_all();
        myCar.refueling();
        myCar.info();
        myCar.start();
        myCar.move();
        myCar.getMileage();
        myCar.move(123456);
        myCar.info();
    }
}
