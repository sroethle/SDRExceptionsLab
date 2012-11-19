package lab2.solution;

import lab2.*;

/**
 * This class provides various services relating to name manipulation.
 * No output should be performed here.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class NameService {
    private static final int FIRST_NAME_IDX = 0;
    private static final int LAST_NAME_IDX = 1;
    public static final String NO_VALUE_MSG = "No Value Found";
    
    /**
     * Finds and returns the last name from within a full name. Caution: 
     * No validation is performed.
     * 
     * @param fullName - a name containing a first name and a last name
     * @return the last name
     */
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
    
    /**
     * Finds and returns the first name from within a full name. Caution: 
     * No validation is performed.
     * 
     * @param fullName - a name containing a first name and a last name
     * @return the first name
     */
    public String extractFirstName(String fullName) {
        String[] nameParts = fullName.split(" ");
        return nameParts[FIRST_NAME_IDX];
    }

    /**
     * Gets the length of a name.
     * 
     * @param name - any full name or part of a name.
     * @return the length of the name or part.
     */
    public int getNameLength(String name) {
        return name.length();
    }
    
}
