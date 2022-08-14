package KitePomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteHomePage
{
    //1.
	
	@FindBy(xpath="//span[@class='user-id']") private WebElement uID;
	@FindBy(xpath="//a[@target='_self']") private WebElement LogOutButton;
	
	//2.
	
	public KiteHomePage (WebDriver driver)
	{
		PageFactory.initElements(driver,this); 
	}
	
	//3.
	
//	public void  validateUserId(String username)
//	{
//		String expectedUserId=username;
//		String actualUserId=uID.getText();	
//		if(expectedUserId.equals(actualUserId))
//	    {
//			System.out.println("Actual user id is match with excepted userid then test case is pass");
//		}
//		else
//		{
//			System.out.println("test case fail");
//		}
//	}
	
	public String getActualUserID()
	{
		String actualUserID = uID.getText();
		return actualUserID;
	}
	
		
		public void ClickOnLogOutButton() throws InterruptedException
		{
			
		uID.click();
		Thread.sleep(200);
		LogOutButton.click();
		
		}
	
	}
	
	
	
	
	
	
	

