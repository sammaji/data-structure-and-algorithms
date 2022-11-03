package UnionFind;

public class QuickUnion extends UF {

    private int[] entries, id = {};

    public QuickUnion(int N) {
        super(N);

        entries = new int[N];
        for (int i=0; i < N-1; ++i) entries[i]=i;
        id = entries.clone();
    }

    private int root(int i) {
        while (i != id[i]) i = id[i];
        return i;
    }

    @Override
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
    
}


