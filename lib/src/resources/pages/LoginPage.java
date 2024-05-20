package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

	static WebElement element = null;

	public WebElement usernamField() {
		element = findElement(By.name("username"));
		return element;

	}

	public WebElement passwordField() {
		element = findElement(By.name("password"));
		return element;
	}

	public WebElement submitButton() {
		element = findElement(By.cssSelector(".btn"));
		return element;

	}

}