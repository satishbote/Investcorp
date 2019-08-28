package org.ejagruti.investcorp.generic;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.*;

public class TextOperations {

	public enum FileOptions {

		RemoveEmptyLines(1);

		private final int value;

		private FileOptions(int value) {
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}
	}

	/**
	 * Used to check whether given file is present or not.
	 * 
	 * @param FilePath
	 * @return
	 */
	public static boolean FileExists(String FilePath) {

		File f = new File(FilePath);
		return f.exists();
	}

	/**
	 * 
	 * @param FilePath
	 * @return boolean How To Use: It will Create a New Text File on the given
	 *         filePath and return true If the File is already present then it
	 *         will return false.
	 */
	public static boolean CreateTextFile(String FilePath) {
		boolean chk = true;
		try {
			Path path = Paths.get(FilePath);
			// always create new file, failing if it already exists
			OutputStream out = Files.newOutputStream(path, CREATE_NEW);
		} catch (IOException ioex) {
			chk = false;
		}
		return chk;
		/*
		 * // truncate and overwrite an existing file, or create the file if //
		 * it doesn't initially exist
		 * 
		 * OutputStream out = Files.newOutputStream(path);
		 * 
		 * // append to an existing file, fail if the file does not exist
		 * OutputStream out = Files.newOutputStream(path, CREATE_NEW); out =
		 * Files.newOutputStream(path, APPEND);
		 * 
		 * // append to an existing file, create file if it doesn't initially
		 * exist OutputStream out = Files.newOutputStream(path, CREATE_NEW); out
		 * = Files.newOutputStream(path, CREATE, APPEND);
		 */

	}

	/**
	 * Create a New Text File and Add the Given contents into that File. If the
	 * File is Already Present then it will return false else return true
	 * 
	 * @param FilePath
	 * @param Contents
	 * @return
	 */
	public static boolean CreateTextFile(String FilePath, String Contents) {
		boolean chk = true;
		try {
			Path path = Paths.get(FilePath);
			// always create new file, failing if it already exists
			OutputStream out = Files.newOutputStream(path, CREATE_NEW);
			out.write(Contents.trim().getBytes());
		} catch (IOException ioex) {
			chk = false;
		}
		return chk;
	}

	/**
	 * Used to append given contents for the given text file.If the given file
	 * is not present in the given location then it will create a new file and
	 * append the text else it will use the existing file to to append the text
	 * 
	 * @param FilePath
	 * @param Contents
	 * @return : true or false
	 */
	public static boolean AppendTextFile(String FilePath, String Contents) {
		boolean chk = true;
		try {

			Path path = Paths.get(FilePath);
			// always create new file, failing if it already exists
			OutputStream out = Files.newOutputStream(path, APPEND);
			out.write((System.lineSeparator() + Contents.trim()).getBytes());
			RemoveEmptyLines(FilePath);
			// out.write((Contents.trim()).getBytes());
		} catch (IOException ioex) {
			chk = false;
		}
		return chk;
	}

	/**
	 * Used to read entire text file and stored the content inside the string
	 * 
	 * @param FilePath
	 * @return : String value which contains entire file contents
	 */
	public static String ReadAllTextFile(String FilePath) {
		String allFileContents = "";
		try {
			int i = 0;
			String rowString = "";
			BufferedReader br = new BufferedReader(new FileReader(FilePath));
			while ((rowString = br.readLine()) != null) {
				if (!rowString.trim().equals("")) {
					allFileContents = allFileContents + rowString.trim();
				}
			}
			br = null;
		} catch (Exception ex) {
			allFileContents = null;
		}
		return allFileContents;
	}

