package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class UtilityNew 
{
	public static String readDataFromPropertyFile(String key) throws EncryptedDocumentException, IOException
	   {
		   Properties prop=new Properties();
		   FileInputStream myFile = new FileInputStream("C:\\Users\\JAYSHRI\\eclipse-workspace\\9thAprilEvening\\myProperty.properties"); 
		   prop.load(myFile);
		   String value = prop.getProperty(key);
		    return value;
	   }
	   
	   public static void captureScreenShot(WebDriver driver,String TCID) throws IOException 
	   {
		    File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    File des = new File("D:\\9th_april_eve\\screenshot\\TC"+TCID+".png");
		   FileHandler.copy(src, des);
		    
		    Reporter.log("Takan Screenshot",true);
	   }
}
