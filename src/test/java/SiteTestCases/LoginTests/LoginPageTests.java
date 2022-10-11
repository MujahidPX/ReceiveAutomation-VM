package SiteTestCases.LoginTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Utilities.GlobalVariables;

import BaseClasses.DriverBaseClass;
//import BaseClasses.SendEmailReport.SendReport;
import Login.LoginPage;
import SiteElements.SiteActions;
import SiteTestCases.UsersTests.UsersPageTests;
import Users.UsersPage;


public class LoginPageTests extends DriverBaseClass {

	SiteActions siteActions;
	LoginPage loginPage;
	DriverBaseClass driverBaseClass;
	UsersPage usersPage;

	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass() {siteActions = new SiteActions(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass1() {loginPage = new LoginPage(driver, wait);}
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass2() {usersPage = new UsersPage(driver, wait);}
	
	//@Parameters({"browser", "url"})	
	@Test(groups =  {"Logins"} , enabled=true)
	@Parameters({"url"})
	public void LoginAdmin(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AdminEmail, GlobalVariables.AdminPassword);
		loginPage.logout();
	}

	@Test(groups = { "Logins" })
	@Parameters({"url"})
	public void LoginManager(@Optional String url) throws InterruptedException {

		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.ManagerEmail, GlobalVariables.ManagerPassword);
		loginPage.logout();
	}
		
	@Test(groups = { "Logins" })
	@Parameters({"url"})
	public void LoginOperator(@Optional String url) throws InterruptedException {

		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.OperatorEmail, GlobalVariables.OperatorPassword);
		loginPage.logout();
	}
	
	@Test(groups =  {"Logins"} , enabled=true)
	@Parameters({"url"})
	public void LoginSuperAdmin(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.loginSuperAdmin(GlobalVariables.SuperAdminEmail, GlobalVariables.SuperAdminPassword);
		loginPage.logout();
	}
	
	@Test(groups = { "ForgotPassword" ,"Login"})
	@Parameters({"url"})
	public void ForgotPassword(@Optional String url) throws InterruptedException {
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.forgotPassword(GlobalVariables.AutomationEmail, GlobalVariables.AutomationPassword);
		loginPage.logout();
	}
	
	@Test(groups = { "ForgotPasswordNegativeCase" })
	@Parameters({"url"})
	public void ForgotPasswordNegativeCase(@Optional String url) throws InterruptedException {
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.forgotPassword(GlobalVariables.AdminEmail, GlobalVariables.AdminPassword);
		loginPage.logout();
	}
	
	@Test(groups = { "WrongPassword" })
	@Parameters({"url"})
	public void WrongPassword(@Optional String url) throws InterruptedException {
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.wrongPassword(GlobalVariables.AdminEmail , GlobalVariables.AdminPassword);
		loginPage.logout();
	}
	
	@Test(groups = { "MagicLink" ,"Login"})
	@Parameters({"url"})
	public void LoginViaMagicLink(@Optional String url) throws InterruptedException {
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.signInViaMagicLink(GlobalVariables.AutomationEmail);
		loginPage.logout();
	}
	
	@Test(groups = { "LoginNegativeTestCase" ,"Login"})
	@Parameters({"url"})
	public void LoginNegativeCase(@Optional String url) throws InterruptedException {
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.loginNegative(GlobalVariables.AutomationEmail , GlobalVariables.AutomationPassword);
		loginPage.logout();
	}
	
}
