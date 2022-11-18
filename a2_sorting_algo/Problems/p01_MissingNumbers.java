package a2_sorting_algo.Problems;

import java.util.ArrayList;
import java.util.List;

/**
 * All questions are of similar types.
 * @question 01: Given an array nums containing n distinct numbers 
 * in the range [0, n], return the only number in the 
 * range that is missing from the array.
 * 
 * @question 02: Given an array nums of n integers where nums[i] is in the range [1, n], 
 * return an array of all the integers in the range [1, n] that do not appear in nums.
 * Example 1:
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 * 
 * @question 03: Given an array of integers nums containing n + 1 integers
 * where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 * You must solve the problem without modifying the array nums and uses 
 * only constant extra space.
 * Example 1:
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * 
 * @question 04: Given an integer array nums of length n where
 * all the integers of nums are in the range [1, n] and each integer 
 * appears once or twice, return an array of all the integers that 
 * appears twice. You must write an algorithm that runs in O(n) 
 * time and uses only constant extra space.
 * Example 1:
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [2,3]
 * 
 * @question 05: [LEETCODE HARD] Given an unsorted integer array nums, 
 * return the smallest missing positive integer. You must implement 
 * an algorithm that runs in O(n) time and uses constant extra space.
 * 
 * Example 1:
 * Input: nums = [1,2,0]
 * Output: 3
 * Explanation: The numbers in the range [1,2] are all in the array.
 * Example 2:
 * 
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Explanation: 1 is in the array but 2 is missing.
 * Example 3:
 * 
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 * Explanation: The smallest positive integer 1 is missing.
 */
public class p01_MissingNumbers {

    // question 01
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

    // question 02
    static List<Integer> findDisappearedNumbers(int[] nums) {
        int pointer = 0;
        List<Integer> result = new ArrayList<Integer>();

        while (pointer <= nums.length-1) {
            // second condition is important if loop has duplicate items
            // otherwise the loop runs infinitely
            if (nums[pointer] == pointer+1 || nums[pointer] == nums[nums[pointer]-1]) pointer++;
            else {
                if (nums[pointer] <= nums.length) {
                    int temp = nums[nums[pointer]-1];
                    nums[nums[pointer]-1] = nums[pointer];
                    nums[pointer] = temp;
                } else {
                    pointer++;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) {
                result.add(i+1);
            }
        }
        return result;
    }

    // question 03
    static int findDuplicate(int[] nums) {
        int pointer = 0;
        while (pointer <= nums.length-1) {
            // if  num[num[pointer]-1] == nums[pointer], then ignore
            // ex [3,1,3,4,2]: if we do not implement the above check then
            // we will be stuck in an infinite loop
            if (nums[pointer] == pointer+1 || nums[pointer] > nums.length || nums[nums[pointer]-1] == nums[pointer]) {
                pointer++;
            } else if (nums[pointer] != pointer+1 && nums[pointer] <= nums.length) {
                int temp = nums[nums[pointer]-1];
                nums[nums[pointer]-1] = nums[pointer];
                nums[pointer] = temp;
            }
        }

        for (int i=0; i<nums.length; i++) {
            if (nums[i] != i+1) return nums[i];
        }
        return -1;
    }
    
    // question 04
    static List<Integer> findAllDuplicate(int[] nums) {
        int pointer = 0;
        List<Integer> result = new ArrayList<Integer>();

        while (pointer <= nums.length-1) {
            // if  num[num[pointer]-1] == nums[pointer], then ignore
            // ex [3,1,3,4,2]: if we do not implement the above check then
            // we will be stuck in an infinite loop
            if (nums[pointer] == pointer+1 || nums[pointer] > nums.length || nums[nums[pointer]-1] == nums[pointer]) {
                pointer++;
            } else if (nums[pointer] != pointer+1 && nums[pointer] <= nums.length) {
                int temp = nums[nums[pointer]-1];
                nums[nums[pointer]-1] = nums[pointer];
                nums[pointer] = temp;
            }
        }
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != i+1) result.add(nums[i]);
        }
        return result;
    }

    // question 05
    // approach: apply cyclic sort
    // ignoring all negative numbers, the first positive
    // number at the wrong index is the answer
    static int firstMissingPositive(int[] nums) {
        int pointer = 0;
        while(pointer <= nums.length-1) {
            // 3rd condition: ignores negative numbers
            // 4th condition: igonores infinite looping caused due to duplicate elements
            if (nums[pointer] == pointer+1 || nums[pointer] > nums.length
             || nums[pointer] <= 0 || ((nums[pointer]<nums.length || 
             nums[pointer]>0) && nums[nums[pointer]-1] == nums[pointer])) {
                pointer++;
            } else {
                int temp = nums[nums[pointer]-1];
                nums[nums[pointer]-1] = nums[pointer];
                nums[pointer] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) if (nums[i] != i+1) return i+1;
        // if code reaches this point, that means
        // nums arrays is sorted from 1 to N
        // hence the smallest missing number in N+1
        return nums[nums.length-1]+1;
    }
}
