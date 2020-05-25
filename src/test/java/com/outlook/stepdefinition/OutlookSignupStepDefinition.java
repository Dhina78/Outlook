package com.outlook.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.outlook.basepage.OutlookBasePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
//import junit.framework.Assert;
import junit.framework.AssertionFailedError;

@RunWith(Cucumber.class)
public class OutlookSignupStepDefinition extends OutlookBasePage {
	//Variable declarations
	private String ExpectedMessage = null; //Expected Page Title
	OutlookBasePage BasePage = new OutlookBasePage(); //creating an object for class BasePage
	
	//Set ExpectedPageTitle
	public void setExpectedMessage(String PageTitle) {
		this.ExpectedMessage = PageTitle;
	}
	//getter to ExpectedPageTitle
	public String getExpectedMessage() {
		return ExpectedMessage;
	}
	
	@Given("User in HomePage")
	public void user_in_HomePage() {
		BasePage.OpenHomePage();
	    System.out.println("User in HomePage");
	}

    @When("^User click Create free account page$")
    public void user_click_create_free_account_page()  {
    	BasePage.goToSignupPage();
    	System.out.println("User click create free account page");
    }

    @Then("^User get Create a password message$")
    public void user_get_create_a_password_message() {
    	
    	try { //QUERY: only assertion should be in try catch ?
    		WebElement password = driver.findElement(By.id("PasswordTitle"));
    		password.click(); //QUERY: Without this, driver is referring previous page (returns previous page title)
    		String ActualMessage = driver.getTitle();
    		setExpectedMessage("Create a password");
			org.junit.Assert.assertEquals(ActualMessage, getExpectedMessage());
			System.out.println("Expected Page Title: " + getExpectedMessage() + " & Actual Page Title: " + ActualMessage );
			driver.quit();
		} catch (AssertionFailedError e) {
			org.junit.Assert.fail();
		}
    	driver.quit(); //QUERY: Do we need to quit here, irrespective of assertion result ?
    }

    @And("^In Create account page enter an (.+) in format$")
    public void in_create_account_page_enter_an_in_format(String emailid) {
    	WebElement membername = driver.findElement(By.id("MemberName"));
    	membername.click();
    	membername.clear();
    	membername.sendKeys(emailid);
    	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    	System.out.println("Enter an email ID  "+ emailid);
    }

    @And("^select Domain and click Next$")
    public void select_domain_and_click_next()  {
    	
    	//select domain from drop down
    		Select dropDomain = new Select(driver.findElement(By.id("LiveDomainBoxList")));
    		dropDomain.selectByValue("hotmail.com");
    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
    	//click "next" button
    	
    	driver.findElement(By.className("button-container")).click();
    	
    	//new Actions(driver).moveToElement(nextButton).click().perform();
    	//nextButton.submit();
    	
    	System.out.println("selected Domain and submitted Next");

    }
    @Then("^User expect (.+)$")
    public void user_expect(String errormessage) {
    	try { 
    		WebElement InvalidEmailErrorMessage = driver.findElement(By.id("MemberNameError"));
    		String ActualMessage = InvalidEmailErrorMessage.getText();
    		setExpectedMessage(errormessage);
    		//setExpectedMessage("This email is part of a reserved domain. Please enter a different email address.");
    		org.junit.Assert.assertEquals(ActualMessage, getExpectedMessage());
			System.out.println("Expected Error Message: " + getExpectedMessage() + " & Actual Error Message: " + ActualMessage );
			driver.quit();
		} catch (AssertionFailedError e) {
			org.junit.Assert.fail();
		}
    	driver.quit(); //QUERY: Do we need to quit here, irrespective of assertion result ?
    }
    
}
