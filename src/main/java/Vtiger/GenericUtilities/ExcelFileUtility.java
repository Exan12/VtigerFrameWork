package Vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This method Contains all Generic Methods related to Excel File.
 * @author Kiran
 *
 */

public class ExcelFileUtility {
	
	/**
	 * This Method will read the data from Excel sheet with Sheet name , Row and Cell Number.
	 * @param sheet
	 * @param row
	 * @param cel
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcel(String sheet , int row , int cel) throws Throwable 
	{
		FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheet);
		Row r = s.getRow(row);
		Cell c = r.getCell(cel);
		String value = c.getStringCellValue();
		wb.close();
		return value;
	}
	
	/**
	 * This Method will return total no of Rows in the Excel sheet
	 * @param sheet
	 * @return
	 * @throws Throwable
	 */
	
	public int getRowCount(String sheet) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheet);
		int data = s.getLastRowNum();
		wb.close();
		return data;
	}
	
	/**
	 * This Method will write the data into Excel sheet
	 * @param sheet
	 * @param row
	 * @param cel
	 * @param 
	 * @throws Throwable
	 */
	
	public void writeDataIntoExcel(String sheet,int row,int cel,String value) throws Throwable 
	{
		FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheet);
		Row r = s.getRow(row);
		Cell c = r.createCell(cel);
		c.setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(IConstantsUtility.ExcelFilePath);
		wb.write(fos);
		wb.close();
	}
	
	/**
	 * This method will read all the data present in sheet and return 2 dimensional Object
	 * array which can be fed to data provider
	 * @param sheet
	 * @return
	 * @throws Throwable
	 */
	public Object[][] readMultipleDataFromExcel(String sheet) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCell];
		
		for(int i=0;i<=lastRow;i++)
		{
			for(int j=0;j<=lastCell;j++)
			{
				data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}

}
