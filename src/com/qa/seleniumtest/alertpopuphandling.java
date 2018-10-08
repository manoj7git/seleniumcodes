package com.qa.seleniumtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class alertpopuphandling {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "D:\\me\\Study\\Selenium\\Downloads\\Browser_drivers\\Firefox\\geckodriver-v0.22.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.name("proceed")).click();
		
		Thread.sleep(5000);
		
		Alert popup = driver.switchTo().alert();
		//Use the ".getText" method to fetch the text appearing on the popup.
		System.out.println(popup.getText());
		
		//Use "Accept" method to click the OK button of the javascript popup/alert 
		popup.accept();
		
		/*
		//Use "Dismiss" method to click the "CANCEL" button in the Alert/Popup
		popup.dismiss();
		*/
		
		driver.findElement(By.linkText("Home")).click();
		System.out.println(driver.getTitle());
		
		driver.quit();

	}

}
