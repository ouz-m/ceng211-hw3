package models.cargo_package;
import shared.Constants;
/**
 * This interface lists the required methods for CargoPackage class.
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW3
 */
public interface ICargoPackage<T> {
    //Calculate desi 
	double calculateDesi(double width, double length, double height);
	//Calculate size 
	int calculateSize(double desi, int weight);
    //Getter for weight 
	int getWeight();
    //Getter for width
	int getWidth();
    //Getter for height
	int getHeight();
    //Getter for length
	int getLength();
    //Getter for cargo code
	T getCargoCode();
    //Calculate predicted delivery date
	Constants.dayOfWeek calculatePredictedDeliveryDate();
    //Getter for delivery date
	Constants.dayOfWeek getDeliveryDate();
    //Getter for size
    int getSize();
}
