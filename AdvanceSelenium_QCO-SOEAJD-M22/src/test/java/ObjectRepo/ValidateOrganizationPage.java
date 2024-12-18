package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ValidateOrganizationPage {

	public ValidateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);

	}
	
	
	public String validateOrganization(WebDriver driver,String OrgName)
	{
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();

	//	if (actData.contains(OrgName)) {
	//		System.out.println("Organization Name is Created");
	//	} else {
	//		System.out.println("Organization name not created");
	//	}
		return actData;
	}
	
}
