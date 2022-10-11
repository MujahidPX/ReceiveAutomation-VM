package SiteTestCases.RecipientsTests;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClasses.DriverBaseClass;
//import BaseClasses.SendEmailReport.SendReport;
import Locations.LocationsPage;
import Login.LoginPage;
import Recipients.RecipientsPage;
import SiteElements.SiteActions;
import Users.UsersPage;
import Utilities.GlobalVariables;
import Utilities.Waits;


public class RecipientsPageTests extends DriverBaseClass {
	
	SiteActions siteActions;
	LoginPage loginPage;
	UsersPage usersPage;
	DriverBaseClass driverBaseClass;
	RecipientsPage recipientsPage;
	LocationsPage locationsPage;
	

	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass() {siteActions = new SiteActions(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass1() {loginPage = new LoginPage(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass2() {recipientsPage = new RecipientsPage(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass3() {usersPage = new UsersPage(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass4() {locationsPage = new LocationsPage(driver, wait);}
	
	
	@Test(groups =  {"Recipients"} , enabled = true)
	@Parameters({"url"})
	public void AddNewRecipient(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail, GlobalVariables.AutomationPassword);
		recipientsPage.addNewRecipient( GlobalVariables.autoRecepientUser, GlobalVariables.AddNewUserEmail, GlobalVariables.locationSearched);
		recipientsPage.editRecipient();
		recipientsPage.deleteRecipient();
		recipientsPage.searchByEmail_Delete();
		recipientsPage.noDataFound();
		loginPage.logout();
	}
		
	@Test(groups =  {"Recipients"} , enabled = true)
	@Parameters({"url"})
	public void AddCustomFields(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail, GlobalVariables.AutomationPassword);
		recipientsPage.addCustomFields();
		loginPage.logout();
	}
	
	
	@Test(groups =  {"Recipients"} , enabled = true)
	@Parameters({"url"})
	public void AddNewRecipientByOperator(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.OperatorEmail, GlobalVariables.OperatorPassword);
		recipientsPage.addNewRecipient( GlobalVariables.autoRecepientUser, GlobalVariables.AddNewUserEmail, GlobalVariables.locationSearched);
		recipientsPage.editRecipient();
		recipientsPage.deleteRecipient();
		recipientsPage.addNewGroup(GlobalVariables.AddNewUserEmail, GlobalVariables.locationSearched);
		recipientsPage.editGroup();
		recipientsPage.deleteGroup();
		loginPage.logout();
	}
	
	@Test(groups =  {"Groups"} , enabled = true)
	@Parameters({"url"})
	public void AddNewGroup(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail, GlobalVariables.AutomationPassword);
		recipientsPage.addNewGroup(GlobalVariables.AddNewUserEmail, GlobalVariables.locationSearched);
		recipientsPage.editGroup();
		recipientsPage.deleteGroup();
		recipientsPage.searchByName_Delete();
		recipientsPage.noDataFound();
		loginPage.logout();
	}
		
	@Test(groups =  {"UploadCSV"} , enabled = true)
	@Parameters({"url"})
	public void UploadCSVUPMerge(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail, GlobalVariables.AutomationPassword);
		recipientsPage.chooseAndSearchLocation(GlobalVariables.locationSearched);
		recipientsPage.uploadCSV(GlobalVariables.locationSearched, GlobalVariables.fileuploadCorrectMerge, GlobalVariables.uploadPreferenceMerge);
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		recipientsPage.searchImportedRecipientEmail();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	@Test(groups =  {"UploadCSV"} , enabled = true)
	@Parameters({"url"})
	public void UploadCSVUPOverwrite(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail, GlobalVariables.AutomationPassword);
		recipientsPage.chooseAndSearchLocation(GlobalVariables.locationSearched);
		recipientsPage.uploadCSV(GlobalVariables.locationSearched, GlobalVariables.fileuploadCorrectOverwrite, GlobalVariables.uploadPreferenceOverwrite);
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		recipientsPage.searchImportedRecipientEmail();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	@Test(groups =  {"UploadCSV"} , enabled = true)
	@Parameters({"url"})
	public void UploadCSVInvalidEmail(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail, GlobalVariables.AutomationPassword);
		recipientsPage.chooseAndSearchLocation(GlobalVariables.locationSearched);
		recipientsPage.uploadCSV(GlobalVariables.locationSearched, GlobalVariables.fileuploadInvalidEmail, GlobalVariables.uploadPreferenceOverwrite);
		recipientsPage.downloadFailedFileAndPath();
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		recipientsPage.searchImportedRecipientEmail();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	@Test(groups =  {"UploadCSV"} , enabled = true)
	@Parameters({"url"})
	public void UploadCSVDuplicateEmail(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail, GlobalVariables.AutomationPassword);
		recipientsPage.chooseAndSearchLocation(GlobalVariables.locationSearched);
		recipientsPage.uploadCSV(GlobalVariables.locationSearched, GlobalVariables.fileuploadDuplicateEmail, GlobalVariables.uploadPreferenceOverwrite);
		recipientsPage.downloadFailedFileAndPath();
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		recipientsPage.searchImportedRecipientEmail();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	@Test(groups =  {"UploadCSV"} , enabled = true)
	@Parameters({"url"})
	public void UploadCSVEmailMissing(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail, GlobalVariables.AutomationPassword);
		recipientsPage.chooseAndSearchLocation(GlobalVariables.locationSearched);
		recipientsPage.uploadCSVMissingData(GlobalVariables.locationSearched, GlobalVariables.fileuploadEmailMissing, GlobalVariables.uploadPreferenceOverwrite);
		recipientsPage.downloadFailedFileAndPath();
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		recipientsPage.searchImportedRecipientEmail();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	@Test(groups =  {"UploadCSV"} , enabled = true)
	@Parameters({"url"})
	public void UploadCSVLongAdress(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail, GlobalVariables.AutomationPassword);
		recipientsPage.chooseAndSearchLocation(GlobalVariables.locationSearched);
		recipientsPage.uploadCSV(GlobalVariables.locationSearched, GlobalVariables.fileuploadInvalidAddress, GlobalVariables.uploadPreferenceOverwrite);
		recipientsPage.downloadFailedFileAndPath();
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	
	@Test(groups =  {"UploadCSV"} , enabled = true)
	@Parameters({"url", "locationSearched"})
	public void UploadCSVUpdateMerge(@Optional String url, @Optional ("locationSearched") String name) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail, GlobalVariables.AutomationPassword);
		recipientsPage.updateRecipientByCSV(GlobalVariables.locationSearchedRecepCSV);
		recipientsPage.uploadCSV(GlobalVariables.locationSearchedRecepCSV, GlobalVariables.fileuploadRecepCSV, GlobalVariables.uploadPreferenceMerge);
		UsersPage.clickExpandBtn();
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		recipientsPage.searchImportedRecipientEmail();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	
	@Test(groups =  {"UploadCSV"} , enabled = true)
	@Parameters({"url", "locationSearched"})
	public void UploadCSVEditUploadMerge(@Optional String url, @Optional("locationSearched") String name) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail, GlobalVariables.AutomationPassword);
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
	
	@Test(groups =  {"UploadCSV"} , enabled = true)
	@Parameters({"url"})
	public void UploadCSVNameEmailMissing(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail, GlobalVariables.AutomationPassword);
		recipientsPage.chooseAndSearchLocation(GlobalVariables.locationSearched);
		recipientsPage.uploadCSVNameEmailMissing(GlobalVariables.locationSearched, GlobalVariables.fileuploadNameEmailMissing, GlobalVariables.uploadPreferenceOverwrite);
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		recipientsPage.searchImportedRecipientEmail();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	@Test(groups =  {"UploadCSV"} , enabled = true)
	@Parameters({"url"})
	public void UploadCSVUnitGroup(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail, GlobalVariables.AutomationPassword);
		recipientsPage.chooseAndSearchLocation(GlobalVariables.locationSearchedUAT);
		recipientsPage.uploadCSV_UnitGroup(GlobalVariables.locationSearched, GlobalVariables.fileuploadUnitGroup, GlobalVariables.uploadPreferenceOverwrite);
		//recipientsPage.downloadFailedFileAndPath();
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	@Test(groups =  {"UploadCSV"} , enabled = true)
	@Parameters({"url"})
	public void UploadCSV10000Recipients(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail, GlobalVariables.AutomationPassword);
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
	
	@Test(groups =  {"UploadCSV"} , enabled = true)
	@Parameters({"url"})
	public void UploadCSV30MinWait(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail, GlobalVariables.AutomationPassword);
		recipientsPage.chooseAndSearchLocation(GlobalVariables.locationSearched);
		recipientsPage.uploadCSV30MinWait(GlobalVariables.locationSearched, GlobalVariables.fileuploadCorrectOverwrite, GlobalVariables.uploadPreferenceOverwrite);
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	@Test(groups =  {"UploadCSV"} , enabled = true)
	@Parameters({"url"})
	public void selectLocationFromDashboardSearch_TC01(@Optional String url) throws InterruptedException, IOException, AWTException {
	
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail, GlobalVariables.AutomationPassword);
		loginPage.selectLocationFromSearch();
		loginPage.globalSearch();
		Waits.waitTime(5);
		locationsPage.addMailroomName();
		locationsPage.addMailroomCode_1();
		loginPage.logout();
	}
	
	@Test(groups =  {"Recipients"} , enabled = true)
	@Parameters({"url"})
	public void ColumnPreferencesRecipients(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail, GlobalVariables.AutomationPassword);
		recipientsPage.columnPreferencesRecipients();
		Waits.waitTime(3);
		//recipientsPage.columnPreferences();
		loginPage.logout();
	}
	
