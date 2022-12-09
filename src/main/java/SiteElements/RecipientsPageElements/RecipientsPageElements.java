package SiteElements.RecipientsPageElements;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import Recipients.RecipientsPage;

//import Utilities.GlobalVariables;

public class RecipientsPageElements {

	private static final String AboutUsText = "GlobalVariables.AdminUserRole";

	WebDriver driver;

	@CacheLookup
	@FindBy(xpath="//a[@aria-label='Recipients']")
	//@FindBy(xpath="//span[text()='Recipients']")
    protected WebElement RecepientsTab;
	
	@FindBy(xpath="//div[text()='Groups']")
	protected WebElement GroupsTab;
	
	@FindBy(xpath="//span[text()='Create']")
    protected WebElement CreateBtn;
	
	@FindBy(xpath="//span[text()='Add']")
	protected WebElement Add_ddl;
	
	//@FindBy(xpath="//span[text()='Recipient']")
	@FindBy(xpath="(//span[text()='Recipients'])[2]")
    protected WebElement Recepient;
	
	@FindBy(xpath="//span[text()='Groups']")
    protected WebElement Group;
	
	@FindBy(xpath="//button[@aria-label='Choose Location']")
	protected WebElement ChooseLocation;
	
	// Recipient Information
	
	@FindBy(xpath="//input[@name='name']")
    protected WebElement Name;

	@FindBy(xpath="//input[@name='email']")
    protected WebElement Email;
	
	@FindBy(xpath="//input[@class='form-control phone-input'] | //input[@id='phone-form-control']")
    public static WebElement Phone;
	
	@FindBy(xpath="//input[@name='location']")
    protected WebElement Locationddl;
	
	@FindBy(xpath="//button[text()='Apply']")
    protected WebElement Apply;
	
	@FindBy(xpath="//input[@name='unit']")
    protected WebElement Unit;
	
	@FindBy(xpath="//input[@name='address']")
    protected WebElement Address;
	
	@FindBy(xpath="//input[@name='custom1']")
    protected WebElement Custom1;
    
    @FindBy(xpath="//input[@name='custom2']")
    protected WebElement Custom2;
    
    @FindBy(xpath="//textarea[@name='notes']")
    protected WebElement Notes;
    
   
    @FindBy(xpath="//label[text()='ADD ALTERNATE']/following::div[1]")
    protected WebElement AddAlternateddl;
   
    @FindBy(xpath="//input[@name='alternateName']")
    protected WebElement AlternateName;
    
    @FindBy(xpath="//input[@name='alternateEmail']")
    protected WebElement AlternateEmail;
    
    @FindBy(xpath="(//input[@class='form-control phone-input'])[2] | (//input[@id='phone-form-control'])[2]")
    protected WebElement AlternatePhone;
    
    @FindBy(xpath="//button[text()='Add']")
    protected WebElement AddBtn;
    
    @FindBy(xpath="(//span[text()='Name'])[2]")
    protected WebElement NameBtn;
    		
    @FindBy(xpath="//span[text()='Email']")
    protected WebElement EmailBtn;
    
    @FindBy(xpath="//span[text()='Phone']")
    protected WebElement PhoneBtn;
    
    @FindBy(name="Alternate Group Alias")
    protected WebElement AlternateGroupAlias;
    
    @FindBy(xpath="//button[text()='Save']")
    protected WebElement SaveBtn;
    
    @FindBy(xpath="//div[@class='ant-notification-notice-with-icon']")
	public static WebElement SuccessMsgNotification;
    
    @FindBy(id="notification-title")
    public static WebElement NotificationMsg;
    
    @FindBy(xpath="//*[text()='Recipient added successfully']")
    protected WebElement NewRecipientAddedMsg;
    
    @FindBy(xpath="//*[text()='Recipient deleted successfully.']")
    protected WebElement RecipientDeletedMsg;
    
    @FindBy(xpath="//span[text()='Group added successfully.']")
    protected WebElement GroupAddedMsg;
    
    @FindBy(xpath="//*[text()='Group deleted successfully.']")
    protected WebElement GroupDeletedMsg;
    
    @FindBy(xpath="//div[@class='MuiAvatar-root MuiAvatar-circular cursor-pointer MuiAvatar-colorDefault']")
	protected WebElement LogoutMenu;
    
    
    // Assign Recipients
    
    @FindBy(xpath="(//*[contains(text(),'')])/preceding::td/label/span")
    protected WebElement RecipientCheckBox;
    
