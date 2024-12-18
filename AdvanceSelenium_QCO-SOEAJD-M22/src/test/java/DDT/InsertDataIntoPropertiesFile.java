package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InsertDataIntoPropertiesFile {

	public static void main(String[] args) throws Throwable {
		
		//Inserting/writing data to Properties_File
		FileInputStream fis=new FileInputStream("./src/test/resources/CommomData.properties");
		//create an object to properties class to load all the keys
		Properties pro=new Properties();
		pro.setProperty("browser","firefox");
		pro.setProperty("url","http://localhost:8888");//"https://www.saucedemo.com/v1/", 
		pro.setProperty("username","admin");//"standard_user"
		pro.setProperty("password","admin");//"secret_sauce"
		FileOutputStream fos=new FileOutputStream("./src/test/resources/CommomData.properties");
		pro.store(fos, "CommonData");
		System.out.println("successfully inserted the data into PropertiesFile");//data written successfully
		//.................................................................................
		
		//Fetching/read the data from Properties File
		WebDriver driver;//WebDriver driver=new ChromeDriver();//driver.manage().window().maximize();
		pro.load(fis);
		String BROWSER=pro.getProperty("browser");
		String URL=pro.getProperty("url");
		String USERNAME=pro.getProperty("username");
		String PASSWORD=pro.getProperty("password");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
	
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
	

	}

}
