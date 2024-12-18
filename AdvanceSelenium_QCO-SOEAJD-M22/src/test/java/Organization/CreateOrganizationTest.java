package Organization;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepo.CampDetailedPage;
import ObjectRepo.ValidateCampaignPage;
import ObjectRepo.ValidateOrganizationPage;
import ObjectRepo.CreateCampPage;
import ObjectRepo.CreateOrganizationPage;
import ObjectRepo.OrgDetailedPage;
import ObjectRepo.VtigerHomePage;

public class CreateOrganizationTest extends BaseClass {

@Test

	public void createOrganizationTest() throws Throwable {

		//WebDriver driver;
		//FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		//Properties pro = new Properties();
		//pro.load(fis);
		//String BROWSER = pro.getProperty("browser");
		//String URL = pro.getProperty("url");
		//String USERNAME = pro.getProperty("username");
		//String PASSWORD = pro.getProperty("password");
	    WebDriver_Utility wlib = new WebDriver_Utility();
	    Java_Utility jlib = new Java_Utility();
	    Excel_Utility elib = new Excel_Utility();
		File_Utility flib = new File_Utility();
		
		//String BROWSER = flib.getKeyAndValuePair("browser");
		//String URL = flib.getKeyAndValuePair("url");
		//String USERNAME = flib.getKeyAndValuePair("username");
		//String PASSWORD = flib.getKeyAndValuePair("password");

		//if (BROWSER.equalsIgnoreCase("chrome")) {
			//driver = new ChromeDriver();
		//} else if (BROWSER.equalsIgnoreCase("firefox")) {
			//driver = new FirefoxDriver();
		//} else if (BROWSER.equalsIgnoreCase("edge")) {
		//	driver = new EdgeDriver();
		//} else {
		//	driver = new ChromeDriver();
		//}

	//	driver.get(URL);
	//	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	//	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	//	driver.findElement(By.id("submitButton")).click();

	//	driver.findElement(By.linkText("Organizations")).click();
	//	driver.findElement(By.cssSelector("[alt=\"Create Organization...\"]")).click();
		
		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickMoreLink();
		home.clickOrgLink();

		OrgDetailedPage img = new OrgDetailedPage(driver);
		img.clickOrgLookUpImg();
//-----------------------------------------------------------------------------------------------------------
		// RanDom Class----->generating unique values(Avoid Duplicate value)
		//Random ran = new Random();
		//int ranNum = ran.nextInt(1000);
		int ranNum = jlib.getRandomNum();
//----------------------------------------------------------------------------------------------------------		
		// step1:- Path setting of the Excel file
	//	FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData11.xlsx");

		// step2:- keep the File in read mode
	//	Workbook book = WorkbookFactory.create(fis1);

		// step3:- Navigating to the sheet
	//	Sheet sheet = book.getSheet("Organization");

		// Step4:- Navigating to the Row
	//	Row row = sheet.getRow(0);

		// Step5:- Navigating to the Cell
	//	Cell cell = row.getCell(0);

	//	String OrgName = cell.getStringCellValue() + ranNum;
	//	System.out.println(OrgName);
// --------------------------------------------------------------------------------------------------------------------------------
	//	Row row1 = sheet.getRow(1);

		// Step5:- Navigating to the Cell
	//	Cell cell1 = row1.getCell(0);

	//	DataFormatter format1 = new DataFormatter();
	//	String phnNum = format1.formatCellValue(cell1);
	//	System.out.println(phnNum);
// ----------------------------------------------------------------------------------------------------------------------------
	//	Row row2 = sheet.getRow(2);

		// Step5:- Navigating to the Cell
	//	Cell cell2 = row2.getCell(0);

	//	DataFormatter format2 = new DataFormatter();
	//	String emailId = format2.formatCellValue(cell2);
	//	System.out.println(emailId);
//----------------------------------------------------------------------------------------------------------
	//	driver.findElement(By.name("accountname")).sendKeys(OrgName);
	//	driver.findElement(By.id("phone")).sendKeys(phnNum);
	//	driver.findElement(By.id("email1")).sendKeys(emailId);

	//	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//-------------------------------------------------------------------------------------------------------------
	//	Thread.sleep(2000);
	//	String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
	//	if (actData.contains(OrgName)) {
		//	System.out.println("Organization name is created");
		//	}
	//	else {
		//	System.out.println("Organization name is not created");
	//	}
//----------------------------------------------------------------------------------------------------------
	//	driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
	//	driver.findElement(By.linkText("Sign Out")).click();
		//String OrgName = elib.readExcelData("Organization", 0, 0) + ranNum;// getExcelData
		String OrgName = elib.getExcelDataUsingFormatter("Organization", 0, 0) + ranNum;// getExcelData
		String phnNum = elib.getExcelDataUsingFormatter("Organization", 1, 0) + ranNum;
		String emailId = elib.getExcelDataUsingFormatter("Organization", 2, 0) + ranNum;

		CreateOrganizationPage OrgPage = new CreateOrganizationPage(driver);
		OrgPage.enterOrgName(OrgName);
		OrgPage.enterPhnNum(phnNum);
		OrgPage.enterOrgName(emailId);
		//or
		//OrgPage.enterOrgData(OrgName, phnNum, emailId );
		OrgPage.clickSaveButton();
//.....................................................................................................	
		Thread.sleep(2000);
		ValidateOrganizationPage validate = new ValidateOrganizationPage(driver);
		String actData = validate.validateOrganization(driver,OrgName);
Assert.assertEquals(actData, OrgName);//OrgData
System.out.println("Organization name is not created");
		//home.logoutApp();
	}

}

