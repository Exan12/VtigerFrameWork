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
		// Step - 1 : Create an Object of all the utilites
		WebDriverUtility wUtil = new WebDriverUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		JavaUtility jUtil = new JavaUtility();
		
		// Step - 2 : Open the Browser and Enter the Url
		WebDriver driver = new ChromeDriver();
		wUtil.maximiseWindow(driver);
		wUtil.waitForDOMLoad(driver);
		String URL = pUtil.readDataFromPFile("url");
		driver.get(URL);
		
		// Step - 3 : Login to the Application
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp("admin","admin");

		// Step - 4 : Click On the Organization Link
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLnk().click();
		
		// Step - 5 : Click On the Organization Lookup Button
		OrganizationPage op = new OrganizationPage(driver);
		op.ClickOnOrganizationLookUpBtn();
		
		// Step - 6 : Create the New Organization
		CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
		cno.EnterOrganizationName("PSPYDERS"+jUtil.getRandomNumber());
		cno.ClickOnSaveBtn();
		
		// Step - 7 : Read the Organization Name and Header
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		oip.OrganizationNameField();
		oip.OrganizationHeader();
		
		// Step - 8 : Verfication
		if(oip.OrganizationHeader().contains(oip.OrganizationNameField()))
		{
			System.out.println("New Organization was Created Sucessfully ---> PASS");
		}
		else
		{
			System.out.println("New Organization was Not Created Sucessfully ---> FAIL");
		}
		
		// Step - 9 : Logout
		hp.SignOutApp(driver);
		
	}

}
