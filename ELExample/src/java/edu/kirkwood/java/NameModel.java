package edu.kirkwood.java;

import java.io.Serializable;

/**
 * A simple bean for the demonstration.
 *
 * @author Sean Geraets
 */
public class NameModel implements Serializable {

    /**
     * Needed for Serializable.
     */
    private static final long serialVersionUID = 1L;

    /**
     * A name to use when none is supplied.
     */
    private static final String DEFAULT_NAME = "Guest";

    /**
     * A number to use when none is supplied.
     */
    private static final double DEFAULT_NUMBER = 0.0;

    /**
     * The blank error message when things are good.
     */
    private static final String DEFAULT_ERROR_MESSAGE = "";

    /**
     * The message when the name is blank.
     */
    private static final String DEFAULT_MISSING_NAME_ERROR
            = "No name specified";

    /**
     * The message when the number is blank.
     */
    private static final String DEFAULT_MISSING_NUMBER_ERROR
            = "No number specified";

    private static final String DEFAULT_INVALID_NUMBER_ERROR
            = "The supplied value cannot be converted to a number";

    /**
     * The name from the form.
     */
    private String userName;

    /**
     * The error message for user name.
     */
    private String userNameError;

    /**
     * The number from the form.
     */
    private double userNumber;

    /**
     * The error message for user number.
     */
    private String userNumberError;

    /**
     * The regular constructor
     *
     * @param userName
     * @param userNumber
     */
    public NameModel(String userName, String userNumber) {
        validateUserName(userName);
        validateUserNumber(userNumber);
    }

    /**
     * The no-argument constructor.
     */
    public NameModel() {
        this(null, null);
    }

    /**
     * The name from the form.
     *
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * The name from the form.
     *
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        validateUserName(userName);
    }

    /**
     * The error message for user name.
     *
     * @return the userNameError
     */
    public String getUserNameError() {
        return userNameError;
    }

    /**
     * The number from the form.
     *
     * @return the userNumber
     */
    public double getUserNumber() {
        return userNumber;
    }

    /**
     * The number from the form.
     *
     * @param userNumber the userNumber to set
     */
    public void setUserNumber(String userNumber) {
        validateUserNumber(userNumber);
    }

    /**
     * The number from the form.
     *
     * @param userNumber the userNumber to set
     */
    public void setUserNumber(double userNumber) {
        validateUserNumber(String.valueOf(userNumber));
    }

    /**
     * The error message for user number.
     *
     * @return the userNumberError
     */
    public String getUserNumberError() {
        return userNumberError;
    }

    /**
     * Validate the user name.  It should be either, null, blank, or assumed 
     * to be a valid name.
     * 
     * @param userName the name to validate
     */
    private void validateUserName(String userName) {
        if(null == userName){
            this.userName = DEFAULT_NAME;
            this.userNameError = DEFAULT_ERROR_MESSAGE;
        }else if (userName.isBlank()){
            this.userName = DEFAULT_NAME;
            this.userNameError = DEFAULT_MISSING_NAME_ERROR;
        } else {
            String noHtml = userName.replace("\\<.*?>", "");
            this.userName = noHtml;
            this.userNameError = DEFAULT_ERROR_MESSAGE;
        }
    }

    /**
     * Validates the user number.  Expected values are null, blank, numeric, 
     * and non-numeric.
     * 
     * @param userNumber  the number to validate, as a String
     */
    private void validateUserNumber(String userNumber) {
        if(null == userNumber){
            this.userNumber = DEFAULT_NUMBER;
            this.userNumberError = DEFAULT_ERROR_MESSAGE;
        }else if(userNumber.isBlank()){
            this.userNumber = DEFAULT_NUMBER;
            this.userNumberError = DEFAULT_MISSING_NUMBER_ERROR;
        } else {
            try{
                this.userNumber = Double.parseDouble(userNumber);
                this.userNumberError = DEFAULT_ERROR_MESSAGE;
            } catch(NumberFormatException ex){
                this.userNumber = DEFAULT_NUMBER;
                this.userNumberError = DEFAULT_INVALID_NUMBER_ERROR;
            }
        }
    }

}
