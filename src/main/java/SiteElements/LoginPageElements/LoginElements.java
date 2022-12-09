package SiteElements.LoginPageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import java.util.List;
//import java.sql.Driver;

//import org.openqa.selenium.support.CacheLookup;
//import org.openqa.selenium.support.FindAll;
//import org.openqa.selenium.By;

public class LoginElements {

	WebDriver driver;

	//@FindBy(id="email")
    //protected WebElement email;
	
	//public static By UsePassword = By.xpath("//*[text()='Use Password Instead']");
	
	@FindBys(@FindBy(xpath="//*[text()='Use Password Instead']"))
	public List<WebElement> desiredElement;
	
	@FindBy(how = How.ID, using = "email")
	protected
	WebElement EmailLogin;
	
	@FindBy(id="submit-btn")
	protected WebElement ContinueBtn;
	
	//@CacheLookup
	@FindBy(xpath="//*[text()='Use Password Instead']")
	protected WebElement UsePassword;
	
	@FindBy(id="password")
	protected WebElement Password;
	
	@FindBy(xpath="//span[text()='Incorrect username or password.']")
	protected WebElement IncorrectPasswordMsg;
	
	@FindBy(id="phone-form-control")
	protected WebElement PhoneForm;
	
	@FindBy(xpath="//*[@name='field-1']")
	protected WebElement PhoneCode;
	
	//@FindBy(xpath="(//*[text()='Dashboard'])[2]")
	@FindBy(xpath="//div[text()='Analytics']")
	protected WebElement Dashboard;
	
	
	
	
	// DashBoard Side Expand/Shrink Button  	
	
	@FindBy(xpath="//*[@class='hamburger']")
    protected static WebElement ExpandBtn;
	
	
	
	// Logout Elements
	
	//@FindBy(xpath="//div[@aria-label='User Preferences']")
	@FindBy(id="user_preferences")
	protected WebElement LogoutMenu;
	
	//@FindBy(xpath="(//*[@class='sc-gsnTZi bsJyFh'])[1]")
	@FindBy(xpath="//a[@href='/users/current']")
	protected WebElement UserRole;

	
	@FindBy(xpath="//a[@href='/signout']")
	//@FindBy(xpath="//div[text()='Sign Out']")
	//@FindBy(xpath="(//div[text()='Sign Out'])[2]")
	//@FindBy(xpath="(//a[@href='/signout'])[2] | //a[@href='/signout']")
	protected WebElement SignOut;
	
	
	
	
	// Forgot Password
	
	@FindBy(id="forgot-password-link")
	protected WebElement ForgotPassword;
	
	
	@FindBy(xpath="//*[text()='Attempt limit exceeded, please try after some time.']")
	protected WebElement AttemptLimitMsg;
	
	@FindBy(xpath="//span[text()='Sign in to Mailroom']")
	protected WebElement SignIntoMailRoom;

	@FindBy(xpath="//a[@href]/span")
	//@FindBy(xpath="//span[text()='Sign in to Receive Account']")
	protected WebElement SignIntoReceiveAccount;
	
	@FindBy(xpath="//span[text()='Sign in to Receive Account']")
	protected WebElement OLSignIntoReceiveAccount;
	
	@FindBy(xpath="//input[@placeholder='Enter your inbox here']")
	public static WebElement EmailForCode;
	
	@FindBy(xpath="//input[@type='email']")
	public static WebElement OLEmailForCode;
	
	@FindBy(xpath="//input[@type='submit']")
	public static WebElement NextBtn;
	
	@FindBy(xpath="//input[@type='password']")
	public static WebElement OLPassword;
	
	@FindBy(xpath="//span[text()='Mail Testing']")
	public static WebElement OLMailTesting;
	
	@FindBy(xpath="(//span[text()='Mail Testing']/following::div/span[text()='Inbox'])[1]")
	public static WebElement OLInbox;
	
	@FindBy(xpath="(//span[text()='PackageX Receive'])[1]")
	public static WebElement OLPackageXReceive;
	
	@FindBy(xpath="//img[@alt='password_icon']/following::td/span")
	public static WebElement OLTemporaryCode;
	
