package SiteElements.LocationsPageElements;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class LocationPageElements {

	WebDriver driver;

	//@FindBy(xpath="//span[text()='Locations']")
	@FindBy(xpath="//a[@href='/locations']")
    protected WebElement LocationsTab;
	
	//@FindBy(xpath="//button[text()='Add Location']")
	@FindBy(xpath="//button[text()='Create Location']")
    protected WebElement CreateLocation;
	
	@FindBy(id="name")
    protected WebElement LocationName;
	
	@FindBy(xpath="//label[text()='City']/following::input[@value]")
	protected WebElement City;
	
	@FindBy(id="code")
    protected WebElement Code;
	
	@FindBy(xpath="//label[@id='Places_input-label']")
	protected WebElement Addresslbl;
	
	@FindBy(xpath="//input[@id='Places_input']")
    protected WebElement Address;
	
	//@FindBy(xpath="//div[@class='pac-container pac-logo hdpi']")
	@FindBy(xpath="//div[@class='pac-item']")
	protected WebElement AddressList;
	
	@FindBy(id="replyTo")
    protected WebElement ReplyToAddress;
	
	//@FindBy(xpath="(//button[text()='Add Location'])[2]")
	@FindBy(xpath="(//button[text()='Create Location'])[2]")
    protected WebElement CreateLocationBtn;
	
	 @FindBy(xpath="//span[text()='Location added successfully.']")
	 protected WebElement LocationAddedMsg;
	 
	 
	 //// Edit Location
	 
	 @FindBy(xpath="(//a[contains(@href,'/locations/')])[1]")
	 protected WebElement FirstLocation;
	 
	 // Reminder Preferences

	 @FindBy(xpath="(//*[text()='friday']/following::div//button[@role='switch'])[1]")
	 protected WebElement FridayBtn;
	 
	 @FindBy(xpath="(//*[text()='monday']/following::div//button[@role='switch'])[1]")
	 protected WebElement MondayBtn;
	 
	 @FindBy(xpath="(//*[text()='tuesday']/following::div//button[@role='switch'])[1]")
	 protected WebElement TuesdayBtn;
	 
	 @FindBy(xpath="(//*[text()='wednesday']/following::div//button[@role='switch'])[1]")
	 protected WebElement WednesdayBtn;
	 
	 @FindBy(xpath="(//*[text()='thursday']/following::div//button[@role='switch'])[1]")
	 protected WebElement ThursdayBtn;
	 
	 
	 @FindBy(xpath="//button[text()='Save Changes']")
	 protected WebElement SaveChangesBtn;
	 
	 
	 //// Mailrooms
	 
	 @FindBy(xpath="//h5[text()='Mailrooms']/following::span[@class='MuiIconButton-label'][1]")
	 protected WebElement MailroomsAddBtn;
	 
	 @FindBy(xpath="(//div[@class='edit-button'])[last()]")
	 protected WebElement MailroomsEditBtn;

	 
	 @FindBy(id="mailroomName")
	 protected WebElement MailroomName;
	 
	 @FindBy(id="mailroomCode")
	 protected WebElement MailroomCode;
	 
	 @FindBys(@FindBy(xpath="//span[text()='Mailroom code already exists.']"))
	 public List<WebElement> MailroomExistMsg;
	 
	 //
	 //@FindBy(xpath="(//p[@class='sc-bBXxYQ kJgVVa table-data typography'])[last()-1]")
	 @FindBy(xpath="(//p[contains(@class,'table-data')])[last()-1]")
	 protected WebElement LastMailroom;
	 
	 @FindBy(xpath="(//button[text()='Save'])[5]")
	 protected WebElement SaveBtnMaialroom;
	 
	 @FindBy(xpath="//span[text()='Mailroom added successfully']")
	 public static WebElement MailroomAddedMsg;
	 
	 //// Users
	 
	 @FindBy(xpath="//h5[text()='Users']/following::span[@class='MuiIconButton-label'][1]")
	 protected WebElement UsersAddBtn;
	 
	 @FindBy(xpath="//input[@name='text']")
	 protected WebElement Name;
	 
	 @FindBy(xpath="//input[@name='email']")
	 protected WebElement Email;
	 
	 @FindBy(xpath="//label[text()='Role']/following::div[@aria-haspopup='listbox'] | //label[text()='ROLE']/following::div[@aria-haspopup='listbox']")
	 protected WebElement Role_ddl;
	 
	 @FindBy(xpath="//ul[@role='listbox']")
	 protected WebElement ListBox;
	
	 @FindBy(xpath="//label[text()='MAILROOM']/following::div[@aria-haspopup='listbox']")
	 protected WebElement Mailroom_ddl;
	 
	 @FindBy(xpath="(//button[text()='Add New'])[2]")
	 protected WebElement AddNewBtn;
	 
	 
	 @FindBy(xpath="//h5[text()='Users']/following::tr[@class='ant-table-row ant-table-row-level-0'][last()]")
	 protected WebElement UserFromList;
	 
	 /// Notification Preferences
	 
	 @FindBy(xpath="//span[text()='Enable Delayed Notifications']/button[@role='switch']")
	 protected WebElement EnableDelayedNotificationsSwitchBtn;
	 
	 @FindBy(xpath="(//p[text()='notify']/following::input[@type='checkbox']/following::p[text()='Email'])[1]")
	 protected WebElement NotifyEmailChkBox;
	 
	 @FindBy(xpath="(//p[text()='remind']/following::input[@type='checkbox']/following::p[text()='Email'])[1]")
	 protected WebElement RemindEmailChkBox;
	 
	 @FindBy(xpath="(//p[text()='pickup']/following::input[@type='checkbox']/following::p[text()='Email'])[1]")
	 protected WebElement PickupEmailChkBox;
	 
	 
	 //Recipient Preferences
	 
	 @FindBy(xpath="//p[text()='Enable CSV Upload']/div/button[@role='switch']")
	 protected WebElement EnableCSVUploadSwitchBtn;
	 
	 @FindBy(xpath="//p[text()='Enable Receive Connect']/div/button[@role='switch']")
	 protected WebElement EnableReceiveConnectSwitchBtn;
	 
	 @FindBy(xpath="//p[text()='Enable Mailbox']/div/button[@role='switch']")
	 protected WebElement EnableMailboxSwitchBtn;
	 
	 @FindBy(xpath="//span[text()='Recipient preferences updated successfully']")
	 public static WebElement RecipientPreferencesUpdatedMsg;
	 
	 // Receive Connect
	 
	 @FindBy(xpath="//span[text()='Receive Connect is disabled on Location Level']")
	 protected WebElement ReceiveConnectDisabled;
	 
	 @FindBy(xpath="(//p[text()='Scan & Send'])[1]")
	 protected WebElement ScanAndSendTab;
	 
	 @FindBy(xpath="(//p[text()='Forward'])[1]")
	 protected WebElement ForwardTab;
	 
	 @FindBy(xpath="(//p[text()='Destroy'])[1]")
	 protected WebElement DestroyTab;
	 
	 @FindBy(xpath="(//p[text()='Hold'])[1]")
	 protected WebElement HoldTab;
	 
	 
	 @FindBy(xpath="//p[text()='Scan & Send']/button[@role='switch']")
	 protected WebElement EnableScanAndSendSwitchBtn;
	 
	 @FindBy(xpath="//input[@id='cta-snapsend']")
	 protected WebElement TitleSnapSend; 
	 
	 @FindBy(xpath="//p[text()='Forward']/button[@role='switch']")
	 protected WebElement EnableForwardSwithcBtn;
	 
	 @FindBy(xpath="//input[@id='cta-fwd']")
	 protected WebElement TitleForward; 
	 
	 @FindBy(xpath="//p[text()='Destroy']/button[@role='switch']")
	 protected WebElement EnableDestroySwithcBtn;
	 
	 @FindBy(xpath="//input[@id='cta-destroy']")
	 protected WebElement TitleDestroy; 
	 
	 @FindBy(xpath="//p[text()='Hold']/button[@role='switch']")
	 protected WebElement EnableHoldSwithcBtn;
	 
	 @FindBy(xpath="//input[@id='cta-hold']")
	 protected WebElement TitleHold; 
	 
	 
	 @FindBy(xpath="(//button[text()='Add New'])[1]")
	 protected WebElement AddNewBtnSS;
	 
	 @FindBy(xpath="(//button[text()='Add New'])[2]")
	 protected WebElement AddNewBtnFwd;
	 
	 @FindBy(xpath="(//button[text()='Add New'])[3]")
	 protected WebElement AddNewBtnDestroy;
	 
	 @FindBy(xpath="(//button[text()='Add New'])[4]")
	 protected WebElement AddNewBtnHold;
	 
	 
	 @FindBy(xpath="(//tr[contains(@class,'ant-table-row ant-table-row-level-0')])[last()]")
	 protected WebElement LastUserFromList;
	 
	 
	 //Email Template
	 
	 @FindBy(xpath="//a[text()='Notify Template']")
	 protected WebElement NotifyTemplate;
	 
	 @FindBy(xpath="//a[text()='Remind Template']")
	 protected WebElement RemindTemplate;
	 
	 @FindBy(xpath="//a[text()='Reroute Template']")
	 protected WebElement RerouteTemplate;
	 
	 @FindBy(xpath="//a[text()='Pickup Template']")
	 protected WebElement PickupTemplate;
	 
	 @FindBy(xpath="//a[text()='Discard Template']")
	 protected WebElement DiscardTemplate;
	 
	 
	 @FindBy(xpath="(//div[@aria-haspopup='listbox'])[1]")
	 protected WebElement SelectType;
	 
	 @FindBy(xpath="(//div[@aria-haspopup='listbox'])[2]")
	 protected WebElement SelectCategory;
	 
	 @FindBy(xpath="//ul[@role='listbox']")
	 protected WebElement SelectCategory_ddl;
	 
	 @FindBy(xpath="//ul[@role='listbox']")
	 protected WebElement SelectTypeList;
	 
	 @FindBy(xpath="//label[text()='SUBJECT']/following::textarea[@class='mention-email-text__input'][1]")
	 protected WebElement Subject;
	 
	 @FindBy(xpath="//div[@class='ellipsis nw b f18']")
	 protected WebElement Email_Title;
	 
	 @FindBy(xpath="//label[text()='HEADLINE']/following::textarea[@class='mention-email-text__input'][1]")
	 protected WebElement Headline;
	 
	 @FindBy(xpath="//h1[@id='title']")
	 protected WebElement Headline_Response;
	 
	 @FindBy(xpath="//h1[@style]")
	 protected WebElement Email_Headline;
	 
	 @FindBy(xpath="//div[@data-tut='emailTemplate-body']")
	 protected WebElement Body;
	 
	 @FindBy(xpath="//p[@id='body']")
	 protected WebElement Body_Response;
	 
	 @FindBy(xpath="//p[@style]")
	 protected WebElement Body_Email;
	
	 @FindBy(xpath="(//span[contains(@style,'mso-text-raise: 8pt;')])[1]")
	 protected WebElement TrackingNoUSPS_1;
	 
	 @FindBy(xpath="(//span[text()='USPS']/following::tr/td/a)[1]")
	 protected WebElement Email_TrackingNoUSPS_1;
	 
	 @FindBy(xpath="(//span[contains(@style,'mso-text-raise: 8pt;')])[2]")
	 protected WebElement TrackingNoUSPS_2;
	 
	 @FindBy(xpath="(//span[text()='USPS']/following::tr/td/a)[2]")
	 protected WebElement Email_TrackingNoUSPS_2;
	 
	 @FindBy(xpath="//div[@class='ant-upload-drag-container']")
	 protected WebElement UploadLogoBtn;
	 
	 @FindBy(xpath="//span[text()='Remove']")
	 protected WebElement RemoveBtn;
	 
	 @FindBy(xpath="//span[text()='Replace']")
	 protected WebElement ReplaceBtn;
	 
	 @FindBy(xpath="//button[text()='Send Test Email']")
	 protected WebElement SendTestEmail;
	 
	 @FindBy(xpath="//span[text()='Email sent successfully']")
	 public static WebElement EmailSentMsg;
	 
	 @FindBy(xpath="//button[text()='Save Anyway']")
	 protected WebElement SaveAnyway;
	 
	 
	/// Column Preference
	 
	 @FindBy(xpath="//span[@aria-label='Column Preferences']")
	 protected WebElement ColumnPreferences;

	 @FindBy(id="city")
	 protected WebElement City_TglBtn;

	 @FindBy(id="country")
	 protected WebElement Country_TglBtn;

	 @FindBy(id="recipient")
	 protected WebElement Recipient_TglBtn;

	 @FindBy(id="group")
	 protected WebElement Group_TglBtn;

	 @FindBy(id="overdue_items")
	 protected WebElement OverdueItems_TglBtn;

	 @FindBy(id="scan_count")
	 protected WebElement ScanCount_TglBtn;
		
	 
}
