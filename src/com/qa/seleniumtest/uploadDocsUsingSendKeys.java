package com.qa.seleniumtest;

import java.awt.AWTException;
import java.awt.Robot; //Java AWT (Abstract Window Toolkit) is an API to develop GUI or window-based applications in java
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class uploadDocsUsingSendKeys {

	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
			
		//For Upload docs if the Upload/Attach button is an "Input" tag type 
		//then one need to use the the sendkeys method just to pass the file to upload location string.
		
		
		System.setProperty("webdriver.gecko.driver", "D:\\me\\Study\\Selenium\\Downloads\\Browser_drivers\\Firefox\\geckodriver-v0.22.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		driver.get("https://cleartax.in/paytax/UploadForm16?ref=income-tax-efiling");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);		
		Thread.sleep(3000);
		
		String doclocation = "C:\\Users\\manoj.ghadei\\Documents\\Setup.pdf";
		//WebElement.SendKeys() method to upload the document silently when the Upload/Attach element is an Input type
		driver.findElement(By.xpath("//input[@id='js-form16-upload-input']")).sendKeys(doclocation);
		driver.findElement(By.id("dateOfBirth")).sendKeys("10/10/2018");
		driver.findElement(By.name("submitButton")).click();
		Thread.sleep(2000);
		
		//Capture Screenshot
		File osnapshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String oLoc = "D:\\me\\Study\\Selenium\\Practice\\seleniumcodes";
		FileUtils.copyFile(osnapshot, new File(oLoc +"/screenshots/"+ System.currentTimeMillis() + ".png"));

		
		String txt = driver.findElement(By.xpath("//a[@class='ct-bold']")).getText();
		if (txt.equalsIgnoreCase("Try uploading again")) {
			System.out.println("The Document was uploaded successfully which made to navigate to the new page");			
		} else {
			String errmsg = driver.findElement(By.xpath("//span[contains(text(),'Please select a file to upload')]")).getText();
			System.out.println("Error message appeared for uploading file" + errmsg);

		}		
		
		driver.quit();

	}

}
