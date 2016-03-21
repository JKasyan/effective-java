package item26;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by evgen on 21.03.16.
 */
public class Stack<E> {

    private E[] elements;
    private int size = 0;
    private static final int DEFAULT = 10;

    public Stack() {
        this(DEFAULT);
    }

    @SuppressWarnings("unchecked")
    public Stack(int size) {
        this.elements = (E[])new Object[size];
    }

    public void add(E o) {
        ensureCapacity();
        elements[size++] = o;
    }

    public E pop() {
        if(size == 0)
            throw new EmptyStackException();
        E o = elements[--size];
        elements[size] = null;
        return o;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    @Override
    public String toString() {
        return "Stack{" + Arrays.toString(elements) + "}";
    }
}

class Main {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < 20; i++)
            stack.add(i);
        System.out.println(stack);
    }
}
