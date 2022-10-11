package Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

    public static WebElement waitVisibilityOfElement(WebDriverWait wait, WebElement element) {
        try {
            element = wait.until(ExpectedConditions.visibilityOf(element));
            return element;
        } catch (Exception e) {
            System.out.println("The element is not visible. " + element.toString());
            e.printStackTrace();
            return null;
        }
    }

    public static boolean waitVisibilityOfTwoElements(WebDriverWait wait, WebElement element1, WebElement element2) {
        try {

            return wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOf(element1),
                    ExpectedConditions.visibilityOf(element2)
            ));
        } catch (Exception e) {
            System.out.println("The elements are not visible. " + element1.toString() + "     " + element2.toString());
            //e.printStackTrace();
            return false;
        }
    }

    public static WebElement waitPresenceOfElement(WebDriverWait wait, By locator) {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("The element is not presence using the locator: " + locator.toString());
            return null;
        }
    }
    
    

    public static WebElement waitForElementToBeClickable(WebDriverWait wait, WebElement element) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            return null;
        }
    }



    public static boolean waitForAttributeToNotBeEmpty(WebDriverWait wait, WebElement element, String attribute) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return wait.until((WebDriver driver) -> {
                String attributeValue;
                try {
                    attributeValue = element.getAttribute(attribute);
                    if(attributeValue.length() > 0)
                        return true;
                    else
                        return false;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public static boolean waitForElementTextToNotBeEmpty(WebDriverWait wait, WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return wait.until((WebDriver driver) -> {
                String textValue = "";
                try {
                    textValue = element.getText();
                    if(textValue.length() > 0)
                        return true;
                    else
                        return false;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static void waitTime(long timeInSeonds) {
    	
    	try {
    	    TimeUnit.SECONDS.sleep(timeInSeonds);
    	} catch (InterruptedException ie) {
    	    Thread.currentThread().interrupt();
    	}
    }

}
