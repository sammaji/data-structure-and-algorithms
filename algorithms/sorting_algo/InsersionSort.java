package algorithms.sorting_algo;

public class InsersionSort {
    public static void main(String[] args) {
        int[] arrWithoutRepeatition = {
            1,3,4,2,6,15,17,21,9,7,20,19
        };

        int[] arrWithRepeatition = {
            15,2,1,3,4,2,6,4,15,17,
            21,9,7,20,19,19,21,18,6,2,
            17,15,2,17
        };

        int[] result = insersionSort(arrWithoutRepeatition);
        for (int element : result) System.out.print(element+",");
        System.out.println();
        result = insersionSort(arrWithRepeatition);
        for (int element : result) System.out.print(element+",");
    }

    static int[] insersionSort(int[] sample) {
        for (int i = 0; i < sample.length-1 ; i++) {
            for (int j = i+1; j > 0; j--) {
                if (sample[j] < sample[j-1]) {
                    // swap
                    int temp = sample[j-1];
                    sample[j-1] = sample[j];
                    sample[j] = temp;
                } else if (sample[j] > sample[j-1]) {
                    // as the part 0 to j-1 is already sorted
                    // hence is sample[j] > sample[j-1], then that means,
                    // the part 0 to j is sorted
                    break;
                }
            }
        }
        return sample;
    }
}
