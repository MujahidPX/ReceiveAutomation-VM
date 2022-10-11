package RerunFailTests.AnnotationTransformer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import RerunFailTests.RerunAutomationScripts;
public class AnnotationTransformer implements IAnnotationTransformer {
	
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
    	
    	//IRetryAnalyzer retry = annotation.getRetryAnalyzer();
        annotation.setRetryAnalyzer(RerunAutomationScripts.class);
    }
}
