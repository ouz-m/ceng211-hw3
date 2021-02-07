import services.FileIO;

/**
 * This class implements the required methods for CargoAcceptanceApp.
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW3
 */
public class CargoAcceptanceApp {
    
	/**
	 * Main method for program.
	 * @param args
	 */
	public static void main(String[] args) {
        Simulation simulation = new Simulation();
        simulation.run(new FileIO());
    }
}

