package rock.dong.jucdemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // new Thread(new Runnable()).start()
        // new Thread(new FutureTask<V>()).start()
        // new Thread(new FutureTask<v>(Callable)).start()
        Mythread mythread = new Mythread();
        FutureTask futureTask = new FutureTask<>(mythread);
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start(); // the result will be cached
        System.out.println(futureTask.get()); // get() will be result in block, so we'll always put this at the end or use async operation.

    }
}

class Mythread implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("call");
        return "test";
    }
}