	@FindBy(xpath="//button[@title='Check Inbox @yopmail.com']")
	public static WebElement CheckEmailBtn;
	
	@FindBy(xpath="(//span[text()='PackageX Receive'])[1] | (//span[text()='Coke'])[1]")
	public static WebElement PackageXReceiveEmail;
	
	@FindBy(xpath="//div[@class='recaptcha-checkbox-border']")
	protected WebElement CaptchaCheckbox;
	
	@FindBy(xpath="//*[@alt='password_icon']/following::span[1]")
	public static WebElement TemporaryCodeFromEmail;
	
	@FindBy(name="field-1")
	public static WebElement TemporaryPassword;
	
	@FindBy(xpath="//span[text()='Complete Sign up']/following::span[1]")
	public static WebElement OneTimePassword;
	
	@FindBy(xpath="//span[text()='Complete Sign up']")
	public static WebElement CompleteSignUpBtn;
	
	@FindBy(id="new-password")
	public static WebElement NewPassword;
	
	@FindBy(id="confirm-password")
	public static WebElement ConfirmPassword;
	
	@FindBy(xpath="//span[text()='Your password has been changed successfully. Please log in with new credentials.']")
	protected WebElement PasswordChangedMsg;
	
	@FindBy(id="login-link")
	protected WebElement LoginInstead;
	
	@FindBy(xpath="//span[text()='Show']")
	protected WebElement ShowPassword;
	
	@FindBy(xpath="//span[text()='Hide']")
	protected WebElement HidePassword;
	
	// Success Message
	@FindBy(xpath="//div[@class='ant-notification ant-notification-topRight']")
	public static WebElement SuccessMessage;
	
	// Magic Link
	
	@FindBy(xpath="//h3[text()='Magic Link Sent']")
	public WebElement MagicLinkSent;
	
	
	@FindBy(xpath="//*[@fill='currentColor']")
	public WebElement GreenMark;
	
	@FindBy(xpath="//span[text()='The user ID you entered does not exist in our system.']")
	public WebElement IDNotExistMsg;
	
	
	// Dashboard Globar Search Bar
	
	@FindBy(xpath="(//input[@type='search'])[1]")
	public static WebElement SearchBarDashBoard;
	
	@FindBy(xpath="(//span[@class='ant-select-selection-item'])[1]")
	public static WebElement SearchBar_ddlDashBoard;
	
	@FindBy(xpath="//div[@class='rc-virtual-list-holder-inner']")
	public static WebElement SearchBar_ddlBox;
	
	@FindBy(xpath="(//span[text()='Locations'])[2]")
	public static WebElement SelectLocation;
	
	@FindBy(xpath="(//span[text()='Users'])[2]")
	public static WebElement SelectUser;
	
	@FindBy(xpath="(//span[text()='Recipient'])[1]")
	public static WebElement SelectRecipient;
	
	@FindBy(xpath="(//span[text()='Groups'])[1]")
	public static WebElement SelectGroup;
	
	@FindBy(xpath="(//div[@class='rc-virtual-list'])[2]")
	public static WebElement SearchBar_ddl;
	
	@FindBy(xpath="//span[text()='Location']")
	public static WebElement SelectLocationFrom_Searched_ddl;
	
	@FindBy(xpath="(//span[text()='Recipient'])[3]")
	public static WebElement SelectRecipientFrom_Searched_ddl;
	
	@FindBy(xpath="(//span[text()='Group'])[1]")
	public static WebElement SelectGroupFrom_Searched_ddl;
	
	@FindBy(xpath="(//span[text()='User'])[1]")
	public static WebElement SelectUserFrom_Searched_ddl;
	
	// Super Admin
	
	@FindBy(xpath="//input[@placeholder='Search Tenants']")
	public WebElement SearchTenantsBar;
	
	@FindBy(xpath="//span[@aria-label='search']")
	public WebElement SearchIcon;
	
	@FindBy(xpath="(//div[@class='inner-text text-ellipsis-15rem'])[3]")
	public WebElement ContactName;
	
}
