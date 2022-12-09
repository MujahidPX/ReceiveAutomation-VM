package Users;

import static org.testng.Assert.assertEquals;

//import static org.testng.Assert.assertEquals;
//import se.*;
//import se.baselib.web.SeWebElement;

import java.time.Duration;
import java.util.List;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import SiteElements.SiteActions;
import SiteElements.RecipientsPageElements.RecipientsPageElements;
import SiteElements.UsersPageElements.UsersPageElements;
import Utilities.CommonActions;
import Utilities.ExcelFile;
import Utilities.GlobalVariables;
import Utilities.Helper;
import Utilities.Waits;

public class UsersPage extends UsersPageElements {

	private static WebDriver driver;
	private WebDriverWait wait;
	private CommonActions commonActions;
	private ExcelFile excelFile;

	public String EmailRole;
	//public String name;

	public UsersPage(WebDriver driver, WebDriverWait wait) {
		super();
		UsersPage.driver = driver;
		this.wait = wait;
		commonActions = new CommonActions(driver, wait);
		PageFactory.initElements(driver, this);
	}

	public void addNewUser(String userRole, String emailRole, String locationSearched) throws InterruptedException {

		Helper.waitForPageLoad(driver);
		clickUsersTab();
		clickAddNew();
		enterName();
		enterEmail(emailRole);
		selectRole(userRole, locationSearched);
		clickSave();
		
		SiteActions.notification();
		assertEquals(RecipientsPageElements.SuccessMsgNotification.getText(), "User created successfully");
	    CommonActions.waitForElementToDisappear(NewUserAddedMsg);
		
		System.out.println("New user created email : " + emailRole);
		EmailRole = emailRole;
		Waits.waitTime(2);
	}
	
	public void editUser(String userRole, String locationSearched) throws InterruptedException {
		
		searchByEmail();
		clickUserFromList();
		editName();
		selectRole(userRole, locationSearched);
		clickSave();
		
		SiteActions.notification();
		assertEquals(RecipientsPageElements.SuccessMsgNotification.getText(), "User updated successfully");
	    CommonActions.waitForElementToDisappear(UserUpdatedMsg);
		Waits.waitTime(4);
	}
	
	public void deleteUser() {
		
		//clickUsersTab();
		searchByEmail();
		clickUserFromList();
		clickDeactivate();
		clickConfirmDeactivate();
		clickDelete();
		clickConfirmDelete();
		
		SiteActions.notification();
		assertEquals(RecipientsPageElements.SuccessMsgNotification.getText(), "User deleted successfully");
	    CommonActions.waitForElementToDisappear(UserDeletedMsg);
	}
	
	public void activateUser(String userRole, String locationSearched) throws InterruptedException {
		
		searchByEmail();
		clickUserFromList();
		clickDeactivate();
		clickConfirmDeactivate();
		clickUsersTab();
	    Waits.waitTime(2);
	    searchByEmail();
	    checkInActive();
		clickUserFromList();
		selectRole(userRole, locationSearched);
		clickActivate();
		
		SiteActions.notification();
		assertEquals(RecipientsPageElements.SuccessMsgNotification.getText(), "User activated successfully");
	    CommonActions.waitForElementToDisappear(NotificationMsg);
	    clickUsersTab();
	    CommonActions.waitLogoInvisible();
	    //Waits.waitTime(2);
	}
	
	public void addNewUserFilterSorting(String userRole, String emailRole, String name, String locationSearched) throws InterruptedException {
		
		addNewUser(userRole, emailRole, locationSearched);
		searchName(name);
		searchEmail(emailRole);
		applyFilters();
		clearFilters();
		
		Waits.waitTime(2);
		sortName();
		sortEmail();
		sortRole();
	}

	public static void clickExpandBtn() {

		CommonActions.waitForElement(ExpandBtn);
		if(ExpandBtn.isEnabled()) {
			ExpandBtn.click();
			
		}
	}

	public void clickUsersTab() {

		CommonActions.waitForElement(UsersTab);
		//CommonActions.focusElementJs(driver, UsersTab);
		if(UsersTab.isEnabled()){
			UsersTab.click();
		}
	}

	public void clickAddNew() {

		CommonActions.waitForElement(AddNew);
		if(AddNew.isEnabled()){
			AddNew.click();
		}
	}

