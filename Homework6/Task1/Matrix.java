package Homework6.Task1;

public interface Matrix<T> {
  void add(T element);
  void remove(int row, int column);
  T getEleent(int row, int column);
}
