package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {        // Rule - 1 : Create Java Class Page Wise
	
	/* Rule - 2 : Identify the all Type Webelements in the page by using 
	   @FindBy,@FindAll,@FindBys */
	
	// Declaration
	@FindBy(name = "user_name") private WebElement UserNameEdt;
	@FindBy(name = "user_password") private WebElement PasswordEdt;
	@FindBy(id = "submitButton") private WebElement SubmitBtn;
	
	// Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver , this);
	}
	
    // Utilization
	public WebElement getUserNameEdt() 
	{
		return UserNameEdt;
	}

	public WebElement getPasswordEdt() 
	{
		return PasswordEdt;
	}

	public WebElement getSubmitBtn() 
	{
		return SubmitBtn;
	}
	
	// Business Library
	public void LoginToApp(String userName , String password)
	{
		UserNameEdt.sendKeys(userName);
		PasswordEdt.sendKeys(password);
		SubmitBtn.click();
		
	}
	
	
	
	
	

}
