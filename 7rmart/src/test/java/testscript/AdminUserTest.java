package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUserPage;
import pages.LoginPage;
import utility.ExcelUtility.ExcelUtilities;

public class AdminUserTest extends Base{
	@Test
	public void verifyThatAdminIsAbleToCreateNewUserSuccessfully() throws IOException {
		//String username = "admin";
		//String passwordvalue = "admin";
		
		String username=ExcelUtilities.getStringData(1, 0, "Admin_user");
		String passwordvalue=ExcelUtilities.getStringData(1, 1, "Admin_user");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSignInButton();
		
		
	String newusername=ExcelUtilities.getStringData(2, 0, "Admin_user");
	String newpasswords=ExcelUtilities.getStringData(2, 1, "Admin_user");
	
		//String newusername = "anuc48o780";
		//String newpasswords = "acd5e0560908";

		AdminUserPage adminuserpage = new AdminUserPage(driver);
		adminuserpage.clickTheAdminUserMoreInfo();
		adminuserpage.clickTheAdminUserNewButton();
		adminuserpage.enterUserName(newusername);
		adminuserpage.enterPassword(newpasswords);
		adminuserpage.selectUserType();
		adminuserpage.clickTheSaveButton();
		boolean isAlertMessageDispalyed = adminuserpage.isAlertDisplayed();
		Assert.assertTrue(isAlertMessageDispalyed);

	}

	@Test
	public void verifyThatTheSaveButtonIsDisplayed() throws IOException {
		//String username = "admin";
		//String passwordvalue = "admin";
		String username=ExcelUtilities.getStringData(1, 0, "Admin_user");
		String passwordvalue=ExcelUtilities.getStringData(1, 1, "Admin_user");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSignInButton();
		
		AdminUserPage adminuserpage = new AdminUserPage(driver);
		adminuserpage.clickTheAdminUserMoreInfo();
		adminuserpage.clickTheAdminUserNewButton();
		adminuserpage.isSaveButtonDisplayed();
		boolean isAlertMessageDispalyed = adminuserpage.isSaveButtonDisplayed();
		Assert.assertTrue(isAlertMessageDispalyed);

	}

}
