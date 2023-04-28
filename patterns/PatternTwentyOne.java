package patterns;

public class PatternTwentyOne {
    public static void main(String[] args) {
        printPattern(5);
    }

    public static void printPattern(int row) {
        int counter = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(counter++ + " ");
            }
            System.out.println();
        }
    }
}
