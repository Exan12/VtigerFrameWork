package Vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class MysqlReadData {

	public static void main(String[] args) throws Throwable 
	{
		Driver driverRef = new Driver();
		
		// Step - 1 : Register the Driver/Database
		DriverManager.registerDriver(driverRef);
		
		// Step - 2 : Create the connection
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mydatabase","root","Kiran@2210");
				
		// Step - 3 : Create Query/statement
		Statement stmt = con.createStatement();
		
		// Step - 4 : Execute the Query - Provide Table name
		ResultSet  result = stmt.executeQuery("select * from clientinfo;");
		
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
		}
		
		// Step - 5 : Close the connection
		con.close();
	}
}
