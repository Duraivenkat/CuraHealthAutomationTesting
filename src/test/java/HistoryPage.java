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

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators

    By menuToggle = By.id("menu-toggle");

    By historyButton = By.linkText("History");

    By historyPageText =
            By.xpath("//h2[contains(text(),'History')]");

    By facilityText =
            By.xpath("(//p[@id='facility'])[1]");

    By dateText =
            By.xpath("(//p[contains(@id,'visit_date')])[1]");

    // Actions

    public void openHistoryPage() {

        wait.until(
                ExpectedConditions.elementToBeClickable(menuToggle)
        ).click();

        wait.until(
                ExpectedConditions.elementToBeClickable(historyButton)
        ).click();
    }

    // Get History Page Text

    public String getHistoryPageText() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(historyPageText)
        ).getText();
    }

    // Get Facility

    public String getFacilityHistory() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(facilityText)
        ).getText();
    }

    // Get Date

    public String getDateHistory() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(dateText)
        ).getText();
    }
}