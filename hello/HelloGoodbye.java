/**
 * @assignment: Write a program HelloGoodbye.java that takes two names
 *  as command-line arguments and prints hello and goodbye messages as 
 * shown below (with the names for the hello message in the same order
 *  as the command-line arguments and with the names for the goodbye
 *  message in reverse order).
 */

package hello;
import edu.princeton.cs.algs4.StdIn;

public class HelloGoodbye {
    public static void main(String[] args) {
        System.out.println("Enter two names (separated by blank space)");
        String name1 = StdIn.readString();
        String name2 = StdIn.readString();
        System.out.println("Hello "+name1+" and "+name2+".");
        System.out.println("Goodbye "+name2+" and "+name1+".");
    }
}