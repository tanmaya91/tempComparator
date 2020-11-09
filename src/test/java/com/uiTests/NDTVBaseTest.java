package com.uiTests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pages.WeatherPage;
import com.utils.BaseClass;

public class NDTVBaseTest extends BaseClass{
	
	public static WeatherPage weatherPage;
	
	public int getTemparatureInDegree(String city) {
		int temp= Integer.parseInt(weatherPage.tempInDegreeText.getText().substring(17));
		return temp;
	}
	
	public void selectCityOnMap(String city) {
		ArrayList<WebElement> cityOnMapList=(ArrayList<WebElement>) driver.findElements(By.xpath("//div[@class='cityText']"));
		
		weatherPage= new WeatherPage();
		for (WebElement e: cityOnMapList) {
			
			if(e.getText().equalsIgnoreCase(city)) {
				e.click();
			}
		}
		
		if(driver.findElements(By.xpath("//div[@class='leaflet-popup-content']")).size() != 0){
			System.out.println("The city "+city+" is availale on the map");
			System.out.println("Weather details of city is revealed by popup");
			if (weatherPage.cityTextOnWeatherDetailsPopup.getText().contains(city)) 	
				System.out.println(city+"'s weather details is displayed");	
			
			}
		else{
			
			System.out.println("Weather details popup of the city "+city+" is not avaialble");
			Assert.fail("Weather details is not displayed");
			}

	}
	
	public void findCityWeather(String cityName) {	
		//Wait for page load complete
		waitForPageLoad(20);			
		
		WeatherPage weatherPage= new WeatherPage();
		weatherPage.citySearchBox.click();
		weatherPage.citySearchBox.sendKeys(cityName);	
	}
	
	public void selectCityOnPinMyCitySearchBox(String cityName){

		WebElement selectCityCheckbox = driver.findElement(By.id(cityName));
	/*
	 * weatherPage= new WeatherPage(); weatherPage.
	 */
		selectCityCheckbox.click();
	}
	
	public void waitForPageLoad(int timeSeconds) {
		WebDriverWait wait= new WebDriverWait(driver, timeSeconds);
		wait.until((ExpectedCondition<Boolean>) driver ->
		   ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
	}
	
	public boolean validateSelectedCityPresentInMap(String city) {
		int flag =0;
		ArrayList<WebElement> cityOnMapList=(ArrayList<WebElement>) driver.findElements(By.xpath("//div[@class='cityText']"));
		for (WebElement e: cityOnMapList) {
			
			if(e.getText().equalsIgnoreCase(city)) {
			System.out.println("the city is present in the map");
			flag=1;
			break;
			}

		}
		if (flag==1)
			return true;
		else {
			Assert.fail("The city "+city+" is not present on map");
		}
			return false;
	}
	

}
