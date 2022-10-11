package BaseClasses.SendEmailReport;

import org.testng.IExecutionListener;

import Reporting.EReport;

public class SendReport implements IExecutionListener {
 
    @Override
    public void onExecutionStart() {
        System.out.println("Autoamtion is going to start");
         
    }
 
    @Override
    public void onExecutionFinish() {
        System.out.println("TestNG is finished");
        
        EReport.sendEmail();
    }
}

