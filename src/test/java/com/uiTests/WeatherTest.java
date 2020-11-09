package com.uiTests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.pages.NDTvHomePage;
import com.pages.WeatherPage;
import com.utils.BaseClass;
import com.utils.CoreUtils;
import com.utils.WeatherDetails;

public class WeatherTest extends NDTVBaseTest {

	int tempInDegree;
	public static WeatherDetails weatherDetailsFromUI;
	//WeatherPage weatherPage = new WeatherPage();
	public static Properties prop;
	public static String city;

	@Test(priority = 0)
	public void navigateToWeatherPageTest() throws IOException  {

		prop = CoreUtils.loadPropertiesFromDataFile();
		city = prop.getProperty("city");

		driver.get(url);
		driver.manage().window().maximize();

		// Navigate to weather page
		NDTvHomePage homepage = new NDTvHomePage();
		homepage.menuButton.click();
		homepage.weatherMenuButton.click();
	}

	@Test(priority = 1)
	public void pinCityInWeatherPageTest() {
		findCityWeather(city);
		selectCityOnPinMyCitySearchBox(city);
		validateSelectedCityPresentInMap(city);

	}

	@Test(priority = 2)
	public void validateSelectingCityOnMapRevealsTempDetailstest() {
		selectCityOnMap(city);
	}

	@Test(priority = 3)
	public void getTemparatureDetailsOfCityTest() {
		tempInDegree = getTemparatureInDegree(city);
		System.out.println("temp of city in degress is :" + tempInDegree);
		
		//storing in weather details object
		weatherDetailsFromUI = new WeatherDetails();
		weatherDetailsFromUI.setTempDegrees(tempInDegree);
		System.out.println("The temperature of the city "+city+ "in weatherpage is "+weatherDetailsFromUI.getTempDegrees());

	}

	
}
