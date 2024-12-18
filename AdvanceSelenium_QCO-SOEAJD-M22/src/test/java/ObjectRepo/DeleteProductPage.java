package ObjectRepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProductPage {

	public DeleteProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@value=\"Delete\"]")
	private WebElement DeleteButton;
	
	/*
	 * This method is used to select prdName in table
	 * @param driver
	 * @param PrdName
	 */
	public void selectPrdCheckBox(WebDriver driver,String PrdName )
	{
		driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='" + PrdName
				+ "']/../preceding-sibling::td//input[@type='checkbox']")).click();
	}
	/*
	 * This method is used to click delete button
	 */
	
	public void clicktDeletButton()
	{
		DeleteButton.click();
	}
	
	public String validatePrdDeleted(WebDriver driver,String PrdName)
	{
		//WebElement prd = driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='" + PrdName + "']"));
		//if (prd.equals(PrdName)) {
		//	System.out.println("Product Name is Present");
		//} else {
		//	System.out.println("Product name is not Present");
		//}
		List<WebElement> prdList = driver
			.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));

	boolean flag = false;
	for (WebElement prd : prdList) {

	String actData = prd.getText();
	if (actData.contains(PrdName)) {
	flag = true;
	break;
	}
	}
	if (flag) {
		System.out.println("Product name is deleted");
	}

	else {
		System.out.println("Product name is not deleted");
		}
	return PrdName;

	}

	
}
