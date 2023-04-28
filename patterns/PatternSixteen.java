package patterns;

public class PatternSixteen {
    public static void main(String[] args) {
        printPattern(5);
    }

    /**
     * @param index starts with zero
     * @param row   starts with zero
     * @return
     */
    public static int getPascalInt(int index, int row) {
        if (row == 0 || row == 1 || index == 0 || index == row)
            return 1;
        return getPascalInt(index - 1, row - 1) + getPascalInt(index, row - 1);
    }

    public static void printPattern(int row) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < (row - i) - 1; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j <= i; j++) {
                System.out.print(getPascalInt(j, i) + " ");
            }

            System.out.println();
        }
    }
}
