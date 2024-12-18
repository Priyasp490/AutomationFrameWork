
package DDT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ObjectRepository.FindBysAndFindAll;

public class ImplementationAnnotation {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");

		FindBysAndFindAll login = new FindBysAndFindAll(driver);
		login.enterName("admin", "admin");
}}

