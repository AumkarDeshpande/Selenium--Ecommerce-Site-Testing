package AmazonSiteTesting;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import AmazonSiteTesting.ScreenShot;
import resources.DriverInitialize;
import resources.ExtentReporterNG;

public class Listeners extends DriverInitialize implements ITestListener {

	public static Logger log = LogManager.getLogger(Listeners.class.getName());
	ExtentTest test;
	ExtentReports extent=ExtentReporterNG.getReportObject();
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String testMethodName =result.getMethod().getMethodName();
		
		System.out.println("Start of Test \t" +testMethodName);
		log.info("Start of Test \t" +testMethodName);
		
		test = extent.createTest(testMethodName+"\t Test");
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String testMethodName =result.getMethod().getMethodName();
		
		System.out.println("Success of Test \t" +testMethodName);
		log.info("Success of Test \t" +testMethodName);
		
		test.log(Status.PASS, "Test Passed");
		
		WebDriver diver=getDriver();
		 ScreenShot ss= new ScreenShot();
		 
		 try {
			ss.takeSuccessScreenShot(testMethodName, diver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 test.log(Status.PASS, result.getThrowable());
         test.log(Status.PASS, "Snapshot below: " + test.addScreenCaptureFromPath(System.getProperty("user.dir") + "\\reports\\success\\" + testMethodName + ".png"));
		  
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testMethodName =result.getMethod().getMethodName();
		
		System.out.println("Failure of Test \t" +testMethodName);
		log.info("Failure of Test \t" +testMethodName);
		
		test.fail(result.getThrowable());
		
		WebDriver diver=getDriver();
		 ScreenShot ss= new ScreenShot();
		 
		 try {
			ss.takeFailureScreenShot(testMethodName, diver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 test.log(Status.FAIL, result.getThrowable());
         test.log(Status.FAIL, "Snapshot below: " + test.addScreenCaptureFromPath(System.getProperty("user.dir") + "\\reports\\failure\\" + testMethodName + ".png"));
		
			
		 
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String testMethodName =result.getMethod().getMethodName();
		
		System.out.println("Skipped the Test \t" +testMethodName);
		log.info("Skipped the Test \t" +testMethodName);
		
		WebDriver diver=getDriver();
		 ScreenShot ss= new ScreenShot();
		 
		 try {
			ss.takeSkippedScreenShot(testMethodName, diver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 test.log(Status.SKIP, result.getThrowable());
         test.log(Status.SKIP, "Snapshot below: " + test.addScreenCaptureFromPath(System.getProperty("user.dir") + "\\reports\\skipped\\" + testMethodName + ".png"));
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}

	
}
