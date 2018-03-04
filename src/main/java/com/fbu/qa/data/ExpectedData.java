package com.fbu.qa.data;
import com.fbu.qa.base.TestBase;
import com.fbu.qa.pages.HomePage;

public class ExpectedData extends TestBase {

public static final String ExpectedLoginPageTitle = "Facebook - Log In or Sign Up";

	public static String getExpectedHomePageTitle() {

		HomePage homePage = new HomePage();

		int friendRequestsCount = 0;
		if (homePage.getFriendRequest() != null && !(homePage.getFriendRequest().isEmpty())) {
			friendRequestsCount = Integer.valueOf(homePage.getFriendRequest());

		}

		int messagesCount = 0;
		if (homePage.getMessages() != null && !(homePage.getMessages().isEmpty())) {
			messagesCount = Integer.valueOf(homePage.getMessages());

		}

		int notificationsCount = 0;
		if (homePage.getNotifications() != null && !(homePage.getNotifications().isEmpty())) {
			notificationsCount = Integer.valueOf(homePage.getNotifications());

		}

		int addition = messagesCount + notificationsCount + friendRequestsCount;

		String str = String.valueOf(addition);

		if (str.equals("")) {
			return "Facebook";
		}

		else {
			return "(" + str + ") " + "Facebook";
		}
	}}