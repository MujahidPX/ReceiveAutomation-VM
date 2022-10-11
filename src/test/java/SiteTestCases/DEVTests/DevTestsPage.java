package SiteTestCases.DEVTests;

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
import Locations.LocationsPage;
import Login.LoginPage;
import Recipients.RecipientsPage;
import Settings.PlanAndBilling.PlanAndBillingPage;
import SiteElements.SiteActions;
import Users.UsersPage;
import Utilities.GlobalVariables;
import Utilities.Waits;


public class DevTestsPage extends DriverBaseClass {

	SiteActions siteActions;
	LoginPage loginPage;
	DriverBaseClass driverBaseClass;
	UsersPage usersPage;
	RecipientsPage recipientsPage;
	LocationsPage locationsPage;
	AnalyticsPage analyticsPage;
	PlanAndBillingPage planAndBillingPage;
	

	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass() {siteActions = new SiteActions(driver, wait);}

	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass1() {loginPage = new LoginPage(driver, wait);}

	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass2() {usersPage = new UsersPage(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass3() {recipientsPage = new RecipientsPage(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass4() {locationsPage = new LocationsPage(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass5() {analyticsPage = new AnalyticsPage(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass6() {planAndBillingPage = new PlanAndBillingPage(driver, wait);}
	
	
	@Test(groups = { "LoginNegativeTestCase" ,"Login", "DEV"})
	@Parameters({"url"})
	public void LoginNegativeCase(@Optional String url) throws InterruptedException {
		siteActions.navigateURL(GlobalVariables.dev_Url);
		loginPage.loginNegative(GlobalVariables.DEVEmail , GlobalVariables.DEVPassword);
		loginPage.logout();
	}
	
	@Test(groups = { "MagicLink" ,"Login", "DEV"})
	@Parameters({"url"})
	public void LoginViaMagicLink(@Optional String url) throws InterruptedException {
		siteActions.navigateURL(GlobalVariables.dev_Url);
		loginPage.signInViaMagicLinkUAT(GlobalVariables.DEVEmail);
		loginPage.logout();
	}
	
	@Test(groups = { "ForgotPassword" ,"Login", "DEV"})
	@Parameters({"url"})
	public void ForgotPassword(@Optional String url) throws InterruptedException {
		siteActions.navigateURL(GlobalVariables.dev_Url);
		loginPage.forgotPassword(GlobalVariables.DEVEmail, GlobalVariables.DEVPassword);
		loginPage.logout();
	}
	
	
	@Test(groups =  {"Users", "DEV"} , enabled = true)
	@Parameters({"url"})
	public void AddNewAdminUser(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.dev_Url);
		loginPage.login(GlobalVariables.DEVEmail, GlobalVariables.DEVPassword);
		usersPage.addNewUser(GlobalVariables.AdminUserRole, GlobalVariables.AddNewUserEmail, GlobalVariables.locationSearched);
		usersPage.editUser(GlobalVariables.AdminUserRole, GlobalVariables.locationSearched);
		usersPage.deleteUser();
		loginPage.logout();		
	}
	
	@Test(groups =  {"Users", "DEV"} , enabled = true)
	@Parameters({"url"})
	public void AddNewManagerUser(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.dev_Url);
		loginPage.login(GlobalVariables.DEVEmail, GlobalVariables.DEVPassword);
		usersPage.addNewUser(GlobalVariables.ManagerUserRole, GlobalVariables.AddNewManagerEmail, GlobalVariables.locationSearchedUAT);
		usersPage.editUser(GlobalVariables.ManagerUserRole, GlobalVariables.locationSearchedUAT);
		usersPage.deleteUser();
		loginPage.logout();		
	}
	
	@Test(groups =  {"Users", "DEV"} , enabled = true)
	@Parameters({"url"})
	public void AddNewOperatorUser(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.dev_Url);
		loginPage.login(GlobalVariables.DEVEmail, GlobalVariables.DEVPassword);
		usersPage.addNewUser(GlobalVariables.OperatorUserRole, GlobalVariables.AddNewOperatorEmail, GlobalVariables.locationSearchedUAT);
		usersPage.editUser(GlobalVariables.OperatorUserRole, GlobalVariables.locationSearchedUAT);
		usersPage.deleteUser();
		loginPage.logout();
	}
	
	@Test(groups =  {"Users", "DEV"} , enabled = true)
	@Parameters({"url"})
	public void AddNewAdminUserFiltersSorting(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.dev_Url);
		loginPage.login(GlobalVariables.DEVEmail, GlobalVariables.DEVPassword);
		usersPage.addNewUserFilterSorting(
				
				GlobalVariables.AdminUserRole, 
				GlobalVariables.AddNewUserEmail, 
				GlobalVariables.AddNewUserName, 
				GlobalVariables.locationSearched);
		
		usersPage.editUser(GlobalVariables.AdminUserRole, GlobalVariables.locationSearchedUAT);
		usersPage.deleteUser();
		loginPage.logout();		
	}
	
	@Test(groups =  {"Locations", "DEV"} , enabled = true)
	@Parameters({"url"})
	public void CreateNewLocation(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.dev_Url);
		loginPage.login(GlobalVariables.DEVEmail, GlobalVariables.DEVPassword);
		locationsPage.createNewLocation(GlobalVariables.Location);
		loginPage.logout();
	}
	
	@Test(groups =  {"Recipients", "DEV"} , enabled = true)
	@Parameters({"url"})
	public void AddNewRecipient(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.dev_Url);
		loginPage.login(GlobalVariables.DEVEmail, GlobalVariables.DEVPassword);
		recipientsPage.addNewRecipient( GlobalVariables.autoRecepientUser, GlobalVariables.AddNewUserEmail, GlobalVariables.locationSearchedUAT);
		recipientsPage.editRecipient();
		recipientsPage.deleteRecipient();
		loginPage.logout();
	}
	
	@Test(groups =  {"Groups", "DEV"} , enabled = true)
	@Parameters({"url"})
	public void AddNewGroup(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.dev_Url);
		loginPage.login(GlobalVariables.DEVEmail, GlobalVariables.DEVPassword);
		recipientsPage.addNewGroup(GlobalVariables.AddNewUserEmail, GlobalVariables.locationSearchedUAT);
		recipientsPage.editGroup();
		recipientsPage.deleteGroup();
		loginPage.logout();
	}
	
	@Test(groups =  {"UploadCSV", "DEV"} , enabled = true)
	@Parameters({"url"})
	public void UploadCSVUPMerge(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.dev_Url);
		loginPage.login(GlobalVariables.DEVEmail, GlobalVariables.DEVPassword);
		recipientsPage.chooseAndSearchLocation(GlobalVariables.locationSearched);
		recipientsPage.uploadCSV(GlobalVariables.locationSearched, GlobalVariables.fileuploadCorrectMerge, GlobalVariables.uploadPreferenceMerge);
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		recipientsPage.searchImportedRecipientEmail();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	@Test(groups =  {"UploadCSV", "DEV"} , enabled = true)
	@Parameters({"url"})
	public void UploadCSVUPOverwrite(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.dev_Url);
		loginPage.login(GlobalVariables.DEVEmail, GlobalVariables.DEVPassword);
		recipientsPage.chooseAndSearchLocation(GlobalVariables.locationSearched);
		recipientsPage.uploadCSV(GlobalVariables.locationSearched, GlobalVariables.fileuploadCorrectOverwrite, GlobalVariables.uploadPreferenceOverwrite);
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		recipientsPage.searchImportedRecipientEmail();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	@Test(groups =  {"UploadCSV", "DEV"} , enabled = true)
	@Parameters({"url"})
	public void UploadCSVInvalidEmail(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.dev_Url);
		loginPage.login(GlobalVariables.DEVEmail, GlobalVariables.DEVPassword);
		recipientsPage.chooseAndSearchLocation(GlobalVariables.locationSearched);
		recipientsPage.uploadCSV(GlobalVariables.locationSearched, GlobalVariables.fileuploadInvalidEmail, GlobalVariables.uploadPreferenceOverwrite);
		recipientsPage.downloadFailedFileAndPath();
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		recipientsPage.searchImportedRecipientEmail();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	@Test(groups =  {"UploadCSV", "DEV"} , enabled = true)
	@Parameters({"url"})
	public void UploadCSVDuplicateEmail(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.dev_Url);
		loginPage.login(GlobalVariables.DEVEmail, GlobalVariables.DEVPassword);
		recipientsPage.chooseAndSearchLocation(GlobalVariables.locationSearched);
		recipientsPage.uploadCSV(GlobalVariables.locationSearched, GlobalVariables.fileuploadDuplicateEmail, GlobalVariables.uploadPreferenceOverwrite);
		recipientsPage.downloadFailedFileAndPath();
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		recipientsPage.searchImportedRecipientEmail();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	@Test(groups =  {"UploadCSV", "DEV"} , enabled = true)
	@Parameters({"url"})
	public void UploadCSVEmailMissing(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.dev_Url);
		loginPage.login(GlobalVariables.DEVEmail, GlobalVariables.DEVPassword);
		recipientsPage.chooseAndSearchLocation(GlobalVariables.locationSearched);
		recipientsPage.uploadCSVMissingData(GlobalVariables.locationSearched, GlobalVariables.fileuploadEmailMissing, GlobalVariables.uploadPreferenceOverwrite);
		recipientsPage.downloadFailedFileAndPath();
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		recipientsPage.searchImportedRecipientEmail();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	@Test(groups =  {"UploadCSV", "DEV"} , enabled = true)
	@Parameters({"url"})
	public void UploadCSVLongAdress(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.dev_Url);
		loginPage.login(GlobalVariables.DEVEmail, GlobalVariables.DEVPassword);
		recipientsPage.chooseAndSearchLocation(GlobalVariables.locationSearched);
		recipientsPage.uploadCSV(GlobalVariables.locationSearched, GlobalVariables.fileuploadInvalidAddress, GlobalVariables.uploadPreferenceOverwrite);
		recipientsPage.downloadFailedFileAndPath();
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	
	@Test(groups =  {"UploadCSV", "DEV"} , enabled = true)
	@Parameters({"url", "locationSearched"})
	public void UploadCSVUpdateMerge(@Optional String url, @Optional ("locationSearched") String name) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.dev_Url);
		loginPage.login(GlobalVariables.DEVEmail, GlobalVariables.DEVPassword);
		recipientsPage.updateRecipientByCSV(GlobalVariables.locationSearchedRecepCSV);
		recipientsPage.uploadCSV(GlobalVariables.locationSearchedRecepCSV, GlobalVariables.fileuploadRecepCSV, GlobalVariables.uploadPreferenceMerge);
		UsersPage.clickExpandBtn();
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		recipientsPage.searchImportedRecipientEmail();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	
	@Test(groups =  {"UploadCSV", "DEV"} , enabled = true)
	@Parameters({"url", "locationSearched"})
	public void UploadCSVEditUploadMerge(@Optional String url, @Optional("locationSearched") String name) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.dev_Url);
		loginPage.login(GlobalVariables.DEVEmail, GlobalVariables.DEVPassword);
		recipientsPage.updateRecipientByCSV(GlobalVariables.locationSearchedRecepCSV);
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		recipientsPage.editCSV(); 
		recipientsPage.uploadCSV(GlobalVariables.locationSearchedRecepCSV, GlobalVariables.fileuploadRecepCSV, GlobalVariables.uploadPreferenceMerge);
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		recipientsPage.searchImportedRecipientEmail();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	@Test(groups =  {"UploadCSV", "DEV"} , enabled = true)
	@Parameters({"url"})
	public void UploadCSVNameEmailMissing(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.dev_Url);
		loginPage.login(GlobalVariables.DEVEmail, GlobalVariables.DEVPassword);
		recipientsPage.chooseAndSearchLocation(GlobalVariables.locationSearched);
		recipientsPage.uploadCSVNameEmailMissing(GlobalVariables.locationSearched, GlobalVariables.fileuploadNameEmailMissing, GlobalVariables.uploadPreferenceOverwrite);
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		recipientsPage.searchImportedRecipientEmail();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	@Test(groups =  {"UploadCSV", "DEV"} , enabled = true)
	@Parameters({"url"})
	public void UploadCSVUnitGroup(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.dev_Url);
		loginPage.login(GlobalVariables.DEVEmail, GlobalVariables.DEVPassword);
		recipientsPage.chooseAndSearchLocation(GlobalVariables.locationSearchedUAT);
		recipientsPage.uploadCSV_UnitGroup(GlobalVariables.locationSearched, GlobalVariables.fileuploadUnitGroup, GlobalVariables.uploadPreferenceOverwrite);
		//recipientsPage.downloadFailedFileAndPath();
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	@Test(groups =  {"UploadCSV", "DEV"} , enabled = true)
	@Parameters({"url"})
	public void UploadCSV10000Recipients(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.dev_Url);
		loginPage.login(GlobalVariables.DEVEmail, GlobalVariables.DEVPassword);
		recipientsPage.chooseAndSearchLocation(GlobalVariables.locationSearched10000Rec);
		recipientsPage.uploadCSV(GlobalVariables.locationSearched10000Rec, GlobalVariables.fileupload10000Recipients, GlobalVariables.uploadPreferenceOverwrite);
		Waits.waitTime(100);
		recipientsPage.refreshData();
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		recipientsPage.searchImportedRecipientEmail();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	@Test(groups =  {"UploadCSV", "DEV"} , enabled = true)
	@Parameters({"url"})
	public void UploadCSV30MinWait(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.dev_Url);
		loginPage.login(GlobalVariables.DEVEmail, GlobalVariables.DEVPassword);
		recipientsPage.chooseAndSearchLocation(GlobalVariables.locationSearched);
		recipientsPage.uploadCSV30MinWait(GlobalVariables.locationSearched, GlobalVariables.fileuploadCorrectOverwrite, GlobalVariables.uploadPreferenceOverwrite);
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	
	@Test(groups =  {"Analytics", "DEV"} , enabled = true)
	@Parameters({"url"})
	public void Analytics(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.dev_Url);
		loginPage.login(GlobalVariables.DEVEmail, GlobalVariables.DEVPassword);
		analyticsPage.scanTrends();
		analyticsPage.currentlyHeldItems();
		loginPage.logout();
	}
	
	@Test(groups =  {"Analytics", "DEV"} , enabled = true)
	@Parameters({"url"})
	public void GlobalSearch(@Optional String url) throws InterruptedException, IOException, AWTException {
	
		siteActions.navigateURL(GlobalVariables.dev_Url);
		loginPage.login(GlobalVariables.DEVEmail, GlobalVariables.DEVPassword);
		//loginPage.selectLocationFromSearch();
		loginPage.globalSearch();
		Waits.waitTime(2);
		loginPage.logout();
	}
	
}
