package Vtiger.Practice;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyfile {

	public static void main(String[] args) throws IOException
	{
		// Step - 1 : Load the file location into file input stream
	
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\data\\commonData.properties");
		
		// Step - 2 : Create object of properties
		Properties prop = new Properties();
		
		// Step - 3 : Load the data into properties
		prop.load(fis);
		
		// Step - 4 : Use the key and read the values
		String BROWSER = prop.getProperty("browser");
		System.out.println(BROWSER);
		
		String URL = prop.getProperty("url");
		System.out.println(URL);
	}

}
