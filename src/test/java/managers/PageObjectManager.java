package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MainPage;

public class PageObjectManager {
	
	private WebDriver driver;
	
	private MainPage mainPage;
	private HomePage homePage;	
	private LoginPage loginPage;
	
	public PageObjectManager(WebDriver drv){
		driver = drv;
	}

	public MainPage getMainPage() {
		if (mainPage == null){
			mainPage = new MainPage(driver);
		}			
		return mainPage;
	}	
	
	public HomePage getHomePage(){
		if (homePage == null){
			homePage = new HomePage(driver);
		}			
		return homePage;
	}
	
	public LoginPage getLoginPage(){
		if (loginPage == null){
			loginPage = new LoginPage(driver);
		}			
		return loginPage;
	}


}
