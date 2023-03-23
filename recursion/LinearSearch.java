package recursion;

public class LinearSearch {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 53, 21, 34, 5, 61, 8, 9, 12 };
        System.out.println(linearSearch(nums, 53));
        System.out.println(linearSearch(nums, 14));
    }

    private static int linearSearch(int[] nums, int target, int pointer) {
        if (pointer > nums.length - 1)
            return -1;

        if (nums[pointer] == target)
            return pointer;

        return linearSearch(nums, target, ++pointer);
    }

    public static int linearSearch(int[] nums, int target) {
        return linearSearch(nums, target, 0);
    }
}
