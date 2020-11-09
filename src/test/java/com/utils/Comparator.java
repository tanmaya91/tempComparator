package com.utils;

public class Comparator {
	
	public void compareTwoObjets(WeatherDetails obj1, WeatherDetails obj2, int variation) throws CustomException {
		
		if ((obj1.getTempDegrees()-obj2.getTempDegrees()<=variation && obj1.getTempDegrees()-obj2.getTempDegrees() >=-variation) 
				|| obj1.getTempDegrees()-obj2.getTempDegrees()==0) {
			System.out.println("The temperature details match");
		}
		else {
			System.out.println("the temperature diference is more than "+variation+"degree celcius");
			System.out.println("The temperature difference is "+(obj1.getTempDegrees()-obj2.getTempDegrees()));
			throw new CustomException("unequal temperature: The temperature in ndtv does not match with openWeather API");
		}
	}

}
