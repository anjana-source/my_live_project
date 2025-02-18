package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManageFooterPage;
import utility.ExcelUtility.ExcelUtilities;

public class ManageFooterTest extends Base {
	
	@Test
	public void verifyThatuserIsAbleToUpadatManageFooterSuccessfully() throws IOException {
		//String username = "admin";
		//String passwordvalue = "admin";
		
		String username=ExcelUtilities.getStringData(1, 0, "login_page");
		String passwordvalue=ExcelUtilities.getStringData(1, 1, "login_page");
		
		String addressname=ExcelUtilities.getStringData(1, 0, "Manage_footer");
		String emails=ExcelUtilities.getStringData(1, 1, "Manage_footer");
	     String phones=ExcelUtilities.getIntegerData(1, 2, "Manage_footer");
		
		//String phones="90876566";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSignInButton();
		
		
		
		
		ManageFooterPage managefooterpage= new ManageFooterPage(driver);
		managefooterpage.clickTheManagefooterTextMoreInfo();
		managefooterpage.clickTheActionButton();
		managefooterpage.clearandenteraddress(addressname);
		managefooterpage.enterEmail(emails);
		managefooterpage.enterphonenumber(phones);
		managefooterpage.clickTheUpdateButton();
		boolean TheAlertBoxisdisplayed=managefooterpage.isAlertDisplayed();
		Assert.assertTrue(TheAlertBoxisdisplayed);

}
	@Test
	public void verifyThatTheUpdateButtonIsDisplayed() throws IOException {
		//String username = "admin";
		//String passwordvalue = "admin";
		String username=ExcelUtilities.getStringData(1, 0, "login_page");
		String passwordvalue=ExcelUtilities.getStringData(1, 1, "login_page");
		

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSignInButton();
		
		ManageFooterPage managefooterpage= new ManageFooterPage(driver);
		managefooterpage.clickTheManagefooterTextMoreInfo();
		managefooterpage.clickTheActionButton();
		managefooterpage.isUpdatebuttonDisplayed();
		boolean isupdateButtonDispalyed = managefooterpage.isUpdatebuttonDisplayed();
		Assert.assertTrue(isupdateButtonDispalyed);

	}


}
