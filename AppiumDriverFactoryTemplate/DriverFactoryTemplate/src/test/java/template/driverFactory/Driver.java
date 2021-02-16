package template.driverFactory;

import template.utils.GlobalData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public abstract class Driver extends GlobalData {
    protected static AppiumDriver driver;

    public abstract AndroidDriver<MobileElement> createAndroidDriver();

    public abstract IOSDriver<MobileElement> createIOSDriver();
}
