package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateProduct {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver;
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonDatas.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String BROWSER = pro.getProperty("browser");
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.cssSelector("[title=\"Create Product...\"]")).click();
		
		// RanDom Class----->generating unique values(Avoid Duplicate value)
				Random ran = new Random();
				int ranNum = ran.nextInt(1000);
		//----------------------------------------------------------------------------------------------------------		
				// step1:- Path setting of the Excel file
				FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData11.xlsx");

				// step2:- keep the File in read mode
				Workbook book = WorkbookFactory.create(fis1);

				// step3:- Navigating to the sheet
				Sheet sheet = book.getSheet("Product");

				// Step4:- Navigating to the Row
				Row row = sheet.getRow(0);

				// Step5:- Navigating to the Cell
				Cell cell = row.getCell(0);

				String PrdName = cell.getStringCellValue() + ranNum;
				System.out.println(PrdName);
		
				driver.findElement(By.name("productname")).sendKeys(PrdName);
				
				driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
				Thread.sleep(2000);
                String actData = driver.findElement(By.id("dtlview_Product Name")).getText();
                
                if(actData.contains(PrdName))
                {
                	System.out.println("Product Name is created");
                }
                else
                {
                	System.out.println("Product Name is not Created");
                }
                driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
                driver.findElement(By.linkText("Sign Out")).click();
	}

}
/*
 
package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import http://java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import http://org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateProduct {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver;
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonDatas.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String BROWSER = pro.getProperty("browser");
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.get(URL);
		driver.findElement(http://By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(http://By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(http://By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.cssSelector("[title=\"Create Product...\"]")).click();
		
		// RanDom Class----->generating unique values(Avoid Duplicate value)
				Random ran = new Random();
				int ranNum = ran.nextInt(1000);
		//----------------------------------------------------------------------------------------------------------		
				// step1:- Path setting of the Excel file
				FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData11.xlsx");

				// step2:- keep the File in read mode
				Workbook book = WorkbookFactory.create(fis1);

				// step3:- Navigating to the sheet
				Sheet sheet = book.getSheet("Product");

				// Step4:- Navigating to the Row
				Row row = sheet.getRow(0);

				// Step5:- Navigating to the Cell
				Cell cell = row.getCell(0);

				String PrdName = cell.getStringCellValue() + ranNum;
				System.out.println(PrdName);
		
				driver.findElement(http://By.name("productname")).sendKeys(PrdName);
				
				driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
				Thread.sleep(2000);
                String actData = driver.findElement(http://By.id("dtlview_Product Name")).getText();
                
                if(actData.contains(PrdName))
                {
                	System.out.println("Product Name is created");
                }
                else
                {
                	System.out.println("Product Name is not Created");
                }
                driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
                driver.findElement(By.linkText("Sign Out")).click();
	}

}
 
 */
/*
 package Product;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateProduct {

	public static void main(String[] args) throws Throwable {

		// step1:- get the file path connection
		FileInputStream fis = new FileInputStream("C:\\Users\\Shobha\\Downloads\\Properties_Data7am.properties");

		// step2:- load all the keys
		Properties pro = new Properties();
		pro.load(fis);

		// step3:- read key value
		String BROWSER = pro.getProperty("browser");
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");

		WebDriver driver;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();
		}
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.linkText("Products")).click();

		driver.findElement(By.xpath("//img[@title=\"Create Product...\"]")).click();

		// To Avoid Duplicates
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);

		// Step1:-get the connection of physical file
		FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData7am.xlsx");

		// step2:- open workbook in read mode
		Workbook book = WorkbookFactory.create(fis1);

		// step3:-get control of the Sheet
		Sheet sheet = book.getSheet("Product");

		// step4:-get control of the row
		Row row = sheet.getRow(0);

		// step5:-get control of the cell
		Cell cel = row.getCell(0);

		// //step6:-read cell value
		String PrdName = cel.getStringCellValue() + ranNum;
		System.out.println(PrdName);

		driver.findElement(By.name("productname")).sendKeys(PrdName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();

		if (actData.equals(PrdName)) {
			System.out.println("Product Name is Created");
		} else {
			System.out.println("Product name is not created");
		}

		WebElement AmdLink = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));

		Actions act = new Actions(driver);
		act.moveToElement(AmdLink).perform();
		driver.findElement(By.linkText("Sign Out")).click();
	}

}
===================================================================================================================================================================

 */
