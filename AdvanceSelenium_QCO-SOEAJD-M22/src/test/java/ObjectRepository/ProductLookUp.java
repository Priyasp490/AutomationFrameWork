package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductLookUp {

	public ProductLookUp(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@title=\"Create Product...\"]")
	private WebElement prdPlusSign;

	public WebElement getPrdPlusSign() {
		return prdPlusSign;
	}

	public void clickOnPlusSign() {
		prdPlusSign.click();
	}
}
//...................
/*
Product Implementation
***********************
package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductLookUp {

	public ProductLookUp(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@title=\"Create Product...\"]")
	private WebElement prdPlusSign;

	public WebElement getPrdPlusSign() {
		return prdPlusSign;
	}

	public void clickOnPlusSign() {
		prdPlusSign.click();
	}
}
*/
//...............
/*
package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {

	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "productname")
	private WebElement prdName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getPrdName() {
		return prdName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void enterPrdName(String Name)
	{
		prdName.sendKeys(Name);
	}
	public void clickSaveButton()
	{
		saveButton.click();
	}
}
*/
//.............................
/*
CreateProduct and Delete product implementation
************************************************
package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductLookUp {

	public ProductLookUp(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@title=\"Create Product...\"]")
	private WebElement prdPlusSign;

	public WebElement getPrdPlusSign() {
		return prdPlusSign;
	}

	public void clickOnPlusSign() {
		prdPlusSign.click();
	}
}
*/