package com.fbu.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.fbu.qa.util.TestUtil;
import com.fbu.qa.util.WebEventListener;


public class TestBase {
	static public Properties properties;
	static public WebDriver driver;
	static TestBase base;
	
	static {
		properties = new Properties();
		try {
			properties.load(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\fbu\\qa\\config\\config.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void launchBrowser() {
		String browserName = properties.getProperty("Browser");
		if (browserName.equals("FireFox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\Drivers\\geckodriver-v0.18.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver(options);
		} else if (browserName.equals("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Drivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver(options);
		} else {
			System.err.println("InvalidBrowser");
		}
		EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
		eventFiringWebDriver.register(new WebEventListener());
		driver = eventFiringWebDriver;	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.get(properties.getProperty("URL"));
	}
	
	
	
	public static void closeBrowser() {
		
		driver.close();
	}
	
	
	
}
