package AmazonSiteTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import pageObjects.WindowHandlePage;
import resources.DriverInitialize;
import resources.ExcelSheet;
import pageObjects.CartPage;
import pageObjects.FilterPage;
import pageObjects.SearchPage;
import pageObjects.SelectProductPage;
import pageObjects.WindowHandlePage;

public class AmazonTest extends DriverInitialize {
	
	public static Logger log = LogManager.getLogger(AmazonTest.class.getName());
	
	
	ArrayList<String> data;
	
	
	@BeforeTest
	public void getExcel() throws IOException {
		ExcelSheet d =new ExcelSheet();
		data = d.getData();
	}
	
	
	@Test
	public void homePageNavigation() throws IOException
	{
		driver =initializeDriver();
		log.info("Driver is initialized");
		
		//String urlName = prop.getProperty("url");
		String urlName=data.get(1);
		driver.get(urlName);
		log.info("Navigated to Site");
		
		driver.manage().window().maximize();
		log.info("Window is maximized");
	}
	
	@Test(dependsOnMethods= {"homePageNavigation"})
	public void search()
	{
		SearchPage search = new SearchPage(driver);
		
		
		search.searchText().sendKeys(data.get(2));
		//search.searchText().sendKeys("mobile");
		log.info("Mobile text is sent into search bar");
		
		search.searchButton().click();
		log.info("Search button is clicked");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(dependsOnMethods= {"search"})
	public void filter() throws InterruptedException
	{
		FilterPage filter = new FilterPage(driver);
		filter.getAmazonPrime().click();
		log.info("prime filter button is clicked");
		
		filter.getSamsungMobile().click();
		log.info("Samsung mobile fitter is clicked");
		
		filter.getPriceRange().click();
		log.info("Price filter is clicked");
		
		filter.getPayOnDelivery().click();
		log.info("Pay on delivery filter is clicked");
		
	}
	
	@Test(dependsOnMethods= {"filter"})
	public void selectProduct() throws InterruptedException
	{
		SelectProductPage select = new SelectProductPage(driver);
		select.getProduct1().click();
		log.info("Clicked on first product");
		
		select.getProduct2().click();
		log.info("Clicked on second product");
		
		select.getProduct3().click();
		log.info("Clicked on third product");
	}
	
	@Test(dependsOnMethods= {"selectProduct"})
	public void addToCart() throws InterruptedException {	
		WindowHandlePage w = new WindowHandlePage(driver);
		w.getWindows();
		log.info("Products are added to cart");
	}
	
	@Test(dependsOnMethods= {"addToCart"})
	public void goToCart() throws Exception
	{
		CartPage cart = new CartPage(driver);
		cart.getGoToCart().click();
	}
	
	@AfterTest
	public void afterTest() throws InterruptedException {
		driver.quit();
	}
	

	
	
}
