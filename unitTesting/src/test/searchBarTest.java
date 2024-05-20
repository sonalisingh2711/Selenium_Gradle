
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import component.frontend;
import utility.uiHandler;

public class searchBarTest extends frontend {

    @Test
    public void assertsearchIconIsClickable() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(searchbar.searchIcon()));

        System.out.println("--------------------------------------test done-----------------------------------");
    }

}
