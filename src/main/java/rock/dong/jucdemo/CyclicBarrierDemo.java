package rock.dong.jucdemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("The dragon has been awaken successfully");
        });

        for (int i = 0; i <=7 ; i++) {
            int temp = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + " collect " + temp + " Dragon Ball ");
                try {
                    cyclicBarrier.await();// wait
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
