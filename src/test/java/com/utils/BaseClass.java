package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	public static String url;
	public static String browser;
	public static String city;
	@BeforeSuite
	public void setup() throws IOException {

		prop = CoreUtils.loadPropertiesFromDataFile();
		url= prop.getProperty("url");
		city = prop.getProperty("city");

		// initializing browser
		browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(ops);
		}

		else if (browser.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.get(url);
	}

	
	  @AfterSuite 
	  public void teardown() 
	  	{ 
		  driver.close(); 
	  	}
	 

}
