package chapter_5.item27;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Created by evgen on 26.03.16.
 */
public interface UnaryFunction<T> {

    T apply(T arg);
}


class Test {

    private static UnaryFunction<Object> IDENTITY_FUNCTION = new UnaryFunction<Object>() {
        @Override
        public Object apply(Object arg) {
            return arg;
        }
    };

    @SuppressWarnings("unchecked")
    public static <T> UnaryFunction<T> identity() {
        return (UnaryFunction<T>)IDENTITY_FUNCTION;
    }

    public static <T extends Comparable<? super T>> T max(List<? extends T> list) {
        Objects.requireNonNull(list);
        Iterator<? extends T> iterator = list.iterator();
        T result = iterator.next();
        while (iterator.hasNext()) {
            T t = iterator.next();
            if(t.compareTo(result) > 0)
                result = t;
        }
        return result;
    }
}


