package Greenmouse.DONandChyke;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class adminAddUsers extends reusables {
	WebDriver driver;
	reusables invoke = new reusables();
	
	@Test
	public void adminActivity() throws InterruptedException {
		
		invoke.init();
		invoke.launchAdmin();
		invoke.adminLogin();
		invoke.addManager();
		invoke.addAsstManager();
		invoke.addAccountant();

	}
	
	 public void captureScreenshot(String testName) {
	        // Capture screenshot and save it to a file
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
			File destination = new File("/Users/user/eclipse-workspace/DONandChyke/reports" + testName + ".png");

	        try {
	            FileUtils.copyFile(source, destination);
	            System.out.println("Screenshot taken: " + destination.getAbsolutePath());
	        } catch (IOException e) {
	            System.err.println("Failed to capture screenshot: " + e.getMessage());
	        }
	    }
	

	 @AfterMethod
	    public void tearDown(ITestResult result) {
	        // Check if the test failed
	        if (result.getStatus() == ITestResult.FAILURE) {
	            captureScreenshot(result.getName());
	        }

	        // Close the WebDriver instance
	        driver.quit();
	        driver.close(); //close browser
	    }

	   
	
}
