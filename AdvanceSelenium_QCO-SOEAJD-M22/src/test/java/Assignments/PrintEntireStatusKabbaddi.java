package Assignments;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class PrintEntireStatusKabbaddi {

	public static void main(String[] args) throws Throwable {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enetr team name: ");
		String Team=sc.next();
		
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.prokabaddi.com/standings");
		
		List<WebElement> EntireRow = driver.findElements(By.xpath("//p[contains(text(),'"+Team+"')]//ancestor::div[@class='row-head']//div//descendant::p"));
		
		for(WebElement row:EntireRow)
		{
			System.out.print(row.getText()+"\t");
		}
	
		
		Thread.sleep(1000);
		driver.quit();
	}

} 
