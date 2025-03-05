package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LogOutPage;
import pages.LoginPage;
import pages.ManageProductPage;
import pages.ManageSubCategoryPage;
import utility.FakerUtility;
import utility.ExcelUtility.ExcelUtilities;


public class ManageSubCategoryTest extends Base {
	LogOutPage logoutpage;
	ManageSubCategoryPage managesubcategorypage;
@Test(description="verify That Manage SubCategory can uplaod File")
public void verifyThatManageSubCategorycanuplaodFile() throws IOException, AWTException {
		
		String username=ExcelUtilities.getStringData(1, 0, "login_page");
		String passwordvalue=ExcelUtilities.getStringData(1, 1, "login_page");
		//String subcategory1=ExcelUtilities.getStringData(1, 0, "Manage_subcategory");
		//String subcategory1 = "apple123";
		
		FakerUtility fakerutility = new FakerUtility();
		String subcategory1 = fakerutility.creatARandomFirstName();
		/*
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSignInButton();
		
		ManageSubCategoryPage managesubcategorypage= new ManageSubCategoryPage(driver);
		managesubcategorypage.clickTheSubCategoryMoreInfo();
		managesubcategorypage.clickTheNew_Button();
		managesubcategorypage.selectCategory_Dropdown();
		managesubcategorypage.enterSubCategory(subcategory1);
		managesubcategorypage.uploadTheImage();
		managesubcategorypage.clickTheSaveButton();
		boolean isGreenalertmessageDispalyed=managesubcategorypage.isGreenAlertboxDispalyed();
		Assert.assertTrue(isGreenalertmessageDispalyed,Constants.MANAGESUBCATEGORY);
		*/
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(passwordvalue);
		logoutpage = loginpage.clickOnSignInButton();
		managesubcategorypage=logoutpage.clickTheSubCategoryMoreInfo();
		managesubcategorypage.clickTheNew_Button().selectCategory_Dropdown().enterSubCategory(subcategory1).uploadTheImage().clickTheSaveButton();
		boolean isGreenalertmessageDispalyed=managesubcategorypage.isGreenAlertboxDispalyed();
		Assert.assertTrue(isGreenalertmessageDispalyed,Constants.MANAGESUBCATEGORY);
}
}