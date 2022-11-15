package a1_search_algo.Problems;

/**
 * @Date : 08/11/2022
 * @Question 01 : Find the ceiling of given number from an array.
 * Ceiling of a number (here) is the samllest number greater than
 * or equal to the given number
 * <p>
 * eg, array = {2,3,5,9,13,16,18}
 * findCeiling(arr, 10) = 13;
 * findCeiling(arr, 25) = 18;
 */
public class p02_FindCeilingInArray {

    public static void main(String[] args) {
        int[] arr = {2,3,5,9,13,16,18};
        int result = findFloor(arr, 1);
        System.out.println(result);
    }

    /**
     * using two pointer approach
     */
    static int findCeiling(int[] sample, int target) {
        int leftPointer = 0;
        int rightPointer = sample.length-1;
        int midPointer;

        if (sample[leftPointer] == target || sample[rightPointer] == target) return target;
        else if (sample[leftPointer] > target) return sample[leftPointer];

        while (leftPointer<=rightPointer) {
            midPointer = leftPointer + ((rightPointer-leftPointer)/2);

            if (sample[midPointer] >= target && sample[midPointer-1] <target) {
                return sample[midPointer];
            } else if (sample[midPointer] < target) {
                leftPointer = midPointer+1;
            } else if (sample[midPointer] > target) {
                rightPointer = midPointer-1;
            }
        }
        return -1; // when target is bigger than the max element in sample
    }


    // find the biggest number less than or equal to target
    static int findFloor(int[] sample, int target) {
        int leftPointer = 0;
        int rightPointer = sample.length-1;
        int midPointer;

        if (sample[rightPointer] <= target) return sample[rightPointer];
        else if (sample[leftPointer] == target) return target;

        while (leftPointer<=rightPointer) {
            midPointer = leftPointer+((rightPointer-leftPointer)/2);
            if (sample[midPointer]<=target && sample[midPointer+1]>target) return sample[midPointer];
            else if (sample[midPointer] < target) leftPointer = midPointer+1;
            else if (sample[midPointer] > target) rightPointer = midPointer-1;
        }
        return -1;
    }


    /**
     * @Question : Leetcode 744. Find The Smallest Letter Greater Than Target
     * You are given an array of characters letters that is sorted in non-decreasing order, and a character target.
     * There are at least two different characters in letters.
     * Return the smallest character in letters that is lexicographically greater than target.
     * If such a character does not exist, return the first character in letters.
     * Example 1:
     * Input: letters = ["c","f","j"], target = "a"
     * Output: "c"
     * Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.
     * Example 2:
     * Input: letters = ["c","f","j"], target = "c"
     * Output: "f"
     * Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.
     * Example 3:
     * Input: letters = ["x","x","y","y"], target = "z"
     * Output: "x"
     * Explanation: There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].
     */
    public char nextGreatestLetter(char[] letters, char target) {
        // two pointer approach
        int leftPointer = 0;
        int rightPointer = letters.length-1;
        int midPointer;

        if (letters[leftPointer]>target) return letters[leftPointer];
        else if (letters[leftPointer] == target) return letters[1];

        while(leftPointer<=rightPointer) {
            midPointer = leftPointer + ((rightPointer-leftPointer)/2);
            if (letters[midPointer]>target && letters[midPointer-1]<target) return letters[midPointer];
            else if(letters[midPointer] < target) {
                leftPointer = midPointer +1;
            }
            else if(letters[midPointer] > target) {
                rightPointer = midPointer-1;
            }
        }
        return letters[0];
    }
}
