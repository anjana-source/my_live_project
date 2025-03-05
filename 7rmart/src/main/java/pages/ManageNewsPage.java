package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	WebDriver driver;

	public ManageNewsPage(WebDriver driver) // constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	private WebElement moreinfo;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newbutton;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement enternews;
	// @FindBy(xpath="//button[@type='submit']")private WebElement savebutton;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertbox;
/*
	public void clickTheManageNewsInfo() {
		moreinfo.click();
	}
	*/

	public ManageNewsPage clickTheManageNewsNewButton() {
		newbutton.click();
		return this;
	}

	public ManageNewsPage enterTheNews(String news) {
		enternews.sendKeys(news);
		return this;
	}

	public ManageNewsPage clickTheSaveButton() {
		savebutton.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alertbox.isDisplayed();
	}

}
