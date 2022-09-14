package rock.dong.jucdemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABADemo {


    public static void main(String[] args) {
        AtomicStampedReference atomicStampedReference = new AtomicStampedReference(1, 1);
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println("a1 = " + stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicStampedReference.compareAndSet(1, 2, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1));
            System.out.println("a2 = " + atomicStampedReference.getStamp());
            System.out.println(atomicStampedReference.compareAndSet(2, 1, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1));
            System.out.println("a3 = " + atomicStampedReference.getStamp());
        }).start();

    }
}
