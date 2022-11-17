package a2_sorting_algo.Problems;

/**
 * Given an array nums containing n distinct numbers 
 * in the range [0, n], return the only number in the 
 * range that is missing from the array.
 */
public class p01_MissingNumbers {
    public static void main(String[] args) {
        int[] nums1 = {3,0,1};
        int[] nums2 = {0,1};
        int[] nums3 = {9,6,4,2,3,5,7,0,1};

        System.out.println(findMissingNumbers(nums1));
        System.out.println(findMissingNumbers(nums2));
        System.out.println(findMissingNumbers(nums3));
    }

    static int findMissingNumbers(int[] nums) {
        int pointer = 0;
        int index = 0;
        while(pointer <= nums.length-1) {
            if (nums[pointer] == pointer) {
                pointer++;
            } else if (nums[pointer] != pointer && nums[pointer] < nums.length) {
                // swap
                int temp = nums[nums[pointer]];
                nums[nums[pointer]] = nums[pointer];
                nums[pointer] = temp;
            } else if (nums[pointer] == nums.length) {
                index = pointer;
                pointer++;
            }
        }
        
        // if index is pointing at index 0, then,
        // case1: either the missing element is zero.
        // in that case nums[0] must be N
        // case2: or the missing element is N
        // in that case nums[0] must be 0
        if (index == 0) {
            if (nums[0] == 0) return nums.length;
            else return 0;
        } 

        return index;
    }
}
