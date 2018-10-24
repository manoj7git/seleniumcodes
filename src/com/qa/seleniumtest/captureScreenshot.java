package com.qa.seleniumtest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class captureScreenshot {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.gecko.driver", "D:\\me\\Study\\Selenium\\Downloads\\Browser_drivers\\Firefox\\geckodriver-v0.22.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		driver.get("https://cleartax.in/paytax/UploadForm16?ref=income-tax-efiling");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);		
		Thread.sleep(3000);

		//Capture Screenshot
		File osnapshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String oLoc = "C:\\Users\\manoj.ghadei\\Documents";
		FileUtils.copyFile(osnapshot, new File(oLoc +"/screenshots/"+ System.currentTimeMillis() + ".png"));
				
		driver.quit();

	}

}
