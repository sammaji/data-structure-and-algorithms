package a2_sorting_algo.Problems;

import javax.swing.plaf.multi.MultiButtonUI;

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
        
        return -1;
    }
}
