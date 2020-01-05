/*
 * takes two names as command-line arguments and prints hello and goodbye messages
 * as shown below (with the names for the hello message in the same order as the command-line 
 * arguments and with the names for the goodbye message in reverse order).
 */

package hellogoodbye;
import java.util.Scanner;

/**
 *
 * @author edima
 */
public class HelloGoodbye {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        //  prompt for the user's name
        System.out.print("Enter two names like this name1 and name2");
        // get their input as a String
        String username = scanner.next();
        
        int andPosition = username.indexOf("and");
        String firstName = "";
        String lastName = "";
        
        //Generate output 1
        System.out.println("Hello " + firstName + " and " + lastName);
        //Generate output 2
        System.out.println("Goodbye " + lastName + " and " + firstName);
        
    }
    
}
