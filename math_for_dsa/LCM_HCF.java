package math_for_dsa;

public class LCM_HCF {
    /**
     * HCF -> Highest Common Factor
     * also called GCD -> Greatest Common Divisor
     * 
     * Euclidean algorithm:
     * GCD(a, b) = GCD(b%a, b)
     */
    public int HCF(int a, int b) {
        System.out.print(1);
        if (b%a == 0) return a;
        return HCF(b%a, a);
    }

    /**
     * LCM -> Lowest Common Multiple
     * 
     * Formula:
     * LCM * HCF = a * b
     */
    public int LCM(int a, int b) {
        return (a*b)/HCF(a, b);
    }
}