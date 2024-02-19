package task9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

  public final static ConcurrentLinkedQueue<Order> queue = new ConcurrentLinkedQueue<>();
  public static volatile boolean flagOrder = true;
  public static volatile boolean flagCook = true;
  public static volatile boolean AllEndCook = false;

  private static final int COUNT_CUSTOMERS = 2;
  private static final int COUNT_CHEFS = 2;
  private static final int COUNT_DELIVERERS = 2;

  public static final ExecutorService chefs = Executors.newFixedThreadPool(COUNT_CHEFS);
  public static final ExecutorService customers = Executors.newFixedThreadPool(COUNT_CUSTOMERS);
  public static final ExecutorService deliverers = Executors.newFixedThreadPool(COUNT_DELIVERERS);
  public static final ExecutorService printerQueue = Executors.newSingleThreadExecutor();

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    //запускаем покупателей
    List<CompletableFuture<Void>> customersFutureList = new ArrayList<>();
    for (int i = 0; i < COUNT_CUSTOMERS; ++i) {
      customersFutureList.add(CompletableFuture.runAsync(new Ordering(), customers));
    }
    CompletableFuture<Void> allCustomersFutures = CompletableFuture.allOf(
        customersFutureList.toArray(new CompletableFuture[0]));

    //запускаем поваров
    List<CompletableFuture<Void>> chefsFutureList = new ArrayList<>();
    for (int i = 0; i < COUNT_CHEFS; ++i) {
      chefsFutureList.add(CompletableFuture.runAsync(new Cooking(), chefs));
    }
    CompletableFuture<Void> allChefsFutures = CompletableFuture.allOf(
        chefsFutureList.toArray(new CompletableFuture[0]));

    //запускаем принтер очереди
    printerQueue.submit(() -> {
      while (flagCook || flagOrder) {
        try {
          TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        System.out.println("Order queue: " + queue + "\n");
      }
    });

    TimeUnit.SECONDS.sleep(30);
    flagOrder = false;
    allCustomersFutures.get();
    customers.shutdown();
    System.out.println("---------End ordering---------" + "\n");
    while (!queue.isEmpty()) {
      TimeUnit.SECONDS.sleep(2);
    }
    printerQueue.shutdown();
    flagCook = false;
    allChefsFutures.get();
    chefs.shutdown();
    deliverers.shutdown();
    System.out.println("---------End cooking---------" + "\n");
  }
}
