package Items;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Login.LoginPage;
import Recipients.RecipientsPage;
import SiteElements.ItemsPageElements.ItemsPageElements;
import Users.UsersPage;
import Utilities.CommonActions;
import Utilities.GlobalVariables;
import Utilities.Waits;

public class ItemsPage extends ItemsPageElements{

	private WebDriver driver;
	private WebDriverWait wait;
	private CommonActions commonActions;
	private LoginPage loginPage;
	private UsersPage usersPage;
	private RecipientsPage recipientsPage;

	public ItemsPage(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
		commonActions = new CommonActions(driver, wait);
		PageFactory.initElements(driver, this);
	}
	
	public void basicSearch() {
		
		ItemsTab.click();
		SearchType.click();
		Basic.click();
		SearchBarItems.click();
		SearchBarItems.sendKeys("Anna Friis");
		SearchBtn.click();
	}
	
	public void labelTextSearch() throws InterruptedException {
			
		ItemsTab.click();		
		SearchType.click();
		LabelText.click();
		SearchBarItems.click();
		SearchBarItems.sendKeys("Fragile");
		SearchBtn.click();
		CommonActions.waitLogoInvisible();
	}
	
	public void copyTrackingNo() {
		
		CopyTrackingNo.click();
		CommonActions.doubleClick(SearchBarItems);
		SearchBarItems.sendKeys(Keys.CONTROL + "a",Keys.BACK_SPACE);
		SearchBarItems.sendKeys(Keys.CONTROL + "v");
		Waits.waitTime(1);
		SearchBtn.click();
		CommonActions.waitLogoInvisible();
	}
	
	public void advancedFilters() {

		CommonActions.waitForElement(ItemsTab);
		if(ItemsTab.isDisplayed()) {
			ItemsTab.click();
		}
		
		CommonActions.waitForElement(AdvanceFilters);
		if(AdvanceFilters.isEnabled()) {
			//CommonActions.focusElementJs(driver, AdvanceFilters);
			AdvanceFilters.click();
		}

		recipients();
		groups();
		pickedUpBy();
		scanBy();
		carrier();
		actions();
		labels();
		shelf();
		scanType();
		applyFilter();
		statusFilter();

	}
	
	public void searchFilters() {
		
		Search.click();
	}
	
	
	public void recipients() {
		
		CommonActions.waitForElement(SelectARecipient);
		SelectARecipient.click();
		Search.click();
		Search.sendKeys("Recipient Items"+ Keys.ENTER);
		CommonActions.waitProgressBarInvisible();
		FirstCheckBox.click();
		CommonActions.escKey();
		
	}
	
	public void groups() {
		
		CommonActions.waitForElement(Groups);
		Groups.click();
		Search.click();
		Search.sendKeys("Pakistan"+ Keys.ENTER);
		CommonActions.waitProgressBarInvisible();
		FirstCheckBox.click();
		CommonActions.escKey();
	}
	
	public void pickedUpBy() {
		
		CommonActions.waitForElement(PickedUpBy);
		PickedUpBy.click();
		Search.click();
		Search.sendKeys("Recipient Items" + Keys.ENTER);
		CommonActions.waitProgressBarInvisible();
		FirstCheckBox.click();
		CommonActions.escKey();
	}
	
	public void scanBy() {
		
		CommonActions.waitForElement(ScanBy);
		ScanBy.click();
		Search.click();
		Search.sendKeys("test"+ Keys.ENTER);
		CommonActions.waitProgressBarInvisible();
		FirstCheckBox.click();
		CommonActions.escKey();
	}
	
	public void carrier() {
		
		CommonActions.waitForElement(Carrier);
		Carrier.click();
		Search.click();
		Search.sendKeys("UPS"+ Keys.ENTER);
		CommonActions.waitProgressBarInvisible();
		FirstCheckBox.click();
		CommonActions.escKey();
		
	}
	
	public void actions() {

		CommonActions.waitForElement(Actions);
		Actions.click();
		ScanAndSendChkBox.click();
		CommonActions.escKey();

	}
	
	public void labels() {
		
		CommonActions.waitForElement(Labels);
		Labels.click();
		ChkBox_DocumentGlobal.click();
		CommonActions.escKey();
	}
	
	public void shelf() {
		
		CommonActions.waitForElement(Itemlocation);
		Itemlocation.click();
		DrawerAChkBox.click();
		CommonActions.escKey();
	}
	
