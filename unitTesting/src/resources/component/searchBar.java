package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.uiHandler;

public class searchBar extends uiHandler {

    public WebElement searchIcon() {
        WebElement element = findElement(By.className("atmc-header_right"));
        return element;
    }

}
