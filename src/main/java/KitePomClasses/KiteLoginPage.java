package KitePomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLoginPage 
{

	//1.Data Members Declaration
	// Data members should be declared globally with access level private using
	
	@FindBy(id="userid") private WebElement userID;
	@FindBy(id="password") private WebElement password;
	@FindBy(xpath="//button[@type='submit']") private WebElement loginButton;
	
	//2.Data Initialization
	// Data initialize within a constructor with access level public using pagefactory
	
	public  KiteLoginPage (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//3. Usage/methods
	// Utilize within a method with access level public
	
	public void sendUserID(String UN)
	{
		userID.sendKeys(UN);
	}
	
	public void sendPassword(String PWD)
	{
		password.sendKeys(PWD);
	}
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
		
	
}
