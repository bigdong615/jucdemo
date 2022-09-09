package rock.dong.jucdemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static void main(String[] args) {
        Ticket2 ticket = new Ticket2();
        new Thread(() -> {
            for (int i = 1; i < 50; i++) {
                ticket.sale();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i < 50; i++) {
                ticket.sale();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 1; i < 50; i++) {
                ticket.sale();
            }
        }, "C").start();

    }

}

/**
 * Lock steps
 * 1  new ReentrantLock()
 * 2  lock.lock() // add lock
 * 3  finally -> lock.unlock() // release lock
 */
class Ticket2 {

    Lock lock = new ReentrantLock();

    private int number = 50;

    public void sale() {
        lock.lock();

        try {
            // business logic
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了" + (number--) + "票，剩余" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
