package patterns;

public class PatternTwelve {
    public static void main(String[] args) {
        printPattern(10);
    }

    public static void printPattern(int row) {
        if (row % 2 == 0) {
            PatternEleven.printPattern(row / 2);
            PatternTen.printPattern(row / 2);
        } else {
            PatternEleven.printPattern((row / 2) + 1);

            for (int i = 0; i < row / 2 + 1; i++) {
                if (i == 0)
                    continue;

                for (int j = 0; j < row / 2 - i; j++) {
                    System.out.print(" ");
                }

                for (int j = 0; j <= i; j++) {
                    System.out.print("* ");
                }

                System.out.println();
            }
        }
    }
}
