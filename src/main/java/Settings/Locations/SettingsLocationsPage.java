package Settings.Locations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Login.LoginPage;
import SiteElements.LocationsPageElements.LocationPageElements;
import SiteElements.SettingsPageElements.SettingsLocationsPageElements.SettingsLocationsPageElements;
import Users.UsersPage;
import Utilities.CommonActions;

public class SettingsLocationsPage extends SettingsLocationsPageElements {

	private WebDriver driver;
	private WebDriverWait wait;
	private CommonActions commonActions;
	private LoginPage loginPage;
	private UsersPage usersPage;

	public SettingsLocationsPage(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
		commonActions = new CommonActions(driver, wait);
		PageFactory.initElements(driver, this);
	}
	
	public static void enterLocationsDetail() {
		
		CommonActions.waitForElement(SettingsTab);
		if(SettingsTab.isDisplayed()) {
			SettingsTab.click();
		}
		
		CommonActions.waitForElement(Locations);
		if(Locations.isDisplayed()) {
			Locations.click();
		}
		
	}
	
}

