package ds1_UnionFind;

/**
 * Given a set of N objects:
 * - Union command: connects two objects
 * - Find / Connected query: is there a path connecting two objects?
 */
public abstract class UF {

    /**
     * Initialize union find data sructure with N objects 
     * (indexed as 0 to N-1)
     */
    public UF(int N) {}
    
    /**
     * Adds connection between @param p and @param q.
     */
    public abstract void union(int p, int q);

    /**
     * Checks if @param p and @param q belong to the same
     * connected component
     */
    public abstract boolean connected(int p, int q);
}
