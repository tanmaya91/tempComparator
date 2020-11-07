package apiTests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.WeatherDetails;

public class WeatherAPITest extends APIBaseTest{
	public static String baseUrl="https://api.openweathermap.org/data/2.5/weather";
	public static Map<String, Object> queryParams = null;
	WeatherDetails weatherDetailsFromAPI = new WeatherDetails();

	@Test
	public void getWeatherByCityTest() {
		
		queryParams = new HashMap<String, Object>();
		queryParams.put("q", "Bhubaneswar");
		queryParams.put("appid", "7fe67bf08c80ded756e598d6f8fedaea");
		queryParams.put("units", "metric");
		
		
		WeatherApiResponse weatherResponse= getWeatherResponse(baseUrl, null, queryParams);
		Main mainObj=new Main();
		
		System.out.println(weatherResponse);
		System.out.println(weatherResponse.getResponse().asString());
		JsonPath jsonPathWeatherResponse= new JsonPath(weatherResponse.getResponse().asString());
		
		JsonPath main= jsonPathWeatherResponse.get("main");
		JsonPath coord = jsonPathWeatherResponse.get("coord");
		JsonPath weather = jsonPathWeatherResponse.get("weather");
		JsonPath wind = jsonPathWeatherResponse.get("wind");
		
		JsonPath sys = jsonPathWeatherResponse.get("sys");
		System.out.println(jsonPathWeatherResponse.getString("name"));
		System.out.println(jsonPathWeatherResponse.getString("main.temp"));
		int tempInDegrees= Integer.parseInt(jsonPathWeatherResponse.getString("main.temp"));
		weatherDetailsFromAPI.setTempDegrees(tempInDegrees);
		
		
		/*
		 * RequestSpecification request= RestAssured.given(); request.queryParam("q",
		 * "Bhubaneswar"); request.queryParam("appid",
		 * "7fe67bf08c80ded756e598d6f8fedaea"); request.queryParam("units", "metric");
		 * Response response = request .when() .get(baseUrl);
		 */
		
		 
	}

	private WeatherApiResponse getWeatherResponse(String url, Map<String, Object> headers, Map<String, Object> queryParams) {
		
		Response response = null;
		WeatherApiResponse weatherResponse = new WeatherApiResponse();
		
		response= runAPI(url, headers, queryParams);
		weatherResponse.setResponse(response);
		
		return weatherResponse;
	}
	

}
