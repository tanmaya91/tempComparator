package uiTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	
	 @BeforeSuite
	    public void setup() {
		 WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
	 }
	
	
		/*
		 * @AfterSuite public void teardown() { driver.close(); }
		 */

}
