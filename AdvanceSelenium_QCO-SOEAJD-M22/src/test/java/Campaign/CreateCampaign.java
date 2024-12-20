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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepo.CampDetailedPage;
import ObjectRepo.ValidateCampaignPage;
import ObjectRepo.CreateCampPage;
import ObjectRepo.LoginVtigerPage;
import ObjectRepo.VtigerHomePage;
import ObjectRepository.CampaignCreateNavigationPage;
import ObjectRepository.CreateCampaignPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.ValidateCampaigns;

public class CreateCampaign {

	public static void main(String[] args) throws Throwable {
		// I am 1st eng - gitbash
		WebDriver_Utility wlib = new WebDriver_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
		File_Utility flib = new File_Utility();
		
		WebDriver driver;
		
		// Reading data from file_utility
		String BROWSER = flib.getKeyAndValuePair("browser");
		String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
		String PASSWORD = flib.getKeyAndValuePair("password");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} 
		else {
			driver = new ChromeDriver();
		}
		driver.get(URL);
		//using getter methods
		//LoginVtigerPage login=new LoginVtigerPage(driver);
		//login.getUserTextfield().sendKeys(USERNAME);
		//login.getPasswordTextfield().sendKeys(PASSWORD);
		//login.getLoginButton().click();
		
		

		//Using Business logics
		LoginVtigerPage login=new LoginVtigerPage(driver);
		login.loginIntoVtiger(USERNAME, PASSWORD);
		
		wlib.maximizeWindow(driver);
		wlib.waitForPageToLoad(driver);
		
		//wlib.waitForElementsToLoad(driver);

		//driver.findElement(By.linkText("More")).click();
		//driver.findElement(BY.linkText("Campaigns")).click();
		
		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickMoreLink();
		home.clickCampLink();
		
		CampDetailedPage img=new CampDetailedPage(driver);
		img.clickCampLookUpImg();
        
	//	driver.findElement(By.cssSelector("[alt=\"Create Campaign...\"]")).click();
		
		//RanDom Class ---->generating unique values(Avoid Duplicate value)

		int ranNum=jlib.getRandomNum();
		//---------------------------------------------------------------------------
		
		//CampaignCreateNavigationPage camp = new CampaignCreateNavigationPage(driver);
		//camp.clickCampPlus();

     	String CampName = elib.readExcelData("Campaign", 0, 0) + ranNum;//readExcelData or getexceldata both are same
		//System.out.println(CampName);
         
     	//driver.findElement(By.name("campaignname")).sendKeys(CampName);
     	//driver.findElement(By.cssSelector("title=\"Save[Alt+S]\"]")).click();
     	
     	CreateCampPage createPage = new CreateCampPage(driver);
     	createPage.enterCampName(CampName);
     	createPage.clickSaveButton();
     	
     	//String actData=driver.findElement(By.id("dtlview_CampaignName")).getText();
     	//if(actData.contains(CampName))
     	//{
     	//	System.out.println("Campaign Name is Created");
     	//}else
     	//{
     	//	System.out.println("Campaign Name is not Created");

     	//}
     	

		ValidateCampaignPage validate = new ValidateCampaignPage(driver);
		validate.validateCampaign(driver, CampName);
     	
     	//driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
     	//driver.findElement(By.linkText("SignOut")).click();
		home.logoutApp();
     	
     	
	}

}
