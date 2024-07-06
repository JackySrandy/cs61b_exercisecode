package Map61B;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;


public class ArrayMap<K, V> implements Map61B<K, V>{
    private K[] keys;
    private V[] values;
    private int size;
    public ArrayMap() {
        keys = (K[]) new Object[100];
        values = (V[]) new Object[100];
        size = 0;
    }

    /** Returns the index of key if it exists,
     *  -1 otherwise. */
    private int keyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    /** Returns Ture if this map contains key
     *  False otherwise. */
    @Override
    public boolean containKey(K key) {
        return keyIndex(key) > -1;
    }

    /** Associates the specified value with the specified key in this map. */
    @Override
    public void put(K key, V value) {
        int index = keyIndex(key);
        if (index > -1) {
            values[index] = value;
        } else {
            keys[size] = key;
            values[size] = value;
            size += 1;
        }

    }

    /** Return the value of key if it exists,
     *  null otherwise. */
    @Override
    public V get(K key) {
        int index = keyIndex(key);
        if (index == -1) {
            return null;
        }
        return values[index];
    }

    /** Return the size of this map. */
    @Override
    public int size(){
        return size;
    }

    /** Returns a list of the keys in this map. */
    @Override
    public List<K> keys() {
        List<K> keylist = new ArrayList<>();
        for (int i = 0; i < size; i += 1) {
            keylist.add(keys[i]);
        }
        return keylist;
    }

    @Test
    public void test() {
        ArrayMap<Integer, Integer> am = new ArrayMap<Integer, Integer>();
        am.put(2, 5);
        int expected = 5;
        assertEquals(expected, (int) am.get(2));
    }

//    public static void main(String[] args) {
//        ArrayMap<String, Integer> m = new ArrayMap<String, Integer>();
//        m.put("horse", 3);
//        m.put("fish", 9);
//        m.put("house", 10);
//    }
}
