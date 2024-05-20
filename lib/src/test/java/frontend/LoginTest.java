package frontend;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.Frontend;
import utility.Environment;

public class LoginTest extends BasePage {
	@Test(groups = { "SmokeTest" })
	public void loginTest() {
		logger.info("Visiting url:" + Environment.getValue("UI", "URL"));
		driver.get(Environment.getValue("UI", "URL"));
		Frontend.loginpage.usernamField().sendKeys(Environment.getValue("UI", "USERNAME"));
		Frontend.loginpage.passwordField().sendKeys(Environment.getValue("UI", "PASSWORD"));
		Frontend.loginpage.submitButton().click();
		Assert.assertEquals(driver.getCurrentUrl(), data.getValue("loginUrl"));
	}

}
