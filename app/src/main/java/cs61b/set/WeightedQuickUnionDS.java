package cs61b.set;

public class WeightedQuickUnionDS implements DisjointSets {
    private int[] id;

    public WeightedQuickUnionDS(int n) {
        this.id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = -1;
        }
    }

    @Override
    public void connect(int p, int q) {
        int mainRoot = find(p);
        int secondaryRoot = find(q);
        if (id[mainRoot] < id[secondaryRoot]) {
            id[secondaryRoot] = mainRoot;
            id[mainRoot] -= 1;
        } else {
            id[mainRoot] = secondaryRoot;
            id[secondaryRoot] -= 1;
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    private int find(int i) {
        if (id[i] < 0) {
            return i;
        }
        return find(id[i]);
    }
}
