package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.DriverInitialize;

public class SearchPage extends DriverInitialize {

	public SearchPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	By search = By.id("twotabsearchtextbox");
	
	By searchButton = By.cssSelector("input.nav-input[type=submit]");
	
	public WebElement searchText()
	{
		explicitWait(search);
		return driver.findElement(search);
	}
	
	public WebElement searchButton()
	{
		explicitWait(searchButton);
		return driver.findElement(searchButton);
	}
}
