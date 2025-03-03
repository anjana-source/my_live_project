package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
	WebDriver driver;

	public LogOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[@class='nav-link' and @data-toggle='dropdown']")private WebElement admin;
		@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")private WebElement logout;
		@FindBy(xpath="//button[@type='submit']")private WebElement login_screen;

		
	public void clickTheAdminIcon()
	{
		admin.click();
	}
	public void clickTheLogOut()
	{
		logout.click();
		
	}
	
  public boolean isLoginPageVisible()
  {
	return login_screen.isDisplayed();
	  
  }
	
	
	
}
