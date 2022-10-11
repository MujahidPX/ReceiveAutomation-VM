package SiteElements;


//import java.util.List;
//import java.sql.Driver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SiteElements{
	WebDriver driver;
	
	/*
	
	//Home Page Elements
	//@FindBy(how = How.CSS, using = "#menu-header-menu > li:nth-child(5) > div > ul > li:nth-child(1) > a")
	//*[@id="menu-header-menu"]/li[1]/a
	@FindBy(how = How.XPATH, using = "//div[@class='text-center col-4']/p[1]")
	//#menu-header-menu > li:nth-child(5) > div > ul > li:nth-child(1) > a
	//@FindBy(how = How.CSS, using = "#menu-header-menu > li:nth-child(5) > div > ul > li:nth-child(1) > a")
	protected
	WebElement Price;

	@FindBy(how = How.XPATH, using = "//div[@class='text-center col-4']/p[1] ")
	protected
	WebElement Title;
	

	  
	 // List<WebElement> myList=driver.findElements(By.className("accordion-toggle"));

    //Create Account Page Elements
	//List<WebElement> elements = driver.findElements(By.xpath("//div[@class='text-center col-4']/p[1]"));

    @FindBy(how = How.CLASS_NAME, using = "text-center col-4")
    protected
    WebElement Container;
    

    @FindBy(how = How.CLASS_NAME, using = "SignInForm-signUpButton")
    protected
    WebElement CreateAccountButton;

    @FindBy (how = How.CLASS_NAME, using = "Profile-firstName")
    protected
    WebElement ProfileFirstNameField;

    @FindBy (how = How.CLASS_NAME, using = "Profile-lastName")
    protected
    WebElement ProfileLastNameField;

    @FindBy (how = How.CLASS_NAME, using = "Profile-email")
    protected
    WebElement ProfileEmailField;

    @FindBy (how = How.CSS, using = "input.PasswordField-password.no-tracking")
    protected
    WebElement ProfilePasswordField;

    @FindBy (how = How.CLASS_NAME, using = "Profile-signUpButton")
    protected
    WebElement ProfileCreateAccountButton;

    // Login Elements


    @FindBy (how = How.CLASS_NAME, using = "SignInForm-email")
    protected
    WebElement LoginEmail;



    @FindBy(how = How.CSS, using = "input.PasswordField-password.no-tracking")
    protected
    WebElement LoginPassword;

    @FindBy(how =  How.CLASS_NAME, using = "SignInForm-signInButton")
    protected
    WebElement LoginButton;


    //---------------//

    //Verify Email is not editable

    @FindBy(how = How.CSS, using = "div.Popup.CustomerPopup > a")
    protected
    WebElement AccountLoggedinIcon;

    @FindBy(how = How.CSS, using = "div.AccountMenu a.AccountMenu-link:nth-child(6) > span.AccountMenu-linkLabel")
    protected
    WebElement MyProfileLink;
    @FindBy(how = How.CLASS_NAME, using = "ProductNavigation-logo")
    protected
    WebElement Logo;

    //-------------------//

    //Search For any Term


    @FindBy(how = How.CLASS_NAME, using = "QuickSearch-v2-textBox")
    protected
    WebElement SearchBar;

    @FindBy(how = How.CSS, using = "div.QuickSearch-v2-resultsItem.QuickSearch-simpleListResults a.QuickSearch-v2-recentSearchItem:nth-child(2) > span.QuickSearch-v2-recentSearchItem-Text")
    protected
    WebElement SelectSearchOption;

    @FindBy(how = How.XPATH, using = "(//div[@class='Product-details'])[1]")
    protected
    WebElement FirstProduct;
    @FindBy(how = How.CLASS_NAME, using = "AddToBag")
    protected
    WebElement AddToBagButton;

    //-----------//

    */
    
    // Notification Pop up


    @FindBy(how = How.CSS, using = "div.wzrk-alert.wiz-show-animate")
    protected
    WebElement PopUp;

    @FindBy(how = How.ID, using = "wzrk-cancel")
    protected
    WebElement PopUpCancel;

    
    
    @FindBy(how = How.ID, using = "email")
	protected
	WebElement EmailLogin;
    
    @FindBy(id="submit-btn")
    protected WebElement ContinueBtn;
	
	@FindBy(how = How.ID, using="password")
	protected WebElement password1;
	
	@FindBy(xpath="(//*[text()='Dashboard'])[2]")
	protected WebElement Dashboard;

    //------------------//

    /*
     
    // CheckOut (Bag)

    @FindBy(how = How.CSS, using = "div.Popup.MiniCartPopup > a.Popup-iconLink")
    protected
    WebElement BagIcon;

    @FindBy(how = How.CLASS_NAME, using = "CartTotal-secureCheckout")
    protected
    WebElement SecureCheckOutButton;

    @FindBy(how = How.ID, using = "mobileNumber")
    protected
    WebElement PhoneNumber;

    @FindBy(how = How.CSS, using = "form.ShippingInformationForm section.NewAddress:nth-child(3) label.NewAddress-field:nth-child(6) > input.pac-target-input")
    protected
    WebElement AddressField;

    @FindBy(how = How.CSS, using = "#street")
    protected
    WebElement DeliveryField;

    @FindBy(how = How.CSS, using = "#additionalInformation")
    protected
    WebElement ApartmentField;

    @FindBy(how = How.CLASS_NAME, using = "ShippingInformationForm-submitButton")
    protected
    WebElement SubmittButton;

    //----------------------------

    // FaceBook Login

    @FindBy(how = How.CLASS_NAME, using = "SignInThirdpartyButtons-facebookButton")
    protected
    WebElement FBButton;

    @FindBy(how = How.ID, using = "email")
    protected
    WebElement FBEmail;

    @FindBy(how = How.ID, using = "pass")
    protected
    WebElement FBPassword;

    @FindBy(how = How.ID,using = "loginbutton")
    protected
    WebElement FBLoginButton;

    @FindBy(how = How.CSS, using = "button._42ft._4jy0.layerConfirm._1fm0._51_n.autofocus._4jy3._4jy1.selected._51sy")
    protected
    WebElement FBConfirmButton;


    //-----------------------------------------------------

    //Listing Page Objects

    @FindBy(how = How.CSS, using = "div.Product-contents")
    protected
    WebElement ProductLists;

    @FindBy(how = How.XPATH, using = "//label[@class='CheckboxLabel default designer'][13]")
    protected
    WebElement Filter;

    @FindBy(how = How.CSS, using = "a.Gender-desktop-link:nth-child(1)")
    protected
    WebElement WomenTile;

    @FindBy(how = How.CSS, using = "a.L2Category.L2Category-link:nth-child(4)")
    protected
    WebElement ClothingButton;

    @FindBy(how = How.CLASS_NAME, using = "Product-brand")
    protected
    WebElement FilterOnProductName;
    

    */
    
    // @FindBy(id="username")
    // private WebElement user_name;
    
    

}
