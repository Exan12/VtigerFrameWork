package Vtiger.Practice;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContactWithAddOrganisation {

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
		
		// Step - 3 : Navigate to the Contact Link
		driver.findElement(By.xpath("//a[@href=\"index.php?module=Contacts&action=index\"]")).click();
		
		
		// Step - 4 : Click on the create Contact Lookup image
		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		
		// Step - 5 : Create Contact with mandatory fields
		driver.findElement(By.name("lastname")).sendKeys("Ratna Kiran");
		
		// Step - 6 : Choose organization which is Existed
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/select.gif\"]")).click();
		
		// Step - 7 : Switch from Parent to Child Window
		driver.switchTo().window("Organization");
		driver.findElement(By.name("search_text")).sendKeys("Ratna Kiran");
	    driver.findElement(By.name("search")).click();
	    
	    // Step - 8 : Switch from child to parent Window
	    driver.switchTo().window("Contacts");
		
		// Step - 9 : Save
		driver.findElement(By.name("button")).click();
		
		// Step - 10 : Logout
		Actions ac = new Actions(driver);
		WebElement x = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		ac.moveToElement(x).perform();
		driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
	
	}

}