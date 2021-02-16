package template.driverFactory.AbstractBoilerPlates;

import template.driverFactory.DesiredCaps;
import template.driverFactory.DriverFactory;
import template.utils.GlobalData;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.OrderWith;
import org.junit.runner.manipulation.Alphanumeric;

@OrderWith(Alphanumeric.class)
public class AbstractAndroidNoReset extends GlobalData {

    @BeforeClass
    public static void setup() {
        GlobalData.driver = DriverFactory.getDriver(DesiredCaps.ANDROIDNORESET).createAndroidDriver();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
