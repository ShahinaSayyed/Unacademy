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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.Base;
import pageobject.LoginPage;

public class LogInTest extends Base {
    
	public WebDriver driver;
	WebDriverWait wait;
	
	@Test(priority=1)
	public void validcredentials() {

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
     
      
       wait =new WebDriverWait(driver,Duration.ofSeconds(5));
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='https://static.uacdn.net/thumbnail/user/default.png']")));
       Assert.assertTrue(driver.findElement(By.xpath("//img[@src='https://static.uacdn.net/thumbnail/user/default.png']")).isDisplayed());
      
      
	}
	
   
	@Test(priority=2)
	public void invalidcredentials( ) {
		
	    LoginPage loginpage= new LoginPage(driver);
	    loginpage.clickonLoginButton();
    	
        driver.findElement(By.xpath("//input[@placeholder='Enter your mobile number']")).sendKeys(prop.getProperty("number"));
      
        wait =new WebDriverWait(driver,Duration.ofSeconds(3));
	      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=' css-1uhmx9i-StyledButton e1wp3nh0']"))).click();       
      
       
        driver.findElement(By.xpath("//input[@placeholder='One time password']")).sendKeys(prop.getProperty("invalidotp"));

        
        
        wait =new WebDriverWait(driver,Duration.ofSeconds(3));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=' e8butdu9 css-1yl7b1d-StyledButton-Verify e1wp3nh0']"))).click();
     
     
      
        wait =new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@color='var(--color-i-red)']")));
        Assert.assertTrue(driver.findElement(By.xpath("//p[@color='var(--color-i-red)']")).getText().contains("This OTP is not valid"));
      
   	
	}
	
   /* @Test(invocationCount=3)
	public void unsuccessfulloginattempts() {
		
		
       driver.findElement(By.xpath("//button[@type='button']")).click();
        
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("create your account"))).click();;
       
        WebDriverWait wait1 =new WebDriverWait(driver,Duration.ofSeconds(3));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter your mobile number']"))).sendKeys("9325780164");
      
        driver.findElement(By.xpath("//button[@aria-label=\"Continue\"]")).click();
        
       
        wait =new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='One time password']"))).sendKeys("123456");
        driver.findElement(By.xpath("//button[@aria-label=\"Submit\"]")).click();
        
     
      
        wait =new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@color='var(--color-i-red)']")));
        Assert.assertTrue(driver.findElement(By.xpath("//p[@color='var(--color-i-red)']")).getText().contains("This OTP is not valid"));
		
        		
	}*/
	
	/*@Test
	 public void navigationfromloginpage() {
		
		 driver.findElement(By.xpath("//button[@type='button']")).click();
	        
	        wait =new WebDriverWait(driver,Duration.ofSeconds(3));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("create your account"))).click();;
	       
	        wait =new WebDriverWait(driver,Duration.ofSeconds(3));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter your mobile number']"))).sendKeys("9325780164");
	      
	        driver.findElement(By.xpath("//button[@aria-label=\"Continue\"]")).click();
	        
	        
	        
	        Scanner scanner= new Scanner(System.in);
	        System.out.println("Enter your OTP");
	        String otp = scanner.nextLine();
	        scanner.close();
	        driver.findElement(By.xpath("//input[@placeholder='One time password']")).sendKeys(otp);
	        driver.findElement(By.xpath("//button[@aria-label=\"Submit\"]")).click();
	        
	        Assert.assertTrue(driver.findElement(By.xpath("//button[@color='green']")).isDisplayed());
	        driver.findElement(By.xpath("//button[@color='green']")).click();
	        Assert.assertTrue(driver.findElement(By.xpath("//input[@autocomplete='off']")).isDisplayed());
	        driver.findElement(By.xpath("//input[@autocomplete='off']")).click();
	        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='css-1y3jqo4-Highlight egs83k421']")).isDisplayed());
	        driver.findElement(By.xpath("//span[@class='css-1y3jqo4-Highlight egs83k421']")).click();
	}*/
	
	
	
	
	
	
	
	
	  @BeforeMethod
	  public void setup() throws IOException
	  {
		    driver = initializeBrowser();
	        driver.get(prop.getProperty("url"));
	        }
	  
	  
	  @AfterMethod
	  public void tearDown() {
			driver.quit();
	}
      
}
