package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LogOutPage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utility.ExcelUtility.ExcelUtilities;

public class ManageNewsTest extends Base {
	LogOutPage logoutpage;
	ManageNewsPage managenewspage1;
	
	@Test(description="verify That User Can Create News Successfully")
	public void verifyThatUserCanCreateNewsSuccessfully() throws IOException {
		//String username = "admin";
		//String passwordvalue = "admin";
		String username=ExcelUtilities.getStringData(1, 0, "login_page");
		String passwordvalue=ExcelUtilities.getStringData(1, 1, "login_page");
		String news=ExcelUtilities.getStringData(1, 0, "Manage_news");
		//String news = "automation testing";

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(passwordvalue);  // 
		logoutpage= loginpage.clickOnSignInButton();
				//loginpage.enterPassword(passwordvalue);


		//ManageNewsPage managenewspage = new ManageNewsPage(driver);
	//	managenewspage.clickTheManageNewsInfo();
		//logoutpage.clickTheManageNewsInfo();
		
		managenewspage1=logoutpage.clickTheManageNewsInfo();
		
		managenewspage1.clickTheManageNewsNewButton().enterTheNews(news).clickTheSaveButton();
		//managenewspage.enterTheNews(news);
		//managenewspage.clickTheSaveButton();
		boolean isAlertMessageDispalyed = managenewspage1.isAlertDisplayed();
		Assert.assertTrue(isAlertMessageDispalyed,Constants.MANAGENEWS);

	}
	
}
