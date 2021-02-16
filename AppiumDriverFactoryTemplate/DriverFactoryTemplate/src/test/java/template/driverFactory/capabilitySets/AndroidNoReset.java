package template.driverFactory.capabilitySets;

import template.driverFactory.Driver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidNoReset extends Driver {

    @Override
    public AndroidDriver<MobileElement> createAndroidDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("device", "Android");
        capabilities.setCapability("noReset", false);
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", APPPACKAGE);
        capabilities.setCapability("appActivity", APPACTIVITY);
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("ignoreUnimportantViews", true);
        try {
            return new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        }catch (MalformedURLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public IOSDriver<MobileElement> createIOSDriver() {
        return null;
    }
}
