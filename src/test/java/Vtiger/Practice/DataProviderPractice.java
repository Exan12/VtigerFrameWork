package Vtiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	@Test (dataProvider = "getData")
	public void CreateOrganizationWithIndustry(String Orgname , String Industry)
	{
		System.out.println(Orgname+" ---> "+Industry);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object [5][2];
		
		data[0][0] = "QSPYDERS";
		data[0][1] = "Chemichals";
		
		data[1][0] = "PSPYDERS";
		data[1][1] = "Petroleum";
		
		data[2][0] = "JSPYDERS";
		data[2][1] = "Beverages";
		
		data[3][0] = "APE";
		data[3][1] = "Metal";
		
		data[4][0] = "BUNGE";
		data[4][1] = "Edibile Oil";
		
		return data;
	}

}
