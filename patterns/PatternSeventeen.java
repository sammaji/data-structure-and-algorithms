package patterns;

public class PatternSeventeen {
    public static void main(String[] args) {
        printPattern(7);
    }

    /**
     * @param index starts with 0
     * @param row   starts with 0
     * @return
     */
    public static int getTransformedValue(int index, int row) {
        return 1 + Math.abs(row - index);
    }

    public static void printPattern(int row) {
        int upper = (row % 2 == 0) ? row / 2 : row / 2 + 1;
        for (int i = 0; i < upper; i++) {
            for (int j = 0; j < upper - i - 1; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j <= 2 * i; j++) {
                System.out.print(getTransformedValue(j, i));
            }

            System.out.println();
        }

        int lower = row / 2;
        for (int i = lower - 1; i >= 0; i--) {

            if (row % 2 != 0)
                System.out.print(" ");

            for (int j = lower - 1; j > i; j--) {
                System.out.print(" ");
            }

            for (int j = 0; j <= 2 * i; j++) {
                System.out.print(getTransformedValue(j, i));
            }

            System.out.println();
        }
    }
}