package chapter_5.item29;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by evgen on 27.03.16.
 */
public class Favorites <T> {

    private Map<Class<?>, Object> map = new HashMap<>();

    public void add(Class<T> cl, T instance) {
        Objects.requireNonNull(instance);
        map.put(cl, cl.cast(instance));
    }

    public T get(Class<T> k) {
        return k.cast(map.get(k));
    }
}

class Main {

    public static void main(String[] args) {
        Favorites f = new Favorites();
        f.add(String.class, "Java");
        f.add(Long.class, 1L);
        f.add(Integer.class, 0xcafebabe);
        f.add(Class.class, Favorites.class);
        f.get(Class.class);
    }
}
