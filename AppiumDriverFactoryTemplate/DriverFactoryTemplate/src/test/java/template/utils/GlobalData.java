package template.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Random;

public class GlobalData {
    /**
     * Global Variables
     */
    public static String APPPACKAGE = "ENTER APP PACKAGE";
    public static String APPACTIVITY = "ENTER APP ACTIVITY";
    public static String IOSBUNDLEID="ENTER BUNDLE ID";
    public static String XCODEORGID= "ENTER ORG ID";
    public static AppiumDriver driver;
    static Random random = new Random();
    public static WebDriverWait wait;
    public static Integer generalTimeout = 20;

    /**
     * Custom Expected Conditions
     */
    public static void xWaitForText(By locator, String text) {
        new WebDriverWait(driver,60).until(ExpectedConditions.textToBePresentInElementLocated(locator,text));
    }

    public static void xElementInvisible(By locator){
        new WebDriverWait(driver,60).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void xElementWait(By locator){new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(locator));}

    public static void sElementWait(By locator){new WebDriverWait(driver,1).until(ExpectedConditions.presenceOfElementLocated(locator));}

    public static Long timeWait(By locator){
        new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(locator));
        long time = System.nanoTime();
        return time;
    }

    public static Boolean elementBool(By locator){
        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(locator));
            System.out.println("\n"+ locator +"\n Element Is Displayed" );
            return true;
        }catch (Exception e){
            System.out.println("\n"+ locator +"\n Element Not Displayed" );
            return false;
        }
    }
    public static Boolean sElementBool(By locator){
        try {
            new WebDriverWait(driver, 1).until(ExpectedConditions.presenceOfElementLocated(locator));
            System.out.println("\n"+ locator +"\n Element Is Displayed" );
            return true;
        }catch (Exception e){
            System.out.println("\n"+ locator +"\n Element Not Displayed" );
            return false;
        }
    }

    public static Boolean xElementBool(By locator){
        try {
            new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(locator));
            System.out.println("\n"+ locator +"\n Element Is Displayed" );
            return true;
        }catch (Exception e){
            System.out.println("\n"+ locator +"\n Element Not Displayed" );
            return false;
        }
    }

    public static Boolean elementTextBool(By locator, String text){
        try {
            new WebDriverWait(driver, 20).until(ExpectedConditions.textToBePresentInElementLocated(locator,text));
            System.out.println("\n"+ locator +"\n Element Is Displayed and has text" );
            return true;
        }catch (Exception e){
            System.out.println("\n"+ locator +"\n Element Not Displayed and does not have text" );
            return false;
        }
    }

    public static Boolean sElementTextBool(By locator, String text){
        try {
            new WebDriverWait(driver, 1).until(ExpectedConditions.textToBePresentInElementLocated(locator,text));
            System.out.println("\n"+ locator +"\n Element Is Displayed and has text" );
            return true;
        }catch (Exception e){
            System.out.println("\n"+ locator +"\n Element Not Displayed and does not have text" );
            return false;
        }
    }

    public static void elementClickable(By locator){
        new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void xElementClickable(By locator){
        new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(locator));

    }

    public static void sElementClickable(By locator){
        new WebDriverWait(driver,2).until(ExpectedConditions.elementToBeClickable(locator));

    }

    public static void elementSendKeys(By locator, String text){
        new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(locator)).clear();
        new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(text);
    }

    public static void elementClick(By locator){
        new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(locator)).click();
        System.out.println("\n"+ locator +"\n Element Is clicked" );
    }

    public static Long timeClick(By locator){
        new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(locator)).click();
        long time = System.nanoTime();
        System.out.println("\n"+ locator +"\n Element Is clicked timer started" );
        return time;
    }

    public static void sElementClick(By locator){
        new WebDriverWait(driver,2).until(ExpectedConditions.presenceOfElementLocated(locator)).click();
        System.out.println("\n"+ locator +"\n Element Is clicked" );
    }
    public static void xElementClick(By locator){
        new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(locator)).click();
        System.out.println("\n"+ locator +"\n Element Is clicked" );
    }

    public static void elementInvisibleText(By locator,String text){
        new WebDriverWait(driver,20).until(ExpectedConditions.invisibilityOfElementWithText(locator,text));
    }
    public static void xElementInvisibleText(By locator,String text){
        new WebDriverWait(driver,60).until(ExpectedConditions.invisibilityOfElementWithText(locator,text));
    }

    public static void elementInvisible(By locator){
        new WebDriverWait(driver,2).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static String elementGetText( By locator){
        String string = driver.findElement(locator).getText();
        return string;
    }

    public static void elementHasText(By locator, String text){
        new WebDriverWait(driver,20).until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }
    public static void sElementHasText(By locator, String text){
        new WebDriverWait(driver,1).until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }
    public static void xElementHasText(By locator, String text) {
        new WebDriverWait(driver,60).until(ExpectedConditions.textToBePresentInElementLocated(locator,text));
    }

    /**
     * Subclasses of Selectors Stored by Page
     */

    public static class Home{
        public static By title = By.xpath("");
    }
}
