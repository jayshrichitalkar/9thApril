package KiteBase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import utility.UtilityNew;

public class BaseNew1 
{
	
protected static WebDriver driver;
	
	public void openApplication() throws EncryptedDocumentException, IOException
	{
		System.setProperty("webdriver.chrome.driver","D:\\9th_april_eve\\ChromeDriver.exe");
		driver=new ChromeDriver();
	    driver.manage().window().maximize();
		driver.get(UtilityNew.readDataFromPropertyFile("URL"));
		
		Reporter.log("Launching Kite App",true);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		
	}
	
	public  void captureScreenShot(String TCName)throws IOException 
	   {
		    File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    File des = new File("D:\\9th_april_eve\\screenshot\\"+TCName+".png");
		    FileHandler.copy(src, des);
		    
		    Reporter.log("Takan Screenshot",true);
	   }
}
