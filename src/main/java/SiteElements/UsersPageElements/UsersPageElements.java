package SiteElements.UsersPageElements;

import java.util.List;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import Users.UsersPage;
import Utilities.GlobalVariables;
//import org.openqa.selenium.support.How;

//import Utilities.GlobalVariables;
//import org.openqa.selenium.support.How;

public class UsersPageElements {

	WebDriver driver;

	@FindBy(xpath="//*[@class='hamburger']")
    protected static WebElement ExpandBtn;
	
	@FindBy(xpath="//a[@aria-label='Users']")
	//@FindBy(xpath="//span[text()='Users']")
    protected WebElement UsersTab;
	
	@FindBy(xpath="//button[text()='Add New']")
    protected WebElement AddNew;
	
	//@FindBy(xpath="//input[@name='text']")
	@FindBy(xpath="//input[@name='name']|//input[@name='text']")
	//@FindBy(xpath="//div[@data-tut='user-userName']")
    protected static WebElement Name;
	//*[@name='text']
	
	@FindBy(name="email")
    protected static WebElement Email;
	
	//@FindBy(xpath="//*[@role='button']")
	@FindBy(xpath="//label[text()='Role']/following::div[@aria-haspopup='listbox'] | //label[text()='ROLE']/following::div[@aria-haspopup='listbox']")
    protected WebElement Roleddl;
	
	@FindBy(xpath="//ul[@role='listbox']")
    protected WebElement Roleddl1;
	
	@FindBy(xpath="//span[text()='Admin']")
    protected CharSequence[] Admin;
	
	@FindBy(xpath="//span[text()='Manager']")
    protected WebElement Manager;
	
	@FindBy(xpath="//span[text()='Operator']")
    protected WebElement Operator;
	
	@FindBy(xpath="//span[text()='Abc']")
    protected WebElement AbcLocation;
	
	@FindBy(xpath="//button[text()='Choose Location']")
    protected WebElement ChooseLocation;
	
	@FindBy(xpath="//input[@placeholder='Search Location']")
	public static WebElement SearchLocation;
	
	@FindBy(xpath="//span[@class='ant-input-clear-icon']")
	public static WebElement SearchClear;
	
	@FindBy(xpath="//*[contains(text(),'Abc')]")
	public static WebElement AbcManOpLocation;
	
	@FindBy(xpath="//input[@type='checkbox']")
	public static WebElement Chkbox;
	
	@FindBy(xpath="//input[@type='radio']")
	public static WebElement Radiobtn;
	
	@FindBy(xpath="//*[@data-icon='loading']")
	public static WebElement SearchLoadingIcon;
	
	@FindBy(xpath="//button[text()='Add']")
    protected WebElement Add;
	
	@FindBy(xpath="//button[text()='Select']")
    protected static WebElement SelectBtn;
	
	
	@FindBys(@FindBy(xpath="//div[text()='Select Mailroom(s)']"))
	public List<WebElement> selectMailroom;
	
	@FindBy(xpath="(//div[@aria-haspopup='listbox'])[2]")
    protected WebElement SelectMailroom;
	
	@FindBy(xpath="//div[text()='new-002']")
    protected WebElement New002;
	
	@FindBy(xpath="//button[text()='Save']")
	public
    static WebElement Save;
	
	@FindBy(xpath="//div[@class='ant-notification ant-notification-topRight']")
    protected WebElement UserAddedMsg;
	
   //	@FindBy(xpath="//div[@class='sc-dPyBCJ hoBTmk  typography-x']")
   //   protected WebElement UserAddedMsg;
	
	@FindBy(xpath="//span[text()='User created successfully']")
    public static WebElement NewUserAddedMsg;
	
	@FindBy(xpath="//div[text()='Showing results']")
	protected WebElement ShowingResults;
	
	// Add User Test cases
	
	@FindBy(xpath="(//div[text()='Name']/following::span[@aria-label='search'])[1]")
	public static WebElement SearchIconName;
	
	@FindBy(xpath="(//div[text()='Email']/following::span[@aria-label='search'])[1]")
	public static WebElement SearchIconEmail;
	
	@FindBy(xpath="//input[@placeholder='Search Name']|//input[@placeholder='Search name']")
	//@FindBy(xpath="(//input[@type='text'])[1]")
	public static WebElement SearchNametxt;
	
	@FindBy(xpath="//input[@placeholder='Search Email']|//input[@placeholder='Search email']")
	//@FindBy(xpath="(//input[@type='text'])[1]")
	public static WebElement SearchEmailtxt;
	
	@FindBy(xpath="//input[@placeholder='Search Name']/following::div//span[text()='Search']|//input[@placeholder='Search name']/following::div//span[text()='Search']")
	//@FindBy(xpath="(//span[text()='Search'])[1]")
	public
	static WebElement SearchBtnName;
	
	//@FindBy(xpath="(//span[text()='Search'])[1]")
	//@FindBy(xpath="//input[@placeholder='Search Email']/following::div//span[text()='Search']")
	@FindBy(xpath="//input[@placeholder='Search email']/following::div//span[text()='Search'] | //input[@placeholder='Search Email']/following::div//span[text()='Search']")
	public static WebElement SearchBtnEmail;
	
