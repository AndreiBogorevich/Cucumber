package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends MainPage {

	// page onjects declarations
	@FindBy(how = How.ID_OR_NAME, using = "email")
	public static WebElement txtEmail;

	@FindBy(how = How.ID_OR_NAME, using = "passwd")
	public static WebElement txtPassword;

	@FindBy(how = How.XPATH, using = "//p[@class='submit']//span[1]")
	public static WebElement btnLogIn;

	// Constructor
	public LoginPage(WebDriver drv) {
		super(drv);
		// TODO Auto-generated constructor stub
	}

	public void logIn(String sUsername, String sPassword) {

		txtEmail.clear();
		txtEmail.sendKeys(sUsername);
		
		txtPassword.clear();
		txtPassword.sendKeys(sPassword);
		
		btnLogIn.click();
	}

}
