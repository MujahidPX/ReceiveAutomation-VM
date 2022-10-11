package SiteTestCases.LocationsTests;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClasses.DriverBaseClass;
import BaseClasses.SendEmailReport.SendReport;
import Locations.LocationsPage;
import Login.LoginPage;
import Recipients.RecipientsPage;
import Settings.Locations.SettingsLocationsPage;
import SiteElements.SiteActions;
import Users.UsersPage;
import Utilities.GlobalVariables;

@Listeners({SendReport.class})
public class LocationsPageTests extends DriverBaseClass  {
	
	SiteActions siteActions;
	LoginPage loginPage;
	LocationsPage locationsPage;
	RecipientsPage recipientsPage;
	UsersPage usersPage;
	SettingsLocationsPage settingsLocationsPage;
	DriverBaseClass driverBaseClass;


	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass() {siteActions = new SiteActions(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass1() {loginPage = new LoginPage(driver, wait);}

	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass2() {recipientsPage = new RecipientsPage(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass3() {locationsPage = new LocationsPage(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass4() {usersPage = new UsersPage(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass5() {settingsLocationsPage = new SettingsLocationsPage(driver, wait);}
	
	@Test(groups =  {"Locations"} , enabled = true)
	@Parameters({"url"})
	public void CreateNewLocation(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail, GlobalVariables.AutomationPassword);
		locationsPage.createNewLocation(GlobalVariables.Location);
		loginPage.logout();
	}
	
	@Test(groups =  {"Locations"} , enabled = true)
	@Parameters({"url"})
	public void CreateNewLocationNoState(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail1, GlobalVariables.AutomationPassword1);
		locationsPage.createNewLocation(GlobalVariables.LocationNoState);
		loginPage.logout();
	}
	
	@Test(groups =  {"SuperAdmin","Locations"} , enabled=true)
	@Parameters({"url"})
	public void SuperAdminCreateNewLocation(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.loginSuperAdmin(GlobalVariables.SuperAdminEmail, GlobalVariables.SuperAdminPassword);		
		locationsPage.createNewLocation(GlobalVariables.Location);
		loginPage.logout();
	}
	
	@Test(groups =  {"Locations"} , enabled = true)
	@Parameters({"url"})
	public void EditLocation_AddManager(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.Automation1Email, GlobalVariables.Automation1Password);
		locationsPage.editLocation(GlobalVariables.AddNewManagerEmail, GlobalVariables.ManagerUserRole);
		loginPage.logout();
	}
	
	@Test(groups =  {"Locations"} , enabled = true)
	@Parameters({"url"})
	public void EditLocation_AddOperator(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.Automation1Email, GlobalVariables.Automation1Password);
		locationsPage.editLocation(GlobalVariables.AddNewOperatorEmail, GlobalVariables.OperatorUserRole);
		loginPage.logout();
	}
	
	@Test(groups =  {"Locations"} , enabled = true)
	@Parameters({"url"})
	public void EmailTemplates(@Optional String url) throws InterruptedException, AWTException, IOException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.Automation1Email, GlobalVariables.Automation1Password);
		locationsPage.emailTemplate();
		loginPage.logout();
	}
	
	@Test(groups =  {"Locations"} , enabled = true)
	@Parameters({"url","code"})
	public void AddMailroom(@Optional String url, @Optional String code) throws InterruptedException, AWTException, IOException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.Automation1Email, GlobalVariables.Automation1Password);
		locationsPage.addMailroom(GlobalVariables.MailroomCode);
		loginPage.logout();
	}
	
	@Test(groups =  {"Locations"} , enabled = true)
	@Parameters({"url"})
	public void ReceiveConnect(@Optional String url) throws InterruptedException, AWTException, IOException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.Automation1Email, GlobalVariables.Automation1Password);
		locationsPage.receiveConnect();
		loginPage.logout();
	}
}
