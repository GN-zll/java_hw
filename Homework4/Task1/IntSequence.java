package Homework4.Task1;

public interface IntSequence {

  Integer next();

  static IntSequence of(int... ints) {
    return new IntSequence() {
      private int index = 0;

      @Override
      public Integer next() {
        if (index < ints.length) {
          return ints[index++];
        } else {
          System.out.print("Index out of bounce");
          return null;
        }
      }
    };
  }

  static IntSequence constant(int c) {
    return new IntSequence() {
      @Override
      public Integer next() {
        return c;
      }
    };
  }

}
