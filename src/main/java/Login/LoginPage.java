package Login;

//import se.Se;
//import se.Se.*;
//import se.Se.NavigateOption;
//import se.baselib.web.*;
//import se.baselib.web.SeWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
//import org.openqa.selenium.devtools.v85.browser.Browser;
//import org.openqa.selenium.devtools.v85.page.model.NavigatedWithinDocument;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
//import com.sun.jna.Library;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

//import SiteElements.SiteActions;
//import SiteElements.SiteElements;
import SiteElements.LoginPageElements.LoginElements;
import Utilities.CommonActions;
import Utilities.ExcelFile;
import Utilities.GlobalVariables;
import Utilities.Helper;
//import Utilities.Waits;
import Utilities.Waits;

//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.JavascriptExecutor;
//import BaseClasses.CreateRandomEmail;
//import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import Utilities.CommonActions;
//import Utilities.GlobalVariables;
//import org.openqa.selenium.RenderedWebElement;
import org.openqa.selenium.StaleElementReferenceException;

import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertTrue;

import java.time.Duration;
//import java.time.Duration;
//import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;

//import java.util.Optional;
//import java.util.Set;
//import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginPage extends LoginElements {

	private static WebDriver driver;
	private WebDriverWait wait;
	private CommonActions commonActions;
	private ExcelFile excelFile;

	public ExtentReports extent;
	public ExtentTest extentTest;
	String originalWindow;

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
		commonActions = new CommonActions(driver, wait);
		PageFactory.initElements(driver, this);

	}
	
	public void login(String email, String password) throws InterruptedException {
		
		enterEmail(email);				
		clickContinue();
		CommonActions.waitForPageLoad();
		try 
		{
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
			usePasswordInstead();	
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		}	
			catch(NoSuchElementException e){
				System.out.println("No password instead option");
		}
		enterPassword(password);
		getTextAfterLogin();
	}

	public void loginSuperAdmin(String email, String password) throws InterruptedException {
		
		enterEmail(email);				
		clickContinue();
		CommonActions.waitForPageLoad();
		enterPassword(password);
		chooseTenantSuperAdmin();
		//getTextAfterLogin();

	}
	
	public void chooseTenantSuperAdmin() {

		CommonActions.waitForElement(SearchTenantsBar);
		if(SearchTenantsBar.isDisplayed()) 
		{
			SearchTenantsBar.sendKeys("Automation Man");
		}
		
		CommonActions.waitForElement(SearchIcon);
		if(SearchIcon.isEnabled()) 
		{
			SearchIcon.click();
		}
		Waits.waitTime(2);
		CommonActions.waitForElement(ContactName);
		if(ContactName.isDisplayed()) 
		{
			ContactName.click();
		}
		
		CommonActions.waitLogoInvisible();
		//CommonActions.escKey();
		//CommonActions.escKey();
	}
	
	public void logout() throws InterruptedException {
		
		Waits.waitTime(2);
		CommonActions.waitForElement(LogoutMenu);
		if(LogoutMenu.isDisplayed()) {
			CommonActions.focusElementJs(driver, LogoutMenu);
			LogoutMenu.click();
			String text = UserRole.getText();
			System.out.println("User : "+ text);
		}

		CommonActions.waitForElement(SignOut);
		if(SignOut.isDisplayed()) {
			SignOut.click();
		}
	}

	public void forgotPassword(String email, String password) throws InterruptedException {

		Helper.waitForPageLoad(driver);

		enterEmail(email);				
		clickContinue();
		CommonActions.waitForPageLoad();
		try {
			usePasswordInstead();	
			
		}	
		catch(NoSuchElementException e){
				System.out.println("No password instead option");
		}

		clickForgotPassword();
		clickContinue();
		Helper.waitForPageLoad(driver);

		List<WebElement> attemptLimit = driver.findElements(By.xpath("//*[text()='Attempt limit exceeded, please try after some time.']"));
		if(!attemptLimit.isEmpty()) {
			try {				
				loginInstead();
				enterPassword(password);
				showHidePassword();
				System.out.println("Attempt limit exceeded");
			}

			catch(Exception e) {
				// Store the current window handle
				String winHandleBefore = driver.getWindowHandle();

				// Perform the click operation that opens new window

				driver.get("https://yopmail.com/en/wm");			
				EmailForCode.sendKeys(email);
				CheckEmailBtn.click();
				clickCapchaCheckbox();
				driver.switchTo().frame("ifmail");
				SignIntoMailRoom.click();

				driver.close();			

				// Switch to new window opened
				for(String winHandle : driver.getWindowHandles()){

					driver.switchTo().window(winHandle);
				}
			}
		}

		else {

			clickContinue();
			switchToNewWindowAndGetEmailCode(email, password);
			clickContinue();

			CommonActions.waitForElement(PasswordChangedMsg);
			if(PasswordChangedMsg.isDisplayed()) {
				CommonActions.focusElementJs(driver, PasswordChangedMsg);
				String ExpectedText="Your password has been changed successfully. Please log in with new credentials.";
				String ActualText = PasswordChangedMsg.getText();
				Assert.assertEquals(ActualText, ExpectedText);
			}

			enterPassword(password);
			showHidePassword();
		}
	}

	
	public void clickForgotPassword() {

		CommonActions.waitForElement(ForgotPassword);
		if(ForgotPassword.isEnabled()) {
			ForgotPassword.click();
		}
	}

	public void switchToNewWindowAndGetEmailCode(String email, String password) {

		originalWindow = driver.getWindowHandle();
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://yopmail.com/en/wm");			
		EmailForCode.sendKeys(email);
		CheckEmailBtn.click();

		driver.switchTo().frame("ifinbox");
		PackageXReceiveEmail.click();
		driver.switchTo().defaultContent();
		//clickCapchaCheckbox();

		driver.switchTo().frame("ifmail");
		String emailCode = TemporaryCodeFromEmail.getText();
		System.out.println("Temporary Email Code : " + emailCode);
		driver.switchTo().defaultContent();
		driver.close();
		driver.switchTo().window(originalWindow);

		if(ContinueBtn.isEnabled()) {
			ContinueBtn.click();
		}

		if(TemporaryPassword.isDisplayed()) {

			TemporaryPassword.sendKeys(emailCode);
		}

		if(NewPassword.isDisplayed()) {

			NewPassword.sendKeys(password);
		}

		if(ConfirmPassword.isDisplayed()) {

			ConfirmPassword.sendKeys(password);
		}
	}

	public void clickCapchaCheckbox() {

		List<WebElement> captchaCheckbox = driver.findElements(By.xpath("//div[@class='recaptcha-checkbox-border']"));

		if(!captchaCheckbox.isEmpty()) {

			if(CaptchaCheckbox.isDisplayed()) {
				CaptchaCheckbox.click();
			}
		}
	}

	public void enterEmail(String email) {

		Helper.waitForPageLoad(driver);
		CommonActions.waitForElement(EmailLogin);
		if(EmailLogin.isDisplayed()){
			EmailLogin.sendKeys(email);
		}
		else{
			System.out.println("Email page is not showing");
		}
	}

	public void clickContinue() {

		CommonActions.waitForElement(ContinueBtn);
		CommonActions.waitForClickablility(ContinueBtn,5);
		if(ContinueBtn.isEnabled()) {
			ContinueBtn.click();
		}
	}

	public void enterPassword(String password) throws InterruptedException {

		CommonActions.waitForElement(Password);
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
		if(Password.isDisplayed()){
			Password.click();
			Password.sendKeys(password, Keys.ENTER);
			
			Helper.waitForPageLoad(driver);						
			
			/**
			* ////driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			* //showHidePassword();
			* ////enterInPhoneForm();
			* ////Helper.waitForPageLoad(driver);
			* ////enterPhoneCode();
			* ////getTextAfterLogin();
			*/
		}
	}

	public void showHidePassword() throws InterruptedException {
		Thread.sleep(1000);
		CommonActions.waitForElement(ShowPassword);
		if(ShowPassword.isDisplayed()) {
			ShowPassword.click();
		}
		Thread.sleep(1000);
		CommonActions.waitForElement(HidePassword);
		if(HidePassword.isDisplayed()) {
			HidePassword.click();
		}
		Thread.sleep(1000);
	}
	
	
	public boolean isPresentAndDisplayed(final WebElement element) {
			
		try {
		    return element.isDisplayed() && element.isEnabled();
		  } catch (NoSuchElementException e) {
		    return false;
		  }
		
		}
	
