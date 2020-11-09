package com.pages;

import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.BaseClass;

public class WeatherPage extends BaseClass {

	public WeatherPage() {
		super();
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='searchBox']")
	public WebElement citySearchBox;

	@FindBy(xpath = "//input[@id='\"+cityName+\"']")
	public WebElement selectCityCheckbox;

	@FindBy(xpath = "//div[@class='leaflet-popup-content']//span[4]")
	public WebElement tempInDegreeText;

	@FindBy(xpath = "//div[@class='leaflet-popup-content']//span[2]")
	public WebElement cityTextOnWeatherDetailsPopup;

	
}
