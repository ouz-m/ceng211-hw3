package services;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * This class implements required methods for File I/O.
 * @author Oguzhan Mertturk / 270201036
 * @author Tore Babacan / 280201095
 * @version HW3
 */
public class FileIO implements IFileIO {

	/**
	 *Reads CSV files.
	 */
	public ArrayList<ArrayList<String>> readCSV(String path){
		String line;
		ArrayList<ArrayList<String>> packagesToAcceptDataList = new ArrayList<>();
		
		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			
			while ((line = br.readLine()) != null) {
				ArrayList<String> packageToAcceptData = new ArrayList<String>();
				StringTokenizer st = new StringTokenizer(line, ";");
				
				while (st.hasMoreElements()) {
					packageToAcceptData.add(st.nextToken().trim());
				}
				packagesToAcceptDataList.add(packageToAcceptData);
			}
			fr.close();br.close();
		}
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return packagesToAcceptDataList;		
	}
}
