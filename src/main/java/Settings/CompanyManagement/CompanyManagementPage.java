package Settings.CompanyManagement;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import SiteElements.SiteActions;
import SiteElements.RecipientsPageElements.RecipientsPageElements;
import SiteElements.SettingsPageElements.CompanyManagement.CompanyManagementPageElements;
import Utilities.CommonActions;

public class CompanyManagementPage extends CompanyManagementPageElements {

	private static WebDriver driver;
	private WebDriverWait wait;
	private CommonActions commonActions;

	public CompanyManagementPage(WebDriver driver, WebDriverWait wait) {
		super();
		CompanyManagementPage.driver = driver;
		this.wait = wait;
		commonActions = new CommonActions(driver, wait);
		PageFactory.initElements(driver, this);
	}
	
	public void enableMagicLink() {
		
		clickSettingsTab();
		
		CommonActions.waitForElement(CompanyManagement);
		CompanyManagement.click();
		
		CommonActions.waitForElement(SignInOptions);
		SignInOptions.click();
		
		CommonActions.waitForElement(EnableMagicLink);
		EnableMagicLink.click();
		
		SiteActions.notification();
		assertEquals(RecipientsPageElements.SuccessMsgNotification.getText(), "Sign in options updated successfully");
	    CommonActions.waitForElementToDisappear(NotificationMessage);
		
	}
	
	public void clickSettingsTab() {
		
		CommonActions.waitForElement(SettingsTab);
		if(SettingsTab.isDisplayed()) {
			SettingsTab.click();
		}
		
	}
}
