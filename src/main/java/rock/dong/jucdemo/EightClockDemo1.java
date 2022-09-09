package rock.dong.jucdemo;

import java.util.concurrent.TimeUnit;

public class EightClockDemo1 {
    public static void main(String[] args) {
        //synchronized locks the object who invoke the methods, so as the sendmessage and call are invoked by the same object phone, as the
        //sendmessage is the first one to get synchronized(first to get the lock), it'll always execute first.
        //if there are two objects, execution sequence depends on who will run first(no TimeUnit.sleep() will be the first).
        phone phone = new phone();
        new Thread(() -> {
            try {
                phone.sendMessage();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            phone.call();
        }).start();

        new Thread(() -> {
            phone.hello();
        }).start();
    }
}


class phone {

    public synchronized void sendMessage() throws InterruptedException {

        TimeUnit.SECONDS.sleep(3);
        System.out.println("send message");
    }

    public synchronized void call() {
        System.out.println("call");

    }

    public void hello() {
        System.out.println("hello");

    }
}
