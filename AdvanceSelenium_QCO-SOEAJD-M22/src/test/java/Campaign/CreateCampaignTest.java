package Campaign;

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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepo.CampDetailedPage;
import ObjectRepo.ValidateCampaignPage;
import ObjectRepo.CreateCampPage;
import ObjectRepo.LoginVtigerPage;
import ObjectRepo.VtigerHomePage;
import junit.framework.Assert;
@Listeners(Generic_Utilities.ListenerImp.class)
public class CreateCampaignTest extends BaseClass {

	@Test(groups = {"smoke", "Regression"})
	public void createCampaignTest() throws Throwable {

		WebDriver_Utility wlib = new WebDriver_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
		File_Utility flib = new File_Utility();

	//	WebDriver driver;
	//	String BROWSER = flib.getKeyAndValuePair("browser");
		
	//	String URL = flib.getKeyAndValuePair("url");
	//	String USERNAME = flib.getKeyAndValuePair("username");
	//	String PASSWORD = flib.getKeyAndValuePair("password");
		//driver.get(URL);
//if (BROWSER.equalsIgnoreCase("chrome")) {
//	driver = new ChromeDriver();
// else if (BROWSER.equalsIgnoreCase("firefox")) {
//	driver = new FirefoxDriver();
// else if (BROWSER.equalsIgnoreCase("edge")) {
//	driver = new EdgeDriver();
// else {
//	driver = new ChromeDriver();}

           //using getter methods
		
		// using business logics
	//	LoginVtigerPage login = new LoginVtigerPage(driver);
	//	login.loginIntoVtiger(USERNAME, PASSWORD);

	//	wlib.maximizeWindow(driver);
	//	wlib.waitForPageToLoad(driver);

		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickMoreLink();
		home.clickCampLink();

		CampDetailedPage img = new CampDetailedPage(driver);
		img.clickCampLookUpImg();
       Assert.fail();
       System.out.println("Failing script");
		int ranNum = jlib.getRandomNum();
		//driver.findElement(By.cssSelector("[alt=\"create Campaign...\"]")).click();
		
		//Random Class-------> generating unique values(Avoid Duplicate value)
//----------------------------------------------------------------------------------------------------------		

		String CampName = elib.readExcelData("Campaign", 0, 0) + ranNum;// getExcelData

		CreateCampPage createPage = new CreateCampPage(driver);
		createPage.enterCampName(CampName);
		
		createPage.clickSaveButton();

		ValidateCampaignPage validate = new ValidateCampaignPage(driver);
		//validate.validateCampaign(driver, CampName);
        String actData=validate.validateCampaign(driver, CampName);
       // Assert.assertEquals(actData, CampName);
        System.out.println("Campaign Name is created");
		//home.logoutApp();
	}

}

/*
 * package Campaign;
 * 
 * import java.io.FileInputStream; import java.io.FileNotFoundException; import
 * java.util.Properties; import java.util.Random;
 * 
 * import org.apache.poi.ss.usermodel.Cell; import
 * org.apache.poi.ss.usermodel.Row; import org.apache.poi.ss.usermodel.Sheet;
 * import org.apache.poi.ss.usermodel.Workbook; import
 * org.apache.poi.ss.usermodel.WorkbookFactory; import org.openqa.selenium.By;
 * import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.edge.EdgeDriver; import
 * org.openqa.selenium.firefox.FirefoxDriver;
 * 
 * public class CreateCampaign {
 * 
 * public static void main(String[] args) throws Throwable {
 * 
 * WebDriver driver; FileInputStream fis = new
 * FileInputStream("./src/test/resources/CommonDatas.properties"); Properties
 * pro = new Properties(); pro.load(fis); String BROWSER =
 * pro.getProperty("browser"); String URL = pro.getProperty("url"); String
 * USERNAME = pro.getProperty("username"); String PASSWORD =
 * pro.getProperty("password");
 * 
 * if (BROWSER.equalsIgnoreCase("chrome")) { driver = new ChromeDriver(); } else
 * if (BROWSER.equalsIgnoreCase("firefox")) { driver = new FirefoxDriver(); }
 * else if (BROWSER.equalsIgnoreCase("edge")) { driver = new EdgeDriver(); }
 * else { driver = new ChromeDriver(); }
 * 
 * driver.get(URL); driver.findElement(By.name("user_name")).sendKeys(USERNAME);
 * driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
 * driver.findElement(By.id("submitButton")).click();
 * 
 * driver.findElement(By.linkText("More")).click();
 * driver.findElement(By.linkText("Campaigns")).click();
 * 
 * driver.findElement(By.cssSelector("[alt=\"Create Campaign...\"]")).click();
 * 
 * // RanDom Class----->generating unique values(Avoid Duplicate value) Random
 * ran = new Random(); int ranNum = ran.nextInt(1000);
 * //---------------------------------------------------------------------------
 * ------------------------------- // step1:- Path setting of the Excel file
 * FileInputStream fis1 = new
 * FileInputStream("./src/test/resources/TestData11.xlsx");
 * 
 * // step2:- keep the File in read mode Workbook book =
 * WorkbookFactory.create(fis1);
 * 
 * // step3:- Navigating to the sheet Sheet sheet = book.getSheet("Campaign");
 * 
 * // Step4:- Navigating to the Row Row row = sheet.getRow(0);
 * 
 * // Step5:- Navigating to the Cell Cell cell = row.getCell(0);
 * 
 * String CampName = cell.getStringCellValue() + ranNum;
 * System.out.println(CampName);
 * 
 * driver.findElement(By.name("campaignname")).sendKeys(CampName);
 * driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();
 * 
 * String actData =
 * driver.findElement(By.id("dtlview_Campaign Name")).getText();
 * 
 * if(actData.contains(CampName)) {
 * System.out.println("Campaign Name is Created"); } else {
 * System.out.println("Campaign Name is not Created"); }
 * 
 * driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]"))
 * .click(); driver.findElement(By.linkText("Sign Out")).click(); }
 * 
 * } /* import java.io.FileInputStream; import java.io.FileNotFoundException;
 * import http://java.util.Properties; import java.util.Random;
 * 
 * import org.apache.poi.ss.usermodel.Cell; import
 * org.apache.poi.ss.usermodel.Row; import org.apache.poi.ss.usermodel.Sheet;
 * import org.apache.poi.ss.usermodel.Workbook; import
 * org.apache.poi.ss.usermodel.WorkbookFactory; import
 * http://org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.edge.EdgeDriver; import
 * org.openqa.selenium.firefox.FirefoxDriver;
 * 
 * public class CreateCampaign {
 * 
 * public static void main(String[] args) throws Throwable {
 * 
 * WebDriver driver; FileInputStream fis = new
 * FileInputStream("./src/test/resources/CommonDatas.properties"); Properties
 * pro = new Properties(); pro.load(fis); String BROWSER =
 * pro.getProperty("browser"); String URL = pro.getProperty("url"); String
 * USERNAME = pro.getProperty("username"); String PASSWORD =
 * pro.getProperty("password");
 * 
 * if (BROWSER.equalsIgnoreCase("chrome")) { driver = new ChromeDriver(); } else
 * if (BROWSER.equalsIgnoreCase("firefox")) { driver = new FirefoxDriver(); }
 * else if (BROWSER.equalsIgnoreCase("edge")) { driver = new EdgeDriver(); }
 * else { driver = new ChromeDriver(); }
 * 
 * driver.get(URL);
 * driver.findElement(http://By.name("user_name")).sendKeys(USERNAME);
 * driver.findElement(http://By.name("user_password")).sendKeys(PASSWORD);
 * driver.findElement(http://By.id("submitButton")).click();
 * 
 * driver.findElement(By.linkText("More")).click();
 * driver.findElement(By.linkText("Campaigns")).click();
 * 
 * driver.findElement(By.cssSelector("[alt=\"Create Campaign...\"]")).click();
 * 
 * // RanDom Class----->generating unique values(Avoid Duplicate value) Random
 * ran = new Random(); int ranNum = ran.nextInt(1000);
 * //---------------------------------------------------------------------------
 * ------------------------------- // step1:- Path setting of the Excel file
 * FileInputStream fis1 = new
 * FileInputStream("./src/test/resources/TestData11.xlsx");
 * 
 * // step2:- keep the File in read mode Workbook book =
 * WorkbookFactory.create(fis1);
 * 
 * // step3:- Navigating to the sheet Sheet sheet = book.getSheet("Campaign");
 * 
 * // Step4:- Navigating to the Row Row row = sheet.getRow(0);
 * 
 * // Step5:- Navigating to the Cell Cell cell = row.getCell(0);
 * 
 * String CampName = cell.getStringCellValue() + ranNum;
 * System.out.println(CampName);
 * 
 * driver.findElement(http://By.name("campaignname")).sendKeys(CampName);
 * driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();
 * 
 * String actData =
 * driver.findElement(http://By.id("dtlview_Campaign Name")).getText();
 * 
 * if(actData.contains(CampName)) {
 * System.out.println("Campaign Name is Created"); } else {
 * System.out.println("Campaign Name is not Created"); }
 * 
 * driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]"))
 * .click(); driver.findElement(By.linkText("Sign Out")).click(); }
 * 
 * 
 * }
 */

