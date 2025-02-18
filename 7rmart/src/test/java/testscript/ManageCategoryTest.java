package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageCategoryPage;
import utility.ExcelUtility.ExcelUtilities;

public class ManageCategoryTest  extends Base{
	@Test
	public void verifyThatManageCategorycandelete() throws IOException {
		
		String username=ExcelUtilities.getStringData(1, 0, "login_page");
		String passwordvalue=ExcelUtilities.getStringData(1, 1, "login_page");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSignInButton();
		
		ManageCategoryPage managecategory=new ManageCategoryPage(driver);
		managecategory.clickTheManageCategoryMoreInfo();
		managecategory.clickThedeleteButton();
		boolean isAlertMessageDispalyed = managecategory.isAlertDisplayed();
		Assert.assertTrue(isAlertMessageDispalyed);

	
		
	}

}