//	public boolean isDisplayedElement() {
//        return this.checkDisplayedElement(true);
//    }
    
	
//    private boolean checkDisplayedElement(final boolean logAction) {
//        boolean clickable = false;
//        if ((Se.suppressOnStaleElement())) {
//            int i = 0;
//            while (i < 10) {
//                try {
//                    clickable = this.isDisplayedElement();
//                    break;
//                }
//                catch (StaleElementReferenceException sere) {
//                    System.out.println("stale element exception caught and suppressed");
//                    //this.sleep(500L);
//                    ++i;
//                }
//            }
//        }
//        else {
//            clickable = this.isDisplayedElement();
//        }
//        return clickable;
//    }
	
    public void isElementVisible(WebElement webElement, int timeOut) {
        try {
          WebDriverWait wait = new WebDriverWait(driver, timeOut);
          
        } catch (org.openqa.selenium.NoSuchElementException e) {
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        }
      }
    
	public void usePasswordInstead() throws InterruptedException {
			    
	    List<WebElement> listOfElements = driver.findElements(By.xpath("//*[text()='Use Password Instead']"));
	    int numberOfElementsFound = listOfElements.size();
	    if(numberOfElementsFound == 1)
	    {
	    	UsePassword.click();
	    }
	    
//	    else
//	    {
//	    
//	    }
			
	}

