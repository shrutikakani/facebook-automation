package com.fbu.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fbu.qa.base.TestBase;
import com.fbu.qa.data.ExpectedData;

public class RecoveryAccountPage extends TestBase {
	static RecoveryAccountPage recoveryPage;
	
	@FindBy(id  = "identify_email")
	private  WebElement identifyEmail;
	@FindBy(name  = "did_submit")
	private  WebElement dSubmit;
	public RecoveryAccountPage() {
	PageFactory.initElements(driver,this);
	}
	
	
	public  void giveRecoveryEmail(String email) {
		recoveryPage= new RecoveryAccountPage();
		recoveryPage.identifyEmail.sendKeys(email);
		recoveryPage.dSubmit.click();
		while(ExpectedData.ExpectedLoginPageTitle.equals(driver.getTitle())) {
		driver.navigate().back();
		}
	}
}
