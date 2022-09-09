package rock.dong.jucdemo;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " go out");
                countDownLatch.countDown(); // minus -1.
            }).start();
        }
        countDownLatch.await(); //wait till counter ==0 and continue the left execution.

        System.out.println("close Door");
    }
}
