import engines.cargo_acceptance_processor.CargoAcceptanceProcessor;
import engines.cargo_acceptance_view.CargoAcceptanceView;
import models.cargo_package.CargoPackage;
import services.FileIO;
import shared.Constants;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * This class implements the required methods for simulation.
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW3
 */
public class Simulation {
    
	/**
	 * Start execution process. 
	 * @param fileIO
	 */
	public void run(FileIO fileIO){
        Hashtable<String, ArrayList<CargoPackage>> packages;

        CargoAcceptanceProcessor processor = new CargoAcceptanceProcessor();
        CargoAcceptanceView view = new CargoAcceptanceView();
        packages= processor.processCargoPackages(fileIO.readCSV(Constants.PACKAGES_TO_ACCEPT_FILE));
        processor.processDailyLimits(packages.get("Ecommerce"));

        simulateOutput(packages, processor, view);
    }

	/**
	 * Give output to console.
	 * @param packages
	 * @param processor
	 * @param view
	 */
    private void simulateOutput(Hashtable<String, ArrayList<CargoPackage>> packages, CargoAcceptanceProcessor processor, CargoAcceptanceView view) {
        System.out.println("Welcome!");
        System.out.println();
        view.printNumberOfAcceptedCargo(processor.calculateNumberOfAcceptedAndNotAccepted(packages.get("Ecommerce")));
        System.out.println("Here are the details:");
        System.out.println();
        view.printNormalCargoPackages(packages.get("Normal"));
        view.printEcommerceCargoPackages(packages.get("Ecommerce"));
    }
}
