package a3_sorting_algo;

public class BubbleSort {
    Package a3_sorting_algo;
    
    public static void main(String[] args) {
        int[] arrWithoutRepeatition = {
            1,3,4,2,6,15,17,21,9,7,20,19
        };

        int[] arrWithRepeatition = {
            15,2,1,3,4,2,6,4,15,17,
            21,9,7,20,19,19,21,18,6,2,
            17,15,2,17
        };

        int[] result = bubbleSort(arrWithoutRepeatition);
        for (int element : result) System.out.print(element+",");
        result = bubbleSort(arrWithRepeatition);
        for (int element : result) System.out.print(element+",");

    }

    static int[] bubbleSort(int[] sample) {
        // i is the number of steps
        // j is the index of each element in array
        for (int i = 0; i < sample.length; i++) { 
            // after i-th step, the i-th largest index
            // goes to the (n-i)th position
            // after 3rd step, the 3rd largest element
            // goes to the 3rd last position
            for (int j = 0; j < sample.length-1; j++) {
                if (sample[j] > sample[j+1]) {
                    // swap
                    int a = sample[j+1];
                    sample[j+1] = sample[j];
                    sample[j] = a;
                }
            }
        }
        return sample;
    }
}
