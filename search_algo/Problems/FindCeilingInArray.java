package Problems;

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
public class FindCeilingInArray {

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
}
