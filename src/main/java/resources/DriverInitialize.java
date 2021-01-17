package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverInitialize {

	public static  WebDriver driver;
	public Properties prop;
	public String parent;
	
	public WebDriver initializeDriver() throws IOException
	{
		//public static void main(String[] args) throws IOException
		prop =new Properties();
		FileInputStream fis= new FileInputStream("F:\\Eclipse -Photon\\Amazon_Testing\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		String browserName = prop.getProperty("Browser_Name");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "F:\\Eclipse -Photon\\.ChromeDriver\\chromedriver.exe");  
		   driver=new ChromeDriver();  
		    //driver.navigate().to("http://www.google.co.in");  
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			//firefox
			
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			//code
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	public static void explicitWait(By locator)
	{
		WebDriver driver =getDriver();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static void implicitWait()
	{
		WebDriver driver =getDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
