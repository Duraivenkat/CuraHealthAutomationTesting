import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HistoryPage {

    WebDriver driver;
    WebDriverWait wait;

    public HistoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By menu = By.id("menu-toggle");
    By history = By.linkText("History");
    By table = By.cssSelector(".table");

    public void openHistory() {
        wait.until(ExpectedConditions.elementToBeClickable(menu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(history)).click();
    }

    public boolean isHistoryLoaded() {
        return driver.findElements(table).size() > 0;
    }
}