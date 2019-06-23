package stepDefinition;

import org.junit.Assert;

import pageObjects.MainPage;
import cucumber.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MainPageSteps {
	
	TestContext testContext = null;
	MainPage page = null;
	
	public MainPageSteps(TestContext context){
		testContext = context;
		page = testContext.getPageObjectManager().getMainPage();
	}
	
	@Then("^User is logged out and sign in option is available$")
	public void message_displayed_LogOut_Successfully()  {

		Assert.assertTrue(testContext.isElementVisible(page.btnSignIn));
	}


	@Then("^User is logged in and sign out option is available$")
	public void login_successful() {

		Assert.assertTrue(testContext.isElementVisible(page.btnSignOut));
	}

	@When("^User logs out from the application$")
	public void user_LogOut_from_the_Application() {

		page.signOut();

	}
	
}
