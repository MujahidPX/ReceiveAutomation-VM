package Recipients;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.maven.shared.utils.StringUtils;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import BaseClasses.ApacheCommonsCSV;

import java.awt.AWTException;
//import java.awt.Robot;
//import java.awt.Toolkit;
//import java.awt.datatransfer.StringSelection;
//import java.awt.event.KeyEvent;

import Login.LoginPage;
import SiteElements.SiteActions;
import SiteElements.ItemsPageElements.ItemsPageElements;
import SiteElements.RecipientsPageElements.RecipientsPageElements;
import SiteElements.UsersPageElements.UsersPageElements;
//import SiteElements.UsersPageElements.UsersPageElements;
import Users.UsersPage;
import Utilities.CommonActions;
import Utilities.ExcelFile;
import Utilities.GlobalVariables;
import Utilities.Helper;
import Utilities.Waits;


public class RecipientsPage extends RecipientsPageElements {

	private static WebDriver driver;
	private WebDriverWait wait;
	private CommonActions commonActions;
	private ExcelFile excelFile;
	private UsersPage usersPage;
	public String EmailRole;
	public static String UpdatedEmail;
	public String ImportedRecipientEmail;
	
	public RecipientsPage(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
		commonActions = new CommonActions(driver, wait);
		PageFactory.initElements(driver, this);
	}

