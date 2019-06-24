package stepDefinition;

import cucumber.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	TestContext testContext;

	public Hooks(TestContext context) {
		testContext = context;
	}

	@Before
	public void setUp() {
		System.out.println("-----------------------------------");
		System.out.println("Before each test");
		testContext.getWebDriverManager().setBrowserSize();
	}

	@After
	public void tearDown() {
		System.out.println("After each test");
		testContext.getWebDriverManager().getDriver().quit();
	}
}
