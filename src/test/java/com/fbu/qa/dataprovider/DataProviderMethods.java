package com.fbu.qa.dataprovider;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.fbu.qa.data.CustomerDetails;
import com.fbu.qa.models.Customer;
import com.fbu.qa.models.LoginCredential;

public class DataProviderMethods {
	
	@DataProvider(name = "LoginDetails")
	public Iterator<LoginCredential> loginPageData(){
		return CustomerDetails.loginDetails().iterator();
		}
	@DataProvider(name = "CustomerData")
	public Iterator<Customer>  loginPageCreateAccountDataProvider(){
		return CustomerDetails.loginPageCreateAccountData().iterator();
			}
	
}
