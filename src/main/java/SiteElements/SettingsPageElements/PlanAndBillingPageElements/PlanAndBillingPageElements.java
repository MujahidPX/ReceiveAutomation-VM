package SiteElements.SettingsPageElements.PlanAndBillingPageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlanAndBillingPageElements {

	WebDriver driver;

	@FindBy(xpath="//a[@aria-label='Settings']")
    protected WebElement SettingsTab;
	
	@FindBy(xpath="//header[text()='Plan and Billing']")
	protected WebElement PlanAndBilling;
	
	@FindBy(xpath="//button[text()='Change Plan']")
	protected WebElement ChangePlan;
	
	@FindBy(xpath="//button[text()='View Details']")
	protected WebElement ViewDetails;
	
	@FindBy(xpath="//button[text()='Subscribe']")
	protected WebElement Subscribe;
	
	
	@FindBy(xpath="//h5[text()='Payment Methods']/following::div/span[@aria-label='plus']")
	protected WebElement AddPaymentMethod;
	
	@FindBy(xpath="//span[@aria-label='credit-card']")
	protected WebElement AddCreditDebitCard;
	
	@FindBy(name="cardHolderName")
	protected WebElement CardHolderNametxt;
	
	@FindBy(xpath="//iframe[@title='Secure card number input frame']")
	protected WebElement CardNumberFrame;
	
	@FindBy(xpath="//input[@aria-label='Credit or debit card number']")
	protected WebElement CardNumbertxt;
	
	@FindBy(xpath="//iframe[@title='Secure expiration date input frame']")
	protected WebElement CardExpiryFrame;
	
	@FindBy(name="exp-date")
	protected WebElement CardExpiry;
	
	@FindBy(xpath="//iframe[@title='Secure CVC input frame']")
	protected WebElement CVCFrame;
	
	@FindBy(xpath="//input[@name='cvc']")
	protected WebElement CVC;
	
	@FindBy(xpath="//button[text()='Add Credit / Debit Card']")
	protected WebElement AddCreditDebitCardBtn;
	
	@FindBy(xpath="(//span[@aria-label='Delete Card'])[last()]")
	protected WebElement DeleteCardBtn;
	
	@FindBy(xpath="//button[text()='Delete']")
	protected WebElement DeleteBtn;
	
	@FindBy(xpath="(//span[@aria-label='Activate Card'])[last()]")
	protected WebElement ActivateCardBtn;
	
	@FindBy(xpath="//button[text()='Activate']")
	protected WebElement ActivateBtn;
	
	
	// Change Plan
	
	@FindBy(xpath="//span[text()='5,000']")
	protected WebElement Btn_5000;
	
	@FindBy(xpath="//span[text()='10,000']")
	protected WebElement Btn_10000;
	
	@FindBy(xpath="//span[text()='20,000']")
	protected WebElement Btn_20000;
	
	@FindBy(xpath="//span[text()='30,000']")
	protected WebElement Btn_30000;
	
	@FindBy(xpath="//span[text()='40,000']")
	protected WebElement Btn_40000;
	
	@FindBy(xpath="//span[text()='50,000']")
	protected WebElement Btn_50000;
	
	@FindBy(xpath="//span[text()='60,000']")
	protected WebElement Btn_60000;
	
	@FindBy(xpath="//span[text()='70,000']")
	protected WebElement Btn_70000;
	
	@FindBy(xpath="//span[text()='80,000']")
	protected WebElement Btn_80000;
	
	@FindBy(xpath="//span[text()='90,000']")
	protected WebElement Btn_90000;
	
	@FindBy(xpath="//span[text()='100,000']")
	protected WebElement Btn_100000;
	
	@FindBy(xpath="//p[text()='Monthly']")
	protected WebElement MonthlyBtn;
	
	@FindBy(xpath="//p[text()='Annually']")
	protected WebElement AnnuallyBtn;
	
	
	@FindBy(xpath="(//span[text()='Annual Deliveries']/strong)[1]")
	protected WebElement BasicAnnualDeliveries;
	
	@FindBy(xpath="(//span[text()='Annual Deliveries']/strong)[2]")
	protected WebElement PremiumAnnualDeliveries;
	
	@FindBy(xpath="(//span[text()='Annual Deliveries']/strong)[3]")
	protected WebElement EnterpriseAnnualDeliveries;
	
	@FindBy(xpath="//h5[text()='Basic']")
	protected WebElement BasicPlan;
	
	@FindBy(xpath="(//h5[text()='Basic']/following::h5)[1]")
	protected WebElement BasicAmount;
	
	@FindBy(xpath="//h5[text()='Premium']")
	protected WebElement PremiumPlan;
	
	@FindBy(xpath="(//h5[text()='Premium']/following::h5)[1]")
	protected WebElement PremiumAmount;
	
	@FindBy(xpath="//h5[text()='Enterprise']")
	protected WebElement EnterprisePlan;
	
	@FindBy(xpath="(//h5[text()='Enterprise']/following::h5)[1]")
	protected WebElement EnterpriseAmount;
	
	@FindBy(xpath="//button[text()='Contact Sales']")
	protected WebElement ContactSales;
	
	@FindBy(xpath="(//button[text()='Upgrade'])[1]")
	protected WebElement UpgradeBtn_Basic;
	
	@FindBy(xpath="(//button[text()='Upgrade'])[2]")
	protected WebElement UpgradeBtn_Premium ;
	
	@FindBy(xpath="(//button[text()='Upgrade'])[3]")
	protected WebElement UpgradeBtn_Enterprize;
	
	@FindBy(xpath="//button[text()='Downgrade']")
	protected WebElement DowngradeBtn;
	
	@FindBy(xpath="//h5[contains(text(),'Upgrade to')]")
	protected WebElement UpgradeTo_PlanName;
	
	@FindBy(xpath="//p[text()='Co-Branded Notifications']")
	protected WebElement CoBrandedNotifications;
	
	@FindBy(xpath="//p[text()='Custom Item Labels & Storage Locations']")
	protected WebElement CustomItemLabels;
	
	@FindBy(xpath="//p[text()='Receive Connect']")
	protected WebElement ReceiveConnect;
	
	@FindBy(xpath="//p[text()='API & Webhooks']")
	protected WebElement APIAndWebhooks;
	
	@FindBy(xpath="//p[text()='Internal Label Printing']")
	protected WebElement InternalLabelPrinting;
	
	@FindBy(xpath="(//button[text()='Upgrade'])[3]")
	protected WebElement UpgradeBtn_Popup;
			
	@FindBy(xpath="(//button[text()='Downgrade'])[2]")
	protected WebElement DowngradeBtn_Popup;
	
	@FindBy(xpath="//span[text()='Price per location']/following::strong[text()='USD '][1]")
	protected WebElement PricePerLocation;
	
	@FindBy(xpath="//strong[text()='Total Price']/following::strong[text()='USD ']")
	protected WebElement TotalPrice;
	
	
	//@FindBy(xpath="//span[@aria-label='check-circle' and @style='color: rgb(54, 179, 126); font-size: 1.25rem;']/following::span[1][text()='Receive Connect']")
	//protected WebElement ReceiveConnect_Selected;
	
	@FindBy(xpath="//span[text()='Your Plan']/following::span[@aria-label='check-circle' and @style='color: rgb(54, 179, 126); font-size: 1.25rem;']/following::span[1][text()='Receive Connect']")
	protected WebElement ReceiveConnect_Selected;
	
	@FindBy(xpath="//span[@aria-label='check-circle' and @style='color: rgb(54, 179, 126); font-size: 1.25rem;']/following::span[text()='Receive Connect']")
	protected WebElement ReceiveConnect_AddedInPlan;
	
	//@FindBy(xpath="//span[text()='Basic']")
	@FindBy(xpath="//h5[text()='Your Plan']/following::div[1]/span")
	protected WebElement Plan_NameOuter;
	
	//@FindBy(xpath="//span[text()='Basic']/following::span/span/b[text()='Basic']")
	@FindBy(xpath="//h5[text()='Your Plan']/following::span[3]/b[2]")
	protected WebElement Plan_NameInner;
	
	@FindBy(xpath="//h5[text()='Your Plan']/following::span[3]/b[4]")
	protected WebElement Plan_TotalPrice;
	
	
	@FindBy(xpath="//div[text()='Contract Terms']")
	protected WebElement ContractTerms;
	
	//@FindBy(xpath="//input[@type='checkbox']")
	@FindBy(xpath="//p[text()=' privacy policy and contract terms.']")
	protected WebElement AgreePrivacyPolicy_chkBox;
	
	@FindBy(xpath="//button[text()='Pay']")
	protected WebElement PayBtn;
	
	@FindBy(xpath="//h6[contains(text(),'$')]")
	protected WebElement TotalPrice_Checkout;
	
}
