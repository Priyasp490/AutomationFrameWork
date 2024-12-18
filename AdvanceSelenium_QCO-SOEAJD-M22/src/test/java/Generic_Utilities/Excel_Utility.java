/*package Generic_Utilities;
import java.io.FileInputStream;

import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
//public int getExcelData(String string, int i, int j) {
	// TODO Auto-generated method stub
	//return 0;
//}//or
	public String readExcelData(String sheetName, int RowNum, int CellNum) throws Throwable {
		// step1:- Path setting of the Excel file
		FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData11.xlsx");

		// step2:- keep the File in read mode
		Workbook book = WorkbookFactory.create(fis1);

		// step3:- Navigating to the sheet
		Sheet sheet = book.getSheet(sheetName);

		// Step4:- Navigating to the Row
		Row row = sheet.getRow(RowNum);

		// Step5:- Navigating to the Cell
		Cell cell = row.getCell(CellNum);

		String excelData = cell.getStringCellValue();
		System.out.println(excelData);
		return excelData;

	}

	public String readExcelDataUsingDataFormatter(String sheetName, int rowNum, int cellNum) throws Throwable {
		// step1:- Path setting of the Excel file
		FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData11.xlsx");

		// step2:- keep the File in read mode
		Workbook book = WorkbookFactory.create(fis1);

		// step3:- Navigating to the sheet
		Sheet sheet = book.getSheet(sheetName);

		// step4:- Navigating to the Row
		Row row1 = sheet.getRow(rowNum);

		// Step5:- Navigating to the Cell
		Cell cell1 = row1.getCell(cellNum);

		DataFormatter format1 = new DataFormatter();
		String excelData = format1.formatCellValue(cell1);
		System.out.println(excelData);
        return excelData;

	}

	
}*/
//................
/*
Excel Utility libraries 


	As per the rule of automation, data should not be hardcoded with in the test scripts, so that to get the data from external file like Excel & .propertes file 
We go for ExcelUtility & FileUtlity
	Excel Utility class is developed using apache Poi libraries, which is used to read the data from Excel 
	FileUtility is used to get the data from .properties file 
*/
package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility 
{

	/**
	 * it used to read data from excel
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * @author Shobha
	 */
	public  String readExcelData(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		 FileInputStream fis2 = new FileInputStream("./src/test/resources/TestData1.xlsx");
  	   
         //step2:-open workbook in read mode
  	Workbook book= WorkbookFactory.create(fis2);
  	
  	  //step3:-get the control of the Sheet
  	Sheet sheet = book.getSheet(sheetName);
  	
  	//step4:- get control of the row
  	Row row = sheet.getRow(rowNum);
  	
  	//step5:- get control of the cell
  	Cell cell = row.getCell(cellNum);
  	
  	String ExcelData = cell.getStringCellValue();
	return ExcelData;
	}
	
//*****************************************************************************
public String getExcelDataUsingFormatter(String SheetName,int rowNum,int celNum) throws Throwable
	{
		//Step1:- give Connection between the physical file and test script
		FileInputStream fis = new FileInputStream("C:\\Users\\malat\\eclipse-workspace\\AdvanceSelenium_QCO-SOEAJD-M22\\src\\test\\resources\\TestData1.xlsx");

		//step2:-keep excel file in read mode
		Workbook book = WorkbookFactory.create(fis);
	
	   //step3:-taking Control of the excel sheet
		Sheet sheet = book.getSheet(SheetName);
	
		//step4:-taking Control of the rows
		Row row = sheet.getRow(rowNum);
	
		//step5:-taking Control of the cell
		Cell cel = row.getCell(celNum);
		
		DataFormatter format = new DataFormatter();
		String ExcelData = format.formatCellValue(cel);
		System.out.println(ExcelData);
		return ExcelData;
		
	}
public Object[][] readExcelDataForDataProvider(String sheetName) throws Throwable

{
	FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData1.xlsx");

	Workbook book = WorkbookFactory.create(fis1);

	Sheet sheet = book.getSheet(sheetName);

	int lastRow = sheet.getLastRowNum() + 1;
	int lastCell = sheet.getRow(0).getLastCellNum();

	Object[][] obj = new Object[lastRow][lastCell];

	for (int i = 0; i < lastRow; i++) {
		for (int j = 0; j < lastCell; j++) {
			obj[i][j] = sheet.getRow(i).getCell(j).toString();
		}
	}
	return obj; 
}


}
