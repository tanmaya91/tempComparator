package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import uiTests.BaseClass;

public class NDTvHomePage extends BaseClass{

	public NDTvHomePage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="h_sub_menu")
	public WebElement menuButton;
}
