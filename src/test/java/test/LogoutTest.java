package test;

import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageobject.LoginPage;
import pageobject.LogoutPage;


public class LogoutTest extends Base {

	public WebDriver driver;
	WebDriverWait wait;
	 
	@Test
	public void loggingout() {
		 
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
     
     
	    wait =new WebDriverWait(driver,Duration.ofSeconds(3));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='https://static.uacdn.net/thumbnail/user/default.png']"))).click();	    
	    LogoutPage logoutpage= new LogoutPage(driver);
	    logoutpage.clickonlogoutbutton();
      
	       
	    Assert.assertTrue(driver.findElement(By.xpath("//button[@type='button']")).isDisplayed());
	}
	 
	
	@BeforeMethod
	  public void setup() throws IOException
	  {
		    driver = initializeBrowser();
	        driver.get(prop.getProperty("url"));
	        }
	  
	 
	  
	 @AfterMethod
     public void tearDown() 
	     {
		   driver.quit();
		   }

}