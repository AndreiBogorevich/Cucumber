package managers;

import dataProviders.ConfigFileReader;

public class FileReaderManager {
	
	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFileReader configFileReader;

	// private constructor =
	// no objects of this class are allowed
	private FileReaderManager(){
	}
	
	public static FileReaderManager getInstance(){
		return fileReaderManager;
	}
	
	public ConfigFileReader getConfigFileReader(){
		if (configFileReader == null){
			configFileReader = new ConfigFileReader();
		}
		return configFileReader;
	} 
}
