package algorithms.search.Problems;

/**
 * @Date : 11/11/22
 * @Question 02 : Search in a aorted infinite array in log time.
 * Infinite array means a large array and array.length is not available.
 */
public class p01_SearchInInfiniteArray {
    /**
     * APPROACH:
     * First divide the array in chunks.
     * This can be done by taking chunks of fixed size (linear time)
     * Or by doubling the size every time we search.
     * If the element is in the search space, apply binary search.
     */
    static int binarySearchOnInfiniteArray(int[] sample, int target) {
        int leftPointer = 0;
        int rightPointer =0;
        int searchSpace=1;

        boolean isElementInSearchSpace = false;
        while(!isElementInSearchSpace) {
            rightPointer = leftPointer+searchSpace;
            if(target<=sample[rightPointer] && target>=sample[leftPointer]) {
                isElementInSearchSpace = true;
                break;
            } else {
                searchSpace = 2*searchSpace;
            }
            leftPointer = rightPointer+1;
        }

        int midPointer;
        while(leftPointer<=rightPointer) {
            midPointer = leftPointer + ((rightPointer-leftPointer)/2);
            if (sample[midPointer] == target) {
                return midPointer;
            } else if (sample[midPointer] > target) {
                rightPointer = leftPointer-1;
            } else if (sample[midPointer] < target) {
                leftPointer = leftPointer+1;
            }
        }
        return -1;
    }
}
