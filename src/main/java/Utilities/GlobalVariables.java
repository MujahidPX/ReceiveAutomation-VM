package Utilities;

//import org.openqa.selenium.WebElement;

import BaseClasses.CreateRandomEmail;

public class GlobalVariables extends ExcelFile {

      public static String env = "";
      public static String qa_Url = "https://qa.portal.packagex.xyz/login";
      public static String uat_Url = "https://uat.portal.packagex.xyz/login";
      public static String dev_Url = "https://dev.portal.packagex.xyz/login";
 
      //public static String host2 = "https:///www.google.com/"; menu-link-blank     
     // public static String Email = ExcelFile.readFile();
      
      public static String AdminEmail = "automation@yopmail.com";
      public static String AdminPassword = "Pakistan_123";
      
      public static String AutomationEmail = "testing-automation@yopmail.com";
      public static String AutomationPassword = "Abcd1234!";
      
      public static String AutomationEmail1 = "test-automation1@yopmail.com";
      public static String AutomationPassword1 = "Abcd1234!";
      
      public static String Automation_Email = "test111@yopmail.com";
      public static String Automation_Password = "Abcd1234!";

      public static String ManagerEmail = "manager123@yopmail.com";
      public static String ManagerPassword = "Pakistan_123";

      public static String OperatorEmail = "automationoperator@yopmail.com";
      public static String OperatorPassword = "Pakistan_123";

      public static String AutoEmail = "automation@yopmail.com";
      public static String AutoPassword = "Pakistan_123";
      
      public static String SuperAdminEmail = "cla1@yopmail.com";
      public static String SuperAdminPassword = "Abcd1234!";
      
      public static String RealAdminEmail = "realadmin@yopmail.com";
      public static String RealAdminPassword = "Abcd1234!";
      
      public static String BannerEmail = "banner1@yopmail.com";
      public static String BannerPassword = "Abcd1234!";
      
      public static String UATEmail = "chocchip@packagex.xyz";
      public static String UATPassword = "Abcd1234!";
      
      public static String UATEmail2 = "automationuat@yopmail.com";
      public static String UATPassword2 = "Abcd1234!";
      
      public static String UAT_Email1 = "uatautoamtion@yopmail.com";
      public static String UAT_Password1 ="Abcd1234!";
      
      public static String UAT_Email2 = "uatautomation@yopmail.com";
      public static String UAT_Password2 ="Abcd1234!";
      
      public static String DEVEmail = "admin11@packagex.xyz";
      public static String DEVPassword = "Abcd1234!";
      
      public static String Automation1Email = "automation1@yopmail.com";
      public static String Automation1Password = "Pakistan_123";
      
      public static String AddNewUserName = CreateRandomEmail.generateTestName();
      public static String AddNewUserEmail = CreateRandomEmail.generateTestEmail();
      public static String AddNewManagerEmail = CreateRandomEmail.generateManagerEmail();
      public static String AddNewOperatorEmail = CreateRandomEmail.generateOperatorEmail();
      
      public static String AddNewEmail = CreateRandomEmail.generateEmail();
      
      public static String MailroomCode =CreateRandomEmail.generateRandomInt();
      
      public static String AdminUserRole = "Admin";
      public static String ManagerUserRole = "Manager";
      public static String OperatorUserRole = "Operator";
      public static String OperatorUserRoleActivate = "OperatorActivate";
      
      public static String uploadPreferenceMerge = "Merge";
      public static String uploadPreferenceOverwrite = "Overwrite";
      
      public static String locationSearched ="Madrid";
      //public static String locationSearched ="Melbourne";

      public static String locationSearchedUAT ="Weimar";
      public static String locationSearchedUAT2 ="Inovative Build 1";
      public static String locationSearched10000Rec ="500";  
      
      public static String autoRecepientUser ="Recipient AutoUser";
      
      public static String locationSearchedRecepCSV ="RecipientCSV"; 
      
      public static String Location = "Weimar, Germany ";
      public static String LocationCode = CreateRandomEmail.generateRandomInt();
      public static String LocationNoState = "Baja, Hungary ";

      public static String fileuploadCorrectMerge = "CorrectMerge";
      public static String fileuploadCorrectOverwrite = "CorrectOverwrite";
      public static String fileuploadInvalidEmail = "InvalidEmail";
      public static String fileuploadDuplicateEmail = "DuplicateEmail";
      public static String fileuploadNameEmailMissing = "NameEmailMissing";
      public static String fileuploadEmailMissing = "EmailMissing";
      public static String fileuploadInvalidAddress = "InvalidAddress";
      public static String fileuploadRecepCSV = "RecepientCSV";
      public static String fileuploadUnitGroup = "MapUnitGroup";
      public static String fileupload10000Recipients = "10000Recipients";
      
      public static String CSVuploadFilePath = "RecepientCSV";
      
      public static String name = "Mansoor";

    
}
