package patterns;

public class PatternFive {
    public static void main(String[] args) {
        printPattern(9);
    }

    public static void printPattern(int row) {
        int upper, lower;

        if (row % 2 == 0) {
            upper = lower = row / 2;
        } else {
            upper = row / 2 + 1;
            lower = row / 2;
        }

        for (int i = 0; i < upper; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 0; i < lower; i++) {
            for (int j = 0; j < lower - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
