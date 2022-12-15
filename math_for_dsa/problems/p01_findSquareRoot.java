package math_for_dsa.problems;

public class p01_findSquareRoot {
    public static void main(String[] args) {
        int no = 27;
        System.out.printf("sqrt = %s", Math.sqrt(no));
        System.out.println();
        double sq = findExactSquareRoot(no, 3);

        if (sq == -1)
        System.out.printf("sqrt of %s does not exists", no);
        else
        System.out.println(sq);
    }

    // binary search algo to find integer part of sqrt of a number
    public static double findSquareRoot(int number) {
        int start = 0;
        int end = number;
        int mid = -1;

        if (number < 0)
            throw new IllegalArgumentException("Square Root of a negative number is not possible");

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (mid * mid > number) {
                end = mid - 1;
            } else if (mid * mid < number) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return mid;
    }

    public static double findExactSquareRoot(int number, int decimal_places) {
        double start = 0;
        double end = number;
        double mid = -1;

        if (number < 0)
            throw new IllegalArgumentException("Square Root of a negative number is not possible");

        while (start <= end) {
            mid = start + (int)((end - start) / 2);
            if (mid * mid > number) {
                end = mid - 1;
            } else if (mid * mid < number) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        for (int i=1; i <= decimal_places; i++) {
            System.out.println("ans" + mid);
            while (mid*mid < number) {
                System.out.println(1/Math.pow(10, i));
                mid += 1/Math.pow(10, i);
            }
        }
        return Math.floor(mid * 100) / 100;
    }
}