	public void addNewRecipient(String autoRecepientUser, String emailRole, String locationSearched) throws InterruptedException {

		Helper.waitForPageLoad(driver);

		//LoginPage.clickExpandBtn();
		clickRecipientTab();
		//LoginPage.clickExpandBtn();
		clickAdd_ddl();
		clickRecipient();

		enterName(autoRecepientUser);
		UsersPage.enterEmail(emailRole);
		enterPhone();

		if(Locationddl.isEnabled()) {
			clickLocation();
			UsersPage.searchLocation(locationSearched);
			UsersPage.selectRadioBox();
			Apply();
		}

		enterUnit();		
		enterAddress();
		enterNotes();
		addAlternateName();
		CommonActions.scrollDown();
		addAlternateEmail();
		addAlternatePhone();
		NotificationPreference();
		assignToAGroup();
		UsersPage.clickSave();
		Helper.waitForPageLoad(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		CommonActions.waitForElement(SuccessMsgNotification);
		if(SuccessMsgNotification.isDisplayed()) {
			CommonActions.focusElementJs(driver, SuccessMsgNotification);
			String ExpectedText="Recipient added successfully";
			String ActualText = SuccessMsgNotification.getText();
			Assert.assertEquals(ActualText, ExpectedText);

		}

		CommonActions.waitForElementToDisappear(NewRecipientAddedMsg);
		System.out.println("New added recipient's email : " + emailRole);

		EmailRole = emailRole;
	}


	public void addNewGroup(String emailRole, String locationSearched) throws InterruptedException {

		Helper.waitForPageLoad(driver);

		LoginPage.clickExpandBtn();
		clickRecipientTab();
		LoginPage.clickExpandBtn();
		clickAdd_ddl();
		clickGroup();

		UsersPage.enterName();
		UsersPage.enterEmail(emailRole);
		CommonActions.tabKey();
		enterPhone();
//		clickLocation();
//		UsersPage.searchLocation(locationSearched);
//		UsersPage.selectRadioBox();
//		Apply();
		
		if(Locationddl.isEnabled()) {
			clickLocation();
			UsersPage.searchLocation(locationSearched);
			UsersPage.SearchClear.click();
			CommonActions.waitLogoInvisible();
			UsersPage.searchLocation(locationSearched);
			UsersPage.selectRadioBox();
			Apply();
		}
		
		enterUnit();		
		enterAddress();
		enterNotes();
		addAlternateGroupAlias();
		assignRecipients();
		UsersPage.clickSave();
		Helper.waitForPageLoad(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		CommonActions.waitForElement(SuccessMsgNotification);
		if(SuccessMsgNotification.isDisplayed()) {
			CommonActions.focusElementJs(driver, SuccessMsgNotification);
			assertEquals(SuccessMsgNotification.getText(), "Group added successfully");
		}

		CommonActions.waitForElementToDisappear(GroupAddedMsg);
		System.out.println("New added group's email : " + emailRole);

		EmailRole = emailRole;
	}

	public void assignRecipients() throws InterruptedException {

		CommonActions.waitForElement(AssignRecipientsBtn);
		AssignRecipientsBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		searchRecipients();

	}

	public void searchRecipients() throws InterruptedException {
		Waits.waitTime(4);

		CommonActions.waitForLoad(driver);
		CommonActions.waitLogoInvisible();
		CommonActions.waitForElement(SearchRecipientsIcon);

		if(SearchRecipientsIcon.isEnabled()) {
			SearchRecipientsIcon.click();
		}
		Waits.waitTime(1);
		CommonActions.waitForElement(SearchName);
		if(SearchName.isEnabled()) {
			SearchName.sendKeys(GlobalVariables.autoRecepientUser);
		}
		Waits.waitTime(1);
		CommonActions.waitForPageLoad();
		if(SearchBtn.isEnabled()) {
			SearchBtn.click();
		}
		Waits.waitTime(3);
		//CommonActions.waitLogoInvisible(LogoInRecipient);

		CommonActions.waitForElement(RecipientCheckBox);
		if(RecipientCheckBox.isDisplayed() && RecipientCheckBox.isEnabled()) {
			if(!RecipientCheckBox.isSelected()) {
				RecipientCheckBox.click();
			}
			Waits.waitTime(1);
			CommonActions.waitForPageLoad();
		}


		CommonActions.waitForElement(AssignRecipientsSaveBtn);
		if(AssignRecipientsSaveBtn.isDisplayed()) {
			AssignRecipientsSaveBtn.click();
		}
		Waits.waitTime(2);
		CommonActions.waitForLoad(driver);
	}
	
	public void NotificationPreference() {
		
		Waits.waitTime(3);
		CommonActions.waitForElement(NotifyEmailChkBox);
		if(!NotifyEmailChkBox.isSelected()) {
			NotifyEmailChkBox.click();
			Waits.waitTime(1);
		}
		NotifyEmailChkBox.click();

		
		Waits.waitTime(3);
		CommonActions.waitForElement(RemindEmailChkBox);
		if(!RemindEmailChkBox.isSelected()) {
			RemindEmailChkBox.click();
		}
		
		Waits.waitTime(3);
		CommonActions.waitForElement(PickupEmailChkBox);
		if(!PickupEmailChkBox.isSelected()) {
			PickupEmailChkBox.click();
		}

	}

	public void clickRecipientTab() {

		CommonActions.waitForElement(RecepientsTab);
		if(RecepientsTab.isEnabled()) {
			RecepientsTab.click();
		}
	}


	public void create_ddl() {

		CommonActions.waitForElement(CreateBtn);
		if(CreateBtn.isEnabled()) {
			CreateBtn.click();
		}
	}

	public void clickAdd_ddl() {

		CommonActions.waitForElement(Add_ddl);
		if(Add_ddl.isEnabled()) {
			Add_ddl.click();
		}
	}

	public void clickRecipient() {

		CommonActions.waitForElement(Recepient);
		if(Recepient.isEnabled()) {
			Recepient.click();
		}
	}

	public void clickGroup() {

		CommonActions.waitForElement(Group);
		if(Group.isEnabled()) {
			Group.click();
		}
	}


	public void Apply() {

		CommonActions.waitForElement(Apply);
		Apply.click();
		CommonActions.waitLogoInvisible();
	}

	public void enterName(String autoRecepientUser) {

		CommonActions.waitForElement(Name);
		if(Name.isEnabled()) {
			Name.sendKeys(autoRecepientUser);
		}
	}

	public void enterPhone() {
		
		//CommonActions.focusElementJs(driver, Phone);
		CommonActions.waitForElement(Phone);
		if(Phone.isEnabled()) {
			Phone.click();
			Phone.sendKeys(Keys.BACK_SPACE, "923331234568", Keys.ENTER);
		}
	}

	public void clickLocation() {

		CommonActions.waitForElement(Locationddl);
		if(Locationddl.isDisplayed()) {
			Locationddl.click();
		}
	}

	public void enterUnit() {

		CommonActions.waitForElement(Unit);
		if(Unit.isEnabled()) {
			Unit.sendKeys("10");
		}
	}

	public void enterAddress() {

		CommonActions.waitForElement(Address);
		if(Address.isEnabled()) {
			Address.sendKeys("ABCD");
		}
	}

	public void enterNotes() {

		CommonActions.waitForElement(Notes);
		if(Notes.isEnabled()) {
			Notes.sendKeys("Testing ");
		}
	}

	public void clickAddBtn() {

		CommonActions.waitForElement(AddBtn);
		AddBtn.click();

	}

	public void addAlternateName() {

		CommonActions.waitForElement(AddAlternateddl);
		if(AddAlternateddl.isDisplayed()) {
			AddAlternateddl.click();

			CommonActions.waitForElement(NameBtn);
			if(NameBtn.isDisplayed()) {
				NameBtn.click();
			}
			if(AlternateName.isDisplayed()) {
				AlternateName.sendKeys("Auto users 123");
			}

			clickAddBtn();
		}

	}

	public void addAlternateEmail() {

		CommonActions.waitForElement(AddAlternateddl);
		if(AddAlternateddl.isDisplayed()) {
			AddAlternateddl.click();
		}

		CommonActions.waitForElement(EmailBtn);
		if(EmailBtn.isDisplayed()) {
			EmailBtn.click();
		}
		if(AlternateEmail.isDisplayed()) {
			AlternateEmail.sendKeys("amp123@yopmail.com");
		}

		clickAddBtn();
	}

	public void addAlternatePhone() {

		CommonActions.waitForElement(AddAlternateddl);
		if(AddAlternateddl.isDisplayed()) {
			AddAlternateddl.click();
		}
		CommonActions.waitForElement(PhoneBtn);
		if(PhoneBtn.isDisplayed()) {
			PhoneBtn.click();
		}
		if(AlternatePhone.isDisplayed()) {
			//Waits.waitTime(1);
			AlternatePhone.sendKeys(Keys.BACK_SPACE, "12345678913", Keys.ENTER);
			//Waits.waitTime(1);
			AlternatePhone.sendKeys(Keys.ENTER);
			Helper.waitForPageLoad(driver);
			AlternatePhone.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE);
			Helper.waitForPageLoad(driver);
		}

	}

	public void addAlternateGroupAlias() {

		CommonActions.waitForElement(AlternateGroupAlias);
		if(AlternateGroupAlias.isDisplayed()) {
			AlternateGroupAlias.sendKeys("ABC User 2");
		}

		clickAddBtn();
	}

	public void uploadCSV(String locationSearched, String file, String uploadPreference) throws InterruptedException, IOException, AWTException {
		Helper.waitForPageLoad(driver);

		//LoginPage.clickExpandBtn();
		clickRecipientTab();
		//LoginPage.clickExpandBtn();

		clickAdd_ddl();
		clickUploadCSV();

		clickUploadNewCSV();
		//selectLocation(locationSearched);

		if(file == "CorrectMerge") 
		{
			attachFile();
		}
		if(file == "CorrectOverwrite") 
		{
			attachFileOverwrite();
		}
		if(file == "InvalidEmail") 
		{
			attachFileInvalidEmail();
		}
		if(file == "DuplicateEmail") 
		{
			attachFileDuplicateEmail();
		}
		if(file == "NameEmailMissing") 
		{
			attachFileNameEmailMissing();
		}
		if(file == "EmailMissing") 
		{
			attachFileEmailMissing();
		}
		if(file == "InvalidAddress") 
		{
			attachFileAddress();
		}
		if(file == "RecepientCSV") 
		{
			attachFileRecipientCSV();
		}
		if(file == "10000Recipients") 
		{
			attachFile10000Recipients();
		}

		clickUpload();
		mapItems();
		Waits.waitTime(2);
		mapItems();
		clickNext();
		getEmailImportedRecipients();
		try 
		{
			clickNext();
		}
		catch(Exception e) {
			review();
		}

		if(uploadPreference == "Merge") {

			selectMerge();
		}
		if(uploadPreference == "Overwrite") {

			selectOverwrite();
		}

		clickContinue();
		Waits.waitTime(3);
		csvUploadedAssertion();

		refreshData();
//		clickRecipientTab();
//		searchImportedRecipientEmail();

	}

	public void uploadCSV_UnitGroup(String locationSearched, String file, String uploadPreference) throws InterruptedException, IOException, AWTException {
		Helper.waitForPageLoad(driver);

		clickRecipientTab();

		clickAdd_ddl();
		clickUploadCSV();

		clickUploadNewCSV();
		
		if(file == "MapUnitGroup") 
		{
			attachFileUnitGroup();
		}

		clickUpload();
		mapUnitsGroups();
		Waits.waitTime(3);
		clickNext();
		try 
		{
			clickNext();
		}
		catch(Exception e) {
			review();
		}

		if(uploadPreference == "Merge") {

			selectMerge();
		}
		if(uploadPreference == "Overwrite") {

			selectOverwrite();
		}

		clickContinue();
		Waits.waitTime(3);
		unitGroupCSVUploadedAssertion();
		Waits.waitTime(4);
		CloseBtnUploadCSV.click();
		Waits.waitTime(1);
		//refreshData();

	}

	public void uploadCSV_EmptyAlternateFields(String locationSearched, String file, String uploadPreference) throws InterruptedException, IOException, AWTException {
		Helper.waitForPageLoad(driver);

		clickRecipientTab();

		clickAdd_ddl();
		clickUploadCSV();

		clickUploadNewCSV();
		
		if(file == "EmptyAlternateFields") 
		{
			attachFileEmptyAlternateFields();
		}

		clickUpload();
		mapAltGroupNameGroupAlias();
		for (int i=0; i<5; i++) 
		{
			mapItems();
		}
		Waits.waitTime(3);
		clickNext();
		
		getEmailImportedRecipients();
		reviewEmptyAlternateFields();

		if(uploadPreference == "Merge") {

			selectMerge();
		}
		if(uploadPreference == "Overwrite") {

			selectOverwrite();
		}

		clickContinue();
		Waits.waitTime(3);
		csvUploadedAssertion();
		
		refreshData();

	}
	
	public void uploadCSV_AlternateFields(String locationSearched, String file, String uploadPreference) throws InterruptedException, IOException, AWTException {
		Helper.waitForPageLoad(driver);

		clickRecipientTab();

		clickAdd_ddl();
		clickUploadCSV();

		clickUploadNewCSV();
		
		if(file == "AlternateFields") 
		{
			attachFileAlternateFields();	
		}
		
		if(file == "AlternateEmailDuplicate") 
		{
			attachFileAlternateEmailDuplicate();
		}
		
		if(file == "AlternateFieldsDuplicate") 
		{
			attachFileAlternateFieldsDuplicate();
		}

		clickUpload();
		for (int i=0; i<=5; i++) 
		{
			mapItems();
		}
		Waits.waitTime(3);
		clickNext();
		getEmailImportedRecipients();
		try 
		{
			clickNext();
		}
		catch(Exception e) {
			review();
		}

		if(uploadPreference == "Merge") {

			selectMerge();
		}
		if(uploadPreference == "Overwrite") {

			selectOverwrite();
		}

		clickContinue();
		Waits.waitTime(3);
		csvUploadedAssertion();
		
		refreshData();

	}
	
	public void uploadCSVNameEmailMissing(String locationSearched, String file, String uploadPreference) throws InterruptedException, IOException, AWTException {
		Helper.waitForPageLoad(driver);

		//LoginPage.clickExpandBtn();
		clickRecipientTab();
		//LoginPage.clickExpandBtn();

		clickAdd_ddl();
		clickUploadCSV();

		clickUploadNewCSV();
		//selectLocation(locationSearched);

		if(file == "CorrectMerge") 
		{
			attachFile();
		}
		if(file == "CorrectOverwrite") 
		{
			attachFileOverwrite();
		}
		if(file == "InvalidEmail") 
		{
			attachFileInvalidEmail();
		}
		if(file == "DuplicateEmail") 
		{
			attachFileDuplicateEmail();
		}
		if(file == "NameEmailMissing") 
		{
			attachFileNameEmailMissing();
		}
		if(file == "EmailMissing") 
		{
			attachFileEmailMissing();
		}
		if(file == "InvalidAddress") 
		{
			attachFileAddress();
		}
		if(file == "RecepientCSV") 
		{
			attachFileRecipientCSV();
		}

		clickUpload();
		mapItems();
		mapItems();
		clickNext();
		getEmailImportedRecipients();

		review();

		if(uploadPreference == "Merge") {

			selectMerge();
		}
		if(uploadPreference == "Overwrite") {

			selectOverwrite();
		}

		clickContinue();
		
		Waits.waitTime(3);
		csvUploadedAssertion();

		refreshData();

	}

	public void uploadCSV30MinWait(String locationSearched, String file, String uploadPreference) throws InterruptedException, IOException, AWTException {
		Helper.waitForPageLoad(driver);

		//LoginPage.clickExpandBtn();
		clickRecipientTab();
		//LoginPage.clickExpandBtn();

		clickAdd_ddl();
		clickUploadCSV();

		clickUploadNewCSV();
		//selectLocation(locationSearched);

		if(file == "CorrectMerge") 
		{
			attachFile();
		}
		if(file == "CorrectOverwrite") 
		{
			attachFileOverwrite();
		}
		if(file == "InvalidEmail") 
		{
			attachFileInvalidEmail();
		}
		if(file == "DuplicateEmail") 
		{
			attachFileDuplicateEmail();
		}
		if(file == "NameEmailMissing") 
		{
			attachFileNameEmailMissing();
		}
		if(file == "EmailMissing") 
		{
			attachFileEmailMissing();
		}
		if(file == "InvalidAddress") 
		{
			attachFileAddress();
		}
		if(file == "RecepientCSV") 
		{
			attachFileRecipientCSV();
		}

		clickUpload();
		mapItems();
		mapItems();
		clickNext();
		getEmailImportedRecipients();
		
		try 
		{
			TimeUnit.MINUTES.sleep(30);
			clickNext();
		}
		catch(Exception e) {
			review();
		}

		if(uploadPreference == "Merge") {

			selectMerge();
		}
		if(uploadPreference == "Overwrite") {

			selectOverwrite();
		}

		clickContinue();
		
		Waits.waitTime(3);
		csvUploadedAssertion();

		refreshData();

	}

	public void uploadCSVMissingData(String locationSearched, String file, String uploadPreference) throws InterruptedException, IOException, AWTException {
		Helper.waitForPageLoad(driver);

		//LoginPage.clickExpandBtn();
		clickRecipientTab();
		//LoginPage.clickExpandBtn();
		clickAdd_ddl();
		clickUploadCSV();

		clickUploadNewCSV();
		//selectLocation(locationSearched);

		if(file == "Correct") 
		{
			attachFile();
		}
		if(file == "InvalidEmail") 
		{
			attachFileInvalidEmail();
		}
		if(file == "DuplicateEmail") 
		{
			attachFileDuplicateEmail();
		}
		if(file == "NameEmailMissing") 
		{
			attachFileNameEmailMissing();
		}
		if(file == "EmailMissing") 
		{
			attachFileEmailMissing();
		}
		if(file == "InvalidAddress") 
		{
			attachFileAddress();
		}
		clickUpload();
		mapItems();
		mapItems();
		clickNext();
		getEmailImportedRecipients();
		
		reviewMissingData();

		if(uploadPreference == "Merge") {

			selectMerge();
		}
		if(uploadPreference == "Overwrite") {

			selectOverwrite();
		}

		clickContinue();
		//CommonActions.waitLogoInvisible(LogoInRecipient);
		csvUploadedAssertion();

		refreshData();
		Waits.waitTime(1);

	}

	public void downloadFailedFileAndPath() {

		try {
			if(FailedCSVFile.isDisplayed()) {
				downloadFailedFile();
				downloadedFilePath();
			}
		}
		catch(Exception e)
		{

		}
	}

	public void chooseAndSearchLocation(String locationSearched) throws InterruptedException {

		UsersPage.clickExpandBtn();
		clickRecipientTab();
		UsersPage.clickExpandBtn();
		clickChooseLocation();
		searchLocationCSV(locationSearched);
		UsersPage.selectRadioBox();
		Apply();
	}
	
	public void chooseAndSearchLocationItems(String locationSearched) throws InterruptedException {

		clickChooseLocation();
		searchLocationCSV(locationSearched);
		UsersPage.selectRadioBox();
		Apply();
	}

	public void updateRecipientByCSV(String locationSearched) throws InterruptedException {

		chooseAndSearchLocation(locationSearched);

	}


	public void editCSV() throws InterruptedException {

		CommonActions.waitForElement(EditRecord);
		EditRecord.click();
		CommonActions.waitForElement(EditRecipientName);
		EditRecipientName.click();
		EditRecipientName.sendKeys("1", Keys.BACK_SPACE);
		UsersPage.clickSave();

		CommonActions.waitForElement(SuccessMsgNotification);
		if(SuccessMsgNotification.isDisplayed()) 
		{
			CommonActions.focusElementJs(driver, SuccessMsgNotification);
			assertEquals(SuccessMsgNotification.getText(), "Recipient updated successfully");
		}

		CommonActions.waitForElementToDisappear(RecipientUpdatedMsg);
	}

	public static void searchLocationCSV(String locationSearched) throws InterruptedException {

		CommonActions.waitForElement(UsersPage.SearchLocation);
		if(UsersPage.SearchLocation.isEnabled()) {
			UsersPage.SearchLocation.click();
			CommonActions.waitLogoInvisible();
			UsersPage.SearchLocation.sendKeys(locationSearched, Keys.ENTER);
			
			CommonActions.waitLogoInvisible();
			
		}		
	}

	public void clickUploadCSV() {

		CommonActions.waitForElement(UploadCSVBtn);
		if(UploadCSVBtn.isDisplayed()) {
			UploadCSVBtn.click();
		}
	}

	public void clickUploadNewCSV() throws InterruptedException {

		CommonActions.waitLogoInvisible();				
		CommonActions.waitForElement(UploadNewCSV);
		Waits.waitTime(2);

		if(UploadNewCSV.isEnabled()) {
			//CommonActions.focusElementJs(driver, UploadNewCSV);
			UploadNewCSV.click();
		}				

	}

	public void selectLocation(String locationSearched) throws InterruptedException {

		Thread.sleep(1000);
		Thread.sleep(1000);
		CommonActions.waitForElement(LocationsList);
		LocationsList.sendKeys("RecipientCSV", Keys.ENTER);
		Thread.sleep(1000);
		
	}

	public void attachFile() throws InterruptedException, IOException, AWTException {

		Waits.waitTime(2);
		CommonActions.focusElementJs(driver, DropYourFileHere);
		CommonActions.waitForElement(DropYourFileHere);
		if(DropYourFileHere.isDisplayed()) {
			DropYourFileHere.click();

			SiteActions.uploadAndAttachFile();						
			Thread.sleep(1000);
		}		
	}

	public void attachFileOverwrite() throws InterruptedException, IOException, AWTException {

		Waits.waitTime(2);
		CommonActions.focusElementJs(driver, DropYourFileHere);
		CommonActions.waitForElement(DropYourFileHere);
		if(DropYourFileHere.isDisplayed()) {
			DropYourFileHere.click();

			SiteActions.uploadAndAttachFileOverwrite();						
			Thread.sleep(1000);
		}		
	}
	
	public void attachFileAddress() throws InterruptedException, IOException, AWTException {

		Waits.waitTime(2);
		CommonActions.focusElementJs(driver, DropYourFileHere);
		CommonActions.waitForElement(DropYourFileHere);
		if(DropYourFileHere.isDisplayed()) {
			DropYourFileHere.click();

			SiteActions.uploadAndAttachFile_address();						
			Thread.sleep(1000);
		}		
	}

	public void attachFileInvalidEmail() throws InterruptedException, IOException, AWTException {

		Waits.waitTime(2);
		CommonActions.focusElementJs(driver, DropYourFileHere);
		CommonActions.waitForElement(DropYourFileHere);
		if(DropYourFileHere.isDisplayed()) {
			DropYourFileHere.click();

			SiteActions.uploadAndAttachFile_InvalidEmail();						
			Thread.sleep(1000);
		}		
	}

	public void attachFileDuplicateEmail() throws InterruptedException, IOException, AWTException {

		Waits.waitTime(2);
		CommonActions.focusElementJs(driver, DropYourFileHere);
		//CommonActions.waitForElement(DropYourFileHere);
		//if(DropYourFileHere.isDisplayed()) {
			//DropYourFileHere.click();
			DropYourFileHere.sendKeys("C:\\Users\\QA.User\\Desktop\\CSV_All_Files\\UploadCSV-DuplicateEmail.csv");
			
			SiteActions.uploadAndAttachFile_DuplicateEmail();						
			Thread.sleep(1000);
		//}		
	}

	public void attachFileEmailMissing() throws InterruptedException, IOException, AWTException {

		Waits.waitTime(2);
		CommonActions.focusElementJs(driver, DropYourFileHere);
		CommonActions.waitForElement(DropYourFileHere);
		if(DropYourFileHere.isDisplayed()) {
			DropYourFileHere.click();

			SiteActions.uploadAndAttachFile_EmailMissing();						
			Thread.sleep(1000);
		}		
	}

	public void attachFileNameEmailMissing() throws InterruptedException, IOException, AWTException {

		//Thread.sleep(1000);
		Waits.waitTime(2);
		CommonActions.focusElementJs(driver, DropYourFileHere);
		CommonActions.waitForElement(DropYourFileHere);
		if(DropYourFileHere.isDisplayed()) {
			DropYourFileHere.click();

			SiteActions.uploadAndAttachFile_NameEmailMissing();						
			Thread.sleep(1000);
		}		
	}

	public void attachFileRecipientCSV() throws InterruptedException, IOException, AWTException {

		Waits.waitTime(2);
		CommonActions.focusElementJs(driver, DropYourFileHere);
		CommonActions.waitForElement(DropYourFileHere);
		if(DropYourFileHere.isDisplayed()) {
			DropYourFileHere.click();

			SiteActions.uploadAndAttachFile_RecipientCSV();						
			Thread.sleep(1000);
		}		
	}
	
	public void attachFileUnitGroup() throws InterruptedException, IOException, AWTException {

		Waits.waitTime(2);
		CommonActions.focusElementJs(driver, DropYourFileHere);
		CommonActions.waitForElement(DropYourFileHere);
		if(DropYourFileHere.isDisplayed()) {
			DropYourFileHere.click();

			SiteActions.uploadFile_UnitGroup();						
			Thread.sleep(1000);
		}		
	}
	
	public void attachFileEmptyAlternateFields() throws InterruptedException, IOException, AWTException {

		Waits.waitTime(2);
		CommonActions.focusElementJs(driver, DropYourFileHere);
		CommonActions.waitForElement(DropYourFileHere);
		if(DropYourFileHere.isDisplayed()) {
			DropYourFileHere.click();

			SiteActions.uploadFile_EmptyAlternateFields();						
			Thread.sleep(1000);
		}		
	}
	
	public void attachFileAlternateFields() throws InterruptedException, IOException, AWTException {

		Waits.waitTime(2);
		CommonActions.focusElementJs(driver, DropYourFileHere);
		CommonActions.waitForElement(DropYourFileHere);
		if(DropYourFileHere.isDisplayed()) {
			DropYourFileHere.click();

			SiteActions.uploadFile_AlternateFields();						
			Thread.sleep(1000);
		}		
	}
	
	public void attachFileAlternateFieldsDuplicate() throws InterruptedException, IOException, AWTException {

		Waits.waitTime(2);
		CommonActions.focusElementJs(driver, DropYourFileHere);
		CommonActions.waitForElement(DropYourFileHere);
		if(DropYourFileHere.isDisplayed()) {
			DropYourFileHere.click();

			SiteActions.uploadFile_AlternateFieldsDuplicate();						
			Thread.sleep(1000);
		}		
	}
	
	public void attachFileAlternateEmailDuplicate() throws InterruptedException, IOException, AWTException {

		Waits.waitTime(2);
		CommonActions.focusElementJs(driver, DropYourFileHere);
		CommonActions.waitForElement(DropYourFileHere);
		if(DropYourFileHere.isDisplayed()) {
			DropYourFileHere.click();

			SiteActions.uploadFile_AlternateEmailDuplicate();						
			Thread.sleep(1000);
		}		
	}
	
	
	public void attachFile10000Recipients() throws InterruptedException, IOException, AWTException {

		Waits.waitTime(2);
		CommonActions.focusElementJs(driver, DropYourFileHere);
		CommonActions.waitForElement(DropYourFileHere);
		if(DropYourFileHere.isDisplayed()) {
			DropYourFileHere.click();

			SiteActions.uploadAndAttachFile10000Recipients();						
			Thread.sleep(1000);
		}		
	}

	public void clickUpload() throws InterruptedException {

		CommonActions.waitForElement(UploadBtn);
		//CommonActions.focusElementJs(driver, UploadBtn);
		
		if(UploadBtn.isEnabled()) {
			UploadBtn.click();				
		}

		CommonActions.waitLogoInvisible();

	}

	public void mapItems() {

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		List<WebElement> UploadedItem = driver.findElements(By.xpath("//div[@aria-haspopup='listbox']/following::span[text()='Select']/preceding::div[@class='inner-text text-capitalize'][1]"));				    			
		if(!UploadedItem.isEmpty()) 
		{				
			String item1 = UploadedItems.getText();
			String cap = item1.substring(0, 1).toUpperCase() + item1.substring(1);
			System.out.println(cap);

			DBSelects.click();

			WebElement elementList = driver.findElement(By.xpath("//*[@role='listbox']"));
			CommonActions.waitForElement(elementList);
			CommonActions.focusElementJs(driver, elementList);

			elementList.sendKeys(cap);
			
				WebElement element = driver.findElement(By.xpath("//*[@role='listbox']//p[text()='"+item1+"']"));
				
				/*
				 List<WebElement> listOfElements = driver.findElements(By.xpath("//*[@role='listbox']//p[text()='"+item1+"']"));
				    int numberOfElementsFound = listOfElements.size();
				    if(numberOfElementsFound == 1)
				    {
				    	WebElement element = driver.findElement(By.xpath("//*[@role='listbox']//p[text()='"+item1+"']"));
				    	//listOfElements.click();
				    //}
				//element1.sendKeys(cap);
				//CommonActions.scrollIntoView(element);

				Waits.waitTime(1);
				CommonActions.focusElementJs(driver, element);
				element.click();
		}
				    if(numberOfElementsFound == 0)
				    {
				    	Waits.waitTime(1);
				    	UploadedItems.click();
				    }
				    */
				
				Waits.waitTime(1);
				CommonActions.focusElementJs(driver, element);
				element.click();

		}
	}
	
	public void mapUnitsGroups() {

		Waits.waitTime(2);
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
		//List<WebElement> UploadedItem = driver.findElements(By.xpath("//div[@aria-haspopup='listbox']/following::span[text()='Select']/preceding::div[@class='inner-text text-capitalize'][1]"));				    			
		//if(!UploadedItem.isEmpty()) 
		//{				
			//String item1 = UploadedItems.getText();
			//String cap = item1.substring(0, 1).toUpperCase() + item1.substring(1);
			//System.out.println(cap);

			//DBSelects.click();

			//div[text()='unit']/following::div[1]
			WebElement elementList = driver.findElement(By.xpath("//div[text()='unit']/following::div[@aria-haspopup][1]"));
			CommonActions.waitForElement(elementList);
			CommonActions.focusElementJs(driver, elementList);
			elementList.click();
			//element1.sendKeys(cap);
			WebElement element = driver.findElement(By.xpath("//p[text()='Group']"));
			//element1.sendKeys(cap);
			//CommonActions.scrollIntoView(element);
			
			Waits.waitTime(1);
			CommonActions.focusElementJs(driver, element);
			element.click();

		//}
	}

	public void mapAltGroupNameGroupAlias() {

		Waits.waitTime(2);
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
		List<WebElement> UploadedItem = driver.findElements(By.xpath("//span[text()='Group Alias']"));
		if(!UploadedItem.isEmpty()) 
		{
			System.out.println("Group already selected");
		}
		else 
		{				
			//String item1 = UploadedItems.getText();
			//String cap = item1.substring(0, 1).toUpperCase() + item1.substring(1);
			//System.out.println(cap);

			//DBSelects.click();

			//div[text()='unit']/following::div[1]
			WebElement elementList = driver.findElement(By.xpath("//div[text()='alternate group name']/following::span[text()='Select'][1]"));
			CommonActions.waitForElement(elementList);
			CommonActions.focusElementJs(driver, elementList);
			elementList.click();
			//element1.sendKeys(cap);
			WebElement element = driver.findElement(By.xpath("//p[text()='Group Alias']"));
			//element1.sendKeys(cap);
			//CommonActions.scrollIntoView(element);
			
			Waits.waitTime(1);
			CommonActions.focusElementJs(driver, element);
			element.click();

		}
	}
	
	public void clickNext() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		CommonActions.waitForElement(NextBtn);
		CommonActions.focusElementJs(driver, NextBtn);
		if(NextBtn.isDisplayed()) {
			NextBtn.click();	
			Thread.sleep(1000);
		}
	}

