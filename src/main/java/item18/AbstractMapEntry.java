package item18;

import java.util.*;

/**
 * Created by evgen on 18.03.16.
 */
public abstract class AbstractMapEntry<K,V> implements Map.Entry<K,V> {

    @Override
    public abstract K getKey();
    @Override
    public abstract V getValue();

    @Override
    public V setValue(V value) {
        throw  new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(!(obj instanceof Map.Entry))
            return false;
        Map.Entry<?, ?> map = (Map.Entry)obj;
        return equals(getKey(), map.getKey())
                && equals(getValue(), map.getValue());
    }

    private static boolean equals(Object o1, Object o2) {
        return o1 == null ? o2 == null : o1.equals(o2);
    }

    @Override
    public int hashCode() {
        return hashCode(getKey()) ^ hashCode(getValue());
    }

    private static int hashCode(Object o) {
        return o == null ? 0 : o.hashCode();
    }
}
