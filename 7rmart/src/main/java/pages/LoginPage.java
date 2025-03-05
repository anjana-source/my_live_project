package pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.WaitUtility;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// @FindBy(xpath="//input[@type='text']")private WebElement usernameField;
	// @FindBy(xpath="//input[@name='password']")private WebElement password;
	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernameField;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submit;
	@FindBy(xpath = "//p[text()='Dashboard']")
	private WebElement dashboard;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alertbox;

	public LoginPage enterUserName(String username) {
		usernameField.sendKeys(username);
		return this;
	}

	public LoginPage enterPassword(String passwordvalue) {
		password.sendKeys(passwordvalue);
		return this;

	}
	public LogOutPage clickOnSignInButton() {
		/* //explicit
		
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //explicit
		 explicit wait wait.until(ExpectedConditions.elementToBeClickable(submit));
		  submit.click();
		 */
		/*
		 * Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
		 * .withTimeout(Duration.ofSeconds(30)) .pollingEvery(Duration.ofSeconds(5))
		 * .ignoring(NoSuchElementException.class);
		 * fluentWait.until(ExpectedConditions.elementToBeClickable(submit));
		 * submit.click();
		 */

		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForClick(driver, submit);
		submit.click();
		return new LogOutPage(driver) ;
		
	}

	public boolean isDashbordLoaded() {
		return dashboard.isDisplayed();

	}

	public boolean isAlertDisplayed() {
		return alertbox.isDisplayed();

	}
}
