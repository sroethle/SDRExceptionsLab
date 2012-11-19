package lab1.solution;

import java.util.regex.PatternSyntaxException;
import lab1.*;
import javax.swing.JOptionPane;
import sun.security.util.Length;

/**
 * The purpose of this challenge is to give you practice time using
 * Java Exception handling techniques.
 * <p>
 * Your challenge is to consider all the possible things that can go wrong
 * with this program and use exception handling where appropriate to prevent
 * the program from crashing. In addition you must display a friendly error
 * message in a JOptionPane and ask the user to try again.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Challenge1 {
    private static final int LAST_NAME_IDX = 1;
    public static final String NO_VALUE_MSG = "No Value Found";

    public static void main(String[] args) {
        Challenge1 app = new Challenge1();
        String fullName = JOptionPane.showInputDialog("Enter full name:");

        try {
            String lastName = app.extractLastName(fullName);
            String msg = "Your last name is: " + lastName;
            JOptionPane.showMessageDialog(null, msg);
        } catch (IllegalArgumentException iae) {
            JOptionPane.showMessageDialog(null, iae.getMessage());
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(null, npe.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public String extractLastName(String fullName) throws IllegalArgumentException, NullPointerException {
        
        if (fullName == null || fullName.length() == 0) {
            throw new NullPointerException(NO_VALUE_MSG);
        } else if (!fullName.contains(" ")) {
            throw new IllegalArgumentException("You must enter a first and last name!");
        } else if (fullName.matches(".*\\d.*")) {
            throw new IllegalArgumentException("You can't enter a number for a name");
        }

        String[] nameParts = fullName.split(" ");

        if (nameParts.length > 2) {
            throw new IllegalArgumentException("You must only enter a first and last name!");
        }

        return nameParts[LAST_NAME_IDX];
    }

}
