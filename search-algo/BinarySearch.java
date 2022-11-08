/**
 * Using binary search algorithm to search for a target
 * in a given sorted array
 */
public class BinarySearch {
    public static void main(String[] args) {
        // setup and init
        int[] sample_array = new int[100];
        for (int i = 0; i < sample_array.length; i++) {
            sample_array[i] = i+10;
        }
        int[] sample_array2 = {5,6,7,8,9,10};
        System.out.println(
            "answer "+
            binary_search(sample_array, 57)
        );
    }


    public static int binary_search(int[] sample, int target) {
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

            if (sample[midPointer] == target) {
                return midPointer;
            }
            if (sample[midPointer]>target) {
                rightPointer = midPointer-1;
            }
            if (sample[midPointer]<target) {
                leftPointer = midPointer+1;
            }
        }
        return -1;
    }
}