package rock.dong.jucdemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo02 {
    public static void main(String[] args) {
        Phone phone2 = new Phone();
        new Thread(() -> {
            phone2.sms();
        }, "A").start();
        new Thread(() -> {
            phone2.sms();
        }, "B").start();
    }
}

class Phone2 {

    Lock lock = new ReentrantLock();

    public void sms() {
        lock.lock(); // a lock is different from synchronized, a lock must have a unlock

        try {
            System.out.println(Thread.currentThread().getName() + " sms");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        call();
    }

    public void call() {
        lock.lock();

        try {
            System.out.println(Thread.currentThread().getName() + " call");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}


