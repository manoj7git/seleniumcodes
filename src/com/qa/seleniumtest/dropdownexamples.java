package com.qa.seleniumtest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class dropdownexamples {
	
	static WebDriver driver;
	static String ExpStr;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "D:\\me\\Study\\Selenium\\Downloads\\Browser_drivers\\Firefox\\geckodriver-v0.22.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("https://www.carmax.com/cars");
		
		String AtcualPagetitle = driver.getTitle(); //fetch the Page title				
		ExpStr = "Used Cars for Sale - CarMax"; //Expected page title
		
		//Validating if landed to right page or not
		if (ExpStr.equalsIgnoreCase(AtcualPagetitle)) {
			System.out.println("************");
			System.out.println("Correct page is opened: " + AtcualPagetitle);			
			
		} else {
			System.out.println("************");
			System.out.println("FAILED: Incorrect page is opened" + AtcualPagetitle);			
		}
		
		Thread.sleep(2000);		//Force wait
		
		//Fetch all the Car Brand Names
		WebElement ddelemnt = driver.findElement(By.className("makeSelect"));		
		/*
		//Method 1: to get all the dropdown elements at one stretch
		ExpStr = ddelemnt.getText();
		System.out.println(ExpStr);
		*/
		
		//Method 2: Using Array List concept & .getOptions method 
		Select carbrand = new Select(ddelemnt);
		carbrand.selectByIndex(2); //method to select & set an particular item of the drop down list
		Thread.sleep(2000);
		System.out.println("************");
		System.out.println(carbrand.getFirstSelectedOption().getText());		
		
				
		List <WebElement> elementlist = carbrand.getOptions(); //This .getOptions() will create a collection.List of the webelements present in the dropdown list
		int elmntcount = elementlist.size(); //This .size() method fetches the # of element in the dropdownlist.
		System.out.println("************");
		System.out.println(elmntcount);
		
		System.out.println("Extract list items using For loop************");
		for (int i = 0; i < elmntcount; i++) {			
			System.out.println(elementlist.get(i).getText());						
		}
		
		System.out.println("Extract list items using Foreach loop************");
		for (WebElement option : elementlist) {			
			System.out.println(option.getText());
		}
		
		
		//Method to fetch the selected item text/string from the dropdown field:  .getFirstSelectedOption().getText()
		elementlist.get(5).click();
		System.out.println("************");
		System.out.println(carbrand.getFirstSelectedOption().getText());
		


		driver.quit();

	}


}
