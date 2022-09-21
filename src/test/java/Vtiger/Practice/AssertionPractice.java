package Vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
	
	@Test
	public void assertPractice()
	{
		SoftAssert sa = new SoftAssert();
		System.out.println("Step 1");
		sa.assertTrue(true);
		System.out.println("Step 2");
		Assert.assertEquals("B", "A"); // It  is a hard Assert it will stops further execution
		System.out.println("Step 3");
		System.out.println("Step 4");
		sa.assertAll();
	}
	
	@Test
	public void assertPractice1()
	{
		SoftAssert sa = new SoftAssert();
		System.out.println("Test Script-2 Step 1");
		sa.assertEquals(true, false);
		System.out.println("Test Script-2 Step 2");
		sa.assertTrue(false);  // failed
		System.out.println("Test Script-2 Step 3");
		System.out.println("Test Script-2 Step 4");
		sa.assertAll(); // It is mandatory
	}

}
