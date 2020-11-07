package uiTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	
	 @BeforeSuite
	    public void setup() {
		 ChromeOptions ops = new ChromeOptions();
         ops.addArguments("--disable-notifications");
		 WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver(ops);
			
			driver.get("https://www.ndtv.com/");
	 }
	
	
		/*
		 * @AfterSuite public void teardown() { driver.close(); }
		 */

}
