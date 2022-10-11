package Settings.PlanAndBilling;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Login.LoginPage;
import Recipients.RecipientsPage;
import Settings.AccountSettings.AccountSettingsPage;
import SiteElements.SiteActions;
import SiteElements.RecipientsPageElements.RecipientsPageElements;
import SiteElements.SettingsPageElements.PlanAndBillingPageElements.PlanAndBillingPageElements;
import Utilities.CommonActions;
import Utilities.Waits;

public class PlanAndBillingPage extends PlanAndBillingPageElements{

	private WebDriver driver;
	private WebDriverWait wait;
	private CommonActions commonActions;
	private LoginPage loginPage;
	//private AccountSettingsPage accountSettingsPage;
	
	
	public String nameVal;
	public String nameVal_1;
	public ArrayList<String> NV;
	public ArrayList<String> NV1;

	public PlanAndBillingPage (WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
		commonActions = new CommonActions(driver, wait);
		PageFactory.initElements(driver, this);
	}
	
	public void addPaymentMethod() {
		
		CommonActions.waitForElement(SettingsTab);
		SettingsTab.click();
		Waits.waitTime(2);
		SettingsTab.click();
		
		CommonActions.waitForElement(PlanAndBilling);
		PlanAndBilling.click();
		
		CommonActions.waitLogoInvisible();
		
		CommonActions.waitForElement(AddPaymentMethod);
		AddPaymentMethod.click();
		
		CommonActions.waitForElement(AddCreditDebitCard);
		AddCreditDebitCard.click();
		
		creditDebitCardDetails();
		
//		CommonActions.waitForElement(CardHolderNametxt);
//		CardHolderNametxt.click();
//		CardHolderNametxt.sendKeys("AutoUser");
//		
//		driver.switchTo().frame(CardNumberFrame);
//		CardNumbertxt.click();
//		CardNumbertxt.sendKeys("4111111111111111");
//		driver.switchTo().defaultContent();
//		
//		driver.switchTo().frame(CardExpiryFrame);
//		CardExpiry.click();
//		CardExpiry.sendKeys("1225");
//		driver.switchTo().defaultContent();
//		
//		driver.switchTo().frame(CVCFrame);
//		CVC.click();
//		CVC.sendKeys("123");
//		driver.switchTo().defaultContent();
		
		CommonActions.waitForElement(AddCreditDebitCardBtn);
		AddCreditDebitCardBtn.click();
		
		//CommonActions.waitProgressBarInvisible();
		Waits.waitTime(2);
		
		SiteActions.notification();
		assertEquals(RecipientsPageElements.SuccessMsgNotification.getText(), "Your card has been stored successfully.");
	    CommonActions.waitForElementToDisappear(RecipientsPageElements.NotificationMsg);
		
		deleteCard();
	}
	
	public void creditDebitCardDetails() {
		
		CommonActions.waitForElement(CardHolderNametxt);
		CardHolderNametxt.click();
		CardHolderNametxt.sendKeys("AutoUser");
		
		driver.switchTo().frame(CardNumberFrame);
		CardNumbertxt.click();
		CardNumbertxt.sendKeys("4111111111111111");
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(CardExpiryFrame);
		CardExpiry.click();
		CardExpiry.sendKeys("1225");
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(CVCFrame);
		CVC.click();
		CVC.sendKeys("123");
		driver.switchTo().defaultContent();
		
	}
	
	public void deleteCard() {
		
		CommonActions.mouseHover(DeleteCardBtn);
		DeleteCardBtn.click();
		
		CommonActions.waitForElement(DeleteBtn);
		DeleteBtn.click();
		
		//CommonActions.waitProgressBarInvisible();
		
		Waits.waitTime(3);
		
		SiteActions.notification_CP();
		assertEquals(RecipientsPageElements.SuccessMsgNotification.getText(), "Your card has been deleted successfully.");
	    CommonActions.waitForElementToDisappear(RecipientsPageElements.NotificationMsg);
		
	}
	
