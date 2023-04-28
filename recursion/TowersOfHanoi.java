package recursion;

public class TowersOfHanoi {
    public static void main(String[] args) {
        solveTowersOfHanoi(2, 3);
    }

    /**
     * peg --> 1,2,3
     * 
     * @param peg - which peg to take the disks assuming the disks are at peg 1
     */
    public static void solveTowersOfHanoi(int numberOfDisks, int peg) {

        if (numberOfDisks == 1) {
            print(0, 1, 2);
            print(1, 1, 3);
            print(0, 1, 3);
        } else {
            solveTowersOfHanoi(numberOfDisks - 1, 2);

            // mov n-th disk
            print(numberOfDisks, 1, 3);
            
            solveTowersOfHanoi(numberOfDisks-1, 3);
        }
    }

    private static void print(int disk, int pegInitial, int pegFinal) {
        System.out.printf("disk:%d from:%d --> to:%d\n", disk, pegInitial, pegFinal);
    }

}
