package Homework2;

public class Parrot extends Pet {
    private final String country;
    private boolean documents;

    @Override
    public void say() {
        System.out.println("karamba!");
    }

    public Parrot(String name, int weight, int age, String owner, String country, boolean documents) {
        super(name, weight, age, owner);
        this.country = country;
        this.documents = documents;
    }

    public void fly() {
        System.out.println(getName() + "flew away but promised to return in " + Math.random() * 60 + "minutes");
    }
}
