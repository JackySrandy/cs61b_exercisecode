public interface DisjointSets {
    /**connects two items P and Q. */
    void connect(int p, int q);

    /** checks if P and Q are connected. */
    boolean isConnected(int p, int q);
}
