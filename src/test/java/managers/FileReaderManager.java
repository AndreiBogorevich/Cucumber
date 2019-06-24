package managers;

import dataProviders.ConfigFileReader;
import dataProviders.JsonFileReader;

public class FileReaderManager {
	
	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFileReader configFileReader;
	private static JsonFileReader jsonFileReader;

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
	
	public JsonFileReader getJsonFileReader(){
		if (jsonFileReader == null){
			jsonFileReader = new JsonFileReader();
		}
		return jsonFileReader;
	} 
}
