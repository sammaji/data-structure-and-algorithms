package a1_search_algo.Problems;

public class p03_PeakElementInBitonicArray {
    static int PeakElement(int[] sample) {
        int start = 0;
        int end = sample.length-1;
        int mid;

        while(start!=end) {
            mid = start + (end-start)/2;
            // descending series
            if (sample[mid] > sample[mid+1]) {
                // search from start to mid
                // include mid as we do not
                // know if sample[mid-1]>sample[mid]
                end = mid;
            } else if (sample[mid] < sample[mid+1]) {
                start = mid+1;
            } else return sample[mid];
        }
        return sample[end];
    }
}