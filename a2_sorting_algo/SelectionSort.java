package a2_sorting_algo;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arrWithoutRepeatition = {
            1,3,4,2,6,15,17,21,9,7,20,19
        };

        int[] arrWithRepeatition = {
            15,2,1,3,4,2,6,4,15,17,
            21,9,7,20,19,19,21,18,6,2,
            17,15,2,17
        };

        int[] result = selectionSort(arrWithoutRepeatition);
        for (int element : result) System.out.print(element+",");
        System.out.println();
        result = selectionSort(arrWithRepeatition);
        for (int element : result) System.out.print(element+",");
    }

    static int[] selectionSort(int[] sample) {
        for (int i = 0; i < sample.length; i++) {
            int max_element_index = 0;
            for (int j = 0; j < sample.length - i; j++) {
                if (sample[j] > sample[max_element_index]) max_element_index = j;
            }
            // put max element towards end
            int temp = sample[sample.length-i-1];
            sample[sample.length-i-1] = sample[max_element_index];
            sample[max_element_index] = temp;
        }
        return sample;
    }
}
