package ObjectRepo;

import org.openqa.selenium.By;
//org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ValidateCampaignPage {

	public ValidateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/**
	 * 
	 * @param driver
	 * @param CampName
	 * @return
	 */
	public String validateCampaign(WebDriver driver,String CampName)
	{
		String actData = driver.findElement(By.id("detailedlview_Campaign Name")).getText();

	//	if (actData.contains(CampName)) {
	//		System.out.println("Campaign Name is Created");
	//	} else {
	//		System.out.println("Campaign Name is not Created");
		//}
	return actData;

	}
	
}