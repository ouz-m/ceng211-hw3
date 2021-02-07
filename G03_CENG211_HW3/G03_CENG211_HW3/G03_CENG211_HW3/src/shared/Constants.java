package shared;

/**
 * This class includes global variables. 
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW3
 */
public class Constants {
	
	public static final String PACKAGES_TO_ACCEPT_FILE = "HW3_PackagesToAccept.csv";

    public enum dayOfWeek{SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY}

    //Daily cargo limits of E-Commerce sites
    public enum dailyLimits{
        AMAZON(5), HEPSIBURADA(7), N11(6), TRENDYOL(9);
        private final int dailyLimit;
        dailyLimits(int dailyLimit) {this.dailyLimit = dailyLimit;}
        public int getDailyLimit() {return dailyLimit;}
    }

}