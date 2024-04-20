package apps;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class Main {

	public static void main(String[] args) {
		Random random = new Random();
		long startTime, endTime;
		int[] largeSortedArray = LargeArrayGenerator.generateSortedArray(1000000);
		int sortedTarget = largeSortedArray[random.nextInt(1000000)];

		try {
			FileWriter fileWriter = new FileWriter("search_performance.csv", true);
			@SuppressWarnings("deprecation")
			CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT);

			// Perform Linear Search
			startTime = System.nanoTime();
			int linearSearchIndex = LinearSearch.linearSearch(largeSortedArray, sortedTarget);
			endTime = System.nanoTime();
			csvPrinter.printRecord("Linear Search", sortedTarget, linearSearchIndex, endTime - startTime);

			// Perform Jump Search
			startTime = System.nanoTime();
			int jumpSearchIndex = JumpSearch.jumpSearch(largeSortedArray, sortedTarget);
			endTime = System.nanoTime();
			csvPrinter.printRecord("Jump Search", sortedTarget, jumpSearchIndex, endTime - startTime);

			csvPrinter.flush(); // Ensure all data is written to the file
			csvPrinter.close(); // Close the printer to release resources
			fileWriter.close(); // Close the writer to release resources
			System.out.println("Data has been written to CSV.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}