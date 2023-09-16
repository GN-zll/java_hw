package Homework2;

public class main {
    public static void main(String[] args) {
        intHolder hold1 = new intHolder(20);
        intHolder hold2 = intHolder.valueOf(30);
        intHolder.swap(hold1, hold2);
        System.out.println(hold1.x);
        System.out.println(hold2.x);
        System.out.println(intHolder.mult(hold1,hold2).x);


    }
}
