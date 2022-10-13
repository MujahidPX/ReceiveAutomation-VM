package BaseClasses;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CreateRandomEmail{

    public static String generateTestEmail(){
        String Email;
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        String TestName="admin"+timeStamp+"@yopmail.com";
        Email = TestName;
        return Email;
    }
    
    public static String generateManagerEmail(){
        String Email;
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        String TestName="manager"+timeStamp+"@yopmail.com";
        Email = TestName;
        return Email;
    }
    
    public static String generateOperatorEmail(){
        String Email;
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        String TestName="operator"+timeStamp+"@yopmail.com";
        Email = TestName;
        return Email;
    }
    
    public static String generateTestEmail2() {
    	
    	//emailTextBx.click(); 
    	String Email;
    	Random randomGenerator = new Random();  
    	int randomInt = randomGenerator.nextInt(10000);  
    	//emailTextBx.sendKeys("username"+ randomInt +"@gmail.com");
    	String TestName="ABC"+randomInt+"@yopmail.com";
    	Email = TestName;
    	return Email;
    }
    
    public static String generateTestName() {
    	 
    	String Name;
    	Random randomGenerator = new Random();  
    	int randomInt = randomGenerator.nextInt(10000);  
    	String TestName="AutoUser "+randomInt;
    	Name = TestName;
    	return Name;
    }
    
    public static String generateRandomInt() {

    	String Number;
    	Random randomGenerator = new Random();  
    	int randomInt = randomGenerator.nextInt(10000);  
    	String TestName= ""+randomInt;
    	Number = TestName;
    	return Number;
    }
    
    public static String generateEmail(){
        String Email;
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        String TestName= timeStamp+"@yopmail.com";
        Email = TestName;
        return Email;
    }
 
 

}
