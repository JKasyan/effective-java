package item11;

/**
 * Created by evgen on 16.03.16.
 */
public class HashTable<K,V> implements Cloneable {

    private Entry<K, V>[] buckets;

    static class Entry<K,V> {

        final K key;
        V value;
        Entry<K,V> next;
        int hash;

        public Entry(int hash,K key, V value, Entry<K,V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.hash = hash;
        }

        @Override
        @SuppressWarnings("unchecked")
        protected Object clone() throws CloneNotSupportedException {
            return new Entry<>(hash, key, value, next == null ? null : (Entry<K, V>)next.clone());
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        HashTable<K, V> t = (HashTable<K, V>)super.clone();
        t.buckets = new Entry[buckets.length];
        for(int i = buckets.length; i > 0;i--) {
            t.buckets[i] = (buckets[i] == null) ? null : (Entry<K,V>)buckets[i].clone();
        }
        return t;
    }
}
