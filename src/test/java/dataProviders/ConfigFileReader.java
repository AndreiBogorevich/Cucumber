package dataProviders;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigFileReader {

	private String sConfigFilePath = (System.getProperty("user.dir") + "/src/test/resources/properties/config.properties");
	private Properties properties;
	
	public ConfigFileReader() {
		FileInputStream fis;
		try {
			
			fis = new FileInputStream(sConfigFilePath);
			properties = new Properties();
			properties.load(fis);	
			fis.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration file failed to load from " + sConfigFilePath);
		}		
	}
	
	public String getBrowser(){
		String sBrowser = properties.getProperty("browser");
		if (sBrowser != null){
			return sBrowser;
		}
		else{
			throw new RuntimeException("Browser is not specified in the configuration file.");
		}
	}
	
	public String getStartingUrl(){
		String sStartingUrl = properties.getProperty("startingUrl");
		if (sStartingUrl != null){
			return sStartingUrl;
		}
		else{
			throw new RuntimeException("Starting Url is not specified in the configuration file.");
		}
	}
	
	public long getImplicitWait(){
		String sImplicitWait = properties.getProperty("implicitWait");
		if (sImplicitWait != null){
			return Long.parseLong(sImplicitWait);
		}
		else{
			throw new RuntimeException("Implicit Wait is not specified in the configuration file.");
		}
	}
	
	public long getExplicitWait(){
		String sExplicitWait = properties.getProperty("explicitWait");
		if (sExplicitWait != null){
			return Long.parseLong(sExplicitWait);
		}
		else{
			throw new RuntimeException("Explicit Wait is not specified in the configuration file.");
		}
	}
	
	public String getFirefoxProfile(){
		String sFirefoxProfile = properties.getProperty("firefoxProfle");
		if (sFirefoxProfile != null){
			return sFirefoxProfile;
		}
		else{
			throw new RuntimeException("Firefox Profile is not specified in the configuration file.");
		}
	}
	
	public String getExecutablesPath(){
		String sExecutablesPath = properties.getProperty("executablesPath");
		if (sExecutablesPath != null){
			return sExecutablesPath;
		}
		else{
			throw new RuntimeException("Executables path is not specified in the configuration file.");
		}
	}
	
	public boolean getUseFirefoxBinary(){
		String sFlag = properties.getProperty("useFirefoxBinary");
		if (sFlag != null){
			if (sFlag.equalsIgnoreCase("y") || sFlag.equalsIgnoreCase("true")){
				return true;
			} // flag is not null and set to yes 
			else{
				return false;
			} // flag is not null and NOT set to yes
		}
		else{
			throw new RuntimeException("Use Firefox Binary flag is missing in the configuration file.");
		} // flag is not setm i.e. is null
	}

	public String getFirefoxBinary() {
		String sFirefoxBinary = properties.getProperty("firefoxBinary");
		if (sFirefoxBinary != null){
			return sFirefoxBinary;
		}
		else{
			throw new RuntimeException("Firefox Binary path is not specified in the configuration file.");
		}
	}
	
	public boolean getMaximizeBrowser(){
		String sMaximize = properties.getProperty("maximizeBrowser");
		if (sMaximize != null){
			if (sMaximize.equalsIgnoreCase("y") || sMaximize.equalsIgnoreCase("true")){
				return true;
			} // flag is not null and set to yes 
			else{
				return false;
			} // flag is not null and NOT set to yes
		}
		else{
			throw new RuntimeException("Use MaximizeBrowser flag is missing in the configuration file.");
		} // flag is not setm i.e. is null
	}
	
}
