package rock.dong.jucdemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorsDemo {
    public static void main(String[] args) {

        //ExecutorService executorService = Executors.newFixedThreadPool(5);  //fixed threadpool
        ExecutorService executorService = Executors.newCachedThreadPool();    //depends on system capacity, how many cores
        //ExecutorService executorService = Executors.newSingleThreadExecutor(); //single threadpool

        try {
            for (int i = 0; i < 10; i++) {
                executorService.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " execute");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown(); // remember to shutdown.
        }
    }
}
