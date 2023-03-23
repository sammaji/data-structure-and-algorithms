package recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 7, 11, 32, 44, 45, 56 };
        System.out.println(binarySearch(nums, 53)); // -1
        System.out.println(binarySearch(nums, 4)); // 3
    }

    private static int binarySearch(int[] nums, int target, int start, int end) {
        int mid = start + (end - start) / 2;
        if (start > end)
            return -1;

        if (nums[mid] > target)
            return binarySearch(nums, target, start, mid - 1);
        else if (nums[mid] < target)
            return binarySearch(nums, target, mid + 1, end);
        else
            return mid;
    }

    public static int binarySearch(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }
}