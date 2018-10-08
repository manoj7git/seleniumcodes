package com.qa.seleniumtest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class iframehandling {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		Robot rbt = new Robot();
		
		System.setProperty("webdriver.gecko.driver", "D:\\me\\Study\\Selenium\\Downloads\\Browser_drivers\\Firefox\\geckodriver-v0.22.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		driver.get("https://www.medplusmart.com/pharmaHome");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Upload your Prescription")).click();
		
		Thread.sleep(3000);
		WebElement UploadPresc = driver.findElement(By.xpath("//div[@id='uploadPrescriptionModelSec']//h3[@class='color-dred margin-t-none margin-b-20 hidden-xs'][contains(text(),'Upload Prescription')]"));
		String text = UploadPresc.getText();
		System.out.println(text);
		
		driver.findElement(By.xpath("//div[@id='uploadPrescriptionModelSec']//span[contains(text(),'Choose File')]")).click();
		
		rbt.setAutoDelay(2000);
		
		StringSelection str = new StringSelection("C:\\Users\\manoj.ghadei\\Desktop\\git.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		rbt.setAutoDelay(1000);
		
		rbt.keyPress(KeyEvent.VK_CONTROL);
		rbt.keyPress(KeyEvent.VK_V);
		
		rbt.keyRelease(KeyEvent.VK_CONTROL);
		rbt.keyRelease(KeyEvent.VK_V);
		rbt.setAutoDelay(1000);
		
		rbt.keyPress(KeyEvent.VK_ENTER);
		rbt.keyRelease(KeyEvent.VK_ENTER);
		
		//driver.findElement(By.xpath("//div[@id='uploadPrescriptionModelSec']//span[contains(text(),'Choose File')]")).sendKeys("C:\\Users\\manoj.ghadei\\Desktop\\git.jpg");
		//Thread.sleep(3000);
		
		String text1 = driver.findElement(By.xpath("//div[@id='uploadPrescriptionModelSec']//button[@type='button'][contains(text(),'Submit')]")).getText();
		System.out.println(text1);
		
		//driver.findElement(By.xpath("//div[@id='uploadPrescriptionModelSec']//i[@class='closeModal hide-prescriptionblock']")).click();
		
		/*
		Alert popup = driver.switchTo().alert();
		//Use the ".getText" method to fetch the text appearing on the popup.
		System.out.println(popup.getText());
		
		//Use "Accept" method to click the OK button of the javascript popup/alert 
		popup.accept();
		
		
		//Use "Dismiss" method to click the "CANCEL" button in the Alert/Popup
		//popup.dismiss();
		
		
		driver.findElement(By.linkText("Home")).click();
		System.out.println(driver.getTitle());
		*/
		driver.quit();

	}

}
