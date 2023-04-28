package patterns;

public class PatternNineteen {
    public static void main(String[] args) {
        printPattern(10);
    }

    public static void printPattern(int row) {
        int upper = (row % 2 == 0) ? row / 2 : row / 2 + 1;
        for (int i = 0; i < upper; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }

            for (int j = 0; j < 2 * (upper - i - 1); j++) {
                System.out.print(" ");
            }

            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        int lower = row / 2;
        for (int i = 0; i < lower; i++) {
            for (int j = 0; j < lower - i; j++) {
                System.out.print("*");
            }

            if (row % 2 == 0) {
                for (int j = 0; j < 2 * i; j++) {
                    System.out.print(" ");
                }
            } else {
                for (int j = 0; j < 2 * (i + 1); j++) {
                    System.out.print(" ");
                }
            }

            for (int j = 0; j < lower - i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