//..............................................................................................................

/*
 * package Campaign;
 * 
 * import java.io.FileInputStream; import java.io.FileNotFoundException; import
 * http://java.util.Properties; import java.util.Random;
 * 
 * import org.apache.poi.ss.usermodel.Cell; import
 * org.apache.poi.ss.usermodel.Row; import org.apache.poi.ss.usermodel.Sheet;
 * import org.apache.poi.ss.usermodel.Workbook; import
 * org.apache.poi.ss.usermodel.WorkbookFactory; import
 * http://org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.edge.EdgeDriver; import
 * org.openqa.selenium.firefox.FirefoxDriver;
 * 
 * public class CreateCampaign {
 * 
 * public static void main(String[] args) throws Throwable {
 * 
 * WebDriver driver; FileInputStream fis = new
 * FileInputStream("./src/test/resources/CommonDatas.properties"); Properties
 * pro = new Properties(); pro.load(fis); String BROWSER =
 * pro.getProperty("browser"); String URL = pro.getProperty("url"); String
 * USERNAME = pro.getProperty("username"); String PASSWORD =
 * pro.getProperty("password");
 * 
 * if (BROWSER.equalsIgnoreCase("chrome")) { driver = new ChromeDriver(); } else
 * if (BROWSER.equalsIgnoreCase("firefox")) { driver = new FirefoxDriver(); }
 * else if (BROWSER.equalsIgnoreCase("edge")) { driver = new EdgeDriver(); }
 * else { driver = new ChromeDriver(); }
 * 
 * driver.get(URL);
 * driver.findElement(http://By.name("user_name")).sendKeys(USERNAME);
 * driver.findElement(http://By.name("user_password")).sendKeys(PASSWORD);
 * driver.findElement(http://By.id("submitButton")).click();
 * 
 * driver.findElement(By.linkText("More")).click();
 * driver.findElement(By.linkText("Campaigns")).click();
 * 
 * driver.findElement(By.cssSelector("[alt=\"Create Campaign...\"]")).click();
 * 
 * // RanDom Class----->generating unique values(Avoid Duplicate value) Random
 * ran = new Random(); int ranNum = ran.nextInt(1000);
 * //---------------------------------------------------------------------------
 * ------------------------------- // step1:- Path setting of the Excel file
 * FileInputStream fis1 = new
 * FileInputStream("./src/test/resources/TestData11.xlsx");
 * 
 * // step2:- keep the File in read mode Workbook book =
 * WorkbookFactory.create(fis1);
 * 
 * // step3:- Navigating to the sheet Sheet sheet = book.getSheet("Campaign");
 * 
 * // Step4:- Navigating to the Row Row row = sheet.getRow(0);
 * 
 * // Step5:- Navigating to the Cell Cell cell = row.getCell(0);
 * 
 * String CampName = cell.getStringCellValue() + ranNum;
 * System.out.println(CampName);
 * 
 * driver.findElement(http://By.name("campaignname")).sendKeys(CampName);
 * driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();
 * 
 * String actData =
 * driver.findElement(http://By.id("dtlview_Campaign Name")).getText();
 * 
 * if(actData.contains(CampName)) {
 * System.out.println("Campaign Name is Created"); } else {
 * System.out.println("Campaign Name is not Created"); }
 * 
 * driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]"))
 * .click(); driver.findElement(By.linkText("Sign Out")).click(); }
 * 
 * 
 * }
 * 
 */
//..........................
/*
 * package Campaign;
 * 
 * import java.io.FileInputStream; import java.io.FileNotFoundException; import
 * java.util.Iterator; import http://java.util.Properties; import
 * java.util.Random; import java.util.Set;
 * 
 * import org.apache.poi.ss.usermodel.Cell; import
 * org.apache.poi.ss.usermodel.Row; import org.apache.poi.ss.usermodel.Sheet;
 * import org.apache.poi.ss.usermodel.Workbook; import
 * org.apache.poi.ss.usermodel.WorkbookFactory; import
 * http://org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.edge.EdgeDriver; import
 * org.openqa.selenium.firefox.FirefoxDriver;
 * 
 * public class CreateCampaignWithProduct {
 * 
 * public static void main(String[] args) throws Throwable {
 * 
 * WebDriver driver; FileInputStream fis = new
 * FileInputStream("./src/test/resources/CommonDatas.properties"); Properties
 * pro = new Properties(); pro.load(fis); String BROWSER =
 * pro.getProperty("browser"); String URL = pro.getProperty("url"); String
 * USERNAME = pro.getProperty("username"); String PASSWORD =
 * pro.getProperty("password");
 * 
 * if (BROWSER.equalsIgnoreCase("chrome")) { driver = new ChromeDriver(); } else
 * if (BROWSER.equalsIgnoreCase("firefox")) { driver = new FirefoxDriver(); }
 * else if (BROWSER.equalsIgnoreCase("edge")) { driver = new EdgeDriver(); }
 * else { driver = new ChromeDriver(); }
 * 
 * driver.get(URL);
 * driver.findElement(http://By.name("user_name")).sendKeys(USERNAME);
 * driver.findElement(http://By.name("user_password")).sendKeys(PASSWORD);
 * driver.findElement(http://By.id("submitButton")).click();
 * 
 * driver.findElement(By.linkText("Products")).click();
 * driver.findElement(By.cssSelector("[title=\"Create Product...\"]")).click();
 * 
 * // RanDom Class----->generating unique values(Avoid Duplicate value) Random
 * ran = new Random(); int ranNum = ran.nextInt(1000); //
 * -----------------------------------------------------------------------------
 * ----------------------------- // step1:- Path setting of the Excel file
 * FileInputStream fis1 = new
 * FileInputStream("./src/test/resources/TestData11.xlsx");
 * 
 * // step2:- keep the File in read mode Workbook book =
 * WorkbookFactory.create(fis1);
 * 
 * // step3:- Navigating to the sheet Sheet sheet = book.getSheet("Product");
 * 
 * // Step4:- Navigating to the Row Row row = sheet.getRow(0);
 * 
 * // Step5:- Navigating to the Cell Cell cell = row.getCell(0);
 * 
 * String PrdName = cell.getStringCellValue() + ranNum;
 * System.out.println(PrdName);
 * 
 * driver.findElement(http://By.name("productname")).sendKeys(PrdName);
 * 
 * driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
 * //---------------------------------------------------------------------------
 * --------------------------- driver.findElement(By.linkText("More")).click();
 * driver.findElement(By.linkText("Campaigns")).click();
 * 
 * driver.findElement(By.cssSelector("[alt=\"Create Campaign...\"]")).click();
 * 
 * // RanDom Class----->generating unique values(Avoid Duplicate value) Random
 * ran1 = new Random(); int ranNum1 = ran1.nextInt(1000); //
 * -----------------------------------------------------------------------------
 * ----------------------------- // step1:- Path setting of the Excel file
 * FileInputStream fis2 = new
 * FileInputStream("./src/test/resources/TestData11.xlsx");
 * 
 * // step2:- keep the File in read mode Workbook book1 =
 * WorkbookFactory.create(fis2);
 * 
 * // step3:- Navigating to the sheet Sheet sheet1 = book1.getSheet("Campaign");
 * 
 * // Step4:- Navigating to the Row Row row1 = sheet1.getRow(0);
 * 
 * // Step5:- Navigating to the Cell Cell cell1 = row1.getCell(0);
 * 
 * String CampName = cell1.getStringCellValue() + ranNum1;
 * System.out.println(CampName);
 * 
 * driver.findElement(http://By.name("campaignname")).sendKeys(CampName);
 * 
 * driver.findElement(By.cssSelector("[alt=\"Select\"]")).click();
 * 
 * Set<String> allWins = driver.getWindowHandles(); Iterator<String> id =
 * allWins.iterator();
 * 
 * while (id.hasNext()) { String win = http://id.next();
 * driver.switchTo().window(win); String title = driver.getTitle(); if
 * (title.contains("Products&action"))
 * 
 * { break; } }
 * driver.findElement(http://By.name("search_text")).sendKeys(PrdName);
 * driver.findElement(http://By.name("search")).click(); Thread.sleep(2000);
 * 
 * //Dynamic xpath
 * driver.findElement(By.xpath("//a[text()='"+PrdName+"']")).click();
 * 
 * Set<String> allWins1 = driver.getWindowHandles(); Iterator<String> id1 =
 * allWins1.iterator();
 * 
 * while (id1.hasNext()) { String win1 = http://id1.next();
 * driver.switchTo().window(win1); String title1 = driver.getTitle(); if
 * (title1.contains("Campaigns&action"))
 * 
 * { break; } }
 * driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();
 * 
 * String actData =
 * driver.findElement(http://By.id("dtlview_Campaign Name")).getText();
 * 
 * if(actData.contains(CampName)) {
 * System.out.println("Campaign Name is Created"); } else {
 * System.out.println("Campaign Name is not Created"); }
 * 
 * //---------------------------------------------------------------------------
 * ---------- String actData1 =
 * driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();
 * 
 * if(actData1.contains(PrdName)) {
 * System.out.println("Product Name is created"); } else {
 * System.out.println("Product Name is not Created"); }
 * driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]"))
 * .click(); driver.findElement(By.linkText("Sign Out")).click(); }
 * 
 * }
 */
