package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LogOutPage;
import pages.LoginPage;
import pages.ManageProductPage;
import utility.ExcelUtility.ExcelUtilities;

public class ManageProductTest extends Base {
	LogOutPage logoutpage;
	ManageProductPage manageproductpage;
@Test(description="verify That Product Can Delete From Manage product")
public void verifyThatProductCanDeleteFromManageproduct() throws IOException {
		
		String username=ExcelUtilities.getStringData(1, 0, "login_page");
		String passwordvalue=ExcelUtilities.getStringData(1, 1, "login_page");
		/*
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSignInButton();
	
		ManageProductPage manageproduct=new ManageProductPage(driver);
		manageproduct.clickTheManageProductMoreInfo();
		manageproduct.clickTheDeleteButton();
		boolean isAlertMessageDispalyed = manageproduct.isAlertDisplayed();
		Assert.assertTrue(isAlertMessageDispalyed,Constants.MANAGEPRODUCT);
*/
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(passwordvalue);
		logoutpage = loginpage.clickOnSignInButton();
		manageproductpage=logoutpage.clickTheManageProductMoreInfo();
		manageproductpage.clickTheDeleteButton();
		boolean isAlertMessageDispalyed = manageproductpage.isAlertDisplayed();
		Assert.assertTrue(isAlertMessageDispalyed,Constants.MANAGEPRODUCT);
}
}