	public void getEmailImportedRecipients() {

		String importedRecipientEmail = EmialImportedRecipient.getText();
		System.out.println("Imported Recipient Email: " + importedRecipientEmail);
		
		ImportedRecipientEmail = importedRecipientEmail;
	}
	
	public void review() {

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		FixnowBtn.click();
		try {
			if(NameReview.isDisplayed()) 
			{
				NameReview.sendKeys("Mansoor");
			}
		}
		catch(NoSuchElementException e){

		}
		try {
			Waits.waitTime(1);
			if(EmailReview.isDisplayed()) 
			{
				EmailReview.click();
				EmailReview.sendKeys("Man123@yopmail.com");
			}
		}
		catch(NoSuchElementException e) {

		}

		CommonActions.waitForElement(ConfirmBtn);
		ConfirmBtn.click();
	}
	
	public void reviewEmptyAlternateFields() {

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		FixnowBtn.click();
		try {
			if(NameReviewCSV.isDisplayed()) 
			{
				NameReviewCSV.sendKeys("User D");
			}
		}
		catch(NoSuchElementException e){

		}
		try {
			Waits.waitTime(1);
			if(EmailReviewCSV.isDisplayed()) 
			{
				EmailReviewCSV.click();
				EmailReviewCSV.sendKeys("test3@packagex.xyz");
			}
		}
		catch(NoSuchElementException e) {

		}

		CommonActions.waitForElement(ConfirmBtn);
		ConfirmBtn.click();
	}

