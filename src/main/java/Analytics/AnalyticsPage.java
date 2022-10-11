package Analytics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Login.LoginPage;
import SiteElements.AnalyticsPageElements.AnalyticsPageElements;
//import SiteElements.LocationsPageElements.LocationPageElements;
import Utilities.CommonActions;
import Utilities.Helper;
import Utilities.Waits;

public class AnalyticsPage extends AnalyticsPageElements {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private CommonActions commonActions;
	private LoginPage loginPage;

	public AnalyticsPage(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
		commonActions = new CommonActions(driver, wait);
		PageFactory.initElements(driver, this);
	}
	
	public void scanTrends() {

		scannedCount();
		notifiedCount();
		pickedUpCount();
	}
	
	public void currentlyHeldItems() {
		
		last_3_DaysCount();
		last_3_10_DaysCount();
		over_10_DaysCount();
	}
	
	public void scannedCount() {
		
		CommonActions.focusElementJs(driver, ScannedCount);
		String scannedCount = ScannedCount.getText();
		System.out.println("\nScanned Count: " + scannedCount);
		
		if(ScannedCount.isEnabled()) {
			ScannedCount.click();
		}
		
		//CommonActions.scrollDown();
		CommonActions.waitLogoInvisible();
		Waits.waitTime(3);
		String sr = ShowingResults.getText();
		String showingResult = sr.split(" ")[6];
		System.out.println("Scanned Count Showing Results: " + showingResult);
		Assert.assertEquals(showingResult, scannedCount);
		
		CommonActions.waitLogoInvisible();
		driver.navigate().back();
	}
	
	public void notifiedCount() {
		
		CommonActions.focusElementJs(driver, NotifiedCount);
		String notifiedCount = NotifiedCount.getText();
		System.out.println("Notification Count: " + notifiedCount);

		if(NotifiedCount.isEnabled()) {
			NotifiedCount.click();
		}
		
		CommonActions.waitLogoInvisible();
		Waits.waitTime(3);
		
		String sr = ShowingResults.getText();
		String showingResult = sr.split(" ")[6];
		System.out.println("Notification Count Showing Results: " + showingResult);
		Assert.assertEquals(showingResult, notifiedCount);
		
		CommonActions.waitLogoInvisible();
		driver.navigate().back();
	}
	
	public void pickedUpCount() {
		
		CommonActions.focusElementJs(driver, PickedUpCount);
		String pickedUpCount = PickedUpCount.getText();
		System.out.println("PickedUp Count: " + pickedUpCount);
		
		if(PickedUpCount.isEnabled()) {
			PickedUpCount.click();
		}
		
		CommonActions.waitLogoInvisible();
		Waits.waitTime(3);
		
		String sr = ShowingResults.getText();
		String showingResult = sr.split(" ")[6];
		System.out.println("PickedUp Count Showing Results: " + showingResult);
		Assert.assertEquals(showingResult, pickedUpCount);
		
		CommonActions.waitLogoInvisible();
		driver.navigate().back();		
	}
	
	public void last_3_DaysCount() {

		CommonActions.focusElementJs(driver, Last_3_DaysCount);
		String last_3_DaysCount = Last_3_DaysCount.getText();
		System.out.println("Last 3 Days Count: " + last_3_DaysCount);
		
		if(Last_3_DaysCount.isEnabled()) {
			Last_3_DaysCount.click();
		}
		
		CommonActions.waitLogoInvisible();
		Waits.waitTime(3);

		String sr = ShowingResults.getText();
		String showingResult = sr.split(" ")[6];
		System.out.println("Last 3 Days Count Showing Results: " + showingResult);
		Assert.assertEquals(showingResult, last_3_DaysCount);
		
		CommonActions.waitLogoInvisible();
		driver.navigate().back();
	}
	
	public void last_3_10_DaysCount(){
		
		CommonActions.focusElementJs(driver, Last_3_10_DaysCount);
		String last_3_10_DaysCount = Last_3_10_DaysCount.getText();
		System.out.println("Last 3 - 10 Days Count: " + last_3_10_DaysCount);
		
		if(Last_3_10_DaysCount.isEnabled()) {
			Last_3_10_DaysCount.click();
		}
		
		CommonActions.waitLogoInvisible();
		Waits.waitTime(3);
		
		String sr = ShowingResults.getText();
		String showingResult = sr.split(" ")[6];
		System.out.println("Last 3 - 10 Days Count Showing Results: " + showingResult);
		Assert.assertEquals(showingResult, last_3_10_DaysCount);
		
		CommonActions.waitLogoInvisible();
		driver.navigate().back();
	}
	
	public void over_10_DaysCount() {
		
		CommonActions.focusElementJs(driver, Over_10_DaysCount);
		String over_10_DaysCount = Over_10_DaysCount.getText();
		System.out.println("Over 10 Days Count: " + over_10_DaysCount);
		
		if(Over_10_DaysCount.isEnabled()) {
			Over_10_DaysCount.click();
		}
		
		CommonActions.waitLogoInvisible();
		Waits.waitTime(3);
		
		String sr = ShowingResults.getText();
		String showingResult = sr.split(" ")[6];
		System.out.println("Over 10 Days Count Showing Results: " + showingResult);
		Assert.assertEquals(showingResult, over_10_DaysCount);
		
		CommonActions.waitLogoInvisible();
		driver.navigate().back();		
	}
	
}
