package BaseClasses;

//import org.testng.annotations.Test;

import Recipients.RecipientsPage;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
public class ApacheCommonsCSV {
	
	public static void readCSV() throws IOException, InterruptedException {
		
		RecipientsPage.downloadFailedFile();
		String CSV_File_Path = "C:\\Users\\MuhammadMujahid\\Downloads\\6180-1646128856.csv-errors.csv";
		// read the file
		Reader reader = Files.newBufferedReader(Paths.get(CSV_File_Path));
		// parse the file into csv values
		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

        for (CSVRecord csvRecord : csvParser) {
            // Accessing Values by Column Index
			String name = csvRecord.get(0);
			String product = csvRecord.get(1);
			String description = csvRecord.get(2);
			String description1 = csvRecord.get(3);
			String error = csvRecord.get(5);
			// print the value to console
			System.out.println("Record No - " + csvRecord.getRecordNumber());
			System.out.println("---------------");
			System.out.println("Name : " + name);
			System.out.println("Product : " + product);
			System.out.println("Description : " + description);
			System.out.println("Description1 : " + description1);
			System.out.println("error : " + error);
			System.out.println("---------------");
        }
	}
}
