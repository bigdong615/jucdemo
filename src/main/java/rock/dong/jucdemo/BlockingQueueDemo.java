package rock.dong.jucdemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {

        ArrayBlockingQueue<Object> arrayBlockingQueue = new ArrayBlockingQueue<>(2);

        System.out.println(arrayBlockingQueue.add(1));
        System.out.println(arrayBlockingQueue.add(2));
        //System.out.println(arrayBlockingQueue.add(3)); //queue is full

        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        //System.out.println(arrayBlockingQueue.remove()); //exception cause no element in the queue

        System.out.println("===============");
        //arrayBlockingQueue.offer(1, 1, TimeUnit.SECONDS);
        System.out.println(arrayBlockingQueue.offer(1));
        System.out.println(arrayBlockingQueue.offer(2));
        System.out.println(arrayBlockingQueue.offer(3));// offer does not throw exception.
        //arrayBlockingQueue.poll(2, TimeUnit.SECONDS);
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll()); // return null
        System.out.println("===============");

        arrayBlockingQueue.put(1);
        arrayBlockingQueue.put(2);
        //arrayBlockingQueue.put(3); //blocking

        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take()); // no resturn

    }
}