/*
 * package Campaign;
 * 
 * import java.io.FileInputStream; import java.io.FileNotFoundException; import
 * java.util.Iterator; import http://java.util.Properties; import
 * java.util.Random; import java.util.Set;
 * 
 * import org.apache.poi.ss.usermodel.Cell; import
 * org.apache.poi.ss.usermodel.Row; import org.apache.poi.ss.usermodel.Sheet;
 * import org.apache.poi.ss.usermodel.Workbook; import
 * org.apache.poi.ss.usermodel.WorkbookFactory; import
 * http://org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.edge.EdgeDriver; import
 * org.openqa.selenium.firefox.FirefoxDriver;
 * 
 * public class CreateCampaignWithProduct {
 * 
 * public static void main(String[] args) throws Throwable {
 * 
 * WebDriver driver; FileInputStream fis = new
 * FileInputStream("./src/test/resources/CommonDatas.properties"); Properties
 * pro = new Properties(); pro.load(fis); String BROWSER =
 * pro.getProperty("browser"); String URL = pro.getProperty("url"); String
 * USERNAME = pro.getProperty("username"); String PASSWORD =
 * pro.getProperty("password");
 * 
 * if (BROWSER.equalsIgnoreCase("chrome")) { driver = new ChromeDriver(); } else
 * if (BROWSER.equalsIgnoreCase("firefox")) { driver = new FirefoxDriver(); }
 * else if (BROWSER.equalsIgnoreCase("edge")) { driver = new EdgeDriver(); }
 * else { driver = new ChromeDriver(); }
 * 
 * driver.get(URL);
 * driver.findElement(http://By.name("user_name")).sendKeys(USERNAME);
 * driver.findElement(http://By.name("user_password")).sendKeys(PASSWORD);
 * driver.findElement(http://By.id("submitButton")).click();
 * 
 * driver.findElement(By.linkText("Products")).click();
 * driver.findElement(By.cssSelector("[title=\"Create Product...\"]")).click();
 * 
 * // RanDom Class----->generating unique values(Avoid Duplicate value) Random
 * ran = new Random(); int ranNum = ran.nextInt(1000); //
 * -----------------------------------------------------------------------------
 * ----------------------------- // step1:- Path setting of the Excel file
 * FileInputStream fis1 = new
 * FileInputStream("./src/test/resources/TestData11.xlsx");
 * 
 * // step2:- keep the File in read mode Workbook book =
 * WorkbookFactory.create(fis1);
 * 
 * // step3:- Navigating to the sheet Sheet sheet = book.getSheet("Product");
 * 
 * // Step4:- Navigating to the Row Row row = sheet.getRow(0);
 * 
 * // Step5:- Navigating to the Cell Cell cell = row.getCell(0);
 * 
 * String PrdName = cell.getStringCellValue() + ranNum;
 * System.out.println(PrdName);
 * 
 * driver.findElement(http://By.name("productname")).sendKeys(PrdName);
 * 
 * driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
 * //---------------------------------------------------------------------------
 * --------------------------- driver.findElement(By.linkText("More")).click();
 * driver.findElement(By.linkText("Campaigns")).click();
 * 
 * driver.findElement(By.cssSelector("[alt=\"Create Campaign...\"]")).click();
 * 
 * // RanDom Class----->generating unique values(Avoid Duplicate value) Random
 * ran1 = new Random(); int ranNum1 = ran1.nextInt(1000); //
 * -----------------------------------------------------------------------------
 * ----------------------------- // step1:- Path setting of the Excel file
 * FileInputStream fis2 = new
 * FileInputStream("./src/test/resources/TestData11.xlsx");
 * 
 * // step2:- keep the File in read mode Workbook book1 =
 * WorkbookFactory.create(fis2);
 * 
 * // step3:- Navigating to the sheet Sheet sheet1 = book1.getSheet("Campaign");
 * 
 * // Step4:- Navigating to the Row Row row1 = sheet1.getRow(0);
 * 
 * // Step5:- Navigating to the Cell Cell cell1 = row1.getCell(0);
 * 
 * String CampName = cell1.getStringCellValue() + ranNum1;
 * System.out.println(CampName);
 * 
 * driver.findElement(http://By.name("campaignname")).sendKeys(CampName);
 * 
 * driver.findElement(By.cssSelector("[alt=\"Select\"]")).click();
 * 
 * Set<String> allWins = driver.getWindowHandles(); Iterator<String> id =
 * allWins.iterator();
 * 
 * while (id.hasNext()) { String win = http://id.next();
 * driver.switchTo().window(win); String title = driver.getTitle(); if
 * (title.contains("Products&action"))
 * 
 * { break; } }
 * driver.findElement(http://By.name("search_text")).sendKeys(PrdName);
 * driver.findElement(http://By.name("search")).click(); Thread.sleep(2000);
 * 
 * //Dynamic xpath
 * driver.findElement(By.xpath("//a[text()='"+PrdName+"']")).click();
 * 
 * Set<String> allWins1 = driver.getWindowHandles(); Iterator<String> id1 =
 * allWins1.iterator();
 * 
 * while (id1.hasNext()) { String win1 = http://id1.next();
 * driver.switchTo().window(win1); String title1 = driver.getTitle(); if
 * (title1.contains("Campaigns&action"))
 * 
 * { break; } }
 * driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();
 * 
 * String actData =
 * driver.findElement(http://By.id("dtlview_Campaign Name")).getText();
 * 
 * if(actData.contains(CampName)) {
 * System.out.println("Campaign Name is Created"); } else {
 * System.out.println("Campaign Name is not Created"); }
 * 
 * //---------------------------------------------------------------------------
 * ---------- String actData1 =
 * driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();
 * 
 * if(actData1.contains(PrdName)) {
 * System.out.println("Product Name is created"); } else {
 * System.out.println("Product Name is not Created"); }
 * driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]"))
 * .click(); driver.findElement(By.linkText("Sign Out")).click(); }
 * 
 * }
 * 
 */
