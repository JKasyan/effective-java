package chapter_5.item28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by evgen on 27.03.16.
 */
public class Capture {

    public static void swap(List<?> list, int i, int j) {
        swapHelper(list, i, j);
    }

    private static <E> void swapHelper(List<E> list, int i, int j) {
        E e = list.get(i);
        list.add(i, list.get(j));
        list.add(j, e);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2));
        System.out.println(list);
        swap(list, 0, 1);
        System.out.println(list);
    }
}

