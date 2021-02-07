package models.cargo_package.normal;
import models.cargo_package.CargoPackage;
import java.util.ArrayList;

/**
 * This class implements required methods for NormalCargoPAckage.
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW3
 */
public class NormalCargoPackage extends CargoPackage<Integer> implements INormalCargoPackage {
   
	private final long senderID;
    private final String senderName;
    private final String recipientName;
    private final String recipientAddress;
    private final double price;

    /**
     * Constructor for NormalCargoPackage.
     * @param senderID Sender ID to be set for this NormalCargoPackage.
     * @param senderName Sender name to be set for this NormalCargoPackage.
     * @param recipientName Recipient name to be set for this NormalCargoPackage.
     * @param recipientAddress Recipient addresss to be set for this NormalCargoPackage.
     * @param weight Weight to be set for this NormalCargoPackage.
     * @param width Width to be set for this NormalCargoPackage.
     * @param height Height to be set for this NormalCargoPackage.
     * @param length Length to be set for this NormalCargoPackage.
     */
    public NormalCargoPackage(long senderID, String senderName,
                              String recipientName, String recipientAddress,
                              int weight, int width, int height, int length) {

        super(weight, width, height, length, INormalCargoPackage.generateCargoCode());
        this.senderID = senderID;
        this.senderName = senderName;
        this.recipientName = recipientName;
        this.recipientAddress = recipientAddress;
        this.price = calculatePrice(calculateSize(calculateDesi(width,length,height), weight));
    }

    /**
     * Constructor for NormalCargoPackage.
     * @param dataList Arraylist data list to be set for this NormalCargoPackage.
     */
    public NormalCargoPackage(ArrayList<String> dataList){
        this(Long.parseLong(dataList.get(1)),
                dataList.get(2),
                dataList.get(3),
                dataList.get(4),
                Integer.parseInt(dataList.get(5)),
                Integer.parseInt(dataList.get(6)),
                Integer.parseInt(dataList.get(7)),
                Integer.parseInt(dataList.get(8)));
    }

    /**
     * Calculate price of this NormalCargoPackage.
     */
    @Override
    public double calculatePrice(double size) {
        return (18.5 + 3 * size);
    }
    
    /**
     * Get sender ID of this NormalCargoPackage.
     */
    @Override
    public long getSenderID() {
        return senderID;
    }
    
    /**
     * Get sender name of this NormalCargoPackage.
     */
    @Override
    public String getSenderName() {
        return senderName;
    }
    
    /**
     * Get recipient name of this NormalCargoPackage.
     */
    @Override
    public String getRecipientName() {
        return recipientName;
    }
    
    /**
     * Get recipient address of this NormalCargoPackage.
     */
    @Override
    public String getRecipientAddress() {
        return recipientAddress;
    }
    
    /**
     * Get price of this NormalCargoPackage.
     */
    @Override
    public double getPrice() {
        return price;
    }
    
    /**
     * Converts the object to string.
     */
    @Override
    public String toString(){
        String[] row = new String[] {String.valueOf(getCargoCode()), String.valueOf(getSenderID()),
                getSenderName(), getRecipientName(), getRecipientAddress(), String.valueOf(getSize()),
                String.valueOf(getPrice()), String.valueOf(getDeliveryDate())};
        return String.format("%-10s%-15s%-20s%-20s%-30s%-5s%-9s%-15s", row);

    }
}