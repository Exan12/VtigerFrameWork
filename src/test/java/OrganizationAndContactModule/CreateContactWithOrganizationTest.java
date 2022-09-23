package OrganizationAndContactModule;
import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Vtiger.GenericUtilities.BaseClass;
import Vtiger.ObjectRepository.ContactPage;
import Vtiger.ObjectRepository.ContactsInfoPage;
import Vtiger.ObjectRepository.CreateContactWithOrganizationPage;
import Vtiger.ObjectRepository.CreateNewOrganizationPage;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.OrganizationInfoPage;
import Vtiger.ObjectRepository.OrganizationPage;


public class CreateContactWithOrganizationTest extends BaseClass  {
	
	@Test
	public void createContactWithOrganization() throws Throwable
	{
		// Step - 1 : Click On the Organization Link
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLnk().click();
				
		// Step - 2 : Click On the Organization Lookup Button
		OrganizationPage op = new OrganizationPage(driver);
		op.ClickOnOrganizationLookUpBtn();
				
		// Step - 3 : Create the New Organization
		CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
		cno.EnterOrganizationName("QSPYDERS"+jUtil.getRandomNumber());
		cno.ClickOnSaveBtn();
		
		// Step - 4 : Read the Organization Name and Header
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String ORGNAME = oip.OrganizationNameField();
		String ORGHEADER = oip.OrganizationHeader();
				
		// Step - 5 : Verfication
		Assert.assertEquals(ORGHEADER.contains(ORGNAME),true);
		Reporter.log("New Organization Created Sucessfully ---> PASS",true);
				
		// Step - 6 : Click On the Contact Link
		hp.ClickOnContactsLnk();
		
		// Step - 7 : Click On the Contacts Lookup Button
	    ContactPage cp = new ContactPage(driver);
	    cp.ClickOnContactsLookupBtn();
	    
	    // Step - 8 : Create the New Contacts
	    CreateContactWithOrganizationPage ccwp = new CreateContactWithOrganizationPage(driver);
	    ccwp.CreateContactWithOrganizationMethod("Kiran"+jUtil.getRandomNumber(),ORGNAME, driver);
	    
	    // Step - 9 : Read the Contact Name and Header
	    ContactsInfoPage cip = new ContactsInfoPage(driver);
	    String CONTACTNAME = cip.ContactLastnameField();
	    System.out.println(CONTACTNAME);
	    String CONTACTHEADER = cip.ContactsHeader();
	    System.out.println(CONTACTHEADER);
	 	
	    // Step - 10 : Validation
	    Assert.assertEquals(CONTACTHEADER.contains(CONTACTNAME),true);
	    Reporter.log("New Contact Created Sucessfully ---> PASS",true);
	    
	}

}
