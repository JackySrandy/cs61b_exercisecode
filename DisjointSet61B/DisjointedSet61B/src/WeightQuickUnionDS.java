public class WeightQuickUnionDS implements DisjointSets {
    private int[] roots;


    WeightQuickUnionDS(int N) {
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
//        roots[qRoot] = pRoot;
        if (pRoot >= qRoot) {
            roots[qRoot] += roots[pRoot];
            roots[pRoot] = qRoot;
        } else {
            roots[pRoot] += roots[qRoot];
            roots[qRoot] = pRoot;

        }
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

    public static void main(String[] args) {
        WeightQuickUnionDS testDS = new WeightQuickUnionDS(10);
        for (int i = 1; i <= 5; i++) {
            testDS.connect(0, i);
        }
        testDS.connect(8, 9);
        testDS.connect(6, 7);
        testDS.connect(6, 8);
        System.out.println(1);
    }
}

