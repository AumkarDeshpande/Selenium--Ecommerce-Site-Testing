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

public class CartPage extends DriverInitialize {
	
	public CartPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	By goToCart = By.xpath("//span[@id='nav-cart-count']");
	
	public WebElement getGoToCart() throws InterruptedException
	{
		explicitWait(goToCart);
		return driver.findElement(goToCart);
	}
}
