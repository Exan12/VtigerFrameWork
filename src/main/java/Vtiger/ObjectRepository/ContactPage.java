package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	// Declaration
	@FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement CreateContactLookupBtn;
	
	// Initialization
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
    
	// Utilization
	public WebElement getCreateContactLookupBtn() 
	{
		return CreateContactLookupBtn;
	}
	
	// Business Logic
	
	/**
	 * This Method is used to Click the Create Contact Lookup Button
	 */
	public void ClickOnContactsLookupBtn()
	{
		CreateContactLookupBtn.click();
	}

}
