package utility;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import pages.BasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import java.util.*;
import org.testng.annotations.Listeners;

@Listeners(utility.ListenerTest.class)

public class Helper {
    public static WebDriver driver;
    public static WebElement element = null;
    public static List<WebElement> listOfElements = null;
    public static Logger logger = LoggerFactory.getLogger(BasePage.class);
    public static Properties property = null;
    public DataReader data = new DataReader();

    // This method will run before each test suite
    @BeforeSuite(alwaysRun = true)
    public void configureLogging() {
        DataBaseConnection.databaseConnection();
        PropertyConfigurator.configure(
                System.getProperty("user.dir") + "\\src\\resources\\config\\Log.properties");
    }

    // This method will capture screenshot
    public void screenshot(String TestCaseName) {

        File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrfile,
                    new File(System.getProperty("user.dir") + "//src//resources//testOutput//Screenshot//"
                            + TestCaseName
                            + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // This method will run after each method
    @AfterMethod(alwaysRun = true)
    public void teardown(ITestResult Result) throws Exception {
        ReportGenerator.generateReport(Result);
    }
}
