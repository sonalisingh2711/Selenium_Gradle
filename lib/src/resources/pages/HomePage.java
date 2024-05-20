package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
	static WebElement element;

	public WebElement searchBox() {
		element = driver.findElement(By.cssSelector("input[placeholder='Search']"));
		return element;
	}

}
