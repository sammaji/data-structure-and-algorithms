package patterns;

public class PatternOne {
    public static void main(String[] args) {
        printPattern(5, 5);
    }

    public static void printPattern(int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
