package Map61B;

import java.util.List;

public interface Map61B<K, V> {
    public boolean containKey(K key);
    public void put(K key, V value);

    V get(K key);

    int size();

    List<K> keys();
}
