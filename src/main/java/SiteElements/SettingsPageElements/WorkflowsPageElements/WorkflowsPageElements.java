package SiteElements.SettingsPageElements.WorkflowsPageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorkflowsPageElements {

	
	WebDriver driver;
	
	@FindBy(xpath="//a[@aria-label='Settings']")
	protected WebElement SettingsTab;

	@FindBy(xpath="//header[text()='Workflows']")
    protected WebElement Workflows;
	
	@FindBy(xpath="//p[text()='Custom Workflows']")
    protected WebElement CustomWorkflows;
	
	@FindBy(xpath="//p[text()='Templates']")
    protected WebElement Templates;
	
	@FindBy(xpath="//span[text()='Create New Workflow']")
	protected WebElement CreateNewWorkflow;
	
	@FindBy(name="workflowTitle")
	protected WebElement WorkflowTitle;

	@FindBy(xpath="//textarea[@name='description']")
	protected WebElement WorkflowDescription;
	
	@FindBy(name="tags")
	protected WebElement WorflowTags;
	
	@FindBy(xpath="//button[text()='Add']")
	protected WebElement AddBtn;
	
	@FindBy(xpath="//*[@class='MuiSvgIcon-root MuiChip-deleteIcon']")
	protected WebElement DeleteTagBtn;
	
	//@FindBy(xpath="//p[text()='Activate?']/preceding::input[1]")
	//@FindBy(xpath="//p[text()='Activate?']/preceding::input[@type='checkbox']")
	@FindBy(xpath="//p[text()='Activate?']")
	protected WebElement ActivateChkBox;
	
	@FindBy(xpath="//button[text()='Update Workflow']")
	protected WebElement UpdateWorkflowBtn;
	
	@FindBy(xpath="//button[text()='Add workflow']")
	protected WebElement AddWorkflowBtn;
		
	@FindBy(xpath="//p[text()='Package Notified']")
	protected WebElement PackageNotified;
	
	@FindBy(xpath="//p[text()='PackageX Multi Hop']")
	protected WebElement PackageXMultiHop;
	
	@FindBy(xpath="//p[text()='Internal Routing']")
	protected WebElement InternalRouting;
	
	@FindBy(xpath="//p[text()='PackageX Remote Mail Management']")
	protected WebElement PackageXRemoteMailManagement;
	
	@FindBy(xpath="//p[text()='Package Delivered']")
	protected WebElement PackageDelivered;
	
	@FindBy(xpath="//p[text()='Self Service Pickup']")
	protected WebElement SelfServicePickup;
	
	@FindBy(xpath="//p[text()='Package Picked']")
	protected WebElement PackagePicked;
	
	@FindBy(xpath="//span[@aria-label='Delete']")
	protected WebElement DeleteBtn;
	
	@FindBy(xpath="//span[@aria-label='Add-ons']")
	protected WebElement AddOnsBtn;
	
	@FindBy(xpath="//span[text()='PackageX Vision Camera']/following::span[@aria-label='Add-ons'][1]")
	//@FindBy(xpath="//span[text()='PackageX Cam']/following::span[@aria-label='Add-ons'][1]")
	protected WebElement PackageXCamAddOnsBtn;
	
	@FindBy(xpath="//span[text()='Package Scanned']/following::span[@aria-label='Add-ons'][1]")
	protected WebElement PackageScannedAddOnsBtn;
	
	
	@FindBy(xpath="//span[text()='Package Notified']/following::span[@aria-label='Add-ons'][1]")
	protected WebElement PackageNotifiedAddOnsBtn;
	
	@FindBy(xpath="//span[text()='Package Notified']/following::span[@aria-label='Delete'][1]")
	protected WebElement PackageNotifiedDeleteBtn;
	
	
	@FindBy(xpath="//span[text()='PackageX Multi Hop']/following::span[@aria-label='Add-ons'][1]")
	protected WebElement PackageXMultiHopAddOnsBtn;
	
	@FindBy(xpath="//span[text()='PackageX Multi Hop']/following::span[@aria-label='Delete'][1]")
	protected WebElement PackageXMultiHopDeleteBtn;
	
	
	@FindBy(xpath="//span[text()='Internal Routing']/following::span[@aria-label='Add-ons'][1]")
	protected WebElement InternalRoutingAddOnsBtn;
	
	@FindBy(xpath="//span[text()='Internal Routing']/following::span[@aria-label='Delete'][1]")
	protected WebElement InternalRoutingDeleteBtn;
	
	
	@FindBy(xpath="//span[text()='PackageX Remote Mail Management']/following::span[@aria-label='Delete'][1]")
	protected WebElement PackageXRemoteMailManagementDeleteBtn;
	
	@FindBy(xpath="//span[text()='Package Delivered']/following::span[@aria-label='Delete'][1]")
	protected WebElement PackageDeliveredDeleteBtn;
	
	@FindBy(xpath="//span[text()='Self Service Pickup']/following::span[@aria-label='Delete'][1]")
	protected WebElement SelfServicePickupDeleteBtn;
	
	@FindBy(xpath="//span[text()='Package Picked']/following::span[@aria-label='Delete'][1]")
	protected WebElement PackagePickedDeleteBtn;
	
	
	@FindBy(xpath="//button[text()='Delete']")
	protected WebElement ConfirmDeleteBtn;
	
	
	@FindBy(xpath="//h6[text()='OCR']/following::button[@role='switch'][1]")
	protected WebElement OCRToggleBtn;
	
	@FindBy(xpath="//div[contains(@style,'rgb(50, 63, 86);')]/span[text()='OCR']")
	protected WebElement OCRLabel;
	
	
	@FindBy(xpath="//h6[text()='Bar Code']/following::button[@role='switch'][1]")
	protected WebElement BarCodeToggleBtn;
	
	@FindBy(xpath="//div[contains(@style,'rgb(50, 63, 86);')]/span[text()='Delete Scan']")
	protected WebElement BarCodeLabel;
	
	@FindBy(xpath="//div[contains(@style,'rgb(151, 160, 175);')]/span[text()='Bar Code']")
	protected WebElement BarCodeLabel_unSelect;
	
	@FindBy(xpath="//h6[text()='Direct Pickup']/following::button[@role='switch'][1]")
	protected WebElement DirectPickupToggleBtn;
	
	@FindBy(xpath="//div[contains(@style,'rgb(50, 63, 86);')]/span[text()='Direct Pickup']")
	protected WebElement DirectPickupLabel;
	
	@FindBy(xpath="//div[contains(@style,'rgb(151, 160, 175);')]/span[text()='Direct Pickup']")
	protected WebElement DirectPickupLabel_unSelect;
	
	@FindBy(xpath="//h6[text()='Delete Scan']/following::button[@role='switch'][1]")
	protected WebElement DeleteScanToggleBtn;
	
	@FindBy(xpath="//div[contains(@style,'rgb(50, 63, 86);')]/span[text()='Delete Scan']")
	protected WebElement DeleteScanLabel;
	
	@FindBy(xpath="//div[contains(@style,'rgb(151, 160, 175);')]/span[text()='Delete Scan']")
	protected WebElement DeleteScanLabel_unSelect;
	
	@FindBy(xpath="//h6[text()='Wireless Printing']/following::button[@role='switch'][1]")
	protected WebElement WirelessPrintingToggleBtn;
	
	@FindBy(xpath="//div[contains(@style,'rgb(50, 63, 86);')]/span[text()='Wireless Printing']")
	public WebElement WirelessPrintingLabel;
	
	@FindBy(xpath="//div[contains(@style,'rgb(151, 160, 175);')]/span[text()='Wireless Printing']")
	public WebElement WirelessPrintingLabel_unSelect;
	
	
	@FindBy(xpath="//h6[text()='Carrier Required']/following::button[@role='switch'][1]")
	protected WebElement CarrierRequiredToggleBtn;
	
	@FindBy(xpath="//div[contains(@style,'rgb(50, 63, 86);')]/span[text()='Carrier Required']")
	protected WebElement CarrierRequiredLabel;

	@FindBy(xpath="//div[contains(@style,'rgb(151, 160, 175);')]/span[text()='Carrier Required']")
	protected WebElement CarrierRequiredLabel_unSelect;
	
	
	@FindBy(xpath="//h6[text()='Tracking Number']/following::button[@role='switch'][1]")
	protected WebElement TrackingNumberToggleBtn;	
	
	@FindBy(xpath="//div[contains(@style,'rgb(50, 63, 86);')]/span[text()='Tracking Number']")
	protected WebElement TrackingNumberLabel;
	
	@FindBy(xpath="//div[contains(@style,'rgb(151, 160, 175);')]/span[text()='Tracking Number']")
	protected WebElement TrackingNumberLabel_unSelect;
	
	
	@FindBy(xpath="//h6[text()='Labels Required']/following::button[@role='switch'][1]")
	protected WebElement LabelsRequiredToggleBtn;
		
	@FindBy(xpath="//div[contains(@style,'rgb(50, 63, 86);')]/span[text()='Labels Required']")
	protected WebElement LabelsRequiredLabel;
	
	@FindBy(xpath="//div[contains(@style,'rgb(151, 160, 175);')]/span[text()='Labels Required']")
	protected WebElement LabelsRequiredLabel_unSelect;
	
	
	@FindBy(xpath="//h6[text()='Delayed Notifications']/following::button[@role='switch'][1]")
	protected WebElement DelayedNotificationsToggleBtn;
		
	@FindBy(xpath="//div[contains(@style,'rgb(50, 63, 86);')]/span[text()='Delayed Notifications']")
	protected WebElement DelayedNotificationsLabel;
	
	@FindBy(xpath="//div[contains(@style,'rgb(151, 160, 175);')]/span[text()='Delayed Notifications']")
	protected WebElement DelayedNotificationsLabel_unSelect;
	
	
	@FindBy(xpath="//h6[text()='Additional Images']/following::button[@role='switch'][1]")
	protected WebElement AdditionalImagesToggleBtn;
		
	@FindBy(xpath="//div[contains(@style,'rgb(50, 63, 86);')]/span[text()='Additional Images']")
	protected WebElement AdditionalImagesLabel;
	
	@FindBy(xpath="//div[contains(@style,'rgb(151, 160, 175);')]/span[text()='Additional Images']")
	protected WebElement AdditionalImagesLabel_unSelect;
	
	
	@FindBy(xpath="//h6[text()='Item Location']/following::button[@role='switch'][1]")
	protected WebElement ItemLocationToggleBtn;
		
	@FindBy(xpath="//div[contains(@style,'rgb(50, 63, 86);')]/span[text()='Item Location']")
	protected WebElement ItemLocationLabel;
	
	@FindBy(xpath="//div[contains(@style,'rgb(151, 160, 175);')]/span[text()='Item Location']")
	protected WebElement ItemLocationLabel_unSelect;
	
	
	@FindBy(xpath="//h6[text()='Package Notes']/following::button[@role='switch'][1]")
	protected WebElement PackageNotesToggleBtn;
		
	@FindBy(xpath="//div[contains(@style,'rgb(50, 63, 86);')]/span[text()='Package Notes']")
	protected WebElement PackageNotesLabel;
	
	@FindBy(xpath="//div[contains(@style,'rgb(151, 160, 175);')]/span[text()='Package Notes']")
	protected WebElement PackageNotesLabel_unSelect;
	
	
	@FindBy(xpath="//h6[text()='Remind']/following::button[@role='switch'][1]")
	protected WebElement RemindToggleBtn;
		
	@FindBy(xpath="//div[contains(@style,'rgb(50, 63, 86);')]/span[text()='Remind']")
	protected WebElement RemindLabel;
	
	
	@FindBy(xpath="//h6[text()='Reroute']/following::button[@role='switch'][1]")
	protected WebElement RerouteToggleBtn;
		
	@FindBy(xpath="//div[contains(@style,'rgb(50, 63, 86);')]/span[text()='Reroute']")
	protected WebElement RerouteLabel;
	
	@FindBy(xpath="//div[contains(@style,'rgb(151, 160, 175);')]/span[text()='Reroute']")
	protected WebElement RerouteLabel_unSelect;
	
	
	@FindBy(xpath="//h6[text()='Discard']/following::button[@role='switch'][1]")
	protected WebElement DiscardToggleBtn;
		
	@FindBy(xpath="//div[contains(@style,'rgb(50, 63, 86);')]/span[text()='Discard']")
	protected WebElement DiscardLabel;
	
	@FindBy(xpath="//div[contains(@style,'rgb(151, 160, 175);')]/span[text()='Discard']")
	protected WebElement DiscardLabel_unSelect;
	
	
	@FindBy(xpath="//h6[text()='Edit']/following::button[@role='switch'][1]")
	protected WebElement EditToggleBtn;
		
	@FindBy(xpath="//div[contains(@style,'rgb(50, 63, 86);')]/span[text()='Edit']")
	protected WebElement EditLabel;
	
	@FindBy(xpath="//div[contains(@style,'rgb(151, 160, 175);')]/span[text()='Edit']")
	protected WebElement EditLabel_unSelect;
	
	
	@FindBy(xpath="//h6[text()='Signature']/following::button[@role='switch'][1]")
	protected WebElement SignatureToggleBtn;
		
	@FindBy(xpath="//div[contains(@style,'rgb(50, 63, 86);')]/span[text()='Signature']")
	protected WebElement SignatureLabel;
	
	@FindBy(xpath="//div[contains(@style,'rgb(151, 160, 175);')]/span[text()='Signature']")
	protected WebElement SignatureLabel_unSelect;
	
	@FindBy(xpath="//h6[text()='Picture']/following::button[@role='switch'][1]")
	protected WebElement PictureToggleBtn;
		
	@FindBy(xpath="//div[contains(@style,'rgb(50, 63, 86);')]/span[text()='Picture']")
	protected WebElement PictureLabel;
	
	@FindBy(xpath="//div[contains(@style,'rgb(151, 160, 175);')]/span[text()='Picture']")
	protected WebElement PictureLabel_unSelect;
	
	
	@FindBy(xpath="//h6[text()='Disaggregate']/following::button[@role='switch'][1]")
	protected WebElement DisaggregateToggleBtn;
	
	@FindBy(xpath="//div[contains(@style,'rgb(50, 63, 86);')]/span[text()='Disaggregate']")
	protected WebElement DisaggregateLabel;
	
	// Customize
	
	@FindBy(xpath="(//div[@class='popOverTriggerIcon'])[last()]")
	protected WebElement CustomizeMenuBtn;
	
	@FindBy(xpath="//span[text()='Activate']")
	protected WebElement ActivateBtn;
	
	@FindBy(xpath="//span[text()='Customize']")
	protected WebElement CustomizeBtn;
	
	@FindBy(xpath="//span[text()='Preview']")
	protected WebElement PreviewBtn;
	
	@FindBy(xpath="//button[text()='Customize']")
	protected WebElement CustomizeBtn_Preview;
	
	@FindBy(xpath="//button[text()='Activate Workflow']")
	protected WebElement ActivateWorkflowBtn_Preview;
	
	@FindBy(xpath="(//button[text()='Activate Workflow'])[2]")
	protected WebElement ActivateWorkflowBtn;
	
	@FindBy(xpath="//span[@aria-label='Activated']")
	protected WebElement ActivatedIcon;
	
	@FindBy(xpath="(//h5[@class])[last()]")
	protected WebElement WorkflowText;
	
	@FindBy(xpath="//span[text()='New Workflow successfully created.']")
	protected WebElement WorkflowCreatedMsg;
	
//	@FindBy(xpath="//span[text()='"+LastWorkflow+"', 'successfully created.']")
//	protected WebElement WorkflowCreatedMsgLast;
	
	
	@FindBy(xpath="//span[text()='successfully updated.']")
	protected WebElement WorkflowUpdatedMsg;
	
	@FindBy(xpath="(//h5[text()])[last()]")
	protected WebElement LastWorkflowName_Text;
	
}
