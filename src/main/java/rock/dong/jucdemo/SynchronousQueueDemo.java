package rock.dong.jucdemo;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>(); // There is no capacity, put an element, you must wait for it to come before you can put an element in it.

        new Thread(() -> {

            try {
                System.out.println(Thread.currentThread().getName() + " put 1 ");
                synchronousQueue.put("1");
                System.out.println(Thread.currentThread().getName() + " put 2 ");
                synchronousQueue.put("2");
                System.out.println(Thread.currentThread().getName() + " put 3 ");
                synchronousQueue.put("3");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();


        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + "==>" + synchronousQueue.take());
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + "==>" + synchronousQueue.take());
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + "==>" + synchronousQueue.take());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();

    }
}
