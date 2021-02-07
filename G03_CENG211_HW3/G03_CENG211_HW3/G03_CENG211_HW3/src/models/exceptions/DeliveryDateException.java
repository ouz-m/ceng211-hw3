package models.exceptions;

/**
 * This class implements the required methods for DeliveryDateException.
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW3
 */
public class DeliveryDateException extends Exception{
    
	/**
	 * Constructor for DeliveryDateException.
	 * Exception with user defined message.
	 */
	public DeliveryDateException(){
        super("Shipment day is invalid. calculatePredictedDeliveryDate() function condition should be changed accordingly to javadoc");
    }
   
	/**
	 * Constructor for DeliveryDateException.
	 * Exception with the specified detail message.
	 */
	public DeliveryDateException(String message){
        super(message);
    }
}