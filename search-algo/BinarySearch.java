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
        int leftpointer = 0;
        int rightpointer = sample.length-1;
        int midpointer;

        while(leftpointer<rightpointer) {
            midpointer = (leftpointer+rightpointer)/2;
            System.out.println("midpointer "+midpointer);
            System.out.println("sample "+sample[midpointer]);

            if (sample[midpointer] == target) {
                
                return midpointer;
            }
            if (sample[midpointer]>target) {
                rightpointer = midpointer;
            }
            if (sample[midpointer]<target) {
                leftpointer = midpointer;
            }
        }
        return -1;
    }
}