package SignUp;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Login.LoginPage;
import SiteElements.SignUpPageElements.SignUpPageElements;
import Utilities.CommonActions;
import Utilities.Waits;

public class SignUpPage extends SignUpPageElements{

	private static WebDriver driver;
	private WebDriverWait wait;
	private CommonActions commonActions;

	
	public SignUpPage(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
		commonActions = new CommonActions(driver, wait);
		PageFactory.initElements(driver, this);
	}
	
	public void signUp(String email, String password) {
		
		CommonActions.waitForElement(CreateAnAccount);
		CreateAnAccount.click();
		
		CommonActions.waitForElement(FirstName);
		FirstName.click();
		FirstName.sendKeys("fn");
		
		CommonActions.waitForElement(LastName);
		LastName.click();
		LastName.sendKeys("ln");
		
		CommonActions.waitForElement(Email);
		Email.click();
		Email.sendKeys("automation555@yopmail.com");
		
		CommonActions.waitForElement(CompanyName);
		CompanyName.click();
		CompanyName.sendKeys("Vx");
		
		CommonActions.waitForElement(Phone);
		Phone.click();
		Phone.sendKeys("7023215468");
		
		//CommonActions.waitForElement(TermsOfService_chkBox);
		CommonActions.focusElementJs(driver, TermsOfService_chkBox);
		TermsOfService_chkBox.click();
		
		CommonActions.waitForElement(Capcha_TglBtn);
		Capcha_TglBtn.click();
		
		CommonActions.waitForElement(ContinueBtn);
		ContinueBtn.click();
		Waits.waitTime(2);
		
		CommonActions.waitForElement(UserAlreadyRegdMsg);
		assertEquals( UserAlreadyRegdMsg.getText() , "A user is already registered with this Email");
		
		CommonActions.waitForElement(Email);
		Email.click();
		Email.sendKeys(Keys.chord(Keys.CONTROL, "a"+ Keys.BACK_SPACE));
		Email.sendKeys(email);
		System.out.println(email);
		
		if(ContinueBtn.isEnabled()) {
			ContinueBtn.click();
		}
		
		
		//LoginPage.switchToNewWindowAndGetEmailCode();
		switchToNewWindowAndGetEmailCode(email, password);
		//Waits.waitTime(3);
		clickNextBtn();
		clickNextBtn();
		clickNextBtn();
		clickNextBtn();
		clickSkipBtn();
		clickSkipBtnTutorial();
	}
	
	public void switchToNewWindowAndGetEmailCode(String email, String password){
		
		Waits.waitTime(3);
		String originalWindow = driver.getWindowHandle();
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://yopmail.com/en/wm");			
		LoginPage.EmailForCode.sendKeys(email);
		LoginPage.CheckEmailBtn.click();

		driver.switchTo().frame("ifinbox");
		LoginPage.PackageXReceiveEmail.click();
		driver.switchTo().defaultContent();
		//clickCapchaCheckbox();

		driver.switchTo().frame("ifmail");
		//LoginPage.CompleteSignUpBtn.click();
		
		String emailCode = LoginPage.OneTimePassword.getText();
		System.out.println("Temporary Email Code : " + emailCode);
		driver.switchTo().defaultContent();
		driver.close();
		driver.switchTo().window(originalWindow);

//		if(ContinueBtn.isEnabled()) {
//			ContinueBtn.click();
//		}

		Waits.waitTime(3);
		if(LoginPage.TemporaryPassword.isDisplayed()) {

			LoginPage.TemporaryPassword.sendKeys(emailCode);
		}

		if(LoginPage.NewPassword.isDisplayed()) {

			LoginPage.NewPassword.sendKeys(password);
		}

		if(LoginPage.ConfirmPassword.isDisplayed()) {

			LoginPage.ConfirmPassword.sendKeys(password);
		}
		
		if(ContinueBtn.isEnabled()) {
			ContinueBtn.click();
		}
		
	}
	
	public void clickNextBtn() {
		
		Waits.waitTime(2);
		CommonActions.waitForElement(NextBtn);
		if(NextBtn.isDisplayed()) {
			NextBtn.click();
			//Waits.waitTime(2);
		}
	}
	
	public void clickSkipBtn() {

		CommonActions.waitForElement(SkipBtn);
		if(SkipBtn.isDisplayed()) {
			SkipBtn.click();
		}
	}
	
	public void clickSkipBtnTutorial() {

		CommonActions.waitForElement(SkipBtnTutorial);
		if(SkipBtnTutorial.isDisplayed()) {
			SkipBtnTutorial.click();
		}
	}
}
