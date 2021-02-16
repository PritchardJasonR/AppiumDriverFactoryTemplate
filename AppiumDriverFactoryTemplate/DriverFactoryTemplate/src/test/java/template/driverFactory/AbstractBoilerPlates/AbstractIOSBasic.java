package template.driverFactory.AbstractBoilerPlates;

import org.junit.BeforeClass;
import org.junit.runner.OrderWith;
import org.junit.runner.manipulation.Alphanumeric;
import template.driverFactory.DesiredCaps;
import template.driverFactory.DriverFactory;
import template.driverFactory.capabilitySets.IOSBasic;
import template.utils.GlobalData;

@OrderWith(Alphanumeric.class)
public abstract class AbstractIOSBasic extends GlobalData {

    @BeforeClass
    public static void setUp(){
        GlobalData.driver = DriverFactory.getDriver(DesiredCaps.IOSBASIC).createIOSDriver();
    }
}