	public void estimatedAnnualDelivery() {
		
		CommonActions.waitForElement(SettingsTab);
		SettingsTab.click();
		Waits.waitTime(2);
		SettingsTab.click();
		
		CommonActions.waitForElement(PlanAndBilling);
		PlanAndBilling.click();
		CommonActions.waitLogoInvisible();
		
		CommonActions.waitForElement(ChangePlan);
		ChangePlan.click();
		CommonActions.waitLogoInvisible();
		
		CommonActions.waitForElement(Btn_10000);
		Btn_10000.click();
		String btn_10000 = Btn_10000.getText();
		String bad_10000 = BasicAnnualDeliveries.getText();
		Assert.assertEquals(btn_10000, bad_10000);
		String pad_10000 = PremiumAnnualDeliveries.getText();
		Assert.assertEquals(btn_10000, pad_10000);
		String ead_10000 = EnterpriseAnnualDeliveries.getText();
		Assert.assertEquals(btn_10000, ead_10000);
		System.out.println("[Estimmated Annual Delivery : " + btn_10000 + "]" + " [Basic : " + bad_10000 + "]"+ " [Premium : " + pad_10000 + "]" + " [Enterprize : " + ead_10000 + "]");
		String baa_10000 = BasicAmount.getText();
		String paa_10000 = PremiumAmount.getText();
		String eaa_10000 = EnterpriseAmount.getText();
		//System.out.println("[Annual Amount for 10,000 [Basic : " + baa_10000 + "]"+ " [Premium : " + paa_10000 + "]" + " [Enterprize : " + eaa_10000 + "]]");
		
		CommonActions.waitForElement(Btn_20000);
		Btn_20000.click();
		String btn_20000 = Btn_20000.getText();
		String bad_20000 = BasicAnnualDeliveries.getText();
		Assert.assertEquals(btn_20000, bad_20000);
		String pad_20000 = PremiumAnnualDeliveries.getText();
		Assert.assertEquals(btn_20000, pad_20000);
		String ead_20000 = EnterpriseAnnualDeliveries.getText();
		Assert.assertEquals(btn_20000, ead_20000);
		System.out.println("[Estimmated Annual Delivery : " + btn_20000 + "]" + " [Basic : " + bad_20000 + "]"+ " [Premium : " + pad_20000 + "]" + " [Enterprize : " + ead_20000 + "]");
		String baa_20000 = BasicAmount.getText();
		String paa_20000 = PremiumAmount.getText();
		String eaa_20000 = EnterpriseAmount.getText();
		Assert.assertNotEquals(baa_20000, baa_10000);
		Assert.assertNotEquals(paa_20000, paa_10000);
		Assert.assertNotEquals(eaa_20000, eaa_10000);
		//System.out.println("[Annual Amount for 20,000 [Basic : " + baa_20000 + "]"+ " [Premium : " + paa_20000 + "]" + " [Enterprize : " + eaa_20000 + "]]");
		
		CommonActions.waitForElement(Btn_30000);
		Btn_30000.click();
		String btn_30000 = Btn_30000.getText();
		String bad_30000 = BasicAnnualDeliveries.getText();
		Assert.assertEquals(btn_30000, bad_30000);
		String pad_30000 = PremiumAnnualDeliveries.getText();
		Assert.assertEquals(btn_30000, pad_30000);
		String ead_30000 = EnterpriseAnnualDeliveries.getText();
		Assert.assertEquals(btn_30000, ead_30000);
		System.out.println("[Estimmated Annual Delivery : " + btn_30000 + "]" + " [Basic : " + bad_30000 + "]"+ " [Premium : " + pad_30000 + "]" + " [Enterprize : " + ead_30000 + "]");
		String baa_30000 = BasicAmount.getText();
		String paa_30000 = PremiumAmount.getText();
		String eaa_30000 = EnterpriseAmount.getText();
		Assert.assertNotEquals(baa_30000, baa_20000);
		Assert.assertNotEquals(paa_30000, paa_20000);
		Assert.assertNotEquals(eaa_30000, eaa_20000);
		//System.out.println("[Annual Amount for 30,000 [Basic : " + baa_30000 + "]"+ " [Premium : " + paa_30000 + "]" + " [Enterprize : " + eaa_30000 + "]]");
		
		CommonActions.waitForElement(Btn_40000);
		Btn_40000.click();
		String btn_40000 = Btn_40000.getText();
		String bad_40000 = BasicAnnualDeliveries.getText();
		Assert.assertEquals(btn_40000, bad_40000);
		String pad_40000 = PremiumAnnualDeliveries.getText();
		Assert.assertEquals(btn_40000, pad_40000);
		String ead_40000 = EnterpriseAnnualDeliveries.getText();
		Assert.assertEquals(btn_40000, ead_40000);
		System.out.println("[Estimmated Annual Delivery : " + btn_40000 + "]" + " [Basic : " + bad_40000 + "]"+ " [Premium : " + pad_40000 + "]" + " [Enterprize : " + ead_40000 + "]");
		String baa_40000 = BasicAmount.getText();
		String paa_40000 = PremiumAmount.getText();
		String eaa_40000 = EnterpriseAmount.getText();
		Assert.assertNotEquals(baa_40000, baa_30000);
		Assert.assertNotEquals(paa_40000, paa_30000);
		Assert.assertNotEquals(eaa_40000, eaa_30000);
		//System.out.println("[Annual Amount for 40,000 [Basic : " + baa_40000 + "]"+ " [Premium : " + paa_40000 + "]" + " [Enterprize : " + eaa_40000 + "]]");
		
		CommonActions.waitForElement(Btn_50000);
		Btn_50000.click();
		String btn_50000 = Btn_50000.getText();
		String bad_50000 = BasicAnnualDeliveries.getText();
		Assert.assertEquals(btn_50000, bad_50000);
		String pad_50000 = PremiumAnnualDeliveries.getText();
		Assert.assertEquals(btn_50000, pad_50000);
		String ead_50000 = EnterpriseAnnualDeliveries.getText();
		Assert.assertEquals(btn_50000, ead_50000);
		System.out.println("[Estimmated Annual Delivery : " + btn_50000 + "]" + " [Basic : " + bad_50000 + "]"+ " [Premium : " + pad_50000 + "]" + " [Enterprize : " + ead_50000 + "]");
		String baa_50000 = BasicAmount.getText();
		String paa_50000 = PremiumAmount.getText();
		String eaa_50000 = EnterpriseAmount.getText();
		Assert.assertNotEquals(baa_50000, baa_40000);
		Assert.assertNotEquals(paa_50000, paa_40000);
		Assert.assertNotEquals(eaa_50000, eaa_40000);
		//System.out.println("[Annual Amount for 50,000 [Basic : " + baa_50000 + "]"+ " [Premium : " + paa_50000 + "]" + " [Enterprize : " + eaa_50000 + "]]");
		
		CommonActions.waitForElement(Btn_60000);
		Btn_60000.click();
		String btn_60000 = Btn_60000.getText();
		String bad_60000 = BasicAnnualDeliveries.getText();
		Assert.assertEquals(btn_60000, bad_60000);
		String pad_60000 = PremiumAnnualDeliveries.getText();
		Assert.assertEquals(btn_60000, pad_60000);
		String ead_60000 = EnterpriseAnnualDeliveries.getText();
		Assert.assertEquals(btn_60000, ead_60000);
		System.out.println("[Estimmated Annual Delivery : " + btn_60000 + "]" + " [Basic : " + bad_60000 + "]"+ " [Premium : " + pad_60000 + "]" + " [Enterprize : " + ead_60000 + "]");
		String baa_60000 = BasicAmount.getText();
		String paa_60000 = PremiumAmount.getText();
		String eaa_60000 = EnterpriseAmount.getText();
		Assert.assertNotEquals(baa_60000, baa_50000);
		Assert.assertNotEquals(paa_60000, paa_50000);
		Assert.assertNotEquals(eaa_60000, eaa_50000);
		//System.out.println("[Annual Amount for 60,000 [Basic : " + baa_60000 + "]"+ " [Premium : " + paa_60000 + "]" + " [Enterprize : " + eaa_60000 + "]]");
		
		CommonActions.waitForElement(Btn_70000);
		Btn_70000.click();
		String btn_70000 = Btn_70000.getText();
		String bad_70000 = BasicAnnualDeliveries.getText();
		Assert.assertEquals(btn_70000, bad_70000);
		String pad_70000 = PremiumAnnualDeliveries.getText();
		Assert.assertEquals(btn_70000, pad_70000);
		String ead_70000 = EnterpriseAnnualDeliveries.getText();
		Assert.assertEquals(btn_70000, ead_70000);
		System.out.println("[Estimmated Annual Delivery : " + btn_70000 + "]" + " [Basic : " + bad_70000 + "]"+ " [Premium : " + pad_70000 + "]" + " [Enterprize : " + ead_70000 + "]");
		String baa_70000 = BasicAmount.getText();
		String paa_70000 = PremiumAmount.getText();
		String eaa_70000 = EnterpriseAmount.getText();
		Assert.assertNotEquals(baa_70000, baa_60000);
		Assert.assertNotEquals(paa_70000, paa_60000);
		Assert.assertNotEquals(eaa_70000, eaa_60000);
		//System.out.println("[Annual Amount for 70,000 [Basic : " + baa_70000 + "]"+ " [Premium : " + paa_70000 + "]" + " [Enterprize : " + eaa_70000 + "]]");
		
		CommonActions.waitForElement(Btn_80000);
		Btn_80000.click();
		String btn_80000 = Btn_80000.getText();
		String bad_80000 = BasicAnnualDeliveries.getText();
		Assert.assertEquals(btn_80000, bad_80000);
		String pad_80000 = PremiumAnnualDeliveries.getText();
		Assert.assertEquals(btn_80000, pad_80000);
		String ead_80000 = EnterpriseAnnualDeliveries.getText();
		Assert.assertEquals(btn_80000, ead_80000);
		System.out.println("[Estimmated Annual Delivery : " + btn_80000 + "]" + " [Basic : " + bad_80000 + "]"+ " [Premium : " + pad_80000 + "]" + " [Enterprize : " + ead_80000 + "]");
		String baa_80000 = BasicAmount.getText();
		String paa_80000 = PremiumAmount.getText();
		String eaa_80000 = EnterpriseAmount.getText();
		Assert.assertNotEquals(baa_80000, baa_70000);
		Assert.assertNotEquals(paa_80000, paa_70000);
		Assert.assertNotEquals(eaa_80000, eaa_70000);
		//System.out.println("[Annual Amount for 80,000 [Basic : " + baa_80000 + "]"+ " [Premium : " + paa_80000 + "]" + " [Enterprize : " + eaa_80000 + "]]");
		
		CommonActions.waitForElement(Btn_90000);
		Btn_90000.click();
		String btn_90000 = Btn_90000.getText();
		String bad_90000 = BasicAnnualDeliveries.getText();
		Assert.assertEquals(btn_90000, bad_90000);
		String pad_90000 = PremiumAnnualDeliveries.getText();
		Assert.assertEquals(btn_90000, pad_90000);
		String ead_90000 = EnterpriseAnnualDeliveries.getText();
		Assert.assertEquals(btn_90000, ead_90000);
		System.out.println("[Estimmated Annual Delivery : " + btn_90000 + "]" + " [Basic : " + bad_90000 + "]"+ " [Premium : " + pad_90000 + "]" + " [Enterprize : " + ead_90000 + "]");
		String baa_90000 = BasicAmount.getText();
		String paa_90000 = PremiumAmount.getText();
		String eaa_90000 = EnterpriseAmount.getText();
		Assert.assertNotEquals(baa_90000, baa_80000);
		Assert.assertNotEquals(paa_90000, paa_80000);
		Assert.assertNotEquals(eaa_90000, eaa_80000);
		//System.out.println("[Annual Amount for 90,000 [Basic : " + baa_90000 + "]"+ " [Premium : " + paa_90000 + "]" + " [Enterprize : " + eaa_90000 + "]]");
		
		CommonActions.waitForElement(Btn_100000);
		Btn_100000.click();
		String btn_100000 = Btn_100000.getText();
		String bad_100000 = BasicAnnualDeliveries.getText();
		Assert.assertEquals(btn_100000, bad_100000);
		String pad_100000 = PremiumAnnualDeliveries.getText();
		Assert.assertEquals(btn_100000, pad_100000);
		String ead_100000 = EnterpriseAnnualDeliveries.getText();
		Assert.assertEquals(btn_100000, ead_100000);
		System.out.println("[Estimmated Annual Delivery : " + btn_100000 + "]" + " [Basic : " + bad_100000 + "]"+ " [Premium : " + pad_100000 + "]" + " [Enterprize : " + ead_100000 + "]");
		String baa_100000 = BasicAmount.getText();
		String paa_100000 = PremiumAmount.getText();
		String eaa_100000 = EnterpriseAmount.getText();
		Assert.assertNotEquals(baa_100000, baa_90000);
		Assert.assertNotEquals(paa_100000, paa_90000);
		Assert.assertNotEquals(eaa_100000, eaa_90000);
		//System.out.println("[Annual Amount for 100,000 [Basic : " + baa_100000 + "]"+ " [Premium : " + paa_100000 + "]" + " [Enterprize : " + eaa_100000 + "]]");
		
		
		System.out.println("[Annual Amount for 10,000 [Basic : " + baa_10000 + "]"+ " [Premium : " + paa_10000 + "]" + " [Enterprize : " + eaa_10000 + "]]");
		System.out.println("[Annual Amount for 20,000 [Basic : " + baa_20000 + "]"+ " [Premium : " + paa_20000 + "]" + " [Enterprize : " + eaa_20000 + "]]");
		System.out.println("[Annual Amount for 30,000 [Basic : " + baa_30000 + "]"+ " [Premium : " + paa_30000 + "]" + " [Enterprize : " + eaa_30000 + "]]");
		System.out.println("[Annual Amount for 40,000 [Basic : " + baa_40000 + "]"+ " [Premium : " + paa_40000 + "]" + " [Enterprize : " + eaa_40000 + "]]");
		System.out.println("[Annual Amount for 50,000 [Basic : " + baa_50000 + "]"+ " [Premium : " + paa_50000 + "]" + " [Enterprize : " + eaa_50000 + "]]");
		System.out.println("[Annual Amount for 60,000 [Basic : " + baa_60000 + "]"+ " [Premium : " + paa_60000 + "]" + " [Enterprize : " + eaa_60000 + "]]");
		System.out.println("[Annual Amount for 70,000 [Basic : " + baa_70000 + "]"+ " [Premium : " + paa_70000 + "]" + " [Enterprize : " + eaa_70000 + "]]");
		System.out.println("[Annual Amount for 80,000 [Basic : " + baa_80000 + "]"+ " [Premium : " + paa_80000 + "]" + " [Enterprize : " + eaa_80000 + "]]");
		System.out.println("[Annual Amount for 90,000 [Basic : " + baa_90000 + "]"+ " [Premium : " + paa_90000 + "]" + " [Enterprize : " + eaa_90000 + "]]");
		System.out.println("[Annual Amount for 100,000 [Basic : " + baa_100000 + "]"+ " [Premium : " + paa_100000 + "]" + " [Enterprize : " + eaa_100000 + "]]");
	}
	
	
	public void upgradePlan() {
		
		CommonActions.waitForElement(SettingsTab);
		SettingsTab.click();
		Waits.waitTime(2);
		SettingsTab.click();
		
		CommonActions.waitForElement(PlanAndBilling);
		PlanAndBilling.click();
		CommonActions.waitLogoInvisible();
		
		clickChangePlan();
		checkIfDowngrade();
		basicPlan();
		scansAddedInPlan();
		clickChangePlan();
		premiumPlan();
		scansAddedInPlan();
		
		//Waits.waitTime(1);
		SiteActions.notification_CP();
		assertEquals(RecipientsPageElements.SuccessMsgNotification.getText(), "Plan upgraded successfully.");
	    CommonActions.waitForElementToDisappear(RecipientsPageElements.NotificationMsg);
		
	}
	
