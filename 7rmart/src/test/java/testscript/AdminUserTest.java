package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.AdminUserPage;
import pages.LoginPage;
import utility.ExcelUtility.ExcelUtilities;
import utility.FakerUtility;

public class AdminUserTest extends Base {
	@Test(description="verify That Admin Is Able To Create New User Successfully")
	public void verifyThatAdminIsAbleToCreateNewUserSuccessfully() throws IOException {
		// String username = "admin";
		// String passwordvalue = "admin";

		String username = ExcelUtilities.getStringData(1, 0, "Admin_user");
		String passwordvalue = ExcelUtilities.getStringData(1, 1, "Admin_user");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSignInButton();

		// String newusername=ExcelUtilities.getStringData(2, 0, "Admin_user");
		FakerUtility fakerutility = new FakerUtility();
		String newusername = fakerutility.creatARandomFirstName();
		String newpasswords = ExcelUtilities.getStringData(2, 1, "Admin_user");

		// String newusername = "anuc48o780";
		// String newpasswords = "acd5e0560908";

		AdminUserPage adminuserpage = new AdminUserPage(driver);
		adminuserpage.clickTheAdminUserMoreInfo();
		adminuserpage.clickTheAdminUserNewButton();
		adminuserpage.enterUserName(newusername);
		adminuserpage.enterPassword(newpasswords);
		adminuserpage.selectUserType();
		adminuserpage.clickTheSaveButton();
		boolean isAlertMessageDispalyed = adminuserpage.isAlertDisplayed();
		Assert.assertTrue(isAlertMessageDispalyed,"Admin Is not Able To Create New User");

	}

	@Test(dataProvider = "LoginProvider",description="verify That The Save Button Is Displayed on the screen")
	public void verifyThatTheSaveButtonIsDisplayed(String username, String passwordvalue) throws IOException {
		// String username = "admin";
		// String passwordvalue = "admin";
		// String username=ExcelUtilities.getStringData(1, 0, "Admin_user");
		// String passwordvalue=ExcelUtilities.getStringData(1, 1, "Admin_user");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSignInButton();

		AdminUserPage adminuserpage = new AdminUserPage(driver);
		adminuserpage.clickTheAdminUserMoreInfo();
		adminuserpage.clickTheAdminUserNewButton();
		adminuserpage.isSaveButtonDisplayed();
		boolean isAlertMessageDispalyed = adminuserpage.isSaveButtonDisplayed();
		Assert.assertTrue(isAlertMessageDispalyed,"Ensure That The Save Button Is Displayed");

	}

	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() throws IOException {
		return new Object[][] {
				{ ExcelUtilities.getStringData(1, 0, "Admin_user"), ExcelUtilities.getStringData(1, 1, "Admin_user") } };

	}
}
