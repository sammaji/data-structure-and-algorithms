/**
 * Using binary search algorithm to search for a target
 * in a given sorted array
 */
public class BinarySearch {
    public static void main(String[] args) {
        // setup and init
        int[] sample_array = new int[10];
        for (int i = 0; i < sample_array.length; i++) {
            sample_array[i] = i+10;
        }
        System.out.println(
            "answer "+
            binary_search(sample_array, 13)
        );
    }


    public static int binary_search(int[] sample, int target) {
        int leftPointer = 0;
        int rightPointer = sample.length-1;
        int midPointer;

        while(leftPointer<rightPointer) {
            midPointer = (leftPointer+rightPointer)/2;
            System.out.println("midPointer "+midPointer);
            System.out.println("sample "+sample[midPointer]);

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