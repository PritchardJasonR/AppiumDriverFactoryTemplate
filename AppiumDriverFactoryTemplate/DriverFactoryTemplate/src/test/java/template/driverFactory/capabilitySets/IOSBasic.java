package template.driverFactory.capabilitySets;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.remote.DesiredCapabilities;
import template.utils.GlobalData;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import template.driverFactory.Driver;

import java.net.MalformedURLException;
import java.net.URL;

public class IOSBasic extends Driver {

    @Override
    public AndroidDriver<MobileElement> createAndroidDriver() {
        return null;
    }

    @Override
    public IOSDriver<MobileElement> createIOSDriver() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iOS");
        capabilities.setCapability("bundleId", IOSBUNDLEID);
        capabilities.setCapability("udid", "auto");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("xcodeOrgId", XCODEORGID);
        capabilities.setCapability("xcodeSigningId", "iPhone Developer");
        capabilities.setCapability("autoAcceptAlerts", true);
        try{
            return new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        }catch (SessionNotCreatedException e) {
            throw new RuntimeException(e);
        }catch (MalformedURLException p){
            throw new RuntimeException(p);
        }
    }
}