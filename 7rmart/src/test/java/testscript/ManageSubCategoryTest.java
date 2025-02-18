package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageSubCategoryPage;
import utility.ExcelUtility.ExcelUtilities;

public class ManageSubCategoryTest extends Base {
@Test	
public void verifyThatManageCategorycandelete() throws IOException, AWTException {
		
		String username=ExcelUtilities.getStringData(1, 0, "login_page");
		String passwordvalue=ExcelUtilities.getStringData(1, 1, "login_page");
		String subcategory1=ExcelUtilities.getStringData(1, 0, "Manage_subcategory");
		//String subcategory1 = "apple123";
		
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSignInButton();
		
		ManageSubCategoryPage managesubcategorypage= new ManageSubCategoryPage(driver);
		managesubcategorypage.clickTheSubCategoryMoreInfo();
		managesubcategorypage.clickTheNew_Button();
		managesubcategorypage.selectcategory_Dropdown();
		managesubcategorypage.enterSubcategory(subcategory1);
		managesubcategorypage.uploadTheImage();
		managesubcategorypage.clickTheSaveButton();
		boolean isGreenalertmessageDispalyed=managesubcategorypage.isGreenAlertboxDispalyed();
		Assert.assertTrue(isGreenalertmessageDispalyed);
		

}
}