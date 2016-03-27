package chapter_5.item27;

import java.util.*;

/**
 * Created by evgen on 22.03.16.
 */
public class GenericMethod {

    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    public static <K,V> Map<K,V> newHashMap() {
        return new HashMap<>();
    }
}

class Main {

    public static void main(String[] args) {
        Map<String, String> map = System.getenv();
        map.forEach((k, v) -> System.out.println(k + " = " + v));
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));
        Set<Integer> set3 = GenericMethod.union(set1, set2);
        System.out.println(set3);
        /**
         *
         */
        Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Double> s2 = new HashSet<>(Arrays.asList(1.0));
        Set<Number> s3 = GenericMethod.<Number>union(s1, s2);
    }
}