/*
 * package Campaign;
 * 
 * import java.io.FileInputStream; import java.io.FileNotFoundException; import
 * java.util.Iterator; import http://java.util.Properties; import
 * java.util.Random; import java.util.Set;
 * 
 * import org.apache.poi.ss.usermodel.Cell; import
 * org.apache.poi.ss.usermodel.Row; import org.apache.poi.ss.usermodel.Sheet;
 * import org.apache.poi.ss.usermodel.Workbook; import
 * org.apache.poi.ss.usermodel.WorkbookFactory; import
 * http://org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.edge.EdgeDriver; import
 * org.openqa.selenium.firefox.FirefoxDriver;
 * 
 * public class CreateCampaignWithProduct {
 * 
 * public static void main(String[] args) throws Throwable {
 * 
 * WebDriver driver; FileInputStream fis = new
 * FileInputStream("./src/test/resources/CommonDatas.properties"); Properties
 * pro = new Properties(); pro.load(fis); String BROWSER =
 * pro.getProperty("browser"); String URL = pro.getProperty("url"); String
 * USERNAME = pro.getProperty("username"); String PASSWORD =
 * pro.getProperty("password");
 * 
 * if (BROWSER.equalsIgnoreCase("chrome")) { driver = new ChromeDriver(); } else
 * if (BROWSER.equalsIgnoreCase("firefox")) { driver = new FirefoxDriver(); }
 * else if (BROWSER.equalsIgnoreCase("edge")) { driver = new EdgeDriver(); }
 * else { driver = new ChromeDriver(); }
 * 
 * driver.get(URL);
 * driver.findElement(http://By.name("user_name")).sendKeys(USERNAME);
 * driver.findElement(http://By.name("user_password")).sendKeys(PASSWORD);
 * driver.findElement(http://By.id("submitButton")).click();
 * 
 * driver.findElement(By.linkText("Products")).click();
 * driver.findElement(By.cssSelector("[title=\"Create Product...\"]")).click();
 * 
 * // RanDom Class----->generating unique values(Avoid Duplicate value) Random
 * ran = new Random(); int ranNum = ran.nextInt(1000); //
 * -----------------------------------------------------------------------------
 * ----------------------------- // step1:- Path setting of the Excel file
 * FileInputStream fis1 = new
 * FileInputStream("./src/test/resources/TestData11.xlsx");
 * 
 * // step2:- keep the File in read mode Workbook book =
 * WorkbookFactory.create(fis1);
 * 
 * // step3:- Navigating to the sheet Sheet sheet = book.getSheet("Product");
 * 
 * // Step4:- Navigating to the Row Row row = sheet.getRow(0);
 * 
 * // Step5:- Navigating to the Cell Cell cell = row.getCell(0);
 * 
 * String PrdName = cell.getStringCellValue() + ranNum;
 * System.out.println(PrdName);
 * 
 * driver.findElement(http://By.name("productname")).sendKeys(PrdName);
 * 
 * driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
 * //---------------------------------------------------------------------------
 * --------------------------- driver.findElement(By.linkText("More")).click();
 * driver.findElement(By.linkText("Campaigns")).click();
 * 
 * driver.findElement(By.cssSelector("[alt=\"Create Campaign...\"]")).click();
 * 
 * // RanDom Class----->generating unique values(Avoid Duplicate value) Random
 * ran1 = new Random(); int ranNum1 = ran1.nextInt(1000); //
 * -----------------------------------------------------------------------------
 * ----------------------------- // step1:- Path setting of the Excel file
 * FileInputStream fis2 = new
 * FileInputStream("./src/test/resources/TestData11.xlsx");
 * 
 * // step2:- keep the File in read mode Workbook book1 =
 * WorkbookFactory.create(fis2);
 * 
 * // step3:- Navigating to the sheet Sheet sheet1 = book1.getSheet("Campaign");
 * 
 * // Step4:- Navigating to the Row Row row1 = sheet1.getRow(0);
 * 
 * // Step5:- Navigating to the Cell Cell cell1 = row1.getCell(0);
 * 
 * String CampName = cell1.getStringCellValue() + ranNum1;
 * System.out.println(CampName);
 * 
 * driver.findElement(http://By.name("campaignname")).sendKeys(CampName);
 * 
 * driver.findElement(By.cssSelector("[alt=\"Select\"]")).click();
 * 
 * Set<String> allWins = driver.getWindowHandles(); Iterator<String> id =
 * allWins.iterator();
 * 
 * while (id.hasNext()) { String win = http://id.next();
 * driver.switchTo().window(win); String title = driver.getTitle(); if
 * (title.contains("Products&action"))
 * 
 * { break; } }
 * driver.findElement(http://By.name("search_text")).sendKeys(PrdName);
 * driver.findElement(http://By.name("search")).click(); Thread.sleep(2000);
 * 
 * //Dynamic xpath
 * driver.findElement(By.xpath("//a[text()='"+PrdName+"']")).click();
 * 
 * Set<String> allWins1 = driver.getWindowHandles(); Iterator<String> id1 =
 * allWins1.iterator();
 * 
 * while (id1.hasNext()) { String win1 = http://id1.next();
 * driver.switchTo().window(win1); String title1 = driver.getTitle(); if
 * (title1.contains("Campaigns&action"))
 * 
 * { break; } }
 * driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();
 * 
 * String actData =
 * driver.findElement(http://By.id("dtlview_Campaign Name")).getText();
 * 
 * if(actData.contains(CampName)) {
 * System.out.println("Campaign Name is Created"); } else {
 * System.out.println("Campaign Name is not Created"); }
 * 
 * //---------------------------------------------------------------------------
 * ---------- String actData1 =
 * driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();
 * 
 * if(actData1.contains(PrdName)) {
 * System.out.println("Product Name is created"); } else {
 * System.out.println("Product Name is not Created"); }
 * driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]"))
 * .click(); driver.findElement(By.linkText("Sign Out")).click(); }
 * 
 * }
 * 
 */
