public class QuickFindDS implements DisjointSets{

    private int[] id;

    QuickFindDS(int num) {
        id = new int[num];
        for (int i = 0; i < num; i += 1) {
            id[i] = i;
        }
    }

    /** connects two items P and Q. */
    @Override
    public void connect(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    /** checks if P and Q are connected. */
    @Override
    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }
}
