package com.fbu.qa.tests;

import static com.fbu.qa.base.TestBase.*;
import org.testng.annotations.*;
import com.fbu.qa.pages.LoginPage;

public class commonTest {
	
	protected LoginPage loginPage = null;
	
	@BeforeMethod
	public void setUp() {
		launchBrowser();
		loginPage = new LoginPage();
	}
	
	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}

	/*@AfterTest
	public void closeConnection() {
		System.out.println("Inside closeConnection of CommonTest class");
		CustomerDetails.closeConnection();
	}*/
}
