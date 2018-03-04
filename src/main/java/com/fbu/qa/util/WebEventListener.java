package com.fbu.qa.util;
//WebListener is used to get logs 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.fbu.qa.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener {
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigating to: '" + url + "'");
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to:'" + url + "'");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Value of the:" + element.toString() + " before any changes made");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Element value changed to: " + element.toString());
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Trying to click on: " + element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on: " + element.toString());
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back to previous page");
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to previous page");
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating forward to next page");
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated forward to next page");
	}

	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Exception occured: " + error);
		TestUtil.takeScreenShot();
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to find Element By : " + by.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found Element By : " + by.toString());
	}

	/*
	 * non overridden methods of WebListener class
	 */
	public void beforeScript(String script, WebDriver driver) {
		System.out.println("before script : "+script);
	}

	public void afterScript(String script, WebDriver driver) {
		System.out.println("after script : "+script);
	}

	public void beforeAlertAccept(WebDriver driver) {
		System.out.println("Before Alert Accept");

	}

	public void afterAlertAccept(WebDriver driver) {
		System.out.println("After Alert Accept");

	}

	public void afterAlertDismiss(WebDriver driver) {
		System.out.println("Before Alert Dismiss");

	}

	public void beforeAlertDismiss(WebDriver driver) {
		System.out.println("After Alert Dismiss");

	}

	public void beforeNavigateRefresh(WebDriver driver) {
		System.out.println("Before Navigate Refresh");

	}

	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("After Navigate Refresh");

	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("Value of the:" + element.toString()+"before Change Value");

	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("Value of the:" + element.toString()+"after Change Value");

	}


}
