package models.cargo_package.ecommerce;
import models.exceptions.CargoNumberFormatMismatchException;
import java.util.ArrayList;
import java.util.Hashtable;
/**
 * This interface lists the required methods for ECommerceCargoPackage. 
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW3
 */
public interface IECommerceCargoPackage {

	//Check the code format for Amazon
    void amazonCodeFormatChecker() throws CargoNumberFormatMismatchException;
    //Check the code format for Hepsiburada
    void hepsiburadaCodeFormatChecker() throws CargoNumberFormatMismatchException;
    //Check the code format for N11
    void n11CodeFormatChecker() throws CargoNumberFormatMismatchException;
    //Check the code format for Trendyol
    void trendyolCodeFormatChecker() throws CargoNumberFormatMismatchException;
    //Getter for eCommerceSiteName
    String geteCommerceSiteName();
    //Setter for status
    void setStatus(boolean status);
    //Compare method for status
    boolean isStatus();
}
