package Vtiger.GenericUtilities;

import java.util.Date;
import java.util.Random;

/**
 * This class contains all Generic Methods related to java
 * @author Kiran
 *
 */

public class JavaUtility {
	
	/**
	 * This method will generates the Random integer number for every Execution
	 * @return 
	 * 
	 */
	public int getRandomNumber()
	{
		Random r = new Random();
		int ran = r.nextInt(1000);
		return ran;
	}
	
	/**
	 * This method will return the current System Date
	 * @return
	 */
	
	public String getSystemDate()
	{
		Date d = new Date();
		String date = d.toString();
		return date;
	}
	
	/**
	 * This method will provide the date and time in a specific Format.
	 * @return 
	 */
	public String getSystemDateInFormat()
	{
		Date d = new Date();
		String[] dArr = d.toString().split(" ");
		String date = dArr[2];
		String month = dArr[1];
		String year = dArr[5];
		String time = dArr[3].replace(":", "-");
		String currentDate = date+" "+month+" "+ year+" "+time;
		return currentDate;
		
	}
	

}
