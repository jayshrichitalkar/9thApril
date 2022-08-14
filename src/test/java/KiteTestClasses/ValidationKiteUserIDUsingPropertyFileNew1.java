package KiteTestClasses;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import KiteBase.BaseNew1;
import KitePomClasses.KiteHomePage;
import KitePomClasses.KiteLoginPage;
import KitePomClasses.KitePinPage;
import utility.UtilityNew;

@Listeners(utility.Listener.class)

public class ValidationKiteUserIDUsingPropertyFileNew1 extends BaseNew1
{
	KiteHomePage home;
	KiteLoginPage login;
	KitePinPage pin;
	
	
	@BeforeClass
	public void launchBrowser() throws EncryptedDocumentException, IOException
	{
		openApplication();
		
	
		login=new KiteLoginPage(driver);
		pin=new KitePinPage(driver);
		home=new KiteHomePage(driver);
		
	}
	
	@BeforeMethod
	public void loginToKiteApp() throws EncryptedDocumentException, IOException
	{
		login.sendUserID(UtilityNew.readDataFromPropertyFile("UN"));
		login.sendPassword(UtilityNew.readDataFromPropertyFile("PWD"));
		login.clickOnLoginButton();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		//Utility.Wait(driver, 1000);
		
		pin.sendPin(UtilityNew.readDataFromPropertyFile("PIN"));
		pin.clickOnContinueButton();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		//Utility.Wait(driver, 1000);
	}
		
  @Test
  public void kiteUserValidation() throws EncryptedDocumentException, IOException
  {
	  //String TCID="11";
	  String actualUserID=home.getActualUserID();
	  String expectedUserID=UtilityNew.readDataFromPropertyFile("UN1");
	  
	  Assert.assertEquals(actualUserID,expectedUserID,"TC failed actual and expected UserID are not matching");
	  Reporter.log("actual and expected are matching tc is passed",true);
	  
	  //UtilityNew.captureScreenShot(driver, TCID);	  	  
  }
  
  @AfterMethod
  public void LogOutFromKitApp() throws InterruptedException
  {
	home.ClickOnLogOutButton();  
  }
  
  @AfterClass
  public void CloseBrowser() throws InterruptedException
  {
	driver.close();  
  }
   
}
