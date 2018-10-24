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

public class uploadDocsUsingRobotclass {

	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
			
		//For Upload docs if the Upload/Attach button is not an "Input" tag type 
		//then one need to use the Robot class in order to simulate the Keyboard methods and
		//handle file explorer (non web app.) to upload docs.
		
		
		System.setProperty("webdriver.gecko.driver", "D:\\me\\Study\\Selenium\\Downloads\\Browser_drivers\\Firefox\\geckodriver-v0.22.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		driver.get("https://www.medplusmart.com/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@title='File Upload']")).click();
		//driver.findElement(By.linkText("Upload your Prescription")).click();
		
		Thread.sleep(3000);
		WebElement UploadPresc = driver.findElement(By.xpath("//div[@id='uploadPrescriptionModelSec']//h3[@class='color-dred margin-t-none margin-b-20 hidden-xs'][contains(text(),'Upload Prescription')]"));
		String text = UploadPresc.getText();
		System.out.println(text);
		
		driver.findElement(By.xpath("//div[@id='uploadPrescriptionModelSec']//span[contains(text(),'Choose File')]")).click();
		Thread.sleep(2000);
			
		
		//Accessing the Robot class in order to replicate Keyboard access
		Robot rbt = new Robot();
		rbt.setAutoDelay(2000);  //Similar to Thread.sleep
		
		
		//StringSelection class has been used to store the doc location string
		StringSelection str = new StringSelection("C:\\Users\\manoj.ghadei\\Desktop\\git.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null); //This statement says the above location string is moved to the clipboard.
		rbt.setAutoDelay(1000);
		
		rbt.keyPress(KeyEvent.VK_CONTROL); //This KeyPress simulates Keyboard Press Ctrl+V action
		rbt.keyPress(KeyEvent.VK_V);
		
		rbt.keyRelease(KeyEvent.VK_CONTROL); //This KeyRelease simulates lifting release mouse pointer
		rbt.keyRelease(KeyEvent.VK_V);
		rbt.setAutoDelay(1000);
		
		rbt.keyPress(KeyEvent.VK_ENTER);
		rbt.keyRelease(KeyEvent.VK_ENTER);		
		
		
		String text1 = driver.findElement(By.xpath("//div[@id='uploadPrescriptionModelSec']//button[@type='button'][contains(text(),'Submit')]")).getText();
		System.out.println(text1);
		
		driver.findElement(By.xpath("//div[@id='uploadPrescriptionModelSec']//i[@class='closeModal hide-prescriptionblock']")).click();
		
		//Capture Screenshot
		File osnapshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String oLoc = "D:\\me\\Study\\Selenium\\Practice\\seleniumcodes";
		FileUtils.copyFile(osnapshot, new File(oLoc +"/screenshots/"+ System.currentTimeMillis() + ".png"));
		

		driver.quit();

	}

}
