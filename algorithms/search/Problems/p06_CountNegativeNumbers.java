package algorithms.search.Problems;

/**
 * https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
 * Given a m x n matrix grid which is sorted in 
 * non-increasing order both row-wise and column-wise,
 * return the number of negative numbers in grid.
 */
public class p06_CountNegativeNumbers {
    public static void main(String[] args) {
        int[][] grid = {
            {4,3,2,-1},
            {3,2,1,-1},
            {1,1,-1,-2},
            {-1,-1,-2,-3}
        };
        System.out.println(
            countNegatives(grid)
        );  
    }

    static int countNegatives(int[][] grid) {
        int row = 0;
        int col = grid[0].length-1;
        int count = 0;
        
        while(col >= 0 && row <= grid.length-1) {
            if (grid[row][col] >= 0) {
                row++;
            } else if (grid[row][col] < 0) {
                count += grid.length - row;
                col--;
            }
        }
        return count;
    }
}
