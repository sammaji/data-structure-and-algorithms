package Problems;

public class PeakElementInBitonicArray {
    public static void main(String[] args) {
        int[] arr = {1,3,4,6,9,10,15,5,4,3,2,1};
        int ans = PeakElement(arr);
        System.out.println(ans);
    }

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