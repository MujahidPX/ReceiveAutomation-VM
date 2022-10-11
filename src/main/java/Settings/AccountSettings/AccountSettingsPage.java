package Settings.AccountSettings;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Settings.Workflows.WorkflowsPage;
import SiteElements.SiteActions;
import SiteElements.RecipientsPageElements.RecipientsPageElements;
import SiteElements.SettingsPageElements.AccountSettingsPageElements.AccountSettingsPageElements;
import Utilities.CommonActions;
import Utilities.Waits;

public class AccountSettingsPage extends AccountSettingsPageElements{

	private static WebDriver driver;
	private WebDriverWait wait;
	private CommonActions commonActions;

	
	public AccountSettingsPage(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
		commonActions = new CommonActions(driver, wait);
		PageFactory.initElements(driver, this);
	}
	
	public void updatePassword() {
		
		clickSettingsTab();
		
		CommonActions.waitForElement(AccountSettings);
		AccountSettings.click();
		
		CommonActions.waitForElement(UpdatePassword);
		UpdatePassword.click();
		
		CommonActions.waitForElement(CurrentPassword);
		CurrentPassword.click();
		CurrentPassword.sendKeys("Abcd1234!");
		Waits.waitTime(1);
		
		CommonActions.waitForElement(NewPassword);
		NewPassword.click();
		NewPassword.sendKeys("Abcd1234!");
		
		CommonActions.waitForElement(ConfirmPassword);
		ConfirmPassword.click();
		ConfirmPassword.sendKeys("Abcd1234!");
		
		CommonActions.waitForElement(UpdatePasswordBtn);
		UpdatePasswordBtn.click();
		
		SiteActions.notification();
		assertEquals(RecipientsPageElements.SuccessMsgNotification.getText(), "Your password has successfully been changed.");
	    CommonActions.waitForElementToDisappear(PasswordUpdatedMsg);
		
	}
	
	public static void clickSettingsTab() {
		
		CommonActions.waitForElement(SettingsTab);
		SettingsTab.click();
		Waits.waitTime(2);
		SettingsTab.click();
	}
}
