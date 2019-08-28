package org.ejagruti.investcorp.generic;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.ejagruti.investcorp.modules.LaunchApp;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class GetScreenShot {

	public static String captureScreenShot() {

		// String userDirectory=System.getProperty("user.dir");
		String customLocation = "C:\\ejagruti\\Screenshots\\";
		String imageFileName = customLocation + System.currentTimeMillis()+ ".png";
		File scrFile = ((TakesScreenshot) LaunchApp.driver).getScreenshotAs(OutputType.FILE);
		try {

			FileUtils.copyFile(scrFile, new File(imageFileName));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return imageFileName;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
