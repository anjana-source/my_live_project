package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageProductPage {

	WebDriver driver;

	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product' and @class='small-box-footer']")
	private WebElement manage_product_info;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Product/delete?del=523&page_ad=1']")
	private WebElement deletebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertbox;

	public void clickTheManageProductMoreInfo() {
		manage_product_info.click();
	}

	public void clickThedeleteButton() {
		deletebutton.click();
		driver.switchTo().alert().accept();
	}

	public boolean isAlertDisplayed() {
		return alertbox.isDisplayed();
	}
}
