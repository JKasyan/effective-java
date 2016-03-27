package chapter_3.item11;

/**
 * Created by evgen on 16.03.16.
 */
public class Stack {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    @Override
    protected Stack clone() throws CloneNotSupportedException {
        Stack stack = (Stack)super.clone();
        stack.elements = elements.clone();
        return stack;
    }
}
