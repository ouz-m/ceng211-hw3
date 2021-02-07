package models.exceptions;

/**
 * This class implements the required methods for IDNotCorrectException.
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW3
 */
public class IDNotCorrectException extends Exception {
    /**
     * Constructor for IDNotCorrectException.
     * Exception with user defined message.
     */
	public IDNotCorrectException(){
        super("ID is not correct.");
    }
    
	/**
	 * Constructor for IDNotCorrectException.
	 * Exception with the specified detail message.
	 */
    public IDNotCorrectException(String message){
        super(message);
    }
}
