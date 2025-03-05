package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.Constants;
import utility.FileUploadUtility;
import utility.PageUtility;

public class ManageSubCategoryPage {
	WebDriver driver;

	public  ManageSubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category' and @class='small-box-footer']")
	private WebElement moreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/add']")
	private WebElement newbutton;
	@FindBy(xpath = "//select[@id='cat_id']")
	private WebElement category;
	@FindBy(xpath = "//input[@id='subcategory']")
	private WebElement sub_category;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement image_upload;
	@FindBy(xpath = "//button[@name='create']")
	private WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement Green_alertbox;
/*
	public void clickTheSubCategoryMoreInfo() {
		moreinfo.click();
	}
	*/

	public ManageSubCategoryPage clickTheNew_Button() {
		newbutton.click();
		return this;
	}

	public ManageSubCategoryPage selectCategory_Dropdown(){
		/*
	 Select select=new Select(category);
	 select.selectByVisibleText("Fresh_fruits");
	 */
		PageUtility pageutility=new PageUtility();
		pageutility.selectByVisibleText(category,"Fresh_fruits");
		return this;
	
	}
	public ManageSubCategoryPage enterSubCategory(String subcategory){
		sub_category.sendKeys(subcategory);
		return this;
			
	}
	
	public ManageSubCategoryPage uploadTheImage() throws AWTException {
		
//	JavascriptExecutor js = (JavascriptExecutor) driver;
		
	//js.executeScript("arguments[0].click();", image_upload);
		
		PageUtility pageutility=new PageUtility();
		pageutility.JavascriptExecutor(driver,image_upload );
		
		//FileUploadUtility fileuploadutility_sendkeys=new FileUploadUtility();
		
		//fileuploadutility_sendkeys.fileUploadUsingRobotClass(image_upload, Constants.APPLEIMAGE);
		
		
		FileUploadUtility fileuploadutilityRobot=new FileUploadUtility();
		
		fileuploadutilityRobot.fileUploadUsingRobotClass(image_upload, Constants.APPLEIMAGE);
		return this;
		
	
	}
		
	public ManageSubCategoryPage clickTheSaveButton() {
		savebutton.click();
		return this;
	}
	public boolean isGreenAlertboxDispalyed()
	{
		return Green_alertbox.isDisplayed();
		
	}
	
}