	/**
	 * Used to find the Total Row Present in the Given Text File.
	 * 
	 * @param FilePath
	 * @return : total number of row count
	 */
	public static int GetTotalRowCount(String filePath) {
		int count = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));

			String rowData = br.readLine();
			while (rowData != null) {
				rowData = br.readLine();
				count++;

			}
			br = null;

		} catch (IOException ex) {
			System.out.println(ex.getLocalizedMessage());
			count = 0;
		}
		return count;
	}

	/**
	 * Used to read entire text file line by line and return the array
	 * 
	 * @param FilePath
	 * @return : String array
	 */
	public static ArrayList<String> ReadAllTextFileLineByLine(String FilePath) {
		int totalRows = GetTotalRowCount(FilePath);
		ArrayList<String> allFileContents = new ArrayList<String>();
		try {
			int i = 0;
			String rowString = "";
			BufferedReader br = new BufferedReader(new FileReader(FilePath));
			while ((rowString = br.readLine()) != null) {
				if (!rowString.trim().equals("")) {
					allFileContents.add(rowString.trim());
				}
			}

			br = null;
		} catch (Exception ex) {
			allFileContents = null;
		}
		return allFileContents;
	}

	/**
	 * Used to get the row value for the specific Row Number and for the given
	 * File Path
	 * 
	 * @param FilePath
	 * @param RowNumber
	 * @return
	 */
	public static String GetRowValue(String FilePath, int RowNumber) {
		int totalRows = GetTotalRowCount(FilePath);
		String rowValue = "";
		int counter = 0;
		try {
			int i = 0;
			String rowString = "";
			BufferedReader br = new BufferedReader(new FileReader(FilePath));
			while ((rowString = br.readLine()) != null) {
				if (counter == RowNumber) {
					rowValue = rowString.trim();
				}
				counter++;
			}
			br = null;

		} catch (Exception ex) {
			rowValue = null;
		}
		return rowValue;
	}

	/**
	 * Used to return the particular row number which contains given search
	 * characters
	 * 
	 * @param FilePath
	 * @param searchRowWithString
	 * @return String
	 */
	public static int GetRowNumber(String FilePath, String searchRowWithString) {
		int counter = 0;
		for (String singleRow : ReadAllTextFileLineByLine(FilePath)) {
			counter = counter + 1;
			if (singleRow
					.replace(" ", "")
					.toLowerCase()
					.trim()
					.contains(
							searchRowWithString.replace(" ", "").toLowerCase()
									.trim())) {
				break;
			}
		}
		return counter;
	}

	/**
	 * Used to return the particular row which contains given search characters
	 * 
	 * @param FilePath
	 * @param searchRowWithString
	 * @return String
	 */
	public static String GetRowValue(String FilePath, String searchRowWithString) {
		String retVal = "";
		for (String singleRow : ReadAllTextFileLineByLine(FilePath)) {
			if (singleRow
					.replace(" ", "")
					.trim()
					.toLowerCase()
					.contains(
							searchRowWithString.trim().toLowerCase()
									.replace(" ", ""))) {
				retVal = singleRow;
				break;
			}
		}
		return retVal;
	}

	/**
	 * Used to Delete Text File
	 * 
	 * @param FilePath
	 * @return boolean
	 */

	public static boolean DeleteTextFile(String FilePath) {
		boolean val;
		try {
			if (FileExists(FilePath)) {
				File f = new File(FilePath);
				f.delete();
				val = true;
				/*
				 * if(f.exists()){ f.delete(); //
				 * System.out.println("File existed"); val=true; }else{
				 * //System.out.println("File not found!"); val=false; }
				 */
			} else
				val = false;
		} catch (Exception ex) {
			val = false;
		}
		return val;
	}

	/**
	 * Used to modifiy the row matching with the search characters with the new
	 * Line if the row modified then it will return true else it will return
	 * false
	 * 
	 * @param FilePath
	 * @param SearchRowWhichContains
	 * @param ReplaceRowWith
	 * @return ArrayList<String>
	 */
	public static boolean ReplaceLineInTextFile(String FilePath,
			String SearchRowWhichContains, String ReplaceRowWith) {
		boolean val = false;
		ArrayList<String> allFileContents = ReadAllTextFileLineByLine(FilePath);
		try {

			for (int r = 0; r < allFileContents.size(); r++) {
				if (allFileContents
						.get(r)
						.toLowerCase()
						.replace(" ", "")
						.trim()
						.contains(
								SearchRowWhichContains.trim().toLowerCase()
										.replace(" ", ""))) {
					allFileContents.set(r, ReplaceRowWith);
					val = true;
				}
			}

			Path path = Paths.get(FilePath);
			java.nio.file.Files.write(path, allFileContents,
					StandardCharsets.UTF_8, TRUNCATE_EXISTING);
		} catch (Exception ex) {
			val = false;
		}
		return val;
	}

	/**
	 * Used to modifiy the row for the given row number
	 * 
	 * @param FilePath
	 * @param SearchRowWhichContains
	 * @param ReplaceRowWith
	 * @return ArrayList<String>
	 */
	public static boolean ReplaceLineInTextFile(String FilePath, int RowNumber,
			String ReplaceRowWith) {
		boolean val = true;
		ArrayList<String> allFileContents = ReadAllTextFileLineByLine(FilePath);
		try {

			allFileContents.set(RowNumber, ReplaceRowWith);
			Path path = Paths.get(FilePath);
			java.nio.file.Files.write(path, allFileContents,
					StandardCharsets.UTF_8, TRUNCATE_EXISTING);
		} catch (Exception ex) {
			val = false;
		}
		return val;
	}

	/**
	 * Used to Delete the row for the given row number in the given text file
	 * 
	 * @param FilePath
	 * @param SearchRowWhichContains
	 * @param ReplaceRowWith
	 * @return ArrayList<String>
	 */
	public static boolean DeleteLineInTextFile(String FilePath, int RowNumber) {
		boolean val = true;
		ArrayList<String> allFileContents = ReadAllTextFileLineByLine(FilePath);
		try {
			allFileContents.remove(RowNumber);
			Path path = Paths.get(FilePath);
			java.nio.file.Files.write(path, allFileContents,
					StandardCharsets.UTF_8, TRUNCATE_EXISTING);
		} catch (Exception ex) {
			val = false;
		}
		return val;
	}

	/**
	 * Used to Delete the row which contains given search string in the given
	 * text file
	 * 
	 * @param FilePath
	 * @param SearchRowWhichContains
	 * @param ReplaceRowWith
	 * @return ArrayList<String>
	 */
	public static boolean DeleteLineInTextFile(String FilePath,
			String SearchRowWhichContains) {
		boolean val = true;
		ArrayList<String> allFileContents = ReadAllTextFileLineByLine(FilePath);
		try {

			for (int r = 0; r < allFileContents.size(); r++) {
				if (allFileContents
						.get(r)
						.trim()
						.toLowerCase()
						.contains(
								SearchRowWhichContains.toLowerCase().trim()
										.replace(" ", ""))) {
					allFileContents.remove(r);
				}
			}
			Path path = Paths.get(FilePath);
			java.nio.file.Files.write(path, allFileContents,
					StandardCharsets.UTF_8, TRUNCATE_EXISTING);
		} catch (Exception ex) {
			val = false;
		}
		return val;
	}

	public static void OverWriteTextFile(String FilePath,
			ArrayList<String> allFileContents) throws IOException {
		Path path = Paths.get(FilePath);
		java.nio.file.Files.write(path, allFileContents,
				StandardCharsets.UTF_8, TRUNCATE_EXISTING);
	}

	public static void RemoveEmptyLines(String FilePath) throws IOException {
		ArrayList<String> contents = ReadAllTextFileLineByLine(FilePath);
		OverWriteTextFile(FilePath, contents);
	}

	/**
	 * Used to get the list of all the descendants files including all the files
	 * present inside the sub folders with their absolute path e.g. if
	 * RootFolder A has 10 files and 2 folders each 2 sub folders has 10 files
	 * each then in the output it will return you all the 30 files
	 * 
	 * @param RootFolder
	 *            path and SearchString
	 * @return
	 */
	public static ArrayList<String> GetAllFiles(String RootFolder,
			String SearchFileWhichContains) {

		ArrayList<String> allFilesContains = new ArrayList<String>();
		return PerformSearchOperation(RootFolder, SearchFileWhichContains,
				allFilesContains);
	}

	private static ArrayList<String> PerformSearchOperation(String RootFolder,
			String SearchFileWhichContains, ArrayList<String> allFilesContains) {

		for (String file : Generic.GetFiles(RootFolder)) {
			if (file.toLowerCase().contains(SearchFileWhichContains)) {
				allFilesContains.add(RootFolder + "\\" + file);
			}
		}
		for (String folder : Generic.GetSubFolders(RootFolder)) {
			PerformSearchOperation(RootFolder + "\\" + folder,
					SearchFileWhichContains, allFilesContains);
		}
		return allFilesContains;
	}

	private static ArrayList<String> PerformOperation(String RootFolder,
			ArrayList<String> allFiles) {
		for (String file : Generic.GetFiles(RootFolder)) {
			allFiles.add(RootFolder + "\\" + file);
		}
		for (String folder : Generic.GetSubFolders(RootFolder)) {
			PerformOperation(RootFolder + "\\" + folder, allFiles);
		}
		return allFiles;
	}

	public static ArrayList<String> GetAllFiles(String RootFolder) {
		ArrayList<String> allFiles = new ArrayList<String>();
		return PerformOperation(RootFolder, allFiles);

	}

	public static void main(String[] args) throws IOException {

		// RemoveEmptyLines("C:\\eJagruti\\Parameters\\input\\Input_Parameter.txt");
		// System.out.println("asfdas");
		// String allF=ReadAllTextFile("C:\\EJAGRUTI\\TESTSUITES\\TRIAL.HTML");
		// System.out.println(allF);

		// System.out.println(CreateTextFile("C:\\ejagruti\\Logs\\satish.txt"));
		// System.out.println(CreateTextFile("C:\\ejagruti\\Logs\\satish1.txt","Pune"));
		// System.out.println(AppendTextFile("C:\\ejagruti\\Logs\\satish.txt","Kolhapur"));
		// System.out.println(ReadAllTextFile("C:\\ejagruti\\Logs\\satish1.txt"));
		// System.out.println(GetTotalRowCount("C:\\ejagruti\\Logs\\satish1.txt"));
		// System.out.println(ReadAllTextFileLineByLine("C:\\ejagruti\\Logs\\satish1.txt"));
		// System.out.println(GetRowValue("C:\\ejagruti\\Logs\\satish1.txt",
		// 1));
		// System.out.println(GetRowNumber("C:\\ejagruti\\Logs\\satish1.txt",
		// "pune"));
		// System.out.println(GetRowValue("C:\\ejagruti\\Logs\\satish1.txt",
		// "kol"));
		// System.out.println(DeleteTextFile("C:\\ejagruti\\Logs\\satish.txt"));
		// System.out.println(ReplaceLineInTextFile("C:\\ejagruti\\Logs\\satish1.txt",
		// "pune", "waraje"));
		// System.out.println(ReplaceLineInTextFile("C:\\ejagruti\\Logs\\satish1.txt",
		// 1, "Satish Bote"));
		// System.out.println(DeleteLineInTextFile("C:\\ejagruti\\Logs\\satish1.txt",
		// 1));
		// System.out.println(DeleteLineInTextFile("C:\\ejagruti\\Logs\\satish11.txt",
		// "kolhapur"));
		// System.out.println(GetAllFiles("C:\\ejagruti\\Logs", "sat"));

	}

}
