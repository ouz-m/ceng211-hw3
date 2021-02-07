package engines.cargo_acceptance_processor;
import models.cargo_package.CargoPackage;
import java.util.*;
/**
 * This interface lists the required methods for CargoAcceptanceProcessor.
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW3
 */
public interface ICargoAcceptanceProcessor {

	//Process cargo packages according to their type
    Hashtable<String, ArrayList<CargoPackage>> processCargoPackages(ArrayList<ArrayList<String>> packageData);
    //Process daily limits of e-commerce cargo packages
    void processDailyLimits(ArrayList<CargoPackage> eCommerceCargoPackages);
    //Calculate numbers of accepted and not accepted cargo packages
    int[] calculateNumberOfAcceptedAndNotAccepted(ArrayList<CargoPackage> packageList);
}
