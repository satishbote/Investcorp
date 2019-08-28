package org.ejagruti.investcorp.generic;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

public class HTMLReportGenerator {

	static ExtentReports report = null;
	static ExtentTest logger;

	public static void TestSuiteStart(String ResultHTMLFilePath, String UserName)
			throws UnknownHostException {
		report = new ExtentReports(ResultHTMLFilePath, false,
				NetworkMode.OFFLINE);

		report.addSystemInfo("Host Name",
				InetAddress.getLocalHost().getHostName())
				.addSystemInfo("Environment", "QA")
				.addSystemInfo("User Name", UserName);
	}

	public static void TestSuiteEnd() {
		report.flush();
		report.close();
	}

	public static void TestCaseStart(String TestName, String Description) {
		logger = report.startTest(TestName, Description);
	}

	public static void TestCaseEnd() {
		report.endTest(logger);

	}

	public static void StepDetails(String Status, String StepName,
			String StepDetails, String objectImagePath) {
		String tbl = StepDetails + "<br>"
				+ logger.addScreenCapture(objectImagePath);
		if (Status.equalsIgnoreCase("pass")) {
			logger.log(LogStatus.PASS, StepName, tbl);
		} else if (Status.equalsIgnoreCase("fail")) {
			logger.log(LogStatus.FAIL, StepName, tbl);
		} else if (Status.equalsIgnoreCase("error")) {
			logger.log(LogStatus.ERROR, StepName, tbl);
		} else if (Status.equalsIgnoreCase("info")) {
			logger.log(LogStatus.INFO, StepName, tbl);
		} else if (Status.equalsIgnoreCase("skip")) {
			logger.log(LogStatus.SKIP, StepName, tbl);
		} else {
			logger.log(LogStatus.INFO, StepName, tbl);
		}

	}

	public static void main(String[] args) throws UnknownHostException {

		TestSuiteStart("C:\\eJagruti\\Result\\manish.html", "ejagruti");
		TestCaseStart("this is test name", "this is description");
		StepDetails("pass", "this is step1", "this is step details1",
				"C://Users//Public//Pictures//Sample Pictures//Desert.jpg");
		StepDetails("fail", "this is step2", "this is step details2", "img2");
		TestCaseEnd();
		TestSuiteEnd();

	}

}
