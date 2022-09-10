package rock.dong.jucdemo;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
/*        Function<String, String> function = new Function<String, String>() {// Functional interface
            @Override
            public String apply(String str) {
                return str;
            }
        };*/

        Function<String, String> function = (str)->{return str;};
        System.out.println(function.apply("test"));
    }
}