	public void reviewMissingData() {

		FixnowBtn.click();
		try {
			if(Name.isDisplayed()) 
			{
				Name.sendKeys("Mansoor");
			}
		}
		catch(NoSuchElementException e){

		}
		try {
			if(Email.isDisplayed()) 
			{
				Email.sendKeys("");
			}
		}
		catch(NoSuchElementException e) {

		}

		CommonActions.waitForElement(ConfirmBtn);
		ConfirmBtn.click();
	}

	public void selectMerge() throws InterruptedException {

		CommonActions.waitForElement(MergeRdBtn);
		if(MergeRdBtn.isEnabled()) {
			MergeRdBtn.click();	
			Thread.sleep(1000);
		}
	}

	public void selectOverwrite() {

		CommonActions.waitForElement(OverwriteRdBtn);
		if(OverwriteRdBtn.isEnabled()) {
			OverwriteRdBtn.click();			
		}
	}

	public void clickContinue() throws InterruptedException {

		CommonActions.waitForElement(ContinueBtn);
		CommonActions.focusElementJs(driver, ContinueBtn);
		if(ContinueBtn.isEnabled()) {
			ContinueBtn.click();	
			Waits.waitTime(2);
		}
	}

	public void csvUploadedAssertion() {

		CommonActions.waitForElement(SuccessMsgNotification);
		if(SuccessMsgNotification.isDisplayed()) {
			CommonActions.focusElementJs(driver, SuccessMsgNotification);
			assertEquals(SuccessMsgNotification.getText(), "CSV successfully uploaded.");
		}

		CommonActions.waitForElementToDisappear(CSVUploadedMsg);
	}
	
