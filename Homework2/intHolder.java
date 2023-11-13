package Homework2;

import java.util.Objects;

public class intHolder {

  private int x;

  public intHolder(int x) {
    this.x = x;
  }

  public intHolder() {
    this.x = 0;
  }

  public static intHolder valueOf(int x) {
    return new intHolder(x);
  }


  public void sum(intHolder a) {
    x = x + a.x;
  }

  public void sub(intHolder a) {
    x = x - a.x;
  }

  public void mult(intHolder a) {
    x = x * a.x;
  }
  public void div(intHolder a) {
    x = x / a.x;
  }
  public void rem(intHolder a) {
    x = x % a.x;
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
