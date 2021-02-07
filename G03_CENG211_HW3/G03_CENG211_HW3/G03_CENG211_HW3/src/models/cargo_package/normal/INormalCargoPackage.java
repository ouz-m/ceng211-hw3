package models.cargo_package.normal;
import java.util.Random;
/**
 * This interface lists the required methods for NormalCargoPackage. 
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW3
 */
public interface INormalCargoPackage {
    
	//Calculate price
	double calculatePrice(double size);
	//Generate cargo code
    static int generateCargoCode() {
        Random random = new Random();
        return 1000000 + random.nextInt(9000000);
    }
    //Getter for sender ID
    long getSenderID();
    //Getter for sender name
    String getSenderName();
    //Getter for recipient name
    String getRecipientName();
    //Getter for recipient address
    String getRecipientAddress();
    //Getter for price
    double getPrice();
}
