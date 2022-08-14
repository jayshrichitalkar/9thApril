package utility;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;


import KiteBase.BaseNew1;



public class Listener  implements ITestListener
{
	 
	BaseNew1 b=new BaseNew1();
	
   public void onTestStart(ITestResult result)
    {
    	Reporter.log("TC execution is started "+result.getName(),true);
    }
	
	
	   public void onTestSkipped(ITestResult result)
	    {
	    	Reporter.log("TC execution is skipped "+result.getName(),true);
	    }
	
	
	   public void onTestFailure(ITestResult result)
	    {
		  String TCName=result.getName();
		 //Reporter.log("TC execution is failed "+result.getName(),true);
		 try
		 {
			
			b.captureScreenShot(TCName);
		 }
		 catch(IOException e)
		 {
			 e.printStackTrace();
		 }
	    }
	

	   public void onTestSuccess(ITestResult result)
	    {
	    	Reporter.log("TC execution is successful "+result.getName(),true);
	    }
	
	
}
