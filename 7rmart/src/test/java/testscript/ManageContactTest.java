package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;
import pages.ManageFooterPage;
import utility.ExcelUtility.ExcelUtilities;

public class ManageContactTest extends Base{
	@Test
	public void verifyThatUserAbleToChangePhonenumberAndDeliveryTime() throws IOException
	{
		String username=ExcelUtilities.getStringData(1, 0, "login_page");
		String passwordvalue=ExcelUtilities.getStringData(1, 1, "login_page");
		String phoneno=ExcelUtilities.getIntegerData(1, 0, "Manage_contact");
		String delivrytime=ExcelUtilities.getIntegerData(1, 1, "Manage_contact");
		
		
		//String phoneno="897878887";
		//String delivrytime="05.19.10";
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSignInButton();
		
		ManageContactPage managecontact=new ManageContactPage(driver);
		managecontact.clickTheManageContactMoreinfo();
		managecontact.clickTheEditButton();
		managecontact.enterThePhoneNumber(phoneno);
		managecontact.enterTheDeliveryTime(delivrytime);
		managecontact.clickUpdateButton();
		boolean isAlertmessageDisplayed=managecontact.isAlertDisplayed();
		Assert.assertTrue(isAlertmessageDisplayed);
	}
   
    @Test
	public void verifyThatTheUpdateButtonIsDisplayed1() throws IOException {
    	
		String username=ExcelUtilities.getStringData(1, 0, "login_page");
		String passwordvalue=ExcelUtilities.getStringData(1, 1, "login_page");
		

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSignInButton();
		
		ManageContactPage managecontact=new ManageContactPage(driver);
		managecontact.clickTheManageContactMoreinfo();
		managecontact.clickTheEditButton();
		//managecontact.clickUpdateButton();
		boolean isupdatebuttonEnabled = managecontact.isUpdate_ButtonDisplayed();
		Assert.assertTrue(isupdatebuttonEnabled);

	}
}