/*
 package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateProductAndDeleteProduct {

	public static void main(String[] args) throws Throwable {
		// step1:- get the file path connection
		FileInputStream fis = new FileInputStream("C:\\Users\\Shobha\\Downloads\\Properties_Data7am.properties");

		// step2:- load all the keys
		Properties pro = new Properties();
		pro.load(fis);

		// step3:- read key value
		String BROWSER = pro.getProperty("browser");
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");

		WebDriver driver;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();
		}
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.linkText("Products")).click();

		driver.findElement(By.xpath("//img[@title=\"Create Product...\"]")).click();

		// To Avoid Duplicates
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);

		// Step1:-get the connection of physical file
		FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData7am.xlsx");

		// step2:- open workbook in read mode
		Workbook book = WorkbookFactory.create(fis1);

		// step3:-get control of the Sheet
		Sheet sheet = book.getSheet("Product");

		// step4:-get control of the row
		Row row = sheet.getRow(0);

		// step5:-get control of the cell
		Cell cel = row.getCell(0);

		// //step6:-read cell value
		String PrdName = cel.getStringCellValue() + ranNum;
		System.out.println(PrdName);

		driver.findElement(By.name("productname")).sendKeys(PrdName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();

		if (actData.equals(PrdName)) {
			System.out.println("Product Name is Created");
		} else {
			System.out.println("Product name is not created");
		}

		// -------------------------------------------------------------------------------------------------------------------------
		// Navigating to product table
		driver.findElement(By.xpath("//a[text()='Products']")).click();

		// driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='Product
		// Name']/../preceding-sibling::td//input[@type='checkbox']")).click();
driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='"+PrdName+"']/../preceding-sibling::td//input[@type='checkbox']")).click();
	
	driver.findElement(By.xpath("//input[@value=\"Delete\"]")).click();
	
	driver.switchTo().alert().accept();
	
	
	WebElement prd=driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='"+PrdName+"']"));
    if(prd.equals(PrdName))
	{
		System.out.println("Product Name is Present");
	}
	else
	{
		System.out.println("Product name is not Present");
	}
    
	WebElement AmdLink = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));

	Actions act = new Actions(driver);
	act.moveToElement(AmdLink).perform();
	driver.findElement(By.linkText("Sign Out")).click();
	}
}
==================================================================================================================================================================

 */
 //.........................
/*
package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Uilities.Excel_Utility;
import Generic_Uilities.File_Utility;
import Generic_Uilities.Java_Utility;
import Generic_Uilities.WebDriver_Utility;

public class CreateProduct {

	public static void main(String[] args) throws Throwable {

		File_Utility flib = new File_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();

		WebDriver driver;

		String BROWSER = flib.getKeyAndValuePair("browser");
		String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
		String PASSWORD = flib.getKeyAndValuePair("password");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.cssSelector("[title=\"Create Product...\"]")).click();

		// RanDom Class----->generating unique values(Avoid Duplicate value)

		int ranNum = jlib.getRandomNum();
		// ----------------------------------------------------------------------------------------------------------

		String PrdName = elib.readExcelData("Product", 0, 0) + ranNum;
		System.out.println(PrdName);

		driver.findElement(By.name("productname")).sendKeys(PrdName);

		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();

		Thread.sleep(2000);
		String actData = driver.findElement(By.id("dtlview_Product Name")).getText();

		if (actData.contains(PrdName)) {
			System.out.println("Product Name is created");
		} else {
			System.out.println("Product Name is not Created");
		}
		driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
	}

}
*/
//.............
/*
package Product;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_utility;
import ObjectRepository.CreateProductPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.ProductLookUp;
import ObjectRepository.ValidatePrdName;

public class CreateProduct {

	public static void main(String[] args) throws Throwable {

		File_Utility flib = new File_Utility();
		WebDriver_utility wlib = new WebDriver_utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();

		String BROWSER = flib.getKeyAndValuePair("browser");
		String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
		String PASSWORD = flib.getKeyAndValuePair("password");

		WebDriver driver;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();
		}
		driver.get(URL);

		LoginPage login = new LoginPage(driver);
		login.loginToVtiger(USERNAME, PASSWORD);

		wlib.maximizeWindow(driver);
		wlib.waitForElementsToLoad(driver);

		HomePage home = new HomePage(driver);
		home.clickProductLink();

		ProductLookUp prd = new ProductLookUp(driver);
		prd.clickOnPlusSign();

		int ranNum = jlib.getRandomNum();

		String PrdName = elib.getExcelData("Product", 0, 0) + ranNum;
		System.out.println(PrdName);

		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.enterPrdName(PrdName);
		prdPage.clickSaveButton();

		ValidatePrdName validate = new ValidatePrdName(driver);
		validate.validatePrd(driver, PrdName);

		home.logOut(driver);
	}

}
*/