package misc;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * @question 01 : Write a program that prints the nth fibonacci number
 * @question 02 : Write a program that prints the nth fibonacci number using recursion
 * @question 03 : Write a program that prints the nth fibonacci number using bottom up approach
 */

public class Fibonacci {
    public static void main(String[] args) {
        int index = 1000;
        double time;
        Stopwatch stopwatch = new Stopwatch();

        System.out.println(fib(index));
        time = stopwatch.elapsedTime();
        System.out.println(time);

        System.out.println(fib_recursion(index));
        time = stopwatch.elapsedTime() - time;
        System.out.println(time);

        System.out.println(fib_bottom_up(index));
        time = stopwatch.elapsedTime() - time;
        System.out.println(time);
    }

    /**
     * @sol: @problem 01
     * DATE: 07-11-22
     */
    static int fib(int n) {
        if (n==1 || n==2) return 1;
        int[] numbers = new int[n];
        numbers[0] = 1; numbers[1] = 1;
        for (int i=2; i<n ; i++) {
            numbers[i] = numbers[i-1]+numbers[i-2];
        }
        return numbers[n-1];
    }

    /**
     *
     */
    static int fib_recursion(int n) {
        if (n == 1 || n == 2) return 1;
        return fib_recursion(n-1) + fib_recursion(n-2);
    }

    static  int fib_bottom_up(int n) {
        return n;
    }
}
