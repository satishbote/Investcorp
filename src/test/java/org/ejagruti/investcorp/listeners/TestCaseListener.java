package org.ejagruti.investcorp.listeners;

import org.ejagruti.investcorp.generic.Generic;
import org.ejagruti.investcorp.generic.HTMLReportGenerator;
import org.ejagruti.investcorp.generic.GetScreenShot;

import org.ejagruti.investcorp.generic.TextOperations;
import org.ejagruti.investcorp.modules.LaunchApp;


import java.util.regex.Pattern;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.SkipException;

public class TestCaseListener implements ITestListener {

	@Override
	public void onFinish(ITestContext arg0) {

		HTMLReportGenerator.TestCaseEnd();
		LaunchApp.driver.quit();
	}

	@Override
	public void onStart(ITestContext arg0) {

		// System.out.println(arg0.getCurrentXmlTest().getAllParameters().values());
		String name = arg0.getCurrentXmlTest().getName();
		String tcid = arg0.getCurrentXmlTest().getParameter("tcid");
		String usid = arg0.getCurrentXmlTest().getParameter("usid");
		String owner = arg0.getCurrentXmlTest().getParameter("owner");
		String creation_date = arg0.getCurrentXmlTest().getParameter("creation_date");
		System.out.println("\r\nTest Name: " + name);
		System.out.println("TCID: " + tcid);
		System.out.println("USID: " + usid);
		System.out.println("Owner: " + owner);
		System.out.println("Creation Date: " + creation_date);

		// System.out.println("\r\n"+arg0.getCurrentXmlTest().getName()+" test case started");

		String TestName = arg0.getCurrentXmlTest().getName();

		HTMLReportGenerator.TestCaseStart(TestName, " test case started");

		String path = TestSuiteListener.filePath;
		String contents = "\r\n" + Generic.getDateTime() + " Test Name: "
				+ name + "\r\n" + Generic.getDateTime() + " TCID: " + tcid
				+ "\r\n" + Generic.getDateTime() + " USID: " + usid + "\r\n"
				+ Generic.getDateTime() + " Owner: " + owner + "\r\n"
				+ Generic.getDateTime() + " Creation Date: " + creation_date;
		
		TextOperations.AppendTextFile(path, contents);

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	@Override
	public void onTestFailure(ITestResult arg0) {

		String str = arg0.getTestClass().getName();
		// System.out.println(arg0.getTestClass().getName());
		String className = str.split(Pattern.quote("."))[str.split(Pattern.quote(".")).length - 1];
		String Description = arg0.getMethod().getDescription()+ " failed and reason is " + arg0.getThrowable();
		String objectImagePath = GetScreenShot.captureScreenShot();
		
		HTMLReportGenerator.StepDetails("fail", className, Description,objectImagePath);

		if (arg0.getStatus() == ITestResult.FAILURE) {
			System.out.println(className + " step failed");
		}

		String path = TestSuiteListener.filePath;
		String contents = Generic.getDateTime() + " " + className+ " step failed";
		
		TextOperations.AppendTextFile(path, contents);

	}

	@Override
	public void onTestSkipped(ITestResult arg0) {

		String str = arg0.getTestClass().getName();
		// System.out.println(arg0.getTestClass().getName());
		String className = str.split(Pattern.quote("."))[str.split(Pattern.quote(".")).length - 1];
		String Description = arg0.getMethod().getDescription()+ " skipped and reason is " + arg0.getThrowable();
		String objectImagePath = "C:\\ejagruti-automation\\testSkipped.png";

		HTMLReportGenerator.StepDetails("skip", className, Description,objectImagePath);

		if (arg0.getStatus() == ITestResult.SKIP) {
			System.out.println(className + " step skipped");
		}

		String path = TestSuiteListener.filePath;
		String contents = Generic.getDateTime() + " " + className+ " step skipped";
		
		TextOperations.AppendTextFile(path, contents);

	}

	@Override
	public void onTestStart(ITestResult arg0) {

		if (arg0.getTestContext().getCurrentXmlTest().getParameter("execute").contains("n")) {
			// System.out.println("Test case skipped");
			throw new SkipException("Skipped");
		}

		String str = arg0.getTestClass().getName();
		// System.out.println(arg0.getTestClass().getName());

		String className = str.split(Pattern.quote("."))[str.split(Pattern.quote(".")).length - 1];
		String parameters = arg0.getTestContext().getCurrentXmlTest().getParameter(className);

		System.out.println(className + " step Started");
		System.out.println("Parameters of " + className + " Step: "+ parameters);

		String path = TestSuiteListener.filePath;
		String contents = "\r\n" + Generic.getDateTime() + " " + className
				+ " step Started" + "\r\n" + Generic.getDateTime()
				+ " Parameters of " + className + " Step: " + parameters;
		
		TextOperations.AppendTextFile(path, contents);

	}

	@Override
	public void onTestSuccess(ITestResult arg0) {

		// System.out.println(arg0.getTestClass().getName());
		String str = arg0.getTestClass().getName();
		String className = str.split(Pattern.quote("."))[str.split(Pattern.quote(".")).length - 1];
		String Description = arg0.getMethod().getDescription();
		String objectImagePath = GetScreenShot.captureScreenShot();
		
		HTMLReportGenerator.StepDetails("pass", className, Description,objectImagePath);

		System.out.println(className + " step passed");

		String path = TestSuiteListener.filePath;
		String contents = "\r\n" + Generic.getDateTime() + " " + className+ " step passed";
		
		TextOperations.AppendTextFile(path, contents);
	}

}
