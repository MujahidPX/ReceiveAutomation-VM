package Locations;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

//import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
//import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Login.LoginPage;
import Settings.Locations.SettingsLocationsPage;
import SiteElements.SiteActions;
import SiteElements.LocationsPageElements.LocationPageElements;
import SiteElements.LoginPageElements.LoginElements;
import SiteElements.RecipientsPageElements.RecipientsPageElements;
import SiteElements.UsersPageElements.UsersPageElements;
import Users.UsersPage;
//import SiteElements.LoginPageElements.LoginElements;
//import SiteElements.RecipientsPageElements.RecipientsPageElements;
//import SiteElements.UsersPageElements.UsersPageElements;
import Utilities.CommonActions;
//import Utilities.ExcelFile;
import Utilities.GlobalVariables;
import Utilities.Helper;
import Utilities.Waits;
//import se.Se;

public class LocationsPage extends LocationPageElements {

	private WebDriver driver;
	private WebDriverWait wait;
	private CommonActions commonActions;
	private LoginPage loginPage;
	private UsersPage usersPage;
	private SettingsLocationsPage settingsLocationsPage;
	String originalWindow;
	
	public String SubjectText;
	public String HeadlineText;
	public String MessageText;
	public String Tracking1;
	
	public LocationsPage(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
		commonActions = new CommonActions(driver, wait);
		PageFactory.initElements(driver, this);
	}

	public void createNewLocation(String location) throws InterruptedException {

		Helper.waitForPageLoad(driver);
		LoginPage.clickExpandBtn();
		clickLocationTab();
		LoginPage.clickExpandBtn();
		createLocation();
		enterLocationName();
		enterLocationCode();
		selectAddress(location);
		clickCreateLocation();

		SiteActions.notification();
		assertEquals(RecipientsPageElements.SuccessMsgNotification.getText(), "Location added successfully");
		CommonActions.waitForElementToDisappear(LocationAddedMsg);

	}

	public void clickLocationTab() {

		CommonActions.waitForElement(LocationsTab);
		if (LocationsTab.isEnabled()) {
			LocationsTab.click();
		}
	}

	public void createLocation() throws InterruptedException {
		Thread.sleep(5000);
		CommonActions.waitForElement(CreateLocation);
		if (CreateLocation.isEnabled()) {
			CreateLocation.click();
		}
	}

	public void enterLocationName() {

		Waits.waitTime(2);
		CommonActions.waitForElement(LocationName);
		if (LocationName.isEnabled()) {
			// LocationName.sendKeys("Hungary");
		}
	}

	public void enterLocationCode() {

		CommonActions.waitForElement(Code);
		if (Code.isEnabled()) {
			// Code.sendKeys("16");
			Code.sendKeys(GlobalVariables.LocationCode);
		}
	}

	public void selectAddress(String location) throws InterruptedException {

		Helper.waitForPageLoad(driver);
		CommonActions.scrollIntoView(Addresslbl);
		CommonActions.moveToElement(Addresslbl);
		CommonActions.waitForElement(Addresslbl);

		if (Addresslbl.isDisplayed()) {
			Addresslbl.click();
		}

		if (!Addresslbl.isDisplayed()) {

			CommonActions.scrollIntoView(Addresslbl);
			CommonActions.moveToElement(Addresslbl);
			CommonActions.waitForElement(Addresslbl);
			Addresslbl.click();
		}

		CommonActions.waitForElement(Address);
		Address.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		List<WebElement> address = driver.findElements(By.xpath("//input[@id='Places_input']"));
		if (!address.isEmpty()) {

			Address.sendKeys(location + Keys.SPACE);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			Thread.sleep(2000);

			if (!AddressList.isDisplayed()) {
				Address.sendKeys(Keys.SPACE);
			}			
		}

		Helper.waitForPageLoad(driver);
		CommonActions.waitForElement(AddressList);
		AddressList.click();
		Thread.sleep(2000);
		String cityname = City.getAttribute("Value");
		LocationName.click();
		LocationName.sendKeys(cityname);
		Code.sendKeys(cityname.substring(0, 2));
	}

