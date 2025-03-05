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
		
		@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")
		private WebElement adminmoreinfo;
		
		@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']")
		private WebElement managecontact;
		
		@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext'  and  @class='small-box-footer']")
		private WebElement managefooterext;
		
		@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
		private WebElement newsmoreinfo;
		
		@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product' and @class='small-box-footer']")
		private WebElement manage_product_info;
		
       @FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category' and @class='small-box-footer']")
         private WebElement subcatetorymoreinfo;
		
		
		
		public AdminUserPage clickTheAdminUserMoreInfo() {
			adminmoreinfo.click();
			return new AdminUserPage(driver) ;
		}
		public ManageContactPage clickTheManageContactMoreInfo()
		{
			managecontact.click();
			return new ManageContactPage(driver);
		}
		
		public ManageFooterPage clickTheManagefooterTextMoreInfo() {
			managefooterext.click();
			return new ManageFooterPage(driver);
		}
		
		public ManageNewsPage clickTheManageNewsInfo() {
			newsmoreinfo.click();
			return new ManageNewsPage(driver);
		}
		
		public ManageProductPage clickTheManageProductMoreInfo() {
			manage_product_info.click();
			return new ManageProductPage(driver);
		}
		
		public ManageSubCategoryPage clickTheSubCategoryMoreInfo() {
			subcatetorymoreinfo.click();
			return new ManageSubCategoryPage(driver);
		}

		
		
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
