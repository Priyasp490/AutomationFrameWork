package Campaign;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepo.ValidateCampaignPage;
import ObjectRepo.CreateCampPage;
import ObjectRepo.CreateProductPage;
import ObjectRepo.LoginVtigerPage;
import ObjectRepo.PrdDetailedPage;
import ObjectRepo.ValidateProductPage;
import ObjectRepo.VtigerHomePage;

public class CreateCampaignWithProductTest extends BaseClass{

//		public static void main(String[] args) throws Throwable {
        @Test(groups = "sanity")
		public void createCampaignWithProductTest() throws Throwable {	
			
			WebDriver_Utility wlib = new WebDriver_Utility();
			File_Utility flib = new File_Utility();
			Excel_Utility elib = new Excel_Utility();
			Java_Utility jlib = new Java_Utility();
			//WebDriver driver;
			
		   // String BROWSER = flib.getKeyAndValuePair("browser");
			//String URL = flib.getKeyAndValuePair("url");
			//String USERNAME = flib.getKeyAndValuePair("username");
			//String PASSWORD = flib.getKeyAndValuePair("password");

		//	if (BROWSER.equalsIgnoreCase("chrome")) {
		//		driver = new ChromeDriver();
		//} else if (BROWSER.equalsIgnoreCase("firefox")) {
		//		driver = new FirefoxDriver();
		//	} else if (BROWSER.equalsIgnoreCase("edge")) {
		//		driver = new EdgeDriver();
		//	} else {
		//		driver = new ChromeDriver();
		//	}
			
		//	wlib.maximizeWindow(driver);
		//	wlib.waitForPageToLoad(driver);
	    //driver.get(URL);	
			
			// using business logics
			//LoginVtigerPage login = new LoginVtigerPage(driver);
			//login.loginIntoVtiger(USERNAME, PASSWORD);
			
			VtigerHomePage home=new VtigerHomePage(driver);
			home.clickPrdLink();
			
			PrdDetailedPage prdPlus=new PrdDetailedPage(driver);
			prdPlus.clickPrdLookUpImg();
			int ranNum = jlib.getRandomNum();
			//driver.findElement(By.cssSelector("[alt=\"create Campaign...\"]")).click();
			
			//Random Class-------> generating unique values(Avoid Duplicate value)
	//----------------------------------------------------------------------------------------------------------		

			String PrdName = elib.readExcelData("Product", 0, 0) + ranNum;// getExcelData

			CreateProductPage createPage = new CreateProductPage(driver);
			createPage.enterPrdName(PrdName);
			
			createPage.clickSaveButton();

			ValidateProductPage validate = new ValidateProductPage(driver);
			validate.validatePrd(driver, PrdName);

			//home.logoutApp();
		}

	}
