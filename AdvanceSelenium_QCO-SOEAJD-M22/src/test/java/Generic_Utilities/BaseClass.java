package Generic_Utilities;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepo.LoginVtigerPage;
import ObjectRepo.VtigerHomePage;

public class BaseClass {
	public static TakesScreenshot sdriver;
	public WebDriver driver;

	@BeforeSuite(groups = {"smoke", "regression", "sanity"})
	public void bs() {
		System.out.println("DataBase connection");
	}

	@BeforeTest(groups = {"smoke", "regression", "sanity"})
	public void bt() {
		System.out.println("parallel execution");
	}
   @Parameters("BROWSER")
	@BeforeClass(groups = {"smoke", "regression", "sanity"})
	public void bc() throws Throwable {
		File_Utility flib = new File_Utility();
		String BROWSER = flib.getKeyAndValuePair("browser");
		/*
		 * String URL = flib.getKeyAndValuePair("url"); 
		 * String USERNAME = flib.getKeyAndValuePair("username"); 
		 * String PASSWORD = flib.getKeyAndValuePair("password");
		 */
  // public void bc(String BROWSER) throws Throwable {
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		System.out.println("launching browser");
	}
  //  @Parameters({"UNAME", "PWD", "URL"})
	@BeforeMethod
	//(groups = {"smoke", "regression", "sanity"})
   //public void BeforeMethod(String UNAME, String PWD, String URL) throws Throwable
    //{
	public void bm() throws Throwable {
		System.out.println("login to application");
		File_Utility flib = new File_Utility();
    	WebDriver_Utility wlib = new WebDriver_Utility();
		String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
		String PASSWORD = flib.getKeyAndValuePair("password");
		driver.get(URL);
		wlib.maximizeWindow(driver);
		wlib.waitForPageToLoad(driver);
		// using business logics
		LoginVtigerPage login = new LoginVtigerPage(driver);
		login.loginIntoVtiger(USERNAME, PASSWORD);
		//login.loginIntoVtiger(UNAME, PWD);
		//login.getUserTextField().sendKeys(UNAME);
		//login.getPassWordTextField().sendKeys(PWD);
		//login.getLoginButton().click();
	}

	@AfterMethod(groups = {"smoke", "regression", "sanity"})
	public void am() {
		
		VtigerHomePage home = new VtigerHomePage(driver);
		home.logoutApp();
		System.out.println("logout from Application");

	}

	@AfterClass(groups = {"smoke", "regression", "sanity"})
	public void ac() {

		driver.quit();
		System.out.println("close the browser");

	}

	@AfterTest(groups = {"smoke", "regression", "sanity"})
	public void at() {
		System.out.println("close parallel execution");
	}

	@AfterSuite(groups = {"smoke", "regression", "sanity"})
	public void as() {
		System.out.println("Data base close");
	}
}






















/*package Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {
 public WebDriver driver;
	
	@BeforeSuite
	public void bs() {
		System.out.println("DataBase connection");
	}

	@BeforeTest
	public void bt() {
		System.out.println("parallel execution");
	}

	@BeforeClass
	public void bc() throws Throwable {
		File_Utility flib = new File_Utility();
		String BROWSER = flib.getKeyAndValuePair("browser");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		System.out.println("launching browser");
	}

	@BeforeMethod
	public void bm() {
		System.out.println("login to application");
	}

	@AfterMethod
	public void am() {
		System.out.println("logout from Application");
	}

	@AfterClass
	public void ac() {
		System.out.println("close the browser");
	}

	@AfterTest
	public void at() {
		System.out.println("close parallel execution");
	}

	@AfterSuite
	public void as() {
		System.out.println("Data base close");
	}
}
*/