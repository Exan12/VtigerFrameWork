package Vtiger.OrganizationTest;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Vtiger.GenericUtilities.BaseClass;
import Vtiger.GenericUtilities.JavaUtility;
import Vtiger.GenericUtilities.PropertyFileUtility;
import Vtiger.GenericUtilities.WebDriverUtility;
import Vtiger.ObjectRepository.CreateNewOrganizationPage;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.LoginPage;
import Vtiger.ObjectRepository.OrganizationInfoPage;
import Vtiger.ObjectRepository.OrganizationPage;

public class CreateOrganizationPomTest extends BaseClass{
	
	
    @ Test (groups = "RegressionSuite")
	public void CreateOrganizationTest() throws Throwable
	{
		// Step - 1 : Click On the Organization Link
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLnk().click();
		
		// Step - 2 : Click On the Organization Lookup Button
		OrganizationPage op = new OrganizationPage(driver);
		op.ClickOnOrganizationLookUpBtn();
		
		// Step - 3 : Create the New Organization
		CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
		cno.EnterOrganizationName("PSPYDERS"+jUtil.getRandomNumber());
		cno.ClickOnSaveBtn();
		
		// Step - 4 : Read the Organization Name and Header
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		oip.OrganizationNameField();
		oip.OrganizationHeader();
		
		// Step - 5 : Verfication
		if(oip.OrganizationHeader().contains(oip.OrganizationNameField()))
		{
			System.out.println("New Organization was Created Sucessfully ---> PASS");
		}
		else
		{
			System.out.println("New Organization was Not Created Sucessfully ---> FAIL");
		}
		
	}

}
