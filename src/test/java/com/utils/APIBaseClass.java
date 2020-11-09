package com.utils;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import com.apiTests.WeatherApiResponsePOJO;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIBaseClass {
	
	public static Properties prop;
	public static String city;
	

	public RequestSpecification request=RestAssured.given();
	
	public Response runAPI(String url,  Map<String, Object> header, Map<String, Object> params) throws IOException {
		
		
		//RequestSpecification request=RestAssured.given();
		
		if(null!=params){
			for (Map.Entry<String, Object> element : params.entrySet()) {
		         System.out.print("Param: Key is: "+ element.getKey() + " & Value is: "+ element.getValue() +"\n");
		         request.queryParams( element.getKey(), element.getValue());	
			}
		}
		
		if(null!=header){
			for (Map.Entry<String, Object> element : header.entrySet()) {
		         System.out.print("Header: Key is: "+ element.getKey() + " & Value is: "+ element.getValue() +"\n");
		         request.header( element.getKey(), element.getValue());	
			}
		}
		Response response = request
				.when()
				.get(url);
		return response;
				
	}
	
	public WeatherApiResponsePOJO getWeatherResponse(String url, Map<String, Object> headers, Map<String, Object> queryParams) throws IOException {
		
		Response response = null;
		WeatherApiResponsePOJO weatherResponse = new WeatherApiResponsePOJO();
		
		response= runAPI(url, headers, queryParams);
		response.then().statusCode(200);
		weatherResponse.setResponse(response);
		
		return weatherResponse;
	}
	
}
