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

public class FilterPage extends DriverInitialize{
	
	
	public FilterPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	By primeCheckBox = By.xpath("//li[@id='p_85/10440599031']/span/a/div/label/i");

	By samsungMobile = By.xpath("//li[@id='p_89/Samsung']/span/a/div/label/i");
	
	By priceRange = By.xpath("//li[@id='p_36/1318507031']/span/a");
	
	By payOnDelivery = By.xpath("//li[@id='p_n_is_cod_eligible/4931671031']/span/a/div/label/i");
	
	
	public WebElement getAmazonPrime() throws InterruptedException
	{
		explicitWait(primeCheckBox);
		return driver.findElement(primeCheckBox);
		
	}
	
	public WebElement getSamsungMobile() throws InterruptedException
	{
		explicitWait(samsungMobile);
		return driver.findElement(samsungMobile);
		
	}
	
	
	public WebElement getPriceRange() throws InterruptedException
	{
		explicitWait(priceRange);
		return driver.findElement(priceRange);
		
	}
	public WebElement getPayOnDelivery() throws InterruptedException
	{
		explicitWait(payOnDelivery);
		return driver.findElement(payOnDelivery);
		
	}
	
}
