package Utilities;

import java.time.Duration;

import org.json.JSONArray;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Helper {

    public static void highlight(WebDriver driver, WebElement element) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border=\'3px solid rgb(64, 68, 163)\'", element);
       // JavascriptExecutor js = (JavascriptExecutor) driver;
        //use executeScript() method and pass the arguments
        //Here i pass values based on css style. Yellow background color with solid red color border.
       // js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        Thread.sleep(200L);
    }

    public static String getStringConsoleQuery(WebDriver driver, String cmd) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            return (String) js.executeScript(cmd);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void waitForPageLoad(final WebDriver driver) {
        try {
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
            //WebDriverWait wait = new WebDriverWait(driver, 30L);
            wait.until(apply -> ((JavascriptExecutor) driver).executeScript("return document.readyState", new Object[0]).equals("complete"));
        } catch (Exception var2) {
            Assert.fail("problem in the method waitForPageLoad");
        }
    }


    private static JSONArray getDataLayer(WebDriver driver) {
        JSONArray array = new JSONArray();
        String dataLayer = getStringConsoleQuery(driver, "return JSON.stringify(dataLayer);");
        if (dataLayer != null)
            array = new JSONArray(dataLayer);

        return array;
    }

}
