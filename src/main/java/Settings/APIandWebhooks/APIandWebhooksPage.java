package Settings.APIandWebhooks;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Login.LoginPage;
import Recipients.RecipientsPage;
import SiteElements.SiteActions;
import SiteElements.RecipientsPageElements.RecipientsPageElements;
import SiteElements.SettingsPageElements.APIandWebhooksPageElements.APIandWebhooksPageElements;
import Users.UsersPage;
import Utilities.CommonActions;
import Utilities.Waits;

public class APIandWebhooksPage extends APIandWebhooksPageElements {

	private WebDriver driver;
	private WebDriverWait wait;
	private CommonActions commonActions;
	private LoginPage loginPage;
	private UsersPage usersPage;
	private RecipientsPage recipientsPage;
	String originalWindow;
	
	public APIandWebhooksPage(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
		commonActions = new CommonActions(driver, wait);
		PageFactory.initElements(driver, this);
	}
	
	public void generateAPIKey() {
		
		CommonActions.waitForElement(SettingsTab);
		SettingsTab.click();
		
		CommonActions.waitForElement(APIandWebhooks);
		APIandWebhooks.click();
		
		CommonActions.waitForElement(APIKeysBtn);
		APIKeysBtn.click();
		
		//Waits.waitTime(2);
		
		CommonActions.waitForElement(Plan_ddl);
		Plan_ddl.click();
		
		CommonActions.waitForElement(Low);
		Low.click();
		
		CommonActions.waitForElement(GenerateAPIKey);
		GenerateAPIKey.click();
		
		Waits.waitTime(1);
		
		if(APIKeyLimitMsg.size() == 1) {
			
			Waits.waitTime(2);
			
			CommonActions.waitForElement(CancelBtn);
			CommonActions.focusElementJs(driver, CancelBtn);
			CancelBtn.click();
			Waits.waitTime(1);
			
			if(DeleteAPIKeysBtnLast.isDisplayed()) {

				DeleteAPIKeysBtnLast.click();

				CommonActions.waitForElement(ConfirmDeleteBtn);
				ConfirmDeleteBtn.click();
				CommonActions.waitLogoInvisible();
				//Waits.waitTime(3);
			}
			
			CommonActions.waitForElement(APIKeysBtn);
			APIKeysBtn.click();
			
			CommonActions.waitForElement(Plan_ddl);
			Plan_ddl.click();
			
			CommonActions.waitForElement(Low);
			Low.click();
			
			CommonActions.waitForElement(GenerateAPIKey);
			GenerateAPIKey.click();
		}
		 
		Waits.waitTime(5);
		CommonActions.focusElementJs(driver, YourAPIKey);
		String apiKey = YourAPIKey.getAttribute("value");
		String fourDigitApiKey = apiKey.substring(apiKey.length() - 4);
		
		//String ApiKey1 = ApiKey.substring(0, ApiKey.length() - 4);
		System.out.println("Your API Key: " + fourDigitApiKey);
		
		//Waits.waitTime(5);
		CommonActions.waitForElement(SavedAPIKeyBtn);
		SavedAPIKeyBtn.click();
		
		String lastGeneratedApi = LastAPIKey.getText();
		String fourDigitLastGenApi = lastGeneratedApi.substring(lastGeneratedApi.length() - 4);
		System.out.println("Last Generated API: " + fourDigitLastGenApi);
		
		Assert.assertEquals(fourDigitApiKey, fourDigitLastGenApi);
		
	}
	
