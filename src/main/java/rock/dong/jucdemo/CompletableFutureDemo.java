package rock.dong.jucdemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            try { //runAsync no return values.
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "runAsync=>void");
        });
        System.out.println("111");
        voidCompletableFuture.get();

        CompletableFuture<Integer> integerCompletableFutureCompletableFuture = CompletableFuture.supplyAsync(() -> {
            // supplyAsync has return value.
            System.out.println(Thread.currentThread().getName() + "supplyAsync=>Integer");
            int i = 10 / 0;
            return 1024;
        });
        integerCompletableFutureCompletableFuture.whenComplete((t, u) -> {
            System.out.println("t = " + t);
            System.out.println("u = " + u);
        }).exceptionally(e -> {
            e.getStackTrace();
            return 233;
        }).get();
    }


}
