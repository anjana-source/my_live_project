package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.PageUtility;


public class AdminUserPage {
	WebDriver driver;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")
//	private WebElement adminmoreinfo;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newbutton;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement user;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement usertype;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertbox;

	/*
	public void clickTheAdminUserMoreInfo() {
		adminmoreinfo.click();
		return this;
	}

*/
	public AdminUserPage clickTheAdminUserNewButton() {
		newbutton.click();
		return this;
	}

	public AdminUserPage enterUserName(String username) {
		user.sendKeys(username);
		return this;
	}

	public AdminUserPage enterPassword(String passsword) {
		password.sendKeys(passsword);
		return this;
	}

	public AdminUserPage selectUserType() {
		
	//Select select = new Select(usertype);
	//select.selectByVisibleText("Staff");
		PageUtility pageutility=new PageUtility();
		pageutility.selectByVisibleText(usertype,"Staff");
		return this;

	}

	public AdminUserPage clickTheSaveButton() {
		savebutton.click();
		return this;
	}
	
	public boolean isAlertDisplayed() {
		return alertbox.isDisplayed();
	}
	
	public boolean isSaveButtonDisplayed() {
		return savebutton.isDisplayed();
	}
}

