package SiteTestCases.SettingsTests.CompanyManagementTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClasses.DriverBaseClass;
//import BaseClasses.SendEmailReport.SendReport;
import Login.LoginPage;
import Recipients.RecipientsPage;
import Settings.CompanyManagement.CompanyManagementPage;
import Settings.Workflows.WorkflowsPage;
import SiteElements.SiteActions;
import Users.UsersPage;
import Utilities.GlobalVariables;


public class CompanyManagementTestsPage extends DriverBaseClass {
	
	SiteActions siteActions;
	LoginPage loginPage;
	UsersPage usersPage;
	RecipientsPage recipientsPage;
	DriverBaseClass driverBaseClass;
	CompanyManagementPage companyManagementPage;
	

	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass() {siteActions = new SiteActions(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass1() {loginPage = new LoginPage(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass2() {companyManagementPage = new CompanyManagementPage(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass3() {usersPage = new UsersPage(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass4() {recipientsPage = new RecipientsPage(driver, wait);}
	
	
	@Test(groups =  {"Settings", "SignIn"} , enabled = true)
	@Parameters({"url"})
	public void SignInOptions_EnableMagicLink(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.Automation1Email, GlobalVariables.Automation1Password);
		companyManagementPage.enableMagicLink();
		loginPage.logout();
		
		loginPage.login(GlobalVariables.Automation1Email, GlobalVariables.Automation1Password);
		companyManagementPage.enableMagicLink();
		loginPage.logout();
	}

}