    @FindBy(xpath="//span[text()='Assign Recipients']")
    protected WebElement AssignRecipientsBtn;
    
    
    @FindBy(xpath="//span[@aria-label='search']")
    protected WebElement SearchRecipientsIcon;
    
    @FindBy(xpath="//input[@placeholder='Search name']")
    protected WebElement SearchName;
    
    @FindBy(xpath="//span[text()='Search']")
    protected WebElement SearchBtn;
    
    @FindBy(xpath="(//button[text()='Save'])[2]")
    protected WebElement AssignRecipientsSaveBtn;
    
    @FindBy(xpath="//span[@class='anticon mailroom-loading-logo ant-spin-dot']")
    protected static WebElement LogoInRecipient;
    
    @FindBy(xpath="//div[@class='ant-spin ant-spin-spinning']")
    protected WebElement RecipientTable;
    
    @FindBy(xpath="//div[text()='Name']")
    protected WebElement NameLabel;
    
    @FindBy(xpath="//h5[text()='Recipients']")
    protected WebElement RecipientLabel;
    
    
    // Upload CSV
    
    @FindBy(xpath="//span[text()='Upload CSV']")
    protected WebElement UploadCSVBtn;
    
    @FindBy(xpath="//span[text()='Upload New CSV']")
    protected WebElement UploadNewCSV;
    
    @FindBy(xpath="//*[text()='SELECT LOCATION']")
    protected WebElement SelectLocationlbl;
    
    @FindBy(xpath="(//div[@aria-haspopup='listbox'])[2]")
    protected WebElement SelectLocationtxt2;
    
    @FindBy(xpath="//div[@aria-haspopup='listbox']")
    protected WebElement SelectLocationtxt;
    
    @FindBy(xpath="//ul[@role='listbox']")
    protected WebElement LocationsList;
    
   // @FindBy(xpath="//div[@class='ant-upload-drag-container']")
    @FindBy(xpath="//div[@class='ant-upload ant-upload-drag sc-hrDvXV kUHhKy']/span/div/p[1]")
    protected WebElement DropYourFileHere;
    
    @FindBy(xpath="//span[text()='Upload']")
    protected WebElement UploadBtn;
    
    @FindBy(xpath="(//*[@id='modal-close-icon'])[2]")
    protected WebElement CloseBtnUploadCSV;
    
    @FindBy(xpath="//div[@aria-haspopup='listbox']/following::span[text()='Select']/preceding::div[@class='inner-text text-capitalize'][1]")
    //@FindBy(xpath="//div[@class='inner-text text-capitalize']")
    protected WebElement UploadedItems;
    
    @FindBy(xpath="//div[@aria-haspopup='listbox']/following::span[text()='Select']/preceding::div[@class='inner-text text-capitalize'][1]")
    protected WebElement UploadedItem1;
    
    @FindBy(xpath="//div[@aria-haspopup='listbox']/following::span[text()='Select']")
   // @FindBy(xpath="//div[@aria-haspopup='listbox']")
    protected WebElement DBSelects;
    
    //@FindBy(xpath="//p[text()='Name']")
    @FindBy(xpath="//td[normalize-space(text())='"+AboutUsText+"']/a")
    protected WebElement SelectName;
    
    @FindBy(xpath="//span[text()='Next']")
    protected WebElement NextBtn;
    
    @FindBy(xpath="//div[text()='Email']/following::a[@href][1]")
    protected WebElement EmialImportedRecipient;
    
    @FindBy(xpath="//h6[text()='Merge']")
    protected WebElement MergeRdBtn;
    
    @FindBy(xpath="//h6[text()='Overwrite']")
    protected WebElement OverwriteRdBtn;
    
    @FindBy(xpath="//span[text()='Continue']")
    protected WebElement ContinueBtn;
    
    @FindBy(xpath="//span[text()='Missing Entry!!']")
    protected WebElement MissingEntry;
    
    @FindBy(xpath="//h5[contains(text(),' Issue')]")
    protected WebElement IssueAlert;
    
    @FindBy(xpath="//span[text()='Fix now']")
    protected WebElement FixnowBtn;
    
    @FindBy(xpath="//span[text()='Confirm']")
    protected WebElement ConfirmBtn;
    
    @FindBy(xpath="//span[text()='Skip issues & continue']")
    protected WebElement SkipIssuesContinueBtn;
    
    @FindBy(xpath="//span[@aria-label='Refresh Data']")
    protected WebElement RefreshDataBtn;
        
    @FindBy(xpath="(//span[contains(text(),'Success')])[1]")
    protected WebElement FileUploadedSuccess;
    
