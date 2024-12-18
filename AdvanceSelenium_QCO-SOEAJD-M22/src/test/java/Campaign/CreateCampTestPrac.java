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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Uilities.BaseClass;
import Generic_Uilities.Excel_Utility;
import Generic_Uilities.File_Utility;
import Generic_Uilities.Java_Utility;
import Generic_Uilities.WebDriver_Utility;
import ObjectRepo.CampDetailedPage;
import ObjectRepo.CampValidatePage;
import ObjectRepo.CreateCampPage;
import ObjectRepo.CreateProductPage;
import ObjectRepo.LoginVtigerPage;
import ObjectRepo.ProductDetailedPage;
import ObjectRepo.ProductValidate;
import ObjectRepo.VtigerHomePage;

//@Listeners(Generic_Uilities.Listener.class)
@Listeners(Generic_Utilities.ExtentReport.class)
public class CreateCampTestPrac extends BaseClass {

//	@Test(retryAnalyzer = Generic_Uilities.RetryImp.class)
	@Test
	public void createCampaignTest() throws Throwable {

		Generic_Utilities.WebDriver_Utility wlib = new Generic_Utilities.WebDriver_Utility();
		Generic_Utilities.Java_Utility jlib = new Generic_Utilities.Java_Utility();
		Generic_Utilities.Excel_Utility elib = new Generic_Utilities.Excel_Utility();
		Generic_Utilities.File_Utility flib = new Generic_Utilities.File_Utility();

		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickMoreLink();
		home.clickCampLink();

		CampDetailedPage img = new CampDetailedPage(driver);
		img.clickCampLookUpImg();
	
		
		System.out.println("Failing script");

		int ranNum = jlib.getRandomNum();
//----------------------------------------------------------------------------------------------------------		

		String CampName = elib.readExcelData("Campaign", 0, 0) + ranNum;

		CreateCampPage createPage = new CreateCampPage(driver);
		createPage.enterCampName(CampName);

		createPage.clickSaveButton();
		http://Assert.fail();

		CampValidatePage validate = new CampValidatePage(driver);
		String actData = validate.validateCampaign(driver, CampName);
	//	Assert.assertEquals(actData, CampName);
		System.out.println("Campagin Name is created");
		

	}
}
//	=============================================================================================
 