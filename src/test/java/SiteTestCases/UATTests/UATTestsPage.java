package SiteTestCases.UATTests;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.datatransfer.UnsupportedFlavorException;
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


public class UATTestsPage extends DriverBaseClass {
	
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
	
	@Test(groups = { "LoginNegativeTestCase" ,"Login", "UAT"})
	@Parameters({"url"})
	public void LoginNegativeCase(@Optional String url) throws InterruptedException {
		siteActions.navigateURL(GlobalVariables.uat_Url);
		loginPage.loginNegative(GlobalVariables.UATEmail2 , GlobalVariables.UATPassword);
		loginPage.logout();
	}
	
	
	@Test(groups = { "MagicLink" ,"Login", "UAT"})
	@Parameters({"url"})
	public void LoginViaMagicLink(@Optional String url) throws InterruptedException {
		siteActions.navigateURL(GlobalVariables.uat_Url);
		loginPage.signInViaMagicLinkUAT(GlobalVariables.UATEmail2);
		loginPage.logout();
	}
	
	@Test(groups = { "ForgotPassword" ,"Login", "UAT"})
	@Parameters({"url"})
	public void ForgotPassword(@Optional String url) throws InterruptedException {
		siteActions.navigateURL(GlobalVariables.uat_Url);
		loginPage.forgotPassword(GlobalVariables.UATEmail2, GlobalVariables.UATPassword);
		loginPage.logout();
	}
	
	
	@Test(groups =  {"Users", "UAT"} , enabled = true)
	@Parameters({"url"})
	public void AddNewAdminUser(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.uat_Url);
		loginPage.login(GlobalVariables.UATEmail2, GlobalVariables.UATPassword);
		usersPage.addNewUser(GlobalVariables.AdminUserRole, GlobalVariables.AddNewUserEmail, GlobalVariables.locationSearched);
		usersPage.editUser(GlobalVariables.AdminUserRole, GlobalVariables.locationSearched);
		usersPage.deleteUser();
		loginPage.logout();		
	}
	
	@Test(groups =  {"Users", "UAT"} , enabled = true)
	@Parameters({"url"})
	public void AddNewManagerUser(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.uat_Url);
		loginPage.login(GlobalVariables.UATEmail2, GlobalVariables.UATPassword);
		usersPage.addNewUser(GlobalVariables.ManagerUserRole, GlobalVariables.AddNewManagerEmail, GlobalVariables.locationSearchedUAT);
		usersPage.editUser(GlobalVariables.ManagerUserRole, GlobalVariables.locationSearchedUAT);
		usersPage.deleteUser();
		loginPage.logout();		
	}
	
	@Test(groups =  {"Users", "UAT"} , enabled = true)
	@Parameters({"url"})
	public void AddNewOperatorUser(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.uat_Url);
		loginPage.login(GlobalVariables.UATEmail2, GlobalVariables.UATPassword);
		usersPage.addNewUser(GlobalVariables.OperatorUserRole, GlobalVariables.AddNewOperatorEmail, GlobalVariables.locationSearchedUAT);
		usersPage.editUser(GlobalVariables.OperatorUserRole, GlobalVariables.locationSearchedUAT);
		usersPage.deleteUser();
		loginPage.logout();
	}
	
	@Test(groups =  {"Users", "UAT"} , enabled = true)
	@Parameters({"url"})
	public void AddNewAdminUserFiltersSorting(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.uat_Url);
		loginPage.login(GlobalVariables.UATEmail2, GlobalVariables.UATPassword);
		usersPage.addNewUserFilterSorting(
				
				GlobalVariables.AdminUserRole, 
				GlobalVariables.AddNewUserEmail, 
				GlobalVariables.AddNewUserName, 
				GlobalVariables.locationSearched);
		
		usersPage.editUser(GlobalVariables.AdminUserRole, GlobalVariables.locationSearchedUAT);
		usersPage.deleteUser();
		loginPage.logout();		
	}
	
	@Test(groups =  {"Locations", "UAT"} , enabled = true)
	@Parameters({"url"})
	public void CreateNewLocation(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.uat_Url);
		loginPage.login(GlobalVariables.UATEmail2, GlobalVariables.UATPassword);
		locationsPage.createNewLocation(GlobalVariables.Location);
		loginPage.logout();
	}
	
	@Test(groups =  {"Recipients", "UAT"} , enabled = true)
	@Parameters({"url"})
	public void AddNewRecipient(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.uat_Url);
		loginPage.login(GlobalVariables.UATEmail2, GlobalVariables.UATPassword);
		recipientsPage.addNewRecipient( GlobalVariables.autoRecepientUser, GlobalVariables.AddNewUserEmail, GlobalVariables.locationSearchedUAT);
		recipientsPage.editRecipient();
		recipientsPage.deleteRecipient();
		loginPage.logout();
	}
	
	@Test(groups =  {"Groups", "UAT"} , enabled = true)
	@Parameters({"url"})
	public void AddNewGroup(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.uat_Url);
		loginPage.login(GlobalVariables.UATEmail2, GlobalVariables.UATPassword);
		recipientsPage.addNewGroup(GlobalVariables.AddNewUserEmail, GlobalVariables.locationSearchedUAT);
		recipientsPage.editGroup();
		recipientsPage.deleteGroup();
		loginPage.logout();
	}
	
	@Test(groups =  {"UploadCSV", "UAT"} , enabled = true)
	@Parameters({"url"})
	public void UploadCSVUPMerge(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.uat_Url);
		loginPage.login(GlobalVariables.UATEmail2, GlobalVariables.UATPassword);
		recipientsPage.chooseAndSearchLocation(GlobalVariables.locationSearchedUAT);
		recipientsPage.uploadCSV(GlobalVariables.locationSearched, GlobalVariables.fileuploadCorrectMerge, GlobalVariables.uploadPreferenceMerge);
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	@Test(groups =  {"UploadCSV", "UAT"} , enabled = true)
	@Parameters({"url"})
	public void UploadCSVUPOverwrite(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.uat_Url);
		loginPage.login(GlobalVariables.UATEmail2, GlobalVariables.UATPassword);
		recipientsPage.chooseAndSearchLocation(GlobalVariables.locationSearchedUAT);
		recipientsPage.uploadCSV(GlobalVariables.locationSearched, GlobalVariables.fileuploadCorrectOverwrite, GlobalVariables.uploadPreferenceOverwrite);
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	@Test(groups =  {"UploadCSV", "UAT"} , enabled = true)
	@Parameters({"url"})
	public void UploadCSVInvalidEmail(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.uat_Url);
		loginPage.login(GlobalVariables.UATEmail2, GlobalVariables.UATPassword);
		recipientsPage.chooseAndSearchLocation(GlobalVariables.locationSearchedUAT);
		recipientsPage.uploadCSV(GlobalVariables.locationSearched, GlobalVariables.fileuploadInvalidEmail, GlobalVariables.uploadPreferenceOverwrite);
		recipientsPage.downloadFailedFileAndPath();
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	@Test(groups =  {"UploadCSV", "UAT"} , enabled = true)
	@Parameters({"url"})
	public void UploadCSVDuplicateEmail(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.uat_Url);
		loginPage.login(GlobalVariables.UATEmail2, GlobalVariables.UATPassword);
		recipientsPage.chooseAndSearchLocation(GlobalVariables.locationSearchedUAT);
		recipientsPage.uploadCSV(GlobalVariables.locationSearched, GlobalVariables.fileuploadDuplicateEmail, GlobalVariables.uploadPreferenceOverwrite);
		recipientsPage.downloadFailedFileAndPath();
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	@Test(groups =  {"UploadCSV", "UAT"} , enabled = true)
	@Parameters({"url"})
	public void UploadCSVEmailMissing(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.uat_Url);
		loginPage.login(GlobalVariables.UATEmail2, GlobalVariables.UATPassword);
		recipientsPage.chooseAndSearchLocation(GlobalVariables.locationSearchedUAT);
		recipientsPage.uploadCSVMissingData(GlobalVariables.locationSearched, GlobalVariables.fileuploadEmailMissing, GlobalVariables.uploadPreferenceOverwrite);
		recipientsPage.downloadFailedFileAndPath();
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	@Test(groups =  {"UploadCSV", "UAT"} , enabled = true)
	@Parameters({"url"})
	public void UploadCSVLongAdress(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.uat_Url);
		loginPage.login(GlobalVariables.UATEmail2, GlobalVariables.UATPassword);
		recipientsPage.chooseAndSearchLocation(GlobalVariables.locationSearchedUAT);
		recipientsPage.uploadCSV(GlobalVariables.locationSearched, GlobalVariables.fileuploadInvalidAddress, GlobalVariables.uploadPreferenceOverwrite);
		recipientsPage.downloadFailedFileAndPath();
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	
	@Test(groups =  {"UploadCSV", "UAT"} , enabled = true)
	@Parameters({"url", "locationSearched"})
	public void UploadCSVUpdateMerge(@Optional String url, @Optional("locationSearched") String name) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.uat_Url);
		loginPage.login(GlobalVariables.UATEmail2, GlobalVariables.UATPassword);
		recipientsPage.updateRecipientByCSV(GlobalVariables.locationSearchedUAT);
		recipientsPage.uploadCSV(GlobalVariables.locationSearchedUAT, GlobalVariables.fileuploadRecepCSV, GlobalVariables.uploadPreferenceMerge);
		UsersPage.clickExpandBtn();
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	
	@Test(groups =  {"UploadCSV", "UAT"} , enabled = true)
	@Parameters({"url", "locationSearched"})
	public void UploadCSVEditUploadMerge(@Optional String url, @Optional("locationSearched") String name) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.uat_Url);
		loginPage.login(GlobalVariables.UATEmail2, GlobalVariables.UATPassword);
		recipientsPage.updateRecipientByCSV(GlobalVariables.locationSearchedUAT);
		//recipientsPage.uploadCSV(GlobalVariables.locationSearchedRecepCSV, GlobalVariables.fileuploadRecepCSV, GlobalVariables.uploadPreferenceMerge);
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		recipientsPage.editCSV(); 
		recipientsPage.uploadCSV(GlobalVariables.locationSearchedUAT, GlobalVariables.fileuploadRecepCSV, GlobalVariables.uploadPreferenceMerge);
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	@Test(groups =  {"UploadCSV", "UAT"} , enabled = true)
	@Parameters({"url"})
	public void UploadCSVNameEmailMissing(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.uat_Url);
		loginPage.login(GlobalVariables.UATEmail2, GlobalVariables.UATPassword);
		recipientsPage.chooseAndSearchLocation(GlobalVariables.locationSearchedUAT);
		recipientsPage.uploadCSVNameEmailMissing(GlobalVariables.locationSearched, GlobalVariables.fileuploadNameEmailMissing, GlobalVariables.uploadPreferenceOverwrite);
		//recipientsPage.downloadFailedFileAndPath();
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	@Test(groups =  {"UploadCSV", "UAT"} , enabled = true)
	@Parameters({"url"})
	public void UploadCSVUnitGroup(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.uat_Url);
		loginPage.login(GlobalVariables.UATEmail2, GlobalVariables.UATPassword);
		recipientsPage.chooseAndSearchLocation(GlobalVariables.locationSearchedUAT);
		recipientsPage.uploadCSV_UnitGroup(GlobalVariables.locationSearched, GlobalVariables.fileuploadUnitGroup, GlobalVariables.uploadPreferenceOverwrite);
		recipientsPage.downloadFailedFileAndPath();
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	@Test(groups =  {"UploadCSV", "UAT"} , enabled = true)
	@Parameters({"url"})
	public void selectLocationFromDashboardSearch_TC01(@Optional String url) throws InterruptedException, IOException, AWTException {
	
		siteActions.navigateURL(GlobalVariables.uat_Url);
		loginPage.login(GlobalVariables.UATEmail2, GlobalVariables.UATPassword);
		loginPage.selectLocationFromSearch();
		loginPage.searchLocationGS();
		Waits.waitTime(5);
		locationsPage.addMailroomName();
		locationsPage.addMailroomCode_1();
		loginPage.logout();
	}
	
	@Test(groups =  {"Analytics", "UAT"} , enabled = true)
	@Parameters({"url"})
	public void Analytics(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.uat_Url);
		loginPage.login(GlobalVariables.UATEmail2, GlobalVariables.UATPassword);
		analyticsPage.scanTrends();
		analyticsPage.currentlyHeldItems();
		loginPage.logout();
	}
	
	@Test(groups =  {"Analytics", "UAT"} , enabled = true)
	@Parameters({"url"})
	public void GlobalSearch(@Optional String url) throws InterruptedException, IOException, AWTException {
	
		siteActions.navigateURL(GlobalVariables.uat_Url);
		loginPage.login(GlobalVariables.UAT_Email1, GlobalVariables.UAT_Password1);
		//loginPage.selectLocationFromSearch();
		loginPage.globalSearch();
		Waits.waitTime(2);
		loginPage.logout();
	}
	
	@Test(groups =  {"Settings", "PlanAndBilling", "UAT"} , enabled = true)
	@Parameters({"url"})
	public void AddPaymentMethod(@Optional String url) throws InterruptedException, HeadlessException, UnsupportedFlavorException, IOException {
		
		siteActions.navigateURL(GlobalVariables.uat_Url);
		loginPage.login(GlobalVariables.UAT_Email2, GlobalVariables.UAT_Password2);
		planAndBillingPage.addPaymentMethod();
		loginPage.logout();
		
	}
	
	@Test(groups =  {"Settings", "PlanAndBilling"} , enabled = true)
	@Parameters({"url"})
	public void EstimatedAnnualScans(@Optional String url) throws InterruptedException, HeadlessException, UnsupportedFlavorException, IOException {
		
		siteActions.navigateURL(GlobalVariables.uat_Url);
		loginPage.login(GlobalVariables.UAT_Email2, GlobalVariables.UAT_Password2);
		planAndBillingPage.addPaymentMethod();
		planAndBillingPage.estimatedAnnualDelivery();
		planAndBillingPage.upgradePlan();
		loginPage.logout();
		
	}
}
