package com.training;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import com.training.model.Header;
import com.training.model.LineItems;

/**
 * @author Kaushal.Kumar
 *
 */
public class MainApp {
	public static void main(String[] args) throws FileNotFoundException {
		String file ="src\\read-file-java-poc1.csv";
		Scanner sc = new Scanner(new File(file));
		HashMap<String,LineItems> lineMap=new HashMap<String,LineItems>();
		while(sc.hasNextLine()) {
			String[] strArr = sc.nextLine().split(";");
			if(strArr[0].equalsIgnoreCase("HAUDIT")) {
				Header header = new Header();
				header.setRecordType(strArr[0]);
				header.setTotalLines(Integer.parseInt(strArr[1]));
				header.setTotalAmt(Float.parseFloat(strArr[2]));
				header.setMinAmt(Integer.parseInt(strArr[3]));
				header.setCurrentDate(strArr[4]);
				System.out.println("Header: "+header);
			}
			else if(strArr[0].equalsIgnoreCase("LINE")) {
				LineItems line = new LineItems();
				line.setRecordType(strArr[0]);
				line.setLineNumber(Integer.parseInt(strArr[1]));
				line.setRefDocNum(strArr[2]);
				line.setCity(strArr[3]);
				line.setAmount(Float.parseFloat(strArr[4]));
				lineMap.put(line.getRefDocNum(), line);
			}
			else {
				System.out.println("This line in csv is neither HAUDIT nor LINE");
			}
		}
		System.out.println("HashMap: "+lineMap);
	}
	
}
