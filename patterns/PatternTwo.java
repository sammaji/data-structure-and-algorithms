package patterns;

public class PatternTwo {
    public static void main(String[] args) {
        printPattern(5);
    }

    public static void printPattern(int row) {
        for(int i=0; i<row; i++) {
            for (int j=0; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
