package BaseClasses;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class GetScreenShot {

	/*
    public static String capture(WebDriver driver,String screenShotName) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") +"\\ErrorScreenshots\\"+screenShotName+".png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);        

        return dest;
    }
	 */

	/*
	public static String getScreenshots(WebDriver driver)
	{

		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png";
		File destination=new File(path);

		try
		{
			FileUtils.copyFile(src, destination);
		}
		catch (IOException e)
		{
			System.out.println("Capture Failed "+e.getMessage());
		}
		return path;

	}
	*/
	
	//Creating a method getScreenshot and passing two parameters
	//driver and screenshotName
	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
	                //below line is just to append the date format with the screenshot name to avoid duplicate names
	                String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	                //after execution, you could see a folder “FailedTestsScreenshots” under src folder
	String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
	File finalDestination = new File(destination);
	FileUtils.copyFile(source, finalDestination);
	                //Returns the captured file path
	return destination;
	}

}
