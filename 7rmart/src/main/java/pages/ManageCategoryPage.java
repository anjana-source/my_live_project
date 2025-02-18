package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageCategoryPage {
		WebDriver driver;

		public ManageCategoryPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")
		private WebElement managecategory;
	//	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/category/delete?del=1074&page_ad=1' and @role='button']")
		
		@FindBy(xpath = "//a[@class='btn btn-sm btn btn-danger btncss' and  @href='https://groceryapp.uniqassosiates.com/admin/category/delete?del=1066&page_ad=1']")
		private WebElement deletebutton;
		@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
		private WebElement alertbox;

		public void clickTheManageCategoryMoreInfo() {
			managecategory.click();
		}

		public void clickThedeleteButton() {
			deletebutton.click();
		}
		public boolean isAlertDisplayed() {
			return alertbox.isDisplayed();
		}
}