/*
 package Organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import http://java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import http://org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrganization {

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

		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("[alt=\"Create Organization...\"]")).click();
//-----------------------------------------------------------------------------------------------------------
		// RanDom Class----->generating unique values(Avoid Duplicate value)
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
//----------------------------------------------------------------------------------------------------------		
		// step1:- Path setting of the Excel file
		FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData11.xlsx");

		// step2:- keep the File in read mode
		Workbook book = WorkbookFactory.create(fis1);

		// step3:- Navigating to the sheet
		Sheet sheet = book.getSheet("Organization");

		// Step4:- Navigating to the Row
		Row row = sheet.getRow(0);

		// Step5:- Navigating to the Cell
		Cell cell = row.getCell(0);

		String OrgName = cell.getStringCellValue() + ranNum;
		System.out.println(OrgName);
// --------------------------------------------------------------------------------------------------------------------------------
		Row row1 = sheet.getRow(1);

		// Step5:- Navigating to the Cell
		Cell cell1 = row1.getCell(0);

		DataFormatter format1 = new DataFormatter();
		String phnNum = format1.formatCellValue(cell1);
		System.out.println(phnNum);
// ----------------------------------------------------------------------------------------------------------------------------
		Row row2 = sheet.getRow(2);

		// Step5:- Navigating to the Cell
		Cell cell2 = row2.getCell(0);

		DataFormatter format2 = new DataFormatter();
		String emailId = format2.formatCellValue(cell2);
		System.out.println(emailId);
//----------------------------------------------------------------------------------------------------------
		driver.findElement(http://By.name("accountname")).sendKeys(OrgName);
		driver.findElement(http://By.id("phone")).sendKeys(phnNum);
		driver.findElement(http://By.id("email1")).sendKeys(emailId);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//-------------------------------------------------------------------------------------------------------------
		Thread.sleep(2000);
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		if (actData.contains(OrgName)) {
			System.out.println("Organization name is created");
			}
		else {
			System.out.println("Organization name is not created");
		}
//----------------------------------------------------------------------------------------------------------
		driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
	}

}
*/
 //.............................................................................................abstract
 /*
1. Login to vtiger application->click on organizations link->click on create organization lookup image->Enter organisation name,phone number and email->click on save Btn->verify whether the organization is created in Organization Information page and Logout from the application.


2. Login to vtiger application->click on products link->click on create product lookup image->Enter product name->click on save Btn->verify whether the product is created in product Information page and Logout from the application.

3. Login to vtiger application->mouseOverOn more Link->click on campaigns->click on create campaign lookup image->Enter campaignName->click on save Btn->verify whether the campaign is created in campaign Information page and Logout from the application.

4. Login to vtiger application->mouseOverOn more Link->click on campaigns->click on create campaign lookup image->Enter campaignName->Click on Product plus img->Handle the PopUp->Product name should be added to campaign createpage->
click on save Btn->verify whether the campaign is created in campaign Information page and Logout from the application.

5.Login to vtiger application->click on products link->click on create product lookup image->Enter product name->click on save Btn->verify whether the product is created in product Information page->click on product link->navigate to product table page ->select the product created checkbox->click on delete->Handle the Alert popup and verify product deleted or not and Logout from the application.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------

package Organization;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
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

public class CreateOrganization {

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
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("[alt=\"Create Organization...\"]")).click();

		//To Avoid Duplicates
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		
		
		// Step1:-get the connection of physical file
		FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData7am.xlsx");

		// step2:- open workbook in read mode
		Workbook book = WorkbookFactory.create(fis1);

		// step3:-get control of the Sheet
		Sheet sheet = book.getSheet("Organization");

		// step4:-get control of the row
		Row row = sheet.getRow(0);

		// step5:-get control of the cell
		Cell cel = row.getCell(0);

		// //step6:-read cell value
		String OrgName = cel.getStringCellValue()+ranNum;
		System.out.println(OrgName);
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		// --------------------------------------------------------------------------------------------

		// step4:-get control of the row
		Row row1 = sheet.getRow(1);

		// step5:-get control of the cell
		Cell cel1 = row1.getCell(0);

		DataFormatter format = new DataFormatter();
		String PhoneNum = format.formatCellValue(cel1);
		System.out.println(PhoneNum);
		driver.findElement(By.id("phone")).sendKeys(PhoneNum);
		
		//------------------------------------------------------------------------------------------
		Row row2 = sheet.getRow(2);

		// step5:-get control of the cell
		Cell cel2 = row2.getCell(0);

		// //step6:-read cell value
		String Email = cel2.getStringCellValue();
		System.out.println(Email);
		driver.findElement(By.id("email1")).sendKeys(Email);
		//-------------------------------------------------------------------------------------------
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		
		if(actData.contains(OrgName))
		{
			System.out.println("Organization Name is Created");
		}
		else
		{
			System.out.println("Organization name not created");
		}
		
		WebElement AmdLink = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		
		Actions act = new Actions(driver);
		act.moveToElement(AmdLink).perform();
		driver.findElement(By.linkText("Sign Out")).click();
}
}
*/
//......................
/*
 import java.io.FileInputStream;
import java.io.FileNotFoundException;
import http://java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import http://org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Uilities.Excel_Utility;
import Generic_Uilities.File_Utility;
import Generic_Uilities.Java_Utility;

public class CreateOrganization {

	public static void main(String[] args) throws Throwable {

		WebDriver driver;

		File_Utility flib = new File_Utility();
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
		driver.findElement(http://By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(http://By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(http://By.id("submitButton")).click();

		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("[alt=\"Create Organization...\"]")).click();
//-----------------------------------------------------------------------------------------------------------
		// RanDom Class----->generating unique values(Avoid Duplicate value)
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
//----------------------------------------------------------------------------------------------------------		

		Excel_Utility elib = new Excel_Utility();
		String OrgName = elib.readExcelData("Organization", 0, 0) + ranNum;
// --------------------------------------------------------------------------------------------------------------------------------

		String phnNum = elib.readExcelDataUsingDataFormatter("Organization", 1, 0);
// ----------------------------------------------------------------------------------------------------------------------------

		String emailId = elib.readExcelDataUsingDataFormatter("Organization", 2, 0);
//----------------------------------------------------------------------------------------------------------
		driver.findElement(http://By.name("accountname")).sendKeys(OrgName);
		driver.findElement(http://By.id("phone")).sendKeys(phnNum);
		driver.findElement(http://By.id("email1")).sendKeys(emailId);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//-------------------------------------------------------------------------------------------------------------
		Thread.sleep(2000);
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		if (actData.contains(OrgName)) {
			System.out.println("Organization name is created");
		} else {
			System.out.println("Organization name is not created");
		}
//----------------------------------------------------------------------------------------------------------
		driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
	}

}
 
 */
