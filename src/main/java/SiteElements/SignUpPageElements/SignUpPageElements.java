package SiteElements.SignUpPageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class SignUpPageElements {

	WebDriver driver;

	//@FindBy(id="sso-btn")
	@FindBy(xpath="//button[text()='Create an Account']")
    protected WebElement CreateAnAccount;
	
	@FindBy(xpath="//input[@id='firstName']")
	protected WebElement FirstName;
	
	@FindBy(xpath="//input[@id='lastName']")
	protected WebElement LastName;
	
	@FindBy(xpath="//input[@id='userEmail']")
	protected WebElement Email;
	
	@FindBy(xpath="//input[@id='companyName']")
	protected WebElement CompanyName;
	
	@FindBy(xpath="//input[@class='form-control phone-input']")
	protected WebElement Phone;
	
	//@FindBy(xpath="//input[@type='checkbox']")
	@FindBy(xpath="//input[@class='ant-checkbox-input']")
	protected WebElement TermsOfService_chkBox;
	
	@FindBy(id="recaptcha-toggle")
	protected WebElement Capcha_TglBtn;
	
	@FindBy(id="recaptcha-anchor")
	protected WebElement Capcha_chkBox;
	
	@FindBy(id="submit-btn")
	protected WebElement ContinueBtn;
	
	@FindBy(xpath="//span[text()='A user is already registered with this Email']")
	public WebElement UserAlreadyRegdMsg;
	
	
	@FindBy(xpath="//button[text()='Next']")
	public WebElement NextBtn;
	
	@FindBy(xpath="//span[text()='Skip']")
	public WebElement SkipBtn;
	
	@FindBy(xpath="//button[text()='Skip']")
	public WebElement SkipBtnTutorial;
}
