package task3;

import java.util.ArrayList;
import java.util.List;

public class Main {

  private static volatile boolean endFlag = false;
  private static final List<Integer> list = new ArrayList<>();

  public static void main(String[] args) throws InterruptedException {
    WriterThread writer = new WriterThread(10);
    PrinterThread printer = new PrinterThread();

    Thread writerThread = new Thread(writer);
    Thread printerThread = new Thread(printer);
    writerThread.start();
    printerThread.start();

    writerThread.join();
    printerThread.join();
  }

  private static class WriterThread implements Runnable {

    private final int size;

    private WriterThread(int size) {
      this.size = size;
    }

    @Override
    public void run() {
      for (int j = 0; j < 10; ++j) {
        synchronized (list) {
          while (endFlag) {
            try {
              list.wait();
            } catch (InterruptedException e) {
              throw new RuntimeException(e);
            }
          }
          for (int i = 0; i < size; ++i) {
            list.add((int) (Math.random() * 100));
          }
          endFlag = true;
          list.notifyAll();
        }
      }
    }
  }

  private static class PrinterThread implements Runnable {

    @Override
    public synchronized void run() {
      for (int i = 0; i < 10; ++i) {
        synchronized (list) {
          while (!endFlag) {
            try {
              list.wait();
            } catch (InterruptedException e) {
              throw new RuntimeException(e);
            }
          }
          System.out.println(list);
          endFlag = false;
          list.clear();
          list.notifyAll();
        }
      }
    }
  }
}
