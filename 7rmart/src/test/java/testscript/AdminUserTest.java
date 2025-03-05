package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUserPage;
import pages.LogOutPage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utility.ExcelUtility.ExcelUtilities;
import utility.FakerUtility;

public class AdminUserTest extends Base {
	LogOutPage logoutpage;
	AdminUserPage adminuserpage;

	@Test(description = "verify That Admin Is Able To Create New User Successfully")
	public void verifyThatAdminIsAbleToCreateNewUserSuccessfully() throws IOException {
		// String username = "admin";
		// String passwordvalue = "admin";

		String username = ExcelUtilities.getStringData(1, 0, "Admin_user");
		String passwordvalue = ExcelUtilities.getStringData(1, 1, "Admin_user");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(passwordvalue);
		logoutpage = loginpage.clickOnSignInButton();
		
		/*
		  LoginPage loginpage = new LoginPage(driver);
		  loginpage.enterUserName(username); loginpage.enterPassword(passwordvalue);
		  loginpage.clickOnSignInButton();
		 */

		// String newusername=ExcelUtilities.getStringData(2, 0, "Admin_user");
		FakerUtility fakerutility = new FakerUtility();
		String newusername = fakerutility.creatARandomFirstName();
		String newpasswords = ExcelUtilities.getStringData(2, 1, "Admin_user");

		// String newusername = "anuc48o780";
		// String newpasswords = "acd5e0560908";

		/*
		 * AdminUserPage adminuserpage = new AdminUserPage(driver);
		 * adminuserpage.clickTheAdminUserMoreInfo();
		 * adminuserpage.clickTheAdminUserNewButton();
		 * adminuserpage.enterUserName(newusername);
		 * adminuserpage.enterPassword(newpasswords); adminuserpage.selectUserType();
		 * adminuserpage.clickTheSaveButton(); boolean isAlertMessageDispalyed =
		 * adminuserpage.isAlertDisplayed();
		 * Assert.assertTrue(isAlertMessageDispalyed,Constants.ADMINUSER);
		 * 
		 */
		adminuserpage = logoutpage.clickTheAdminUserMoreInfo();
		adminuserpage.clickTheAdminUserNewButton().enterUserName(newusername).enterPassword(newpasswords)
				.selectUserType().clickTheSaveButton();
		boolean isAlertMessageDispalyed = adminuserpage.isAlertDisplayed();
		Assert.assertTrue(isAlertMessageDispalyed, Constants.ADMINUSER);

	}

	@Test(dataProvider = "LoginProvider", description = "verify That The Save Button Is Displayed on the screen")
	public void verifyThatTheSaveButtonIsDisplayed(String username, String passwordvalue) throws IOException {
		// String username = "admin";
		// String passwordvalue = "admin";
		// String username=ExcelUtilities.getStringData(1, 0, "Admin_user");
		// String passwordvalue=ExcelUtilities.getStringData(1, 1, "Admin_user");

		/*
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSignInButton();
		*/
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(passwordvalue);
		logoutpage = loginpage.clickOnSignInButton();

		
		/*
		AdminUserPage adminuserpage = new AdminUserPage(driver);
		adminuserpage.clickTheAdminUserMoreInfo();
		adminuserpage.clickTheAdminUserNewButton();
		adminuserpage.isSaveButtonDisplayed();
		boolean isAlertMessageDispalyed = adminuserpage.isSaveButtonDisplayed();
		Assert.assertTrue(isAlertMessageDispalyed, Constants.UPDATEBUTTON);
		*/
		
		adminuserpage = logoutpage.clickTheAdminUserMoreInfo();
		adminuserpage.clickTheAdminUserNewButton().isSaveButtonDisplayed();
		boolean isAlertMessageDispalyed = adminuserpage.isSaveButtonDisplayed();
		Assert.assertTrue(isAlertMessageDispalyed, Constants.UPDATEBUTTON);
		

	}

	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() throws IOException {
		return new Object[][] { { ExcelUtilities.getStringData(1, 0, "Admin_user"),
				ExcelUtilities.getStringData(1, 1, "Admin_user") } };

	}
}
