package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingDataFromExcelUsingDataFormatter {//reading

	public static void main(String[] args) throws Throwable {
		//path connections
		//FileInputStream fis=new FileInputStream("‪C:\Users\malat\Downloads\TestData1.xlsx);
		//FileInputStream fis=new FileInputStream("./src/test/resources/TestData1.xlsx");
		FileInputStream fis=new FileInputStream("C:\\Users\\malat\\OneDrive\\Documents\\TestData1.xlsx");
		//open workbook in read mode
		Workbook book=WorkbookFactory.create(fis);
		//get the control of the sheet
		Sheet sheet=book.getSheet("Sheet3");
		int rowNum=sheet.getLastRowNum();
		System.out.println(rowNum);
		for(int i=0;i<rowNum;i++)
		{
			//get control of the row
			Row row=sheet.getRow(i);//0
			for(int j=0;j<row.getLastCellNum();j++)
			{
			//get control of the cell
			Cell cell=row.getCell(j);
			//String link=cell.getStringCellValue();
			//System.out.println(link);//excel data
			DataFormatter format = new DataFormatter();
			String link=format.formatCellValue(cell);
			System.out.println(link);
			//
			//}
			
		}
		
		}
	}}