	public void scanType() {
	
		CommonActions.waitForElement(ScanType);
		ScanType.click();
		RdBtn_All.click();
		CommonActions.escKey();
		
	}
	
	
	public void applyFilter() {
		
		CommonActions.waitForElement(ApplyFilterBtn);
		if(ApplyFilterBtn.isEnabled()) {
			ApplyFilterBtn.click();
		}
		CommonActions.waitLogoInvisible();
		Waits.waitTime(3);
		ClearFilters.click();
		CommonActions.waitLogoInvisible();
	}
	
	public void statusFilter() {
		
		CommonActions.waitForElement(StatusFilter);
		if(StatusFilter.isEnabled()) {
			StatusFilter.click();
		}
		
		CommonActions.waitForElement(Holding_chkBox);
		Holding_chkBox.click();
		CommonActions.waitForElement(Collected_chkBox);
		Collected_chkBox.click();
		
		CommonActions.waitForElement(SearchBtn_StatusFilter);
		if(SearchBtn_StatusFilter.isEnabled()) {
			SearchBtn_StatusFilter.click();
		}
		
		CommonActions.waitLogoInvisible();
	}
	
	public void filterByDate() {
		
		CommonActions.waitForElement(ItemsTab);
		if(ItemsTab.isDisplayed()) {
			ItemsTab.click();
			//CommonActions.waitLogoInvisible();
		}
		
		dateFilter();
		
		CommonActions.waitForElement(ThisWeek);
		if(ThisWeek.isEnabled()) {
			ThisWeek.click();
		}
		apply();
		CommonActions.waitLogoInvisible();
		ClearFilters.click();
		
		dateFilter();
		CommonActions.waitForElement(LastWeek);
		if(LastWeek.isEnabled()) {
			LastWeek.click();
		}
		apply();
		CommonActions.waitLogoInvisible();
		ClearFilters.click();
		
		dateFilter();
		CommonActions.waitForElement(LastMonth);
		if(LastMonth.isEnabled()) {
			LastMonth.click();
		}
		apply();
		CommonActions.waitLogoInvisible();
		ClearFilters.click();
	}
	
	public void apply() {
		
		CommonActions.waitForElement(ApplyBtn);
		if(ApplyBtn.isEnabled()) {
			ApplyBtn.click();
		}
	}
	
	public void dateFilter() {
		
		Waits.waitTime(9);
		CommonActions.waitForElement(DateFilter);
		if(DateFilter.isDisplayed()) {
			CommonActions.focusElementJs(driver, DateFilter);
			DateFilter.click();
			//DateFilter.click();
			
		}
	}
	
	public void columnPreferences() throws InterruptedException {
		
		CommonActions.waitForElement(ItemsTab);
		if(ItemsTab.isDisplayed()) {
			ItemsTab.click();
		}
		
		CommonActions.waitForElement(ColumnPreferences);
		if(ColumnPreferences.isDisplayed()) {
			ColumnPreferences.click();
		}
		
		CommonActions.waitForElement(Group_TglBtn);
		if(Group_TglBtn.isDisplayed()) {
			Group_TglBtn.click();
		}
		CommonActions.waitForElement(Status_TglBtn);
		if(Status_TglBtn.isDisplayed()) {
			Status_TglBtn.click();
		}
		CommonActions.waitForElement(CheckedIn_TglBtn);
		if(CheckedIn_TglBtn.isDisplayed()) {
			CheckedIn_TglBtn.click();
		}
		CommonActions.waitForElement(CheckedOut_TglBtn);
		if(CheckedOut_TglBtn.isDisplayed()) {
			CheckedOut_TglBtn.click();
		}
//		CommonActions.waitForElement(Carrier_TglBtn);
//		if(ItemLocation_TglBtn.isDisplayed()) {
//			Carrier_TglBtn.click();
//		}
		CommonActions.waitForElement(Unit_TglBtn);
		if(Unit_TglBtn.isDisplayed()) {
			Unit_TglBtn.click();
		}
		CommonActions.waitForElement(LastUpdate_TglBtn);
		if(LastUpdate_TglBtn.isDisplayed()) {
			LastUpdate_TglBtn.click();
		}
		CommonActions.waitForElement(SenderName_TglBtn);
		if(SenderName_TglBtn.isDisplayed()) {
			SenderName_TglBtn.click();
		}
		CommonActions.waitForElement(ScanType_TglBtn);
		if(ScanType_TglBtn.isDisplayed()) {
			ScanType_TglBtn.click();
		}
		CommonActions.waitForElement(ItemLocation_TglBtn);
		if(ItemLocation_TglBtn.isDisplayed()) {
			ItemLocation_TglBtn.click();
		}
		CommonActions.waitForElement(Carrier_TglBtn);
		if(ItemLocation_TglBtn.isDisplayed()) {
			Carrier_TglBtn.click();
		}
		
		UsersPage.clickSave();
	}


}
