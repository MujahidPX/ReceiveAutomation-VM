package Settings.Workflows;

import static org.testng.Assert.assertEquals;

import java.awt.Checkbox;
import java.time.Duration;

import javax.swing.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Settings.AccountSettings.AccountSettingsPage;
import SiteElements.SiteActions;
import SiteElements.RecipientsPageElements.RecipientsPageElements;
import SiteElements.SettingsPageElements.WorkflowsPageElements.WorkflowsPageElements;
import Users.UsersPage;
import Utilities.CommonActions;
import Utilities.ExcelFile;
import Utilities.Waits;

public class WorkflowsPage extends WorkflowsPageElements{

	
	private static WebDriver driver;
	private WebDriverWait wait;
	private CommonActions commonActions;
	public String LastWorkflow;
	
	public WorkflowsPage(WebDriver driver, WebDriverWait wait) {
		super();
		WorkflowsPage.driver = driver;
		this.wait = wait;
		commonActions = new CommonActions(driver, wait);
		PageFactory.initElements(driver, this);
	}
	
	public void createNewWorkflow() throws InterruptedException {
		
		AccountSettingsPage.clickSettingsTab();
		
		CommonActions.waitForElement(Workflows);
		Workflows.click();
		
		CommonActions.waitForElement(CustomWorkflows);
		CustomWorkflows.click();
		
		CommonActions.waitForElement(CreateNewWorkflow);
		CreateNewWorkflow.click();
		
		enterTitle();
		enterDescription();
		addTags();
		//activateChkBox();
		addNewConnector();
		selectAddOnsPackageXCam();
		selectAddOnsPackageScanned();
		selectAddOnsPackageNotified();
		selectAddOnsInternalRouting();
		//deleteWorkflowConnectors();
		addWorkflow();
		
		//customizeAWorkflow();
	}
	
	public void enterTitle() {

		CommonActions.waitForElement(WorkflowTitle);
		if(WorkflowTitle.isDisplayed()) {
			WorkflowTitle.click();
			WorkflowTitle.sendKeys("Workflow 2");
		}
	}
	
	public void enterDescription() {
		
		//CommonActions.waitForElement(WorflowDescription);
		//CommonActions.tabKey();
		CommonActions.waitForElement(WorkflowDescription);
		if(WorkflowDescription.isDisplayed()) {
			WorkflowDescription.click();
			WorkflowDescription.sendKeys("This flow enables you to scan an item and notify recipients. It works best for residential locations and coworking spaces");
		}
	}
	
	public void addTags() {
		
		CommonActions.waitForElement(WorflowTags);
		if(WorflowTags.isDisplayed()) {
			WorflowTags.click();
			WorflowTags.sendKeys("Co-WorkingSpace");
		}
		addBtn();
		
		CommonActions.waitForElement(WorflowTags);
		if(WorflowTags.isDisplayed()) {
			WorflowTags.click();
			WorflowTags.sendKeys("Residential Units");
		}
		addBtn();
		
	}
	
	public void addBtn() {
		
		CommonActions.waitForElement(AddBtn);
		if(AddBtn.isEnabled()) {
			AddBtn.click();
		}
	}
	
	public void activateChkBox() {
		
		CommonActions.waitForElement(ActivateChkBox);
		
		//CommonActions.isChecked(ActivateChkBox);
			ActivateChkBox.click();
		
		
//		if(!ActivateChkBox.isSelected()) {
//			ActivateChkBox.click();
//		}
	}
	
	public void addNewConnector() {
		
		CommonActions.waitForElement(PackageNotified);
		if(PackageNotified.isDisplayed()) {
			PackageNotified.click();
		}
		
		CommonActions.waitForElement(PackageXMultiHop);
		if(PackageXMultiHop.isDisplayed()) {
			PackageXMultiHop.click();
		}
		
		CommonActions.waitForElement(InternalRouting);
		if(InternalRouting.isDisplayed()) {
			InternalRouting.click();
		}
		
		CommonActions.waitForElement(PackageXRemoteMailManagement);
		if(PackageXRemoteMailManagement.isDisplayed()) {
			PackageXRemoteMailManagement.click();
		}
		
		CommonActions.waitForElement(PackageDelivered);
		if(PackageDelivered.isDisplayed()) {
			PackageDelivered.click();
		}
		
		CommonActions.waitForElement(SelfServicePickup);
		if(SelfServicePickup.isDisplayed()) {
			SelfServicePickup.click();
		}
		
		CommonActions.waitForElement(PackagePicked);
		if(PackagePicked.isDisplayed()) {
			PackagePicked.click();
		}

	}
	