/*
 * package Campaign;
 * 
 * import java.io.FileInputStream; import java.io.FileNotFoundException; import
 * java.util.Iterator; import http://java.util.Properties; import
 * java.util.Random; import java.util.Set;
 * 
 * import org.apache.poi.ss.usermodel.Cell; import
 * org.apache.poi.ss.usermodel.Row; import org.apache.poi.ss.usermodel.Sheet;
 * import org.apache.poi.ss.usermodel.Workbook; import
 * org.apache.poi.ss.usermodel.WorkbookFactory; import
 * http://org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.edge.EdgeDriver; import
 * org.openqa.selenium.firefox.FirefoxDriver;
 * 
 * public class CreateCampaignWithProduct {
 * 
 * public static void main(String[] args) throws Throwable {
 * 
 * WebDriver driver; FileInputStream fis = new
 * FileInputStream("./src/test/resources/CommonDatas.properties"); Properties
 * pro = new Properties(); pro.load(fis); String BROWSER =
 * pro.getProperty("browser"); String URL = pro.getProperty("url"); String
 * USERNAME = pro.getProperty("username"); String PASSWORD =
 * pro.getProperty("password");
 * 
 * if (BROWSER.equalsIgnoreCase("chrome")) { driver = new ChromeDriver(); } else
 * if (BROWSER.equalsIgnoreCase("firefox")) { driver = new FirefoxDriver(); }
 * else if (BROWSER.equalsIgnoreCase("edge")) { driver = new EdgeDriver(); }
 * else { driver = new ChromeDriver(); }
 * 
 * driver.get(URL);
 * driver.findElement(http://By.name("user_name")).sendKeys(USERNAME);
 * driver.findElement(http://By.name("user_password")).sendKeys(PASSWORD);
 * driver.findElement(http://By.id("submitButton")).click();
 * 
 * driver.findElement(By.linkText("Products")).click();
 * driver.findElement(By.cssSelector("[title=\"Create Product...\"]")).click();
 * 
 * // RanDom Class----->generating unique values(Avoid Duplicate value) Random
 * ran = new Random(); int ranNum = ran.nextInt(1000); //
 * -----------------------------------------------------------------------------
 * ----------------------------- // step1:- Path setting of the Excel file
 * FileInputStream fis1 = new
 * FileInputStream("./src/test/resources/TestData11.xlsx");
 * 
 * // step2:- keep the File in read mode Workbook book =
 * WorkbookFactory.create(fis1);
 * 
 * // step3:- Navigating to the sheet Sheet sheet = book.getSheet("Product");
 * 
 * // Step4:- Navigating to the Row Row row = sheet.getRow(0);
 * 
 * // Step5:- Navigating to the Cell Cell cell = row.getCell(0);
 * 
 * String PrdName = cell.getStringCellValue() + ranNum;
 * System.out.println(PrdName);
 * 
 * driver.findElement(http://By.name("productname")).sendKeys(PrdName);
 * 
 * driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
 * //---------------------------------------------------------------------------
 * --------------------------- driver.findElement(By.linkText("More")).click();
 * driver.findElement(By.linkText("Campaigns")).click();
 * 
 * driver.findElement(By.cssSelector("[alt=\"Create Campaign...\"]")).click();
 * 
 * // RanDom Class----->generating unique values(Avoid Duplicate value) Random
 * ran1 = new Random(); int ranNum1 = ran1.nextInt(1000); //
 * -----------------------------------------------------------------------------
 * ----------------------------- // step1:- Path setting of the Excel file
 * FileInputStream fis2 = new
 * FileInputStream("./src/test/resources/TestData11.xlsx");
 * 
 * // step2:- keep the File in read mode Workbook book1 =
 * WorkbookFactory.create(fis2);
 * 
 * // step3:- Navigating to the sheet Sheet sheet1 = book1.getSheet("Campaign");
 * 
 * // Step4:- Navigating to the Row Row row1 = sheet1.getRow(0);
 * 
 * // Step5:- Navigating to the Cell Cell cell1 = row1.getCell(0);
 * 
 * String CampName = cell1.getStringCellValue() + ranNum1;
 * System.out.println(CampName);
 * 
 * driver.findElement(http://By.name("campaignname")).sendKeys(CampName);
 * 
 * driver.findElement(By.cssSelector("[alt=\"Select\"]")).click();
 * 
 * Set<String> allWins = driver.getWindowHandles(); Iterator<String> id =
 * allWins.iterator();
 * 
 * while (id.hasNext()) { String win = http://id.next();
 * driver.switchTo().window(win); String title = driver.getTitle(); if
 * (title.contains("Products&action"))
 * 
 * { break; } }
 * driver.findElement(http://By.name("search_text")).sendKeys(PrdName);
 * driver.findElement(http://By.name("search")).click(); Thread.sleep(2000);
 * 
 * //Dynamic xpath
 * driver.findElement(By.xpath("//a[text()='"+PrdName+"']")).click();
 * 
 * Set<String> allWins1 = driver.getWindowHandles(); Iterator<String> id1 =
 * allWins1.iterator();
 * 
 * while (id1.hasNext()) { String win1 = http://id1.next();
 * driver.switchTo().window(win1); String title1 = driver.getTitle(); if
 * (title1.contains("Campaigns&action"))
 * 
 * { break; } }
 * driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();
 * 
 * String actData =
 * driver.findElement(http://By.id("dtlview_Campaign Name")).getText();
 * 
 * if(actData.contains(CampName)) {
 * System.out.println("Campaign Name is Created"); } else {
 * System.out.println("Campaign Name is not Created"); }
 * 
 * //---------------------------------------------------------------------------
 * ---------- String actData1 =
 * driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();
 * 
 * if(actData1.contains(PrdName)) {
 * System.out.println("Product Name is created"); } else {
 * System.out.println("Product Name is not Created"); }
 * driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]"))
 * .click(); driver.findElement(By.linkText("Sign Out")).click(); }
 * 
 * }
 */
/*
 * package Campagins;
 * 
 * import java.io.FileInputStream; import java.io.FileNotFoundException; import
 * java.time.Duration; import java.util.Properties; import java.util.Random;
 * 
 * import org.apache.poi.ss.usermodel.Cell; import
 * org.apache.poi.ss.usermodel.Row; import org.apache.poi.ss.usermodel.Sheet;
 * import org.apache.poi.ss.usermodel.Workbook; import
 * org.apache.poi.ss.usermodel.WorkbookFactory; import org.openqa.selenium.By;
 * import org.openqa.selenium.WebDriver; import org.openqa.selenium.WebElement;
 * import org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.edge.EdgeDriver; import
 * org.openqa.selenium.firefox.FirefoxDriver; import
 * org.openqa.selenium.interactions.Actions;
 * 
 * import Generic_Utility.File_Utility;
 * 
 * public class CreateCampaigns {
 * 
 * public static void main(String[] args) throws Throwable {
 * 
 * // // step1:- get the file path connection // FileInputStream fis = new
 * FileInputStream("C:\\Users\\Shobha\\Downloads\\Properties_Data7am.properties"
 * ); // // // step2:- load all the keys // Properties pro = new Properties();
 * // pro.load(fis); // // // step3:- read key value // String BROWSER =
 * pro.getProperty("browser"); // String URL = pro.getProperty("url"); // String
 * USERNAME = pro.getProperty("username"); // String PASSWORD =
 * pro.getProperty("password");
 * 
 * //Reading data from file_utility File_Utility flib = new File_Utility();
 * String BROWSER = flib.getKeyAndValuePair("browser"); String URL =
 * flib.getKeyAndValuePair("url"); String USERNAME =
 * flib.getKeyAndValuePair("username"); String PASSWORD =
 * flib.getKeyAndValuePair("password");
 * 
 * WebDriver driver; if (BROWSER.equalsIgnoreCase("chrome")) { driver = new
 * ChromeDriver(); }
 * 
 * else if (BROWSER.equalsIgnoreCase("edge")) { driver = new EdgeDriver(); }
 * 
 * else if (BROWSER.equalsIgnoreCase("firefox")) { driver = new FirefoxDriver();
 * } else { driver = new EdgeDriver(); } driver.get(URL);
 * driver.findElement(By.name("user_name")).sendKeys(USERNAME);
 * driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
 * driver.findElement(By.id("submitButton")).click();
 * 
 * driver.manage().window().maximize();
 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 * 
 * WebElement moreLink = driver.findElement(By.linkText("More"));
 * 
 * Actions act = new Actions(driver); act.moveToElement(moreLink).perform();
 * driver.findElement(By.linkText("Campaigns")).click();
 * driver.findElement(By.xpath("//img[@alt=\"Create Campaign...\"]")).click();
 * 
 * // To Avoid Duplicates Random ran = new Random(); int ranNum =
 * ran.nextInt(1000);
 * 
 * FileInputStream fes = new FileInputStream(
 * "C:\\Users\\Shobha\\eclipse-BasicSelenium\\AdvanceSelenium_QCO-SOEAJD-M19\\target\\test-classes\\TestData7am.xlsx"
 * ); // step2:- open workbook in read mode Workbook book =
 * WorkbookFactory.create(fes);
 * 
 * // step3:-get control of the Sheet Sheet sheet = book.getSheet("Campaigns");
 * 
 * // step4:-get control of the row Row row = sheet.getRow(0);
 * 
 * // step5:-get control of the cell Cell cel = row.getCell(0);
 * 
 * // //step6:-read cell value String CampName = cel.getStringCellValue() +
 * ranNum; System.out.println(CampName);
 * 
 * driver.findElement(By.name("campaignname")).sendKeys(CampName);
 * 
 * driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
 * String actData =
 * driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText()
 * ;
 * 
 * if(actData.contains(CampName)) {
 * System.out.println("Campaigns Name is Created"); } else {
 * System.out.println("Campaigns name not created"); }
 * 
 * 
 * 
 * WebElement AmdLink =
 * driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"))
 * ; act.moveToElement(AmdLink).perform();
 * driver.findElement(By.linkText("Sign Out")).click();
 * 
 * }
 * 
 * }
 * =============================================================================
 * =============================================================================
 * =========
 * 
 * 
 */

