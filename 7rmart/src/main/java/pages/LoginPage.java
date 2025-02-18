package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	//@FindBy(xpath="//input[@type='text']")private WebElement usernameField;
	//@FindBy(xpath="//input[@name='password']")private WebElement password;
	@FindBy(xpath="//input[@name='username']")private WebElement usernameField;
	@FindBy(xpath="//input[@name='password']")private WebElement password;
	@FindBy(xpath="//button[@type='submit']")private WebElement submit;
	@FindBy(xpath="//p[text()='Dashboard']")private WebElement dashboard;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")private WebElement alertbox;
	

public void enterUserName(String username)
{
	usernameField.sendKeys(username);
}
public void enterPassword(String passwordvalue)
{
	password.sendKeys(passwordvalue);
	
}
public void clickOnSignInButton()
{
	submit.click();
}
public boolean isDashbordLoaded()
{
	return dashboard.isDisplayed();
	
}
public boolean isAlertDisplayed()
{
	return alertbox.isDisplayed();
	
}
}
