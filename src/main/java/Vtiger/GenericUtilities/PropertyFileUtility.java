package Vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class contains all the Generic Methods related to property file.
 * @author Kiran
 *
 */

public class PropertyFileUtility {
	
	/**
	 * This method will read the Key from Propertyfile and return the Value
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	
	public String readDataFromPFile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\data\\commonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
		
	}

}
