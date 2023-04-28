package patterns;

public class PatternTwenty {
    public static void main(String[] args) {
        printPattern(5, 4);
    }

    public static void printPattern(int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || i == row - 1 || j == 0 || j == col - 1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }

    }
}
