package testscript;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
	WebDriver driver;
	 @BeforeMethod
			public void initaialBrowser()
			{
		 driver=new ChromeDriver();
		 driver.get("https://groceryapp.uniqassosiates.com/admin");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  //implicit wait
		 driver.manage().window().maximize();
		 
	 }
	
	//@AfterMethod
 public void QuitandClose()
	 {
		//driver.close();
		driver.quit();
	}
	
	
}
