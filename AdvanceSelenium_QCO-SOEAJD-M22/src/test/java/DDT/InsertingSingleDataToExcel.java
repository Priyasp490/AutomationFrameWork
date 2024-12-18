package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsertingSingleDataToExcel {

	public static void main(String[] args) throws Throwable {
			FileInputStream fis=new FileInputStream("C:\\Users\\malat\\OneDrive\\Documents\\TestData1.xlsx");//path connections
			Workbook book=WorkbookFactory.create(fis);//open workbook in read mode
			Sheet sheet=book.getSheet("Sheet1");//get the control of sheet
			//WebDriver driver=new ChromeDriver();
			//driver.get("https://www.flipkart.com");
			//driver.manage().window().maximize();
			//List<WebElement>allLinks = driver.findElements(By.xpath("//a"));
			
			//int rowNum=sheet.getLastRowNum()+1;
			//System.out.println(rowNum);
			//for(int i=0;i<allLinks.size();i++)
			//{
				Row row=sheet.createRow(2);//2//get the control of row
				
				//for(int j=0;j<row.getLastCellNum();j++)
				//{
				Cell cell=row.createCell(5);//5//get the control of cell
				cell.setCellValue("2024");//create value
				
				//String links=cell.getStringCellValue();
				//System.out.println(links);
				//}
			//}
			//keep work book in write mode
			FileOutputStream fos=new FileOutputStream("C:\\Users\\malat\\OneDrive\\Documents\\TestData1.xlsx");
			book.write(fos);
			book.close();
		
	}

}