	public static void enterName() {

		Waits.waitTime(3);
		CommonActions.waitForElement(Name);
		if(Name.isEnabled()){
			Name.click();
			Name.sendKeys(GlobalVariables.AddNewUserName);
			String name = GlobalVariables.AddNewUserName;
			System.out.println(name);
		}		
	}
	
	public static void enterEmail(String emailRole) {

		CommonActions.waitForElement(Email);
		if(Email.isEnabled()){
			Email.click();
			Email.sendKeys(emailRole);
		}
	}

	public void selectRole(String userRole, String locationSearched) throws InterruptedException {

		CommonActions.waitForElement(Roleddl);
		if(Roleddl.isEnabled()) {
			Roleddl.click();
			Thread.sleep(1000);

			CommonActions.waitForElement(Roleddl1);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			List<WebElement> roleList = driver.findElements(By.xpath("//ul[@role='listbox']"));
			if(!roleList.isEmpty()) {

				CommonActions.focusElementJs(driver, Roleddl1);
				//Roleddl1.click();
				//Roleddl1.sendKeys(Keys.DOWN);
				//Roleddl1.sendKeys(Keys.DOWN);
				Thread.sleep(1000);
				Roleddl1.sendKeys(userRole , Keys.ENTER);

			}

			if(userRole == "Admin") {

				//selectLocationAdmin();
				System.out.println("Admin flow");
			}
			if(userRole == "Manager") {

				chooseLocation();
				searchLocation(locationSearched);
				selectCheckBox();
				
				
				Waits.waitTime(3);
				chooseLocation();
				Waits.waitTime(1);
				searchLocation("Melbourne"+Keys.ENTER);
				Waits.waitTime(3);
				selectCheckBox();
				
			}
			if(userRole == "Operator") {

				chooseLocation();
				searchLocation(locationSearched);
				selectRadioBox();
				clickSelect();
				Waits.waitTime(2);
				if(!selectMailroom.isEmpty()) {
					selectMailRoom();
				}
			}
			if(userRole == "OperatorActivate") {

				chooseLocation();
				searchLocation(locationSearched);
				selectRadioBox();
				clickSelect();
				if(!SelectMailroomOption.isEmpty()) {
					selectMailRoom();
				}
			}
		}
	}

	public void selectLocationAdmin() {

		CommonActions.waitForElement(AbcLocation);
		if(AbcLocation.isDisplayed()) {
			AbcLocation.click();		

		}
	}

	public void chooseLocation() {

		Waits.waitTime(1);
		CommonActions.waitForElement(ChooseLocation);
		CommonActions.focusElementJs(driver, ChooseLocation);
		if(ChooseLocation.isDisplayed()) {
			ChooseLocation.click();
			Waits.waitTime(2);
		}
	}

	public static void searchLocation(String locationSearched) throws InterruptedException {
		
		Waits.waitTime(1);
		CommonActions.waitForElement(SearchLocation);
		CommonActions.focusElementJs(driver, SearchLocation);
		if(SearchLocation.isEnabled()) {
			SearchLocation.click();
			//CommonActions.waitLogoInvisible();
			SearchLocation.sendKeys(locationSearched, Keys.ENTER);
			Waits.waitTime(2);
			CommonActions.waitLogoInvisible();
			//Waits.waitTime(3);
			
			/*
			if(!Chkbox.isSelected()) {
				Chkbox.click();
			}
			clickSelect();
			*/
		}		
	}
	
	public void selectCheckBox() {
		
		//Waits.waitTime(2);
		if(!Chkbox.isSelected()) {
			CommonActions.focusElementJs(driver, Chkbox);
			Chkbox.click();
		}
		Waits.waitTime(1);
		clickSelect();
		Waits.waitTime(1);
	}

	public static void selectRadioBox() {
		
		Waits.waitTime(2);
		if(!Radiobtn.isSelected()) {
			CommonActions.focusElementJs(driver, Radiobtn);
			Radiobtn.click();
		}
		
		//clickSelect();
				
	}
	
	public void selectMailRoom() throws InterruptedException {

		CommonActions.waitForElement(SelectMailroom);
		CommonActions.focusElementJs(driver, SelectMailroom);

		if(SelectMailroom.isDisplayed()) {

			SelectMailroom.click();

			if(!Chkbox.isSelected()) {
				Chkbox.click();
			}
			CommonActions.tabKey();
		}
	}

