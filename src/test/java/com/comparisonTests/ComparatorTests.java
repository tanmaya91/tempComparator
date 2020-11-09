package com.comparisonTests;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import com.apiTests.WeatherAPITest;
import com.uiTests.WeatherTest;
import com.utils.Comparator;
import com.utils.CoreUtils;
import com.utils.CustomException;

public class ComparatorTests {
	Comparator comparator = new Comparator();
	public static Properties prop;
	public static int variation;
	
	@Test(dependsOnMethods = {"com.uiTests.WeatherTest.getTemparatureDetailsOfCityTest", "com.apiTests.WeatherAPITest.getWeatherByCityTest" } )
	public void compareUiAndApiTemperatureTest() throws IOException, CustomException {
		prop = CoreUtils.loadPropertiesFromDataFile();
		variation=Integer.parseInt(prop.getProperty("variation"));
		comparator.compareTwoObjets(WeatherTest.weatherDetailsFromUI, WeatherAPITest.weatherDetailsFromAPI, variation);
	}

}
