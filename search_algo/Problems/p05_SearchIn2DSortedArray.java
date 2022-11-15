package Problems;

/**
 * Search for an element in a 2D row-wise
 * and column wise sorted array, ie, every row is sorted
 * and every column is sorted in ascending order
 */
public class p05_SearchIn2DSortedArray {
    public static void main(String[] args) {
        int[][] sorted_2d_array = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {28, 29, 37, 49},
            {33, 34, 38, 50}
        };
        int target = 37;
        
        int[] result = searchIn2DArray(sorted_2d_array, target);
        System.out.println("row="+result[0]);
        System.out.println("col="+result[1]);
    }

    static int[] searchIn2DArray(int[][] sample, int target) {
        int[] result = {-1, -1};
        int row = 0;
        int col = sample[0].length-1;

        if (sample[0][0] > target) return result;

        while(col >= 0 && row <= sample.length-1) {
            if (sample[row][col] > target) {
                // if sample[0][3] is greater than target,
                // then sample[1][3] is also greater than target and so on
                // hence delete column = 3
                col--;
            } else if (sample[row][col] < target) {
                // if sample[0][2] is less than target,
                // then sample[0][1] is also less than target and so on
                // hence delete row = 3
                row++;
            } else if (sample[row][col] == target) {
                result[0] = row;
                result[1] = col;
                return result;
            }
        }
        return result;
    }
}
