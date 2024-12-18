package DDT;

import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingSingleDataFromExcel {

	public static void main(String[] args) throws Throwable {
		//path connections
		//FileInputStream fis=new FileInputStream("‪C:\Users\malat\Downloads\TestData1.xlsx);
		//FileInputStream fis=new FileInputStream("./src/test/resources/TestData1.xlsx");
		FileInputStream fis=new FileInputStream("C:\\Users\\malat\\OneDrive\\Documents\\TestData1.xlsx");
		//open workbook in read mode
		Workbook book=WorkbookFactory.create(fis);
		//get the control of the sheet
		Sheet sheet=book.getSheet("Sheet1");
		//int rowNum=sheet.getLastRowNum()+1;
		//System.out.println(rowNum);
		//for(int i=0;i<rowNum;i++)
		//{
			//get control of the row
			Row row=sheet.getRow(6);//i
			//for(int j=0;j<row.getLastCellNum();j++)
			//{
			//get control of the cell
			Cell cell=row.getCell(0);//4
			String links=cell.getStringCellValue();
			System.out.println(links);//excel data
			//DataFormatter format = new DataFormatter();
			//String links=format.formatCellValue(cell);
			//System.out.println(links);
			//
			//}
			
		}
		
}