//.................
/*
package Organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
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

public class CreateOrganization {

	public static void main(String[] args) throws Throwable {

		WebDriver driver;

		File_Utility flib = new File_Utility();
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

		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("[alt=\"Create Organization...\"]")).click();
//-----------------------------------------------------------------------------------------------------------
		// RanDom Class----->generating unique values(Avoid Duplicate value)
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
//----------------------------------------------------------------------------------------------------------		

		Excel_Utility elib = new Excel_Utility();
		String OrgName = elib.readExcelData("Organization", 0, 0) + ranNum;
// --------------------------------------------------------------------------------------------------------------------------------

		String phnNum = elib.readExcelDataUsingDataFormatter("Organization", 1, 0);
// ----------------------------------------------------------------------------------------------------------------------------

		String emailId = elib.readExcelDataUsingDataFormatter("Organization", 2, 0);
//----------------------------------------------------------------------------------------------------------
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		driver.findElement(By.id("phone")).sendKeys(phnNum);
		driver.findElement(By.id("email1")).sendKeys(emailId);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//-------------------------------------------------------------------------------------------------------------
		Thread.sleep(2000);
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		if (actData.contains(OrgName)) {
			System.out.println("Organization name is created");
		} else {
			System.out.println("Organization name is not created");
		}
//----------------------------------------------------------------------------------------------------------
		driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
	}

}
*/
//.......................
/*
package Organization;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
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
import ObjectRepository.CreateOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrganizationNavigationPage;
import ObjectRepository.ValidateOrganization;

public class CreateOrganization {

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
		home.clickOrgLink();

		OrganizationNavigationPage orgPlus = new OrganizationNavigationPage(driver);
		orgPlus.clickOrgnization();

		int ranNum = jlib.getRandomNum();

		String OrgName = elib.getExcelData("Organization", 0, 0) + ranNum;
		System.out.println(OrgName);

		CreateOrganizationPage orgPage = new CreateOrganizationPage(driver);
		orgPage.enterOrgName(OrgName);

		// --------------------------------------------------------------------------------------------

		String PhoneNum = elib.getExcelDataUsingDataFormatter("Organization", 1, 0);
		System.out.println(PhoneNum);
		orgPage.enterPhnNum(PhoneNum);

		// ------------------------------------------------------------------------------------------

		String Email = elib.getExcelDataUsingDataFormatter("Organization", 2, 0);
		System.out.println(Email);
		orgPage.enterMailId(Email);

		// -------------------------------------------------------------------------------------------

                //or
                orgPage.enterOrgData(OrgName, PhoneNum, Email);
		

                orgPage.clickSaveButton();

		ValidateOrganization validate = new ValidateOrganization(driver);
		validate.validateOrgName(driver, OrgName);

		home.logOutFromApp();
	}

}
*/