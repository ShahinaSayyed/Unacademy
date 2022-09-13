package test;


import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.Base;
import pageobject.LoginPage;


public class SigninTest extends Base {
	
	public WebDriver driver;
	WebDriverWait wait;
	
	 @BeforeMethod
	 public void setup() throws IOException {
		   
	        driver = initializeBrowser();
	        driver.get(prop.getProperty("url"));
	        }
	 
	 
     @Test(priority=1)
	 public void signinwithexistingaccountcredentials(){
		 
		 LoginPage loginpage= new LoginPage(driver);
	     
		 loginpage.clickonLoginButton();
         loginpage.clickoncreateyouraccount();

     driver.findElement(By.xpath("//input[@placeholder='Enter your mobile number']")).sendKeys(prop.getProperty("number"));
     loginpage.clickonsignin();
     driver.findElement(By.xpath("//input[@placeholder='One time password']"));
    		
     Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='One time password']")).isDisplayed());
     }
     
	 
	 
	
	
	@Test(priority=2)
	 public void signinwithinvalidphonenumber() {
		
		 LoginPage loginpage= new LoginPage(driver);
	     loginpage.clickonLoginButton();
	        
		 
	     driver.findElement(By.xpath("//h6[@class='css-nmgvwj-H6-StyledH6 e1l7v5xe3']")).click();

	     driver.findElement(By.xpath("//input[@placeholder='Enter your mobile number']")).sendKeys(prop.getProperty("invalidnumber") );
	     Assert.assertTrue(driver.findElement(By.xpath("//button[@aria-label=\"Continue\"]")).isEnabled());	
	}
	
	 
	  
	  @AfterMethod
	  public void tearDown() {
			driver.quit();
	}
}