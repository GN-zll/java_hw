package Homework2;

import java.util.Objects;

public class intHolder {
    int x;

    public intHolder(int x) {
        this.x = x;
    }

    public intHolder() {
        this.x = 0;
    }

    public static intHolder valueOf(int x) {
        return new intHolder(x);
    }

    public void is(int new_x) {
        x = new_x;
    }

    public static intHolder sum(intHolder a, intHolder b) {
        return new intHolder(a.x + b.x);
    }

    public static intHolder sub(intHolder a, intHolder b) {
        return new intHolder(a.x - b.x);
    }

    public static intHolder mult(intHolder a, intHolder b) {
        return new intHolder(a.x * b.x);
    }

    public static intHolder div(intHolder a, intHolder b) {
        return new intHolder(a.x / b.x);
    }

    public static intHolder rem(intHolder a, intHolder b) {
        return new intHolder(a.x % b.x);
    }

    public static void swap(intHolder i, intHolder j) {
        intHolder g = intHolder.valueOf(i.x);
        i.x = j.x;
        j.x = g.x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        intHolder hold = (intHolder) o;
        return x == hold.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x);
    }
}
