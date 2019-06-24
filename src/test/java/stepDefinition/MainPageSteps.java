package stepDefinition;

import org.junit.Assert;

import pageObjects.MainPage;
import cucumber.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MainPageSteps {

	TestContext testContext = null;
	MainPage mainPage = null;

	public MainPageSteps(TestContext context) {
		testContext = context;
		mainPage = testContext.getPageObjectManager().getMainPage();
	}

	@Then("^User is logged out and sign in option is available$")
	public void user_is_logged_out_and_sign_in_option_is_available() {

		Assert.assertTrue(testContext.isElementVisible(mainPage.btnSignIn));
	}

	@Then("^User is logged in and sign out option is available$")
	public void user_is_logged_in_and_sign_out_option_is_available() {

		Assert.assertTrue(testContext.isElementVisible(mainPage.btnSignOut));
	}

	@When("^User logs out from the application$")
	public void user_logs_out_from_the_application() {

		mainPage.signOut();

	}

}
