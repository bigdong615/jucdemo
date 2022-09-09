package rock.dong.jucdemo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * semaphore.acquire() aquire, if full, wait till release.
 * semaphore.release() release, current semaphore+1, then notify wait thread
 * area: multi-resourse mutual exclusion, resource limit, control max_thread.
 */
public class SemaphoreDemo {
    public static void main(String[] args) throws InterruptedException {
        // thread, parking, limit resource.
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "aquire the parking spot");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName() + "left the parking spot");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
