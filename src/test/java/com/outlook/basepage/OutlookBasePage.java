package com.outlook.basepage;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OutlookBasePage {
	
	final String AppURL = "https://outlook.live.com/owa/";
	public static WebDriver driver;
	
	private static void setChromeDriverProperty(){
		System.setProperty("webdriver.chrome.driver", "C:\\DRIVERS\\chromedriver.exe");
	}
	
    /**
     * Method to open outlook home page
     *	
	*/
	public void OpenHomePage() {
		//To confirm this method (OpenHomePage) is invoked
		System.out.println("Iam in goToHomePage method");
		
		//to set property for chromedriver.exe by calling setChromeDriverProperty
		setChromeDriverProperty();
		
		//Opening Chrome with options (disable infobars, start-maximized , diable chrome extensions)
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false); //disables the driver to install other chrome extensions
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation")); //alternative to disable infobars
		options.addArguments("start-maximized"); // start maximised
		
		//Initialise  webdriver driver 
		driver = new ChromeDriver(options);
		driver.get(AppURL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
		//QUERY: Do I need to validate HomePage title to ensure this method works correctly ??
	}
	public void goToSignupPage() {
		System.out.println("Iam in goTosignupPage method");
		//driver.findElement(By.xpath("//a[contains(text(),'Create free account')]")).click(); 
		//driver.findElement(By.linkText("Create free account")).submit();
		//driver.findElement(By.partialLinkText("Create free account")).submit();
		//driver.findElement(By.cssSelector("a# SIGNUP")).click();
		//driver.findElement(By.xpath("//span[contains(text(), 'Create free account')]")).click(); 
		//driver.findElement(By.name("Create free account")).click();
		driver.findElement(By.className("action-wrapper")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
	}
}