	public void delete() {
		
		CommonActions.waitForElement(DeleteBtn);
		if(DeleteBtn.isDisplayed()) {
			DeleteBtn.click();
		}

	}
	
	public void addsOns() {
		
		CommonActions.waitForElement(AddOnsBtn);
		if(AddOnsBtn.isDisplayed()) {
			AddOnsBtn.click();
		}

	}
	
	public void addWorkflow() {
		
		CommonActions.waitForElement(AddWorkflowBtn);
		if(AddWorkflowBtn.isDisplayed()) {
			AddWorkflowBtn.click();
		}
		
		SiteActions.notification();
		assertEquals(RecipientsPageElements.SuccessMsgNotification.getText(), "New workflow created successfully.");
	    CommonActions.waitForElementToDisappear(WorkflowCreatedMsg);

	}
	
	public void updateWorkflow() {

		CommonActions.waitForElement(UpdateWorkflowBtn);
		if(UpdateWorkflowBtn.isDisplayed()) {
			UpdateWorkflowBtn.click();
		}
		
		String workflowName = WorkflowText.getText();

		System.out.println(workflowName);
		//Waits.waitTime(1);
		//SiteActions.notification();
		//assertEquals(RecipientsPageElements.SuccessMsgNotification.getText(), workflowName +" Workflow successfully updated.");
		//if(driver.findElement(By.xpath("//span[text()='"+workflowName+" successfully updated.']")).isDisplayed()) {
			CommonActions.focusElementJs(driver, driver.findElement(By.xpath("//span[text()='"+workflowName+" successfully updated.']")));			
		//}
		assertEquals(driver.findElement(By.xpath("//span[text()='"+workflowName+" successfully updated.']")).getText(), workflowName +" successfully updated.");
		
		//CommonActions.waitForElementToDisappear(WorkflowUpdatedMsg);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElement(By.xpath("//span[text()='"+workflowName+" successfully updated.']"))));

	}
	
	public void selectAddOnsPackageXCam() throws InterruptedException {
		
		addOnsPackageXCam();
		
		Assert.assertEquals(true, BarCodeLabel.isDisplayed());
	}
	
	public void unSelectAddOnsPackageXCam() throws InterruptedException {
		
		addOnsPackageXCam();
		
		Assert.assertEquals(true, BarCodeLabel_unSelect.isDisplayed());
	}
	
	public void addOnsPackageXCam() throws InterruptedException {
		
		CommonActions.waitForElement(PackageXCamAddOnsBtn);
		PackageXCamAddOnsBtn.click();
		
		CommonActions.waitForElement(BarCodeToggleBtn);
		if(BarCodeToggleBtn.isDisplayed()) {
			BarCodeToggleBtn.click();
		}
		
		UsersPage.clickSave();
	}
	
	public void selectAddOnsPackageScanned() throws InterruptedException {
		
		addOnsPackageScanned(); 
		
		Assert.assertEquals(true, WirelessPrintingLabel.isDisplayed());
		Assert.assertEquals(true, CarrierRequiredLabel.isDisplayed());
		Assert.assertEquals(true, TrackingNumberLabel.isDisplayed());
		Assert.assertEquals(true, LabelsRequiredLabel.isDisplayed());
		//Assert.assertEquals(true, DelayedNotificationsLabel.isDisplayed());
		Assert.assertEquals(true, AdditionalImagesLabel.isDisplayed());
		Assert.assertEquals(true, ItemLocationLabel.isDisplayed());
		Assert.assertEquals(true, PackageNotesLabel.isDisplayed());
	}
	
	public void unSelectAddOnsPackageScanned() throws InterruptedException {
		
		addOnsPackageScanned(); 
		
		Assert.assertEquals(true, WirelessPrintingLabel_unSelect.isDisplayed());
		Assert.assertEquals(true, CarrierRequiredLabel_unSelect.isDisplayed());
		Assert.assertEquals(true, TrackingNumberLabel_unSelect.isDisplayed());
		Assert.assertEquals(true, LabelsRequiredLabel_unSelect.isDisplayed());
		//Assert.assertEquals(true, DelayedNotificationsLabel_unSelect.isDisplayed());
		Assert.assertEquals(true, AdditionalImagesLabel_unSelect.isDisplayed());
		Assert.assertEquals(true, ItemLocationLabel_unSelect.isDisplayed());
		Assert.assertEquals(true, PackageNotesLabel_unSelect.isDisplayed());
	}
	
