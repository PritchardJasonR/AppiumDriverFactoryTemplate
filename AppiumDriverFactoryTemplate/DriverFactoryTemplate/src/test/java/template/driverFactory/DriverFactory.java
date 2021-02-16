package template.driverFactory;

import template.driverFactory.capabilitySets.AndroidNoReset;
import template.driverFactory.capabilitySets.AndroidReset;
import io.appium.java_client.AppiumDriver;
import template.driverFactory.capabilitySets.IOSBasic;

public class DriverFactory {

    public static Driver getDriver(DesiredCaps desCaps) {
        switch (desCaps) {

            case ANDROIDRESET: {
                return new AndroidReset();
            }
            case ANDROIDNORESET: {
                return new AndroidNoReset();
            }
            case IOSBASIC:{
                return new IOSBasic();
            }
            default: {
                return null;
            }
        }
    }
}
