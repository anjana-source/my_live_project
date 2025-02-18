package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utility.ExcelUtility.ExcelUtilities;

public class LoginTest extends Base {
	@Test
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException
	{
		String username=ExcelUtilities.getStringData(1, 0, "login_page");
		String passwordvalue=ExcelUtilities.getStringData(1, 1, "login_page");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSignInButton();
	boolean ishomepageavailavle=loginpage.isDashbordLoaded();
	Assert.assertTrue(ishomepageavailavle);
	}
	@Test
	public void verifyTheUserIsAbleToLoginUsingValidUsernameInvalidPassword() throws IOException
	{
		String username=ExcelUtilities.getStringData(2, 0, "login_page");
		String passwordvalue=ExcelUtilities.getIntegerData(2, 1, "login_page");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSignInButton();
		boolean isAlertMessageDisplayed=loginpage.isAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed);
		
	}
	@Test
	public  void verifyTheUserIsAbleToUsingInvalidUsernameValidpassword() throws IOException
	{
		String username=ExcelUtilities.getStringData(3, 0, "login_page");
		String passwordvalue=ExcelUtilities.getStringData(3, 1, "login_page");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSignInButton();
		boolean isAlertMessageDisplayed=loginpage.isAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed);
		
	}
	@Test
	public  void verifyTheUserIsAbleToUsingInvalidUsernameInvalidpassword() throws IOException
	{
		String username=ExcelUtilities.getIntegerData(4, 0, "login_page");
		String passwordvalue=ExcelUtilities.getIntegerData(4, 1, "login_page");
		
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSignInButton();
		boolean isAlertMessageDisplayed=loginpage.isAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed);
		
	}

}