	@Test(groups =  {"Recipients"} , enabled = true)
	@Parameters({"url"})
	public void ColumnPreferencesGroups(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail, GlobalVariables.AutomationPassword);
		recipientsPage.columnPreferencesGroups();
		Waits.waitTime(3);
		recipientsPage.columnPreferencesGroups();
		loginPage.logout();
	}
	
	@Test(groups =  {"SuperAdmin"} , enabled=true)
	@Parameters({"url"})
	public void SuperAdminAddNewRecipient(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.loginSuperAdmin(GlobalVariables.SuperAdminEmail, GlobalVariables.SuperAdminPassword);
		recipientsPage.addNewRecipient( GlobalVariables.autoRecepientUser, GlobalVariables.AddNewUserEmail, GlobalVariables.locationSearched);
		recipientsPage.editRecipient();
		recipientsPage.deleteRecipient();
		loginPage.logout();
	}
	
	@Test(groups =  {"SuperAdmin"} , enabled=true)
	@Parameters({"url"})
	public void SuperAdminAddNewGroup(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.loginSuperAdmin(GlobalVariables.SuperAdminEmail, GlobalVariables.SuperAdminPassword);		
		recipientsPage.addNewGroup(GlobalVariables.AddNewUserEmail, GlobalVariables.locationSearched);
		recipientsPage.editGroup();
		recipientsPage.deleteGroup();
		loginPage.logout();
	}
	
	
	@Test(groups =  {"SuperAdmin"} , enabled=true)
	@Parameters({"url"})
	public void SuperAdminUploadCSVMerge(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.loginSuperAdmin(GlobalVariables.SuperAdminEmail, GlobalVariables.SuperAdminPassword);		
		recipientsPage.chooseAndSearchLocation(GlobalVariables.locationSearched);
		recipientsPage.uploadCSV(GlobalVariables.locationSearched, GlobalVariables.fileuploadCorrectMerge, GlobalVariables.uploadPreferenceMerge);
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	@Test(groups =  {"SuperAdmin"} , enabled=true)
	@Parameters({"url"})
	public void SuperAdminUploadCSVOverwrite(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.loginSuperAdmin(GlobalVariables.SuperAdminEmail, GlobalVariables.SuperAdminPassword);		
		recipientsPage.chooseAndSearchLocation(GlobalVariables.locationSearched);
		recipientsPage.uploadCSV(GlobalVariables.locationSearched, GlobalVariables.fileuploadCorrectOverwrite, GlobalVariables.uploadPreferenceOverwrite);
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	@Test(groups =  {"SuperAdmin"} , enabled=true)
	@Parameters({"url"})
	public void SuperAdminUploadCSVInvalidEmail(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.loginSuperAdmin(GlobalVariables.SuperAdminEmail, GlobalVariables.SuperAdminPassword);		
		recipientsPage.chooseAndSearchLocation(GlobalVariables.locationSearched);
		recipientsPage.uploadCSV(GlobalVariables.locationSearched, GlobalVariables.fileuploadInvalidEmail, GlobalVariables.uploadPreferenceOverwrite);
		recipientsPage.downloadFailedFileAndPath();
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	@Test(groups =  {"SuperAdmin"} , enabled=true)
	@Parameters({"url"})
	public void SuperAdminUploadCSVDuplicateEmail(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.loginSuperAdmin(GlobalVariables.SuperAdminEmail, GlobalVariables.SuperAdminPassword);		
		recipientsPage.chooseAndSearchLocation(GlobalVariables.locationSearched);
		recipientsPage.uploadCSV(GlobalVariables.locationSearched, GlobalVariables.fileuploadDuplicateEmail, GlobalVariables.uploadPreferenceOverwrite);
		recipientsPage.downloadFailedFileAndPath();
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	@Test(groups =  {"SuperAdmin"} , enabled=true)
	@Parameters({"url"})
	public void SuperAdminUploadCSVEmailMissing(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.loginSuperAdmin(GlobalVariables.SuperAdminEmail, GlobalVariables.SuperAdminPassword);		
		recipientsPage.chooseAndSearchLocation(GlobalVariables.locationSearched);
		recipientsPage.uploadCSVMissingData(GlobalVariables.locationSearched, GlobalVariables.fileuploadEmailMissing, GlobalVariables.uploadPreferenceOverwrite);
		recipientsPage.downloadFailedFileAndPath();
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	@Test(groups =  {"SuperAdmin"} , enabled=true)
	@Parameters({"url"})
	public void SuperAdminUploadCSVLongAdress(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.loginSuperAdmin(GlobalVariables.SuperAdminEmail, GlobalVariables.SuperAdminPassword);		
		recipientsPage.chooseAndSearchLocation(GlobalVariables.locationSearched);
		recipientsPage.uploadCSV(GlobalVariables.locationSearched, GlobalVariables.fileuploadInvalidAddress, GlobalVariables.uploadPreferenceOverwrite);
		recipientsPage.downloadFailedFileAndPath();
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	@Test(groups =  {"SuperAdmin"} , enabled=true)
	@Parameters({"url", "locationSearched"})
	public void SuperAdminUploadCSVUpdateMerge(@Optional String url, @Optional("locationSearched") String name) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.loginSuperAdmin(GlobalVariables.SuperAdminEmail, GlobalVariables.SuperAdminPassword);		
		recipientsPage.updateRecipientByCSV(GlobalVariables.locationSearchedRecepCSV);
		recipientsPage.uploadCSV(GlobalVariables.locationSearchedRecepCSV, GlobalVariables.fileuploadRecepCSV, GlobalVariables.uploadPreferenceMerge);
		UsersPage.clickExpandBtn();
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	@Test(groups =  {"SuperAdmin"} , enabled=true)
	@Parameters({"url", "locationSearched"})
	public void SuperAdminUploadCSVEditUploadMerge(@Optional String url, @Optional("locationSearched") String name) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.loginSuperAdmin(GlobalVariables.SuperAdminEmail, GlobalVariables.SuperAdminPassword);		
		recipientsPage.updateRecipientByCSV(GlobalVariables.locationSearchedRecepCSV);
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		recipientsPage.editCSV(); 
		recipientsPage.uploadCSV(GlobalVariables.locationSearchedRecepCSV, GlobalVariables.fileuploadRecepCSV, GlobalVariables.uploadPreferenceMerge);
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
	@Test(groups =  {"SuperAdmin"} , enabled=true)
	@Parameters({"url"})
	public void SuperAdminUploadCSVNameEmailMissing(@Optional String url) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.loginSuperAdmin(GlobalVariables.SuperAdminEmail, GlobalVariables.SuperAdminPassword);		
		recipientsPage.chooseAndSearchLocation(GlobalVariables.locationSearched);
		recipientsPage.uploadCSVNameEmailMissing(GlobalVariables.locationSearched, GlobalVariables.fileuploadNameEmailMissing, GlobalVariables.uploadPreferenceOverwrite);
		recipientsPage.clickRecipientTab();
		Waits.waitTime(3);
		loginPage.logout();
	}
	
}
