package Assignments;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class PrintNameAndTimeTodaySKabbaddi {

	public static void main(String[] args) throws Throwable {
	
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.google.com/search?q=pro+kabaddi+schedule&oq");
		
//		List<WebElement> Todays = driver.findElements(By.xpath("//span[text()='today']//ancestor::div[@class='tsp-fr tsp-fs tsp-cpd tsp-rpd tsp-cbd']"));
//		//List<WebElement> Timings = driver.findElements(By.xpath("//span[text()='today']/../../../../..//div[@class=\"tsp-frs tsp-pl4\"]"));
//
//		for(WebElement today:Todays)
	//	{
			List<WebElement> Spans = driver.findElements(By.xpath("//span[text()='today']//ancestor::div[@class='tsp-fr tsp-fs tsp-cpd tsp-rpd tsp-cbd']//descendant::span"));
			int i=0;
			for(WebElement eachspan:Spans)
			{
				
				System.out.print(eachspan.getText()+"\t");
				i++;
				if(i==8)
					System.out.println();
			}
			
		//}
		
		Thread.sleep(1000);
		driver.quit();
	}

}
  