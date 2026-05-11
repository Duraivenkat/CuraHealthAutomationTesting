import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage extends BasePage {

    WebDriver driver;

    public ConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By facility = By.id("facility");
    By hospital = By.id("hospital_readmission");
    By date = By.id("visit_date");
    By comment = By.id("comment");

    public String getFacility() {
        return driver.findElement(facility).getText();
    }

    public String getHospital() {
        return driver.findElement(hospital).getText();
    }

    public String getDate() {
        return driver.findElement(date).getText();
    }

    public String getComment() {
        return driver.findElement(comment).getText();
    }
}