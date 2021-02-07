package services;
import java.util.ArrayList;

/**
 * This interface lists the required methods for FileIO. 
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW3
 */
public interface IFileIO {
	//Read csv file from given path
	ArrayList<ArrayList<String>> readCSV(String path);
}
