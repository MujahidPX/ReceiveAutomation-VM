package SiteElements.SettingsPageElements.CompanyManagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompanyManagementPageElements {

	WebDriver driver;

	@FindBy(xpath="//a[@aria-label='Settings']")
    protected WebElement SettingsTab;
	
	@FindBy(xpath="//header[text()='Company Management']")
	protected WebElement CompanyManagement;
	
	// Sign in options
	
	@FindBy(xpath="//header[text()='Sign in Options']")
    protected WebElement SignInOptions;
	
	@FindBy(xpath="//h6[text()='Enable Magic Link']/following::button[@role='switch']")
	protected WebElement EnableMagicLink;
	
	@FindBy(id="notification-title")
	protected WebElement NotificationMessage;
	
}