	public void generateLabelOCRAPIKey() {
		
		CommonActions.waitForElement(SettingsTab);
		SettingsTab.click();
		
		CommonActions.waitForElement(APIandWebhooks);
		APIandWebhooks.click();
		
		CommonActions.waitForElement(LabelOCRAPIKeysBtn);
		LabelOCRAPIKeysBtn.click();
		
		CommonActions.waitForElement(Plan_ddl);
		Plan_ddl.click();
		
		CommonActions.waitForElement(PerMonth_5000);
		Low.click();
		
		CommonActions.waitForElement(GenerateAPIKey);
		GenerateAPIKey.click();
		
		Waits.waitTime(1);
		
		if(APIKeyLimitMsg.size() == 1) {
			
			Waits.waitTime(2);
			
			CommonActions.waitForElement(CancelBtn);
			CommonActions.focusElementJs(driver, CancelBtn);
			CancelBtn.click();
			Waits.waitTime(1);
			
			if(DeleteLabelOCRAPIKeysBtnLast.isDisplayed()) {

				DeleteLabelOCRAPIKeysBtnLast.click();

				CommonActions.waitForElement(ConfirmDeleteBtn);
				ConfirmDeleteBtn.click();
				CommonActions.waitLogoInvisible();
				//Waits.waitTime(3);
			}
			
			CommonActions.waitForElement(LabelOCRAPIKeysBtn);
			LabelOCRAPIKeysBtn.click();
		}
		
		CommonActions.waitForElement(Plan_ddl);
		Plan_ddl.click();
		
		CommonActions.waitForElement(PerMonth_5000);
		PerMonth_5000.click();
		
		CommonActions.waitForElement(GenerateAPIKey);
		GenerateAPIKey.click();
		 
		Waits.waitTime(5);
		CommonActions.focusElementJs(driver, YourAPIKey);
		String apiKey = YourAPIKey.getAttribute("value");
		String fourDigitApiKey = apiKey.substring(apiKey.length() - 4);
		
		//String ApiKey1 = ApiKey.substring(0, ApiKey.length() - 4);
		System.out.println("Your API Key: " + fourDigitApiKey);
		
		//Waits.waitTime(5);
		CommonActions.waitForElement(SavedAPIKeyBtn);
		SavedAPIKeyBtn.click();
		
		String lastGeneratedApi = LastOCRAPIKey.getText();
		String fourDigitLastGenApi = lastGeneratedApi.substring(lastGeneratedApi.length() - 4);
		System.out.println("Last Generated API: " + fourDigitLastGenApi);
		Assert.assertEquals(fourDigitApiKey, fourDigitLastGenApi);
	}
	
	public void createWebHooks() {
		
		CommonActions.waitForElement(SettingsTab);
		SettingsTab.click();
		
		CommonActions.waitForElement(APIandWebhooks);
		APIandWebhooks.click();
		
		if(webhooksBtn1.size() == 0) {
			deleteWebhooks();
		}
		
		CommonActions.waitForElement(WebhooksBtn);
		WebhooksBtn.click();
		
		CommonActions.waitForElement(EventName);
		EventName.click();
		
		CommonActions.waitForElement(Remind_chkBox);
		Remind_chkBox.click();
		Waits.waitTime(1);
		CommonActions.tabKey();
		Waits.waitTime(1);
		
		String winHandleBefore = driver.getWindowHandle();
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		driver.get("https://webhook.site/");
		String url = UniqueUrl.getText();
		System.out.println(url);
		String shortUrl = url.substring(8, url.length());
		System.out.println(shortUrl);
		Waits.waitTime(3);
		
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		
		CommonActions.waitForElement(EndPointUrl);
		EndPointUrl.click();
		Waits.waitTime(2);
		//EndPointUrl.sendKeys(shortUrl);
		EndPointUrl.sendKeys(url);
		
		CommonActions.waitForElement(GenerateWebhookBtn);
		GenerateWebhookBtn.click();
		Waits.waitTime(2);
		
	}
	
	public void editWebhooks() {
		
		CommonActions.waitForElement(EditWebhookBtn);
		EditWebhookBtn.click();
		
		CommonActions.waitForElement(EventName);
		EventName.click();
		
		CommonActions.waitForElement(SelectAll_chkBox);
		SelectAll_chkBox.click();
		Waits.waitTime(1);
		CommonActions.tabKey();
		
		CommonActions.waitForElement(UpdateWebhookBtn);
		UpdateWebhookBtn.click();
		
		SiteActions.notification();
		assertEquals(RecipientsPageElements.SuccessMsgNotification.getText(), "Webhook updated successfully.");
	    CommonActions.waitForElementToDisappear(RecipientsPageElements.NotificationMsg);
		
	}
	
	public void deleteWebhooks() {
		
		CommonActions.waitForElement(DeleteWebhookBtn);
		if(DeleteWebhookBtn.isDisplayed()) {
			
			DeleteWebhookBtn.click();
			CommonActions.waitForElement(ConfirmDeleteBtn);
			ConfirmDeleteBtn.click();
			CommonActions.waitLogoInvisible();
		}
	}
	
}
