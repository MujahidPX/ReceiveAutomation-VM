package SiteElements.SettingsPageElements.SettingsLocationsPageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsLocationsPageElements {

	
WebDriver driver;
	
	@FindBy(xpath="//a[@aria-label='Settings']")
	protected static WebElement SettingsTab;

	@FindBy(xpath="//header[text()='Global Location Preferences']")
    protected static WebElement Locations;
	
}