	public void addOnsPackageScanned() throws InterruptedException {
		
		CommonActions.waitForElement(PackageScannedAddOnsBtn);
		PackageScannedAddOnsBtn.click();
		
		CommonActions.waitForElement(WirelessPrintingToggleBtn);
		if(WirelessPrintingToggleBtn.isDisplayed()) {
			WirelessPrintingToggleBtn.click();
		}
		
		CommonActions.waitForElement(CarrierRequiredToggleBtn);
		if(CarrierRequiredToggleBtn.isDisplayed()) {
			CarrierRequiredToggleBtn.click();
		}
		
		CommonActions.waitForElement(TrackingNumberToggleBtn);
		if(TrackingNumberToggleBtn.isDisplayed()) {
			TrackingNumberToggleBtn.click();
		}
		
		CommonActions.waitForElement(LabelsRequiredToggleBtn);
		if(LabelsRequiredToggleBtn.isDisplayed()) {
			LabelsRequiredToggleBtn.click();
		}
		
		Waits.waitTime(2);
		//CommonActions.waitForElement(DelayedNotificationsToggleBtn);
		//if(DelayedNotificationsToggleBtn.isDisplayed()) {
		//	DelayedNotificationsToggleBtn.click();
		//}
		
		CommonActions.waitForElement(AdditionalImagesToggleBtn);
		if(AdditionalImagesToggleBtn.isDisplayed()) {
			AdditionalImagesToggleBtn.click();
		}
		
		CommonActions.waitForElement(ItemLocationToggleBtn);
		if(ItemLocationToggleBtn.isDisplayed()) {
			ItemLocationToggleBtn.click();
		}
		
		CommonActions.waitForElement(PackageNotesToggleBtn);
		if(PackageNotesToggleBtn.isDisplayed()) {
			PackageNotesToggleBtn.click();
		}
		
		UsersPage.clickSave();
	}
	
	public void selectAddOnsPackageNotified() throws InterruptedException {
		
		addOnsPackageNotified();
		
		Assert.assertEquals(true, DiscardLabel.isDisplayed());
		Assert.assertEquals(true, EditLabel.isDisplayed());
		Assert.assertEquals(true, PictureLabel.isDisplayed());
	}
	
	public void unSelectAddOnsPackageNotified() throws InterruptedException {
		
		addOnsPackageNotified();
		
		Assert.assertEquals(true, DiscardLabel_unSelect.isDisplayed());
		Assert.assertEquals(true, EditLabel_unSelect.isDisplayed());
		Assert.assertEquals(true, PictureLabel_unSelect.isDisplayed());
	}
	
	public void addOnsPackageNotified() throws InterruptedException {
		
		CommonActions.waitForElement(PackageNotifiedAddOnsBtn);
		PackageNotifiedAddOnsBtn.click();
		
		CommonActions.waitForElement(DiscardToggleBtn);
		if(DiscardToggleBtn.isDisplayed()) {
			DiscardToggleBtn.click();
		}
		
		CommonActions.waitForElement(EditToggleBtn);
		if(EditToggleBtn.isDisplayed()) {
			EditToggleBtn.click();
		}
		
		CommonActions.waitForElement(PictureToggleBtn);
		if(PictureToggleBtn.isDisplayed()) {
			PictureToggleBtn.click();
		}
		
		UsersPage.clickSave();
	}
	
	public void selectAddOnsInternalRouting() throws InterruptedException {
		
		addOnsInternalRouting();
		
		Assert.assertEquals(true, SignatureLabel.isDisplayed());
	}
	
	public void unSelectAddOnsInternalRouting() throws InterruptedException {
		
		addOnsInternalRouting();
		
		Assert.assertEquals(true, SignatureLabel.isDisplayed());
	}
	
	public void addOnsInternalRouting() throws InterruptedException {
		
		CommonActions.waitForElement(InternalRoutingAddOnsBtn);
		InternalRoutingAddOnsBtn.click();
		
		CommonActions.waitForElement(SignatureToggleBtn);
		if(SignatureToggleBtn.isDisplayed()) {
			SignatureToggleBtn.click();
		}
		
		UsersPage.clickSave();
	}
	
