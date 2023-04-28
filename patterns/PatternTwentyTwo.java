package patterns;

public class PatternTwentyTwo {
    public static void main(String[] args) {
        printPattern(5);
    }

    public static void printPattern(int row) {
        boolean iterate = true;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print((iterate ? 1 : 0) + " ");
                iterate = !iterate;
            }
            System.out.println();
        }
    }
}
