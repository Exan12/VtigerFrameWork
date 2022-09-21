package Vtiger.ContactTest;
import org.testng.annotations.Test;
import Vtiger.GenericUtilities.BaseClass;
import Vtiger.ObjectRepository.ContactPage;
import Vtiger.ObjectRepository.ContactsInfoPage;
import Vtiger.ObjectRepository.CreateNewContactPage;
import Vtiger.ObjectRepository.HomePage;


public class CreateContactPomTest extends BaseClass{
	
    @ Test (groups = "SmokeSuite")
	public void CreateContactTest() throws Throwable {
		
        // Step - 4 : Click On the Organization Link
		HomePage hp = new HomePage(driver);
		hp.ClickOnContactsLnk();
		
		// Step - 5 : Click On the Contacts Lookup Button
	    ContactPage cp = new ContactPage(driver);
	    cp.ClickOnContactsLookupBtn();
	    
	    // Step - 6 : Create the New Contacts
	    CreateNewContactPage cnc = new CreateNewContactPage(driver);
	    cnc.EnterLastName("HYDERABAD"+jUtil.getRandomNumber());
	    cnc.ClickOnSaveButton();
	    
	    // Step - 7 : Read the Contacts Name and Header
	    ContactsInfoPage cip = new ContactsInfoPage(driver);
	    cip.ContactLastnameField();
	    cip.ContactsHeader();
	    
	    // Step - 8 : Verfication
	    Thread.sleep(2000);
	    if(cip.ContactsHeader().contains(cip.ContactLastnameField()))
	    {
	    	System.out.println("New Contact Created Sucessfully ---> PASS");
	    }
	    else
	    {
	    	System.out.println("New Contact Not Created Sucessfully ---> FAIL");
	    }
	    
	    // Step - 9 : Logout
	    Thread.sleep(2000);
	    hp.SignOutApp(driver);
	}
    
    @Test (groups = "RegressionSuite")
    public void DemoRegressionTest()
    {
    	System.out.println("This is Regresssion");
    }

}


