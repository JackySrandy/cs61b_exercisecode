package MyBST;

import java.util.Comparator;

class BST<T extends Comparable<T>> {
    private T key;
    private BST<T> left;
    private BST<T> right;

    BST(T k){
        key = k;
        left = right = null;
    }
    BST(T k, BST<T> l, BST<T> r) {
        key = k;
        left = l;
        right = r;
    }

    static <T extends Comparable<T>> BST<T> insert(BST<T> t, T k) {
        BST<T> leaf = new BST<>(k);
        return BST.insert(t, leaf);
    }
    static <T extends Comparable<T>> BST<T> insert(BST<T> t, BST<T> k) {
        if (t == null) {
            return k;
        }
        if (k.key.compareTo(t.key) > 0) {
            t.right = insert(t.right, k);
        } else {
            t.left = insert(t.left, k);
        }
        return t;
    }

    static <T extends Comparable<T>> BST<T> delete(BST<T> t, T k) {
        BST<T> ik = new BST<>(k);
        return delete(t, ik);
    }

    static <T extends Comparable<T>> BST<T> delete(BST<T> t, BST<T> k) {
        if (t == null) {
            return t;
        }
        if (k.key.compareTo(t.key) > 0) {
            t.right = delete(t.right, k);
        } else if (k.key.compareTo(t.key) < 0) {
            t.left = delete(t.left, k);
        } else {
            if (t.left == null) {
                return t.right;
            } else if (t.right == null) {
                return t.left;
            }
            T newKey = minKey(t.right);
            t.key = newKey;
            t.right = delete(t.right, newKey);
        }
        return t;
    }

    private static <T extends Comparable<T>> T minKey(BST<T> t) {
        if (t == null) {
            return null;
        }
        while(t.left != null) {
            t = t.left;
        }
        return t.key;
    }

    static <T extends Comparable<T>> T find(BST<T> t, T k) {
        if(t == null) {
            return null;
        }
        if (t.key.compareTo(k) > 0) {
            return find(t.left, k);
        } else if (t.key.compareTo(k) < 0) {
            return find(t.right, k);
        } else {
            return k;
        }
    }

    public static void main(String[] args) {
        BST<Integer> r = new BST<>(7);
        insert(r, 8);
        insert(r, 6);
        insert(r, 5);
        insert(r, 9);
        delete(r, 7);
    }
}