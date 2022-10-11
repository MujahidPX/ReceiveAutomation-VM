package SiteTestCases.ItemsTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClasses.DriverBaseClass;
//import BaseClasses.SendEmailReport.SendReport;
import Items.ItemsPage;
import Locations.LocationsPage;
import Login.LoginPage;
import Recipients.RecipientsPage;
import SiteElements.SiteActions;
import Users.UsersPage;
import Utilities.GlobalVariables;
import Utilities.Waits;


public class ItemsPageTests extends DriverBaseClass {

	SiteActions siteActions;
	LoginPage loginPage;
	UsersPage usersPage;
	DriverBaseClass driverBaseClass;
	RecipientsPage recipientsPage;
	LocationsPage locationsPage;
	ItemsPage itemsPage;
	

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
	
	@BeforeClass(alwaysRun = true)
	public void initPageObjectClass5() {itemsPage = new ItemsPage(driver, wait);}
	
	
	@Test(groups =  {"Items"} , enabled = true)
	@Parameters({"url"})
	public void ItemsSearch(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.uat_Url);
		loginPage.login(GlobalVariables.UATEmail2, GlobalVariables.UATPassword2);
		itemsPage.basicSearch();
		recipientsPage.chooseAndSearchLocationItems(GlobalVariables.locationSearchedUAT2);
		//itemsPage.labelTextSearch();
		itemsPage.copyTrackingNo();
		itemsPage.labelTextSearch();
		loginPage.logout();
	}
	
	@Test(groups =  {"Items"} , enabled = true)
	@Parameters({"url"})
	public void AdvancedFilters(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AdminEmail, GlobalVariables.AdminPassword);
		itemsPage.advancedFilters();
		loginPage.logout();
	}
	
	@Test(groups =  {"Items"} , enabled = true)
	@Parameters({"url"})
	public void FilterByDate(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AdminEmail, GlobalVariables.AdminPassword);
		itemsPage.filterByDate();
		loginPage.logout();
	}
	
	@Test(groups =  {"Items"} , enabled = true)
	@Parameters({"url"})
	public void ColumnPreferences(@Optional String url) throws InterruptedException {
		
		siteActions.navigateURL(GlobalVariables.qa_Url);
		loginPage.login(GlobalVariables.AdminEmail, GlobalVariables.AdminPassword);
		itemsPage.columnPreferences();
		Waits.waitTime(3);
		itemsPage.columnPreferences();
		loginPage.logout();
	}
	
}