	public void clickAdd() {

		CommonActions.waitForElement(Add);
		if(Add.isEnabled()) {
			Add.click();		

		}
	}

	public static void clickSelect() {

		CommonActions.waitForElement(SelectBtn);
		CommonActions.focusElementJs(driver, SelectBtn);
		if(SelectBtn.isEnabled()) {
			SelectBtn.click();		

		}
	}

	public static void clickSave() throws InterruptedException {

		CommonActions.focusElementJs(driver, Save);		
		List<WebElement> save = driver.findElements(By.xpath("//button[text()='Save']"));

		if(!save.isEmpty()){
			if(Save.isDisplayed()){
				Save.click();
			}
		}
	}

	public static void searchName(String name) throws InterruptedException {

		CommonActions.waitForElement(SearchIconName);
		if(SearchIconName.isEnabled()) {
			SearchIconName.click();
		}

		CommonActions.waitForElement(SearchNametxt);
		if(SearchNametxt.isEnabled()) {
			SearchNametxt.click();
			SearchNametxt.sendKeys(name);
		}

		clickSearchBtnName();

		Thread.sleep(4000);
	}

	public static void clickSearchBtnName() {

		CommonActions.waitForElement(SearchBtnName);
		if(SearchBtnName.isEnabled()) {
			SearchBtnName.click();
		}
	}

	public void clickSearchBtnEmail() {

		CommonActions.waitForElement(SearchBtnEmail);
		if(SearchBtnEmail.isEnabled()) {
			SearchBtnEmail.click();
		}
	}

	public void clickSearchBtnFilters() {

		CommonActions.waitForElement(SearchBtnFilters);
		if(SearchBtnFilters.isEnabled()) {
			SearchBtnFilters.click();
		}
	}

	public void searchEmail(String emailRole) throws InterruptedException {

		CommonActions.waitForElement(SearchIconEmail);
		if(SearchIconEmail.isEnabled()) {
			SearchIconEmail.click();
		}

		CommonActions.waitForElement(SearchEmailtxt);
		if(SearchEmailtxt.isEnabled()) {
			SearchEmailtxt.click();
			SearchEmailtxt.sendKeys(emailRole);
		}

		clickSearchBtnEmail();
		Thread.sleep(2000);
	}

	public void applyFilters() throws InterruptedException {
		
		if(!RoleFilter.isEmpty()) {
			CommonActions.waitForElement(FilterIcon);
			if(FilterIcon.isEnabled()) {
				FilterIcon.click();
			}

			selectManagerCheckBox();
			selectOperatorCheckBox();
			clickSearchBtnFilters();

			CommonActions.waitLogoInvisible();
			Thread.sleep(2000);
		}
	}
	
	public void clearFilters() throws InterruptedException {
		
		CommonActions.waitForElement(ClearFiltersBtn);
		if(ClearFiltersBtn.isEnabled()) {
			ClearFiltersBtn.click();
			Thread.sleep(2000);
		}
	}

	public void selectAdminCheckBox() {

		CommonActions.waitForElement(AdminChkbox);
		if(AdminChkbox.isEnabled() && !AdminChkbox.isSelected()) {
			AdminChkbox.click();
		}
	}

	public void selectManagerCheckBox() {

		CommonActions.waitForElement(ManagerChkbox);
		if(!ManagerChkbox.isSelected()) {
			ManagerChkbox.click();
		}
	}

	public void selectOperatorCheckBox() {

		CommonActions.waitForElement(OperatorChkbox);
		if(!OperatorChkbox.isSelected()) {
			OperatorChkbox.click();
		}
	}

	public void selectPickupCheckBox() {

		CommonActions.waitForElement(PickupChkbox);
		if(!PickupChkbox.isSelected()) {
			PickupChkbox.click();
		}
	}
	
	public void sortName() throws InterruptedException {
		
		Waits.waitTime(3);
		CommonActions.waitForElement(Namelbl);
		if(Namelbl.isEnabled()) {
			Helper.highlight(driver, Namelbl);
			Namelbl.click();
			CommonActions.waitLogoInvisible();
		}		
	}
	
