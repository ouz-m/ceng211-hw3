package engines.cargo_acceptance_view;
import models.cargo_package.CargoPackage;
import java.util.ArrayList;
/**
 * This class implements the required methods for CargoAcceptanceView.
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW3
 */
public class CargoAcceptanceView implements ICargoAcceptanceView {
    
	/**
	 * Print normal cargo packages list.
	 */
	@Override
    public void printNormalCargoPackages(ArrayList<CargoPackage> packageList){
        System.out.println("Normal Cargo Packages:");
        System.out.println("No   Cargo Code   Sender ID     Sender Name        Recipient Name           Recipient Address       Size  Price   Delivery Day");
        for (int i = 0; i < packageList.size(); i++) {
            int no = i+1;
            String[] row = new String[]{String.valueOf(no), packageList.get(i).toString()};
            System.out.format("%-7s%-15s\n", row);
        }
        System.out.println();
    }
	
	/**
	 * Print e-commerce cargo packages list.
	 */
    @Override
    public void printEcommerceCargoPackages(ArrayList<CargoPackage> packageList){
        System.out.println("E-commerce Cargo Packages:");
        System.out.println("No  E-commerce Site  Cargo Code      Status  Size  Delivery Day");
        for (int i = 0; i < packageList.size(); i++) {
            int no = i+1;
            String[] row = new String[]{String.valueOf(no), packageList.get(i).toString()};
            System.out.format("%-7s%-15s\n", row);
        }
        System.out.println();
    }
    
    /**
     * Print number of accepted and not accepted cargo packages.
     */
    @Override
    public void printNumberOfAcceptedCargo(int[] numberAcceptedNotAccepted){
        System.out.println("Number of Accepted Cargo: " + numberAcceptedNotAccepted[0]);
        System.out.println("Number of Not Accepted Cargo: " + numberAcceptedNotAccepted[1]);
        System.out.println();
    }


}