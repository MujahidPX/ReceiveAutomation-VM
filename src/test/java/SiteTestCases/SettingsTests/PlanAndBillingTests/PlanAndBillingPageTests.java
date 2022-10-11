package SiteTestCases.SettingsTests.PlanAndBillingTests;

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
import RerunFailTests.RerunAutomationScripts;
import Settings.AccountSettings.AccountSettingsPage;
//import Settings.APIandWebhooks.APIandWebhooksPage;
import Settings.PlanAndBilling.PlanAndBillingPage;
import SiteElements.SiteActions;
import Users.UsersPage;
import Utilities.GlobalVariables;

public class PlanAndBillingPageTests extends DriverBaseClass {

	SiteActions siteActions;
	LoginPage loginPage;
	UsersPage usersPage;
	RecipientsPage recipientsPage;
	DriverBaseClass driverBaseClass;
	PlanAndBillingPage planAndBillingPage;
	AccountSettingsPage accountSettingsPage;

	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass() {siteActions = new SiteActions(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass1() {loginPage = new LoginPage(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass2() {planAndBillingPage = new PlanAndBillingPage(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass3() {usersPage = new UsersPage(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass4() {recipientsPage = new RecipientsPage(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass5() {accountSettingsPage = new AccountSettingsPage(driver, wait);}
	
	
	@Test(groups =  {"Settings", "PlanAndBilling"} , enabled = true, retryAnalyzer = RerunAutomationScripts.class)
	@Parameters({"url"})
	public void AddPaymentMethod(@Optional String url) throws InterruptedException, HeadlessException, UnsupportedFlavorException, IOException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.Automation1Email, GlobalVariables.Automation1Password);
		planAndBillingPage.addPaymentMethod();
		loginPage.logout();
		
	}
	
	@Test(groups =  {"Settings", "PlanAndBilling"} , enabled = true)
	@Parameters({"url"})
	public void EstimatedAnnualScans(@Optional String url) throws InterruptedException, HeadlessException, UnsupportedFlavorException, IOException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail, GlobalVariables.AutomationPassword);
		//planAndBillingPage.addPaymentMethod();
		planAndBillingPage.estimatedAnnualDelivery();
		//planAndBillingPage.upgradePlan();
		loginPage.logout();
		
	}
	
	@Test(groups =  {"Settings", "PlanAndBilling"} , enabled = true)
	@Parameters({"url"})
	public void UpgradePlan(@Optional String url) throws InterruptedException, HeadlessException, UnsupportedFlavorException, IOException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AutomationEmail, GlobalVariables.AutomationPassword);
		planAndBillingPage.upgradePlan();
		loginPage.logout();
		
	}
	
	@Test(groups =  {"Settings", "PlanAndBilling"} , enabled = true)
	@Parameters({"url"})
	public void PayWithCard_TC(@Optional String url) throws InterruptedException, HeadlessException, UnsupportedFlavorException, IOException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.Automation_Email, GlobalVariables.Automation_Password);
		planAndBillingPage.payWithCard();
		loginPage.logout();
		
	}
		
}
