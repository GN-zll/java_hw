package homework4.task1;

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
          throw new IllegalStateException("Index out of bounce");
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
