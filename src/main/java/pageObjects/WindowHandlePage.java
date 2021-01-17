package pageObjects;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.DriverInitialize;

public class WindowHandlePage extends DriverInitialize{
	
	public WindowHandlePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	By addToCart = By.cssSelector("#add-to-cart-button");
	
	By closePopup = By.xpath("//a[@id='attach-close_sideSheet-link']");
	
	public void getWindows() throws InterruptedException {
		
		WebDriver driver = getDriver();
		String parent = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for(String child:allWindows) 
		{
			if(!parent.equals(child)) {
				driver.switchTo().window(child);
				explicitWait(addToCart);
				driver.findElement(By.cssSelector("#add-to-cart-button")).click();	
				driver.findElement(closePopup).click();
				driver.close();
				
			}
		}
		driver.switchTo().window(parent);
		implicitWait();
		driver.navigate().refresh();
	}	
	

}
