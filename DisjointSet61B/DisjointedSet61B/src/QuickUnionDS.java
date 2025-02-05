public class QuickUnionDS implements DisjointSets{
    private int[] roots;


    QuickUnionDS(int N) {
        roots = new int[N];
        for (int i = 0; i < N; i++) {
            roots[i] = -1;
        }
    }
    /**
     * connects two items P and Q.
     *
     * @param p
     * @param q
     */
    @Override
    public void connect(int p, int q) {
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);
        roots[qRoot] = pRoot;
    }

    /**
     * checks if P and Q are connected.
     *
     * @param p
     * @param q
     */
    @Override
    public boolean isConnected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    /** finds the root of X. */
    private int findRoot(int x) {
        while(roots[x] > 0) {
            x = roots[x];
        }
        return x;
    }
}
