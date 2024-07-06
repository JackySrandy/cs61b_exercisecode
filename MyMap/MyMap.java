import java.util.List;

public interface MyMap<K, V> {
    /** Associate key with the value in the Map. */
    void put(K key, V value);
    /** Returns Ture if the map contains the key. */
    boolean contains(K key);
    /** Returns value of the specified key if it exists and null otherwise. */
    V get(K key);
    /** Returns the size of map. */
    int size();
    /** Returns a list of the keys in this map. */
    List<K> keys();
}
