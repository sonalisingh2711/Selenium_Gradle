package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeOptions;

public class uiHandler {

    public static WebDriver driver;
    public WebElement element;

    @BeforeTest
    public void setupDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1440, 900));
    }

    public WebElement findElement(By locator) {
        try {
            element = driver.findElement(locator);
            return element;
        } catch (Exception e) {
            return element;
        }
    }
}
