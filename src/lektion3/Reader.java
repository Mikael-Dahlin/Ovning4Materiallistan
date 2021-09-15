package lektion3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author mikael
 * Main class for reading a CSV file and printing it to the console.
 */
public class Reader {

	/*
	 * Main method for running the program.
	 */
	public static void main(String[] args) {
		// Declaration of variables.
		String path = "Materiallista.csv";
		String line = "";
		String[] columns;
		
		// Try to read the CSV file.
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			// Loop while there is still information in the file and print it out.
			while(line != null) {
				// Get next line.
				line = br.readLine();
				if(line != null) {
					// Split the line on comma.
					columns = line.split(",");
					for (int i = 0; i < columns.length; i++) {
						// Check if the cell contains "(x" if it does make a calculation for the next cell.
						if(columns[i].contains("(x")) {
							String[] numbers = columns[i].split("\\(x");
							columns[i + 1] = String.valueOf(
									Integer.parseInt(numbers[0].strip()) * 
									Integer.parseInt(numbers[1].replace(")", "").strip()));
						}
						System.out.print(columns[i]);
						if (i < columns.length - 1) System.out.print(", ");
					}
					System.out.println();
				}
			}
			
			// Close 
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
