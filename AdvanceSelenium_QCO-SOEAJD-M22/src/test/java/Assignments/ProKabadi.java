package Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProKabadi {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.prokabaddi.com/standings");
		String teamName="Tamil Thalaivas";
	
		System.out.println("palyed = "+driver.findElement(By.xpath("//p[.='"+teamName+"']/ancestor::div[@class='table-data team']/following-sibling::div[@class='table-data matches-play']")).getText());
	    System.out.println("won = "+driver.findElement(By.xpath("//p[.='"+teamName+"']/ancestor::div[@class='table-data team']/following-sibling::div[@class='table-data matches-won']")).getText());
		System.out.println("lost = "+driver.findElement(By.xpath("//p[.='"+teamName+"']/ancestor::div[@class='table-data team']/following-sibling::div[@class='table-data matches-lost']")).getText());
		System.out.println("draw = "+driver.findElement(By.xpath("//p[.='"+teamName+"']/ancestor::div[@class='table-data team']/following-sibling::div[@class='table-data matches-draw']")).getText());
		System.out.println("score diff = "+driver.findElement(By.xpath("//p[.='"+teamName+"']/ancestor::div[@class='table-data team']/following-sibling::div[@class='table-data score-diff']")).getText());
		System.out.println("points = "+driver.findElement(By.xpath("//p[.='"+teamName+"']/ancestor::div[@class='table-data team']/following-sibling::div[@class='table-data points']")).getText());
		List<WebElement> form = driver.findElements(By.xpath("//p[.='"+teamName+"']/ancestor::div[@class='table-data team']/following-sibling::div[@class='table-data form']//li"));
		System.out.println("Form");
		for(int i=0;i<form.size();i++)
		{
			System.out.print(form.get(i).getText());
		}		
		driver.quit();
	}
}