package models.cargo_package;
import shared.Constants;
import java.util.*;
import models.exceptions.DeliveryDateException;
/**
 * This class implements the required methods for CargoPackage.
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW3
 */
public abstract class CargoPackage<T> implements ICargoPackage<T>{
    
	private final int weight;
    private final int width;
    private final int height;
    private final int length;
    protected final T cargoCode;
    private Constants.dayOfWeek deliveryDate;

    /**
     * Constructor for CargoPackage. 
     * @param weight Weight to be set for this CargoPackage.
     * @param width Width to be set for this CargoPackage.
     * @param height Height to be set for this CargoPackage.
     * @param length Length to be set for this CargoPackage.
     * @param cargoCode CargoCode to be set for this CargoPackage.
     */
    public CargoPackage(int weight, int width, int height, int length, T cargoCode) {
        this.weight = weight;
        this.width = width;
        this.height = height;
        this.length = length;
        this.cargoCode = cargoCode;
        this.deliveryDate = calculatePredictedDeliveryDate();
    }

    /**
     * Calculate predicted delivery date of this CargoPackage.
     */
    @Override
    public Constants.dayOfWeek calculatePredictedDeliveryDate() {
        Date date = new Date();
        Constants.dayOfWeek[] dayOfWeekEnumArray = Constants.dayOfWeek.values();
        try {
            //This condition should be changed if program is running on a system day SUNDAY if(date.getDay() != -1)
            if(date.getDay() != -1) return dayOfWeekEnumArray[(date.getDay() + 2) % dayOfWeekEnumArray.length];
            throw new DeliveryDateException();
        } catch (DeliveryDateException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return dayOfWeekEnumArray[0];
    }
    
    /**
     * Calculate desi of this CargoPackage.
     */
    @Override
    public double calculateDesi(double width, double length, double height){
        return (width * length * height) / 3000;
    }

    /**
     * Calculate size of this CargoPackage.
     */
    @Override
    public int calculateSize(double desi, int weight){
        return (int) Math.max(desi, weight);
    }

    /**
     * Get weight of this CargoPackage.
     */
    @Override
    public int getWeight() {
        return weight;
    }

    /**
     * Get width of this CargoPackage.
     */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     * Get height of this CargoPackage.
     */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     * Get length of this CargoPackage.
     */
    @Override
    public int getLength() {
        return length;
    }

    /**
     * Get cargoCode of this CargoPackage.
     */
    @Override
    public T getCargoCode() {
        return cargoCode;
    }

    /**
     * Get deliveryDate of this CargoPackage.
     */
    @Override
    public Constants.dayOfWeek getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * Get size of this CargoPackage.
     */
    @Override
    public int getSize(){
        return calculateSize(calculateDesi(getWidth(), getLength(), getHeight()), getWeight());
    }
}