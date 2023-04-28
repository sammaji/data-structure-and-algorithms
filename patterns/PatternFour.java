package patterns;

public class PatternFour {
    public static void main(String[] args) {
        printPattern(5);
    }

    public static void printPattern(int row) {
        for(int i=0; i<row; i++) {
            for (int j=0; j<=i; j++) {
                System.out.print(j+1);
            }
            System.out.println();
        }
    }
}
