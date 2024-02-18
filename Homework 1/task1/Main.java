package task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  static final int SIZE = 100_000; //the number of numbers in the file

  public static void main(String[] args) throws InterruptedException, IOException {
    //write random numbers to file
    File file = new File("Homework 1/task1/resources/data.txt");

    try (FileWriter fw = new FileWriter(file)) {
      for (int i = 0; i <= SIZE; i++) {
        fw.write(getRandomNumber(-100000, 100000) + " ");
      }
      fw.write("\n");
    }

    //simple
    long startTime = System.currentTimeMillis();
    BufferedReader br = new BufferedReader(new FileReader(file));
    String[] input = br.readLine().split(" ");
    List<Integer> listNumbers = new ArrayList<>();
    for (var number : input) {
      listNumbers.add(Integer.parseInt(number));
    }
    int realMax = Integer.MIN_VALUE;
    int realMin = Integer.MAX_VALUE;
    for (var number : listNumbers) {
      realMax = Math.max(number, realMax);
      realMin = Math.min(number, realMin);
    }
    long endTime = System.currentTimeMillis();
    long simpleTime = endTime - startTime;

    //multithreaded
    FinderThread finder1 = new FinderThread(file, 0, SIZE / 2);
    FinderThread finder2 = new FinderThread(file, SIZE / 2, SIZE);

    Thread thread1 = new Thread(finder1);
    Thread thread2 = new Thread(finder2);

    startTime = System.currentTimeMillis();
    thread1.start();
    thread2.start();

    thread1.join();
    thread2.join();
    endTime = System.currentTimeMillis();
    long multithreadTime = endTime - startTime;

    int threadsMax = Math.max(finder1.getMax(), finder2.getMax());
    int threadsMin = Math.min(finder1.getMin(), finder2.getMin());
    System.out.println("Real max: " + realMax + " Threads max: " + threadsMax);
    System.out.println("Real min: " + realMin + " Threads min: " + threadsMin);
    System.out.println();
    System.out.println("Max equal: " + (realMax == threadsMax));
    System.out.println("Min equal: " + (realMin == threadsMin));
    System.out.println();
    System.out.println("simple Time: " + simpleTime + " ms");
    System.out.println("multi-thread Time: " + multithreadTime + " ms");
  }


  private static class FinderThread implements Runnable {

    private final File numbersFile;
    private final int start;
    private final int end;

    private int max = Integer.MIN_VALUE;
    private int min = Integer.MAX_VALUE;

    private final List<Integer> listNumbers = new ArrayList<>();

    private FinderThread(File numbersFile, int start, int end) {
      this.numbersFile = numbersFile;
      this.start = start;
      this.end = end;
    }

    @Override
    public void run() {
      try {
        BufferedReader br = new BufferedReader(new FileReader(numbersFile));
        List<String> input = Arrays.asList(br.readLine().split(" ")).subList(start, end);
        for (var number : input) {
          listNumbers.add(Integer.parseInt(number));
        }
        for (var number : listNumbers) {
          max = Math.max(number, max);
          min = Math.min(number, min);
        }
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    public int getMax() {
      return max;
    }

    public int getMin() {
      return min;
    }
  }


  private static int getRandomNumber(int a, int b) {
    if (b < a) {
      return getRandomNumber(b, a);
    }
    return a + (int) ((1 + b - a) * Math.random());
  }

}
