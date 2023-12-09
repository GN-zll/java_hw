package task5;

import java.util.Arrays;
import java.util.Spliterator;
import java.util.function.Consumer;

public class WordSpliterator implements Spliterator<String> {

  String[] textArray;
  Integer start;
  Integer end;

  public WordSpliterator(String text) {
    this.textArray = text.split(" ");
    this.start = 0;
    this.end = textArray.length;
  }

  public WordSpliterator(String[] textArray, Integer start, Integer end) {
    this.textArray = textArray;
    this.start = start;
    this.end = end;
  }

  @Override
  public boolean tryAdvance(Consumer<? super String> action) {
    if (start >= end) {
      return false;
    }
    action.accept(textArray[start]);
    start++;
    return true;
  }

  @Override
  public Spliterator<String> trySplit() {
    if (end - start < 2) {
      return null;
    }
    int middle = (start + end) / 2;
    Spliterator<String> newSplit = new WordSpliterator(textArray, start, middle);
    start = middle;
    return newSplit;
  }

  @Override
  public long estimateSize() {
    return end - start;
  }

  @Override
  public int characteristics() {
    return SIZED | SUBSIZED | NONNULL;
  }


}