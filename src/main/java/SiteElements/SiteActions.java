package SiteElements;
//import BaseClasses.ApacheCommonsCSV;
//import BaseClasses.CreateRandomEmail;
import Login.LoginPage;
import SiteElements.RecipientsPageElements.RecipientsPageElements;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.CommonActions;
//import Utilities.GlobalVariables;
//import Utilities.Helper;
//import Utilities.Waits;
//import SiteElements.LoginPageElements.LoginElements;
import Utilities.Waits;

import static org.testng.Assert.assertEquals;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
//import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.Action;

import java.util.Properties;
import javax.activation.*;
import javax.mail.*;


public class SiteActions extends SiteElements {

	private static WebDriver driver;
	private WebDriverWait wait;
	private CommonActions commonActions;
	private LoginPage loginPage; 

	public SiteActions(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
		commonActions = new CommonActions(driver, wait);
		PageFactory.initElements(driver, this);
	}

	public void navigateURL(String url) throws InterruptedException{

		commonActions.navigateToUrl(url);
	}

	public static void uploadAndAttachFile() throws InterruptedException, AWTException, IOException {

		String fileAbsolutePath = "C:\\Users\\QA.User\\Desktop\\CSV_All_Files\\UploadCSV.csv";
		StringSelection clipBoardPath = new StringSelection(fileAbsolutePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(clipBoardPath, null);

		robotUploadActions();
	}

	public static void uploadAndAttachFileOverwrite() throws InterruptedException, AWTException, IOException {

		String fileAbsolutePath = "C:\\Users\\QA.User\\Desktop\\CSV_All_Files\\UploadCSV-OW.csv";
		StringSelection clipBoardPath = new StringSelection(fileAbsolutePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(clipBoardPath, null);

		robotUploadActions();
	}

	public static void uploadAndAttachFile10000Recipients() throws InterruptedException, AWTException, IOException {

		String fileAbsolutePath = "C:\\Users\\QA.User\\Desktop\\CSV_All_Files\\10000Recipients.csv";
		StringSelection clipBoardPath = new StringSelection(fileAbsolutePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(clipBoardPath, null);

		robotUploadActions();
	}
	
	public static void robotUploadActions() throws InterruptedException, AWTException {

		Thread.sleep(2000);		

		//Robot Class
		Robot robot = new Robot();

		//Keyboard Action : CTRL+V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		//Keyboard Action : Enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_ENTER);
	}

	public static void uploadAndAttachFile_address() throws InterruptedException, AWTException {

		String fileAbsolutePath = "C:\\Users\\QA.User\\Desktop\\CSV_All_Files\\CSV-LongAddress.csv";
		StringSelection clipBoardPath = new StringSelection(fileAbsolutePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(clipBoardPath, null);

		robotUploadActions();
	}

	public static void uploadAndAttachFile_InvalidEmail() throws InterruptedException, AWTException {

		String fileAbsolutePath = "C:\\Users\\QA.User\\Desktop\\CSV_All_Files\\UploadCSV-InvalidEmail.csv";
		StringSelection clipBoardPath = new StringSelection(fileAbsolutePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(clipBoardPath, null);

		robotUploadActions();
	}

	public static void uploadAndAttachFile_DuplicateEmail() throws InterruptedException, AWTException {

		//String fileAbsolutePath = "C:\\Users\\QA.User\\Desktop\\CSV_All_Files\\UploadCSV-DuplicateEmail.csv";
		String fileAbsolutePath = "https://github.com/MujahidPX/ReceiveAutomation/blob/master/CSV-Files/CSV_All_Files/UploadCSV-DuplicateEmail.csv";
		StringSelection clipBoardPath = new StringSelection(fileAbsolutePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(clipBoardPath, null);

		robotUploadActions();
	}

	public static void uploadAndAttachFile_EmailMissing() throws InterruptedException, AWTException {

		String fileAbsolutePath = "C:\\Users\\QA.User\\Desktop\\CSV_All_Files\\UploadCSV-EmailMissing.csv";
		StringSelection clipBoardPath = new StringSelection(fileAbsolutePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(clipBoardPath, null);

		robotUploadActions();
	}

	public static void uploadAndAttachFile_NameEmailMissing() throws InterruptedException, AWTException {

		String fileAbsolutePath = "C:\\Users\\QA.User\\Desktop\\CSV_All_Files\\UploadCSV-NameEmailMissing.csv";
		StringSelection clipBoardPath = new StringSelection(fileAbsolutePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(clipBoardPath, null);

		robotUploadActions();
	}

	public static void uploadAndAttachFile_RecipientCSV() throws InterruptedException, AWTException {

		String fileAbsolutePath = "C:\\Users\\QA.User\\Desktop\\CSV_All_Files\\UpdateRecepData.csv";
		StringSelection clipBoardPath = new StringSelection(fileAbsolutePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(clipBoardPath, null);

		robotUploadActions();
	}

	public static void uploadAndAttachFile_1() throws InterruptedException, AWTException {

		String fileAbsolutePath = "C:\\Users\\QA.User\\Desktop\\CSV_All_Files\\UpdateRecepData.csv";
		StringSelection clipBoardPath = new StringSelection(fileAbsolutePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(clipBoardPath, null);

		robotUploadActions();
	}

	public static void uploadLogo() throws InterruptedException, AWTException, IOException {

		String fileAbsolutePath = "C:\\Users\\QA.User\\Downloads\\profile_cc.png";
		Waits.waitTime(2);
		StringSelection clipBoardPath = new StringSelection(fileAbsolutePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(clipBoardPath, null);

		robotUploadActions();
		CommonActions.escKey();
	}
	
	public static void uploadFile_UnitGroup() throws InterruptedException, AWTException {

		String fileAbsolutePath = "C:\\Users\\QA.User\\Desktop\\CSV_All_Files\\Auto3CSV.csv";
		StringSelection clipBoardPath = new StringSelection(fileAbsolutePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(clipBoardPath, null);

		robotUploadActions();
	}
	
	public static void uploadFile_EmptyAlternateFields() throws InterruptedException, AWTException {

		String fileAbsolutePath = "C:\\Users\\QA.User\\Desktop\\CSV_All_Files\\EmptyAlternateFields.csv";
		StringSelection clipBoardPath = new StringSelection(fileAbsolutePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(clipBoardPath, null);

		robotUploadActions();
	}
	
	public static void uploadFile_AlternateFields() throws InterruptedException, AWTException {

		String fileAbsolutePath = "C:\\Users\\QA.User\\Desktop\\CSV_All_Files\\AlternateFields.csv";
		StringSelection clipBoardPath = new StringSelection(fileAbsolutePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(clipBoardPath, null);

		robotUploadActions();
	}
	
	public static void uploadFile_AlternateFieldsDuplicate() throws InterruptedException, AWTException {

		String fileAbsolutePath = "C:\\Users\\QA.User\\Desktop\\CSV_All_Files\\AlternateFieldsDuplicate.csv";
		StringSelection clipBoardPath = new StringSelection(fileAbsolutePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(clipBoardPath, null);

		robotUploadActions();
	}
	
	public static void uploadFile_AlternateEmailDuplicate() throws InterruptedException, AWTException {

		String fileAbsolutePath = "C:\\Users\\QA.User\\Desktop\\CSV_All_Files\\AlternateEmailDuplicate.csv";
		StringSelection clipBoardPath = new StringSelection(fileAbsolutePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(clipBoardPath, null);

		robotUploadActions();
	}
	
	
	public static void notification() {

		Waits.waitTime(3);
		//CommonActions.waitForElement(RecipientsPageElements.SuccessMsgNotification);
		CommonActions.focusElementJs(driver, RecipientsPageElements.SuccessMsgNotification);
		if(RecipientsPageElements.SuccessMsgNotification.isDisplayed()) {
			CommonActions.focusElementJs(driver, RecipientsPageElements.SuccessMsgNotification);			
		}
	}

	public static void notification_CP() {

		CommonActions.focusElementJs(driver, RecipientsPageElements.SuccessMsgNotification);
		if(RecipientsPageElements.SuccessMsgNotification.isDisplayed()) {
			CommonActions.focusElementJs(driver, RecipientsPageElements.SuccessMsgNotification);			
		}
	}
	
	public static void sendEmail() throws EmailException, InterruptedException {
			
		   final String username = "PackageXAutomation@outlook.com";
		   final String password = "Abcd1234!Abcd1234!";

		    Properties props = new Properties();
		    props.put("mail.smtp.auth", true);
		    props.put("mail.smtp.starttls.enable", true);
		    props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		    props.put("mail.smtp.host", "smtp.outlook.com");
		    props.put("mail.smtp.port", "587");

		    Session session = Session.getInstance(props,
		            new javax.mail.Authenticator() {
		                protected PasswordAuthentication getPasswordAuthentication() {
		                    return new PasswordAuthentication(username, password);
		                    
		                }
		            });

		    try {
		    	
		        Message message = new MimeMessage(session);
		        message.setFrom(new InternetAddress("PackageXAutomation@outlook.com"));
		        message.setRecipients(Message.RecipientType.TO,
		        InternetAddress.parse("muhammad.mujahid@packagex.io, automation@yopmail.com") );
		        message.setSubject("PackageX Receive, Automation Report");
		        message.setText("PFA");
		        MimeBodyPart messageBodyPart = new MimeBodyPart();
		        Multipart multipart = new MimeMultipart(); 
		        String file = "test-output/MailRoomAutomation.html";
		        String fileName = "MailRoomAutomation.html";
		        DataSource source = new FileDataSource(file);
		        messageBodyPart.setDataHandler(new DataHandler(source));
		        messageBodyPart.setFileName(fileName);
		        multipart.addBodyPart(messageBodyPart);
		        message.setContent(multipart);
		        System.out.println("Sending");
		        Transport.send(message);
		        System.out.println("Done");

		    } catch (MessagingException e) {
		        e.printStackTrace();
		    }
		 
	}
	
	public boolean isChecked(WebElement element) {
	    return (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].checked", element);
	}

	public void PageLoad(){
		
		commonActions.WaitForURLLoad();
	}

	public static void switchTo() {

		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
	}
	
	public void controlAll() {
		
		Actions builder = new Actions(driver);
		builder.sendKeys(Keys.CONTROL+"a");
		
		//builder.keyDown( Keys.CONTROL ).sendKeys( "a" ).keyUp( Keys.CONTROL ).build().perform();
		//builder.keyDown( Keys.CONTROL ).sendKeys( "c" ).keyUp( Keys.CONTROL ).build().perform();
	}
	
	
//	public void uploadFile() {
//
//		
//
//		Actions builder = new Actions(driver);
//		Action dragAndDrop = (Action) builder.clickAndHold(elementFrom)
//				.moveToElement(elementFrom)
//				.release(elementTo)
//				.build();
//		dragAndDrop.perform();
//	} 
	

}

