package rock.dong.jucdemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Lazyman {
    public Lazyman() {
        System.out.println(Thread.currentThread().getName() + " ok");
    }

    private volatile static Lazyman lazyman;
    //DCL
    public static Lazyman getInstance() {
        if (lazyman == null) {
            synchronized (Lazyman.class) {

                if (lazyman == null) {
                    lazyman = new Lazyman();
                }
            }
        }
        return lazyman;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                Lazyman.getInstance();
            }).start();
        }

        Lazyman instance = Lazyman.getInstance();
        Lazyman instance3 = Lazyman.getInstance();
        Constructor<Lazyman> constructor = Lazyman.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Lazyman instance2 = constructor.newInstance(); //use reflection to create instance.
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
        System.out.println(instance3.hashCode());
    }

}