	public void unitGroupCSVUploadedAssertion() {

		CommonActions.waitForElement(SuccessMsgNotification);
		if(SuccessMsgNotification.isDisplayed()) {
			CommonActions.focusElementJs(driver, SuccessMsgNotification);
			assertEquals(SuccessMsgNotification.getText(), "Duplicate column headers found for: (unit). Please correct the column headers and mapping of the CSV file uploaded.");
		}

		CommonActions.waitForElementToDisappear(NotificationMsg);
	}

	public void refreshData() {

		CommonActions.waitForElement(RefreshDataBtn);
		if(RefreshDataBtn.isEnabled()) {
			RefreshDataBtn.click();
		}

	}

	public void clickChooseLocation() {

		CommonActions.waitForElement(ChooseLocation);
		if(ChooseLocation.isEnabled()) {
			ChooseLocation.click();
		}

	}

	public static void downloadFailedFile() throws InterruptedException {
		
		if(FailedCSVFile1.size()>0) 
		{
			if(FailedCSVFile.isDisplayed()) {
				FailedCSVFile.click();
			}
			
		}
	}

	public void downloadedFilePath() throws IOException, InterruptedException {

		Waits.waitTime(3);
		String DFPtext = SuccessMsgNotification.getText();

		System.out.println(DFPtext);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		// get everything after first dash
		String DFPNo = DFPtext.substring(DFPtext.indexOf('/') + 1);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		System.out.println(DFPNo);
		//String FileNo = DFPNo.substring(DFPNo.length() - 1);
		String DFPNo1 = StringUtils.chop(DFPNo);
		System.out.println(DFPNo1);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String CSV_File_Path = "C:\\Users\\MuhammadMujahid\\Downloads\\"+DFPNo1+"";
		// read the file
		Reader reader = Files.newBufferedReader(Paths.get(CSV_File_Path));
		// parse the file into csv values
		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

		for (CSVRecord csvRecord : csvParser) {
			// Accessing Values by Column Index
			String name = csvRecord.get(0);
			String email = csvRecord.get(1);
			String group = csvRecord.get(2);
			String location = csvRecord.get(3);
			String phone = csvRecord.get(4);
			String error = csvRecord.get(5);
			// print the value to console
			System.out.println("Row No - " + csvRecord.getRecordNumber());
			System.out.println("---------------");
			System.out.println(name);
			System.out.println(email);
			System.out.println(group);
			System.out.println(location);
			System.out.println(phone);
			System.out.println(error);
			System.out.println("---------------");

			Waits.waitTime(5);
		}
		
	}
	
