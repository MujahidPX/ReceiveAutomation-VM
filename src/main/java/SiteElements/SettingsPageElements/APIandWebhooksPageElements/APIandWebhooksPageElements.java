package SiteElements.SettingsPageElements.APIandWebhooksPageElements;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class APIandWebhooksPageElements {

	WebDriver driver;

	@FindBy(xpath="//a[@aria-label='Settings']")
    protected WebElement SettingsTab;
	
	@FindBy(xpath="//header[text()='API & Webhooks']")
	protected WebElement APIandWebhooks;
	
	@FindBy(xpath="(//h5[text()='API Keys']/following::span/button)[1]")
	protected WebElement APIKeysBtn;
	
	@FindBy(xpath="(//h5[text()='Label OCR API Keys']/following::span/button)[1]")
	protected WebElement LabelOCRAPIKeysBtn;
	
	@FindBy(xpath="(//h5[text()='Webhooks']/following::span/button)[1]")
	protected WebElement WebhooksBtn;
	
	@FindBys(@FindBy(xpath="(//h5[text()='Webhooks']/following::span/button)[1]"))
	public List<WebElement> webhooksBtn1;
	
	@FindBys(@FindBy(xpath="//span[text()='Cannot generate api key because limit reached.']"))
	public List<WebElement> APIKeyLimitMsg;
	
	@FindBy(xpath="//label[text()='PLAN']/following::div[2]")
	protected WebElement Plan_ddl;
	
	@FindBy(xpath="//li[@data-value='low']")
	protected WebElement Low;
	
	@FindBy(xpath="//li[@data-value='mid']")
	protected WebElement Mid;
	
	@FindBy(xpath="//li[@data-value='high']")
	protected WebElement High;
	
	@FindBy(xpath="//span[text()='5000/month']")
	protected WebElement PerMonth_5000;
	
	@FindBy(xpath="//span[text()='10000/month']")
	protected WebElement PerMonth_10000;
	
	@FindBy(xpath="//span[text()='15000/month']")
	protected WebElement PerMonth_15000;
	
	
	@FindBy(xpath="//button[text()='Generate API Key']")
	protected WebElement GenerateAPIKey;
	
	@FindBy(xpath="//div[@aria-label='Copy API Key']")
	protected WebElement CopyAPIKey;
	
	@FindBy(xpath="//input[@name='apikey']")
	//@FindBy(xpath="(//input)[6]")
	protected WebElement YourAPIKey;
	
	//@FindBy(xpath="//button[contains(text(),'saved my API Key')]")
	@FindBy(id="apiKeyGeneratedBtn")
	protected WebElement SavedAPIKeyBtn;
	
	@FindBy(id="apiKey1")
	protected WebElement APIKey1;
	
	@FindBy(xpath="//button[text()='Cancel']")
	protected WebElement CancelBtn;
	
	@FindBy(xpath="(//h6[contains(@id,'apiKey')])[last()]")
	protected WebElement LastAPIKey;
	
	@FindBy(xpath="(//h6[contains(@id,'OCRKey')])[last()]")
	protected WebElement LastOCRAPIKey;
	
	@FindBy(id="ApiKeyDeleteBtn1")
	protected WebElement APIKeyDeleteBtn1;
	
	@FindBy(xpath="//label[text()='EVENT NAME']/following::div[1]")
	protected WebElement EventName;
	
	@FindBy(xpath="//p[text()='Remind']")
	protected WebElement Remind_chkBox;
	
	@FindBy(xpath="//p[text()='Select All']")
	protected WebElement SelectAll_chkBox;
	
	@FindBy(xpath="//input[@name='apikey']")
	protected WebElement EndPointUrl;
	
	@FindBy(xpath="//button[text()='Generate Webhook']")
	protected WebElement GenerateWebhookBtn;
	
	@FindBy(xpath="//button[text()='Update Webhook']")
	protected WebElement UpdateWebhookBtn;
	
	@FindBy(xpath="//a[@ga-event-category='URLCopy']/preceding::code")
	//@FindBy(id="req-url")
	protected WebElement UniqueUrl;
	
	//@FindBy(id="ApiKeyDeleteBtn1")
	@FindBy(xpath="//div[@id='ApiKeyDeleteBtn1'][1]")
	protected WebElement DeleteAPIKeysBtn;
	
	@FindBy(xpath="(//div[contains(@id,'ApiKeyDeleteBtn')])[last()]")
	protected WebElement DeleteAPIKeysBtnLast;
	
	@FindBy(xpath="(//div[@id='OCR_'])[1]")
	protected WebElement DeleteLabelOCRAPIKeysBtn;
	
	@FindBy(xpath="(//div[@id='OCR_'])[last()]")
	protected WebElement DeleteLabelOCRAPIKeysBtnLast;
	
	@FindBys(@FindBy(xpath="(//div[contains(@id,'ApiKeyDeleteBtn')])[last()]"))
	public List<WebElement> DeleteBtnLast;
	
	@FindBy(xpath="//button[text()='Delete']")
	protected WebElement ConfirmDeleteBtn;
	
	@FindBy(id="EditBtnKey1")
	protected WebElement EditWebhookBtn;
	
	@FindBy(id="deleteWebhookKey1")
	protected WebElement DeleteWebhookBtn;
	
	
	
}
