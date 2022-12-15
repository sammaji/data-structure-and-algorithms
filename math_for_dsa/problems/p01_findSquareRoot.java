package math_for_dsa.problems;

public class p01_findSquareRoot {
    public static void main(String[] args) {
        int number = 1699;
        double square_root = findSquareRootNewtonRapson(number);
        System.out.println(Math.sqrt(number));
        System.out.println(square_root);
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
            mid = start + (int) ((end - start) / 2);
            if (mid * mid > number) {
                end = mid - 1;
            } else if (mid * mid < number) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        for (int i = 1; i <= decimal_places; i++) {
            System.out.println("ans" + mid);
            while (mid * mid < number) {
                System.out.println(1 / Math.pow(10, i));
                mid += 1 / Math.pow(10, i);
            }
        }
        return Math.floor(mid * 100) / 100;
    }

    // for variable iterations
    public static double findSquareRootNewtonRapson(int number) {
        if (number < 0)
            throw new IllegalArgumentException("Square Root of a negative number is not possible");
        double guess = (number > 1) ? number / 2 : 1;

        double error;
        do {
            error = Math.abs((guess - (number / guess))*0.5);
            guess = 0.5 * (guess + (number / guess));
        } while (error > 0.01); // 0.01 is the weight; more the weight, more accurate result
        return guess;
    }

    // for fixed iterations
    public static double findSquareRootNewtonRapson(int number, int steps) {
        if (number < 0)
            throw new IllegalArgumentException("Square Root of a negative number is not possible");
        double guess = (number > 1) ? number / 2 : 1;
        for (int i = 0; i < steps; i++)
            guess = 0.5 * (guess + (number / guess));
        return guess;
    }
}