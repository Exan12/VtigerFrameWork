package Vtiger.GenericUtilities;

import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public DatabaseUtility  dbUtil = new DatabaseUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public WebDriver driver = null;

	@BeforeSuite (groups = {"SmokeSuite","RegressionSuite"})
	public void bsConfig() throws SQLException
	{
		dbUtil.connectDB();
		Reporter.log(" ---- DB Connection Successfull ---- ",true);
	}
	
	@BeforeClass (groups = {"SmokeSuite","RegressionSuite"})
	public void bcConfig() throws Throwable
	{
		String BROWSER = pUtil.readDataFromPFile("browser");
	    String URL = pUtil.readDataFromPFile("url");
	    
	    if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			Reporter.log(BROWSER + "--- Browser Launched ---- ");
		}
		else if(BROWSER.equalsIgnoreCase("FIREFOX"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			Reporter.log(BROWSER + "--- Browser Launched ---- ");
		}
		else
		{
			System.out.println("--- Invalid Browser Name --- ");
		}
		
		wUtil.maximiseWindow(driver);
		wUtil.waitForDOMLoad(driver);
		driver.get(URL);
	    }
		
		@BeforeMethod (groups = {"SmokeSuite","RegressionSuite"})
		public void bmConfig() throws Throwable
		{
		
			String USERNAME = pUtil.readDataFromPFile("username");
			String PASSWORD = pUtil.readDataFromPFile("password");
			
			LoginPage lp = new LoginPage(driver);
			lp.LoginToApp(USERNAME, PASSWORD);
			Reporter.log(" --- Logged In Sucessfully --- ",true);
		
		}
		
		@AfterMethod (groups = {"SmokeSuite","RegressionSuite"})
		public void amConfig()
		{
			HomePage hp = new HomePage(driver);
			hp.SignOutApp(driver);
			Reporter.log(" --- Logged Out Succesfully --- ",true);
		}
		
		@AfterClass (groups = {"SmokeSuite","RegressionSuite"})
		public void acConfig()
		{
			driver.close();
			Reporter.log(" --- Browser closed Sucessfully --- ",true);
		}
		
		@AfterSuite (groups = {"SmokeSuite","RegressionSuite"})
		public void asConfig() throws SQLException
		{
			dbUtil.closeDB();
			Reporter.log(" --- Database Connection Closed Succesfully",true);
		}
}

