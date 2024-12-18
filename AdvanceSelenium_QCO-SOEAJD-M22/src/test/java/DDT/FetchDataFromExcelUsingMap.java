package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcelUsingMap {

	public static void main(String[] args) throws Throwable {
		//path connections
		//FileInputStream fis=new FileInputStream("‪C:\Users\malat\Downloads\TestData1.xlsx);//ExcelTestData
		//FileInputStream fis=new FileInputStream("./src/test/resources/TestData1.xlsx");
		FileInputStream fis=new FileInputStream("C:\\Users\\malat\\OneDrive\\Documents\\TestData1.xlsx");
		//open workbook in read mode
		Workbook book=WorkbookFactory.create(fis);
		//get the control of the sheet
		Sheet sheet=book.getSheet("Sheet2");
		int rows=sheet.getLastRowNum();//50
		//int rowNum=sheet.getLastRowNum();
		System.out.println(rows);
		
		LinkedHashMap<String, String> map=new LinkedHashMap<String, String>();
		
		for(int i=0;i<=rows;i++)
		{
			String key=sheet.getRow(i).getCell(0).toString();

			String value=sheet.getRow(i).getCell(1).toString();
			map.put(key, value);
		}
		for(Entry<String, String>m:map.entrySet())
		{
			System.out.println(m.getKey()+""+m.getValue());
		}
	}
}
		