package ArraySetPractice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArraySet<T> implements Iterable<T> {
    private T[] items;
    private int size;

    /* Constructor */
    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    /** Return true if this map contains a mapping for the special key */
    public boolean contains(T item) {
        for (int i = 0; i < size; i += 1) {
            if (items[i] == null) {
                if (item == null) {
                    return true;
                } // This code is usually called null safe in oop
            }
            if (item.equals(items[i])) {
                return true;
            }
        }
        return false;
    }

    /** Associates the specified value with the specified key in this map.
     * Ignores nulls that users tries to add.(optional)
     * Throws an IllegalArgumentException if the key is null.(optional) */
    public void add(T item) {
        // Throws an IllegalArgumentException if the key is null.
//        if (item == null) {
//            throw new IllegalArgumentException("You can't add null to ArraySet!");
//        }
        // Ignores nulls that users tries to add.
//        if (item == null) {
//            return;
//        }
        if (!contains(item)) {
            items[size] = item;
            size += 1;
        }
    }

    /** Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

//    @Override
//    public String toString() {
//        StringBuilder returnString = new StringBuilder("{ ");
//        for (T item : items) {
//            if (item == null) {
//                continue;
//            }
//            returnString.append(item.toString());
//            returnString.append(", ");
//        }
//        returnString.append("}");
//        return returnString.toString();
//    } // Shortcoming : Extra comma

    // Lower efficiency but looks beautiful in some way
    @Override
    public String toString() {
        List<String> returnList = new ArrayList<>();
        for (T item : items) {
            if (item == null) {
                continue;
            }
            returnList.add(item.toString());
        }
        return String.join(", ", returnList);
    }

    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    private class ArraySetIterator implements Iterator<T> {
        private int wizPos;

        // Constructor
        public ArraySetIterator() {
            wizPos = 0;
        }

        @Override
        public boolean hasNext() {
            return wizPos < size;
        }

        @Override
        public T next() {
            T returnItem = items[wizPos];
            wizPos += 1;
            return returnItem;
        }
    }

    public static <G> ArraySet<G> of(G... stuff) {
        ArraySet<G> returnSet = new ArraySet<>();
        for (G i : stuff) {
            returnSet.add(i);
        }
        return returnSet;
    }

    public static void main(String[] args) {
        ArraySet<String> s = new ArraySet<>();
        s.add(null);
        s.add("horse");
        s.add("fish");
        s.add("house");
        s.add(null);
        s.add("fish");
        System.out.println(s.contains("horse"));
        System.out.println(s.size()); // Should return -> 3
        System.out.println(s.contains(null)); // Should return -> True
        System.out.println(s.toString());

        // Enhanced For loop
        for (String str : s) {
            System.out.println(str);
        }

        System.out.println("----------------------------------");

        // Ugly implement
        Iterator<String> aseer = s.iterator();
        while (aseer.hasNext()) {
            String item = aseer.next();
            System.out.println(item);
        }

        ArraySet<String> s2 = ArraySet.of("Good", "Luck", "&","Have", "Fun", "!");
        System.out.println(s2);

    }
}