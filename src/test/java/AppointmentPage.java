import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AppointmentPage {

    WebDriver driver;
    WebDriverWait wait;

    public AppointmentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By facility = By.id("combo_facility");
    By hospital = By.id("chk_hospotal_readmission");
    By date = By.id("txt_visit_date");
    By comment = By.id("txt_comment");
    By bookBtn = By.id("btn-book-appointment");

    By confFacility = By.id("facility");
    By confDate = By.id("visit_date");
    By confHospital = By.id("hospital_readmission");

    public void book(String fac, String dt, String comm, boolean hospitalCheck) {

        wait.until(ExpectedConditions.urlContains("appointment"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(facility));

        new Select(driver.findElement(facility)).selectByVisibleText(fac);

        if (hospitalCheck) {
            driver.findElement(hospital).click();
        }

        driver.findElement(date).sendKeys(dt);
        driver.findElement(comment).sendKeys(comm);

        driver.findElement(bookBtn).click();
    }

    public String getFacility() {
        return driver.findElement(confFacility).getText();
    }

    public String getDate() {
        return driver.findElement(confDate).getText();
    }

    public String getHospital() {
        return driver.findElement(confHospital).getText();
    }

    public String getCommentText() {
        return driver.getPageSource();
    }
}