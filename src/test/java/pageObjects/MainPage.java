package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
	
	WebDriver driver;
	
	// Page objects declarations
	@FindBy(how = How.XPATH, using = "//a[@class='login']")
	public WebElement btnSignIn;
	
	@FindBy(how = How.XPATH, using = "//a[@class='logout']")
	public WebElement btnSignOut;
	
	
	// Constructor
	public MainPage(WebDriver drv){
		
		driver = drv;
		PageFactory.initElements(drv, this);
	}
	
	// Common methods
	
	public void gotoLogin (){
		btnSignIn.click();
	}
	
	public void signOut (){
		btnSignOut.click();
	}
}
