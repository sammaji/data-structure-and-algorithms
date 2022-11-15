package a1_search_algo;

/**
 * Using binary search algorithm to search for a target
 * in a given sorted array
 */
public class BinarySearch {

    public static void main(String[] args) {}

    /**
     * implement binary search algorithm
     * @param sample - sorted array in ascending order which acts as search space
     * @param target - element to search for in search space
     * @return - returns index of the target in sample, otherwise returns -1
     */
    static int binarySearchAscending(int[] sample, int target) {
        int leftPointer = 0;
        int rightPointer = sample.length-1;
        int midPointer;

        while(leftPointer<=rightPointer) {
            /*
              do not use midPointer = (leftPointer + rightPointer)/2 to find average
              if both of them (leftPointer and rightPointer) are big integers, then
              their sum (leftPointer+rightPointer) might exceed the storage limit for int
             */
            midPointer = leftPointer + ((rightPointer-leftPointer)/2);

            if (sample[midPointer] == target) return midPointer;
            if (sample[midPointer]>target) rightPointer = midPointer-1;
            if (sample[midPointer]<target) leftPointer = midPointer+1;
        }
        return -1;
    }


    /**
     * implement binary search algorithm
     * @param sample - sorted array in descending order which acts as search space
     * @param target - element to search for in search space
     * @return - returns index of the target in sample, otherwise returns -1
     */
    static int binarySearchDescending(int[] sample, int target) {
        int leftPointer = 0;
        int rightPointer = sample.length -1;
        int midPointer;

        while (leftPointer<=rightPointer) {
            midPointer = leftPointer + ((rightPointer-leftPointer)/2);

            if (sample[midPointer] == target) return midPointer;
            if (sample[midPointer] > target) leftPointer = midPointer+1;
            if (sample[midPointer] < target) rightPointer = midPointer-1;
        }
        return  -1;
    }


    /**
     * implement order-agnostic binary search algorithm
     * @param sample - sorted array in ascending or descending order which acts as search space
     * @param target - element to search for in search space
     * @return - returns index of the target in sample, otherwise returns -1
     */
    static int binarySearchOrderAgnostic(int[] sample, int target) {
        int start = 0;
        int end = sample.length-1;

        if (sample[start]<sample[end]) return binarySearchAscending(sample, target);
        else if (sample[start]>sample[end]) return binarySearchDescending(sample, target);
        else return -1;
    }
}