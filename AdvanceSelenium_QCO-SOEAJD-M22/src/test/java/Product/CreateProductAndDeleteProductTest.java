package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
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
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepo.CampDetailedPage;
import ObjectRepo.PrdDetailedPage;
import ObjectRepo.VtigerHomePage;

public class CreateProductAndDeleteProductTest extends BaseClass{
@Test

	public void createProductAndDeleteProductTest() throws Throwable {

		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();
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
		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickMoreLink();
		home.clickPrdLink();

		PrdDetailedPage img = new PrdDetailedPage(driver);
		img.clickPrdLookUpImg();

		// RanDom Class----->generating unique values(Avoid Duplicate value)

		int ranNum = jlib.getRandomNum();
		// ----------------------------------------------------------------------------------------------------------

		String PrdName = elib.readExcelData("Product", 0, 0) + ranNum;
		System.out.println(PrdName);

		driver.findElement(By.name("productname")).sendKeys(PrdName);

		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();

		driver.findElement(By.linkText("Products")).click();

		driver.findElement(By.xpath("//table[@class=\"lvt small\"]/tbody/tr//td//a[text()='" + PrdName
				+ "']/../preceding-sibling::td/input[@type=\"checkbox\"]")).click();

		driver.findElement(By.cssSelector("[value=\"Delete\"]")).click();

		wlib.alertAccept(driver);

		List<WebElement> prdList = driver
				.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));

		boolean flag = false;
		for (WebElement prd : prdList) {

			String actData = prd.getText();
			if (actData.contains(PrdName)) {
				flag = true;
			break;
			}
		}
		if (flag) {
			System.out.println("Product name is deleted");
		}

		else {
			System.out.println("Product name is not deleted");
		}

		driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
	}

}
//........................
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

import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_utility;
import ObjectRepository.CreateProductPage;
import ObjectRepository.DeleteProductName;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.ProductLookUp;
import ObjectRepository.ValidatePrdName;

public class CreateProductAndDeleteProduct {

	public static void main(String[] args) throws Throwable {
		File_Utility flib = new File_Utility();
		WebDriver_utility wlib = new WebDriver_utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();

		// Reading data from file_utility

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

		ProductLookUp prdImg = new ProductLookUp(driver);
		prdImg.clickOnPlusSign();

		int ranNum = jlib.getRandomNum();

		String PrdName = elib.getExcelData("Product", 0, 0) + ranNum;

		System.out.println(PrdName);

		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.enterPrdName(PrdName);
		prdPage.clickSaveButton();

		ValidatePrdName validate = new ValidatePrdName(driver);
		validate.validatePrd(driver, PrdName);

		// -------------------------------------------------------------------------------------------------------------------------
		// Navigating to product table
		home.clickProductLink();

		DeleteProductName delete = new DeleteProductName(driver);
		delete.selectProdName(driver, PrdName);
		delete.selectDeletButton();

		wlib.alertAccept(driver);

		delete.validatePrdDeleted(driver, PrdName);

		home.logOutFromApp();
	}
}
*/