	public void deleteWorkflowConnectors() {
		
		//CommonActions.waitForElement(PackagePickedDeleteBtn);
		if(PackagePickedDeleteBtn.isDisplayed()) {
			PackagePickedDeleteBtn.click();
		
			confirmDelete();
		}
		
		//CommonActions.waitForElement(SelfServicePickupDeleteBtn);
		if(SelfServicePickupDeleteBtn.isDisplayed()) {
			SelfServicePickupDeleteBtn.click();
			
			confirmDelete();
		}
		
		
		//CommonActions.waitForElement(PackageDeliveredDeleteBtn);
		if(PackageDeliveredDeleteBtn.isDisplayed()) {
			PackageDeliveredDeleteBtn.click();
			
			confirmDelete();
		}
		
		
		//CommonActions.waitForElement(PackageXRemoteMailManagementDeleteBtn);
		if(PackageXRemoteMailManagementDeleteBtn.isDisplayed()) {
			PackageXRemoteMailManagementDeleteBtn.click();
			
			confirmDelete();
		}
		
		
		/*
		CommonActions.waitForElement(InternalRoutingDeleteBtn);
		if(InternalRoutingDeleteBtn.isDisplayed()) {
			InternalRoutingDeleteBtn.click();
		}
		confirmDelete();
		
		CommonActions.waitForElement(PackageXMultiHopDeleteBtn);
		if(PackageXMultiHopDeleteBtn.isDisplayed()) {
			PackageXMultiHopDeleteBtn.click();
		}
		confirmDelete();
		
		CommonActions.waitForElement(PackageNotifiedDeleteBtn);
		if(PackageNotifiedDeleteBtn.isDisplayed()) {
			PackageNotifiedDeleteBtn.click();
		}
		confirmDelete();
		*/
		
		CommonActions.waitForElement(PackagePicked);
		if(PackagePicked.isDisplayed()) {
			PackagePicked.click();
		}
		
	}
	
	public void confirmDelete() {
		
		CommonActions.waitForElement(ConfirmDeleteBtn);
		if(ConfirmDeleteBtn.isDisplayed()) {
			ConfirmDeleteBtn.click();
		}
	}
	
	public void customizeAWorkflow() throws InterruptedException {
		
		CommonActions.waitForElement(SettingsTab);
		SettingsTab.click();
		
		CommonActions.waitForElement(Workflows);
		Workflows.click();
		
		CommonActions.waitForElement(CustomWorkflows);
		CustomWorkflows.click();
		
		CommonActions.waitForElement(WorkflowText);
		String workflowName = WorkflowText.getText();
		System.out.println(workflowName);
		
		CommonActions.waitForElement(CustomizeMenuBtn);
		CustomizeMenuBtn.click();
		
		CommonActions.waitForElement(CustomizeBtn);
		CustomizeBtn.click();
		
		CommonActions.waitForElement(WorkflowTitle);
		if(WorkflowTitle.isDisplayed()) {
			WorkflowTitle.click();
			WorkflowTitle.sendKeys(" 1");
			WorkflowTitle.sendKeys(Keys.BACK_SPACE , Keys.BACK_SPACE);
		}
		
		CommonActions.waitForElement(WorkflowDescription);
		if(WorkflowDescription.isDisplayed()) {
			WorkflowDescription.click();
			WorkflowDescription.sendKeys(".");
		}
		
		unSelectAddOnsPackageXCam();
		unSelectAddOnsPackageScanned();
		unSelectAddOnsPackageNotified();
		unSelectAddOnsInternalRouting();
		
		deleteWorkflowConnectors();
		//updateWorkflow();
		
		CommonActions.waitForElement(UpdateWorkflowBtn);
		if(UpdateWorkflowBtn.isDisplayed()) {
			UpdateWorkflowBtn.click();
		}
		
		//String workflowName = WorkflowText.getText();
		//System.out.println(workflowName);
		
		//Waits.waitTime(1);
		//SiteActions.notification();
		//assertEquals(RecipientsPageElements.SuccessMsgNotification.getText(), workflowName +" Workflow successfully updated.");
		//if(driver.findElement(By.xpath("//span[text()='"+workflowName+" successfully updated.']")).isDisplayed()) {
			CommonActions.focusElementJs(driver, driver.findElement(By.xpath("//span[text()='"+workflowName+" successfully updated.']")));			
		//}
		assertEquals(driver.findElement(By.xpath("//span[text()='"+workflowName+" successfully updated.']")).getText(), workflowName +" successfully updated.");
		
		//CommonActions.waitForElementToDisappear(WorkflowUpdatedMsg);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElement(By.xpath("//span[text()='"+workflowName+" successfully updated.']"))));
	}
	
