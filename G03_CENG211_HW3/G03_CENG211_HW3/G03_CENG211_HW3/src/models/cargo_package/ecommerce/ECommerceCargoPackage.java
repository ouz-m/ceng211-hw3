package models.cargo_package.ecommerce;
import models.cargo_package.CargoPackage;
import models.exceptions.CargoNumberFormatMismatchException;
import java.util.ArrayList;

/**
 * This class implements the required methods for ECommerceCargoPackage.
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW3
 */
public class ECommerceCargoPackage<T> extends CargoPackage<T> implements IECommerceCargoPackage {

    private final String eCommerceSiteName;
    private boolean status;

    /**
     * Constructor for ECommerceCargoPackage.
     * @param eCommerceSiteName E-commerce site name to be set for this ECommerceCargoPackage.
     * @param cargoCode Cargo code to be set for this ECommerceCargoPackage.
     * @param weight Weight to be set for this ECommerceCargoPackage.
     * @param width Width to be set for this ECommerceCargoPackage.
     * @param height Height to be set for this ECommerceCargoPackage.
     * @param length Length to be set for this ECommerceCargoPackage.
     * @param status Status to be set for this ECommerceCargoPackage.
     */
    public ECommerceCargoPackage(String eCommerceSiteName, T cargoCode,
                                 int weight, int width, int height, int length,
                                  boolean status) {

        super(weight, width, height, length, cargoCode);
        this.eCommerceSiteName = eCommerceSiteName;
        this.status = status;
    }
    
    /**
     * Constructor for ECommerceCargoPackage.
     * @param dataList Arraylist dataList to be set for this ECommerceCargoPackage.
     * @param cargoCode Cargo code to be set for this ECommerceCargoPackage.
     */
    public ECommerceCargoPackage(ArrayList<String> dataList, T cargoCode){
        this(dataList.get(1), cargoCode,
                Integer.parseInt(dataList.get(3)),
                Integer.parseInt(dataList.get(4)),
                Integer.parseInt(dataList.get(5)),
                Integer.parseInt(dataList.get(6)), true);
    }

    /**
     * Constructor for ECommerceCargoPackage.
     * @param dataList Arraylist dataList to be set for this ECommerceCargoPackage.
     */
    public ECommerceCargoPackage(ArrayList<String> dataList){
        this(dataList.get(1), (T) dataList.get(2),
                Integer.parseInt(dataList.get(3)),
                Integer.parseInt(dataList.get(4)),
                Integer.parseInt(dataList.get(5)),
                Integer.parseInt(dataList.get(6)), true);
    }

    /**
     * Checks the code format of cargo code according to its class and length for AMAZON.
     * @throws CargoNumberFormatMismatchException
     */
    @Override
    public void amazonCodeFormatChecker() throws CargoNumberFormatMismatchException {
        if (getCargoCode().getClass() != Integer.class
                || getCargoCode().toString().length() != 7){
            throw new CargoNumberFormatMismatchException();
        }
    }

    /**
     * Checks the code format of cargo code according to its class and length for HEPSIBURADA.
     * @throws CargoNumberFormatMismatchException
     */
    @Override
    public void hepsiburadaCodeFormatChecker() throws CargoNumberFormatMismatchException {
        if (getCargoCode().getClass() != String.class
                || getCargoCode().toString().length() != 8){
            throw new CargoNumberFormatMismatchException();
        }
    }

    /**
     * Checks the code format of cargo code according to its class and length for N11.
     * @throws CargoNumberFormatMismatchException
     */
    @Override
    public void n11CodeFormatChecker() throws CargoNumberFormatMismatchException {
        if (getCargoCode().getClass() != String.class
                || getCargoCode().toString().length() != 7){
            throw new CargoNumberFormatMismatchException();
        }
    }

    /**
     * Checks the code format of cargo code according to its class and length for TRENYDOL.
     * @throws CargoNumberFormatMismatchException
     */
    @Override
    public void trendyolCodeFormatChecker() throws CargoNumberFormatMismatchException {
        if (getCargoCode().getClass() != Integer.class
                || getCargoCode().toString().length() != 8){
            throw new CargoNumberFormatMismatchException();
        }
    }

    /**
     * Get name of this ECommerceCargoPackage.
     */
    @Override
    public String geteCommerceSiteName() {
        return eCommerceSiteName;
    }

    /**
     * Set status of this ECommerceCargoPackage.
     */
    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Get status of this ECommerceCargoPackage.
     */
    @Override
    public boolean isStatus() {
        return status;
    }
    
    /**
     * Convert the boolean status to string.
     * @return String status
     */
    public String getStatusToString(){
        return isStatus() ? "Accepted" : "Not Accepted";
    }

    /**
     * Converts the object to string.
     */
    @Override
    public String toString(){
        String[] row = new String[] {geteCommerceSiteName(), String.valueOf(getCargoCode()), getStatusToString(), String.valueOf(getSize()), String.valueOf(getDeliveryDate())};
        return String.format("%-15s%-14s%-10s%-7s%-15s", row);
    }
}