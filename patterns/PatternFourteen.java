package patterns;

public class PatternFourteen {
    public static void main(String[] args) {
        printPattern(5);
    }

    public static void printPattern(int row) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < 2 * (row - i) - 1; j++) {
                if (j == 0 || j == 2 * (row - i - 1) || i == 0)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }

            System.out.println();
        }
    }
}
