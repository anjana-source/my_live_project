package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageContactPage {
	WebDriver driver;
	
	public ManageContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']")
	private WebElement managecontact;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1']")
	private WebElement editbutton;
	@FindBy(xpath="//input[@id='phone']")
	private WebElement phonenumber;
	@FindBy(xpath="//textarea[@name='del_time']")
	private WebElement deliver_time;
	@FindBy(xpath="//button[@name='Update']")
	private WebElement update_button;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement greenAlertbox;
	
	public void clickTheManageContactMoreinfo()
	{
		managecontact.click();
	}
	
	public void clickTheEditButton()
	{
		editbutton.click();
	}
	
	public void enterThePhoneNumber(String phone)
	{
		phonenumber.clear();
		phonenumber.sendKeys(phone);
	}
	
	public void enterTheDeliveryTime(String del_tym)
	{
		deliver_time.clear();
		deliver_time.sendKeys(del_tym );
	}
	public void clickUpdateButton()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
	
		js.executeScript("arguments[0].click();", update_button);
		//update_button.click();
		
	}
	
	public boolean isAlertDisplayed()
	{
		return greenAlertbox.isDisplayed();
		
	}
	
	public boolean isUpdate_ButtonDisplayed() {
		return update_button.isEnabled();
		
	}
}
