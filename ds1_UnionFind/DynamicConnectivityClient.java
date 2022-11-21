/**
 * @use: for checking our union find data structure.
 * - Reads in number of objects N from standard input.
 * - Reads pairs of integer from standard input.
 * - If they are not connected, then connects them.
 */

package ds1_UnionFind;

public class DynamicConnectivityClient {

    public static void main(String[] args) {
        int N = 20;
        int[][] connections = {
            {1,2}, {2,8}, {1,7},
            {1,15}, {4,5}, {7,11},
            {15,5}
        };

        QuickFind quickFind = new QuickFind(N);

        for (int i = 0; i < connections.length-1; i++) {
            quickFind.union(connections[i][0], connections[i][1]);
        }

        System.out.println(quickFind.connected(7,11)); // must be true
        System.out.println(quickFind.connected(1,4)); // must be true
        System.out.println(quickFind.connected(1,10)); // must be false
    }
}
