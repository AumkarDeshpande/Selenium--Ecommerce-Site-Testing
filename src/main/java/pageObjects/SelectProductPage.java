package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.DriverInitialize;

public class SelectProductPage extends DriverInitialize {
	
	public SelectProductPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	By product1 = By.xpath("//span[contains(text(),'Samsung Galaxy M51 (Electric Blue, 8GB RAM, 128GB ')]");
	
	By product2 = By.xpath("//span[contains(text(),'Samsung Galaxy M51 (Electric Blue, 6GB RAM, 128GB ')]");
	
	By product3 = By.xpath("//span[contains(text(),'Samsung Galaxy M31s (Mirage Black, 8GB RAM, 128GB ')]");
	
	
	public WebElement getProduct1() throws InterruptedException
	{
		explicitWait(product1);
		return driver.findElement(product1);
	}
	
	public WebElement getProduct2() throws InterruptedException
	{
		explicitWait(product2);
		return driver.findElement(product2);
	}
	
	public WebElement getProduct3() throws InterruptedException
	{
		explicitWait(product3);
		return driver.findElement(product3);
	}
	
	
}
