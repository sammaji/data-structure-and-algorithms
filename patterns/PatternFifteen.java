package patterns;

public class PatternFifteen {
    public static void main(String[] args) {
        printPattern(9);
    }

    public static void printPattern(int row) {
        int upper;

        if (row % 2 == 0)
            upper = row / 2;
        else
            upper = row / 2 + 1;

        for (int i = 0; i < upper; i++) {
            for (int j = 0; j < upper - i - 1; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j <= 2 * i; j++) {
                if (j == 0 || j == 2 * i)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }

            System.out.println();
        }

        for (int i = 0; i < row/2; i++) {
            if (row % 2 != 0) System.out.print(" ");
            
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j <= 2 * (row/2 - i - 1); j++) {
                if (j == 0 || j == 2 * (row/2 - i - 1))
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