/*
 * package Campagins;
 * 
 * import java.io.FileInputStream; import java.io.FileNotFoundException; import
 * java.time.Duration; import java.util.Iterator; import java.util.Properties;
 * import java.util.Random; import java.util.Set;
 * 
 * import org.apache.commons.collections4.functors.IfClosure; import
 * org.apache.poi.ss.usermodel.Cell; import org.apache.poi.ss.usermodel.Row;
 * import org.apache.poi.ss.usermodel.Sheet; import
 * org.apache.poi.ss.usermodel.Workbook; import
 * org.apache.poi.ss.usermodel.WorkbookFactory; import org.openqa.selenium.By;
 * import org.openqa.selenium.WebDriver; import org.openqa.selenium.WebElement;
 * import org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.edge.EdgeDriver; import
 * org.openqa.selenium.firefox.FirefoxDriver; import
 * org.openqa.selenium.interactions.Actions;
 * 
 * public class CreateCampWithProduct {
 * 
 * public static void main(String[] args) throws Throwable {
 * 
 * // step1:- get the file path connection FileInputStream fis = new
 * FileInputStream("C:\\Users\\Shobha\\Downloads\\Properties_Data7am.properties"
 * );
 * 
 * // step2:- load all the keys Properties pro = new Properties();
 * pro.load(fis);
 * 
 * // step3:- read key value String BROWSER = pro.getProperty("browser"); String
 * URL = pro.getProperty("url"); String USERNAME = pro.getProperty("username");
 * String PASSWORD = pro.getProperty("password");
 * 
 * WebDriver driver; if (BROWSER.equalsIgnoreCase("chrome")) { driver = new
 * ChromeDriver(); }
 * 
 * else if (BROWSER.equalsIgnoreCase("edge")) { driver = new EdgeDriver(); }
 * 
 * else if (BROWSER.equalsIgnoreCase("firefox")) { driver = new FirefoxDriver();
 * } else { driver = new EdgeDriver(); } driver.get(URL);
 * driver.findElement(By.name("user_name")).sendKeys(USERNAME);
 * driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
 * driver.findElement(By.id("submitButton")).click();
 * 
 * driver.manage().window().maximize();
 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 * 
 * driver.findElement(By.linkText("Products")).click();
 * 
 * driver.findElement(By.xpath("//img[@title=\"Create Product...\"]")).click();
 * 
 * // To Avoid Duplicates Random ran = new Random(); int ranNum =
 * ran.nextInt(1000);
 * 
 * // Step1:-get the connection of physical file FileInputStream fis1 = new
 * FileInputStream("./src/test/resources/TestData7am.xlsx");
 * 
 * // step2:- open workbook in read mode Workbook book =
 * WorkbookFactory.create(fis1);
 * 
 * // step3:-get control of the Sheet Sheet sheet = book.getSheet("Product");
 * 
 * // step4:-get control of the row Row row = sheet.getRow(0);
 * 
 * // step5:-get control of the cell Cell cel = row.getCell(0);
 * 
 * // //step6:-read cell value String PrdName = cel.getStringCellValue() +
 * ranNum; System.out.println(PrdName);
 * 
 * driver.findElement(By.name("productname")).sendKeys(PrdName);
 * driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
 * //---------------------------------------------------------------------------
 * -------------------------------- // Navigating to campaign Module WebElement
 * moreLink = driver.findElement(By.linkText("More"));
 * 
 * Actions act = new Actions(driver); act.moveToElement(moreLink).perform();
 * driver.findElement(By.linkText("Campaigns")).click();
 * driver.findElement(By.xpath("//img[@alt=\"Create Campaign...\"]")).click();
 * 
 * FileInputStream fes = new FileInputStream(
 * "C:\\Users\\Shobha\\eclipse-BasicSelenium\\AdvanceSelenium_QCO-SOEAJD-M19\\target\\test-classes\\TestData7am.xlsx"
 * ); // step2:- open workbook in read mode Workbook book1 =
 * WorkbookFactory.create(fes);
 * 
 * // step3:-get control of the Sheet Sheet sheet1 =
 * book1.getSheet("Campaigns");
 * 
 * // step4:-get control of the row Row row1 = sheet1.getRow(0);
 * 
 * // step5:-get control of the cell Cell cel1 = row1.getCell(0);
 * 
 * // //step6:-read cell value String CampName = cel1.getStringCellValue() +
 * ranNum; System.out.println(CampName);
 * 
 * driver.findElement(By.name("campaignname")).sendKeys(CampName);
 * 
 * //Click on + sign To Navigate Product Table
 * driver.findElement(By.xpath("//img[@alt=\"Select\"]")).click();
 * 
 * Set<String> allWins = driver.getWindowHandles();//win1//win2 Iterator<String>
 * it = allWins.iterator();
 * 
 * while (it.hasNext()) { String win = it.next(); driver.switchTo().window(win);
 * String title = driver.getTitle(); if(title.contains("Products&action")) {
 * break; } } driver.findElement(By.name("search_text")).sendKeys(PrdName);
 * driver.findElement(By.cssSelector("[name=\"search\"]")).click();
 * 
 * //Dynamic Xpath
 * driver.findElement(By.xpath("//a[text()='"+PrdName+"']")).click();
 * 
 * Set<String> allWins1 = driver.getWindowHandles(); Iterator<String> it1 =
 * allWins1.iterator();
 * 
 * while (it1.hasNext()) { String win1 = it1.next();
 * driver.switchTo().window(win1); String title1 = driver.getTitle();
 * if(title1.contains("Campaigns&action")) { break; } }
 * driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
 * 
 * String actData =
 * driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText()
 * ;
 * 
 * if(actData.contains(CampName)) {
 * System.out.println("Campaigns Name is Created"); } else {
 * System.out.println("Campaigns name not created"); }
 * 
 * 
 * String actData1 =
 * driver.findElement(By.xpath("//span[@id=\"dtlview_Product\"]")).getText(); if
 * (actData1.equals(PrdName)) { System.out.println("Product Name is Created"); }
 * else { System.out.println("Product name is not created"); }
 * 
 * WebElement AmdLink =
 * driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"))
 * ;
 * 
 * //Logout act.moveToElement(AmdLink).perform();
 * driver.findElement(By.linkText("Sign Out")).click();
 * 
 * }
 * 
 * }
 * =============================================================================
 * =============================================================================
 * =======
 */

/*
 * package Campaign;
 * 
 * import java.io.FileInputStream; import java.io.FileNotFoundException; import
 * http://java.util.Properties; import java.util.Random;
 * 
 * import org.apache.poi.ss.usermodel.Cell; import
 * org.apache.poi.ss.usermodel.Row; import org.apache.poi.ss.usermodel.Sheet;
 * import org.apache.poi.ss.usermodel.Workbook; import
 * org.apache.poi.ss.usermodel.WorkbookFactory; import
 * http://org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.edge.EdgeDriver; import
 * org.openqa.selenium.firefox.FirefoxDriver;
 * 
 * import Generic_Uilities.File_Utility; import Generic_Uilities.Java_Utility;
 * 
 * public class CreateCampaign {
 * 
 * public static void main(String[] args) throws Throwable {
 * 
 * WebDriver driver;
 * 
 * // FileInputStream fis = new
 * FileInputStream("./src/test/resources/CommonDatas.properties"); // Properties
 * pro = new Properties(); // pro.load(fis);
 * 
 * // String BROWSER = pro.getProperty("browser"); // String URL =
 * pro.getProperty("url"); // String USERNAME = pro.getProperty("username"); //
 * String PASSWORD = pro.getProperty("password");
 * 
 * 
 * File_Utility flib = new File_Utility(); String BROWSER =
 * flib.getKeyAndValuePair("browser"); String URL =
 * flib.getKeyAndValuePair("url"); String USERNAME =
 * flib.getKeyAndValuePair("username"); String PASSWORD =
 * flib.getKeyAndValuePair("password");
 * 
 * if (BROWSER.equalsIgnoreCase("chrome")) { driver = new ChromeDriver(); } else
 * if (BROWSER.equalsIgnoreCase("firefox")) { driver = new FirefoxDriver(); }
 * else if (BROWSER.equalsIgnoreCase("edge")) { driver = new EdgeDriver(); }
 * else { driver = new ChromeDriver(); }
 * 
 * driver.get(URL);
 * driver.findElement(http://By.name("user_name")).sendKeys(USERNAME);
 * driver.findElement(http://By.name("user_password")).sendKeys(PASSWORD);
 * driver.findElement(http://By.id("submitButton")).click();
 * 
 * driver.findElement(By.linkText("More")).click();
 * driver.findElement(By.linkText("Campaigns")).click();
 * 
 * driver.findElement(By.cssSelector("[alt=\"Create Campaign...\"]")).click();
 * 
 * // RanDom Class----->generating unique values(Avoid Duplicate value) //
 * Random ran = new Random(); // int ranNum = ran.nextInt(1000); Java_Utility
 * jlib = new Java_Utility(); int ranNum = jlib.getRandomNum();
 * //---------------------------------------------------------------------------
 * ------------------------------- // step1:- Path setting of the Excel file
 * FileInputStream fis1 = new
 * FileInputStream("./src/test/resources/TestData11.xlsx");
 * 
 * // step2:- keep the File in read mode Workbook book =
 * WorkbookFactory.create(fis1);
 * 
 * // step3:- Navigating to the sheet Sheet sheet = book.getSheet("Campaign");
 * 
 * // Step4:- Navigating to the Row Row row = sheet.getRow(0);
 * 
 * // Step5:- Navigating to the Cell Cell cell = row.getCell(0);
 * 
 * String CampName = cell.getStringCellValue() + ranNum;
 * System.out.println(CampName);
 * 
 * driver.findElement(http://By.name("campaignname")).sendKeys(CampName);
 * driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();
 * 
 * String actData =
 * driver.findElement(http://By.id("dtlview_Campaign Name")).getText();
 * 
 * if(actData.contains(CampName)) {
 * System.out.println("Campaign Name is Created"); } else {
 * System.out.println("Campaign Name is not Created"); }
 * 
 * driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]"))
 * .click(); driver.findElement(By.linkText("Sign Out")).click(); }
 * 
 * 
 * }
 */
