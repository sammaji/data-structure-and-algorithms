package misc;

import org.jetbrains.annotations.NotNull;

/**
 * @question 1: Find factorial
 * @question 2: Reverse a string in Linear Time
 */
public class easy_problems {
    public static void main(String[] args) {
        System.out.println(isArmstrongNumber(153));
    }

    static int factorial(int n) {
        if (n==1) return 1;
        return n*factorial(n-1);
    }

    static String reverseString(@NotNull String string) {
        String reversedString = "";
        for (int i=string.length()-1; i>=0; i--) {
            reversedString = reversedString.concat(
                    String.valueOf(string.charAt(i))
            );
        }
        return reversedString;
    }

    static boolean isArmstrongNumber(int num) {
        return false;
    }

}
