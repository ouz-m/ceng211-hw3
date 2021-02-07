package engines.cargo_acceptance_view;
import models.cargo_package.CargoPackage;
import java.util.ArrayList;

/**
 * This interface lists the required methods for CargoAcceptanceView.
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW3
 */
public interface ICargoAcceptanceView {
    //Print NormalCargoPackages list 
	void printNormalCargoPackages(ArrayList<CargoPackage> packageList);
	//Print EcommerceCargoPackages list 
    void printEcommerceCargoPackages(ArrayList<CargoPackage> packageList);
    //Print number of accepted and not accepted cargo packages
    void printNumberOfAcceptedCargo(int[] numberAcceptedNotAccepted);
}
