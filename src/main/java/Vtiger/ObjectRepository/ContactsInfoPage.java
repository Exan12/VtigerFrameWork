package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage { 
	
	// Declaration
	@FindBy(xpath = "//input[@name=\"lastname\"]")
	private WebElement LastNameField;
	
	@FindBy(xpath = "//span[@class=\"dvHeaderText\"]")
	private WebElement Titleinfo;
	
	// Intialization
	public ContactsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver , this);
	}
    
	
	// Utilization
	public WebElement getLastNameField() 
	{
		return LastNameField;
	}

	public WebElement getTitleinfo()
	{
		return Titleinfo;
	}
	
	// Business Logic
	
	/**
	 * This Method is used to read the Contact Information (Last Name)
	 * @param Lastname
	 * @return
	 */
	public String ContactLastnameField()
	{
		String ConName = LastNameField.getText();
		return ConName;
	}
	
	/**
	 * This Method is used to read the Heading oof the Contact Information Page
	 * @return
	 */
	public String ContactsHeader()
	{
		String ConHeader = Titleinfo.getText();
		return ConHeader;
	}

}
