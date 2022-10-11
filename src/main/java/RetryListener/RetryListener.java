package RetryListener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.browser.Browser;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import Utilities.CommonActions;
import Utilities.Waits;
import io.github.bonigarcia.wdm.WebDriverManager;
import SiteElements.LoginPageElements.LoginElements;

public class RetryListener implements IAnnotationTransformer {
	
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
	//	IRetryAnalyzer retryAnalyzer = annotation.getRetryAnalyzer();
	//	if(retryAnalyzer==null){
		
		
			annotation.setRetryAnalyzer(Retry.class);
			//Browser.close();
			
			
			
			
	//	}
		
	}

}