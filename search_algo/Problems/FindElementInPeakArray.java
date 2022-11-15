public class FindInPeakArray {
    public static void main(String[] args) {

    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length()-1;
        int mid;

        int peakIndex = 0;

        // finding peak element
        // O(ln(n))
        while (start < end) {
            mid = start + (end-start)/2;

            if (mountainArr.get(mid) > mountainArr.get(mid+1)) {
                // descending part
                // we dont now if e[mid-1]>e[mid]
                end = mid;
            } else if (mountainArr.get(mid) < mountainArr.get(mid+1)) {
                start = mid+1;
            } else {
                peakIndex = mid;
                break;
            }
        }
        peakIndex = end;

        int minIndex = mountainArr.length()-1;

        // searching in ascending part
        start = 0;
        end = peakIndex-1;

        while (start <= end) {
            mid = start + (end-start)/2;
            if (mountainArr.get(mid) > target) {
                // check left
                end = mid-1;
            } else if (mountainArr.get(mid) < target) {
                // check right
                start = mid+1;
            } else {
                // return the minimum index
                if (mid < minIndex) minIndex = mid;
                break;
            }
        }

        // searching in descending part
        start = peakIndex+1;
        end = mountainArr.length()-1;

        while (start <= end) {
            mid = start + (end-start)/2;
            if (mountainArr.get(mid) < target) {
                // check left
                end = mid-1;
            } else if (mountainArr.get(mid) > target) {
                // check right
                start = mid+1;
            } else {
                // return the minimum index
                if (mid < minIndex) minIndex = mid;
                break;
            }
        }
        // target might or might not be at the last index
        if (mountainArr.get(minIndex) != target && minIndex == (mountainArr.length()-1)) return -1;
        else return minIndex;
    }
}

public class MountainArray() {
    public MountainArray() {
        int length;
    }

    public int get(int index) {
        return;
    }
}