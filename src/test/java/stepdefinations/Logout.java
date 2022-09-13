package stepdefinations;

import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
import pageobject.LogoutPage;

public class Logout extends Base {
	
	WebDriver driver;
	WebDriverWait wait;
	LoginPage loginpage;
	LogoutPage logoutpage;
    
	 @BeforeMethod
	  public void setup() throws IOException 
	  {
		    driver = initializeBrowser();
	  }
	 
	@AfterMethod
	  public void tearDown() {
			driver.quit();
	}
	
	
	    @Given("^that user have loggedin to the unacademy page$")
	    public void that_user_have_loggedin_to_the_unacademy_page()  {
	        
		 LoginPage loginpage= new LoginPage(driver);
	     loginpage.clickonLoginButton();
	        
	     driver.findElement(By.xpath("//input[@placeholder='Enter your mobile number']")).sendKeys(prop.getProperty("number"));
          
	     wait =new WebDriverWait(driver,Duration.ofSeconds(3));
	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=' css-1uhmx9i-StyledButton e1wp3nh0']"))).click();       
        
        
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter your OTP");
        String otp = scanner.nextLine();
        scanner.close();
        driver.findElement(By.xpath("//input[@placeholder='One time password']")).sendKeys(otp);
        wait =new WebDriverWait(driver,Duration.ofSeconds(3));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=' e8butdu9 css-1yl7b1d-StyledButton-Verify e1wp3nh0']"))).click();
     
	    }

	    @When("^user navigates to the Myicon page$")
	    public void user_navigates_to_the_myicon_page()  {
	    
	    wait =new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='https://static.uacdn.net/thumbnail/user/default.png']"))).click();	    
	    	
	    }

	    @Then("^verify user is able to logout of the application$")
	    public void verify_user_is_able_to_logout_of_the_application() {
	    
		Assert.assertTrue(driver.findElement(By.xpath("//button[@type='button']")).isDisplayed());

	    	
	    }

	    @And("^clicks on Logout button$")
	    public void clicks_on_logout_button()  {
	    
	    LogoutPage logoutpage= new LogoutPage(driver);
	    logoutpage.clickonlogoutbutton();	
	    }

	}
