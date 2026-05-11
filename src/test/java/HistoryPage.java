import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HistoryPage extends BasePage  {

    WebDriver driver;


    public HistoryPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By menu = By.id("menu-toggle");
    By history = By.linkText("History");
    By table = By.cssSelector(".table");

    public void openHistory() {

        waitForElement(menu);
        driver.findElement(menu).click();

        wait.until(ExpectedConditions.elementToBeClickable(history));

        driver.findElement(history).click();
    }

    public boolean isHistoryLoaded() {
        return driver.findElements(table).size() > 0;
    }
}