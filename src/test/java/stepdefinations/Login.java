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

public class Login extends Base {
	
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
	
	
	 @Given("^Open the application in any browser for login$")
	    public void open_the_application_in_any_browser_for_login()  {
    	
    	 driver.get(prop.getProperty("url"));
    }

    @When("^User enters valid credentials into the fields$")
    public void user_enters_valid_credentials_into_the_fields()  {
       
    	 driver.findElement(By.xpath("//input[@placeholder='Enter your mobile number']")).sendKeys(prop.getProperty("number"));
         
         wait =new WebDriverWait(driver,Duration.ofSeconds(3));
 	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=' css-1uhmx9i-StyledButton e1wp3nh0']"))).click();       
         Scanner scanner= new Scanner(System.in);
         System.out.println("Enter your OTP");
         String otp = scanner.nextLine();
         scanner.close();
         driver.findElement(By.xpath("//input[@placeholder='One time password']")).sendKeys(otp);
         
    }

    @When("^User enters invalid credentials into the fields$")
    public void user_enters_invalid_credentials_into_the_fields()  {
        
    	 wait =new WebDriverWait(driver,Duration.ofSeconds(3));
	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=' css-1uhmx9i-StyledButton e1wp3nh0']"))).click();       
         driver.findElement(By.xpath("//input[@placeholder='One time password']")).sendKeys(prop.getProperty("invalidotp"));

    }

    @Then("^Verify user is able to successfully Login$")
    public void verify_user_is_able_to_successfully_login()  {
        
    	wait =new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='https://static.uacdn.net/thumbnail/user/default.png']")));
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='https://static.uacdn.net/thumbnail/user/default.png']")).isDisplayed());
       
    }

    @Then("^Verify user login is unsuccessfull$")
    public void verify_user_login_is_unsuccessfull() {
    	
    	wait =new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@color='var(--color-i-red)']")));
        Assert.assertTrue(driver.findElement(By.xpath("//p[@color='var(--color-i-red)']")).getText().contains("This OTP is not valid"));
      
        
    }

    @And("^Navigate to login page for login$")
    public void navigate_to_login_page_for_login() {
    	 loginpage= new LoginPage(driver);
         loginpage.clickonLoginButton();
    }

    @And("^User clicks on login button$")
    public void user_clicks_on_login_button() {
    	 
    	 wait =new WebDriverWait(driver,Duration.ofSeconds(3));
  	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=' e8butdu9 css-1yl7b1d-StyledButton-Verify e1wp3nh0']"))).click();
       
    }
    
    
     @And("^User click on Login button$")
     public void user_click_on_login_button()  {
        
    	 wait =new WebDriverWait(driver,Duration.ofSeconds(3));
 	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=' e8butdu9 css-1yl7b1d-StyledButton-Verify e1wp3nh0']"))).click();
      
    }

}