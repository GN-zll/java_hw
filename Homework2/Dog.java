package Homework2;

public class Dog extends Pet {

    private final String breed;
    private Feed feed;

    public Dog(String name, int weight, int age, String owner, String breed, Feed feed) {
        super(name, weight, age, owner);
        this.breed = breed;
        this.feed = feed;
    }

    @Override
    public void say() {
        System.out.println("Woof, Woof");
    }

    public void walk() {
        System.out.println("I'm walking with " + getOwner());
    }

    public void walk(String name) {
        System.out.println("I'm walking with " + name);
    }

    enum Feed {
        EXPENSIVE,
        CHEAP
    }
}
