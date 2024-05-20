package pages;

import java.util.List;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import utility.ReportGenerator;
import org.testng.ITestResult;
import java.util.*;
import utility.Helper;

import org.testng.annotations.Listeners;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

@Listeners(utility.ListenerTest.class)

public class BasePage extends Helper {
	public static WebDriver driver;
	public static WebElement element = null;
	public static List<WebElement> listOfElements = null;
	public static Properties property = null;

	// This method will run before each method
	@BeforeMethod(alwaysRun = true)
	public void setupTest(ITestResult Result) throws Exception {
		logger.info("----------------BROWSER OPENED---------------------------");

		String browser = System.getProperty("browser", "chrome");
		if (browser.contains("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			//options.addArguments("--remote-allow-origins=*");
			if (browser.contains("remote")) {
				options.addArguments("--disable-gpu");
				options.addArguments("--disable-dev-shm-usage");
				driver = new RemoteWebDriver(new URL(data.getValue("remoteFirefoxPath")), options);
				return;
			}
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(options);

		} else if (browser.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			if (browser.contains("remote")) {
				options.addArguments("--disable-gpu");
				options.addArguments("--disable-dev-shm-usage");
				driver = new RemoteWebDriver(new URL(data.getValue("remoteChromePath")), options);
				return;
			}
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440, 900));
		}
	}

	// This method will run after each method
	@AfterMethod(alwaysRun = true)
	public void teardown(ITestResult Result) {
		ReportGenerator.generateReport(Result);
		driver.quit();
		logger.info("---------------BROWSER CLOSED-----------------------");
	}

	public WebElement findElement(By locator) {
		logger.info("Using  findElement to locate:" + locator);
		try {
			element = driver.findElement(locator);
			return element;
		} catch (Exception e) {
			logger.error("Failed to use findElement to locate: " + locator + " WITH ERROR: " + e);
			return element;
		}
	}

	public List<WebElement> findElements(By locator) {
		logger.info("Using  findElements to locate:" + locator);
		try {
			listOfElements = driver.findElements(locator);
			return listOfElements;
		} catch (Exception e) {
			logger.error("Failed to use findElement to locate: " + locator + " WITH ERROR: " + e);
			return listOfElements;
		}
	}

}