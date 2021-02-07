package models.exceptions;

/**
 * This class implements the required methods for CargoNumberFormatMismatchException. 
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW3
 */
public class CargoNumberFormatMismatchException extends Exception{
    /**
     * Constructor for CargoNumberFormatMismatchException.
     * Exception with user defined message.
     */
	public CargoNumberFormatMismatchException(){
        super("Cargo number format is not appropriate.");
    }
    /**
     * Constructor for CargoNumberFormatMismatchException.
     * Exception with the specified detail message.
     */
	public CargoNumberFormatMismatchException(String message){
        super(message);
    }
}
