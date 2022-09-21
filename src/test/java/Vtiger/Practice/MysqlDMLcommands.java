package Vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/* 1) Create the connection
   2) Create Query
   3) Execute the Query
   4) Close the connection */

public class MysqlDMLcommands {

	public static void main(String[] args) throws Throwable
	{
		// 1) Create the connection
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mydatabase","root","Kiran@2210");
		
		// 2) Create Query/statement
		Statement stmt = con.createStatement();
		
		// 3) Execute the Query
		String query = "insert into clientinfo values ('Ratna',420,'Banglore')";
		int result = stmt.executeUpdate(query);
		
		//System.out.println(result);
		if (result==1) 
		{
			System.out.println("Data Inserted");
		}
		else
		{
			System.out.println("Data not Inserted");
		}
		
		// 5) Close the connection
		con.close();
		
	}

}
