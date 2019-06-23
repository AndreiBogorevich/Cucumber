package stepDefinition;

import pageObjects.LoginPage;
import cucumber.TestContext;
import cucumber.api.java.en.When;

public class LoginPageSteps {
	
	TestContext testContext = null;
	LoginPage loginPage = null;

	public LoginPageSteps(TestContext context) {
		testContext = context;
		loginPage = context.getPageObjectManager().getLoginPage();
	}
	
	@When("^User enters email as \"(.*)\" and password as \"(.*)\"$")
	public void user_enters_username(String sEmail, String sPassword) {

		loginPage.logIn(sEmail, sPassword);
	}
	
}
