package UnionFind;

/**
 * Modify quick union to avoid tall trees
 * Keep track of tree size (no. of obj. in each trees)
 * Balance by root of smaller trees by root of larger trees
 */
public class WeightedQuickUnion extends UF {

    public WeightedQuickUnion(int N) {
        super(N);
        
    }

    @Override
    public void union(int p, int q) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean connected(int p, int q) {
        // TODO Auto-generated method stub
        return false;
    }

    
    
}