	public void customizeTemplates() {
		
		CommonActions.waitForElement(SettingsTab);
		SettingsTab.click();
		
		CommonActions.waitForElement(Workflows);
		Workflows.click();
		
		CommonActions.waitForElement(Templates);
		Templates.click();
		
		CommonActions.waitForElement(WorkflowText);
		String workflowName = WorkflowText.getText();
		System.out.println(workflowName);
		
		CommonActions.waitForElement(CustomizeMenuBtn);
		CustomizeMenuBtn.click();
		
		CommonActions.waitForElement(CustomizeBtn);
		CustomizeBtn.click();
		
		CommonActions.waitForElement(WorkflowTitle);
		if(WorkflowTitle.isDisplayed()) {
			WorkflowTitle.click();
			WorkflowTitle.sendKeys(" 1");
			WorkflowTitle.sendKeys(Keys.BACK_SPACE , Keys.BACK_SPACE);
		}
		
		CommonActions.waitForElement(WorkflowDescription);
		if(WorkflowDescription.isDisplayed()) {
			WorkflowDescription.click();
			WorkflowDescription.sendKeys(".");
		}
		
		//deleteWorkflowConnectors();
		
		CommonActions.waitForElement(UpdateWorkflowBtn);
		if(UpdateWorkflowBtn.isDisplayed()) {
			UpdateWorkflowBtn.click();
		}
		
		SiteActions.notification();
		assertEquals(RecipientsPageElements.SuccessMsgNotification.getText(), "New workflow created successfully.");
	    CommonActions.waitForElementToDisappear(WorkflowCreatedMsg);
	
	}
	
	public void previewCustomized() {
		
		AccountSettingsPage.clickSettingsTab();

		CommonActions.waitForElement(Workflows);
		Workflows.click();

		CommonActions.waitForElement(CustomWorkflows);
		CustomWorkflows.click();
		
		CommonActions.waitForElement(LastWorkflowName_Text);
		String lwf = LastWorkflowName_Text.getText();
		System.out.println(lwf);
			
		LastWorkflow = lwf;
		//driver.findElement(By.xpath("//span[text()='"+lwf+" successfully updated.']"));	

		CommonActions.waitForElement(CustomizeMenuBtn);
		CustomizeMenuBtn.click();
		
		Waits.waitTime(2);
		CommonActions.waitForElement(PreviewBtn);
		PreviewBtn.click();
		Waits.waitTime(2);
		CommonActions.waitForElement(CustomizeBtn_Preview);
		CustomizeBtn_Preview.click();
		
		CommonActions.waitForElement(WorkflowTitle);
		if(WorkflowTitle.isDisplayed()) {
			WorkflowTitle.click();
			WorkflowTitle.sendKeys(" 1");
			WorkflowTitle.sendKeys(Keys.BACK_SPACE , Keys.BACK_SPACE);
		}
		
		CommonActions.waitForElement(WorkflowDescription);
		if(WorkflowDescription.isDisplayed()) {
			WorkflowDescription.click();
			WorkflowDescription.sendKeys(".");
		}
		
		//deleteWorkflowConnectors();
		
		CommonActions.waitForElement(UpdateWorkflowBtn);
		if(UpdateWorkflowBtn.isDisplayed()) {
			UpdateWorkflowBtn.click();
		}
		
//		SiteActions.notification();
//		assertEquals(RecipientsPageElements.SuccessMsgNotification.getText(), "New workflow created successfully.");
//	    CommonActions.waitForElementToDisappear(WorkflowCreatedMsg);
	    
	    CommonActions.focusElementJs(driver, driver.findElement(By.xpath("//span[text()='"+LastWorkflow+" successfully updated.']")));			
		assertEquals(driver.findElement(By.xpath("//span[text()='"+LastWorkflow+" successfully updated.']")).getText(), LastWorkflow +" successfully updated.");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElement(By.xpath("//span[text()='"+LastWorkflow+" successfully updated.']"))));
	}
	
	
}
