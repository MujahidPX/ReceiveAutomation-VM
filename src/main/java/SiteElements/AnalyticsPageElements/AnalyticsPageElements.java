package SiteElements.AnalyticsPageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AnalyticsPageElements {

	WebDriver driver;

	@FindBy(xpath="//a[@aria-label='Analytics']")
    protected WebElement AnalyticsTab;
	
	@FindBy(xpath="//p[text()='Scanned']")
	protected WebElement Scanned;
	
	@FindBy(xpath="(//h3[contains(@class,'typography-x')])[1]")
	protected WebElement ScannedCount;
	
	@FindBy(xpath="//p[text()='Notified']")
	protected WebElement Notified;
	
	@FindBy(xpath="(//h3[contains(@class,'typography-x')])[2]")
	protected WebElement NotifiedCount;
	
	@FindBy(xpath="//p[text()='Picked Up']")
	protected WebElement PickedUp;
	
	@FindBy(xpath="(//h3[contains(@class,'typography-x')])[3]")
	protected WebElement PickedUpCount;
	
	@FindBy(xpath="//p[text()='Last 3 Days']")
	protected WebElement Last_3_Days;
	
	@FindBy(xpath="(//h3[contains(@class,'typography-x')])[4]")
	protected WebElement Last_3_DaysCount;
	
	@FindBy(xpath="//p[text()='Last 3 - 10 Days']")
	protected WebElement Last_3_10_Days;
	
	@FindBy(xpath="(//h3[contains(@class,'typography-x')])[5]")
	protected WebElement Last_3_10_DaysCount;
	
	@FindBy(xpath="//p[text()='Over 10 Days']")
	protected WebElement Over_10_Days;
	
	@FindBy(xpath="(//h3[contains(@class,'typography-x')])[6]")
	protected WebElement Over_10_DaysCount;
	
	@FindBy(xpath="//div[text()='Showing results']")
	protected WebElement ShowingResults;

}
