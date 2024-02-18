package task6;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService service = Executors.newFixedThreadPool(5);
    Chest chest = new Chest();
    List<CompletableFuture<Void>> completableFutureList =
        IntStream.range(0, 500)
            .mapToObj(x -> CompletableFuture.runAsync(() -> chest.addGold(10), service))
            .toList();
    CompletableFuture<Void> allCompletableFuture = CompletableFuture.allOf(
        completableFutureList.toArray(new CompletableFuture[0]));
    allCompletableFuture.get();
    System.out.println(chest.getGold());
    service.shutdown();
  }
}