package rock.dong.jucdemo;

public class TraditionalProducerConsumerDemo {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(() -> {
            for (int i = 1; i < 20; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i < 20; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "B").start();
        new Thread(() -> {
            for (int i = 1; i < 20; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "C").start();
        new Thread(() -> {
            for (int i = 1; i < 20; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "D").start();
    }
}

class Data {

    private int number = 0;

    public synchronized void increment() throws InterruptedException {
        while (number != 0) {//防止虚假唤醒，需要把if 用 while 替换
            //wait
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName() + "=>" + number);
        //notify other thread, I'm done +1
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        while (number == 0) {
            //wait
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "=>" + number);
        this.notifyAll();
    }

}
