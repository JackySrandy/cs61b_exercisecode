package Map61B;

import java.util.List;

public class MapHelper {
    /* Write the following three methods:*/
    /* get(Key) : Return item in map if it exists. */
    public static <K, V> V get(Map61B<K, V> sim, K key) {
        if (sim.containKey(key)) {
            return sim.get(key);
        }
        return null;
    }
    /* maxKey() : Returns max of all keys. Works only if x and y have comparable data. */
    public static <K extends Comparable<K>, V> K maxKey(Map61B<K, V> map) {
        List<K> keylist = map.keys();
        K maxKey = keylist.get(0);
        for (K k: keylist) {
            if (k.compareTo(maxKey) > 0) {
                maxKey = k;
            }
        }
        return maxKey;
    }
}
