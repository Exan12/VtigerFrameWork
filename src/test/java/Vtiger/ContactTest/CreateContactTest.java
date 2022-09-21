package Vtiger.ContactTest;

import java.io.FileInputStream;

import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateContactTest {

	@ Test
	public  void ContactTest() throws Throwable 
	{
		WebDriver driver;
		
		//Generate random number
		Random r = new Random();
		int RANDOM = r.nextInt(500);
				
		//Step 1: Read all the necessary data
		//read data from property file ----> Common Data
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\data\\commonData.properties");
	    Properties pObj = new Properties();
		pObj.load(fisp);
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		//read data from Excel Sheet -----> Test Data
        FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
        Workbook wb = WorkbookFactory.create(fise);
        Sheet sh = wb.getSheet("Contacts");
        Row rw = sh.getRow(1);
        Cell cel = rw.getCell(2);
        String ORGNAME = cel.getStringCellValue();
		
	    //Step 2: launch the browser -- run time polymorphism
        if(BROWSER.equalsIgnoreCase("chrome"))
        {
        	driver = new ChromeDriver();
        	System.out.println("--- chrome browser launched ----");
        }
        else if(BROWSER.equalsIgnoreCase("Firefox"))
        {
        	driver = new FirefoxDriver();
        	System.out.println("---- Firefox browser launched----");
        }
        else
        {
        	System.out.println("-invalid browser name-");
        	driver = new ChromeDriver();
        	System.out.println("--- chrome browser launched ----");
        }
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(URL);
        
        //Step 3: login to app
        driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		// Step - 4 : Navigate to the Contact Link
		driver.findElement(By.xpath("//a[@href=\"index.php?module=Contacts&action=index\"]")).click();
		
		// Step - 5 : Click on the create Contact Lookup image
		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		
		// Step - 6 : Create Contact with mandatory fields
		driver.findElement(By.name("lastname")).sendKeys(ORGNAME+RANDOM);
		
		// Step - 7 : Save
		driver.findElement(By.name("button")).click();
		
		// Step - 8 : Logout
		Actions ac = new Actions(driver);
		WebElement x = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		ac.moveToElement(x).perform();
		driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
	
		
	}

}
