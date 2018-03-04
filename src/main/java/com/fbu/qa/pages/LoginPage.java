package com.fbu.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fbu.qa.base.TestBase;
import com.fbu.qa.models.Customer;
import com.fbu.qa.models.LoginCredential;
import com.fbu.qa.util.TestUtil;

public class LoginPage extends TestBase {
	
	private String actualHomePageTitle;
	
	@FindBy(id = "email")
	private  WebElement emailID;

	@FindBy(id = "pass")
	private  WebElement passWD;

	@FindBy(id = "loginbutton")
	private  WebElement loginButton;

	@FindBy(name = "firstname")
	private   WebElement firstName;

	@FindBy(name = "lastname")
	private  WebElement lastName;

	@FindBy(name = "reg_email__")
	private  WebElement emailOrNumber;

	@FindBy(name = "reg_passwd__")
	private WebElement newPasswd;

	@FindBy(name = "birthday_day")
	private  WebElement birthDay;

	@FindBy(name = "birthday_month")
	private  WebElement birthMonth;

	@FindBy(name = "birthday_year")
	private  WebElement birthYear;

	@FindBy(id = "u_0_b")
	private  WebElement femaleGender;

	@FindBy(id = "u_0_c")
	private  WebElement maleGender;

	@FindBy(id = "birthday-help")
	private  WebElement birthdayHelp;

	@FindBy(xpath = "//button[contains(text() , 'Create Account')]")
	private  WebElement CreateAccounButton;

	@FindBy(xpath = "//i[contains(@class ,'fb_logo img ')]")
	private  WebElement facebookLogo;
	
	@FindBy(linkText = "Forgot account?")
	private  WebElement forgotAccount;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isLogoPresent() {
		return this.facebookLogo.isDisplayed();
	}

	public String getActualHomePageTitle() {
		return actualHomePageTitle;
	}

	public void setActualHomePageTitle(String actualHomePageTitle) {
		this.actualHomePageTitle = actualHomePageTitle;
	}
	
	public HomePage login(LoginCredential loginCredential) {
		this.emailID.sendKeys(loginCredential.getEmail());
		this.passWD.sendKeys(loginCredential.getPass());
		this.loginButton.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		setActualHomePageTitle(driver.getTitle());
		return new HomePage();
	}
	public HomePage login() {
		this.emailID.sendKeys(properties.getProperty("UserID"));
		this.passWD.sendKeys(properties.getProperty("PassWD"));
		this.loginButton.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		return new HomePage();
	}
	
	public void createNewAccount(Customer customer) {
		this.firstName.sendKeys(customer.getfName());
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		this.lastName.sendKeys(customer.getlName());
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		this.emailOrNumber.sendKeys(customer.getEmailAddressOrMobileNumber());
		this.newPasswd.sendKeys(customer.getNewPassword());
		this.birthMonth.sendKeys(customer.getBirthMonth());
		this.birthDay.sendKeys(customer.getBirthDay());
		this.birthYear.sendKeys(customer.getBirthYear());
		
		if("Male".equalsIgnoreCase(customer.getGender())) {
			this.maleGender.click();
		}  else {
			this.femaleGender.click();
		}
		
	}
	
	public RecoveryAccountPage forgotAccount() {
		this.forgotAccount.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		return new RecoveryAccountPage();
	}

}




/*public static void createNewAccount(String[] details) {
	login = new LoginPage();
	login.firstName.sendKeys(details[0]);
	login.lastName.sendKeys(details[1]);
	login.emailOrNumber.sendKeys(details[2]);
	login.newPasswd.sendKeys(details[3]);
	login.birthMonth.sendKeys(details[4]);
	login.birthDay.sendKeys(details[5]);
	login.birthYear.sendKeys(details[6]);
	
	if("Male".equalsIgnoreCase(details[7])) {
		login.maleGender.click();
	}  else {
		login.femaleGender.click();
	}
	
}*/

/*private static LoginPage loginPage = null;

	private LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public static LoginPage getInstance() {
		if(loginPage == null) {
			loginPage = new LoginPage();
		}
		return loginPage;
	}
*/
