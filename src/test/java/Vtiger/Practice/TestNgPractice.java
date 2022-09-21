package Vtiger.Practice;

import org.testng.annotations.Test;

public class TestNgPractice {

	@ Test (priority = 1)
	public void createCustomerTest()
	{
		System.out.println("Customer is Created");
	} 
	
	@ Test (priority = 2)
	public void modifyCustomerTest()
	{
		System.out.println("Customer is Modified");
	}
	
	@ Test (priority = 3)
	public void deleteCustomerTest()
	{
		System.out.println("Customer is Deleted");
	}
}
