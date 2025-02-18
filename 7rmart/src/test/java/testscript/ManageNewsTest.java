package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utility.ExcelUtility.ExcelUtilities;

public class ManageNewsTest extends Base {
	@Test
	public void verifyThatUserCanCreateNewsSuccessfully() throws IOException {
		//String username = "admin";
		//String passwordvalue = "admin";
		String username=ExcelUtilities.getStringData(1, 0, "login_page");
		String passwordvalue=ExcelUtilities.getStringData(1, 1, "login_page");
		String news=ExcelUtilities.getStringData(1, 0, "Manage_news");
		//String news = "automation testing";

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSignInButton();

		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage.clickTheManageNewsInfo();
		managenewspage.clickTheManageNewsNewButton();
		managenewspage.enterTheNews(news);
		managenewspage.clickTheSaveButton();
		boolean isAlertMessageDispalyed = managenewspage.isAlertDisplayed();
		Assert.assertTrue(isAlertMessageDispalyed);

	}
	
}
