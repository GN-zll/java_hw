package Homework2;

public class Pet {
    private final String name;
    private int weight;
    private int age;
    private String owner;

    public Pet(String name, int weight, int age, String owner) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public void say() {
        System.out.println();
    }

}

