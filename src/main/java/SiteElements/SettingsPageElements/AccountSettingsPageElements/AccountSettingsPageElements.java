package SiteElements.SettingsPageElements.AccountSettingsPageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSettingsPageElements {

	
	WebDriver driver;

	@FindBy(xpath="//a[@aria-label='Settings']")
	protected static WebElement SettingsTab;
	
	
	@FindBy(xpath="//header[text()='Account Settings']")
	protected WebElement AccountSettings;
	
	@FindBy(xpath="//header[text()='Update Password']")
	protected WebElement UpdatePassword;
	
	@FindBy(id="current-password")
	protected WebElement CurrentPassword;
	
	@FindBy(id="new-password")
	protected WebElement NewPassword;
	
	@FindBy(id="confirm-password")
	protected WebElement ConfirmPassword;
	
	@FindBy(xpath="//button[text()='Update Password']")
	protected WebElement UpdatePasswordBtn;
	
	//@FindBy(xpath="//span[text()='Your password has successfully been changed.']")
	@FindBy(id="notification-title")
	protected WebElement PasswordUpdatedMsg;
	
}
