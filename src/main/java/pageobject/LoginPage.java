package pageobject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
    
	@FindBy(xpath= "//button[@type='button']")
	private WebElement LoginButton;
	
	
	@FindBy(xpath="//button[@aria-label=\"Continue\"]")
	private WebElement Signin;
	
	
	
	@FindBy(xpath="//h6[@class='css-nmgvwj-H6-StyledH6 e1l7v5xe3']")
	private WebElement CreateYourAccount;
	
	public void clickonLoginButton() {
		
		LoginButton.click();
	}
   
	public void clickonsignin() {
		Signin.click();
	}
	
   

    public void clickoncreateyouraccount() {
    	CreateYourAccount.click();
    }
}


