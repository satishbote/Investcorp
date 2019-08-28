package org.ejagruti.investcorp.listeners;

import java.net.UnknownHostException;
import java.text.SimpleDateFormat;


import org.ejagruti.investcorp.generic.Generic;
import org.ejagruti.investcorp.generic.HTMLReportGenerator;
import org.ejagruti.investcorp.generic.TextOperations;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class TestSuiteListener implements ISuiteListener {

	public static String filePath = "C:\\ejagruti\\logs\\log"
			+ Generic.getDateTime("MMM-dd-yyyy_HH-mm-ss") + ".txt";

	@Override
	public void onFinish(ISuite arg0) {

		String suitename = arg0.getName();

		System.out.println("\r\n" + "Ending Test Suite " + suitename);

		HTMLReportGenerator.TestSuiteEnd();

		String contents = "\r\n"+Generic.getDateTime() + " Ending Test Suite: "
				+ suitename;
		TextOperations.AppendTextFile(filePath, contents);

	}

	@Override
	public void onStart(ISuite arg0) {
		String suitename = arg0.getName();
		int tcs = arg0.getXmlSuite().getTests().size();
		System.out.println("Suite Name: " + suitename);
		System.out.println("Number of Test Cases: " + tcs);

		try {
			HTMLReportGenerator.TestSuiteStart(
					"C:\\ejagruti\\Reports\\"
							+ new SimpleDateFormat("MMM-dd-yyyy_HH-mm-ss")
									.format(System.currentTimeMillis())
							+ "HtmlReport.html", System
							.getProperty("user.name"));
		} catch (UnknownHostException e) {

			e.printStackTrace();
		}

		

		TextOperations.CreateTextFile(filePath);

		String contents = Generic.getDateTime() + " Suite Name:" + suitename
				+ "\r\n" + Generic.getDateTime() + " Number of Test Cases:"
				+ tcs;
		TextOperations.AppendTextFile(filePath, contents);

	}

}
