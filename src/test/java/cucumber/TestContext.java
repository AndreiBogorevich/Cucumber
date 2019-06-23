package cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;

public class TestContext {

	private WebDriverManager webDriverManager;
	private PageObjectManager pageObjectManager;

	public TestContext() {
		webDriverManager = new WebDriverManager();
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
	}

	public WebDriverManager getWebDriverManager() {
		return webDriverManager;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

	public boolean isElementPresent(By by) {

		WebDriverWait wait = new WebDriverWait(webDriverManager.getDriver(),
				FileReaderManager.getInstance().getConfigFileReader()
						.getExplicitWait()); // getting the value from the config properties

		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(by));

			// System.out.println("Element is present");

			return true;
		} catch (Throwable t) {

			System.out.println("Element is not found");

			return false;
		}
	}

	public boolean isElementVisible(WebElement element) {

		WebDriverWait wait = new WebDriverWait(webDriverManager.getDriver(),
				FileReaderManager.getInstance().getConfigFileReader()
						.getExplicitWait()); // getting the value from the config properties

		try {
			wait.until(ExpectedConditions.visibilityOf(element));

			return true;
		} catch (Throwable t) {

			System.out.println("Element is not visible");

			return false;
		}
	}
}
