package Vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtilities.WebDriverUtility;

public class CreateContactWithOrganizationPage extends WebDriverUtility{
	
	// Declaration
	@FindBy (xpath = "//input[@name=\"lastname\"]")
	private WebElement LastNameEditField;
	
	@FindBy (xpath = "//img[@title=\"Select\"]")
	private WebElement OrgNameAddButton;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement savebutton;
	
	@FindBy(id="search_txt") private WebElement SearchBox;
	
	@FindBy(xpath = "//input[@type=\"button\"]")
	private WebElement SearchButton;

	// Initilization
	public CreateContactWithOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	// Utilization
	public WebElement getLastNameEditField()
	{
		return LastNameEditField;
	}

    public WebElement getOrgNameAddButton()
	{
		return OrgNameAddButton;
	}

    public WebElement getSavebutton() 
	{
		return savebutton;
	}

    public WebElement getSearchBox() 
    {
		return SearchBox;
	}

    public WebElement getSearchButton() 
    {
		return SearchButton;
	}

    // Business Logic
    /**
     * This method is used to create the Contacts with Organisation Name
     * @param lastname
     * @param OrgName
     */
	public void CreateContactWithOrganizationMethod(String lastname ,String Orgname ,WebDriver driver)
	{
		LastNameEditField.sendKeys(lastname);
		OrgNameAddButton.click();
		
		// Traversing Parent Window to Child Window
		switchToWindow(driver,"Accounts");
		SearchBox.sendKeys(Orgname);
		SearchButton.click();
		driver.findElement(By.xpath("//a[text()='"+Orgname+"']")).click();
		// Traversing from Child to Parent Window
		switchToWindow(driver,"Contacts");
		savebutton.click();
	}
}
