package task4;

public class Main {

  private static volatile boolean flag = true;
  private static final Object lock = new Object();

  public static void main(String[] args) throws InterruptedException {
    WriterOddThread writerOdd = new WriterOddThread();
    WriterEvenThread writerEven = new WriterEvenThread();

    Thread oddThread = new Thread(writerOdd);
    Thread evenThread = new Thread(writerEven);
    oddThread.start();
    evenThread.start();

    oddThread.join();
    evenThread.join();
  }

  private static class WriterEvenThread implements Runnable {

    @Override
    public void run() {
      for (int i = 0; i < 5; ++i) {
        synchronized (lock) {
          while (flag) {
            try {
              lock.wait();
            } catch (InterruptedException e) {
              throw new RuntimeException(e);
            }
          }
          System.out.println(2 * i + 2);
          flag = true;
          lock.notifyAll();
        }
      }
    }
  }

  private static class WriterOddThread implements Runnable {

    @Override
    public synchronized void run() {
      for (int i = 0; i < 5; ++i) {
        synchronized (lock) {
          while (!flag) {
            try {
              lock.wait();
            } catch (InterruptedException e) {
              throw new RuntimeException(e);
            }
          }
          System.out.println(2 * i + 1);
          flag = false;
          lock.notifyAll();
        }
      }
    }
  }
}
