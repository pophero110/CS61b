package cs61b.set;

public class QuickFindDS implements DisjointSets{
    private int[] id;

    public QuickFindDS(int n) {
        this.id = new int[n];
        for (int i = 0; i < n; i++){
            id[i] = i;
        }
    }

    @Override
    public void connect(int p, int q) {
        for (int i = 0; i < id.length - 1; i++) {
            if (id[i] == id[p]) id[i] = id[q];
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }
}
