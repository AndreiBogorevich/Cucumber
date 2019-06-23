package stepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	@Before
	public static void setUp() {
		System.out.println("-----------------------------------");
		System.out.println("Before each test");
	}

	@After
	public static void tearDown() {
		System.out.println("After each test");
	}
}
