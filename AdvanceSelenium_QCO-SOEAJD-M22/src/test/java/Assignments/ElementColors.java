package Assignments;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementColors {

	public static void main(String[] args) {
		//Pull back
		//I am Pushing code to GitHub
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("field-keywords")).sendKeys("iphone",Keys.ENTER);
//List<WebElement> allColors = driver.findElements(By.xpath("//span[text()='Apple iPhone 13 (128GB) - Starlight']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']//div[@class='a-section a-spacing-none a-spacing-top-mini s-color-swatch-container-list-view']//a"));
	
		 List<WebElement> allColors = driver.findElements(By.xpath("//span[text()='Apple iPhone 13 (128GB) - Midnight']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']//div[@class='a-section a-spacing-none a-spacing-top-mini s-color-swatch-container-list-view']//a"));
	for (WebElement color : allColors)
	{
		String value = color.getAttribute("aria-label");
		System.out.println(value);
	}
	
	
	
	}

}
/*
 *Assignment1:-    https://www.google.com/search?q=pro+kabaddi+schedule&oq 

Nov 22 - 12:52 pm
print Team names and timings of the match 

Nov 22 - 12:52 pm
Assignment2:---     https://www.prokabaddi.com/standings 

Nov 22 - 12:52 pm
Print complete status of the a team 
*/