	public void clickCreateLocation() throws InterruptedException {

		CommonActions.moveToElement(CreateLocationBtn);
		CommonActions.focusElementJs(driver, CreateLocationBtn);
		CommonActions.waitForElement(CreateLocationBtn);
		if (CreateLocationBtn.isEnabled()) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			CommonActions.waitForPageLoad();
		}

		List<WebElement> createLocationBtn = driver.findElements(By.xpath("(//button[text()='Create Location'])[2]"));
		if (!createLocationBtn.isEmpty()) {
			CreateLocationBtn.click();
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			CommonActions.waitForPageLoad();
		}

	}

	public void addMailroom(String code) throws InterruptedException {

		CommonActions.waitForClickablility(LocationsTab, 15);
		LocationsTab.click();
		CommonActions.waitForElement(FirstLocation);
		FirstLocation.click();
		
		clickMailroomAddBtn();
		addMailroomName();
		addMailroomCode(code);
		UsersPage.clickSave();
	}

	public void clickMailroomAddBtn() {

		CommonActions.waitForElement(MailroomsAddBtn);
		MailroomsAddBtn.click();
	}

	public void clickMailroomEditBtn() {

		CommonActions.waitForElement(MailroomsEditBtn);
		MailroomsEditBtn.click();
	}

	public void addMailroomName() {

		//char name = lmr.charAt(8);
		CommonActions.waitForElement(MailroomName);
		MailroomName.sendKeys("Mailroom");
		Waits.waitTime(3);
	}

	public void addMailroomCode_1() throws InterruptedException {

		String lmr = LastMailroom.getText();
		String splittedLmr =lmr. substring(lmr. length() - 2);
		
		int value = Integer.parseInt(splittedLmr);
		System.out.println("splitted value is : " + value);
		value++;

		System.out.println("New value : " + value);
		addMailroomName();
		
		if(value < 10) {
			MailroomCode.sendKeys("MR0" + value);
		}else {
			MailroomCode.sendKeys("MR" + value);
		}
		
		clickSave();
		Waits.waitTime(3);
		if(!MailroomExistMsg.isEmpty()){
			String nV = MailroomCode.getAttribute("value");
			System.out.println(nV);
			//int newValue = Integer.parseInt(nV);
			String newValue = nV;
			//newValue++;
			CommonActions.doubleClick(MailroomCode);
			MailroomCode.sendKeys("MR0" + newValue);
			System.out.println(newValue);
			clickSave();
		}
		SiteActions.notification();
		assertEquals(RecipientsPageElements.SuccessMsgNotification.getText(), "Mailroom added successfully");
	    CommonActions.waitForElementToDisappear(MailroomAddedMsg);
		
	}
	
	public void addMailroomCode(String code) throws InterruptedException {
		
		MailroomCode.sendKeys("MR"+code);
		
		clickSave();
		Waits.waitTime(1);
		
		if(CommonActions.isClickable(SaveBtnMaialroom)) {
			
			CommonActions.doubleClick(MailroomCode);
			MailroomCode.sendKeys("MR" + code+1);
			clickSave();
			Waits.waitTime(1);
		}
		SiteActions.notification_CP();
		assertEquals(RecipientsPageElements.SuccessMsgNotification.getText(), "Mailroom added successfully");
	    CommonActions.waitForElementToDisappear(MailroomAddedMsg);
		
	}

	public void addUsers(String emailRole, String userRole) {
		
		CommonActions.waitForElement(UsersAddBtn);
		if (UsersAddBtn.isDisplayed()) {
			UsersAddBtn.click();
		}
		
		CommonActions.waitForElement(Name);
		if (Name.isDisplayed()) {
			Name.click();
			Name.sendKeys("ABCD");
		}
		
		CommonActions.waitForElement(Email);
		if (Email.isDisplayed()) {
			Email.click();
			Email.sendKeys(emailRole);
		}
		
		if(userRole == "Manager") {

			CommonActions.waitForElement(Role_ddl);
			if (Role_ddl.isDisplayed()) {
				Role_ddl.click();
				CommonActions.focusElementJs(driver, ListBox);
				Waits.waitTime(3);
				ListBox.sendKeys("Manager", Keys.ENTER);	

			}
		}
		
		if(userRole == "Operator") {

			CommonActions.waitForElement(Role_ddl);
			if (Role_ddl.isDisplayed()) {
				Role_ddl.click();
				CommonActions.focusElementJs(driver, ListBox);
				Waits.waitTime(3);
				ListBox.sendKeys("Operator", Keys.ENTER);	

			}

			CommonActions.waitForElement(Mailroom_ddl);
			if (Mailroom_ddl.isDisplayed()) {
				Mailroom_ddl.click();
				CommonActions.focusElementJs(driver, ListBox);
				Waits.waitTime(2);
				ListBox.sendKeys("Mailroom", Keys.ENTER);	
				CommonActions.tabKey();

			}
		}
		
		CommonActions.waitForElement(AddNewBtn);
		if(AddNewBtn.isEnabled()) {
			//AddNewBtn.click();
			AddNewBtn.click();
		}
		
		SiteActions.notification();
		assertEquals(RecipientsPageElements.SuccessMsgNotification.getText(), "User created successfully");
	    CommonActions.waitForElementToDisappear(UsersPageElements.NewUserAddedMsg);
	}

	public void enableReminderPreferences() throws InterruptedException {

		CommonActions.waitForElement(MondayBtn);
		if (!MondayBtn.isSelected()) {
			MondayBtn.click();
		}

		CommonActions.waitForElement(TuesdayBtn);
		if (!TuesdayBtn.isSelected()) {
			TuesdayBtn.click();
		}

		CommonActions.waitForElement(WednesdayBtn);
		if (!WednesdayBtn.isSelected()) {
			WednesdayBtn.click();
		}

		CommonActions.waitForElement(ThursdayBtn);
		if (!ThursdayBtn.isSelected()) {
			ThursdayBtn.click();
		}

		CommonActions.waitForElement(FridayBtn);
		if (!FridayBtn.isSelected()) {
			FridayBtn.click();
		}

		UsersPage.clickSave();
	}

	public void disableReminderPreferences() throws InterruptedException {

		CommonActions.waitForElement(MondayBtn);
		if (MondayBtn.getAttribute("aria-checked") == "true") {
			MondayBtn.click();
		}

		CommonActions.waitForElement(TuesdayBtn);
		if (TuesdayBtn.getAttribute("aria-checked") == "true") {
			TuesdayBtn.click();
		}

		CommonActions.waitForElement(WednesdayBtn);
		if (WednesdayBtn.getAttribute("aria-checked") == "true") {
			WednesdayBtn.click();
		}

		CommonActions.waitForElement(ThursdayBtn);
		if (ThursdayBtn.getAttribute("aria-checked") == "true") {
			ThursdayBtn.click();
		}

		CommonActions.waitForElement(FridayBtn);
		if (FridayBtn.getAttribute("aria-checked") == "true") {
			FridayBtn.click();
		}

		UsersPage.clickSave();
	}


	public void notificationPreferences() {

		CommonActions.waitForElement(EnableDelayedNotificationsSwitchBtn);
		if (EnableDelayedNotificationsSwitchBtn.getAttribute("aria-checked") == "false") {
			EnableDelayedNotificationsSwitchBtn.click();
		}

		CommonActions.waitForElement(NotifyEmailChkBox);
		if (NotifyEmailChkBox.getAttribute("aria-checked") == "false") {
			NotifyEmailChkBox.click();
		}

		CommonActions.waitForElement(RemindEmailChkBox);
		if (RemindEmailChkBox.getAttribute("aria-checked") == "false") {
			RemindEmailChkBox.click();
		}

		CommonActions.waitForElement(PickupEmailChkBox);
		if (PickupEmailChkBox.getAttribute("aria-checked") == "false") {
			PickupEmailChkBox.click();
		}

	} 

	public void recipientPreferences() {

		CommonActions.waitForElement(FirstLocation);
		FirstLocation.click();

		CommonActions.waitForElement(EnableCSVUploadSwitchBtn);
		if (EnableCSVUploadSwitchBtn.isEnabled()) {
			EnableCSVUploadSwitchBtn.click();
			
			SiteActions.notification();
			assertEquals(RecipientsPageElements.SuccessMsgNotification.getText(), "Recipient preferences updated successfully");
		    CommonActions.waitForElementToDisappear(RecipientPreferencesUpdatedMsg);
		}

		CommonActions.waitForElement(EnableReceiveConnectSwitchBtn);
		if (EnableReceiveConnectSwitchBtn.isEnabled()) {
			EnableReceiveConnectSwitchBtn.click();
			
			SiteActions.notification();
			assertEquals(RecipientsPageElements.SuccessMsgNotification.getText(), "Recipient preferences updated successfully");
		    CommonActions.waitForElementToDisappear(RecipientPreferencesUpdatedMsg);
		}
		
		CommonActions.waitForElement(EnableMailboxSwitchBtn);
		if (EnableMailboxSwitchBtn.isEnabled()) {
			CommonActions.focusElementJs(driver, EnableMailboxSwitchBtn);
			EnableMailboxSwitchBtn.click();
			
			SiteActions.notification();
			assertEquals(RecipientsPageElements.SuccessMsgNotification.getText(), "Recipient preferences updated successfully");
		    CommonActions.waitForElementToDisappear(RecipientPreferencesUpdatedMsg);
		}
	}

	public void receiveConnect() throws InterruptedException {

		CommonActions.waitForClickablility(LocationsTab, 15);
		LocationsTab.click();
		
		CommonActions.waitForElement(FirstLocation);
		FirstLocation.click();

		scanAndSend();
		forward();
		destroy();
		hold();
		
		CommonActions.waitForClickablility(SaveChangesBtn, 15);
		SaveChangesBtn.click();

		//Waits.waitTime(2);
		
		SiteActions.notification();
		assertEquals(RecipientsPageElements.SuccessMsgNotification.getText(), "Changes updated successfully");
	    CommonActions.waitForElementToDisappear(RecipientsPageElements.NotificationMsg);
		
	}

	public void scanAndSend() {

		CommonActions.waitForElement(ScanAndSendTab);
		if (ScanAndSendTab.isDisplayed()) {
			ScanAndSendTab.click();
		}

		CommonActions.waitForElement(EnableScanAndSendSwitchBtn);
		if (EnableScanAndSendSwitchBtn.getAttribute("aria-checked") == "false") {
			EnableScanAndSendSwitchBtn.click();
		}

		CommonActions.waitForElement(TitleSnapSend);
		if (TitleSnapSend.isEnabled()) {
			TitleSnapSend.click();
			TitleSnapSend.sendKeys("Scan and Send");
		}

		//Waits.waitTime(1);
		CommonActions.waitForElement(AddNewBtnSS);
		if (AddNewBtnSS.isDisplayed()) {
			AddNewBtnSS.click();
		}
		
		if(!DuplicateLabelsSS.isEmpty()) {

			DeleteBtnSnapSend.click();

			CommonActions.waitForElement(TitleSnapSend);
			TitleSnapSend.click();

			CommonActions.waitForElement(AddNewBtnSS);
			if (AddNewBtnSS.isDisplayed()) {
				AddNewBtnSS.click();
			}

		}

	}

	public void forward() {

		CommonActions.waitForElement(ForwardTab);
		if (ForwardTab.isDisplayed()) {
			ForwardTab.click();
		}

		CommonActions.waitForElement(EnableForwardSwithcBtn);
		if (EnableForwardSwithcBtn.getAttribute("aria-checked") == "false") {
			EnableForwardSwithcBtn.click();
		}

		CommonActions.waitForElement(TitleForward);
		if (TitleForward.isEnabled()) {
			TitleForward.click();
			TitleForward.sendKeys("Forward");
		}

		CommonActions.waitForElement(AddNewBtnFwd);
		if (AddNewBtnFwd.isDisplayed()) {
			AddNewBtnFwd.click();
		}
		
		if(!DuplicateLabelsFwd.isEmpty()) {

			DeleteBtnForward.click();

			CommonActions.waitForElement(TitleForward);
			TitleForward.click();

			CommonActions.waitForElement(AddNewBtnFwd);
			if (AddNewBtnFwd.isDisplayed()) {
				AddNewBtnFwd.click();
			}

		}
	}

	public void destroy() {

		CommonActions.waitForElement(DestroyTab);
		if (DestroyTab.isDisplayed()) {
			DestroyTab.click();
		}

		CommonActions.waitForElement(EnableDestroySwithcBtn);
		if (EnableDestroySwithcBtn.getAttribute("aria-checked") == "false") {
			EnableDestroySwithcBtn.click();
		}

		CommonActions.waitForElement(TitleDestroy);
		if (TitleDestroy.isEnabled()) {
			TitleDestroy.click();
			TitleDestroy.sendKeys("Destroy");
		}

		CommonActions.waitForElement(AddNewBtnDestroy);
		if (AddNewBtnDestroy.isDisplayed()) {
			AddNewBtnDestroy.click();
		}
		
		if(!DuplicateLabelsDestroy.isEmpty()) {

			DeleteBtnDestroy.click();

			CommonActions.waitForElement(TitleDestroy);
			TitleDestroy.click();

			CommonActions.waitForElement(AddNewBtnDestroy);
			if (AddNewBtnDestroy.isDisplayed()) {
				AddNewBtnDestroy.click();
			}

		}
	}

	public void hold() {

		CommonActions.waitForElement(HoldTab);
		if (HoldTab.isDisplayed()) {
			HoldTab.click();
		}

		CommonActions.waitForElement(EnableHoldSwithcBtn);
		if (EnableHoldSwithcBtn.getAttribute("aria-checked") == "false") {
			EnableHoldSwithcBtn.click();
		}

		CommonActions.waitForElement(TitleHold);
		if (TitleHold.isEnabled()) {
			TitleHold.click();
			TitleHold.sendKeys("Hold");
		}

		CommonActions.waitForElement(AddNewBtnHold);
		if (AddNewBtnHold.isDisplayed()) {
			AddNewBtnHold.click();
		}
		
		Waits.waitTime(3);
		
		if(!DuplicateLabelsHold.isEmpty()) {

			DeleteBtnHold.click();

			CommonActions.waitForElement(TitleHold);
			TitleHold.click();

			CommonActions.waitForElement(AddNewBtnHold);
			if (AddNewBtnHold.isDisplayed()) {
				AddNewBtnHold.click();
			}

		}
	}

	public void editLocation(String emailRole, String userRole) throws InterruptedException {

		Helper.waitForPageLoad(driver);
		LoginPage.clickExpandBtn();
		LocationsTab.click();
		
		CommonActions.waitForElement(FirstLocation);
		FirstLocation.click();
		
		/*
		clickMailroomAddBtn();
		//addMailroomName();
		addMailroomCode();
		*/
		
		//recipientPreferences();
		//receiveConnect();
		
		addUsers(emailRole, userRole);
		//editUsers();
	}
	
	public void clickSave() {
		
		CommonActions.waitForElement(SaveBtnMaialroom);
		if(SaveBtnMaialroom.isEnabled()) {
			SaveBtnMaialroom.click();
		}
	}
	
	public void emailTemplate() throws InterruptedException, AWTException, IOException {
		
		//rerouteTemplate();
		//notifyTemplate();
		//pickupTemplate();
		//remindTemplate();
		discardTemplate();
	}
	
	public void notifyTemplate() throws InterruptedException, AWTException, IOException {
		
		SettingsLocationsPage.enterLocationsDetail();
		clickNotifyTemplate();
		templateEditor();
		itemsInfo();
		uspsTracking_2();
		uploadLogo();
		UsersPage.clickSave();
		clickSendTestEmail();
		emailInfo();
		Waits.waitTime(2);		
	}
	
	public void remindTemplate() throws InterruptedException, AWTException, IOException {
		
		SettingsLocationsPage.enterLocationsDetail();
		clickRemindTemplate();
		templateEditor();
		itemsInfo();
		uspsTracking_2();
		uploadLogo();
		UsersPage.clickSave();
		clickSendTestEmail();
		emailInfo();
		Waits.waitTime(2);		
	}
	
	public void rerouteTemplate() throws InterruptedException, AWTException, IOException {

		SettingsLocationsPage.enterLocationsDetail();
		clickRerouteTemplate();
		templateEditor();
		itemsInfo();
		uspsTracking_2();
		uploadLogo();
		UsersPage.clickSave();
		clickSendTestEmail();
		emailInfo();
		Waits.waitTime(2);		
	}
	
	public void pickupTemplate() throws InterruptedException, AWTException, IOException {

		SettingsLocationsPage.enterLocationsDetail();
		clickPickupTemplate();
		templateEditor();
		selectCategory();
		itemsInfo();
		uspsTracking_2();
		uploadLogo();
		UsersPage.clickSave();
		clickSendTestEmail();
		emailInfo();
		Waits.waitTime(2);		
	}
	
	public void discardTemplate() throws InterruptedException, AWTException, IOException {

		SettingsLocationsPage.enterLocationsDetail();
		clickDiscardTemplate();
		templateEditor();
		itemsInfo();
		uspsTracking_2();
		uploadLogo();
		UsersPage.clickSave();
		clickSendTestEmail();
		emailInfo();
		Waits.waitTime(2);		
	}

	public void templateEditor() {
		
		CommonActions.waitForElement(SelectType);
		if(SelectType.isEnabled()) {
			SelectType.click();
		}
		
		Waits.waitTime(2);
		CommonActions.waitForElement(SelectTypeList);
		if(SelectTypeList.isDisplayed()) {
			SelectTypeList.sendKeys("Single Item", Keys.ENTER);
		}
		
		CommonActions.waitForElement(Subject);
		String subjectText = Subject.getText();
		System.out.println("Subject: " + subjectText);
		SubjectText = subjectText;
		
		CommonActions.waitForElement(Headline);
		String headlineText = Headline.getText();
		System.out.println("Headline: " + headlineText);
						
	}
	
	public void itemsInfo() {
		
		CommonActions.waitForElement(Headline_Response);
		String headline = Headline_Response.getText();
		System.out.println("Headline O/P: " + headline);
		HeadlineText = headline;
		
		CommonActions.waitForElement(Body_Response);
		String bodyText = Body_Response.getText();
		System.out.println(bodyText);
		MessageText = bodyText;
		
		Waits.waitTime(2);
		CommonActions.waitForElement(TrackingNoUSPS_1);
		String usps1 = TrackingNoUSPS_1.getText();
		System.out.println("Tracking # 1: " + usps1);
		
		Tracking1 = usps1;
		
	}
	
	public void uspsTracking_2() {

		String val = SelectType.getText();
		System.out.println("Select Type: " + val);

		if(SelectType.getText().equalsIgnoreCase("Multiple Items")) {

			CommonActions.waitForElement(TrackingNoUSPS_2);
			String usps2 = TrackingNoUSPS_2.getText();
			System.out.println("Tracking # 2: " + usps2);

		}

		else {
			System.out.println("Single Item");
		}
	}
	
	public void uploadLogo() throws InterruptedException, AWTException, IOException {
		
		CommonActions.moveToElement(ReplaceBtn);
		CommonActions.waitForElement(ReplaceBtn);
		//if(ReplaceBtn.isEnabled()) {
			//ReplaceBtn.click();
		//}
		
		SiteActions.uploadLogo();
		CommonActions.escKey();
	}
	
	public void emailInfo() {
		
		originalWindow = driver.getWindowHandle();
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		// Store the current window handle
		//String winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window

		driver.get("https://yopmail.com/en/wm");			
		//LoginElements.EmailForCode.sendKeys(GlobalVariables.AutoEmail);
		LoginElements.EmailForCode.sendKeys("automation1@yopmail.com");
		LoginElements.CheckEmailBtn.click();

		driver.switchTo().frame("ifinbox");
		LoginElements.PackageXReceiveEmail.click();
		driver.switchTo().defaultContent();

		//clickCapchaCheckbox();
		driver.switchTo().frame("ifmail");
				
		CommonActions.waitForElement(Email_Title);
		String emailTitle = Email_Title.getText();
		System.out.println("Email title: " + emailTitle);
		Assert.assertEquals(SubjectText, emailTitle);
		
		CommonActions.waitForElement(Email_Headline);
		String emailHeadline = Email_Headline.getText();
		System.out.println("Email headline: " + emailHeadline);
		Assert.assertEquals(HeadlineText, emailHeadline);
		
		CommonActions.waitForElement(Body_Email);
		String emailBody = Body_Email.getText();
		System.out.println("Email body: " + emailBody);
		Assert.assertEquals(MessageText, emailBody);
		
		CommonActions.waitForElement(Email_TrackingNoUSPS_1);
		String usps1Email = Email_TrackingNoUSPS_1.getText();
		System.out.println("Email Tracking # 1: " + usps1Email);
		Assert.assertEquals(Tracking1, usps1Email);
		
		driver.close();			

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){

			driver.switchTo().window(winHandle);
		}
		
		CommonActions.escKey();
		
	}
	
	public void clickSendTestEmail() {

		CommonActions.waitForElement(SendTestEmail);
		if(SendTestEmail.isEnabled()) {
			SendTestEmail.click();
		}
		
		SiteActions.notification();
		assertEquals(RecipientsPageElements.SuccessMsgNotification.getText(), "Email sent successfully");
	    CommonActions.waitForElementToDisappear(EmailSentMsg);
		
	}
	
	public void clickNotifyTemplate() {
		
		CommonActions.waitForElement(NotifyTemplate);
		if(NotifyTemplate.isEnabled()) {
			NotifyTemplate.click();
		}		
	}
	
	public void clickRemindTemplate() {

		CommonActions.waitForElement(RemindTemplate);
		if(RemindTemplate.isEnabled()) {
			RemindTemplate.click();
		}		
	}
	
	public void clickRerouteTemplate() {

		CommonActions.waitForElement(RerouteTemplate);
		if(RerouteTemplate.isEnabled()) {
			RerouteTemplate.click();
		}		
	}
	
	public void clickPickupTemplate() {

		CommonActions.waitForElement(PickupTemplate);
		if(PickupTemplate.isEnabled()) {
			PickupTemplate.click();
		}		
	}
	
	public void clickDiscardTemplate() {

		CommonActions.waitForElement(DiscardTemplate);
		if(DiscardTemplate.isEnabled()) {
			DiscardTemplate.click();
		}		
	}
	
	public void selectCategory() {
		
		CommonActions.waitForElement(SelectCategory);
		if(SelectCategory.isEnabled()) {
			SelectCategory.click();
		}
		
		//driver.switchTo().frame("__privateStripeMetricsController9230");
		Waits.waitTime(2);
		CommonActions.waitForElement(SelectCategory_ddl);
		if(SelectCategory_ddl.isDisplayed()) {
			SelectCategory_ddl.sendKeys("Self pickup", Keys.ENTER);
		}
		//driver.switchTo().defaultContent();
	}

}
