package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import utility.ExcelUtility.ExcelUtilities;

public class LoginTest extends Base {
	@Test(groups = {"regression"},description="verify The User Is Able To Login Using Valid Credentials") //grouping.xml
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException
	{
		String username=ExcelUtilities.getStringData(1, 0, "login_page");
		String passwordvalue=ExcelUtilities.getStringData(1, 1, "login_page");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSignInButton();
	boolean ishomepageavailavle=loginpage.isDashbordLoaded();
	Assert.assertTrue(ishomepageavailavle,Constants.VALIDCREDENTIALS);
	}
	@Test(description="verify The User Is Able To Login Using Valid Username Invalid Password")
	public void verifyTheUserIsAbleToLoginUsingValidUsernameInvalidPassword() throws IOException
	{
		String username=ExcelUtilities.getStringData(2, 0, "login_page");
		String passwordvalue=ExcelUtilities.getIntegerData(2, 1, "login_page");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSignInButton();
		boolean isAlertMessageDisplayed=loginpage.isAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed,Constants.INVALIDCREDENTIALS);
		
	}
	@Test(description="verify The User Is Able To Using Invalid Username Valid password")
	public  void verifyTheUserIsAbleToUsingInvalidUsernameValidpassword() throws IOException
	{
		String username=ExcelUtilities.getStringData(3, 0, "login_page");
		String passwordvalue=ExcelUtilities.getStringData(3, 1, "login_page");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSignInButton();
		boolean isAlertMessageDisplayed=loginpage.isAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed,Constants.INVALIDCREDENTIALS);
		
	}
	@Test(description="verify The User Is Able To Using Invalid Username Invalid password")
	public  void verifyTheUserIsAbleToUsingInvalidUsernameInvalidpassword() throws IOException
	{
		String username=ExcelUtilities.getIntegerData(4, 0, "login_page");
		String passwordvalue=ExcelUtilities.getIntegerData(4, 1, "login_page");
		
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSignInButton();
		boolean isAlertMessageDisplayed=loginpage.isAlertDisplayed();
		Assert.assertTrue(isAlertMessageDisplayed,Constants.INVALIDCREDENTIALS);
		
	}

}

