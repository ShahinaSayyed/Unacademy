package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
WebDriver driver;
	
	public LogoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
 
  
  @FindBy(xpath="//div[@class=' css-441fyq-StyledDiv eyp81ai1']")
  private WebElement LogoutButton;

  
 
  
  
  public void clickonlogoutbutton() {
	   LogoutButton.click();
  }
}


