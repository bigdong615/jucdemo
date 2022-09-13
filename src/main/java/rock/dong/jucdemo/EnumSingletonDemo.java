package rock.dong.jucdemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public enum EnumSingletonDemo {
    INSTANCES;

    public EnumSingletonDemo getInstances() {
        return INSTANCES;
    }
}

class Test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EnumSingletonDemo instance1 = EnumSingletonDemo.INSTANCES;
        Constructor<EnumSingletonDemo> declaredConstructor = EnumSingletonDemo.class.getDeclaredConstructor(String.class, int.class);//must add args!!!
        declaredConstructor.setAccessible(true);
        EnumSingletonDemo instance2 = declaredConstructor.newInstance();
        System.out.println(instance1);
        System.out.println(instance2);

    }
}
