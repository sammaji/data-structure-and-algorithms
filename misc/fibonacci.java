
/**
 * @question 01 : Write a program that prints the nth fibonacci number
 * @question 02 : Write a program that prints the nth fibonacci number using
 *           recursion
 * @question 03 : Write a program that prints the nth fibonacci number using
 *           bottom up approach
 */

public class fibonacci {
    /**
     * @sol: @problem 01
     *       DATE: 07-11-22
     */
    static int fib(int n) {
        if (n == 1 || n == 2)
            return 1;
        int[] numbers = new int[n];
        numbers[0] = 1;
        numbers[1] = 1;
        for (int i = 2; i < n; i++) {
            numbers[i] = numbers[i - 1] + numbers[i - 2];
        }
        return numbers[n - 1];
    }

    /**
     *
     */
    static int fib_recursion(int n) {
        if (n == 1 || n == 2)
            return 1;
        return fib_recursion(n - 1) + fib_recursion(n - 2);
    }

    static int fib_bottom_up(int n) {
        return n;
    }

    static int fib_formula(int n) {
        return (int) ((Math.pow(((1 + Math.sqrt(5)) / 2), n) - Math.pow(((1 - Math.sqrt(5)) / 2), n)) / (Math.sqrt(5)));
    }
}
