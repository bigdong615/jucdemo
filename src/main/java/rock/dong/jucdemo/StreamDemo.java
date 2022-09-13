package rock.dong.jucdemo;

import java.util.ArrayList;

public class StreamDemo {
    public static void main(String[] args) {
        ArrayList<Integer> objects = new ArrayList<Integer>();
        objects.add(10);
        objects.add(21);
        objects.add(30);
        objects.add(41);
        objects.stream().filter((a) -> {
            return a % 2 == 0;
        }).map((a) -> {
            return a * 10;
        }).limit(2).sorted((o1, o2) -> {
            return o2.compareTo(o1);
        }).forEach(System.out::println);

    }
}
