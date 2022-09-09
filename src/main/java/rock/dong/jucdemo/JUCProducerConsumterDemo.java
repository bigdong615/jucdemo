package rock.dong.jucdemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JUCProducerConsumterDemo {

    public static void main(String[] args) {
        Data2 data2 = new Data2();

        new Thread(() -> {
            for (int i = 1; i < 20; i++) {
                try {
                    data2.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i < 20; i++) {
                try {
                    data2.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "B").start();
        new Thread(() -> {
            for (int i = 1; i < 20; i++) {
                try {
                    data2.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "C").start();
        new Thread(() -> {
            for (int i = 1; i < 20; i++) {
                try {
                    data2.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "D").start();
    }
}

class Data2 {

    private int number = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();


    public void increment() throws InterruptedException {
        lock.lock();

        try {// business logic
            while (number != 0) {//防止虚假唤醒，需要把if 用 while 替换
                //wait
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "=>" + number);
            //notify other thread, I'm done +1
            condition.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void decrement() throws InterruptedException {

        lock.lock();

        try {
            while (number == 0) {
                //wait
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "=>" + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

