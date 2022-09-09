package rock.dong.jucdemo;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * java.util.ConcurrentModificationException demo, illustrate the Collection is not multi-thread safe.
 *
 */
public class ConcurrentModificationExceptionDemo01 {

    public static void main(String[] args) {

        //solution1 - Vector<Object> objects = new Vector<>();
        //solution2 - List objects = Collections.synchronizedList(new ArrayList<>());
        //solution3 - List <Object> objects = new CopyOnWriteArrayList<>();
        //ArrayList arrayList = new ArrayList();
        List <Object> objects = new CopyOnWriteArrayList<>(); //copyonwrite is an optimized strategy

;        for (int i = 0; i < 10 ; i++) {
            new Thread(()->{
                objects.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(objects);
            },String.valueOf(i)).start();
        }

    }

}
