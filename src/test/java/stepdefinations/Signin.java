package stepdefinations;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.LoginPage;

public class Signin extends Base {
	
	WebDriver driver;
	WebDriverWait wait;
	LoginPage loginpage;
    
	@BeforeMethod
	  public void setup() throws IOException 
	  {
		    driver = initializeBrowser();
	  }
	 
	@AfterMethod
	  public void tearDown() {
			driver.quit();
	}
	 
    
	@Given("^Open the application in any browser for signin$")
	    public void open_the_application_in_any_browser_for_signin() {
	        
	    	driver.get(prop.getProperty("url"));
	    }
	   

	    @When("^User enters existing accound credentials$")
	    public void user_enters_existing_accound_credentials()  {
	        
	    	driver.findElement(By.xpath("//input[@placeholder='Enter your mobile number']")).sendKeys(prop.getProperty("number"));
	    	loginpage= new LoginPage(driver);
	        loginpage.clickonsignin();
	        driver.findElement(By.xpath("//input[@placeholder='One time password']"));
	       		
	    }

	    @When("^User enters invalid Phone Number as \"([^\"]*)\"$")
	    public void user_enters_invalid_phone_number_as_something(String strArg1) {
	        
		    driver.findElement(By.xpath("//input[@placeholder='Enter your mobile number']")).sendKeys(prop.getProperty("invalidnumber") );

	    }

	    @Then("^Verify user is not able to create new account with existing account credentials$")
	    public void verify_user_is_not_able_to_create_new_account_with_existing_account_credentials() {
	        
	        Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='One time password']")).isDisplayed());

	    }

	    @Then("^Verify user is not able to click on login button and create an account$")
	    public void verify_user_is_not_able_to_click_on_login_button_and_create_an_account()  {
		     
	    	Assert.assertTrue(driver.findElement(By.xpath("//button[@aria-label=\"Continue\"]")).isEnabled());	

	    }

	    @And("^Navigate to login page for signin$")
	    public void navigate_to_login_page_for_signin()  {
	        
	    	 loginpage= new LoginPage(driver);
		     loginpage.clickonLoginButton();
		        
	    }

	    @And("^User clicks on login button to signin$")
	    public void user_clicks_on_login_button_to_signin()  {
	       
	    	 loginpage= new LoginPage(driver);
	    	 loginpage.clickonsignin();
	    }

	
}