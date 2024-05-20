package frontend;

import pages.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BasePage {
    @Test(groups = { "RegressionTest" })
    public void randomTest() {
        Assert.assertEquals(2, 2);
    }
}