    @FindBy(xpath="//span[text()='CSV successfully uploaded.']")
    protected WebElement CSVUploadedMsg;
    
    // Failed File
    @FindBy(xpath="//span[contains(text(),'Failure')]/following::button[1]")
    protected static WebElement FailedCSVFile;
    
	@FindBys(@FindBy(xpath="//span[contains(text(),'Failure')]/following::button[1]"))
	public static List<WebElement> FailedCSVFile1;
	
	
	@FindBy(xpath="//div[@class='inner-text text-ellipsis-15rem']")
	protected static WebElement EditRecord;
	
	//@FindBy(name="recipient-name")
	@FindBy(xpath="//input[@name='recipient-name']")
	protected static WebElement EditRecipientName;
	
	@FindBy(xpath="//span[text()='Recipient updated successfully']")
	protected static WebElement RecipientUpdatedMsg;
	
	@FindBy(xpath="(//div[text()='Email']/following::td/a[@href])[2]")
	protected WebElement uploadedRecipientEmail;
	
	//
	@FindBy(id="name_0")
	protected WebElement NameReview;
	
	@FindBy(xpath="//input[contains(@id,'name_')]")
	protected WebElement NameReviewCSV;
	
	@FindBy(id="email_0")
	protected WebElement EmailReview;
	
	@FindBy(xpath="//input[contains(@id,'email_')]")
	protected WebElement EmailReviewCSV;
	
	@FindBy(xpath="//div[@class='inner-text']")
	protected WebElement GroupData;
	
	@FindBy(xpath="(//button[text()='Delete'])[2] | //button[text()='Delete']")
	protected static WebElement DeleteConfirmBtn;
	
	@FindBy(name="recipient-name")
	protected static WebElement RecipientName;
	
	@FindBy(name="email")
	protected static WebElement RecipientEmail;
	
	@FindBy(xpath="(//div[@class='inner-text'])[1]")
	protected static WebElement SelectGroupFromList;
	
	
	 /// Notification Preferences
	 
	 @FindBy(xpath="(//p[text()='Notify']/following::input[@type='checkbox']/following::p[text()='Email'])[1]")
	 protected WebElement NotifyEmailChkBox;
	 
	 @FindBy(xpath="(//p[text()='Remind']/following::input[@type='checkbox']/following::p[text()='Email'])[1]")
	 protected WebElement RemindEmailChkBox;
	 
	 @FindBy(xpath="(//p[text()='Pickup']/following::input[@type='checkbox']/following::p[text()='Email'])[1]")
	 protected WebElement PickupEmailChkBox;
	 
	 
	 /// Assign to a group
	 
	 @FindBy(xpath="//input[@placeholder='Search Group']")
	 protected WebElement SearchGroupSearchBar;
	 
	 @FindBy(xpath="//span[@aria-label='search']")
	 protected WebElement SearchBtnSearchBar;
	 
	 @FindBy(xpath="//span[@aria-label='loading']")
	 protected WebElement LoadingIcon;
	 
	 @FindBy(xpath="(//div[@class='sc-kRktcz ipCUhm'])[2]")
	 protected WebElement SearchGroup_ddl;
	 
	 @FindBy(xpath="//div[text()='Pakistan']")
	 protected WebElement SearchGroup_Option;
	 
	 @FindBy(xpath="//input[@placeholder='Search Group']/following::div[2]")
	 protected WebElement SearchGroup_Option1;
	 
	 @FindBy(xpath="//h6[text()='Assign to a Group']")
	 protected WebElement AssignToGroup_txt;
	 
	 /// Recipients Column Preference
	 
	@FindBy(xpath="//span[@aria-label='Column Preferences']")
	protected WebElement ColumnPreferences;
		
	@FindBy(id="group")
	protected WebElement Group_TglBtn;
	
	@FindBy(id="location")
	protected WebElement Location_TglBtn;
	 
	@FindBy(id="unit")
	protected WebElement Unit_TglBtn;
	
	
	@FindBy(id="phone")
	protected WebElement Phone_TglBtn;
	
	@FindBy(id="organization")
	protected WebElement Organization_TglBtn;
	 
	@FindBy(id="city")
	protected WebElement City_TglBtn;
	
	@FindBy(id="last_update")
	protected WebElement LastUpdate_TglBtn;
	
	@FindBy(id="received_items")
	protected WebElement ReceivedItems_TglBtn;
	
	@FindBy(id="pending_items")
	protected WebElement PendingItems_TglBtn;
	
	@FindBy(id="notification_preferences")
	protected WebElement NotificationPreferences_TglBtn;
	
	
	///Groups Column Preferences
	
