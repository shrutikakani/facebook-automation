package com.fbu.qa.tests;

import org.testng.annotations.Test;

public class HomePageTest extends commonTest{
	
	
	
	@Test(priority = 2)
	public void ValidateSideBarOptions() {
		loginPage.login().getListOfItemFromSideBar().logOutFromAccount();

	}
	
	
	@Test(priority = 1)
	public void getProfilePage() {
		loginPage.login().openProfile();
		
	}

}
