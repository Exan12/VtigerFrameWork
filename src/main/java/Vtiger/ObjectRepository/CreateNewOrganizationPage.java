package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganizationPage { 
	
	// Declaration
	@FindBy(xpath = "//input[@name=\"accountname\"]")
	private WebElement OrganizationNameEdt;
	
	@FindBy(xpath = "//input[@type=\"radio\"]")
	private WebElement AssignedToBtn;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement SaveBtn;
	
	// Initilazation
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
    
	// Utilization
	public WebElement getOrganizationNameEdt() 
	{
		return OrganizationNameEdt;
	}

	public WebElement getAssignedToBtn() 
	{
		return AssignedToBtn;
	}

	public WebElement getSaveBtn() 
	{
		return SaveBtn;
	}
	
	// Business Logic
	
	/**
	 * This Method is used to enter the Organization Name
	 * @param OrgName
	 */
	public void EnterOrganizationName(String OrgName)
	{
		OrganizationNameEdt.sendKeys(OrgName);
	}
	
	/**
	 * This Method is Used to Click On the Assigned To Button
	 */
	public void ClickOnAssignedToBtn()
	{
		AssignedToBtn.click();
	}
	
	/**
	 * This Method is used to Click on the save button
	 */
	public void ClickOnSaveBtn()
	{
		SaveBtn.click();
	}

}
