package Vtiger.Practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws Throwable 
	{
		// Step - 1 : Load the file location into file input stream
		
			FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
			
			// Step - 2 : Create Workbook
			Workbook wb =  WorkbookFactory.create(fise);
			
			// Step - 3 : Get into Sheet
			Sheet sh = wb.getSheet("Organization");
			
			// Step - 4 : Get into Row
			Row r = sh.getRow(4);
			
			// Step - 5 : Get into Cell
			Cell c = r.getCell(2);
			
			// Step - 6 : Read the value Present in the cell
			String value = c.getStringCellValue();
			System.out.println(value);
	}
}
