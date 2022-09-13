package rock.dong.jucdemo;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileDemo {

    //private static int number = 0;
    private volatile static AtomicInteger atomicInteger = new AtomicInteger();

    public synchronized static void add() {
        // number++; // not a atomic operation
        atomicInteger.incrementAndGet(); // use CAS
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {

            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }
        System.out.println(atomicInteger);
        while (Thread.activeCount() > 2) { //main thread and GC thread, so if there are more than 2 threads, it means the above thread was still running.
            Thread.yield();
        }
    }
}



