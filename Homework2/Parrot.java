package Homework2;

public class Parrot extends Pet {
    private final String country;
    private boolean hasDocuments;

    @Override
    public void say() {
        System.out.println("karamba!");
    }

    public Parrot(String name, int weight, int age, String owner, String country, boolean hasDocuments) {
        super(name, weight, age, owner);
        this.country = country;
        this.hasDocuments = hasDocuments;
    }

    public void fly() {
        System.out.println(getName() + "flew away but promised to return in " + Math.random() * 60 + "minutes");
    }
}
