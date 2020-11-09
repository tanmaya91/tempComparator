package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.BaseClass;

public class NDTvHomePage extends BaseClass{

	public NDTvHomePage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="h_sub_menu")
	public WebElement menuButton;
	
	@FindBy(linkText="WEATHER")
	public WebElement weatherMenuButton;
}