//	public boolean isDisplayed1() {
//        return this.checkDisplayed(true);
//    }
//    
	
//    private boolean checkDisplayed(final boolean logAction) {
//        boolean clickable = false;
//        if ((Se.suppressOnStaleElement())) {
//            int i = 0;
//            while (i < 10) {
//                try {
//                    clickable = this.isDisplayed1();
//                    break;
//                }
//                catch (StaleElementReferenceException sere) {
//                    System.out.println("stale element exception caught and suppressed");
//                    //this.sleep(500L);
//                    ++i;
//                }
//            }
//        }
//        else {
//            clickable = this.isDisplayed1();
//        }
//        return clickable;
//    }
	
    
	public void enterInPhoneForm() throws InterruptedException {

		List<WebElement> phoneForm = driver.findElements(By.id("phone-form-control"));
		if(!phoneForm.isEmpty()){
			if(PhoneForm.isDisplayed()){
				//PhoneForm.click();
				PhoneForm.sendKeys(Keys.BACK_SPACE, "923349683993", Keys.ENTER);

			}
		}
	}

	public void enterPhoneCode() throws InterruptedException {

		List<WebElement> phoneCode = driver.findElements(By.xpath("//*[@name='field-1']"));
		if(!phoneCode.isEmpty()){
			if(PhoneCode.isDisplayed()){

				PhoneCode.sendKeys("123456", Keys.ENTER);

			}
		}
	}


	public static void clickExpandBtn() {

		CommonActions.waitForElement(ExpandBtn);
		if(ExpandBtn.isEnabled()) {
			ExpandBtn.click();
		}
	}

	public void wrongPassword(String email, String password) throws InterruptedException {

		enterEmail(email);				
		clickContinue();
		CommonActions.waitForPageLoad();		
		try {
			usePasswordInstead();	
			
			}	
			catch(NoSuchElementException e){
				System.out.println("No password instead option");
			}		
		enterWrongPassword();
		Helper.waitForPageLoad(driver);
		enterPassword(password);
		Helper.waitForPageLoad(driver);

	}

	public void enterWrongPassword() throws InterruptedException {

		CommonActions.waitForElement(Password);
		if(Password.isDisplayed()){
			Password.click();
			Password.sendKeys("1111111", Keys.ENTER);
			CommonActions.waitForPageLoad();
			Helper.waitForPageLoad(driver);
			CommonActions.waitForElementToDisappear(IncorrectPasswordMsg);
			CommonActions.waitForPageLoad();
			Password.click();

			Actions act = new Actions(driver);
			act.doubleClick(Password).perform();
			Password.sendKeys(Keys.BACK_SPACE);
			//Thread.sleep(2000);

			CommonActions.waitForPageLoad();


		}
	}

	public void signInViaMagicLink(String email) throws InterruptedException {

		Helper.waitForPageLoad(driver);

		enterEmail(email);				
		clickContinue();
		
		CommonActions.waitForPageLoad();
		verifyMagicLinkSent();

		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window

		driver.get("https://yopmail.com/en/wm");			
		//EmailForCode.sendKeys(GlobalVariables.AutoEmail);
		EmailForCode.sendKeys(email);
		CheckEmailBtn.click();
		
		driver.switchTo().frame("ifinbox");
		PackageXReceiveEmail.click();
		driver.switchTo().defaultContent();
		
		//clickCapchaCheckbox();
		driver.switchTo().frame("ifmail");
		SignIntoReceiveAccount.click();
		driver.close();			

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){

			driver.switchTo().window(winHandle);
		}
	}

	public void signInViaMagicLinkUAT(String email) throws InterruptedException {


		Helper.waitForPageLoad(driver);

		enterEmail(email);				
		clickContinue();
		
		CommonActions.waitForPageLoad();
		verifyMagicLinkSent();

		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window

		driver.get("https://yopmail.com/en/wm");			
		EmailForCode.sendKeys(email);
		CheckEmailBtn.click();
		
		driver.switchTo().frame("ifinbox");
		PackageXReceiveEmail.click();
		driver.switchTo().defaultContent();
		
		//clickCapchaCheckbox();
		driver.switchTo().frame("ifmail");
		SignIntoReceiveAccount.click();
		driver.close();			

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){

			driver.switchTo().window(winHandle);
		}
	}
	
	public void signInViaMagicLink2(String email) throws InterruptedException {


		Helper.waitForPageLoad(driver);

		enterEmail(email);				
		clickContinue();
		
		CommonActions.waitForPageLoad();
		verifyMagicLinkSent();

		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window

		//driver.get("https://outlook.live.com/owa/");
		driver.get("https://outlook.office365.com/mail/");
		//driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("QAAutomation@packagex.io", Keys.ENTER);
		Waits.waitTime(2);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Tug71239", Keys.ENTER);
		//EmailForCode.sendKeys("muhammad.mujahid@packagex.io");
		//CheckEmailBtn.click();
		
		driver.switchTo().frame("ifinbox");
		PackageXReceiveEmail.click();
		driver.switchTo().defaultContent();
		
		//clickCapchaCheckbox();
		driver.switchTo().frame("ifmail");
		SignIntoReceiveAccount.click();
		driver.close();			

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){

			driver.switchTo().window(winHandle);
		}
	}
	
	
	
	public void verifyMagicLinkSent() {

		List<WebElement> magicLink = driver.findElements(By.xpath("//h3[text()='Magic Link Sent']"));
		if(!magicLink.isEmpty()){
			CommonActions.waitForElement(MagicLinkSent);
			if(MagicLinkSent.isDisplayed()) {

				assertEquals(MagicLinkSent.getText(), "Magic Link Sent");
				System.out.println("Magic link sent");
			}
		}

		else {
			System.out.println("Magic link is not enabled");
			driver.close();
		}
	}

	public void getTextAfterLogin() {
		
		CommonActions.waitForElement(Dashboard);
		String text= Dashboard.getText();
		System.out.println("PackageX Receive "+ text);
	}

	public void loginNegative(String email, String password) throws InterruptedException {

		enterInvalidEmail();
		checkInvalidID();
		enterEmail(email);				
		clickContinue();
		CommonActions.waitForPageLoad();		
		try {
			usePasswordInstead();	
			
			}	
			catch(NoSuchElementException e){
				System.out.println("No password instead option");
			}		
		enterWrongPassword();
		Helper.waitForPageLoad(driver);
		enterPassword(password);
		Helper.waitForPageLoad(driver);
	}

	public void enterInvalidEmail() throws InterruptedException  {

		CommonActions.waitForElement(EmailLogin);
		if(EmailLogin.isDisplayed()){
			EmailLogin.click();
			EmailLogin.sendKeys("abcdef123", Keys.ENTER);
			Thread.sleep(1000);
			CommonActions.waitForPageLoad();
			Helper.waitForPageLoad(driver);

			CommonActions.focusElementJs(driver, ContinueBtn);
			ContinueBtn.click();
			Thread.sleep(1000);
			EmailLogin.click();

			doubleClickEmailAndBackSpace();
			//Thread.sleep(2000);

			CommonActions.waitForPageLoad();
		}
	}

	public void checkInvalidID() throws InterruptedException {

		EmailLogin.click();
		EmailLogin.sendKeys("aaaaaaaaaaaa@yopmail.com", Keys.ENTER);
		CommonActions.waitForElement(IDNotExistMsg);
		assertEquals( IDNotExistMsg.getText() , "The user ID you entered does not exist in our system.");
		
		selectAllAndRemove();
		
		/*
		doubleClickEmailAndBackSpace();
		doubleClickEmailAndBackSpace();
		doubleClickEmailAndBackSpace();
		doubleClickEmailAndBackSpace();
		doubleClickEmailAndBackSpace();
		*/

		CommonActions.waitForPageLoad();
	}

	public void doubleClickEmailAndBackSpace() {

		Actions act = new Actions(driver);
		act.doubleClick(EmailLogin).perform();
		EmailLogin.sendKeys(Keys.BACK_SPACE);
	}

	public void selectAllAndRemove() {
		
		CommonActions.waitForElement(EmailLogin);
		EmailLogin.click();
		EmailLogin.sendKeys(Keys.chord(Keys.CONTROL, "a"+ Keys.BACK_SPACE));
	}

	public void loginInstead() {

		List<WebElement> loginInstead = driver.findElements(By.id("login-link"));

		if(!loginInstead.isEmpty()){
			if(LoginInstead.isDisplayed()){

				CommonActions.focusElementJs(driver, LoginInstead);
				LoginInstead.click();
			}
		}		
	}
	
	public void globalSearch() {
		
		searchRecipientGS();
		searchGroupGS();
		searchLocationGS();
		searchUserGS();
	}
	
	public void searchLocationGS() {
		
		CommonActions.waitForElement(SearchBar_ddlDashBoard);
		SearchBar_ddlDashBoard.click();
		CommonActions.focusElementJs(driver, SearchBar_ddlBox);
		SelectLocation.click();
		
		//Waits.waitTime(5);
		CommonActions.waitForElement(SearchBarDashBoard);
		SearchBarDashBoard.click();
		
		//String location = "10th Ave";
		//SearchBarDashBoard.sendKeys("10th Ave");
		SearchBarDashBoard.sendKeys("Automation");
		//CommonActions.waitForElement(EnteredLocation);
		SelectLocationFrom_Searched_ddl.click();
		//SearchBar_ddl.sendKeys(Keys.DOWN, Keys.ENTER);
		CommonActions.waitLogoInvisible();
		Waits.waitTime(3);
	}
	
	public void searchRecipientGS() {
		
		CommonActions.waitForElement(SearchBar_ddlDashBoard);
		SearchBar_ddlDashBoard.click();
		CommonActions.focusElementJs(driver, SearchBar_ddlBox);
		SelectRecipient.click();
		
		CommonActions.waitForElement(SearchBarDashBoard);
		SearchBarDashBoard.click();
		//SearchBarDashBoard.sendKeys("Abc Test");
		SearchBarDashBoard.sendKeys("Automation");
		Waits.waitTime(2);
		CommonActions.waitForElement(SelectRecipientFrom_Searched_ddl);
		SelectRecipientFrom_Searched_ddl.click();
		CommonActions.waitLogoInvisible();
		Waits.waitTime(3);
	}
	
	public void searchGroupGS() {

		CommonActions.waitForElement(SearchBar_ddlDashBoard);
		SearchBar_ddlDashBoard.click();
		CommonActions.focusElementJs(driver, SearchBar_ddlBox);
		SelectGroup.click();
		
		CommonActions.waitForElement(SearchBarDashBoard);
		SearchBarDashBoard.click();
		//SearchBarDashBoard.sendKeys("Abc Test");
		SearchBarDashBoard.sendKeys("Automation");
		CommonActions.waitForElement(SelectGroupFrom_Searched_ddl);
		SelectGroupFrom_Searched_ddl.click();
		CommonActions.waitLogoInvisible();
		Waits.waitTime(3);
	}
	
	public void searchUserGS() {

		CommonActions.waitForElement(SearchBar_ddlDashBoard);
		SearchBar_ddlDashBoard.click();
		//Waits.waitTime(2);
		CommonActions.focusElementJs(driver, SearchBar_ddlBox);
		SelectUser.click();
		
		CommonActions.waitForElement(SearchBarDashBoard);
		SearchBarDashBoard.click();
		//SearchBarDashBoard.sendKeys("Abc Test");
		SearchBarDashBoard.sendKeys("Automation");
		CommonActions.waitForElement(SelectUserFrom_Searched_ddl);
		SelectUserFrom_Searched_ddl.click();
		CommonActions.waitLogoInvisible();
		Waits.waitTime(3);
	}
	
	public void selectLocationFromSearch() {
		
		//Waits.waitTime(5);
		CommonActions.waitForElement(SearchBar_ddlDashBoard);
		SearchBar_ddlDashBoard.click();
		Waits.waitTime(2);
		CommonActions.focusElementJs(driver, SearchBar_ddlBox);
		SelectLocation.click();
		
		//SearchBar_ddlBox.sendKeys(Keys.DOWN, Keys.DOWN, Keys.ENTER);
	}

}
