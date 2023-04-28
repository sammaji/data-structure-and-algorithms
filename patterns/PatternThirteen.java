package patterns;

public class PatternThirteen {
    public static void main(String[] args) {
        printPattern(5);
    }

    public static void printPattern(int row) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row - i - 1; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j <= 2 * i; j++) {
                if (j == 0 || j == 2 * i || i == row - 1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }

            System.out.println();
        }
    }
}
