import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The Input class provides methods for safely prompting the user for integer
 * input
 * using a given Scanner object, handling exceptions and providing error
 * messages
 * as needed.
 */
public class Input {
    /*
     * the code was taken from
     * https://stackoverflow.com/questions/26375630/hot-to-stop-the-program-from-
     * crashing-after-a-string-is-entered-instead-of-an-in
     * last accessed 17/10/2023
     */

    /**
     * Prompts the user for an integer input and handles InputMismatchException.
     *
     * @param prompt  The message to display to the user before input.
     * @param scanner The Scanner object used to read user input.
     * @return The integer entered by the user.
     */
    public static int promptInt(String prompt, Scanner scanner) {
        if (!prompt.equals("")) {
            System.out.println(prompt);
        }

        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error: expected a whole number, try again");
            scanner.next();
            return promptInt(prompt, scanner);
        }
    }
}
