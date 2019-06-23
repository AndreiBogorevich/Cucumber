package stepDefinition;

import org.junit.Assert;

import pageObjects.HomePage;
import cucumber.TestContext;
import cucumber.api.java.en.Given;

public class HomePageSteps {

	TestContext testContext = null;
	HomePage homePage = null;

	public HomePageSteps(TestContext context) {
		testContext = context;
		homePage = context.getPageObjectManager().getHomePage();
	}

	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() {

		homePage.navigateToHomePage();
	}

	@Given("^user is not signed in$")
	public void user_is_not_signed_in() throws Throwable {

		// Sign in button is present
		Assert.assertTrue(testContext.isElementVisible(homePage.btnSignIn));

	}

	@Given("^User clicks SignIn$")
	public void user_clicks_SignIn() throws Throwable {

		homePage.gotoLogin();
	}
	


}
