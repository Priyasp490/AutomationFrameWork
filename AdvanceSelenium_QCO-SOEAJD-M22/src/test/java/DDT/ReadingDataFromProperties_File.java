package DDT;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadingDataFromProperties_File {

	public static void main(String[] args) throws IOException{
		WebDriver driver=new ChromeDriver();
		//Step1: Giving the physical representation of the file path
		//FileInputStream fis=new FileInputStream("C:\\Users\\malat\\Downloads\\CommonData.properties.txt");
		FileInputStream fis=new FileInputStream("./src/test/resources/CommomData.properties");
		//Step2: Loading all the "keys" into properties class
		Properties pro=new Properties();
		pro.load(fis);
		//step3: reading keys from properties file
		String URL=pro.getProperty("url");
		String USERNAME=pro.getProperty("username");
		String PASSWORD=pro.getProperty("password");
		driver.get(URL);
		driver.findElement(By.name("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
	}

}
