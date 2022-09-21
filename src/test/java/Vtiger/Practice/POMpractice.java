package Vtiger.Practice;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Vtiger.GenericUtilities.WebDriverUtility;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.LoginPage;
import Vtiger.ObjectRepository.OrganizationPage;

public class POMpractice {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.getUserNameEdt().sendKeys("admin");
		lp.getPasswordEdt().sendKeys("admin");
		lp.getSubmitBtn().click();
		
		lp.LoginToApp("admin","admin");
		
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLnk().click();
		
		WebDriverUtility w = new WebDriverUtility();
		w.mouseHover(driver,hp.getAdministratorImg());
		hp.getSignOutLnk().click();
		
		hp.ClickOnProductsLnk();
		hp.SignOutApp(driver); 
		
		OrganizationPage op = new OrganizationPage(driver);
		op.ClickOnOrganizationLookUpBtn();
	}

}
