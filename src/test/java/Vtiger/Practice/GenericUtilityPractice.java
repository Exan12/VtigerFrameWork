package Vtiger.Practice;

import Vtiger.GenericUtilities.ExcelFileUtility;
import Vtiger.GenericUtilities.JavaUtility;
import Vtiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws Throwable 
	{
		JavaUtility jLib = new JavaUtility();
		int random = jLib.getRandomNumber();
		System.out.println(random);
		
		String date = jLib.getSystemDate();
		System.out.println(date);
		
		String d = jLib.getSystemDateInFormat();
		System.out.println(d);
		
		PropertyFileUtility pLib = new PropertyFileUtility();
		String browser = pLib.readDataFromPFile("browser");
		System.out.println(browser); 
		
		ExcelFileUtility eLib = new ExcelFileUtility();
		String orgName = eLib.readDataFromExcel("Organization",4,2);
		System.out.println(orgName);
		
		eLib.writeDataIntoExcel("Organization",4,6,"Ratna");
		
		eLib.writeDataIntoExcel("Contacts",4,6,"Venkat");
		
	}

}
