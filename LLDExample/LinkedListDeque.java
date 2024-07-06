package LLDExample;

public class LinkedListDeque<T> {
    private int size;
    private TypeNode node;

    private class TypeNode {
        public T item;
        public TypeNode next;
        public TypeNode prev;

        // Constructor with parameter
        TypeNode(T x) {
            item = x;
            next = null;
        }

        // Constructor with no input
        TypeNode() {
            item = null;
            next = null;
        }
    }

    LinkedListDeque() {
        size = 0;
        node = new TypeNode();
    }

    LinkedListDeque(T x) {
        size = 1;
        node = new TypeNode(x);
    }

    /** Return the size of LLD */
    public int size() {
        return size;
    }

    /** Add item to the tail of LLD */
    public void addLast(T item) {
        TypeNode newNode = new TypeNode(item);

        TypeNode p = getNode(size - 1);
        p.next = newNode;
        size += 1;
    }

    //
//    private TypeNode<T> getLastNode() {
//        TypeNode<T> returnNode;
//        returnNode = node;
//        while (returnNode.next != null) {
//            returnNode = returnNode.next;
//        }
//        return returnNode;
//    }

    /** Add item to the first */
    public void addFirst(T item) {
        TypeNode newNode = new TypeNode(item);
        newNode.next = node;
        node = newNode;
        size += 1;
    }

    /** Return the ith item in nodes using iteration
     *  if index > size, return null
     *  */
    public T get(int index) {
        if (index > size()) {
            return null;
        }
        TypeNode p = node;
        int i = index;
        while (i != 0) {
            p = p.next;
            i -= 1;
        }
        return p.item;
    }

    /** Return the ith node in nodes using iteration
     *  if index > size, return null
     *  */
    public TypeNode getNode(int index) {
        if (index > size()) {
            return null;
        }
        TypeNode p = node;
        int i = index;
        while (i != 0) {
            p = p.next;
            i -= 1;
        }
        return p;
    }
}