	@FindBy(xpath="(//span[text()='Search'])[3]")
	protected WebElement SearchBtnFilters;
	
	@FindBy(xpath="//span[text()='Reset']")
	protected WebElement ResetBtn;
	
	@FindBy(xpath="//div[text()='No Data']")
	public static WebElement NoData;
	
	@FindBys(@FindBy(xpath="//div[text()='No Data']"))
	public static List<WebElement> noData;
	
	//@FindBy(xpath="//span[@class='anticon']")
	@FindBy(xpath="(//span[@role='button'])[3]")
	protected WebElement FilterIcon;
	
	@FindBy(xpath="//span[text()='Admin']")
	//@FindBy(xpath="//input[@type='checkbox' and @value='admin']")
	protected WebElement AdminChkbox;
	
	@FindBy(xpath="//span[text()='Manager']")
	//@FindBy(xpath="//input[@type='checkbox' and @value='manager']")
	protected WebElement ManagerChkbox;
	
	@FindBy(xpath="//span[text()='Operator']")
	//@FindBy(xpath="//input[@type='checkbox' and @value='operator']")
	protected WebElement OperatorChkbox;
	
	//@FindBy(xpath="//input[@type='checkbox' and @value='pickup']")
	@FindBy(xpath="//span[text()='Pickup User']")
	protected WebElement PickupChkbox;
	
	@FindBy(xpath="(//span[@aria-label='Remove'])[1]")
	protected WebElement RemoveAdminFilter;

	@FindBy(xpath="(//span[@aria-label='Remove'])[2]")
	protected WebElement RemoveManagerFilter;
	
	@FindBy(xpath="(//span[@aria-label='Remove'])[3]")
	protected WebElement RemoveOperatorFilter;
	
	@FindBy(xpath="(//span[@aria-label='Remove'])[4]")
	protected WebElement RemovePickupFilter;
	
	@FindBy(xpath="//span[text()='Clear Filters']")
	protected WebElement ClearFiltersBtn;
	
	
	@FindBy(xpath="//div[text()='Name']")
	protected WebElement Namelbl;
	
	@FindBy(xpath="//div[text()='Email']")
	protected WebElement Emaillbl;
	
	@FindBy(xpath="//div[text()='Role']")
	protected WebElement Rolelbl;
	
	
	//// Delete Scenario
	
	//@FindBy(xpath="//img[@alt='User']")
	
	@FindBy(xpath="//span[@class='ant-avatar ant-avatar-circle'] | //img[@alt='User']")
	protected static WebElement UserInUsersList;
	
	@FindBy(xpath="//button[text()='Deactivate']")
	protected WebElement DeactivateBtn;
	
	@FindBy(xpath="(//button[text()='Deactivate'])[2]")
	protected WebElement DeactivateConfirmBtn;
	
	@FindBy(xpath="User Deactivated Successfully")
	protected static WebElement UserDeactivatedMsg;
	
	//@FindBy(xpath="//button[text()='Delete']")
	@FindBy(xpath="//span[text()='Delete'] | //button[text()='Delete']")
	protected static WebElement DeleteBtn;
	
	@FindBy(xpath="(//button[text()='Delete'])[2]")
	//@FindBy(xpath="(//button[text()='Delete'])[2] | //button[text()='Delete']")
	protected static WebElement DeleteConfirmBtn;
	
	@FindBy(xpath="//button[text()='Activate']")
	protected static WebElement ActivateBtn;
	
	@FindBy(xpath="//span[@type='danger']")
	protected static WebElement InActive;
	
	@FindBy(xpath="//span[text()='User Updated Successfully']")
	public
	static WebElement UserUpdatedMsg;
	
	@FindBy(xpath="//span[text()='User Deleteted Successfully']")
	protected static WebElement UserDeletedMsg;
	
	@FindBy(id="notification-title")
	public
	static WebElement NotificationMsg;
	
	/// Column Preference
	 
	@FindBy(xpath="//span[@aria-label='Column Preferences']")
	protected WebElement ColumnPreferences;
	
	@FindBy(id="location")
	protected WebElement Location_TglBtn;
	
	@FindBy(id="role")
	protected WebElement Role_TglBtn;
	
	@FindBy(id="status")
	protected WebElement Status_TglBtn;
	
	@FindBys(@FindBy(xpath="//button[@id='status' and @disabled]"))
	public List<WebElement> StatusDisabled_TglBtn;
	
	@FindBy(id="last_update")
	protected WebElement LastUpdate_TglBtn;
	
	@FindBys(@FindBy(xpath="//button[@id='last_update' and @disabled]"))
	public List<WebElement> LastUpdateDisabled_TglBtn;
	
	
	@FindBys(@FindBy(xpath="//div[text()='Role']"))
	public List<WebElement> RoleFilter;
	
	@FindBys(@FindBy(xpath="//button[text()='Save']"))
	public List<WebElement> SaveBtn;
	
	@FindBys(@FindBy(xpath="(//div[@aria-haspopup='listbox'])[2]"))
	public List<WebElement> SelectMailroomOption;
	
}
