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

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators

    By facility = By.id("combo_facility");

    By applyCheckbox = By.id("chk_hospotal_readmission");

    By visitDate = By.id("txt_visit_date");

    By commentBox = By.id("txt_comment");

    By bookButton = By.id("btn-book-appointment");

    // Confirmation Page

    By confirmFacility = By.id("facility");

    By confirmDate = By.id("visit_date");

    By hospitalReadmission =
            By.xpath("//p[@id='hospital_readmission']");

    // Actions

    public void selectFacility(String value) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(facility)
        );

        Select select = new Select(driver.findElement(facility));

        select.selectByVisibleText(value);
    }

    public void clickHospitalCheckbox() {

        wait.until(
                ExpectedConditions.elementToBeClickable(applyCheckbox)
        ).click();
    }

    public void enterDate(String date) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(visitDate)
        ).clear();

        driver.findElement(visitDate).sendKeys(date);
    }

    public void enterComment(String comment) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(commentBox)
        ).sendKeys(comment);
    }

    public void clickBookButton() {

        wait.until(
                ExpectedConditions.elementToBeClickable(bookButton)
        ).click();
    }

    // Booking Without Checkbox

    public void bookWithoutCheckbox(String a,
                                    String b,
                                    String c) {

        selectFacility(a);

        enterDate(b);

        enterComment(c);

        clickBookButton();
    }

    // Booking With Checkbox

    public void bookWithCheckbox(String a,
                                 String b,
                                 String c) {

        selectFacility(a);

        clickHospitalCheckbox();

        enterDate(b);

        enterComment(c);

        clickBookButton();
    }

    // Confirmation Methods

    public String getFacilityText() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(confirmFacility)
        ).getText();
    }

    public String getDateText() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(confirmDate)
        ).getText();
    }

    public String getHospitalReadmissionText() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(hospitalReadmission)
        ).getText();
    }
}