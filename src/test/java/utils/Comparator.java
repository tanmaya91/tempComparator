package utils;

public class Comparator {
	
	public void compareTwoObjets(WeatherDetails obj1, WeatherDetails obj2, int variation) throws CustomException {
		if ((obj1.getTempDegrees()-obj2.getTempDegrees()<=2 && obj1.getTempDegrees()-obj2.getTempDegrees() >=-2) 
				|| obj1.getTempDegrees()-obj2.getTempDegrees()==0) {
			System.out.println("The temperature details match");
		}
		else
			throw new CustomException("unequal temperature: The temperature in ndtv does not match with openWeather API");
	}

}
