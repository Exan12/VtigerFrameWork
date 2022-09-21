package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	
	// Declaration
	@FindBy(linkText = "Organizations") private WebElement OrganizationsLnk;
	@FindBy(linkText = "Contacts") private WebElement ContactsLnk;
	@FindBy(linkText = "Opportunities") private WebElement OpportunitiesLnk;
	@FindBy(linkText = "Products") private WebElement ProductsLnk;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement AdministratorImg;
	
	@FindBy(linkText = "Sign Out") private WebElement SignOutLnk;
	
	// Intialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
    
	// Utilization   ----> Getters And Business Library
	public WebElement getOrganizationsLnk() 
	{
		return OrganizationsLnk;
	}

	public WebElement getContactsLnk() 
	{
		return ContactsLnk;
	}

	public WebElement getOpportunitiesLnk()
	{
		return OpportunitiesLnk;
	}

	public WebElement getProductsLnk()
	{
		return ProductsLnk;
	}

	public WebElement getAdministratorImg()
	{
		return AdministratorImg;
	}

	public WebElement getSignOutLnk() 
	{
		return SignOutLnk;
	}
	
	// Binary Logic
	/**
	 * This Method will click on the Organizations Link
	 */
	public void ClickOnOrganizationLnk()
	{
		OrganizationsLnk.click();
	}
	
	/**
	 * This Method will click on the Contacts Link
	 */
	public void ClickOnContactsLnk()
	{
		ContactsLnk.click();
	}
    
	/**
	 * This Method will Click on the Opportunities Link
	 */
	public void ClickOnOppurtunitiesLnk()
	{
		OpportunitiesLnk.click();
	}
	
	/**
	 * This Method will Click on the Products Link
	 */
	public void ClickOnProductsLnk()
	{
		ProductsLnk.click();
	}
	
	/**
	 * This Method will SignOut of the Application
	 * @param driver
	 */
	public void SignOutApp(WebDriver driver)
	{
		mouseHover(driver, AdministratorImg);
		SignOutLnk.click();
	}
}
