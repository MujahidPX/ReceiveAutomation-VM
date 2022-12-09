package Utilities;
//import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.beust.jcommander.internal.Nullable;

import BaseClasses.DriverBaseClass;
import Login.LoginPage;
//import se.baselib.web.SeWebElement;
//import se.Se;
//import java.util.concurrent.TimeUnit;


public class CommonActions {

	static WebDriverWait wait;
	static WebDriver driver;
	LoginPage loginPage;

	public CommonActions(WebDriver driver, WebDriverWait wait) {
		this.wait = wait;
		this.driver = driver;
	}


	@Parameters("url")
	public void navigateToUrl(String url) throws InterruptedException {
		
		/*
		if(url.equalsIgnoreCase("https://qa.portal.packagex.xyz/login")){

		System.out.println("Go to: " + url);
		driver.get(GlobalVariables.host);
		
		Helper.waitForPageLoad(driver);
		System.out.println("URL Started: " + url);
		 }
		
		else if (url.equalsIgnoreCase("https://uat.portal.packagex.xyz/login")){
			
            System.out.println("Go to: " + url);
            driver.get(GlobalVariables.host2);
            Helper.waitForPageLoad(driver);
            System.out.println("URL Started: " + url);
        }
		*/
		
		//Helper.waitForPageLoad(driver);		
		//System.out.println("URL Started: " + url);
		
		
				System.out.println("Go to: " + url);
				//driver.get(GlobalVariables.host);
				driver.get(url);
				Helper.waitForPageLoad(driver);
				Helper.waitForPageLoad(driver);
				System.out.println("URL Started: " + url);
				
				driver.switchTo().defaultContent();
				

	}

	public void WaitForURLLoad(){
		Helper.waitForPageLoad(driver);
	}

	public static void waitForLoad(WebDriver driver) {
		ExpectedCondition<Boolean> pageLoadCondition = new
				ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
			}
		};
		//WebDriverWait wait = new WebDriverWait(driver, 30);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(pageLoadCondition);
		}

	
	public static void mouseHover(WebElement element){
		
		//WebElement elementVisible = Waits.waitVisibilityOfElement(wait, element);
		//Actions action = new Actions(driver);
		//wait.until(ExpectedConditions.elementToBeClickable(element));
		//action.moveToElement(element).perform();
		//((Actions) element).moveByOffset(5, 5);
		
		
		// Create an object of actions class and pass reference of WebDriver as a parameter to its constructor. 
		   Actions actions = new Actions(driver); 
 
		   actions.moveToElement(element); 
		   actions.clickAndHold(); 
		   
		   actions.moveToElement(element); 
		   actions.release().perform(); 
	}

	
//	public static WebElement waitForClickablility(By locator, int timeout) {
//	    WebDriverWait wait = new WebDriverWait(driver, timeout);
//	    return wait.until(ExpectedConditions.elementToBeClickable(locator));
//	}
	
	public static WebElement waitForClickablility(WebElement element, int timeout) {
	    WebDriverWait wait = new WebDriverWait(driver, timeout);
	    return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static boolean isEnabled(WebElement element) {
		return element.isEnabled();
	}


	public static boolean isElementPresent(WebElement element) {
		try 
		{
			driver.findElement((By) element);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public static boolean isElementVisible(By by) {
		if (driver.findElement(by).isDisplayed() || driver.findElement(by).isEnabled())
		{
			driver.findElement( by);
			return true;
		}
		else
		{
			return false;
		}
	}

	public static void clickElementJs(WebDriver driver, WebElement element) {
		try {
			JavascriptExecutor e = (JavascriptExecutor) driver;
			Helper.highlight(driver, element);
			e.executeScript("arguments[0].click();", element);
		} catch (Exception var3) {
			Assert.fail("can not click element invisible " + var3.getMessage());
		}
	}

	public static void focusElementJs(WebDriver driver, WebElement element) {
		try {
			JavascriptExecutor e = (JavascriptExecutor) driver;
			Helper.highlight(driver, element);
			e.executeScript("arguments[0].focus();", element);
		} catch (Exception e) {

		}
	}

	public void sendKeysToWebElement(WebElement element, String text) throws InterruptedException {
		WebElement elementVisible = Waits.waitVisibilityOfElement(wait, element);
		try {
			focusElementJs(driver, elementVisible);
			elementVisible.sendKeys(text);
		} catch (Exception e) {

		}
	}

	/**
	 * Check if the element that receive as a parameter
	 *  @param elementToVerify
	 * @param errorMessage
	 * @param AuxMethods
	 */

	public void checkVisibilityOfELement(WebElement elementToVerify, String errorMessage, Helper AuxMethods) throws InterruptedException {
		WebElement elementVisible = Waits.waitVisibilityOfElement(wait, elementToVerify);
		if (elementVisible == null) {
			Assert.fail(errorMessage);
		} else {
			highLightElement(elementVisible, AuxMethods);
		}
	}
	

	public static void isElementVisible(WebElement elementToVerify, Helper AuxMethods) throws InterruptedException {
		WebElement elementVisible = Waits.waitVisibilityOfElement(wait, elementToVerify);
		if (elementVisible == null) {
			Assert.fail();
		} else {
			//highLightElement(elementVisible, AuxMethods);
			System.out.println("Element is visible");
		}
	}

	public boolean checkVisibilityOfElement(WebElement elementToVerify) throws InterruptedException {
		WebElement elementVisible = Waits.waitVisibilityOfElement(wait, elementToVerify);
		return elementVisible != null;
	}

	public boolean checkVisibilityOfElements(List<WebElement> elementsToVerify) throws InterruptedException {
		return Waits.waitVisibilityOfTwoElements(wait, elementsToVerify.get(0), elementsToVerify.get(1));
	}

	public static void tabKey() {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).perform();
	}

	public static void enterKey() {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}

	public static void escKey() {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ESCAPE).perform();
	}

	public static void openNewTab() {

		String originalWindow;
		originalWindow = driver.getWindowHandle();		
		driver.switchTo().newWindow(WindowType.TAB);
	}

	public static void waitForElement(WebElement elementToWaitFor) {

		// WebDriverWait wait = new WebDriverWait(driver, 40);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(elementToWaitFor));

	}
	
	

	public static boolean isClickable(WebElement elementToWaitFor) {

		try 
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.elementToBeClickable(elementToWaitFor));
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}



