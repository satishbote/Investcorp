package org.ejagruti.investcorp.generic;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

//import org.ejagruti.Investcorp.Abstraction.BaseClass;

public class Generic {

	public static enum Options {
		OnlyLowerCase, OnlyUpperCase, BothUpperAndLower, WithSpecialCharacters
	}

	public static enum UniqueValueEnum {
		OnlyDigits, OnlyCharacters, BothDigitsAndCharacters
	}

	/**
	 * Used to generate unique Value which will always be unique and never gets
	 * repeated in the future. The Unique Value in a form of string. e.g.
	 * "12222"
	 * 
	 * @return :Unique number in a form of String
	 */
	public static String GenerateUniqueValue(UniqueValueEnum chooseOption) {
		String uniqueValue = null;
		if (chooseOption.equals(UniqueValueEnum.OnlyDigits)) {
			uniqueValue = getDateTime("ddMMyyHHmmssSSS");
		}
		if (chooseOption.equals(UniqueValueEnum.OnlyCharacters)) {
			uniqueValue = getDateTime("ddMMyyHHmmssSSS");
		}
		return uniqueValue;
	}

	/**
	 * Used to generate the random string based on the given length of the
	 * string and options
	 * 
	 * @param lengthofstring
	 *            - any valid integer value
	 * @param chooseOption
	 *            :OnlyLowerCase,
	 *            OnlyUpperCase,BothUpperAndLower,WithSpecialCharacters
	 * @return : String value
	 */

	public static String GenerateRandomString(int lengthofstring,
			Options chooseOption) {
		String randomString = "";
		String strUpperLower = "";
		// System.out.println(Options.OnlyLowerCase);
		if (chooseOption.equals(Options.OnlyUpperCase)) {
			for (int c = 0; c < lengthofstring; c++) {

				char val = (char) GenerateRandomNumber(65, 91);
				randomString = randomString + val;
			}
		}
		if (chooseOption.equals(Options.OnlyLowerCase)) {
			for (int c = 0; c < lengthofstring; c++) {

				char val = (char) GenerateRandomNumber(97, 121);
				randomString = randomString + val;
			}
		}
		if (chooseOption.equals(Options.BothUpperAndLower)) {
			for (int c = 0; c < lengthofstring; c++) {

				char val = (char) GenerateRandomNumber(65, 90);
				strUpperLower = strUpperLower + val;
			}
			for (int c = 0; c < lengthofstring; c++) {

				char val = (char) GenerateRandomNumber(97, 121);
				strUpperLower = strUpperLower + val;
			}
			for (int c = 0; c < lengthofstring; c++) {

				randomString = randomString
						+ strUpperLower.charAt((int) GenerateRandomNumber(0,
								strUpperLower.length()));

			}
		}
		if (chooseOption.equals(Options.WithSpecialCharacters)) {
			for (int c = 0; c < lengthofstring; c++) {

				char val = (char) GenerateRandomNumber(50, 121);
				randomString = randomString + val;
			}
		}
		System.out.println(randomString);
		return randomString;

	}

	/**
	 * Use to get the current date time in a given date format e.g. Use format:
	 * for date: dd for Month:MM for Year: yy or yyyy For hours: HH For minutes:
	 * mm for seconds:ss for milliseconds:SS for e.g.:dd-MM-yyyy HH:mm:ss:SSS
	 * 
	 * @param dtFormat
	 * @return
	 */
	public static String getDateTime(String dtFormat) {
		DateFormat dateFormat = new SimpleDateFormat(dtFormat);

		Date date = new Date();
		return dateFormat.format(date);
	}

	/**
	 * Use to get the current date time in dd-MM-yyyy HH:mm:ss:SSS format
	 * 
	 * @param NA
	 * @return : Current Date Time
	 */
	public static String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss:SSS");

		Date date = new Date();
		return dateFormat.format(date);
	}

	/**
	 * Used to get all the file names present in given folder path
	 * 
	 * @param FolderPath
	 * @return ArrayList<String>
	 */
	public static ArrayList<String> GetFiles(String FolderPath) {

		ArrayList<String> allFiles = new ArrayList<String>();
		File folder = new File(FolderPath);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				allFiles.add(listOfFiles[i].getName());
			}
		}
		return allFiles;
	}

	/**
	 * Used to get all the file names present in given folder path with given
	 * search characters
	 * 
	 * @param FolderPath
	 * @return ArrayList<String>
	 */
	public static ArrayList<String> GetFiles(String FolderPath,
			String SearchFileWhichcontains) {

		ArrayList<String> allFiles = new ArrayList<String>();
		File folder = new File(FolderPath);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()
					&& listOfFiles[i]
							.getName()
							.toLowerCase()
							.trim()
							.replace(" ", "")
							.contains(
									SearchFileWhichcontains.toLowerCase()
											.trim().replace(" ", ""))) {
				allFiles.add(listOfFiles[i].getName());
			}
		}
		return allFiles;
	}

	/**
	 * Used to get all the Sub Folder present in given parent folder
	 * 
	 * @param FolderPath
	 * @return ArrayList<String>
	 */
	public static ArrayList<String> GetSubFolders(String FolderPath) {

		ArrayList<String> allFolders = new ArrayList<String>();
		File folder = new File(FolderPath);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isDirectory()) {
				allFolders.add(listOfFiles[i].getName());
			}
		}
		return allFolders;
	}

	/**
	 * Used to get all the Sub Folder present in given parent folder
	 * 
	 * @param FolderPath
	 * @return ArrayList<String>
	 */
	public static double GenerateRandomNumber(double min, double max) {
		Random rand = new Random();
		double randomNumber = rand.nextDouble();
		double rnddbl = (randomNumber * max) + min;
		return rnddbl;
	}

	public static void makeDirectory(String path) {
		File file = new File(
				path
						+ Generic
								.GenerateUniqueValue(Generic.UniqueValueEnum.OnlyCharacters));
		if (!file.exists()) {
			if (file.mkdir()) {
				System.out.println("Directory is created!");
			} else {
				System.out.println("Failed to create directory!");
			}
		}
	}

	public static void main(String[] args) {
		GenerateRandomString(12, Options.WithSpecialCharacters);

		// GetFiles("C:\\eJagruti\\TestScripts","html");
	}

}
