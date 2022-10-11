package SiteTestCases.SignUpTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClasses.DriverBaseClass;
//import BaseClasses.SendEmailReport.SendReport;
import Login.LoginPage;
import Recipients.RecipientsPage;
//import Settings.AccountSettings.AccountSettingsPage;
import SignUp.SignUpPage;
import SiteElements.SiteActions;
import Utilities.GlobalVariables;


public class SignUpPageTests extends DriverBaseClass {

	SiteActions siteActions;
	LoginPage loginPage;
	DriverBaseClass driverBaseClass;
	RecipientsPage recipientsPage;
	SignUpPage signUpPage;
	

	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass() {siteActions = new SiteActions(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass1() {loginPage = new LoginPage(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass2() {signUpPage = new SignUpPage(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass3() {recipientsPage = new RecipientsPage(driver, wait);}
	
	
	@Test(groups =  {"Settings", "Account Settings"} , enabled = true)
	@Parameters({"url"})
	public void CreateAnAccount(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		signUpPage.signUp(GlobalVariables.AddNewEmail, GlobalVariables.AdminPassword);
		loginPage.logout();
	}
	
	
}
