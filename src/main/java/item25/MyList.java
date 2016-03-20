package item25;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by evgen on 20.03.16.
 */
public class MyList {


    public <E> E reduce(List<E> list, Function<E> f, E initVal) {
        List<E> snapshot;
        synchronized (list) {
            snapshot = new ArrayList<>(list);
        }
        E result = initVal;
        for (E o : list) {
            result = f.apply(result, o);
        }
        return result;
    }

}

interface Function<T> {

    T apply(T o1, T o2);
}

