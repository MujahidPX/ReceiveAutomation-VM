package SiteTestCases.AnalyticsTests;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Analytics.AnalyticsPage;
import BaseClasses.DriverBaseClass;
//import BaseClasses.SendEmailReport.SendReport;
import Login.LoginPage;
import SiteElements.SiteActions;
import Utilities.GlobalVariables;
import Utilities.Waits;


public class AnalyticsPageTests extends DriverBaseClass {	
	
	SiteActions siteActions;
	LoginPage loginPage;
	AnalyticsPage analyticsPage;
	DriverBaseClass driverBaseClass;

	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass() {siteActions = new SiteActions(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass1() {loginPage = new LoginPage(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass2() {analyticsPage = new AnalyticsPage(driver, wait);}
	
	@Test(groups =  {"Analytics"} , enabled = true)
	@Parameters({"url"})
	public void Analytics(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail1, GlobalVariables.AutomationPassword1);
		analyticsPage.scanTrends();
		analyticsPage.currentlyHeldItems();
		loginPage.logout();
	}
	
	@Test(groups =  {"Analytics"} , enabled = true)
	@Parameters({"url"})
	public void GlobalSearch(@Optional String url) throws InterruptedException, IOException, AWTException {
	
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail1, GlobalVariables.AutomationPassword1);
		//loginPage.selectLocationFromSearch();
		loginPage.globalSearch();
		Waits.waitTime(2);
		loginPage.logout();
	}

}
