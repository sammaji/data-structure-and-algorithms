package patterns;

public class PatternEighteen {
    public static void main(String[] args) {
        printPattern(10);
    }

    public static void printPattern(int row) {
        int upper;
        if (row % 2 == 0)
            upper = row / 2;
        else
            upper = row / 2 + 1;

        for (int i = 0; i < upper; i++) {
            for (int j = 0; j < (upper - i); j++)
                System.out.print("*");

            for (int j = 0; j < i; j++)
                System.out.print(" ");

            for (int j = 0; j < i - 1; j++)
                System.out.print(" ");

            for (int j = 0; j < (upper - i); j++)
                if (i != 0 || j != 0)
                    System.out.print("*");

            System.out.println();
        }

        int lower = row / 2;
        for (int i = 0; i < lower; i++) {

            if (row % 2 != 0)
                System.out.print("*");

            for (int j = 0; j <= i; j++)
                System.out.print("*");

            for (int j = 0; j < lower - i - 1; j++)
                System.out.print(" ");

            for (int j = 0; j < lower - i - 2; j++)
                System.out.print(" ");

            for (int j = 0; j <= i; j++)
                if (j != 0 || i != lower - 1)
                    System.out.print("*");

            if (row % 2 != 0)
                System.out.print("*");

            System.out.println();
        }
    }

}
