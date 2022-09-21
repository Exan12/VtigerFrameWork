package Vtiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class OrganisationWithElectronics {

	public static void main(String[] args)
	{
		// Step - 1 : Launch the browser
		
		   WebDriver driver = new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		   driver.get("http://localhost:8888/");
					
			// Step - 2 : Login to the application
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
					
			// Step - 3 : Navigate to the Organization Link
			driver.findElement(By.linkText("Organizations")).click();
					
			// Step - 4 : Click on the create Organization Lookup image
			driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
					
			// Step - 5 : Create organization with mandatory fields
			driver.findElement(By.name("accountname")).sendKeys("BUNGE INDIA PVT LTD 2");
			
			// Step - 6 : Select Electronics in Industry Drop down
			WebElement ddAddr = driver.findElement(By.name("industry"));
		    Select sel = new Select(ddAddr);
		    sel.selectByVisibleText("Electronics");
		    
		    // Step - 7 : Select Investor in Type Drop Down
		    WebElement ddAddr1 = driver.findElement(By.name("accounttype"));
		    Select sele = new Select(ddAddr1);
		    sele.selectByVisibleText("Investor");
					
			// Step - 8 : Save
			driver.findElement(By.name("button")).click();
					
			// Step - 9 : Logout
			Actions ac = new Actions(driver);
			WebElement x = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
			ac.moveToElement(x).perform();
			driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
	}

}
