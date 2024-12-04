package cs61b.set;

public class QuickUnionDS implements DisjointSets {
    private int[] id;

    public QuickUnionDS(int n) {
        this.id = new int[n];
        for (int i = 0; i < n; i++){
            id[i] = -1;
        }
    }

    @Override
    public void connect(int p, int q) {
        int mainRoot = find(p);
        int secondaryRoot = find(q);
        id[secondaryRoot] = mainRoot;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
    
    private int find(int i) {
        if (id[i] == -1)  {
           return i; 
        }
        return find(id[i]);
    }
}
