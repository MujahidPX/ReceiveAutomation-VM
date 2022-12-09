package BaseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;


import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
//import java.io.File;
//import java.lang.String;

import Reporting.EReport;
import RetryListener.Retry;
import SiteElements.SiteActions;
import Utilities.GlobalVariables;
import Utilities.Waits;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.EmailException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class DriverBaseClass {

	protected WebDriver driver;
	protected WebDriverWait wait;
	//private static WebDriver driver;
	
	public ExtentReports extent;
	public ExtentTest extentTest;
	public EReport report;
	SiteActions siteActions;
	SlackIntegration slackIntegration;
	//EReport report;
	
    //ExtentTest test;
    //WebDriver driver;


	public static WebDriver chrome_driver() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		return null;
	}

	public static WebDriver firefox_driver(){
		System.setProperty("webdriver.firefox.driver", "Drivers/geckodriver.exe");
		return null;
	}
	//@BeforeTest
//	public void setExtent(){
//		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/MailRoomAutomation.html", true);		
//	}

	/*
	@BeforeTest
	public void setExtent(){
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);
		extent.addSystemInfo("Host Name", " Mac");
		extent.addSystemInfo("User Name", "Automation Labs");
		extent.addSystemInfo("Environment", "QA");
		
	}
	
	@AfterTest
	public void endReport(){
		extent.flush();
		extent.close();
	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	*/
	
	public void getScreenshot() {

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("C:\\Users\\QA.User\\Desktop\\Receive_Automation\\ErrorScreenshots\\"+dateName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	@Parameters("browser")
	//@BeforeClass(alwaysRun = true)
	@BeforeTest(alwaysRun = true)
	//@BeforeMethod(alwaysRun = true)
	public void initDriver(@Optional String browser) throws InterruptedException {
		if(driver == null) {
			
			 /////extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentScreenshot.html", true);
				
			
			
			/*
			if(browser.equalsIgnoreCase("Chrome")) 
			{
				//String url = "";
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if (browser.equalsIgnoreCase("Firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else if (browser.equalsIgnoreCase("Edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			
			driver.manage().window().maximize();
			*/
			
			
			// Headless Mode
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setHeadless(false);
			chromeOptions.addArguments("--incognito");
			driver = new ChromeDriver(chromeOptions); 
			driver.manage().window().maximize();
			//siteActions.navigateURL(GlobalVariables.qa_Url);
			
			
			//WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			//driver.manage().window().maximize();
			
			
			/*
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			*/
			
			/*
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			*/

			/*
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			driver.manage().window().maximize();
			*/
			

			/*
			driver = DriverBaseClass.chrome_driver();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			*/
			
			//driver = DriverBaseClass.firefox_driver();
			//driver = new FirefoxDriver();
			
			
		}

	}
	
	 
	@AfterTest(alwaysRun = true)
	public void closeDriver() throws EmailException {
		
//			getScreenshot();						
				
		if(driver != null) {
			
			driver.close();
			driver.quit();
		}
		
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result)
	{

		if(ITestResult.FAILURE == result.getStatus())

		{
			getScreenshot();
			
		}
		
	}
	
	
	@AfterSuite(alwaysRun = true)
	
	public void onFinish(ITestContext context) {
		for(int i=0; i<context.getAllTestMethods().length; i++){
			if(context.getAllTestMethods()[i].getCurrentInvocationCount() == 2){
				if (context.getFailedTests().getResults(context.getAllTestMethods()[i]).size() == 2 || context.getPassedTests().getResults(context.getAllTestMethods()[i]).size() == 1){
					
						context.getFailedTests().removeResult(context.getAllTestMethods()[i]);
				}
			}
		}
	}
	
	/*
	//public void SendEmailReport(String testReportPath) throws Exception {
		public void SendEmailReport() throws Exception {
		
		//SiteActions.sendEmail();
		
		//EReport.sendEmail();
		//SlackIntegration.ReportToSlack(testReportPath);
		//SlackIntegration.sendTestExecutionStatusToSlack(message);
		//SlackIntegration.sendTestExecutionReportToSlack(testReportPath);
	}
	*/
	
	
	
	
	/*
	@AfterMethod
	public void closeDriver(ITestResult result) throws IOException{
		
		if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
			
			String screenshotPath = DriverBaseClass.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
			//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

		}
		
		
		extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
		driver.quit();
	}
	*/

}
