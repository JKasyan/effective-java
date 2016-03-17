package item16;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by evgen on 17.03.16.
 */
public class InstrumentedHashSet<E> extends HashSet<E> {

    private int count = 0;

    public InstrumentedHashSet() {}

    public InstrumentedHashSet(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    @Override
    public boolean add(E e) {
        count++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        count += c.size();
        return super.addAll(c);
    }

    public int getCount() {
        return count;
    }
}
