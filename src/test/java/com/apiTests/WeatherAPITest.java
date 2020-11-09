package com.apiTests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;
import com.utils.APIBaseClass;
import com.utils.BaseClass;
import com.utils.CoreUtils;
import com.utils.WeatherDetails;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class WeatherAPITest extends APIBaseClass{
	
	public static Map<String, Object> queryParams = null;
	public static WeatherDetails weatherDetailsFromAPI = new WeatherDetails();
	public static String apiBaseUrl;
	public static Properties prop;
	public static String city;
	public static String appid;

	@Test (groups = {"apiTest"})
	public void getWeatherByCityTest() throws IOException {
		
		prop= CoreUtils.loadPropertiesFromDataFile();
		
		 city= prop.getProperty("city");
		 appid=prop.getProperty("appid");
		 apiBaseUrl=prop.getProperty("ApiBaseUrl");
		
		queryParams = new HashMap<String, Object>();
		queryParams.put("q", city);
		queryParams.put("appid", appid);
		queryParams.put("units", "metric");
		
		WeatherApiResponsePOJO weatherResponse= getWeatherResponse(apiBaseUrl, null, queryParams);
		System.out.println(weatherResponse.getResponse().asString());
		JsonPath jsonPathWeatherResponse= new JsonPath(weatherResponse.getResponse().asString());
		System.out.println("The city name is "+jsonPathWeatherResponse.getString("name"));
		System.out.println("The temp for city is "+jsonPathWeatherResponse.getString("main.temp")+" degree celcius");
		
		//storing in weather details object
		int tempInDegrees= Integer.parseInt(jsonPathWeatherResponse.getString("main.temp"));
		weatherDetailsFromAPI.setTempDegrees(tempInDegrees);
	}	

}
