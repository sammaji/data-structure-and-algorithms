package a2_sorting_algo.Problems;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @question: Given an array nums containing n distinct numbers 
 * in the range [0, n], return the only number in the 
 * range that is missing from the array.
 * 
 * @question: Given an array nums of n integers where nums[i] is in the range [1, n], 
 * return an array of all the integers in the range [1, n] that do not appear in nums.
 * Example 1:
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 */
public class p01_MissingNumbers {
    public static void main(String[] args) {
        int[] nums1 = {9,6,4,2,3,5,7,0,1};
        int[] nums2 = {4,3,2,7,8,2,3,1};

        // System.out.println(findMissingNumbers(nums1));
        System.out.println(
            findDisappearedNumbers(nums2)
            );

        System.out.println(Arrays.toString(nums2));
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
    

    // not working
    static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();

        int pointer = 0;

        while (pointer <= nums.length-1) {
            if (nums[pointer] == pointer+1) pointer++;
            else {
                if (nums[pointer] <= nums.length) {
                    int temp = nums[nums[pointer]-1];
                    nums[pointer] = nums[nums[pointer]-1];
                    nums[nums[pointer]-1] = temp;
                } else {
                    pointer++;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) result.add(i);
        }

        return result;
    }
    
}
