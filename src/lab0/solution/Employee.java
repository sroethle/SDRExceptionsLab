package lab0.solution;

import lab0.*;
import java.util.Date;

/**
 * In this challenge you need to address the probability that at some
 * point the arguments to method parameters may not be valid. 
 * <p>
 * For example, String arguments may be null or empty; other objects may be 
 * null; or primitive numbers may be out of acceptable range.
 * <p>
 * You need to validate ALL method parameters to make sure any and all 
 * arguments are valid. The only exception is when any argument is acceptable 
 * based on requirements. Fix the code below using if logic to validate
 * method arguments and throw IllegalArgumentException or a custom
 * exception if the validation fails.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */

/**
 * This class is a simulation of a real world employee that manages 
 * information about that employee.  CAUTION: This is a first draft and is likely to 
 * change.
 * 
 * @author sroethle
 * @version 1.00
 */
public class Employee {
    /** Global constant for maximum allowed vacation days*/
    public static final int MAX_VACATION_DAYS = 28;
    public static final int MIN_VACATION_DAYS = 0;
    public static final String DAY_RANGE_MSG = "Only Values from 0 to 28 allowed for vacation";
    public static final String NO_VALUE_MSG = "No Value Found";
    public static final String BAD_SS_NUM_MSG = "Social Security number must be 9 characters";
    private String firstName;
    private String lastName;
    private String ssn;
    private Date hireDate;
    private int daysVacation;

    /**
     * Default Constructor
     */
    public Employee() {
        firstName = "Unknown";
        lastName = "Unknown";
        ssn = "Unknown";
        hireDate = new Date();
        daysVacation = 0;
    }

    /**
     * Custom Convenience Constructor for Employee class
     * @param firstName cannot be null or empty
     * @param lastName cannot be null or empty
     * @param ssn must be valid
     * @param hireDate must be within acceptable range
     * @param daysVacation must be within acceptable range
     */
    public Employee(String firstName, String lastName, String ssn, Date hireDate, int daysVacation) {
        setFirstName(firstName);
        setLastName(lastName);
        setHireDate(hireDate);
        setDaysVacation(daysVacation);   
    }
    
    /**
     * 
     * @return days Vacation
     */
    public int getDaysVacation() {
        return daysVacation;
    }
/**
 * Sets the number of vacation days allowed for an employee or the number
 * remaining for an employee. 
 * 
 * @param daysVacation days of vacation allowed per year. a value between MIN and MAX
 * @throws IllegalArgumentException if value out of range between MIN and MAX
 */
    public final void setDaysVacation(int daysVacation) throws IllegalArgumentException {
        if(daysVacation < MIN_VACATION_DAYS || daysVacation > MAX_VACATION_DAYS){
            throw new IllegalArgumentException(DAY_RANGE_MSG);
        }
        this.daysVacation = daysVacation;
    }

    public String getFirstName() {
        return firstName;
    }
/**
 * Sets the first name of this employee.
 * 
 * @param firstName first name of Employee
 * @throws IllegalArgumentException if null or nothing
 */
    public final void setFirstName(String firstName) throws IllegalArgumentException {
        
        if (firstName == null || firstName.length() == 0){
            throw new IllegalArgumentException(NO_VALUE_MSG);
        }
        this.firstName = firstName;
    }

    public Date getHireDate() {
        return hireDate;
    }

    /**
     * Sets the date this employee was hired.
     * @param hireDate date Employee was hired.
     * @throws IllegalArgumentException if date employee was hired is null
     */
    public final void setHireDate(Date hireDate) throws IllegalArgumentException {
        if (hireDate == null || hireDate.after(today)){
            throw new IllegalArgumentException(NO_VALUE_MSG);
        }
        this.hireDate = hireDate;
    }

    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of this employee
     * @param lastName last name of Employee
     * @throws IllegalArgumentException if not at least 1 character in length
     */
    public final void setLastName(String lastName) throws IllegalArgumentException {

        if (lastName == null || lastName.length() == 0) {
            throw new IllegalArgumentException(NO_VALUE_MSG);
        }

        this.lastName = lastName;
    }

    public final String getSsn() {
        return ssn;
    }

    /**
     * Sets the social security number of this employee
     * @param ssn social security of Employee
     * @throws IllegalArgumentException if not equal to 9 characters or null
     */
    public void setSsn(String ssn) throws IllegalArgumentException {

        if (ssn == null || ssn.length() != 9) {
            throw new IllegalArgumentException(BAD_SS_NUM_MSG);
        }
        char[] chars = ssn.toCharArray();
        for (char c : chars) {
            if (!(Character.isDigit(c))) {
                throw new IllegalArgumentException("Illegal SSN");
            }
        }

        this.ssn = ssn;
    }
}
