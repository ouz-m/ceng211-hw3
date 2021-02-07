package engines.cargo_acceptance_processor;
import models.cargo_package.CargoPackage;
import models.cargo_package.ecommerce.ECommerceCargoPackage;
import models.cargo_package.normal.NormalCargoPackage;
import models.exceptions.CargoNumberFormatMismatchException;
import models.exceptions.IDNotCorrectException;
import shared.Constants;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * This class implements the required methods for CargoAcceptanceProcessor.
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW3
 */
public class CargoAcceptanceProcessor implements ICargoAcceptanceProcessor {

	/**
	 * Generate a hashtable that keys are Strings that defines type of CargoPackages, values are CargoPackages
	 */
    public Hashtable<String, ArrayList<CargoPackage>> processCargoPackages(ArrayList<ArrayList<String>> packageDataList) {

        Hashtable<String, ArrayList<CargoPackage>> packages = new Hashtable<>();
        packages.put("Ecommerce", new ArrayList<>()); //Generate an arraylist for ECommerceCargoPackages
        packages.put("Normal", new ArrayList<>()); //Generate an arraylist for NormalCargoPackages
        packageDataList.forEach(packageData -> {
            switch (packageData.get(0)) {
                case "Ecommerce" -> packages.get("Ecommerce").add(eCommerceCargoPackageInitializer(packageData));
                case "Normal" -> packages.get("Normal").add(normalCargoPackageInitializer(packageData));
            }
        });
        return packages;
    }
    
    /**
     * Call appropriate methods for process daily limits.
     */
    @Override
    public void processDailyLimits(ArrayList<CargoPackage> eCommerceCargoPackages){
        Hashtable<String, Integer> dailyLimits = initializeDailyLimits();
        eCommerceCargoPackages.forEach(cargoPackage -> checkForDailyLimit(dailyLimits, (ECommerceCargoPackage) cargoPackage));
    }
    
    /**
     * Calculate number of accepted and not accepted cargo packages according to status.
     */
    @Override
    public int[] calculateNumberOfAcceptedAndNotAccepted(ArrayList<CargoPackage> packageList) {
        int[] numberAcceptedNotAccepted = new int[2];
        int numberAccepted = 0;
        for (CargoPackage cargoPackage: packageList
        ) {
            if (((ECommerceCargoPackage<?>) cargoPackage).isStatus()) numberAccepted += 1;
        }
        numberAcceptedNotAccepted[0] = numberAccepted;
        numberAcceptedNotAccepted[1] = packageList.size() - numberAccepted;
        return numberAcceptedNotAccepted;
    }

    /**
     * Check daily limits of cargo packages according to e-commerce site name.
     * @param dailyLimits to be set for checkForDailyLimit.
     * @param cargoPackage to be set for checkForDailyLimit.
     */
    private void checkForDailyLimit(Hashtable<String, Integer> dailyLimits, ECommerceCargoPackage cargoPackage) {
        String key = cargoPackage.geteCommerceSiteName().toUpperCase();
        Integer value = dailyLimits.get(key);

        if (!value.equals(0)) dailyLimits.put(key, value-1);
        else cargoPackage.setStatus(false);
    }

    /**
     * Generates a hashtable that includes daily limits of each e-commerce site.
     * @return dailyLimitTable 
     */
    private Hashtable<String, Integer> initializeDailyLimits() {
        Hashtable<String, Integer> dailyLimitTable = new Hashtable<>();
        for (Constants.dailyLimits dailyLimit:
                Constants.dailyLimits.values()) {
            dailyLimitTable.put(dailyLimit.name(), dailyLimit.getDailyLimit());
        }
        return dailyLimitTable;
    }

    /**
     * Call appropriate ECommerceCargoPackage initializer according to e-commerce site name.
     * @param dataList
     */
    private ECommerceCargoPackage eCommerceCargoPackageInitializer(ArrayList<String> dataList){
        try{
            switch (dataList.get(1)) {
                case "Amazon" -> {
                    return getAmazonCargoPackage(dataList);
                }
                case "Hepsiburada" -> {
                    return getHepsiburadaCargoPackage(dataList);
                }
                case "N11" -> {
                    return getN11CargoPackage(dataList);
                }
                case "Trendyol" -> {
                    return getTrendyolCargoPackage(dataList);
                }
            }
        } catch (CargoNumberFormatMismatchException e){
            e.printStackTrace();
            return null;
        }
        return null;
    }

    /**
     * ECommerceCargoPackage generator for TRENDYOL.
     * Helper method.
     * @param dataList
     * @return ECommerceCargoPackage
     * @throws CargoNumberFormatMismatchException
     */
    private ECommerceCargoPackage getTrendyolCargoPackage(ArrayList<String> dataList) throws CargoNumberFormatMismatchException {
        ECommerceCargoPackage cargoPackage = new ECommerceCargoPackage<>(dataList, Integer.parseInt(dataList.get(2)));
        cargoPackage.trendyolCodeFormatChecker();
        return cargoPackage;
    }

    /**
     * ECommerceCargoPackage generator for N11.
     * Helper method.
     * @param dataList
     * @return ECommerceCargoPackage
     * @throws CargoNumberFormatMismatchException
     */
    private ECommerceCargoPackage getN11CargoPackage(ArrayList<String> dataList) throws CargoNumberFormatMismatchException {
        ECommerceCargoPackage cargoPackage = new ECommerceCargoPackage<String>(dataList);
        cargoPackage.n11CodeFormatChecker();
        return cargoPackage;
    }

    /**
     * ECommerceCargoPackage generator for HEPSIBURADA.
     * Helper method.
     * @param dataList
     * @return ECommerceCargoPackage
     * @throws CargoNumberFormatMismatchException
     */
    private  ECommerceCargoPackage getHepsiburadaCargoPackage(ArrayList<String> dataList) throws CargoNumberFormatMismatchException {
        ECommerceCargoPackage cargoPackage = new ECommerceCargoPackage<String>(dataList);
        cargoPackage.hepsiburadaCodeFormatChecker();
        return cargoPackage;
    }

    /**
     * ECommerceCargoPackage generator for AMAZON
     * Helper method.
     * @param dataList
     * @return ECommerceCargoPackage 
     * @throws CargoNumberFormatMismatchException
     */
    private ECommerceCargoPackage getAmazonCargoPackage(ArrayList<String> dataList) throws CargoNumberFormatMismatchException {
        ECommerceCargoPackage cargoPackage = new ECommerceCargoPackage<>(dataList, Integer.parseInt(dataList.get(2)));
        cargoPackage.amazonCodeFormatChecker();
        return cargoPackage;
    }

    /**
     * NormalCargoPackage generator.
     * @param dataList
     * @return NormalCargoPackage
     * @throws IDNotCorrectException
     */
    private NormalCargoPackage normalCargoPackageInitializer(ArrayList<String> dataList){
        try {
            if (dataList.get(1).length() == 11) return new NormalCargoPackage(dataList);
            throw new IDNotCorrectException(dataList.get(1) + " is not in length of 11 check input file.");
        //catch exception and end the program.
        } catch (IDNotCorrectException e) {
            e.printStackTrace();
            System.exit(0);
            return null;
        }
    }
}