	public void selectBasicPlanAddons() {
		
		Waits.waitTime(1);
		CommonActions.waitForElement(CoBrandedNotifications);
		CoBrandedNotifications.click();
		Waits.waitTime(1);
		
		CommonActions.waitForElement(CustomItemLabels);
		CustomItemLabels.click();
		Waits.waitTime(1);
		
		CommonActions.waitForElement(ReceiveConnect);
		ReceiveConnect.click();
		Waits.waitTime(1);
	}
	
	public void selectPremiumPlanAddons() {
		
		Waits.waitTime(1);
		CommonActions.waitForElement(InternalLabelPrinting);
		InternalLabelPrinting.click();
		
		Waits.waitTime(1);
		CommonActions.waitForElement(APIAndWebhooks);
		APIAndWebhooks.click();
		Waits.waitTime(1);
	}
	
	public void getListofItems() 
	{		
		String arr[] = {};  
		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(arr));  
		
		List<WebElement> rows = driver.findElements(By.xpath("//span[text()='Your Plan']/following::div[2]/div/div"));
		for (int i = 1; i <= rows.size(); i = i + 1) {
			
	        	System.out.println("count = " + i);
	        	
	        	WebElement name = driver.findElement(By.xpath("(//span[text()='Your Plan']/following::div[2]/div/div)[" + i + "]"));
	        	nameVal = name.getText();
		        System.out.println(nameVal);
		        arrayList.add(nameVal); 
		        
		        if(nameVal.contains("Co-Branded Notifications")) {
		        	arrayList.remove("Co-Branded Notifications");  
		        	arrayList.add("Logo Branding");		        	
		        }
		        
		        System.out.println(arrayList);
		        
		        ArrayList<String> nV = arrayList;
		        NV = nV;    		     
	    }	
		
