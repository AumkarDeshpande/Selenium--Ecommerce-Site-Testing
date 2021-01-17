package AmazonSiteTesting;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import resources.DriverInitialize;

public class ScreenShot extends DriverInitialize {
	
	public WebDriver driver;
	
	
	public void takeFailureScreenShot(String testMethodName , WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationPath = System.getProperty("user.dir") + "\\reports\\failure\\" + testMethodName + ".png";
		FileUtils.copyFile(source, new File(destinationPath));
	}
	
	public void takeSkippedScreenShot(String testMethodName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationPath = System.getProperty("user.dir") + "\\reports\\skipped\\" + testMethodName + ".png";
		FileUtils.copyFile(source, new File(destinationPath));
	}
	
	public void takeSuccessScreenShot(String testMethodName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationPath = System.getProperty("user.dir") + "\\reports\\success\\" + testMethodName + ".png";
		FileUtils.copyFile(source, new File(destinationPath));
		
	}


}
