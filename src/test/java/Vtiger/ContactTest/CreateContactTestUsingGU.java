package Vtiger.ContactTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Vtiger.GenericUtilities.BaseClass;
import Vtiger.GenericUtilities.ExcelFileUtility;
import Vtiger.GenericUtilities.JavaUtility;
import Vtiger.GenericUtilities.PropertyFileUtility;
import Vtiger.GenericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Kiran
 */
public class CreateContactTestUsingGU extends BaseClass {

	@ Test
	public static void CreateContactGuiTest() throws Throwable 
	{
		WebDriver driver = null;
		
		// Step - 1 : Create Object of all the Utilities
		@SuppressWarnings("unused")
		JavaUtility jUtil = new JavaUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		// Step - 2 : Read all the necessary data
		String BROWSER = pUtil.readDataFromPFile("browser");
	    String URL = pUtil.readDataFromPFile("url");
		@SuppressWarnings("unused")
		String USERNAME = pUtil.readDataFromPFile("username");
		@SuppressWarnings("unused")
		String PASSWORD = pUtil.readDataFromPFile("password");
		
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 1 , 2);
		
		// Step - 3 : Launch the browser      ------> (RunTime Polymorphism)
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("FIREFOX"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid Browser Name");
		}
		
		wUtil.maximiseWindow(driver);
		wUtil.waitForDOMLoad(driver);
		driver.get(URL);
		
		// Step - 4 : Login to the application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		// Step - 5 : Navigate to Contact
		driver.findElement(By.xpath("//a[@href=\"index.php?module=Contacts&action=index\"]")).click();
		
		// Step - 6 : Click on Create Contact
		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		
		// Step - 7 : Create new Contact with mandatory Information and save 
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.name("button")).click();
		
		// Step - 8 : Logout
		WebElement x = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		wUtil.mouseHover(driver, x);
		driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
		
	}

}
