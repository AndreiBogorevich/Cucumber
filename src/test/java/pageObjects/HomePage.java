package pageObjects;

import java.util.concurrent.TimeUnit;

import managers.FileReaderManager;

import org.openqa.selenium.WebDriver;

public class HomePage extends MainPage {

	
	
	public HomePage(WebDriver drv) {
		super(drv);
		// TODO Auto-generated constructor stub
	}

	// TODO consider making it generic and moving this method to the MainPage
	public void navigateToHomePage() {

		driver.get(FileReaderManager.getInstance().getConfigFileReader()
				.getStartingUrl());

		driver.manage()
				.timeouts()
				.implicitlyWait(
						FileReaderManager.getInstance().getConfigFileReader()
								.getImplicitWait(), TimeUnit.SECONDS);

		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
