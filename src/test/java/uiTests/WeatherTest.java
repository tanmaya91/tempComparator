package uiTests;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WeatherTest extends BaseClass {
	

	@Test (priority=0)
	public void navigateToWeatherPage() {
//		WebDriverManager.chromedriver().setup();
//		driver= new ChromeDriver();
		
		driver.get("https://www.ndtv.com/");
		driver.manage().window().maximize();
		
		//find weather button and click
		WebElement menuButton = driver.findElement(By.id("h_sub_menu"));
		menuButton.click();
		
		//Click on weather button
		WebElement weatherButton = driver.findElement(By.linkText("WEATHER"));
		weatherButton.click();
		
		
		
	}
	
	@Test(priority=1)
	public void pinCityInWeatherPageTest() {
		findCityWeather("bhubaneswar");
	}
	
	public void findCityWeather(String cityName) {
	//	WebElement citySearchBox = driver.findElement(By.id("searchBox"));
		WebElement citySearchBox=driver.findElement(By.xpath("//input[@id='searchBox']"));
		citySearchBox.click();
		citySearchBox.sendKeys(cityName);
		citySearchBox.submit();
		
		
	}

}
