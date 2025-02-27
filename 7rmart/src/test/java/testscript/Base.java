package testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constants;
import utility.ScreenShotUtility;
import utility.WaitUtility;


public class Base{
	WebDriver driver;
	 public Properties properties;
	 FileInputStream fileinputstream;
	ScreenShotUtility scrshot;
	 @BeforeMethod(alwaysRun =true)
	 @Parameters("browser")
			public void initaialBrowser(String browser) throws Exception 
			{
			 try {
				 properties =new Properties();
				 fileinputstream=new FileInputStream(Constants.CONFIGFILE);
				 properties.load(fileinputstream);
				 
			 }
				 catch(Exception e){ 
					  
					 System.out.println("invalid program");
					 
				 
			 }
		 if(browser.equalsIgnoreCase("chrome")) {
			 driver =new ChromeDriver(); 
		 }
		 else if(browser.equalsIgnoreCase("edge")) {
			 driver =new EdgeDriver(); 	 
		 }
			 
		 else
		 {
			throw new Exception("Browser is not correct") ;
		 }
		 
		// driver=new ChromeDriver();
			
		 //driver.get("https://groceryapp.uniqassosiates.com/admin");
		 driver.get(properties.getProperty("url"));
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICITWAIT));
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  //implicit wait
		 driver.manage().window().maximize();
	 }
	
	@AfterMethod
	 public void browserQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus()== ITestResult.FAILURE) {
			scrshot = new ScreenShotUtility();
			scrshot.getScreenShot(driver, iTestResult.getName());
		}
		//driver.close();
		driver.quit();
	}
}