		if(!nameVal.contains("Email Notifications")) {  
        	arrayList.add(3,"Email Notifications");        	
        }
		
		//System.out.println(NV);		
		
		if(arrayList.get(4).contains("Email Notifications")) {  
        	arrayList.remove("Email Notifications");        	
        }
		
		System.out.println(NV);
		
		//remove duplicates
		//Set<String> newNV = new LinkedHashSet<String>(NV);  
        //System.out.println(newNV);
       
	}
	
	public void scansAddedInPlan() {
				
		String arr[] = {};  
		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(arr));  
		
		List<WebElement> rows = driver.findElements(By.xpath("//h5[text()='Your Plan']/following::div[3]/div/div/span[@style='color: rgb(64, 68, 163); font-size: 1.25rem;']/following::span[1]"));
		for (int i = 1; i <= rows.size(); i = i + 1) {
			
	        	System.out.println("count = " + i);
	        	        	
	        	WebElement name = driver.findElement(By.xpath("(//h5[text()='Your Plan']/following::div[3]/div/div/span[@style='color: rgb(64, 68, 163); font-size: 1.25rem;']/following::span[1])[" + i + "]"));
	        	nameVal_1 = name.getText();
		        System.out.println(nameVal_1);
		        
		        arrayList.add(nameVal_1);  		        
		        System.out.println(arrayList);
		        
		        if(arrayList.contains("Custom Item Labels & Storage Locations (if add-on)")) {  
		        	arrayList.remove("Custom Item Labels & Storage Locations (if add-on)");
		        	arrayList.add("Custom Item Labels & Storage Locations");
		        }
		        
		        if(arrayList.contains("API & Webhooks (if add-on)")) {  
		        	arrayList.remove("API & Webhooks (if add-on)");
		        	arrayList.add("API & Webhooks");
		        }
		        
		        ArrayList<String> nV1 = arrayList;
		        NV1 = nV1;		        
	    }
		
		Assert.assertEquals(NV1, NV);
		
	}
	
	public void basicPlan() {
		
		CommonActions.waitForElement(BasicPlan);
		String basicplan = BasicPlan.getText();
		String baa_10000 = BasicAmount.getText();
		System.out.println(basicplan);
		
		CommonActions.waitForElement(UpgradeBtn_Basic);
		UpgradeBtn_Basic.click();
		
		Waits.waitTime(2);
		CommonActions.waitForElement(UpgradeTo_PlanName);
		String utpn = UpgradeTo_PlanName.getText();
		System.out.println(utpn);
		Assert.assertEquals(utpn, "Upgrade to " + basicplan);
		
		selectBasicPlanAddons();
		selectBasicPlanAddons();
		getListofItems();
		
		CommonActions.waitForElement(PricePerLocation);
		String ppl = PricePerLocation.getText();
		System.out.println(ppl);
		
		String newppl = ppl.replaceAll("\\s", "");
		String new_ppl = newppl.replace("USD", "");
		System.out.println(new_ppl);
		Assert.assertEquals(new_ppl, baa_10000);
		
		CommonActions.waitForElement(TotalPrice);
		String tp = TotalPrice.getText();
		System.out.println(tp);
		
		String newtp = tp.replaceAll("\\s", "");
		String new_tp = newtp.replace("USD", "");
		System.out.println(new_tp);
		String new_tp1 = newtp.replace("/", " ");
		System.out.println(new_tp1);
		
		CommonActions.waitForElement(UpgradeBtn_Popup);
		UpgradeBtn_Popup.click();
		
		CommonActions.waitForElement(Plan_NameOuter);
		String pno = Plan_NameOuter.getText();
		System.out.println(pno);
		String pno_propercase = pno.substring(0, 1).toUpperCase() + pno.substring(1).toLowerCase();
		System.out.println(pno_propercase);
		
		CommonActions.waitForElement(Plan_NameInner);
		String pni = Plan_NameInner.getText();
		System.out.println(pni);
		Assert.assertEquals(basicplan, pno_propercase, pni);
		
		String ptp = Plan_TotalPrice.getText();
		System.out.println(ptp);
		Assert.assertEquals(new_tp1, "USD"+ptp);
		
	}
	
	public void premiumPlan() {
		
		CommonActions.waitForElement(PremiumPlan);
		String premiumplan = PremiumPlan.getText();
		String premiumPlan = premiumplan.replace(" ", "");
		System.out.println(premiumPlan);
		String paa_10000 = PremiumAmount.getText();
		System.out.println(premiumPlan);
		
		CommonActions.waitForElement(UpgradeBtn_Premium);
		UpgradeBtn_Premium.click();
		
		Waits.waitTime(3);
		CommonActions.waitForElement(UpgradeTo_PlanName);
		String utpn = UpgradeTo_PlanName.getText();
		System.out.println(utpn);
		Assert.assertEquals(utpn+" ", "Upgrade to " + premiumplan);
		
		selectPremiumPlanAddons();
		getListofItems();
		
		CommonActions.waitForElement(PricePerLocation);
		String ppl = PricePerLocation.getText();
		System.out.println(ppl);
		
		String newppl = ppl.replaceAll("\\s", "");
		String new_ppl = newppl.replace("USD", "");
		System.out.println(new_ppl);
		Assert.assertEquals(new_ppl, paa_10000);
		
		CommonActions.waitForElement(TotalPrice);
		String tp = TotalPrice.getText();
		System.out.println(tp);
		
		String newtp = tp.replaceAll("\\s", "");
		String new_tp = newtp.replace("USD", "");
		System.out.println(new_tp);
		String new_tp1 = newtp.replace("/", " ");
		System.out.println(new_tp1);
		
		CommonActions.waitForElement(UpgradeBtn_Popup);
		UpgradeBtn_Popup.click();
		
		CommonActions.waitForElement(Plan_NameOuter);
		//Waits.waitTime(1);
		String pno = Plan_NameOuter.getText();
		System.out.println(pno);
		String pno_propercase = pno.substring(0, 1).toUpperCase() + pno.substring(1).toLowerCase();
		System.out.println(pno_propercase);
		
		CommonActions.waitForElement(Plan_NameInner);
		//Waits.waitTime(1);
		String pni = Plan_NameInner.getText();
		System.out.println(pni);
		Assert.assertEquals(premiumPlan, pno_propercase, pni);
		
		String ptp = Plan_TotalPrice.getText();
		System.out.println(ptp);
		Assert.assertEquals(new_tp1, "USD"+ptp);
	}
	
	public void checkIfDowngrade() {
		
		List<WebElement> downgradebtn = driver.findElements(By.xpath("//button[text()='Downgrade']"));
		if(!downgradebtn.isEmpty()) {
			if(DowngradeBtn.isDisplayed()) {

				DowngradeBtn.click();
				Waits.waitTime(5);
				DowngradeBtn_Popup.click();
				
				SiteActions.notification();
				assertEquals(RecipientsPageElements.SuccessMsgNotification.getText(), "Plan downgraded successfully.");
			    CommonActions.waitForElementToDisappear(RecipientsPageElements.NotificationMsg);
			}
			
			clickChangePlan();
		}
	}
	
	public void clickChangePlan() {
		
		CommonActions.waitForElement(ChangePlan);
		ChangePlan.click();
		CommonActions.waitLogoInvisible();
	}
	
	public void payWithCard() {
		
//		CommonActions.waitForElement(SettingsTab);
//		SettingsTab.click();
//		Waits.waitTime(2);
//		SettingsTab.click();
		
		AccountSettingsPage.clickSettingsTab();
		
//		CommonActions.waitForElement(PlanAndBilling);
//		PlanAndBilling.click();
//		CommonActions.waitLogoInvisible();
		
		clickPlanAndBilling();
		
		String ptp = Plan_TotalPrice.getText();
		
		String newptp = ptp.replaceAll(" Annually", "");
		System.out.println("Selected plan price: "+newptp);
		
		CommonActions.waitForClickablility(Subscribe, 15);
		Subscribe.click();
		
		String tpc = TotalPrice_Checkout.getText();
		String newtpc = tpc.replaceAll("Total USD ", "");
		System.out.println("Total price on checkout: "+newtpc);
		
		Assert.assertEquals(newptp, newtpc);
		
		CommonActions.waitForClickablility(ContractTerms, 15);
		ContractTerms.click();
		
		creditDebitCardDetails();
		
		CommonActions.waitForClickablility(AgreePrivacyPolicy_chkBox, 15);
		AgreePrivacyPolicy_chkBox.click();
		
		CommonActions.waitForClickablility(PayBtn, 15);
		String pb =PayBtn.getText();
		String newpb = pb.replaceAll("Pay USD ", "");
		System.out.println("Pay USD: "+newpb);
		
		Assert.assertEquals(newptp, newtpc, newpb);
		
		//PayBtn.click();
		
	}
	
	public void clickPlanAndBilling() {
		
		CommonActions.waitForElement(PlanAndBilling);
		PlanAndBilling.click();
		CommonActions.waitLogoInvisible();
	}
	
}
