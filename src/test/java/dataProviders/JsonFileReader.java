package dataProviders;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import managers.FileReaderManager;
import testDataTypes.Login;

import com.google.gson.Gson;

public class JsonFileReader {

	private final String sLoginPath = FileReaderManager.getInstance()
			.getConfigFileReader().getTestDataPath()
			+ "Login.json";
	private List<Login> listLogin;

	public JsonFileReader() {
		listLogin = getLoginList();
	}

	private List<Login> getLoginList() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(sLoginPath));
			Login[] logins = gson.fromJson(bufferReader, Login[].class);
			return Arrays.asList(logins);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : "
					+ sLoginPath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	public final Login getLoginByEmail(String sEmail) {

		for (Login login : listLogin) {
			if (login.email.equalsIgnoreCase(sEmail)) {
				return login;
			} // end if email comparison
		} // end loop through all logins
		return null; // if no login found with the searched email
	}

}
