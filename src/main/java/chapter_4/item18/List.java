package chapter_4.item18;

import java.lang.reflect.Array;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by evgen on 18.03.16.
 */
public interface List<E> {

    E get(int index);

    void add(E e);

    default void print(int index) {
        System.out.println(get(index));
    }

}

class ListImpl<E> implements List<E> {

    private E[] elements;
    private final static int DEFAULT_CAPACITY = 10;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public ListImpl(Class<? extends E> type) {
        elements = (E[]) Array.newInstance(type, DEFAULT_CAPACITY);
    }

    @Override
    public void add(E e) {
        elements[size++] = e;
    }

    @Override
    public E get(int index) {
        return elements[index];
    }
}

class Main {

    public static void main(String[] args) {
        List<Integer> list = new ListImpl<>(Integer.class);
        list.add(1);
        wrongAdding(list);
        list.print(1);
        Set<Object> set = new HashSet<>();
        set.add(5);
        set.add(new Date());

    }

    private static void wrongAdding(List<? extends Number> list) {
        list.add(null);
    }
}