	public void editRecipient() throws InterruptedException {
		
		searchByEmail();
		UsersPage.clickUserFromList();
		editName();
		editEmail();
		editPhone();
		//enterPhone();
		editUnit();
		editAddress();
		editNotes();
		editAlternateNameEmailNumber();
		editNotificationPreferences();
		editAssignToGroup();
		
		UsersPage.clickSave();
		
		SiteActions.notification();
		String expectedTitles[] = {"Cannot update email of a recipient who is also a user.","Recipient updated successfully"};
		List<String> expectedTitlesList = Arrays.asList(expectedTitles);
		assertTrue(expectedTitlesList.contains(RecipientsPageElements.SuccessMsgNotification.getText()));
		
	    CommonActions.waitForElementToDisappear(UsersPageElements.NotificationMsg);
		Waits.waitTime(4);
		clickRecipientTab();
		CommonActions.waitLogoInvisible();
	}

	public void deleteRecipient() {

		searchByEmail_Delete();
		Waits.waitTime(1);
		if(!UsersPageElements.noData.isEmpty()) {
			clearFilters();
			searchByEmail();
		}
		
		UsersPage.clickUserFromList();
		UsersPage.clickDelete();
		clickConfirmDelete();

		SiteActions.notification();
		assertEquals(SuccessMsgNotification.getText(), "Recipient deleted successfully.");
		CommonActions.waitForElementToDisappear(RecipientDeletedMsg);
		Waits.waitTime(4);

		//searchByEmail_Delete();
		//noDataFound();
	}

	public void editGroup() throws InterruptedException {
		
		searchByName();
		clickGroupFromList();
		UsersPage.editName();
		editEmail();
		editPhone();
		editUnit();
		editAddress();
		editNotes();
		editAlternateGroupAlias();
		
		UsersPage.clickSave();
		
		SiteActions.notification();
		assertEquals(RecipientsPageElements.SuccessMsgNotification.getText(), "Group information updated successfully");
	    CommonActions.waitForElementToDisappear(UsersPageElements.UserUpdatedMsg);
		Waits.waitTime(4);
	}
	
	public void deleteGroup() {

		searchByName_Delete();
		clickGroupData();
		UsersPage.clickDelete();
		clickConfirmDelete();
		
		SiteActions.notification();
		assertEquals(SuccessMsgNotification.getText(), "Group deleted successfully.");
		CommonActions.waitForElementToDisappear(GroupDeletedMsg);
	}

	public void searchByEmail() {

		CommonActions.waitForElement(UsersPageElements.SearchIconEmail);
		if((UsersPageElements.SearchIconEmail).isEnabled()) {
			UsersPageElements.SearchIconEmail.click();
		}

		Waits.waitTime(2);

		CommonActions.waitForElement(UsersPageElements.SearchEmailtxt);
		if(UsersPageElements.SearchEmailtxt.isEnabled()) {
			UsersPageElements.SearchEmailtxt.click();
			UsersPageElements.SearchEmailtxt.sendKeys(EmailRole);
		}

		Waits.waitTime(2);

		CommonActions.waitForElement(UsersPageElements.SearchBtnEmail);
		if(UsersPageElements.SearchBtnEmail.isEnabled()) {
			UsersPageElements.SearchBtnEmail.click();
		}

		Waits.waitTime(5);
	}
	
