package patterns;

public class PatternSeven {
    public static void main(String[] args) {
        printPattern(5);
    }

    public static void printPattern(int row) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < row - i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
