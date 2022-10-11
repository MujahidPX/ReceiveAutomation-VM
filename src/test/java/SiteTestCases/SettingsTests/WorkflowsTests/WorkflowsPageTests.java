package SiteTestCases.SettingsTests.WorkflowsTests;

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
import Settings.AccountSettings.AccountSettingsPage;
import Settings.Workflows.WorkflowsPage;
import SiteElements.SiteActions;
import Users.UsersPage;
import Utilities.GlobalVariables;
import org.openqa.selenium.OutputType;

@Listeners({SendReport.class})
public class WorkflowsPageTests extends DriverBaseClass {

	SiteActions siteActions;
	LoginPage loginPage;
	UsersPage usersPage;
	RecipientsPage recipientsPage;
	DriverBaseClass driverBaseClass;
	WorkflowsPage workflowsPage;
	AccountSettingsPage accountSettingsPage;
	

	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass() {siteActions = new SiteActions(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass1() {loginPage = new LoginPage(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass2() {workflowsPage = new WorkflowsPage(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass3() {usersPage = new UsersPage(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass4() {recipientsPage = new RecipientsPage(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass5() {accountSettingsPage = new AccountSettingsPage(driver, wait);}
	
	@Test(groups =  {"Settings", "Workflows"} , enabled = true)
	@Parameters({"url"})
	public void CreateNewWorkflow(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail1, GlobalVariables.AutomationPassword1);
		workflowsPage.createNewWorkflow();
		workflowsPage.customizeAWorkflow();
		loginPage.logout();
	}
	
	/*
	@Test(groups =  {"Settings", "Workflows"} , enabled = true)
	@Parameters({"url"})
	public void CustomizeAWorflow(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail1, GlobalVariables.AutomationPassword1);
		workflowsPage.customizeAWorkflow();		
		loginPage.logout();
	}
	*/
	
	@Test(groups =  {"Settings", "Workflows"} , enabled = true)
	@Parameters({"url"})
	public void CustomizeTemplates(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail1, GlobalVariables.AutomationPassword1);
		workflowsPage.customizeTemplates();		
		loginPage.logout();
	}
	
	@Test(groups =  {"Settings", "Workflows"} , enabled = true)
	@Parameters({"url"})
	public void PreviewCustomize(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail1, GlobalVariables.AutomationPassword1);
		workflowsPage.previewCustomized();		
		loginPage.logout();
	}
	
}
