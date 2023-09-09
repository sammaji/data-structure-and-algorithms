package algorithms.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arrWithoutRepeatition = {
            1,3,4,2,6,15,17,21,9,7,20,19
        };

        mergeSort(arrWithoutRepeatition);

        int[] arrWithRepeatition = {
            15,2,1,3,4,2,6,4,15,17,
            21,9,7,20,19,19,21,18,6,2,
            17,15,2,17
        };

        mergeSort(arrWithRepeatition);

        System.out.println(Arrays.toString(arrWithoutRepeatition));
        System.out.println(Arrays.toString(arrWithRepeatition));
    }
    

    public static void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
    }

    public static void mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low)/2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid+1, high);
        merge(nums, low, mid, high);
    }

    public static void merge(int[] nums, int low, int mid, int high) {
        int start = low;
        int end = mid+1;

        int index = 0;
        int[] result = new int[high-low+1];

        while (start <= mid && end <= high) {
            if (nums[start] >= nums[end]) {
                result[index] = nums[end];
                end++;
            } else {
                result[index] = nums[start];
                start++;
            }
            index++;
        }

        if (start <= mid) {
            while (start <= mid) {
                result[index] = nums[start];
                start++;
                index++;
            }
        }
        else if (end <= high) {
            while(end <= high) {
                result[index] = nums[end];
                end++;
                index++;
            }
        }

        for (int i = 0; i < index; i++) {
            nums[low + i] = result[i];
        }
    }
}