	public void searchImportedRecipientEmail() {
		
		CommonActions.waitForElement(UsersPageElements.SearchIconEmail);
		if((UsersPageElements.SearchIconEmail).isEnabled()) {
			UsersPageElements.SearchIconEmail.click();
		}

		Waits.waitTime(2);

		CommonActions.waitForElement(UsersPageElements.SearchEmailtxt);
		if(UsersPageElements.SearchEmailtxt.isEnabled()) {
			UsersPageElements.SearchEmailtxt.click();
			UsersPageElements.SearchEmailtxt.sendKeys(ImportedRecipientEmail);
		}

		Waits.waitTime(2);

		CommonActions.waitForElement(UsersPageElements.SearchBtnEmail);
		if(UsersPageElements.SearchBtnEmail.isEnabled()) {
			UsersPageElements.SearchBtnEmail.click();
		}

		Waits.waitTime(5);
		recipientInRecipientsList();
	}
	
	public void searchByEmail_Delete() {

		CommonActions.waitForElement(UsersPageElements.SearchIconEmail);
		if((UsersPageElements.SearchIconEmail).isEnabled()) {
			UsersPageElements.SearchIconEmail.click();
		}

		Waits.waitTime(2);

		CommonActions.waitForElement(UsersPageElements.SearchEmailtxt);
		if(UsersPageElements.SearchEmailtxt.isEnabled()) {
			UsersPageElements.SearchEmailtxt.click();
			UsersPageElements.SearchEmailtxt.sendKeys(UpdatedEmail);
		}

		Waits.waitTime(2);

		CommonActions.waitForElement(UsersPageElements.SearchBtnEmail);
		if(UsersPageElements.SearchBtnEmail.isEnabled()) {
			UsersPageElements.SearchBtnEmail.click();
		}

		Waits.waitTime(5);
	}
	
	public void noDataFound() {
		
		Waits.waitTime(2);
		CommonActions.waitForElement(UsersPageElements.NoData);
		Assert.assertTrue(UsersPageElements.NoData.isDisplayed());
	}

	public void searchByName() {

		CommonActions.waitForElement(UsersPageElements.SearchIconName);
		if((UsersPageElements.SearchIconName).isEnabled()) {
			UsersPageElements.SearchIconName.click();
		}

		Waits.waitTime(2);

		CommonActions.waitForElement(UsersPageElements.SearchNametxt);
		if(UsersPageElements.SearchNametxt.isEnabled()) {
			UsersPageElements.SearchNametxt.click();
			UsersPageElements.SearchNametxt.sendKeys(EmailRole);
		}

		Waits.waitTime(2);

		CommonActions.waitForElement(UsersPageElements.SearchBtnName);
		if(UsersPageElements.SearchBtnName.isEnabled()) {
			UsersPageElements.SearchBtnName.click();
		}

		Waits.waitTime(5);
	}
	
	public void searchByName_Delete() {

		CommonActions.waitForElement(UsersPageElements.SearchIconName);
		if((UsersPageElements.SearchIconName).isEnabled()) {
			UsersPageElements.SearchIconName.click();
		}

		Waits.waitTime(2);

		CommonActions.waitForElement(UsersPageElements.SearchNametxt);
		if(UsersPageElements.SearchNametxt.isEnabled()) {
			UsersPageElements.SearchNametxt.click();
			UsersPageElements.SearchNametxt.sendKeys(UpdatedEmail);
		}

		Waits.waitTime(2);

		CommonActions.waitForElement(UsersPageElements.SearchBtnName);
		if(UsersPageElements.SearchBtnName.isEnabled()) {
			UsersPageElements.SearchBtnName.click();
		}

		Waits.waitTime(5);
	}

	public void clickGroupData() {

		CommonActions.waitForElement(GroupData);
		if(GroupData.isDisplayed()) {
			GroupData.click();
		}
	}

	public void recipientInRecipientsList() {
		
		String recipientUploadedEmail = uploadedRecipientEmail.getText();
		System.out.println("Recipient Email: " + recipientUploadedEmail);
		
		Assert.assertEquals(recipientUploadedEmail, ImportedRecipientEmail);
	}
	
	public static void clickConfirmDelete() {

		Waits.waitTime(2);
		CommonActions.waitForElement(DeleteConfirmBtn);
		if(DeleteConfirmBtn.isDisplayed()) {
			DeleteConfirmBtn.click();
		}				
	}
	
	public static void editName() {
		
		CommonActions.waitForElement(RecipientName);
		RecipientName.click();
		RecipientName.sendKeys("1");
	}
	
	public static void editEmail() {

		CommonActions.waitForElement(RecipientEmail);
		RecipientEmail.click();
		keysArrowRight();
		
	}
	
	public static void editPhone() {

		CommonActions.waitForElement(Phone);
		if(Phone.isEnabled()) {
			Phone.click();
			Phone.sendKeys(Keys.BACK_SPACE, "1", Keys.ENTER);
		}
		
	}
	
	public void editUnit() {
		
		CommonActions.waitForElement(Unit);
		if(Unit.isEnabled()) {
			Unit.sendKeys(Keys.BACK_SPACE, "1", Keys.ENTER);
		}
	}
	
	public void editAddress() {
		
		CommonActions.waitForElement(Address);
		if(Address.isEnabled()) {
			Address.sendKeys(Keys.BACK_SPACE, " Abcd", Keys.ENTER);
		}
	}
	
	public void editNotes() {
		
		CommonActions.waitForElement(Notes);
		if(Notes.isEnabled()) {
			Notes.sendKeys(Keys.BACK_SPACE, " Notes", Keys.ENTER);
		}
	}
	
	public void  editAlternateNameEmailNumber() {
		
		CommonActions.waitForElement(AlternateName_1_DelBtn);
		CommonActions.focusElementJs(driver, AlternateName_1_DelBtn);
		AlternateName_1_DelBtn.click();
		addAlternateName();
		
		CommonActions.waitForElement(AlternateEmail_1_DelBtn);
		CommonActions.focusElementJs(driver, AlternateEmail_1_DelBtn);
		AlternateEmail_1_DelBtn.click();
		addAlternateEmail();
		
		CommonActions.waitForElement(AlternateNumber_1_DelBtn);
		CommonActions.focusElementJs(driver, AlternateNumber_1_DelBtn);
		AlternateNumber_1_DelBtn.click();
		addAlternatePhone();
		
	}
	
	public void editNotificationPreferences() {
		
		NotificationPreference();
	}
	
	public void editAssignToGroup() {
		
		CommonActions.waitForElement(GroupItems_ToggleBtn);
		GroupItems_ToggleBtn.click();
		
		CommonActions.waitForElement(AddedGroup_DelBtn);
		AddedGroup_DelBtn.click();
		
		assignToAGroup();
		
		CommonActions.waitForElement(RemoveAll_SelectedGroups);
		RemoveAll_SelectedGroups.click();
		
	}
	
	public void editAlternateGroupAlias() {
		
		CommonActions.waitForElement(GroupAlias_DelBtn);
		CommonActions.focusElementJs(driver, GroupAlias_DelBtn);
		GroupAlias_DelBtn.click();
		Waits.waitTime(1);
		addAlternateGroupAlias();
	}
	
