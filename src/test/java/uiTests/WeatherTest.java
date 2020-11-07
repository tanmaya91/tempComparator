package uiTests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
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
		selectCityOnPinMyCitySearchBox("bhubaneswar");
		validateSelectedCityPresentInMap("Bhubaneswar");
		
		/*
		 * ArrayList<WebElement> list= (ArrayList<WebElement>)
		 * driver.findElements(By.xpath(
		 * "//div[@id='messages']//div[@class='message']//label")); for (WebElement e:
		 * list) { System.out.println(e.getAttribute("for")); }
		 */
	}
	
	@Test(priority = 2)
	public void validateSelectingCityOnMapRevealsTempDetailstest() {
		selectCityOnMap("Bhubaneswar");
	}
	
	public void selectCityOnMap(String city) {
		ArrayList<WebElement> cityOnMap=(ArrayList<WebElement>) driver.findElements(By.xpath("//div[@class='cityText']"));
		for (WebElement e: cityOnMap) {
			
			if(e.getText().equalsIgnoreCase(city)) {
				e.click();
			}
		}
		
		if(driver.findElements(By.xpath("//div[@class='leaflet-popup-content']")).size() != 0){
			System.out.println("Element1 is Present");
			System.out.println("Weather detaisl of city is revealed by popup");
			if (driver.findElement(By.xpath("//div[@class='leaflet-popup-content']//span[2]")).getText().contains(city)) {
				System.out.println(city+"'s weather details is displayed");
			 	}
			
			}
		else{
			System.out.println("Element1 is Absent");
			System.out.println("Weather details popup is not avaialbele");
			}
		
			/*
			 * if(driver.findElement(By.xpath("//div[@class='leaflet-popup-content']"))!=
			 * null){ System.out.println("Element is Present"); }else{
			 * System.out.println("Element is Absent"); }
			 */
	}
	
	public void findCityWeather(String cityName) {
	//	WebElement citySearchBox = driver.findElement(By.id("searchBox"));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//Wait for page load complete
		waitForPageLoad(10);
		
		/*
		 * boolean
		 * test=((JavascriptExecutor)driver).executeScript("return document.readyState"
		 * ); JavascriptExecutor js= (JavascriptExecutor) driver; WebDriverWait wait=
		 * new WebDriverWait(driver, 10);
		 * wait.ununtil(js.executeScript("return document.readyState").equals(true));
		 */
		
		
		
		WebElement citySearchBox=driver.findElement(By.xpath("//input[@id='searchBox']"));
		citySearchBox.click();
		citySearchBox.sendKeys(cityName);
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
		citySearchBox.sendKeys(" ");
		//citySearchBox.submit();
		
	}
	
	public void selectCityOnPinMyCitySearchBox(String cityName){
		WebElement selectCityCheckbox = driver.findElement(By.xpath("//input[@id='Bhubaneswar']"));
		selectCityCheckbox.click();
	}
	
	public void waitForPageLoad(int timeSeconds) {
		WebDriverWait wait= new WebDriverWait(driver, timeSeconds);
		wait.until((ExpectedCondition<Boolean>) driver ->
		   ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
	}
	
	public boolean validateSelectedCityPresentInMap(String city) {
		int flag =0;
		ArrayList<WebElement> list2=(ArrayList<WebElement>) driver.findElements(By.xpath("//div[@class='cityText']"));
		for (WebElement e: list2) {
			
			if(e.getText().equalsIgnoreCase(city)) {
			System.out.println("the city is present in the map");
			flag=1;
			break;
			}

		}
		if (flag==1)
			return true;
		else 
			return false;
	}
	
	
	

}
