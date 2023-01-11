package recursion;

public class RecursiveBinarySearch {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 5, 6, 17, 35, 54, 59 };
        int target = 35;
        
        System.out.println(bs_recursion(nums, target));
    }

    static int bs_recursion(int[] nums, int target) {
        return bs_recursion(0, nums.length - 1, nums, target);
    }

    static int bs_recursion(int start, int end, int[] nums, int target) {
        if (nums[start] > nums[end]) {
            return -1;
        } else {
            int mid = start + (end - start) / 2;
            if (target > nums[mid])
                return bs_recursion(mid + 1, end, nums, target);
            else if (target < nums[mid])
                return bs_recursion(start, mid - 1, nums, target);
            else
                return mid;
        }
    }
}