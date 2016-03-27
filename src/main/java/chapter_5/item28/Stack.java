package chapter_5.item28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

/**
 * Created by evgen on 26.03.16.
 */
public class Stack<E> {

    private E[] elements;
    private int size = 0;
    private static final int DEFAULT = 10;

    @SuppressWarnings("unchecked")
    public Stack(int size) {
        elements = (E[])new Object[size];
    }

    public Stack() {
        this(DEFAULT);
    }

    void push(E e){
        ensureCapacity();
        elements[size++] = e;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, size * 2 + 1);
        }
    }

    public void pushAll(Iterable<? extends E> all) {
        for (E e:all) {
            push(e);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E pop() {
        if(size == 0)
            throw new EmptyStackException();
        E e = elements[--size];
        elements[size] = null;
        return e;
    }

    /**
     *
     * @param c
     */
    public void popAll(Collection<? super E> c) {
        while (!isEmpty())
            c.add(pop());
    }
}

class Main {

    public static void main(String[] args) {
        Stack<Number> stack = new Stack<>();
        Iterable<Integer> it = Arrays.asList(1, 2, 3, 4);
        stack.pushAll(it);
        /**
         *
         */
        Collection<Object> c = new ArrayList<>();
        stack.popAll(c);
    }
}
