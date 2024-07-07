import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

public class ArrayMap<K, V> implements MyMap<K, V> {
    private int size;
    private K[] keys;
    private V[] values;
    public ArrayMap() {
        size = 0;
        keys = (K[]) new Object[100];
        values = (V[]) new Object[100];
    }

    /** Returns index of key if it exists
     *  -1 otherwise. */
    private int keyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Associate key with the value in the Map.
     */
    @Override
    public void put(K key, V value) {
        if (contains(key)) {
            int keyIndex = keyIndex(key);
            values[keyIndex] = value;
            return;
        }
        keys[size] = key;
        values[size] = value;
        size += 1;
    }

    /**
     * Returns Ture if the map contains the key.
     */
    @Override
    public boolean contains(K key) {
        return keyIndex(key) > -1;
    }

    /**
     * Returns value of the specified key if it exists and null otherwise.
     */
    @Override
    public V get(K key) {
        if (contains(key)) {
            int index = keyIndex(key);
            return values[index];
        }
        return null;
    }

    /**
     * Returns the size of map.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns a list of the keys in this map.
     */
    @Override
    public List<K> keys() {
        List<K> keyList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            keyList.add(keys[i]);
        }
        return keyList;
    }

}
