package Homework2;

public class Main {
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

        Parrot myParrot = new Parrot(
                "parrot",
                1,
                2,
                "Men",
                "Russia",
                false);

        Cat myCat = new Cat(
                "Dog",
                1,
                2,
                "Women",
                "Russia",
                Cat.Feed.Expensive);

        Dog myDog = new Dog(
                "parrot",
                1,
                2,
                "Men",
                "Russia",
                Dog.Feed.Expensive);

        Pet[] animals = new Pet[]{myDog, myCat, myParrot};

        for (int i = 0; i < animals.length; ++i) {
            animals[i].say();
            if (animals[i] instanceof Cat) {
                ((Cat) animals[i]).walk();
            }
            ;
            if (animals[i] instanceof Dog) {
                ((Dog) animals[i]).walk();
            }
            ;
            if (animals[i] instanceof Parrot) {
                ((Parrot) animals[i]).fly();
            }
            ;
        }


    }
}
