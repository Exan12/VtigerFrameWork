package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	
	// Declaration
	@FindBy(xpath = "//input[@name=\"lastname\"]")
	private WebElement LastnameEdt;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement SaveBtn;
	
	// Initialization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
    
	// Utilization
	public WebElement getLastnameEdt() 
	{
		return LastnameEdt;
	}

	public WebElement getSaveBtn() 
	{
		return SaveBtn;
	}
	
	// Business Logic
	
	/**
	 * This Method is used to write the LastName
	 * @param Lastname
	 */
	public void EnterLastName(String Lastname)
	{
		LastnameEdt.sendKeys(Lastname);
	}
	
	/**
	 * This Method is used to click the Save button
	 */
	public void ClickOnSaveButton()
	{
		SaveBtn.click();
	}
	
}
