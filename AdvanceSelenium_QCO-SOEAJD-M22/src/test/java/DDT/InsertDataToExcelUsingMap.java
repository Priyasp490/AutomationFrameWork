package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertDataToExcelUsingMap {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("C:\\Users\\malat\\OneDrive\\Documents\\TestData1.xlsx");//path connections
		Workbook book=WorkbookFactory.create(fis);//open workbook in read mode
		Sheet sheet=book.getSheet("Sheet4");//get the control of sheet
		//WebDriver driver=new ChromeDriver();
        //driver.get("https://www.flipkart.com");
		//driver.manage().window().maximize();
		LinkedHashMap<String, String> map=new LinkedHashMap<String, String>();
		map.put("10", "hyderabad");
		map.put("20", "Bangalore");
		map.put("30", "Goa");
		map.put("40", "Pune");
		int rowNo=0;
		for(Entry<String, String>m:map.entrySet())//10, Pune
		{
			Row row=sheet.createRow(rowNo++);
			row.createCell(0).setCellValue((String)m.getKey());//10
			row.createCell(1).setCellValue((String)m.getValue());//Pune
		}
		//keep work book in write mode
		FileOutputStream fos=new FileOutputStream("C:\\Users\\malat\\OneDrive\\Documents\\TestData1.xlsx");
		book.write(fos);
		book.close();
		
		//.........................................................................................................................
		//LinkedHashMap<Integer, String> map=new LinkedHashMap<Integer, String>();
		//map.put(10, "sanjay");
		//map.put(20, "shobha");
		//map.put(30, "kalpana");
		//map.put(40, "sachin");
		//map.put(50, "deepak");
		
		//int rowNo=0;
		//for(Entry<Integer, String>m:map.entrySet())
		//{
			//Row row=sheet.createRow(rowNo++);
			//row.createCell(0).setCellValue((Integer)m.getKey());//10
			//row.createCell(1).setCellValue((String)m.getValue());//sanjay
		//}
		//keep work book in write mode
		//FileOutputStream fout=new FileOutputStream("C:\\Users\\malat\\OneDrive\\Documents\\TestData1.xlsx");
		//book.write(fout);
		//book.close();
		//System.out.println("data added successfully");
			

}

}
