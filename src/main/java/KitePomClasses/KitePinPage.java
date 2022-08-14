package KitePomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KitePinPage 
{
    //1.
	@FindBy(id="pin") private WebElement pin;
	@FindBy(xpath="//button[@type='submit']") private WebElement ContinueButton;
	
	//2.
	
	public KitePinPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//3.
	 public void sendPin(String PIN)
	 {
		 pin.sendKeys(PIN);
	 }
	 
	 public void clickOnContinueButton()
	 {
		 ContinueButton.click();
	 }
}
