package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LogOutPage;

import pages.LoginPage;
import utility.ExcelUtility.ExcelUtilities;

public class LogOutTest extends Base {
    @Test(retryAnalyzer=retry.Retry.class, description="verify The User Is Able To Logout")
	public void verifyTheUserIsAbleToLogout() throws IOException
	{
		String username=ExcelUtilities.getStringData(1, 0, "login_page");
		String passwordvalue=ExcelUtilities.getStringData(1, 1, "login_page");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSignInButton();
		
		LogOutPage logoutpage=new LogOutPage(driver);
		logoutpage.clickTheAdminicon();
		logoutpage.clickThelogOut();
		boolean verifyingThatLogoutSuccessfull=logoutpage.loginScreen();
		Assert.assertTrue(verifyingThatLogoutSuccessfull,Constants.LOGOUT);
		
	}
}