	public static void keysArrowRight() {
		
		for(int i = 0; i <= 9 ; i++) {
				RecipientEmail.sendKeys(Keys.ARROW_RIGHT);
			}
		Waits.waitTime(1);
		CommonActions.doubleClick(RecipientEmail);
		RecipientEmail.sendKeys(Keys.BACK_SPACE+"io");
		
		String updatedEmail = RecipientEmail.getAttribute("value");
	    System.out.println("Updated email is : " + updatedEmail);
		
	    UpdatedEmail = updatedEmail;
	}
	
	
	public static void keysArrowRight_SearchName() {

		for(int i = 0; i <= 9 ; i++) {
			UsersPageElements.SearchNametxt.sendKeys(Keys.ARROW_RIGHT);
		}
		Waits.waitTime(1);
		CommonActions.doubleClick(UsersPageElements.SearchNametxt);
		UsersPageElements.SearchNametxt.sendKeys(Keys.BACK_SPACE+"io");
		
	}

	public static void clickGroupFromList() {
		
		CommonActions.waitForElement(SelectGroupFromList);
		if(SelectGroupFromList.isDisplayed()) {
			SelectGroupFromList.click();
		}		
	}
	
	public void assignToAGroup() {
		
		CommonActions.waitForElement(SearchGroupSearchBar);
		if(SearchGroupSearchBar.isEnabled()) {
			SearchGroupSearchBar.click();
			SearchGroupSearchBar.sendKeys("Pakistan");
		}	
		
		SearchBtnSearchBar.click();
		//CommonActions.focusElementJs(driver, SearchGroup_ddl);
		CommonActions.waitLoadingIconInvisible();
		Waits.waitTime(2);
		CommonActions.waitForElement(SearchGroup_Option1);
		SearchGroup_Option1.click();
		Waits.waitTime(1);
		CommonActions.waitForElement(AssignToGroup_txt);
		AssignToGroup_txt.click();
		Waits.waitTime(1);
	}
	
	public void columnPreferencesRecipients() throws InterruptedException {
		
		clickRecipientTab();
		
		clickColumnPreferences();
		
		CommonActions.waitForElement(Group_TglBtn);
		if(Group_TglBtn.isDisplayed()) {
			Group_TglBtn.click();
		}
		
		CommonActions.waitForElement(Location_TglBtn);
		if(Location_TglBtn.isDisplayed()) {
			Location_TglBtn.click();
		}
		
		CommonActions.waitForElement(Unit_TglBtn);
		if(Unit_TglBtn.isDisplayed()) {
			Unit_TglBtn.click();
		}
		
		CommonActions.waitForElement(ReceivedItems_TglBtn);
		if(ReceivedItems_TglBtn.isDisplayed()) {
			ReceivedItems_TglBtn.click();
		}
		
		CommonActions.waitForElement(PendingItems_TglBtn);
		if(PendingItems_TglBtn.isDisplayed()) {
			PendingItems_TglBtn.click();
		}
		
		CommonActions.waitForElement(NotificationPreferences_TglBtn);
		if(NotificationPreferences_TglBtn.isDisplayed()) {
			NotificationPreferences_TglBtn.click();
		}
		
		CommonActions.waitForElement(Phone_TglBtn);
		if(Phone_TglBtn.isDisplayed()) {
			Phone_TglBtn.click();
		}
		
		CommonActions.waitForElement(LastUpdate_TglBtn);
		if(LastUpdate_TglBtn.isDisplayed()) {
			LastUpdate_TglBtn.click();
		}
		
		CommonActions.waitForElement(City_TglBtn);
		if(City_TglBtn.isDisplayed()) {
			City_TglBtn.click();
		}
		
		CommonActions.waitForElement(Organization_TglBtn);
		if(Organization_TglBtn.isDisplayed()) {
			Organization_TglBtn.click();
		}
		
		UsersPage.clickSave();
	}
	
	public void clickColumnPreferences() {
		
		Waits.waitTime(2);
		CommonActions.waitForElement(ColumnPreferences);
		if(ColumnPreferences.isDisplayed()) {
			ColumnPreferences.click();
		}
	}

	
	public void columnPreferencesGroups() throws InterruptedException {
		
		clickRecipientTab();
		clickGroupsTab();
		clickColumnPreferences();
		
		CommonActions.waitForElement(TotalRecipients_TglBtn);
		if(TotalRecipients_TglBtn.isDisplayed()) {
			TotalRecipients_TglBtn.click();
		}
		
		CommonActions.waitForElement(DesignatedRecipients_TglBtn);
		if(DesignatedRecipients_TglBtn.isDisplayed()) {
			DesignatedRecipients_TglBtn.click();
		}
				
		if(RecipientItemsDisabled_TglBtn.isEmpty()) {
			CommonActions.waitForElement(RecipientItems_TglBtn);
			if(RecipientItems_TglBtn.isDisplayed()) {
				RecipientItems_TglBtn.click();
			}
		}
		
		if(LastUpdatedByDisabled_TglBtn.isEmpty()) {
			CommonActions.waitForElement(LastUpdatedBy_TglBtn);
			if(LastUpdatedBy_TglBtn.isDisplayed()) {
				LastUpdatedBy_TglBtn.click();
			}
		}
		
		UsersPage.clickSave();
	}
	
	public void clickGroupsTab(){
		
		CommonActions.waitForElement(GroupsTab);
		if(GroupsTab.isEnabled()) {
			GroupsTab.click();
		}
	}
	
	public void clickSetCustomFields() {
		
		CommonActions.waitForElement(SetCustomFields);
		if(SetCustomFields.isDisplayed()) {
			SetCustomFields.click();
		}
		
	}
	
	public void addCustomFields() throws InterruptedException {
						
		clickRecipientTab();
		clickSetCustomFields();
		
		Waits.waitTime(2);
		
//		if(CustomField_1_ClearBtn.isDisplayed()) {
//			CustomField_1_ClearBtn.click();
//		}
		
		CommonActions.waitForElement(Field1);
		String f1 = Field1.getAttribute("value");
		System.out.println(f1);
		if(f1 == "") {
			Field1.sendKeys("Organization");
		}
		
		CommonActions.waitForElement(Field2);
		String f2 = Field2.getAttribute("value");
		System.out.println(f2);
		if(f2 == "") {
			Field2.sendKeys("City");
		}
		
		//if(!SaveBtnCF.getAttribute("class").contains("disabled")) {
		if(!saveBtnCF.isEmpty()) {
			CommonActions.focusElementJs(driver, SaveBtnCF);
			SaveBtnCF.click();
			
			SiteActions.notification();
			assertEquals(RecipientsPageElements.SuccessMsgNotification.getText(), "Updated Successfully!");
		    CommonActions.waitForElementToDisappear(NotificationMsg);
		    
		    checkCustomFieldsAdded();
		}
		else
		{
			CloseCustomFieldsPopup.click();
		}
	}
	
	public void checkCustomFieldsAdded() {
		
		Assert.assertTrue(Organization_Col.isDisplayed());
		Assert.assertTrue(City_Col.isDisplayed());
		
	}
	
	public void clearFilters() {
		
		CommonActions.waitForElement(ClearFilters);
		CommonActions.focusElementJs(driver, ClearFilters);
		ClearFilters.click();
		CommonActions.waitLogoInvisible();
	}

}
