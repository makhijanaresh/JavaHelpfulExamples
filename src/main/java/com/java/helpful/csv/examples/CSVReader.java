package com.java.helpful.csv.examples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Note: No third party dependency used for this example
 * @author Naresh Makhija
 *
 */
public class CSVReader {

	 public static void main(String[] args) {
	        String csvFile = "users.csv";
	        String line;
	        String csvSplitBy = ",";

	        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
	            while ((line = br.readLine()) != null) {
	                String[] data = line.split(csvSplitBy);

	                // Output each field in the CSV row
	                for (String field : data) {
	                    System.out.print(field + " ");
	                }

	                System.out.println(); // Move to the next line
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
