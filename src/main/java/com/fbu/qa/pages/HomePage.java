package com.fbu.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fbu.qa.base.TestBase;
import com.fbu.qa.util.TestUtil;

public class HomePage extends TestBase{
	private String title;
	private static String notifications;
	private static String messages;
	private static String friendRequest;
	
	@FindBy(xpath= "//span[@id = 'notificationsCountValue']")
	private WebElement notificationsCountValue;
	
	@FindBy(xpath= "//span[@id = 'mercurymessagesCountValue']")
	private WebElement mercurymessagesCountValue;
	
	@FindBy(xpath = "//span[@id = 'requestsCountValue']")
	private WebElement friendRequestCountValue;
	
	@FindBy(id = "userNavigationLabel")
	private WebElement userNavigationLabel;
	
	@FindBy(xpath = "//li[contains(@data-gt,'menu_logout')]")
	private WebElement logOut;
	
	@FindBy(xpath = "//a[@title = 'Profile']")
	private WebElement profile;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);

	}
	
	public  void logOutFromAccount() {
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		setNotifications(notificationsCountValue.getText()); 
		setMessages(mercurymessagesCountValue.getText());
		setFriendRequest( friendRequestCountValue.getText());
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		userNavigationLabel.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		logOut.click();
	
	}
	
	public ProfilePage openProfile() {
		profile.click();
		setTitle(driver.getTitle());
		return new ProfilePage();
	
	}
	
	
	public HomePage getListOfItemFromSideBar() {
		String start = "//a[@data-testid = 'left_nav_item_";
		String end = "']";

		List<WebElement> sideElements = driver.findElements(By.xpath("//div[@id = 'universalNav']/ul/li/a"));
		final int MAXIMUM_WAIT_TIME = 30;
		System.out.println(sideElements.size());
		WebDriverWait wait = new WebDriverWait(driver, MAXIMUM_WAIT_TIME);
		for (int i = 0; i < sideElements.size(); i++) {
			try {
				sideElements = driver.findElements(By.xpath("//div[@id = 'universalNav']/ul/li"));
				String s = sideElements.get(i).getText();
				System.out.println(s);
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(start + s + end))))
						.click();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				driver.navigate().back();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

			} catch (StaleElementReferenceException e) {
				sideElements = driver.findElements(By.xpath("//div[@id = 'universalNav']/ul/li"));
				continue;
			}
		}
		return this;
	}

	

	public String getNotifications() {
		return notifications;
	}

	public void setNotifications(String notifications) {
		this.notifications = notifications;
		
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	
	}

	public String getFriendRequest() {
		return friendRequest;
	}

	public void setFriendRequest(String friendRequest) {
		this.friendRequest = friendRequest;
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}




/*public static String getNotificationsCount() {
homePage = new HomePage();
return notificationsCountValue.getText();
}*/
/*public static String getMessageCount() {
homePage = new HomePage();
return mercurymessagesCountValue.getText();
}
public static String getFriendRequestCount() {
homePage = new HomePage();
return friendRequestCountValue.getText();
}*/