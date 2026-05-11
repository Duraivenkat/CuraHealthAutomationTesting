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
    // locators for booking

    By Facility = By.id("combo_facility");
    By applycheckbox = By.id("chk_hospotal_readmission");
    By visitDate = By.id("txt_visit_date");
    By commentBox = By.id("txt_comment");
    By bookButton = By.id("btn-book-appointment");
    // sucess page content
    By confirmFacility = By.id("facility");
    By checkDate = By.id("visit_date");

    // actions
    public void selectFacility(String a) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Facility));
        Select select = new Select(driver.findElement(Facility));
        select.selectByVisibleText(a);
    }
    public void clickHospitalCheckbox() {
        wait.until(ExpectedConditions.elementToBeClickable(applycheckbox)).click();
    }

    public void enterDate(String date) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(visitDate)).sendKeys(date);
    }

    public void enterComment(String d) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(commentBox)).sendKeys(d);
    }

    public void clickBookButton() {
        wait.until(ExpectedConditions.elementToBeClickable(bookButton)).click();
    }

    // combined code
    public void bookwithoutcheckbox(String a, String b, String c) {

        selectFacility(a);
        enterDate(b);
        enterComment(c);
        clickBookButton();
    }
    public void bookWithCheckbox(String a, String b, String c) {

        selectFacility(a);
        clickHospitalCheckbox();
        enterDate(b);
        enterComment(c);
        clickBookButton();
    }

    // sucess  page after register

    public String getFacilityText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmFacility)).getText();
    }
    public String getDateText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated( checkDate)).getText();
    }
}