//	public static boolean isDisplayedElement() {
//		return checkDisplayed(true);
//	}


//	private static boolean checkDisplayed(final boolean logAction) {
//		boolean clickable = false;
//		if ((Se.suppressOnStaleElement())) {
//			int i = 0;
//			while (i < 3) {
//				try {
//					clickable = isDisplayedElement();
//					break;
//				}
//				catch (StaleElementReferenceException sere) {
//					System.out.println("stale element exception caught and suppressed");
//					//this.sleep(500L);
//					++i;
//				}
//			}
//		}
//		else {
//			clickable = isDisplayedElement();
//		}
//		return clickable;
//	}

	
	 public static void waitForPageToLoad(long timeOutInSeconds) {
	     ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
	         public Boolean apply(WebDriver driver) {
	             return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
	         }
	     };
	     try {
	         WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
	         wait.until(expectation);
	     } catch (Throwable error) {
	         error.printStackTrace();
	     }
	 }


	public static void waitForElementClickable(WebElement elementToWaitFor) {

		new WebDriverWait(driver, Duration.ofSeconds(15)).until(
				driver -> ExpectedConditions.elementToBeClickable(elementToWaitFor).apply(driver));
		//driver -> ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()='Group added successfully.']")).apply(driver));
	}

	public static void waitForElementToDisappear(WebElement elementToWaitFor) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfAllElements(elementToWaitFor));

	}

	public static void waitLogoInvisible() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='ant-spin ant-spin-spinning']")));
	}
	
	public static void waitProgressBarInvisible() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@role='progressbar']")));
	}

	public static void waitLoadingIconInvisible() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@aria-label='loading']")));
	}

	public static void clickOn(WebDriver driver, WebElement locator, int timeout)
	{
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();

	}

	public static void visibility() {

		WebDriverWait wait = new WebDriverWait(driver, 120); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("<Element path>"))); 
	}

	public static void waitForVisible(WebElement elementToWaitFor) {

		new WebDriverWait(driver, Duration.ofSeconds(15)).until(
				driver -> ExpectedConditions.visibilityOfAllElements(elementToWaitFor).apply(driver));
	}

	public static void waitForInvisible(WebElement elementToWaitFor) {

		new WebDriverWait(driver, Duration.ofSeconds(15)).until(
				driver -> ExpectedConditions.invisibilityOfAllElements(elementToWaitFor).apply(driver));
	}

	public static void moveToElement(WebElement element) {

		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
		//actions.moveToElement(element).perform();

	}

	public static void clickAndHold(WebElement element) {

		Actions actions = new Actions(driver);
		actions.clickAndHold().perform();
	}


	public static void scrollIntoView(WebElement element) {
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", element);

	}

	public static void waitForElement1(By by){

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}	

	/**
	 * Highlight a element when is present on the page.
	 *
	 * @param elementToVerify
	 * @param AuxMethods
	 * @throws InterruptedException
	 */

	public void highLightElement(WebElement elementToVerify, Helper AuxMethods) throws InterruptedException {
		AuxMethods.highlight(driver, elementToVerify);
		Thread.sleep(500);
	}
	public static void waitForPageLoad() throws InterruptedException {
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//Thread.sleep(30000);
		Helper.waitForPageLoad(driver);
	}

	/**
	 * Select an specific option from drop-down list that is received as a parameter.
	 *
	 * @param select
	 */

	private void selectSpecificOption(WebElement select, String text) {
		try {
			WebElement currentSelect = Waits.waitVisibilityOfElement(wait, select);
			Select dropdown = new Select(select);
			String valueOfOption = "";
			currentSelect.click();
			List<WebElement> options = currentSelect.findElements(By.xpath("option"));
			for (int i = 0; i < options.size(); ++i) {
				valueOfOption = (options.get(i)).getText();
				if (valueOfOption.trim().equalsIgnoreCase(text)) {
					WebElement elementToSelect = options.get(i);
					elementToSelect.click();
					dropdown.selectByVisibleText(text);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String selectDropdownOption(WebElement select, String text) {
		try {
			Select dropdown = new Select(select);
			dropdown.selectByVisibleText(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}

	/**
	 * Selects a specific option from drop-down list that contains the value sent as a parameter.
	 * @param select WebElement The select web element.
	 * @param containedText String The value to search on select options.
	 */
	public void selectOptionThatContains(WebElement select, String containedText) {
		try {
			WebElement currentSelect = Waits.waitVisibilityOfElement(wait, select);
			Select dropdown = new Select(select);
			String valueOfOption = "";
			currentSelect.click();
			List<WebElement> options = currentSelect.findElements(By.xpath("option"));

			for (int i = 0; i < options.size(); ++i) {
				valueOfOption = (options.get(i)).getText();
				if (valueOfOption.trim().toLowerCase().contains(containedText.toLowerCase()))
					dropdown.selectByVisibleText(valueOfOption);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Select a random option of the select that receive as a parameter.
	 *
	 * @param select
	 */
	private  String selectRandomOptionDropDown(WebElement select) {
		String nameOfOption = "";
		try {
			Random rand = new Random();
			WebElement currentSelect = Waits.waitVisibilityOfElement(wait, select);
			Select dropdown = new Select(select);
			currentSelect.click();
			List<WebElement> options = currentSelect.findElements(By.xpath("option"));
			int optionNumber;
			if (options.size() > 0) {
				optionNumber = rand.nextInt(options.size());
				if(options.size() > 1)
					optionNumber = optionNumber == 0 ? 1 : optionNumber;
			} else {
				optionNumber = 1;
			}
			Waits.waitForElementToBeClickable(wait, options.get(optionNumber));
			WebElement elementToSelect = options.get(optionNumber);
			nameOfOption = elementToSelect.getText();
			elementToSelect.click();
			dropdown.selectByVisibleText(nameOfOption);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Fail: " + e.getMessage());
		}
		return nameOfOption;
	}

	/**
	 * Select an option for the make, model or trim selects.
	 * @param element
	 * @param value
	 * @return
	 */
	public String selectOption(WebElement element,  String value){
		if(!value.equalsIgnoreCase("random")){
			selectSpecificOption(element,value);
		}else{
			value = selectRandomOptionDropDown(element);
		}
		return value;
	}

	public static void clickElement(WebElement elementToClick) {
		WebElement element = Waits.waitForElementToBeClickable(wait, elementToClick);
		if (element != null) {

			elementToClick.click();

		} else {
			System.out.println("Error on click, element is not visible. " + elementToClick.toString());
			Assert.fail("Error on click, element is not visible. " + elementToClick.toString());
		}
	}

	public void waitForClickable(WebElement elementToWaitFor) {
		elementToWaitFor.click();
	}

	public void fillInput(WebElement elementToVerify, String value)  throws InterruptedException {

		WebElement elementVisible = Waits.waitVisibilityOfElement(wait, elementToVerify);
		if (elementVisible != null) {

			elementVisible.clear();
			elementVisible.sendKeys(value);
		} else {
			Assert.fail("The input that you are searching is not visible");
		}
	}

	public void clearSessionStorageJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.sessionStorage.clear();");
	}

	public void clearLocalStorageJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.localStorage.clear();");
	}

	public static boolean isElementPresent1(WebElement webElement) {
		try {
			driver.findElement((By) webElement);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}

	}


	public static void doubleClick(WebElement element) {

		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	public static boolean isInvisible(final WebElement element) {
		try {

			return !element.isDisplayed();
		}
		catch(StaleElementReferenceException ignored) {
			return true;

		}
	}

	public static void scrollDown() {

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
	}

	public void implicitWait() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}


	public static boolean isElementHiddenNow(WebElement id) {
		turnOffImplicitWaits();
		boolean result = ExpectedConditions.invisibilityOf((id)).apply(driver);
		turnOnImplicitWaits();
		return result;
	}

	public static boolean isElementShowNow(WebElement id) {
		turnOffImplicitWaits();
	    WebElement result = ExpectedConditions.visibilityOf((id)).apply(driver);
		turnOnImplicitWaits();
		//return result;
		return false;
	}

	private static void turnOffImplicitWaits() {
		//driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
	}

	private static void turnOnImplicitWaits() {
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	
	public static boolean isClickable(WebElement el, WebDriver driver) {
        try{
            WebDriverWait wait = new WebDriverWait(driver, 3);
            wait.until(ExpectedConditions.elementToBeClickable(el));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
	
	public static boolean isChecked(WebElement element) {
	    return (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].!checked", element);
	    
	}

	
	public static String toProperCase(final String s) {
		
		// Convert to "Proper case" ; capital first letter, lowercase suffix.
		return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
	}

}
