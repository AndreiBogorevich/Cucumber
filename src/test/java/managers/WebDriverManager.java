package managers;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverManager {

	private static WebDriver driver;

	/*
	 * Browsers class implements methods to initialise WebDriver of desired
	 * brand (Chrome, Firefox, IE, etc.) and setting these browsers ready for
	 * test: ssl support, clean profiles, etc.
	 */

	public WebDriver getDriver() {
		if (driver == null) {
			driver = getDriver(FileReaderManager.getInstance()
					.getConfigFileReader().getBrowser());
		}
		return driver;
	}

	public WebDriver getDriver(String browserName) {

		if (driver == null) {

			try {
				switch (browserName.toLowerCase()) {
				case "chrome":
					return getChrome();
				case "ie":
					return getInternetExplorer();
				case "internet explorer":
					return getInternetExplorer();
				case "firefox":
					return getFirefox();
				default:
					return getFirefox();
				}
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(
						"Failed to initialise webdriver for " + browserName);
			}

		} else {
			return driver;
		}
	}
	
	public void setBrowserSize(){
		if (FileReaderManager.getInstance().getConfigFileReader()
				.getMaximizeBrowser()) {
			driver.manage().window().maximize();
		}
	}

	@SuppressWarnings("deprecation")
	public WebDriver getChrome() {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")
						+ FileReaderManager.getInstance().getConfigFileReader()
								.getExecutablesPath() + "\\chromedriver.exe");

		// handling SSL connections
		DesiredCapabilities handlSSL = DesiredCapabilities.chrome();
		handlSSL.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		return new ChromeDriver(handlSSL);
	}

	public WebDriver getFirefox() throws IOException {

		System.setProperty("webdriver.gecko.driver",
				System.getProperty("user.dir")
						+ FileReaderManager.getInstance().getConfigFileReader()
								.getExecutablesPath() + "\\geckodriver.exe");

		ProfilesIni profile = new ProfilesIni();

		// reading what profile to use from config.properties
		// to create a profile Win+R firefox.exe -p
		// the existin profiles are at %AppData%\Mozilla\Firefox\Profiles

		FirefoxProfile myprofile = profile.getProfile(FileReaderManager
				.getInstance().getConfigFileReader().getFirefoxProfile());

		// handling SSL encryption for https sites
		myprofile.setAcceptUntrustedCertificates(true);
		myprofile.setAssumeUntrustedCertificateIssuer(false);

		FirefoxOptions options = new FirefoxOptions();

		// if Firefox is not installed - reading the firfox.exe
		// location from the config file
		if (FileReaderManager.getInstance().getConfigFileReader()
				.getUseFirefoxBinary()) {
			options.setBinary(FileReaderManager.getInstance()
					.getConfigFileReader().getFirefoxBinary());
		}
		options.setProfile(myprofile);

		return new FirefoxDriver(options);
	}

	@SuppressWarnings("deprecation")
	public WebDriver getInternetExplorer() {

		System.setProperty("webdriver.ie.driver",
				System.getProperty("user.dir")
						+ FileReaderManager.getInstance().getConfigFileReader()
								.getExecutablesPath() + "\\IEDriverServer.exe");

		// setting capabilities to start webdriver regardless of zoom and
		// security settings
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		cap.setCapability(
				InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
				true);

		return new InternetExplorerDriver(cap);
	}

}
