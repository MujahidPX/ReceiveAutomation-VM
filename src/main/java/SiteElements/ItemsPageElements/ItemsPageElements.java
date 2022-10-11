package SiteElements.ItemsPageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemsPageElements {

	WebDriver driver;

	@FindBy(xpath="//a[@aria-label='Items']")
    protected WebElement ItemsTab;
	
	@FindBy(xpath="//input[@type='text']")
	protected WebElement SearchBarItems;
	
	@FindBy(xpath="//button[@class='ant-btn ant-btn-primary ant-input-search-button']")
	protected WebElement SearchBtn;
	
	@FindBy(xpath="(//div[@aria-haspopup='listbox'])[1]")
	protected WebElement SearchType;
	
	@FindBy(xpath="//li[@data-value='basic']")
	protected WebElement Basic;
	
	@FindBy(xpath="//span[text()='Label Text']")
	protected WebElement LabelText;
	
	@FindBy(xpath="//span[@aria-label='Advance Filters']")
	protected WebElement AdvanceFilters ;
	
	@FindBy(xpath="(//div[@aria-label='Copy Tracking Number'])[1]")
	protected WebElement CopyTrackingNo;
	
	
	@FindBy(xpath="//label[text()='Select a Recipient']/following::div[2]")
	protected WebElement SelectARecipient;
	
	@FindBy(xpath="(//input[@placeholder='Search'])[2]")
	protected WebElement Search;
	
	@FindBy(xpath="(//input[@placeholder='Search'])[2]/following::input[@type='checkbox'][1]")
	protected WebElement FirstCheckBox;
	
	@FindBy(xpath="//label[text()='Picked Up By']/following::div[2]")
	protected WebElement PickedUpBy;
	
	@FindBy(xpath="//label[text()='Select a carrier']/following::div[2]")
	protected WebElement Carrier;
	
	@FindBy(xpath="//label[text()='Labels']/following::div[2]")
	protected WebElement Labels;
	
	@FindBy(xpath="//p[text()='Document Global']")
	protected WebElement ChkBox_DocumentGlobal;
	
	@FindBy(xpath="//label[text()='Scan Type']/following::div[2]")
	protected WebElement ScanType;
	
	@FindBy(xpath="//span[text()='ALL']")
	protected WebElement RdBtn_All;
	
	@FindBy(xpath="//span[text()='Inbound']")
	protected WebElement RdBtn_Inbound;
	
	@FindBy(xpath="//span[text()='Outbound']")
	protected WebElement RdBtn_Outbound;
	
	@FindBy(xpath="//label[text()='Groups']/following::div[2]")
	protected WebElement Groups;
	
	@FindBy(xpath="//label[text()='Scan By']/following::div[2]")
	protected WebElement ScanBy;

	@FindBy(xpath="//label[text()='Actions']/following::div[2]")
	protected WebElement Actions;
	
	@FindBy(xpath="//p[text()='Scan & Send']")
	protected WebElement ScanAndSendChkBox;

	@FindBy(xpath="//label[text()='Select Shelf']/following::div[2]")
	protected WebElement SelectShelf;
	
	@FindBy(xpath="//label[text()='Select Item Location']/following::div[2]")
	protected WebElement Itemlocation;
	
	@FindBy(xpath="//p[text()='Drawer A']")
	protected WebElement DrawerAChkBox;
	
	@FindBy(xpath="//button[text()='Apply Filter']")
	protected WebElement ApplyFilterBtn;
	
	@FindBy(xpath="//button[text()='Reset Filter']")
	protected WebElement ResetFilterBtn;
	
	@FindBy(xpath="//button[text()='Reset']")
	protected WebElement ResetBtn;
	
	
	@FindBy(xpath="//span[@aria-label='Discard Items']")
	protected WebElement DiscardItems;
	
	@FindBy(xpath="//span[@aria-label='Mark as Picked']")
	protected WebElement MarkAsPicked;
	
	@FindBy(xpath="//span[text()='Remind']")
	protected WebElement Remind;
	
	@FindBy(xpath="//*[text()='Mark as picked up']")
	protected WebElement MarkAsPickedUp;
	
	@FindBy(xpath="//*[text()='Discard Item']")
	protected WebElement DiscardItem;
	
	
	@FindBy(xpath="//span[@class='ant-dropdown-trigger ant-table-filter-trigger']")
	protected WebElement StatusFilter;
	
	@FindBy(xpath="//input[@value='Overdue']")
	protected WebElement Overdue_chkBox;
	
	@FindBy(xpath="(//label[@class='ant-checkbox-wrapper' and @style='font-weight: 500;'])[2]")
	protected WebElement Holding_chkBox;
			
	@FindBy(xpath="(//label[@class='ant-checkbox-wrapper' and @style='font-weight: 500;'])[3]")
	protected WebElement Collected_chkBox;
					
	@FindBy(xpath="//input[@value='Scanned']")
	protected WebElement Scanned_chkBox;
					
	@FindBy(xpath="//input[@value='Deleted']")
	protected WebElement Deleted_chkBox;
					
	@FindBy(xpath="//input[@value='Discarded']")
	protected WebElement Discarded_chkBox;
	
	@FindBy(xpath="(//span[text()='Search'])[2]")
	protected WebElement SearchBtn_StatusFilter;
	
	@FindBy(xpath="//span[text()='Reset']")
	protected WebElement ResetBtn_StatusFilter;
	
	@FindBy(xpath="//span[text()='Clear Filters']")
	protected WebElement ClearFilters;
	
	@FindBy(xpath="//span[@role='progressbar']")
	protected WebElement ProgressBar;
	
	@FindBy(xpath="(//input[@type='checkbox'])[2]")
	protected WebElement FirstItemFromList;
	
	
	//@FindBy(xpath="//span[@aria-label='Filter by Date']/button/span")
	@FindBy(xpath="//span[@data-tut='items-dateFilter']")
	protected WebElement DateFilter;
	
	@FindBy(xpath="//span[text()='Today']")
	protected WebElement Today;
	
	@FindBy(xpath="//span[text()='This Week']")
	protected WebElement ThisWeek;
	
	@FindBy(xpath="//span[text()='Last Week']")
	protected WebElement LastWeek;
	
	@FindBy(xpath="//span[text()='Last Month']")
	protected WebElement LastMonth;
	
	@FindBy(xpath="//span[text()='Last Three Months']")
	protected WebElement LastThreeMonths;
	
	@FindBy(xpath="//button[text()='Apply']")
	protected WebElement ApplyBtn;
	
	@FindBy(xpath="//button[text()='Reset']")
	protected WebElement Reset_Btn;
	
	
	
	
	
	@FindBy(xpath="//span[@aria-label='Column Preferences']")
	protected WebElement ColumnPreferences;
	
	@FindBy(id="group")
	protected WebElement Group_TglBtn;
	
	@FindBy(id="status")
	protected WebElement Status_TglBtn;
	
	@FindBy(id="checked_in")
	protected WebElement CheckedIn_TglBtn;
	
	@FindBy(id="checked_out")
	protected WebElement CheckedOut_TglBtn;
	
	@FindBy(id="carrier")
	protected WebElement Carrier_TglBtn;
	
	@FindBy(id="unit")
	protected WebElement Unit_TglBtn;
	
	@FindBy(id="last_update")
	protected WebElement LastUpdate_TglBtn;
	
	@FindBy(id="sender_name")
	protected WebElement SenderName_TglBtn;
	
	@FindBy(id="scan_type")
	protected WebElement ScanType_TglBtn;
	
	@FindBy(id="item_location")
	protected WebElement ItemLocation_TglBtn;
	
	
	// History
	
	@FindBy(xpath="//div[@class='ant-col ant-col-22'][1]")
	protected WebElement HistoryRecord;
}
