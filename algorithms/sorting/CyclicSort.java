package algorithms.sorting;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] unsorted_array = {
            2,3,5,7,1,4,6
        };
        cyclicSort(unsorted_array);
        System.out.println(Arrays.toString(unsorted_array));
    }

    static int[] cyclicSort(int[] sample) {
        int pointer = 0;
        while(pointer <= sample.length-2) {
            if (sample[pointer] == pointer+1) {
                pointer++;
            } else {
                int temp = sample[sample[pointer]-1] ;
                sample[sample[pointer]-1] = sample[pointer];
                sample[pointer] = temp;
            }
        }
        return sample;
    }
}