	@FindBy(id="total_recipients")
	protected WebElement TotalRecipients_TglBtn;
	
	@FindBy(id="designated_recipients")
	protected WebElement DesignatedRecipients_TglBtn;
	
	@FindBy(id="recipient_items")
	protected WebElement RecipientItems_TglBtn;
	
//	@FindBy(xpath="//button[@id='recipient_items' and @disabled]")
//	protected WebElements RecipientItemsDisabled_TglBtn;
	
	@FindBys(@FindBy(xpath="//button[@id='recipient_items' and @disabled]"))
	public List<WebElement> RecipientItemsDisabled_TglBtn;
	
	@FindBy(id="last_updated_by")
	protected WebElement LastUpdatedBy_TglBtn;
	
	@FindBys(@FindBy(xpath="//button[@id='last_updated_by' and @disabled]"))
	//protected WebElement LastUpdatedByDisabled_TglBtn;
	public List<WebElement> LastUpdatedByDisabled_TglBtn;
	
	
	// Add custom fields
	
	@FindBy(xpath="//button[@aria-label='Set Custom Fields']")
	public WebElement SetCustomFields;
	
	@FindBy(name="customId1")
	public WebElement Field1;
	
	@FindBy(name="customId2")
	public WebElement Field2;
	
	@FindBy(xpath="//label[text()='Custom Field 1']/following::*[local-name()='svg' and @stroke='currentColor'][1]")
	protected WebElement CustomField_1_ClearBtn;
	
	@FindBy(xpath="//label[text()='Custom Field 2']/following::*[local-name()='svg' and @stroke='currentColor'][1]")
	protected WebElement CustomField_2_ClearBtn;
	
	@FindBy(xpath="//*[local-name()='svg' and @id='modal-close-icon']")
	protected WebElement CloseCustomFieldsPopup;
	
	@FindBys(@FindBy(xpath="//button[text()='Save']/span"))
	public List<WebElement> saveBtnCF;
	
	@FindBy(xpath="//button[text()='Save']")
	protected WebElement SaveBtnCF;
	
	@FindBy(xpath="(//div[text()='Organization'])[2]")
	protected WebElement Organization_ColPref;
	
	@FindBy(xpath="(//div[text()='City'])[2]")
	protected WebElement City_ColPref;
	
	//@FindBy(xpath='+RecipientsPage.UpdatedEmail+')
	@FindBy(xpath="//div[text()='Organization']")
	//@FindBy(xpath="//div[@class='' contains.text('RecipientsPage.UpdatedEmail')]")
	protected WebElement Organization_Col;
	
	@FindBy(xpath="//div[text()='City']")
	protected WebElement City_Col;
	
	
	// Alternate fields
	
	@FindBy(xpath="//h6[text()='Alternate Name(s)']/following::*[local-name()='svg' and @class='MuiSvgIcon-root MuiChip-deleteIcon'][1]")
	protected WebElement AlternateName_1_DelBtn;
	
	@FindBy(xpath="//h6[text()='Alternate Name(s)']/following::*[local-name()='svg' and @class='MuiSvgIcon-root MuiChip-deleteIcon'][2]")
	protected WebElement AlternateName_2_DelBtn;
	
	@FindBy(xpath="//h6[text()='Alternate Emails(s)']/following::*[local-name()='svg' and @class='MuiSvgIcon-root MuiChip-deleteIcon'][1]")
	protected WebElement AlternateEmail_1_DelBtn;
	
	@FindBy(xpath="//h6[text()='Alternate Number(s)']/following::*[local-name()='svg' and @class='MuiSvgIcon-root MuiChip-deleteIcon'][1]")
	protected WebElement AlternateNumber_1_DelBtn;
	
	
	//Assign to a Group

	@FindBy(xpath="//h6[text()='Selected Groups']/following::*[local-name()='svg' and @xmlns='http://www.w3.org/2000/svg']")
	protected WebElement AddedGroup_DelBtn;
	
	@FindBy(xpath="//h6[text()='Selected Groups']/following::button[@role='switch']")
	protected WebElement GroupItems_ToggleBtn;

	@FindBy(xpath="//span[text()='Remove All']")
	protected WebElement RemoveAll_SelectedGroups;
	

	@FindBy(xpath="//*[local-name()='svg' and @class='MuiSvgIcon-root MuiChip-deleteIcon']")
	protected WebElement GroupAlias_DelBtn;
	
	
	@FindBy(xpath="//span[text()='Clear Filters']")
	protected WebElement ClearFilters;
}

