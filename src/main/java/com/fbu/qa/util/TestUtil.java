package com.fbu.qa.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.fbu.qa.base.TestBase;




public class TestUtil extends TestBase {
	public static final long PAGE_LOAD_TIMEOUT = 50;
	public static final long IMPLICIT_WAIT= 30;
	
	public static String getPageTitle() {
		 return driver.getTitle();
		 
	  }
	
	public static void takeScreenShot() {
		/*if(result.getStatus() == ITestResult.FAILURE) {*/
		File nFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			String currentDir = System.getProperty("user.dir");
			System.out.println(currentDir);
			FileUtils.copyFile(nFile, new File(currentDir + "//screenshots//" + System.currentTimeMillis() + ".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	}

