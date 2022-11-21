package ds1_UnionFind;

public class QuickFind extends UF {

    private int N = 0;
    private int[] entries, id = {};

    public QuickFind(int N) {
        super(N);
        
        this.N = N;
        entries = new int[N];
        for (int i=0; i < N-1; ++i) entries[i]=i;
        id = entries.clone();
        
    }

    @Override
    public void union(int p, int q) {
        int p_id =  id[p];
        int q_id = id[q];
        for (int i=0; i<N-1; i++) {
            if (id[i] == q_id) id[i] = p_id;
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return (id[p] == id[q]);
    }
}
