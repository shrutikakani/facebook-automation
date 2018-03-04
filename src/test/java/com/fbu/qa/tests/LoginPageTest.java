package com.fbu.qa.tests;
import static com.fbu.qa.data.ExpectedData.ExpectedLoginPageTitle;
import static com.fbu.qa.util.TestUtil.getPageTitle;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fbu.qa.data.ExpectedData;
import com.fbu.qa.dataprovider.DataProviderMethods;
import com.fbu.qa.models.Customer;
import com.fbu.qa.models.LoginCredential;

public class LoginPageTest extends commonTest{
	
	@Test
	public void validateLoginPageTitle() {
		String actualLoginPageTitle = getPageTitle();
		Assert.assertEquals(actualLoginPageTitle,ExpectedLoginPageTitle);
	}
	
	@Test
	public void  validateLogo() {
		Assert.assertTrue(loginPage.isLogoPresent());
	}
	
	
	@Test(dataProvider = "LoginDetails",dataProviderClass = DataProviderMethods.class)
	public void validateLoginTest(LoginCredential loginCredential ) {
		loginPage.login(loginCredential).logOutFromAccount();
		Assert.assertEquals(loginPage.getActualHomePageTitle(),ExpectedData.getExpectedHomePageTitle() );
	
	}
	
	@Test(dataProvider = "CustomerData",dataProviderClass = DataProviderMethods.class)
	public void validateNewAccount(Customer customer) {
		loginPage.createNewAccount(customer);
	}
	
	@Test
	public void validateRecoverAccount() {
		loginPage.forgotAccount().giveRecoveryEmail("shruti.kakani@gmail.com");
	}

	
}

/*@Test(priority = 4,dataProvider = "CustomerData",dataProviderClass = CustomerDetails.class)
public void validateNewAccount(String[] details) {
	System.out.println("check1");
	createNewAccount(details);
}*/

