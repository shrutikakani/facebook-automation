package com.fbu.qa.data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fbu.qa.base.TestBase;
import com.fbu.qa.models.Customer;
import com.fbu.qa.models.LoginCredential;
//fn -f2 rename
public class CustomerDetails extends TestBase {
	
	private static Connection connect = null;
	
	static {
		try {
			System.out.println("Inside static block..BEFORE creating connection.. : " + connect);
			connect = DriverManager.getConnection(properties.getProperty("MySQLUurl"),
					properties.getProperty("MySQLid"), properties.getProperty("MySQLpass"));
			System.out.println("Inside static block..AFTER creating connection.. : " + connect);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeConnection() {
		try {
			if(connect != null && !connect.isClosed()) {
				System.out.println("Closing Connection now..");
				connect.close();
			}
		} catch(SQLException ex) {
			
		}
		
	}
	
	public static List<LoginCredential> loginDetails(){
		List<LoginCredential> loginCredentials = new ArrayList<LoginCredential>();
		Statement statement = null;
		
		
		try {
			statement = connect.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from logindatafb");
			while(resultSet.next()) {
				LoginCredential loginCredential = new LoginCredential();
				loginCredential.setEmail(resultSet.getString("Email"));
				loginCredential.setPass(resultSet.getString("Password"));
				loginCredentials.add(loginCredential);
			}
			resultSet.close();
			
		} catch (SQLException e) {
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}

		return loginCredentials;
	}
	
	
	
	
	
	
	
	public static List<Customer> loginPageCreateAccountData(){
		
		List<Customer> customers = new ArrayList<Customer>();
		Statement statement = null;
		
		try {
			
			System.out.println("Inside loginPageCreateAccountData method..connection is  : " + connect);
			statement = connect.createStatement();
			System.out.println("check3");
			ResultSet resultSet = statement.executeQuery("select * from  CreateAccountData");
			 while(resultSet.next()) {
				 
				 Customer customer = new Customer();
				
				 customer.setfName(resultSet.getString("FirstName"));
				 customer.setlName(resultSet.getString("LastName"));
				 customer.setEmailAddressOrMobileNumber(resultSet.getString("EmailOrMobile"));
				 customer.setNewPassword(resultSet.getString("NewPassword"));
				 customer.setBirthMonth(resultSet.getString("BirthMonth"));
				 customer.setBirthDay(resultSet.getString("BirthDay"));
				 customer.setBirthYear(resultSet.getString("BirthYear"));
				 customer.setGender(resultSet.getString("Gender"));
				 
				 customers.add(customer);
			 }
			 
			 resultSet.close();
			 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Inside loginPageCreateAccountData");
		
		return customers;
	}
	
	
	/*private Map<Integer ,String[]> map = new HashMap<Integer ,String[]>();

	public CustomerDetails() {
		try {
			ArrayList<String> accountDetails ;
			Connection connect = DriverManager.getConnection(properties.getProperty("MySQLUurl"),
					properties.getProperty("MySQLid"), properties.getProperty("MySQLpass"));
		
			Statement statement = connect.createStatement();
			System.out.println("check3");
			ResultSet resultSet = statement.executeQuery("select * from  CreateAccountData");
			 int i = 0;
			 while(resultSet.next()) {
				 accountDetails = new ArrayList<String>();
				 accountDetails.add(resultSet.getString("FirstName"));
				 accountDetails.add(resultSet.getString("LastName"));
				 accountDetails.add(resultSet.getString("EmailOrMobile"));
				 accountDetails.add(resultSet.getString("NewPassword"));
				 accountDetails.add(resultSet.getString("BirthMonth"));
				 accountDetails.add(resultSet.getString("BirthDay"));
				 accountDetails.add(resultSet.getString("BirthYear"));
				 accountDetails.add(resultSet.getString("Gender"));
				 
				 String[] arr = new String[accountDetails.size()];
				 
				 map.put(i,accountDetails.toArray(arr));
				 System.out.println(map);
				 i++;
			 }
			 
			 System.out.println("Values are : " + map.values());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	@DataProvider(name = "CustomerData")
	public  Iterator<String[]> loginPageCreateAccountData(){
		System.out.println("Inside loginPageCreateAccountData");
		Iterator<List<String>> valueItr = map.values().iterator();
		while(valueItr.hasNext()){
			valueItr.next();
		}
		return map.values().iterator();
	}*/
	
	
	
}
