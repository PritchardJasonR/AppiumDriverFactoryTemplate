package template.driverFactory.AbstractBoilerPlates;

import template.driverFactory.DesiredCaps;
import template.driverFactory.DriverFactory;
import template.utils.GlobalData;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.OrderWith;
import org.junit.runner.manipulation.Alphanumeric;

@OrderWith(Alphanumeric.class)
public abstract class AbstractAndroidReset extends GlobalData {

    @BeforeClass
    public static void setup() {
        GlobalData.driver = DriverFactory.getDriver(DesiredCaps.ANDROIDRESET).createAndroidDriver();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
