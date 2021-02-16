package template.methods;

import template.utils.GlobalData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;
import java.net.MalformedURLException;
import java.util.Set;

public class TestMethods extends GlobalData {
    /**
     * Relatively Click By Text via xpath
     * @param text
     */
    public static void clickText( String text) {
        WebDriverWait wait = (new WebDriverWait(GlobalData.driver, generalTimeout));
        String elementXpath = "//*[contains(@text, \"" + text + "\")]";
        WebElement element = wait.withMessage("The element is not clickable, but it should be.").until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));
        element.click();
    }

    /**
     * Relatively find By Text via xpath and return a bool
     * @param text
     * @return
     */
    public static Boolean findByText(String text) {
        String elementXpath = "//*[contains(@text, \"" + text + "\")]";

        if (!sElementBool(By.xpath(elementXpath))) {
            System.out.println("Element is not displayed");
            return false;
        } else {
            System.out.println("Element is displayed");
            return true;
        }
    }

    /**
     * Do a pull refresh to reload a page
     * @throws Exception
     */
    public static void pullRefresh( By selector) {
        while (!sElementBool(selector)) {
            if (sElementBool(selector))
                System.out.println("\n"+selector+"\n Element Populated");
            else
                swipeUp();
        }
    }

    /**
     * Scroll down in the middle of the screen
     */
    public static void swipeDown() {
        Dimension screen = GlobalData.driver.manage().window().getSize();
        try {
            Thread.sleep(200);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        new TouchAction<>(GlobalData.driver).press(PointOption.point(screen.getWidth() / 2, screen.getHeight() * 3 / 4))
                .waitAction().moveTo(PointOption.point(screen.getWidth() / 2, screen.getHeight() / 4)).release()
                .perform();
    }

    /**
     * scroll up in the middle of the screen also good for pull refreshes
     */
    public static void swipeUp() {
        Dimension size = driver.manage().window().getSize();
        TouchAction myTouchAction = new TouchAction(driver);
        int startX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endX = startX;
        int endY = size.getHeight() / 100 * 90;
        myTouchAction.longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, endY)).release().perform();
    }

    /**
     * For Hybrid apps good for easily identifing various contexts,  will print out different ones available.
     * Often will have to change the WEBVIEW string literal to something different depending on app
     */
    public static void switchToWebContext() {
        Set a = driver.getContextHandles();
        System.out.println(a);
        if (driver.getContext().equals("NATIVE_APP")){
            driver.context("WEBVIEW_chrome");
            System.out.println("Switched to WebView");
        } else if (driver.getContext().equals("WEBVIEW_chrome")){
            System.out.println("Was Already On WebView");
        }
    }

    /**
     * For Hybrid apps good for easily identifing various contexts,  will print out different ones available.
     * Often will have to change the WEBVIEW string literal to something different depending on app
     */
    public static void switchToNativeContext() {
        Set a = driver.getContextHandles();
        System.out.println(a);
        if (driver.getContext().equals("NATIVE_APP")){
            System.out.println("Was Already On Native");
        } else if (driver.getContext().equals("WEBVIEW_chrome")){
            driver.context("NATIVE_APP");
            System.out.println("Switched to Native");
        }
    }
}
