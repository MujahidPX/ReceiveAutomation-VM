package SiteTestCases.SettingsTests.APIandWebhooksTests;

import java.awt.HeadlessException;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClasses.DriverBaseClass;
//import BaseClasses.SendEmailReport.SendReport;
import Login.LoginPage;
import Recipients.RecipientsPage;
import Settings.APIandWebhooks.APIandWebhooksPage;
import Settings.CompanyManagement.CompanyManagementPage;
import SiteElements.SiteActions;
import Users.UsersPage;
import Utilities.GlobalVariables;
import Utilities.Waits;


public class APIandWebhooksTestsPage extends DriverBaseClass {

	SiteActions siteActions;
	LoginPage loginPage;
	UsersPage usersPage;
	RecipientsPage recipientsPage;
	DriverBaseClass driverBaseClass;
	APIandWebhooksPage apiAndWebhooksPage;
	

	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass() {siteActions = new SiteActions(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass1() {loginPage = new LoginPage(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass2() {apiAndWebhooksPage = new APIandWebhooksPage(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass3() {usersPage = new UsersPage(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass4() {recipientsPage = new RecipientsPage(driver, wait);}
	
	
	@Test(groups =  {"Settings", "APIandWebhooks"} , enabled = true)
	@Parameters({"url"})
	public void GenerateAPIKey(@Optional String url) throws InterruptedException, HeadlessException, UnsupportedFlavorException, IOException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail1, GlobalVariables.AutomationPassword1);
		apiAndWebhooksPage.generateAPIKey();
		//apiAndWebhooksPage.generateLabelOCRAPIKey();
		loginPage.logout();
		
	}
	
	@Test(groups =  {"Settings", "APIandWebhooks"} , enabled = true)
	@Parameters({"url"})
	public void GenerateLabelOCRAPIKey(@Optional String url) throws InterruptedException, HeadlessException, UnsupportedFlavorException, IOException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail1, GlobalVariables.AutomationPassword1);
		apiAndWebhooksPage.generateLabelOCRAPIKey();
		Waits.waitTime(2);
		loginPage.logout();
		
	}
	
	@Test(groups =  {"Settings", "APIandWebhooks"} , enabled = true)
	@Parameters({"url"})
	public void CreateWebhooks(@Optional String url) throws InterruptedException, HeadlessException, UnsupportedFlavorException, IOException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail1, GlobalVariables.AutomationPassword1);
		apiAndWebhooksPage.createWebHooks();
		apiAndWebhooksPage.editWebhooks();
		loginPage.logout();
		
	}
	
}
