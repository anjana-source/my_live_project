package testscript;

import java.io.IOException;

import org.testng.Assert;

import pages.LoginPage;
import pages.ManageProductPage;
import utility.ExcelUtility.ExcelUtilities;

public class ManageProductTest extends Base {
	
public void verifyThatProductCanDeleteFromManageproduct() throws IOException {
		
		String username=ExcelUtilities.getStringData(1, 0, "login_page");
		String passwordvalue=ExcelUtilities.getStringData(1, 1, "login_page");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSignInButton();
	
		ManageProductPage manageproduct=new ManageProductPage(driver);
		manageproduct.clickTheManageProductMoreInfo();
		boolean isAlertMessageDispalyed = manageproduct.isAlertDisplayed();
		Assert.assertTrue(isAlertMessageDispalyed);

}
}
