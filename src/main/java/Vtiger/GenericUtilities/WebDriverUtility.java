package Vtiger.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains all the Generic Methods related to Webdriver.
 * @author Kiran
 *
 */
public class WebDriverUtility 
  {
	/**
	 * This method will Maximise the Window
	 * @param driver
	 */
	public void maximiseWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will waits for 20 seconds for the Entire DOM to load
	 * @param driver
	 */
	public void waitForDOMLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	/**
	 * This method will wait for an Element to be Visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementTOBeVisible(WebDriver driver , WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This Method will wait for the Element to be Clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver , WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This Methos is a Custom Wait where it wait for particular Element.
	 * @param element
	 * @throws Throwable
	 */
	public void waitAndClickOnElement(WebElement element) throws Throwable
	{
		int count=0;
		while(count<10)
		{
			try
			{
				element.click();
				break;
			}
			catch (Exception e) {
				// TODO: handle exception
				Thread.sleep(1000);
				count++;
			}
		}
	}
	
	/**
	 * This method is used to handle DropDown by using select class based on Index
	 * @param element
	 * @param index
	 */
	public void handledDropDown(WebElement element , int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * This method is used to handle DropDown by using select class based on Visible Text
	 * @param element
	 * @param visiblietext
	 */
	public void handledDropDown(WebElement element , String visibletext)
	{
		Select s = new Select(element);
		s.selectByVisibleText(visibletext);
	}
	
	/**
	 * This method is used to handle DropDown by using select class based on Value
	 * @param value
	 * @param element
	 */
	public void handledDropDown(String value , WebElement element)
	{
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * This method will perform MouseHover Action on a particular Webelement
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver , WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method will perform Double Click on the page
	 * @param driver
	 * @param element
	 */
	public void doubleClickOn(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * This method will perform Double Click on the particular Webelement
	 * @param driver
	 * @param element
	 */
	public void doubleClickOn(WebDriver driver , WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method will perform Right Click on the page
	 * @param driver
	 */
	public void rightClickOn(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * This method will perform Right Click on the particular Webelement
	 * @param driver
	 * @param element
	 */
	public void rightClickOn(WebDriver driver , WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method will perform Drag and Drop action the particular source element to target 
	 * element Location
	 * @param driver
	 * @param srcelement
	 * @param targetelement
	 */
	public void dragAndDropOn(WebDriver driver , WebElement srcelement , WebElement targetelement) 
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(srcelement, targetelement).perform();
	}
	
	/**
	 * This Method will press and release the "ENTER" Key
	 * @throws AWTException
	 */
	public void pressEnter() throws AWTException
	{
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * This Method will accept the Alert Popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This Method will Cancel the Alert Popup
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This Method will Get the Text of Alert Popup
	 * @param driver
	 * @return 
	 */
	public String getTextOfAlert(WebDriver driver)
	{
		String text = driver.switchTo().alert().getText();
		return text;
	}
	
	/**
	 * This Method will handle Frame based on the Index
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This Method will handle Frame based on the Name or Id
	 * @param driver
	 * @param nameOrId
	 */
	public void handleFrame(WebDriver driver,String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * This Method will handle Frame based on the Frame Element
	 * @param driver
	 * @param element
	 */
	public void handleFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * This Method will switch the control back to Immidiate parent
	 * @param driver
	 */
	public void toParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will come out of all the Frames
	 * @param driver
	 */
	public void toDefaultWindow(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method will switch from one window to another based on Partial Window title
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver , String partialWinTitle)
	{
		// Step - 1 : Get all Window Id's
		Set<String> windowIds = driver.getWindowHandles();
		
		// Step - 2 : Iterate/Naviagte through all the window Ids
		Iterator<String> it = windowIds.iterator();
		
		// Step -3 : Navigate to each window and Get the title
		while(it.hasNext())
		{
			// Capture the individual window Id
			String winId = it.next();
			
			// Compare the current Window title with Partial Window Title
			String currentTitle = driver.switchTo().window(winId).getTitle();
			if(currentTitle.contains(partialWinTitle))
			{
				break;
			}
		}
	}
	
	/**
	 * This Method will take Screenshot and save it in the Screenshot folder
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String takesScreenshot(WebDriver driver , String screenshotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = ".\\Screenshots"+screenshotName+".png";
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		
		return dest.getAbsolutePath();     // Used for Reporting
			
	}
	
	/**
	 * This method will Scroll Down for 500 units
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("windows.scrollBy(0,500)"," ");
	}
	
	/**
	 * This method will Scroll untill the Element
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver , WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].scrollIntoView()",element);
		int y = element.getLocation().getY();
		js.executeScript("windows.scrollBy(0,"+y+")", element);
	}
	
}
