package SiteTestCases.UsersTests;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

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
import RerunFailTests.RerunAutomationScripts;
import SiteElements.SiteActions;
import Users.UsersPage;
import Utilities.GlobalVariables;
import Utilities.Waits;




public class UsersPageTests extends DriverBaseClass {

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
	public void initPageObjectClass2() {usersPage = new UsersPage(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass3() {recipientsPage = new RecipientsPage(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass4() {locationsPage = new LocationsPage(driver, wait);}
	
	@Test(groups =  {"Users"} , enabled = true, retryAnalyzer = RerunAutomationScripts.class)
	@Parameters({"url"})
	public void AddNewAdminUser(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail, GlobalVariables.AutomationPassword);
		usersPage.addNewUser(GlobalVariables.AdminUserRole, GlobalVariables.AddNewUserEmail, GlobalVariables.locationSearched);
		usersPage.editUser(GlobalVariables.AdminUserRole, GlobalVariables.locationSearched);
		usersPage.activateUser(GlobalVariables.AdminUserRole, GlobalVariables.locationSearched);
		usersPage.deleteUser();
		loginPage.logout();		
	}
	
	@Test(groups =  {"Users"} , enabled = true, retryAnalyzer = RerunAutomationScripts.class)
	@Parameters({"url"})
	public void AddNewManagerUser(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail, GlobalVariables.AutomationPassword);
		usersPage.addNewUser(GlobalVariables.ManagerUserRole, GlobalVariables.AddNewManagerEmail, GlobalVariables.locationSearched);
		usersPage.editUser(GlobalVariables.ManagerUserRole, GlobalVariables.locationSearched);
		usersPage.activateUser(GlobalVariables.ManagerUserRole, GlobalVariables.locationSearched);
		usersPage.deleteUser();
		loginPage.logout();		
	}
	
	@Test(groups =  {"Users"} , enabled = true)
	@Parameters({"url"})
	public void AddNewOperatorUser(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail, GlobalVariables.AutomationPassword);
		usersPage.addNewUser(GlobalVariables.OperatorUserRole, GlobalVariables.AddNewOperatorEmail, GlobalVariables.locationSearched);
		Waits.waitTime(3);
		usersPage.editUser(GlobalVariables.OperatorUserRole, GlobalVariables.locationSearched);
		usersPage.activateUser(GlobalVariables.OperatorUserRoleActivate, GlobalVariables.locationSearched);
		usersPage.deleteUser();
		loginPage.logout();
	}
	
	@Test(groups =  {"Users"} , enabled = true)
	@Parameters({"url"})
	public void AddNewAdminUserFiltersSorting(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail, GlobalVariables.AutomationPassword);
		usersPage.addNewUserFilterSorting(
				
				GlobalVariables.AdminUserRole, 
				GlobalVariables.AddNewUserEmail, 
				GlobalVariables.AddNewUserName, 
				GlobalVariables.locationSearched);
		
		usersPage.editUser(GlobalVariables.AdminUserRole, GlobalVariables.locationSearched);
		usersPage.deleteUser();
		loginPage.logout();		
	}
	
	@Test(groups =  {"Users"} , enabled = true)
	@Parameters({"url"})
	public void ColumnPreferences(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AdminEmail, GlobalVariables.AdminPassword);
		usersPage.columnPreferences();
		Waits.waitTime(3);
		usersPage.columnPreferences();
		loginPage.logout();
	}
	
	@Test(groups =  {"Users"} , enabled = true)
	@Parameters({"url"})
	public void DeleteUser(String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AdminEmail, GlobalVariables.AdminPassword);
		//usersPage.searchByEmail();
		//usersPage.addNewUser(GlobalVariables.AdminUserRole, GlobalVariables.AddNewUserEmail, GlobalVariables.locationSearched);
		usersPage.deleteUser();
		loginPage.logout();		
	}
	
	@Test(groups =  {"SuperAdmin"} , enabled=true)
	@Parameters({"url", "locationSearched"})
	public void SuperAdminAddNewAdminUser(@Optional String url, @Optional("locationSearched") String name) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.loginSuperAdmin(GlobalVariables.SuperAdminEmail, GlobalVariables.SuperAdminPassword);		
		usersPage.addNewUser(GlobalVariables.AdminUserRole, GlobalVariables.AddNewUserEmail, GlobalVariables.locationSearched);
		usersPage.editUser(GlobalVariables.AdminUserRole, GlobalVariables.locationSearched);
		usersPage.deleteUser();
		loginPage.logout();		
	}	
	
	@Test(groups =  {"SuperAdmin"} , enabled=true)
	@Parameters({"url", "locationSearched"})
	public void SuperAdminAddNewManagerUser(@Optional String url, @Optional("locationSearched") String name) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.loginSuperAdmin(GlobalVariables.SuperAdminEmail, GlobalVariables.SuperAdminPassword);		
		usersPage.addNewUser(GlobalVariables.ManagerUserRole, GlobalVariables.AddNewManagerEmail, GlobalVariables.locationSearched);
		usersPage.editUser(GlobalVariables.ManagerUserRole, GlobalVariables.locationSearched);
		usersPage.deleteUser();
		loginPage.logout();	
	}	
	
	@Test(groups =  {"SuperAdmin"} , enabled=true)
	@Parameters({"url", "locationSearched"})
	public void SuperAdminAddNewOperatorUser(@Optional String url, @Optional("locationSearched") String name) throws InterruptedException, IOException, AWTException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.loginSuperAdmin(GlobalVariables.SuperAdminEmail, GlobalVariables.SuperAdminPassword);		
		usersPage.addNewUser(GlobalVariables.OperatorUserRole, GlobalVariables.AddNewOperatorEmail, GlobalVariables.locationSearched);
		usersPage.editUser(GlobalVariables.OperatorUserRole, GlobalVariables.locationSearched);
		usersPage.deleteUser();
		loginPage.logout();	
	}	
}
