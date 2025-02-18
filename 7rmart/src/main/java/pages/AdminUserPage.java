package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class AdminUserPage {
	WebDriver driver;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")
	private WebElement adminmoreinfo;
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

	public void clickTheAdminUserMoreInfo() {
		adminmoreinfo.click();
	}

	public void clickTheAdminUserNewButton() {
		newbutton.click();
	}

	public void enterUserName(String username) {
		user.sendKeys(username);
	}

	public void enterPassword(String passsword) {
		password.sendKeys(passsword);
	}

	public void selectUserType() {
	Select select = new Select(usertype);
	select.selectByVisibleText("Staff");

	}

	public void clickTheSaveButton() {
		savebutton.click();
	}
	
	public boolean isAlertDisplayed() {
		return alertbox.isDisplayed();
	}
	
	public boolean isSaveButtonDisplayed() {
		return savebutton.isDisplayed();
	}
}

