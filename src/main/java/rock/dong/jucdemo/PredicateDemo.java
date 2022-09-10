package rock.dong.jucdemo;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
       /* Predicate<String> objectPredicate = new Predicate<String>() {
            @Override
            public boolean test(String o) {
                return o.isEmpty();
            }
        };*/

        Predicate<String> objectPredicate=(str)->{return str.isEmpty();};
        System.out.println(objectPredicate.test(""));
    }
}