//..........................
/*
 * package Campaign;
 * 
 * import java.io.FileInputStream; import java.io.FileNotFoundException; import
 * java.time.Duration; import http://java.util.Properties; import
 * java.util.Random;
 * 
 * import org.apache.poi.ss.usermodel.Cell; import
 * org.apache.poi.ss.usermodel.Row; import org.apache.poi.ss.usermodel.Sheet;
 * import org.apache.poi.ss.usermodel.Workbook; import
 * org.apache.poi.ss.usermodel.WorkbookFactory; import
 * http://org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.edge.EdgeDriver; import
 * org.openqa.selenium.firefox.FirefoxDriver;
 * 
 * import Generic_Uilities.Excel_Utility; import Generic_Uilities.File_Utility;
 * import Generic_Uilities.Java_Utility; import
 * Generic_Uilities.WebDriver_Utility;
 * 
 * public class CreateCampaign {
 * 
 * public static void main(String[] args) throws Throwable {
 * 
 * WebDriver driver;
 * 
 * File_Utility flib = new File_Utility(); String BROWSER =
 * flib.getKeyAndValuePair("browser"); String URL =
 * flib.getKeyAndValuePair("url"); String USERNAME =
 * flib.getKeyAndValuePair("username"); String PASSWORD =
 * flib.getKeyAndValuePair("password");
 * 
 * if (BROWSER.equalsIgnoreCase("chrome")) { driver = new ChromeDriver(); } else
 * if (BROWSER.equalsIgnoreCase("firefox")) { driver = new FirefoxDriver(); }
 * else if (BROWSER.equalsIgnoreCase("edge")) { driver = new EdgeDriver(); }
 * else { driver = new ChromeDriver(); }
 * 
 * driver.get(URL);
 * driver.findElement(http://By.name("user_name")).sendKeys(USERNAME);
 * driver.findElement(http://By.name("user_password")).sendKeys(PASSWORD);
 * driver.findElement(http://By.id("submitButton")).click();
 * 
 * // driver.manage().window().maximize(); //
 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 * WebDriver_Utility wlib = new WebDriver_Utility();
 * wlib.maximizeWindow(driver); wlib.waitForPageToLoad(driver);
 * 
 * 
 * driver.findElement(By.linkText("More")).click();
 * driver.findElement(By.linkText("Campaigns")).click();
 * 
 * driver.findElement(By.cssSelector("[alt=\"Create Campaign...\"]")).click();
 * 
 * // RanDom Class----->generating unique values(Avoid Duplicate value)
 * 
 * Java_Utility jlib = new Java_Utility(); int ranNum = jlib.getRandomNum();
 * //---------------------------------------------------------------------------
 * -------------------------------
 * 
 * Excel_Utility elib = new Excel_Utility(); String CampName =
 * elib.readExcelData("Campaign", 0, 0) + ranNum;
 * 
 * driver.findElement(http://By.name("campaignname")).sendKeys(CampName);
 * driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();
 * 
 * String actData =
 * driver.findElement(http://By.id("dtlview_Campaign Name")).getText();
 * 
 * if (actData.contains(CampName)) {
 * System.out.println("Campaign Name is Created"); } else {
 * System.out.println("Campaign Name is not Created"); }
 * 
 * driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]"))
 * .click(); driver.findElement(By.linkText("Sign Out")).click(); }
 * 
 * }
 * 
 */
//......................................
/*
 * package Campaign;
 * 
 * import java.io.FileInputStream; import java.io.FileNotFoundException; import
 * java.time.Duration; import java.util.Properties; import java.util.Random;
 * 
 * import org.apache.poi.ss.usermodel.Cell; import
 * org.apache.poi.ss.usermodel.Row; import org.apache.poi.ss.usermodel.Sheet;
 * import org.apache.poi.ss.usermodel.Workbook; import
 * org.apache.poi.ss.usermodel.WorkbookFactory; import org.openqa.selenium.By;
 * import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.edge.EdgeDriver; import
 * org.openqa.selenium.firefox.FirefoxDriver;
 * 
 * import Generic_Uilities.Excel_Utility; import Generic_Uilities.File_Utility;
 * import Generic_Uilities.Java_Utility; import
 * Generic_Uilities.WebDriver_Utility;
 * 
 * public class CreateCampaign {
 * 
 * public static void main(String[] args) throws Throwable {
 * 
 * WebDriver_Utility wlib = new WebDriver_Utility(); Java_Utility jlib = new
 * Java_Utility(); Excel_Utility elib = new Excel_Utility(); File_Utility flib =
 * new File_Utility();
 * 
 * WebDriver driver;
 * 
 * String BROWSER = flib.getKeyAndValuePair("browser"); String URL =
 * flib.getKeyAndValuePair("url"); String USERNAME =
 * flib.getKeyAndValuePair("username"); String PASSWORD =
 * flib.getKeyAndValuePair("password");
 * 
 * if (BROWSER.equalsIgnoreCase("chrome")) { driver = new ChromeDriver(); } else
 * if (BROWSER.equalsIgnoreCase("firefox")) { driver = new FirefoxDriver(); }
 * else if (BROWSER.equalsIgnoreCase("edge")) { driver = new EdgeDriver(); }
 * else { driver = new ChromeDriver(); }
 * 
 * driver.get(URL); driver.findElement(By.name("user_name")).sendKeys(USERNAME);
 * driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
 * driver.findElement(By.id("submitButton")).click();
 * 
 * wlib.maximizeWindow(driver); wlib.waitForPageToLoad(driver);
 * 
 * driver.findElement(By.linkText("More")).click();
 * driver.findElement(By.linkText("Campaigns")).click();
 * 
 * driver.findElement(By.cssSelector("[alt=\"Create Campaign...\"]")).click();
 * 
 * // RanDom Class----->generating unique values(Avoid Duplicate value)
 * 
 * int ranNum = jlib.getRandomNum();
 * //---------------------------------------------------------------------------
 * -------------------------------
 * 
 * String CampName = elib.readExcelData("Campaign", 0, 0) + ranNum;
 * 
 * driver.findElement(By.name("campaignname")).sendKeys(CampName);
 * driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();
 * 
 * String actData =
 * driver.findElement(By.id("dtlview_Campaign Name")).getText();
 * 
 * if (actData.contains(CampName)) {
 * System.out.println("Campaign Name is Created"); } else {
 * System.out.println("Campaign Name is not Created"); }
 * 
 * driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]"))
 * .click(); driver.findElement(By.linkText("Sign Out")).click(); }
 * 
 * }
 */
