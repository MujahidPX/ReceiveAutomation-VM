package SiteTestCases.SettingsTests.AccountSettingsTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClasses.DriverBaseClass;
//import BaseClasses.SendEmailReport.SendReport;
import Login.LoginPage;
import Recipients.RecipientsPage;
import Settings.AccountSettings.AccountSettingsPage;
import Settings.Workflows.WorkflowsPage;
import SiteElements.SiteActions;
import Users.UsersPage;
import Utilities.GlobalVariables;


public class AccountSettingsPageTests extends DriverBaseClass{

	SiteActions siteActions;
	LoginPage loginPage;
	DriverBaseClass driverBaseClass;
	RecipientsPage recipientsPage;
	AccountSettingsPage accountSettingsPage;
	

	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass() {siteActions = new SiteActions(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass1() {loginPage = new LoginPage(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass2() {accountSettingsPage = new AccountSettingsPage(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass3() {recipientsPage = new RecipientsPage(driver, wait);}
	
	@Test(groups =  {"Settings", "Account Settings"} , enabled = true)
	@Parameters({"url"})
	public void UpdatePassword(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail, GlobalVariables.AutomationPassword);
		accountSettingsPage.updatePassword();
		loginPage.logout();
	}
	
}
