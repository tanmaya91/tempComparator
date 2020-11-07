package apiTests;

import java.util.Map;
import java.util.Map.Entry;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIBaseTest {

	public RequestSpecification request=RestAssured.given();
	
	public Response runAPI(String url,  Map<String, Object> header, Map<String, Object> params) {
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
	
}