//''''''''''''''''
/*
 * package Campaign;
 * 
 * import java.io.FileInputStream; import java.io.FileNotFoundException; import
 * java.time.Duration; import http://java.util.Properties; import
 * java.util.Random;
 * 
 * import org.apache.poi.ss.usermodel.Cell; import
 * org.apache.poi.ss.usermodel.Row; import org.apache.poi.ss.usermodel.Sheet;
 * import org.apache.poi.ss.usermodel.Workbook; import
 * org.apache.poi.ss.usermodel.WorkbookFactory; import
 * http://org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.edge.EdgeDriver; import
 * org.openqa.selenium.firefox.FirefoxDriver;
 * 
 * import Generic_Uilities.Excel_Utility; import Generic_Uilities.File_Utility;
 * import Generic_Uilities.Java_Utility; import
 * Generic_Uilities.WebDriver_Utility; import ObjectRepo.LoginVtigerPage; import
 * ObjectRepo.VtigerHomePage;
 * 
 * public class CreateCampaign {
 * 
 * public static void main(String[] args) throws Throwable {
 * 
 * WebDriver_Utility wlib = new WebDriver_Utility(); Java_Utility jlib = new
 * Java_Utility(); Excel_Utility elib = new Excel_Utility(); File_Utility flib =
 * new File_Utility();
 * 
 * WebDriver driver;
 * 
 * String BROWSER = flib.getKeyAndValuePair("browser"); String URL =
 * flib.getKeyAndValuePair("url"); String USERNAME =
 * flib.getKeyAndValuePair("username"); String PASSWORD =
 * flib.getKeyAndValuePair("password");
 * 
 * if (BROWSER.equalsIgnoreCase("chrome")) { driver = new ChromeDriver(); } else
 * if (BROWSER.equalsIgnoreCase("firefox")) { driver = new FirefoxDriver(); }
 * else if (BROWSER.equalsIgnoreCase("edge")) { driver = new EdgeDriver(); }
 * else { driver = new ChromeDriver(); }
 * 
 * driver.get(URL);
 * 
 * // using getter methods // LoginVtigerPage login = new
 * LoginVtigerPage(driver); // login.getUserTextField().sendKeys(USERNAME); //
 * login.getPassWordTextField().sendKeys(PASSWORD); //
 * login.getLoginButton().click();
 * 
 * // using business logics LoginVtigerPage login = new LoginVtigerPage(driver);
 * login.loginIntoVtiger(USERNAME, PASSWORD);
 * 
 * wlib.maximizeWindow(driver); wlib.waitForPageToLoad(driver);
 * 
 * // driver.findElement(By.linkText("More")).click(); //
 * driver.findElement(By.linkText("Campaigns")).click();
 * 
 * VtigerHomePage home = new VtigerHomePage(driver); home.clickMoreLink();
 * home.clickCampLink();
 * 
 * driver.findElement(By.cssSelector("[alt=\"Create Campaign...\"]")).click();
 * 
 * // RanDom Class----->generating unique values(Avoid Duplicate value)
 * 
 * int ranNum = jlib.getRandomNum();
 * //---------------------------------------------------------------------------
 * -------------------------------
 * 
 * String CampName = elib.readExcelData("Campaign", 0, 0) + ranNum;
 * 
 * driver.findElement(http://By.name("campaignname")).sendKeys(CampName);
 * driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();
 * 
 * String actData =
 * driver.findElement(http://By.id("dtlview_Campaign Name")).getText();
 * 
 * if (actData.contains(CampName)) {
 * System.out.println("Campaign Name is Created"); } else {
 * System.out.println("Campaign Name is not Created"); }
 * 
 * //
 * driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]"))
 * .click(); // driver.findElement(By.linkText("Sign Out")).click();
 * home.logoutApp(); }
 * 
 * }
 */
//..............
/*
 * package Campaign;
 * 
 * import java.io.FileInputStream; import java.io.FileNotFoundException; import
 * java.time.Duration; import http://java.util.Properties; import
 * java.util.Random;
 * 
 * import org.apache.poi.ss.usermodel.Cell; import
 * org.apache.poi.ss.usermodel.Row; import org.apache.poi.ss.usermodel.Sheet;
 * import org.apache.poi.ss.usermodel.Workbook; import
 * org.apache.poi.ss.usermodel.WorkbookFactory; import
 * http://org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.edge.EdgeDriver; import
 * org.openqa.selenium.firefox.FirefoxDriver;
 * 
 * import Generic_Uilities.Excel_Utility; import Generic_Uilities.File_Utility;
 * import Generic_Uilities.Java_Utility; import
 * Generic_Uilities.WebDriver_Utility; import ObjectRepo.CampDetailedPage;
 * import ObjectRepo.CampValidatePage; import ObjectRepo.CreateCampPage; import
 * ObjectRepo.LoginVtigerPage; import ObjectRepo.VtigerHomePage;
 * 
 * public class CreateCampaign {
 * 
 * public static void main(String[] args) throws Throwable {
 * 
 * WebDriver_Utility wlib = new WebDriver_Utility(); Java_Utility jlib = new
 * Java_Utility(); Excel_Utility elib = new Excel_Utility(); File_Utility flib =
 * new File_Utility();
 * 
 * WebDriver driver;
 * 
 * String BROWSER = flib.getKeyAndValuePair("browser"); String URL =
 * flib.getKeyAndValuePair("url"); String USERNAME =
 * flib.getKeyAndValuePair("username"); String PASSWORD =
 * flib.getKeyAndValuePair("password");
 * 
 * if (BROWSER.equalsIgnoreCase("chrome")) { driver = new ChromeDriver(); } else
 * if (BROWSER.equalsIgnoreCase("firefox")) { driver = new FirefoxDriver(); }
 * else if (BROWSER.equalsIgnoreCase("edge")) { driver = new EdgeDriver(); }
 * else { driver = new ChromeDriver(); }
 * 
 * driver.get(URL);
 * 
 * // using getter methods // LoginVtigerPage login = new
 * LoginVtigerPage(driver); // login.getUserTextField().sendKeys(USERNAME); //
 * login.getPassWordTextField().sendKeys(PASSWORD); //
 * login.getLoginButton().click();
 * 
 * // using business logics LoginVtigerPage login = new LoginVtigerPage(driver);
 * login.loginIntoVtiger(USERNAME, PASSWORD);
 * 
 * wlib.maximizeWindow(driver); wlib.waitForPageToLoad(driver);
 * 
 * // driver.findElement(By.linkText("More")).click(); //
 * driver.findElement(By.linkText("Campaigns")).click();
 * 
 * VtigerHomePage home = new VtigerHomePage(driver); home.clickMoreLink();
 * home.clickCampLink();
 * 
 * CampDetailedPage img = new CampDetailedPage(driver);
 * img.clickCampLookUpImg(); //
 * driver.findElement(By.cssSelector("[alt=\"Create Campaign...\"]")).click();
 * 
 * // RanDom Class----->generating unique values(Avoid Duplicate value)
 * 
 * int ranNum = jlib.getRandomNum();
 * //---------------------------------------------------------------------------
 * -------------------------------
 * 
 * String CampName = elib.readExcelData("Campaign", 0, 0) + ranNum;
 * 
 * // driver.findElement(http://By.name("campaignname")).sendKeys(CampName); //
 * driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();
 * 
 * CreateCampPage createPage = new CreateCampPage(driver);
 * createPage.enterCampName(CampName); createPage.clickSaveButton();
 * 
 * // String actData =
 * driver.findElement(http://By.id("dtlview_Campaign Name")).getText(); // // if
 * (actData.contains(CampName)) { //
 * System.out.println("Campaign Name is Created"); // } else { //
 * System.out.println("Campaign Name is not Created"); // }
 * 
 * CampValidatePage validate = new CampValidatePage(driver);
 * validate.validateCampaign(driver, CampName);
 * 
 * 
 * //
 * driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]"))
 * .click(); // driver.findElement(By.linkText("Sign Out")).click();
 * home.logoutApp(); }
 * 
 * }
 */
