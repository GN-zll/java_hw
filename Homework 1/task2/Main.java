package task2;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    PrinterThread printer1 = new PrinterThread("111111111", 20);
    PrinterThread printer2 = new PrinterThread("222222", 20);
    PrinterThread printer3 = new PrinterThread("333", 20);

    Thread thread1 = new Thread(printer1);
    Thread thread2 = new Thread(printer2);
    Thread thread3 = new Thread(printer3);

    thread1.start();
    thread2.start();
    thread3.start();

    thread1.join();
    thread2.join();
    thread3.join();
  }

  private static class PrinterThread implements Runnable {

    private final String name;
    private final int amount;

    private PrinterThread(String name, int amount) {
      this.name = name;
      this.amount = amount;
    }

    @Override
    public void run() {
      for (int i = 0; i < amount; ++i) {
        System.out.println(name);
      }
    }
  }
}