	public void sortEmail() throws InterruptedException {
		
		CommonActions.waitForElement(Emaillbl);
		if(Emaillbl.isEnabled()) {
			Helper.highlight(driver, Emaillbl);
			Emaillbl.click();
			CommonActions.waitLogoInvisible();
		}
	}
	
	public void sortRole() throws InterruptedException {
		
		if(!RoleFilter.isEmpty()) {
			CommonActions.waitForElement(Rolelbl);
			if(Rolelbl.isEnabled()) {
				Helper.highlight(driver, Rolelbl);
				Rolelbl.click();
				CommonActions.waitLogoInvisible();
			}
		}
	}
	
	public static void clickUserFromList() {
		
		Waits.waitTime(3);
		CommonActions.waitForElement(UserInUsersList);
		CommonActions.focusElementJs(driver, UserInUsersList);
		if(UserInUsersList.isDisplayed()) {
			UserInUsersList.click();
		}		
	}
	
	public void clickDeactivate() {
		
		CommonActions.waitForElement(DeactivateBtn);
		if(DeactivateBtn.isDisplayed()) {
			DeactivateBtn.click();
		}		
	}

	public void clickConfirmDeactivate() {
		
		CommonActions.waitForElement(DeactivateConfirmBtn);
		if(DeactivateConfirmBtn.isDisplayed()) {
			DeactivateConfirmBtn.click();
		}	
				
		SiteActions.notification();
		assertEquals(RecipientsPageElements.SuccessMsgNotification.getText(), "User deactivated successfully");
	    CommonActions.waitForElementToDisappear(UserDeactivatedMsg);
		
	}
	
	public static void clickDelete() {
		
		CommonActions.waitForElement(DeleteBtn);
		if(DeleteBtn.isDisplayed()) {
			DeleteBtn.click();
		}		
	}

	public static void clickConfirmDelete() {
		
		Waits.waitTime(2);
		CommonActions.waitForElement(DeleteConfirmBtn);
		if(DeleteConfirmBtn.isDisplayed()) {
			DeleteConfirmBtn.click();
		}				
	}
	
	public void searchByEmail() {
			
		CommonActions.waitForElement(SearchIconEmail);
		if(SearchIconEmail.isEnabled()) {
			SearchIconEmail.click();
		}
		
		Waits.waitTime(2);
		
		CommonActions.waitForElement(SearchEmailtxt);
		if(SearchEmailtxt.isEnabled()) {
			SearchEmailtxt.click();
			SearchEmailtxt.sendKeys(EmailRole);
		}
		
		Waits.waitTime(2);
		
		CommonActions.waitForElement(SearchBtnEmail);
		if(SearchBtnEmail.isEnabled()) {
			SearchBtnEmail.click();
		}
		
		Waits.waitTime(5);
	}
	
	public static void editName() {
		
		Waits.waitTime(5);
		CommonActions.waitForElement(Name);
		Name.click();
		Name.sendKeys("1");
	}
	
	public static void editEmail() {

		CommonActions.waitForElement(Email);
		Email.click();
		Email.sendKeys("1");
	}
	
	public void editRole() {
		
		
	}
	
	public void columnPreferences() throws InterruptedException {

		clickUsersTab();
		clickColumnPreferences();

		CommonActions.waitForElement(Location_TglBtn);
		if(Location_TglBtn.isDisplayed()) {
			Location_TglBtn.click();
		}

		CommonActions.waitForElement(Role_TglBtn);
		if(Role_TglBtn.isDisplayed()) {
			Role_TglBtn.click();
		}

		if(StatusDisabled_TglBtn.isEmpty()) {
			CommonActions.waitForElement(Status_TglBtn);
			if(Status_TglBtn.isDisplayed()) {
				Status_TglBtn.click();
			}
		}

		if(LastUpdateDisabled_TglBtn.isEmpty()) {
			CommonActions.waitForElement(LastUpdate_TglBtn);
			if(LastUpdate_TglBtn.isDisplayed()) {
				LastUpdate_TglBtn.click();
			}
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
	
	public void clickActivate() {
		
		CommonActions.waitForElement(ActivateBtn);
		CommonActions.focusElementJs(driver, ActivateBtn);
		ActivateBtn.click();
		
	}
	
	public void checkInActive() {
		
		String inactive = InActive.getText();
		System.out.println(inactive);
		Assert.assertEquals("Inactive", inactive);
	}

}
